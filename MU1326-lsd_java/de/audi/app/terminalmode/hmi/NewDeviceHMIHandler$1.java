/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler$IShowScreenStrategy;

class NewDeviceHMIHandler$1
implements NewDeviceHMIHandler$IShowScreenStrategy {
    private final /* synthetic */ IContext val$pContext;
    private final /* synthetic */ int val$pPartialPopupIdConnectPopup;

    NewDeviceHMIHandler$1(IContext iContext, int n) {
        this.val$pContext = iContext;
        this.val$pPartialPopupIdConnectPopup = n;
    }

    @Override
    public void showScreen() {
        this.val$pContext.getFramework().getHmiServiceApp().showPartialPopup(0, this.val$pPartialPopupIdConnectPopup);
    }

    @Override
    public void removePartialPopup() {
        this.val$pContext.getLogger().hmi().log(14808325, "[%1.removePartialPopup]", (Object)"NewDeviceHMIHandler");
        this.val$pContext.getFramework().getHmiServiceApp().removePartialPopup(0, this.val$pPartialPopupIdConnectPopup);
    }
}

