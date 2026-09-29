/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAppConnectDeviceWorker
extends ExlapAbstractWorker {
    private static final int APP_CONNECT_DEVICE_PROPERTY;

    public ExlapAppConnectDeviceWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAppConnectDeviceWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(57, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAppConnectDeviceWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{57};
    }

    static /* synthetic */ LogChannel access$000(ExlapAppConnectDeviceWorker exlapAppConnectDeviceWorker) {
        return exlapAppConnectDeviceWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAppConnectDeviceWorker exlapAppConnectDeviceWorker, Container container) {
        exlapAppConnectDeviceWorker.container = container;
        return exlapAppConnectDeviceWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAppConnectDeviceWorker exlapAppConnectDeviceWorker) {
        return exlapAppConnectDeviceWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAppConnectDeviceWorker exlapAppConnectDeviceWorker) {
        exlapAppConnectDeviceWorker.trigger();
    }
}

