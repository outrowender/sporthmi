/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler$IShowScreenStrategy;

class NewDeviceHMIHandler$2
implements NewDeviceHMIHandler$IShowScreenStrategy {
    private final /* synthetic */ IContext val$pContext;

    NewDeviceHMIHandler$2(IContext iContext) {
        this.val$pContext = iContext;
    }

    @Override
    public void showScreen() {
        this.val$pContext.getChoiceModel(4384).setValue(1);
    }

    @Override
    public void removePartialPopup() {
    }
}

