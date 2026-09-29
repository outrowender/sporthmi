/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.evo;

import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IOPROpenClosePopupHandler;
import de.audi.app.ecall.core.OpenClosePopupHandler;

public class OPROpenClosePopupHandler
extends OpenClosePopupHandler
implements IOPROpenClosePopupHandler {
    public OPROpenClosePopupHandler(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.OPR", -1554370048);
    }

    @Override
    public void showLicencePopup() {
        this.log.log(1078071040, "OPROpenClosePopupHandler#showLicencePopup(): show ScreenId: %1 ", (long)0);
        this.getHmiServiceApp().showPopup(-1571147264);
    }
}

