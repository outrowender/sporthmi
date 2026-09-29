/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.statemachine.Handler;
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
            this.lc.log(-2137614336, "[%1.reset] now pending - %2", (Object)this.logTag, (Object)this.pendingRequirements);
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
                this.lc.log(-2137614336, "[%1.completeRequirement] completed %2, pending %3", (Object)this.logTag, object, (Object)(this.pendingRequirements.isEmpty() ? "NONE" : this.pendingRequirements.toString()));
                bl = this.pendingRequirements.isEmpty();
                this.isFinished |= bl;
            } else {
                this.lc.log(-2137614336, "[%1.completeRequirement] already done, completed %2 again", (Object)this.logTag, object);
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
}

