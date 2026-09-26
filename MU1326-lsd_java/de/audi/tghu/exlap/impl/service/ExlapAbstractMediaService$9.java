/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.AppConnectDeviceContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$9
implements ListenerIterator {
    private final /* synthetic */ AppConnectDeviceContainer val$appConnectDeviceProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$9(ExlapAbstractMediaService exlapAbstractMediaService, AppConnectDeviceContainer appConnectDeviceContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$appConnectDeviceProperty = appConnectDeviceContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateAppConnectDevice(this.val$appConnectDeviceProperty);
    }
}

