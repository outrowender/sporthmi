/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$1;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;

class DSISmartphoneManagerProxy$PlayerModificationListenerProxy
implements IPlayerModificationListener {
    private final /* synthetic */ DSISmartphoneManagerProxy this$0;

    private DSISmartphoneManagerProxy$PlayerModificationListenerProxy(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        this.this$0 = dSISmartphoneManagerProxy;
    }

    @Override
    public void skip(boolean bl, int n) {
        DSISmartphoneManagerProxy.access$800(this.this$0).skip(bl, n);
    }

    @Override
    public void seek(boolean bl, boolean bl2) {
        DSISmartphoneManagerProxy.access$800(this.this$0).seek(bl, bl2);
    }

    @Override
    public void resume() {
        DSISmartphoneManagerProxy.access$800(this.this$0).resume();
    }

    @Override
    public void pause(boolean bl) {
        DSISmartphoneManagerProxy.access$800(this.this$0).pause(bl);
    }

    /* synthetic */ DSISmartphoneManagerProxy$PlayerModificationListenerProxy(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, DSISmartphoneManagerProxy$1 dSISmartphoneManagerProxy$1) {
        this(dSISmartphoneManagerProxy);
    }
}

