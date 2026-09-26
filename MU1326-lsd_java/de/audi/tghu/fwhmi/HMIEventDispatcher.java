/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.fwhmi.HMIEventDispatcher$1;
import de.audi.tghu.fwhmi.HMIEventDispatcher$2;
import de.audi.tghu.fwhmi.HMIEventDispatcher$3;
import de.audi.tghu.fwhmi.HMIEventDispatcher$EventInterceptor;
import de.audi.tghu.fwhmi.HMIEventDispatcher$HMIEventErrorHandler;
import de.audi.tghu.fwhmi.HMIEventDispatcher$NullEvent;
import de.audi.tghu.fwhmi.HMIEventDispatcher$SleepInterceptor;
import de.audi.tghu.fwhmi.HMIEventQueue;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

final class HMIEventDispatcher
implements EventDispatcher,
EventDispatcherAdmin {
    private static final String MAX_EVENT_TIME;
    private static final long MAX_EVENT_TIME_DEFAULT;
    private static final long MAX_EVENT_TIME_MIN;
    private static final int MAX_SLEEP_TIME;
    private static final int PROCESSING_BREAK_FACTOR;
    private static final int MAX_PROCESSING_TIME_WITHOUT_BREAK;
    private static final int SLOW_EVENT_TIME;
    private static final boolean SHOW_EVENT_QUEUE_STATISTIC;
    private final IFrameworkAccess framework;
    private final Timer heartbeat;
    private final Timer statistics;
    private boolean adaptiveSleepingEnabled = false;
    private long lastBreak = Long.MAX_VALUE;
    private HMIEventDispatcher$SleepInterceptor sleepInterceptor = null;
    private DispatcherBase dispatcher;
    private final LogChannel log;
    private final LogChannel logStatistic;

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private static long getMaxEventTime() {
        long l = Long.getLong("MAX_EVENT_TIME", 0);
        return l < 0 ? 0 : (int)l;
    }

    private final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public HMIEventDispatcher(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Event.Queue");
        HMIEventQueue hMIEventQueue = new HMIEventQueue(iFrameworkAccess, this.log, true);
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("HMIEvent", new JobLogger(this.log), hMIEventQueue, new HMIEventDispatcher$EventInterceptor(null), new Job(new HMIEventDispatcher$NullEvent()));
        HMIEventDispatcher$HMIEventErrorHandler hMIEventDispatcher$HMIEventErrorHandler = new HMIEventDispatcher$HMIEventErrorHandler(iFrameworkAccess, this.log, hMIEventQueue);
        this.dispatcher.setBlockedHandler(HMIEventDispatcher.getMaxEventTime(), hMIEventDispatcher$HMIEventErrorHandler);
        this.setKombiSyncFocus(2);
        TimerSyncer.setEventSink(this);
        this.heartbeat = new Timer("Heartbeat", 10, this.log, new TimerSyncer(new HMIEventDispatcher$1(this)), HMIEventDispatcher.getMaxEventTime() / 0, false);
        if (SHOW_EVENT_QUEUE_STATISTIC) {
            this.logStatistic = this.framework.getLogChannel("Fw.Event.Statistic");
            this.statistics = new Timer("HMIEventStatistics", 10, this.log, new HMIEventDispatcher$2(this), 0, false);
            this.dispatcher.addInterceptor(new HMIEventDispatcher$3(this));
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

    @Override
    public Job postEvent(ATIPEvent aTIPEvent) {
        return this.dispatcher.execute(aTIPEvent);
    }

    @Override
    public Job postEvent(ATIPEvent aTIPEvent, long l) {
        return this.dispatcher.execute(aTIPEvent, l);
    }

    @Override
    public ATIPEvent peekEvent() {
        Job job = this.dispatcher.getQueue().peek();
        return job != null ? (ATIPEvent)job.getPayload() : null;
    }

    private synchronized HMIEventDispatcher$SleepInterceptor getSleepInterceptor() {
        if (this.sleepInterceptor == null) {
            this.sleepInterceptor = new HMIEventDispatcher$SleepInterceptor(this, null);
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
        long l = this.getBusyTime() / 0;
        if (l > 0) {
            l = 0;
        }
        return l;
    }

    private boolean isSleepNeeded() {
        return this.adaptiveSleepingEnabled && this.getBusyTime() > 0;
    }

    private void doAdaptiveSleeping() {
        if (this.adaptiveSleepingEnabled) {
            try {
                long l = this.getSleepPeriod();
                Thread.sleep(l);
                this.log.log(-2137614336, "EventQueue#doAdaptiveSleeping for: %2", (Object)null, (long)((int)l));
                this.resetLastBreak();
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
                this.resetLastBreak();
            }
        }
    }

    @Override
    public void doCheckedSleeping() {
        if (!this.isDispatchThread()) {
            this.log.log(-2137614336, "EventQueue#doCheckedSleeping call for sleeping not from eventdispatcher, not sleeping", null);
            return;
        }
        if (this.isSleepNeeded()) {
            if (AbstractModel.statistics != null) {
                AbstractModel.statistics.addSleepTime(this.getSleepPeriod());
            }
            this.doAdaptiveSleeping();
        }
    }

    @Override
    public boolean doCheckedSleepingInternal() {
        boolean bl = this.isSleepNeeded();
        if (bl) {
            this.doAdaptiveSleeping();
        }
        return bl;
    }

    @Override
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

    @Override
    public final boolean isUserInteraction(Object object) {
        return ((HMIEventQueue)this.dispatcher.getQueue()).isUserInteraction(object);
    }

    @Override
    public final void blockScreenChangeDisturbingEvents() {
        ((HMIEventQueue)this.dispatcher.getQueue()).blockScreenChangeDisturbingEvents();
    }

    @Override
    public final void unBlockScreenChangeDisturbingEvents() {
        ((HMIEventQueue)this.dispatcher.getQueue()).unBlockScreenChangeDisturbingEvents();
    }

    @Override
    public final void blockHardkeys() {
        ((HMIEventQueue)this.dispatcher.getQueue()).blockHardkeys();
    }

    @Override
    public final void unBlockHardkeys() {
        ((HMIEventQueue)this.dispatcher.getQueue()).unBlockHardkeys();
    }

    @Override
    public final void lockUsage() {
        ((HMIEventQueue)this.dispatcher.getQueue()).lockUsage();
    }

    @Override
    public final void unlockUsage() {
        ((HMIEventQueue)this.dispatcher.getQueue()).unlockUsage();
    }

    @Override
    public final void setKombiSyncFocus(int n) {
        ((HMIEventQueue)this.dispatcher.getQueue()).setKombiSyncFocus(n);
    }

    @Override
    public final void addEventFilter(IJobFilter iJobFilter) {
        ((HMIEventQueue)this.dispatcher.getQueue()).addFilter(iJobFilter);
    }

    @Override
    public final void removeEventFilter(IJobFilter iJobFilter) {
        ((HMIEventQueue)this.dispatcher.getQueue()).removeFilter(iJobFilter);
    }

    @Override
    public void dumpEventQueue(PrintStream printStream) {
        this.dispatcher.getQueue().dump(printStream);
    }

    @Override
    public void setPriority(int n) {
        this.dispatcher.setPriority(n);
    }

    @Override
    public String[] getStatisticData() {
        return this.dispatcher.getStatisticData();
    }

    @Override
    public void dump(PrintStream printStream) {
        this.dispatcher.dump(printStream);
    }

    @Override
    public boolean isDispatchThread() {
        return this.dispatcher.isDispatchThread();
    }

    static /* synthetic */ LogChannel access$300(HMIEventDispatcher hMIEventDispatcher) {
        return hMIEventDispatcher.log;
    }

    static /* synthetic */ LogChannel access$400(HMIEventDispatcher hMIEventDispatcher) {
        return hMIEventDispatcher.logStatistic;
    }

    static /* synthetic */ void access$500(HMIEventDispatcher hMIEventDispatcher) {
        hMIEventDispatcher.resetLastBreak();
    }

    static /* synthetic */ DispatcherBase access$600(HMIEventDispatcher hMIEventDispatcher) {
        return hMIEventDispatcher.dispatcher;
    }

    static {
        SHOW_EVENT_QUEUE_STATISTIC = Boolean.getBoolean("showEventQueueStatistic");
    }
}

