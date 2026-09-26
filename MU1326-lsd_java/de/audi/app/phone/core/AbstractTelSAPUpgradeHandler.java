/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;

public abstract class AbstractTelSAPUpgradeHandler
extends AbstractPhoneComponent {
    public AbstractTelSAPUpgradeHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "AbstractTelSAPUpgradeHandler#updateGlobalTelephoneStateProperty stateStruct is null");
            return;
        }
        if (n == 0x22000100) {
            this.processSAPUpgradeActive(iGlobalTelephoneStateStruct.isSapUpgradeActive());
        }
    }

    protected abstract void processSAPUpgradeActive(boolean bl) {
    }
}

