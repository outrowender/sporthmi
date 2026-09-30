/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.DispatcherBaseAdapter;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.statemachine.Handler;
import de.audi.atip.utils.statemachine.SyncronousDispatcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.List;

public class SyncPoint {
    private final Object resetMutex = new Object();
    private final List requirements;
    private final List pendingRequirements;
    private final int messageCode;
    private final Handler handler;
    private final Runnable callback;
    private final IDispatcher dispatcher;
    private final LogChannel lc;
    private final String logTag;
    private boolean isFinished;

    public SyncPoint(List list, int n, Handler handler, Runnable runnable, IDispatcher iDispatcher, LogChannel logChannel, String string) {
        if (list == null || logChannel == null || string == null || iDispatcher == null) {
            throw new NullPointerException();
        }
        this.requirements = list;
        this.lc = logChannel;
        this.logTag = string;
        this.dispatcher = iDispatcher;
        this.messageCode = n;
        this.handler = handler;
        this.callback = runnable;
        if (handler == null && runnable == null) {
            throw new NullPointerException("Either handler or callback must be not null");
        }
        this.isFinished = false;
        this.pendingRequirements = new ArrayList(list.size());
        this.pendingRequirements.addAll(list);
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
                this.pendingRequirements.remove(object);
                this.lc.log(10000000, "[%1.completeRequirement] completed %2, pending %3", (Object)this.logTag, object, (Object)(this.pendingRequirements.isEmpty() ? "NONE" : this.pendingRequirements.toString()));
                bl = this.pendingRequirements.isEmpty();
                this.isFinished |= bl;
            } else {
                this.lc.log(10000000, "[%1.completeRequirement] already done, completed %2 again", (Object)this.logTag, object);
            }
        }
        if (bl) {
            if (this.callback != null) {
                this.dispatcher.execute(this.callback);
            }
            if (this.handler != null) {
                this.handler.sendEmptyMessage(this.messageCode);
            }
        }
    }

    public static class Builder {
        private final List requirements;
        private int messageCode = -1;
        private Handler handler;
        private Runnable callback;
        private IDispatcher dispatcher;
        private LogChannel lc = new LogChannel(){

            public void log(int n, int n2, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n3, Throwable throwable) {
            }

            public void log(int n, String string, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n2, Throwable throwable) {
            }
        };
        private String logTag = "unspecified";

        public Builder() {
            this.dispatcher = new SyncronousDispatcher();
            this.requirements = new ArrayList();
        }

        public Builder setCallbackMessage(Handler handler, int n) {
            this.handler = handler;
            this.messageCode = n;
            return this;
        }

        public Builder addRequirement(Object object) {
            this.requirements.add(object);
            return this;
        }

        public Builder setCallback(Runnable runnable) {
            this.callback = runnable;
            return this;
        }

        public Builder setDispatcher(DispatcherBase dispatcherBase) {
            this.dispatcher = new DispatcherBaseAdapter(dispatcherBase);
            return this;
        }

        public Builder setDispatcher(IDispatcher iDispatcher) {
            this.dispatcher = iDispatcher;
            return this;
        }

        public Builder setLogChannel(LogChannel logChannel) {
            this.lc = logChannel;
            return this;
        }

        public Builder setName(String string) {
            this.logTag = "SyncPoint[" + string + ']';
            return this;
        }

        public SyncPoint build() {
            return new SyncPoint(this.requirements, this.messageCode, this.handler, this.callback, this.dispatcher, this.lc, this.logTag);
        }
    }
}

