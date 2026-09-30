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
        super(iEcallApplication, "App.Ecall.OPR", 3300003);
    }

    public void showLicencePopup() {
        this.log.log(1000000, "OPROpenClosePopupHandler#showLicencePopup(): show ScreenId: %1 ", 3300002L);
        this.getHmiServiceApp().showPopup(3300002);
    }
}

