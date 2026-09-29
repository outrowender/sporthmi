/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.core.comfort.UGDOPopupHandler;
import de.audi.app.car.core.comfort.UGDOPopupHandler$1;

class UGDOPopupHandler$PowerEventListener
implements IPowerEventListener {
    private volatile boolean isInStandby;
    private volatile boolean isHMIonMute;
    private final /* synthetic */ UGDOPopupHandler this$0;

    private UGDOPopupHandler$PowerEventListener(UGDOPopupHandler uGDOPopupHandler) {
        this.this$0 = uGDOPopupHandler;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n) {
        this.this$0.logChannel.log(1078071040, "[UGDOPopupHandler#notifyPowerListenerOnEnterState] Powerevent: '%1'", (long)n);
        switch (n) {
            case 2: 
            case 3: {
                this.isInStandby = true;
                break;
            }
            case 4: {
                this.isHMIonMute = true;
                break;
            }
        }
    }

    @Override
    public void notifyPowerListenerOnExitState(int n) {
        this.this$0.logChannel.log(1078071040, "[UGDOPopupHandler#notifyPowerListenerOnExitState] Powerevent: '%1'", (long)n);
        switch (n) {
            case 2: 
            case 3: {
                this.isInStandby = false;
                break;
            }
            case 0: 
            case 1: 
            case 4: {
                this.isHMIonMute = false;
                break;
            }
        }
    }

    @Override
    public void notifyPowerTriggerAction(int n) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public boolean isInStandby() {
        return this.isInStandby;
    }

    public boolean isHMIOnMute() {
        return this.isHMIonMute;
    }

    /* synthetic */ UGDOPopupHandler$PowerEventListener(UGDOPopupHandler uGDOPopupHandler, UGDOPopupHandler$1 uGDOPopupHandler$1) {
        this(uGDOPopupHandler);
    }
}

