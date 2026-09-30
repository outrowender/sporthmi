/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.error.IErrorManager;
import de.audi.atip.error.ShutdownGuard;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.fwhmi.HMIEventQueue;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IBlockedJobHandler;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import java.io.PrintStream;

final class HMIEventDispatcher
implements EventDispatcher,
EventDispatcherAdmin {
    private static final String MAX_EVENT_TIME = "MAX_EVENT_TIME";
    private static final long MAX_EVENT_TIME_DEFAULT = 20000L;
    private static final long MAX_EVENT_TIME_MIN = 20000L;
    private static final int MAX_SLEEP_TIME = 500;
    private static final int PROCESSING_BREAK_FACTOR = 10;
    private static final int MAX_PROCESSING_TIME_WITHOUT_BREAK = 50;
    private static final int SLOW_EVENT_TIME = 200;
    private static final boolean SHOW_EVENT_QUEUE_STATISTIC = Boolean.getBoolean("showEventQueueStatistic");
    private final IFrameworkAccess framework;
    private final Timer heartbeat;
    private final Timer statistics;
    private boolean adaptiveSleepingEnabled = false;
    private long lastBreak = Long.MAX_VALUE;
    private SleepInterceptor sleepInterceptor = null;
    private DispatcherBase dispatcher;
    private final LogChannel log;
    private final LogChannel logStatistic;

    private static long getMaxEventTime() {
        long l = Long.getLong(MAX_EVENT_TIME, 20000L);
        return l < 20000L ? 20000L : l;
    }

    private final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public HMIEventDispatcher(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Event.Queue");
        HMIEventQueue hMIEventQueue = new HMIEventQueue(iFrameworkAccess, this.log, true);
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("HMIEvent", new JobLogger(this.log), hMIEventQueue, new EventInterceptor(), new Job(new NullEvent()));
        HMIEventErrorHandler hMIEventErrorHandler = new HMIEventErrorHandler(iFrameworkAccess, this.log, hMIEventQueue);
        this.dispatcher.setBlockedHandler(HMIEventDispatcher.getMaxEventTime(), hMIEventErrorHandler);
        this.setKombiSyncFocus(2);
        TimerSyncer.setEventSink(this);
        this.heartbeat = new Timer("Heartbeat", 10, this.log, new TimerSyncer(new TimerListener(){

            public void cancelTimer(Timer timer) {
            }

            public void fireTimer(Timer timer) {
                HMIEventDispatcher.this.log.log(100000000, "Heartbeat!");
            }
        }), HMIEventDispatcher.getMaxEventTime() / 5L, false);
        if (SHOW_EVENT_QUEUE_STATISTIC) {
            this.logStatistic = this.framework.getLogChannel("Fw.Event.Statistic");
            this.statistics = new Timer("HMIEventStatistics", 10, this.log, new TimerListener(){

                public void cancelTimer(Timer timer) {
                }

                public void fireTimer(Timer timer) {
                    String[] stringArray = HMIEventDispatcher.this.getStatisticData();
                    HMIEventDispatcher.this.logStatistic.log(1000000, "%1 - %2 - %3", (Object)stringArray[0], (Object)stringArray[1], (Object)stringArray[2]);
                }
            }, 1000L, false);
            this.dispatcher.addInterceptor(new BaseInterceptor(){

                public void execute(Job job) {
                    super.execute(job);
                    int n = (int)job.getNeeded();
                    if (n > 200) {
                        HMIEventDispatcher.this.logStatistic.log(10000000, "Slow Event [%1] needed %2ms", (Object)job, (long)n);
                    }
                }
            });
        } else {
            this.logStatistic = null;
            this.statistics = null;
        }
        this.start();
    }

    public synchronized void start() {
        this.dispatcher.start();
        this.heartbeat.restart();
        if (this.statistics != null) {
            this.statistics.restart();
        }
    }

    public synchronized void stop() {
        if (this.statistics != null) {
            this.statistics.cancel();
        }
        this.heartbeat.cancel();
        this.dispatcher.stop();
    }

    public Job postEvent(ATIPEvent aTIPEvent) {
        return this.dispatcher.execute(aTIPEvent);
    }

    public Job postEvent(ATIPEvent aTIPEvent, long l) {
        return this.dispatcher.execute(aTIPEvent, l);
    }

    public ATIPEvent peekEvent() {
        Job job = this.dispatcher.getQueue().peek();
        return job != null ? (ATIPEvent)job.getPayload() : null;
    }

    private synchronized SleepInterceptor getSleepInterceptor() {
        if (this.sleepInterceptor == null) {
            this.sleepInterceptor = new SleepInterceptor();
        }
        return this.sleepInterceptor;
    }

    private void resetLastBreak() {
        this.lastBreak = this.getFramework().getMonotonicTime();
    }

    private long getBusyTime() {
        return this.getFramework().getMonotonicTime() - this.lastBreak;
    }

    private long getSleepPeriod() {
        long l = this.getBusyTime() / 10L;
        if (l > 500L) {
            l = 500L;
        }
        return l;
    }

    private boolean isSleepNeeded() {
        return this.adaptiveSleepingEnabled && this.getBusyTime() > 50L;
    }

    private void doAdaptiveSleeping() {
        if (this.adaptiveSleepingEnabled) {
            try {
                long l = this.getSleepPeriod();
                Thread.sleep(l);
                this.log.log(10000000, "EventQueue#doAdaptiveSleeping for: %2", (Object)null, (long)((int)l));
                this.resetLastBreak();
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
                this.resetLastBreak();
            }
        }
    }

    public void doCheckedSleeping() {
        if (!this.isDispatchThread()) {
            this.log.log(10000000, "EventQueue#doCheckedSleeping call for sleeping not from eventdispatcher, not sleeping", null);
            return;
        }
        if (this.isSleepNeeded()) {
            if (AbstractModel.statistics != null) {
                AbstractModel.statistics.addSleepTime(this.getSleepPeriod());
            }
            this.doAdaptiveSleeping();
        }
    }

    public boolean doCheckedSleepingInternal() {
        boolean bl = this.isSleepNeeded();
        if (bl) {
            this.doAdaptiveSleeping();
        }
        return bl;
    }

    public void setAdaptiveSleepingEnabled(boolean bl) {
        if (!Boolean.getBoolean("disableAdaptiveSleeping")) {
            if (!this.adaptiveSleepingEnabled && bl) {
                this.resetLastBreak();
                this.dispatcher.addInterceptor(this.getSleepInterceptor());
            } else if (this.adaptiveSleepingEnabled && !bl) {
                this.dispatcher.removeInterceptor(this.getSleepInterceptor());
            }
            this.adaptiveSleepingEnabled = bl;
        }
    }

    public final boolean isUserInteraction(Object object) {
        return ((HMIEventQueue)this.dispatcher.getQueue()).isUserInteraction(object);
    }

    public final void blockScreenChangeDisturbingEvents() {
        ((HMIEventQueue)this.dispatcher.getQueue()).blockScreenChangeDisturbingEvents();
    }

    public final void unBlockScreenChangeDisturbingEvents() {
        ((HMIEventQueue)this.dispatcher.getQueue()).unBlockScreenChangeDisturbingEvents();
    }

    public final void blockHardkeys() {
        ((HMIEventQueue)this.dispatcher.getQueue()).blockHardkeys();
    }

    public final void unBlockHardkeys() {
        ((HMIEventQueue)this.dispatcher.getQueue()).unBlockHardkeys();
    }

    public final void lockUsage() {
        ((HMIEventQueue)this.dispatcher.getQueue()).lockUsage();
    }

    public final void unlockUsage() {
        ((HMIEventQueue)this.dispatcher.getQueue()).unlockUsage();
    }

    public final void setKombiSyncFocus(int n) {
        ((HMIEventQueue)this.dispatcher.getQueue()).setKombiSyncFocus(n);
    }

    public final void addEventFilter(IJobFilter iJobFilter) {
        ((HMIEventQueue)this.dispatcher.getQueue()).addFilter(iJobFilter);
    }

    public final void removeEventFilter(IJobFilter iJobFilter) {
        ((HMIEventQueue)this.dispatcher.getQueue()).removeFilter(iJobFilter);
    }

    public void dumpEventQueue(PrintStream printStream) {
        this.dispatcher.getQueue().dump(printStream);
    }

    public void setPriority(int n) {
        this.dispatcher.setPriority(n);
    }

    public String[] getStatisticData() {
        return this.dispatcher.getStatisticData();
    }

    public void dump(PrintStream printStream) {
        this.dispatcher.dump(printStream);
    }

    public boolean isDispatchThread() {
        return this.dispatcher.isDispatchThread();
    }

    private static class NullEvent
    extends ATIPEvent {
        NullEvent() {
            super((ATIPEventListener)null, 0);
        }
    }

    private static class EventInterceptor
    extends BaseInterceptor
    implements IInterceptor {
        private EventInterceptor() {
        }

        public void execute(Job job) {
            ((ATIPEvent)job.getPayload()).dispatch();
        }
    }

    private class SleepInterceptor
    extends BaseInterceptor
    implements IInterceptor {
        private boolean queueWasEmpty = true;

        private SleepInterceptor() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void execute(Job job) {
            if (this.queueWasEmpty) {
                HMIEventDispatcher.this.resetLastBreak();
            }
            try {
                super.execute(job);
                HMIEventDispatcher.this.doCheckedSleepingInternal();
            }
            catch (Throwable throwable) {
                HMIEventDispatcher.this.doCheckedSleepingInternal();
                this.queueWasEmpty = HMIEventDispatcher.this.dispatcher.getQueue().length() == 0;
                throw throwable;
            }
            this.queueWasEmpty = HMIEventDispatcher.this.dispatcher.getQueue().length() == 0;
        }
    }

    private static class HMIEventErrorHandler
    implements IBlockedJobHandler {
        private final IFrameworkAccess framework;
        private final LogChannel log;
        private final JobQueue queue;
        private Job blocker;

        HMIEventErrorHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, JobQueue jobQueue) {
            this.framework = iFrameworkAccess;
            this.log = logChannel;
            this.queue = jobQueue;
            this.blocker = null;
        }

        private final IFrameworkAccess getFramework() {
            return this.framework;
        }

        private final IErrorManager getErrorManager() {
            return this.getFramework().getErrorMgr();
        }

        public void blocked(final Job job, long l) {
            this.blocker = job;
            this.getErrorManager().handleError(null, new StringBuffer().append("ERR: event dispatch thread hanging, event = ").append(job).append(", queue size = ").append(this.queue.length()).toString(), 0, 3, 2, new ShutdownGuard(){
                Object cause;
                {
                    this.cause = job;
                }

                public boolean queryShutdown() {
                    HMIEventErrorHandler.this.log.log(100000, "queryShutdown: cause: %1, blocker", this.cause, (Object)HMIEventErrorHandler.this.blocker);
                    return this.cause == HMIEventErrorHandler.this.blocker;
                }
            });
        }

        public void unblocked(Job job) {
            if (job == this.blocker) {
                this.blocker = null;
            }
        }

        public void lengthExceeded(int n, int n2) {
            this.log.log(10000, "ERR: event queue size = %1", (long)this.queue.length());
            this.getErrorManager().handleError(null, new StringBuffer().append("ERR: event queue size = ").append(this.queue.length()).toString(), 0, 3, 2);
        }

        public void lengthWarning(int n, int n2) {
        }
    }
}

