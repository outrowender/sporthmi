/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.AppConnectDeviceContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAppConnectDeviceWorker;

class ExlapAppConnectDeviceWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapAppConnectDeviceWorker this$0;

    ExlapAppConnectDeviceWorker$1(ExlapAppConnectDeviceWorker exlapAppConnectDeviceWorker) {
        this.this$0 = exlapAppConnectDeviceWorker;
    }

    @Override
    public void updateAppConnectDevice(AppConnectDeviceContainer appConnectDeviceContainer) {
        ExlapAppConnectDeviceWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateAppConnectDevice] received new container: %1", (Object)appConnectDeviceContainer);
        ExlapAppConnectDeviceWorker.access$102(this.this$0, appConnectDeviceContainer);
        if (ExlapAppConnectDeviceWorker.access$200(this.this$0) != -1) {
            ExlapAppConnectDeviceWorker.access$300(this.this$0);
        }
    }
}

