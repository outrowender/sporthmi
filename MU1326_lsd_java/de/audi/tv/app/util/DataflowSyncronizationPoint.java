/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.CopyOnWriteArrayList;
import de.audi.tv.app.util.DataflowSyncronizationPoint$1;
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
    private LogChannel lc = new DataflowSyncronizationPoint$1(this);
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
                this.requirements.remove(object);
                this.lc.log(-2137614336, "[%1.completeRequirement] completed %2, pending %3", (Object)this.logTag, object, (Object)this.requirements);
                bl = this.requirements.isEmpty();
                this.isFinished |= bl;
            }
        }
        if (bl) {
            this.lc.log(-2137614336, "[%1.completeRequirement] completed all", (Object)this.logTag);
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

    /* synthetic */ DataflowSyncronizationPoint(DataflowSyncronizationPoint$1 var1_1) {
        this();
    }

    static /* synthetic */ void access$100(DataflowSyncronizationPoint dataflowSyncronizationPoint, Handler handler, int n) {
        dataflowSyncronizationPoint.setCallbackMessage(handler, n);
    }

    static /* synthetic */ void access$200(DataflowSyncronizationPoint dataflowSyncronizationPoint, Object object) {
        dataflowSyncronizationPoint.addRequirement(object);
    }

    static /* synthetic */ void access$300(DataflowSyncronizationPoint dataflowSyncronizationPoint, Runnable runnable) {
        dataflowSyncronizationPoint.setCallback(runnable);
    }

    static /* synthetic */ void access$400(DataflowSyncronizationPoint dataflowSyncronizationPoint, DispatcherBase dispatcherBase) {
        dataflowSyncronizationPoint.setDispatcher(dispatcherBase);
    }

    static /* synthetic */ void access$500(DataflowSyncronizationPoint dataflowSyncronizationPoint, LogChannel logChannel) {
        dataflowSyncronizationPoint.setLogChannel(logChannel);
    }

    static /* synthetic */ void access$600(DataflowSyncronizationPoint dataflowSyncronizationPoint, String string) {
        dataflowSyncronizationPoint.setName(string);
    }
}

