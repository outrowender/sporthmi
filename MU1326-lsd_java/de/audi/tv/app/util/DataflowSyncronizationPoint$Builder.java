/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.DataflowSyncronizationPoint;
import de.audi.tv.app.util.Handler;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class DataflowSyncronizationPoint$Builder {
    private final DataflowSyncronizationPoint point;
    private final Object builderIsUsedOnceMutex = new Object();
    private boolean done;

    public DataflowSyncronizationPoint$Builder() {
        this.point = new DataflowSyncronizationPoint(null);
    }

    public DataflowSyncronizationPoint$Builder setCallbackMessage(Handler handler, int n) {
        DataflowSyncronizationPoint.access$100(this.point, handler, n);
        return this;
    }

    public DataflowSyncronizationPoint$Builder addRequirement(Object object) {
        DataflowSyncronizationPoint.access$200(this.point, object);
        return this;
    }

    public DataflowSyncronizationPoint$Builder setCallback(Runnable runnable) {
        DataflowSyncronizationPoint.access$300(this.point, runnable);
        return this;
    }

    public DataflowSyncronizationPoint$Builder setDispatcher(DispatcherBase dispatcherBase) {
        DataflowSyncronizationPoint.access$400(this.point, dispatcherBase);
        return this;
    }

    public DataflowSyncronizationPoint$Builder setLogChannel(LogChannel logChannel) {
        DataflowSyncronizationPoint.access$500(this.point, logChannel);
        return this;
    }

    public DataflowSyncronizationPoint$Builder setName(String string) {
        DataflowSyncronizationPoint.access$600(this.point, string);
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

