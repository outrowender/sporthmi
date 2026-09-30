/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.CopyOnWriteArrayList;
import de.audi.tv.app.util.Handler;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.List;

public class DataflowSyncronizationPoint {
    private final Object resetMutex = new Object();
    private final List requirements;
    private final List pendingRequirements;
    private boolean isFinished;
    private int messageCode = -1;
    private Handler handler;
    private Runnable callback;
    private DispatcherBase dispatcher;
    private LogChannel lc = new LogChannel(){

        public void log(int n, int n2, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n3, Throwable throwable) {
        }

        public void log(int n, String string, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n2, Throwable throwable) {
        }
    };
    private String logTag = "DataflowSyncronizationPoint";

    private DataflowSyncronizationPoint() {
        this.requirements = new ArrayList();
        this.pendingRequirements = new CopyOnWriteArrayList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addRequirement(Object object) {
        Object object2 = this.resetMutex;
        synchronized (object2) {
            this.requirements.add(object);
        }
    }

    private void setCallbackMessage(Handler handler, int n) {
        this.handler = handler;
        this.messageCode = n;
    }

    private void setCallback(Runnable runnable) {
        this.callback = runnable;
    }

    private void setDispatcher(DispatcherBase dispatcherBase) {
        this.dispatcher = dispatcherBase;
    }

    private void setLogChannel(LogChannel logChannel) {
        this.lc = logChannel;
    }

    private void setName(String string) {
        this.logTag = new StringBuffer().append("DataflowSyncronizationPoint[").append(string).append(']').toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        Object object = this.resetMutex;
        synchronized (object) {
            this.isFinished = false;
            this.pendingRequirements.clear();
            this.pendingRequirements.addAll(this.requirements);
            this.lc.log(10000000, "[%1.reset] now pending - %2", (Object)this.logTag, (Object)this.pendingRequirements);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void completeRequirement(Object object) {
        boolean bl = false;
        Object object2 = this.resetMutex;
        synchronized (object2) {
            if (!this.isFinished) {
                this.requirements.remove(object);
                this.lc.log(10000000, "[%1.completeRequirement] completed %2, pending %3", (Object)this.logTag, object, (Object)this.requirements);
                bl = this.requirements.isEmpty();
                this.isFinished |= bl;
            }
        }
        if (bl) {
            this.lc.log(10000000, "[%1.completeRequirement] completed all", (Object)this.logTag);
            if (this.callback != null) {
                if (this.dispatcher != null) {
                    this.dispatcher.execute(this.callback);
                } else {
                    this.callback.run();
                }
            }
            if (this.handler != null) {
                this.handler.sendEmptyMessage(this.messageCode);
            }
        }
    }

    public static class Builder {
        private final DataflowSyncronizationPoint point;
        private final Object builderIsUsedOnceMutex = new Object();
        private boolean done;

        public Builder() {
            this.point = new DataflowSyncronizationPoint();
        }

        public Builder setCallbackMessage(Handler handler, int n) {
            this.point.setCallbackMessage(handler, n);
            return this;
        }

        public Builder addRequirement(Object object) {
            this.point.addRequirement(object);
            return this;
        }

        public Builder setCallback(Runnable runnable) {
            this.point.setCallback(runnable);
            return this;
        }

        public Builder setDispatcher(DispatcherBase dispatcherBase) {
            this.point.setDispatcher(dispatcherBase);
            return this;
        }

        public Builder setLogChannel(LogChannel logChannel) {
            this.point.setLogChannel(logChannel);
            return this;
        }

        public Builder setName(String string) {
            this.point.setName(string);
            return this;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public DataflowSyncronizationPoint getDataflowSyncronizationPoint() {
            Object object = this.builderIsUsedOnceMutex;
            synchronized (object) {
                if (this.done) {
                    throw new IllegalStateException("Builder is not supposed to be used more than once!");
                }
                this.done = true;
                this.point.reset();
                return this.point;
            }
        }
    }
}

