/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.evo;

import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.ISOSOpenClosePopupHandler;
import de.audi.app.ecall.core.OpenClosePopupHandler;
import de.audi.app.ecall.license.ILicenseScreenState;

public class SOSOpenClosePopupHandler
extends OpenClosePopupHandler
implements ISOSOpenClosePopupHandler {
    private ILicenseScreenState licenseScreenState;
    static /* synthetic */ Class class$de$audi$app$ecall$core$bap$EcallScreenNames;

    public SOSOpenClosePopupHandler(IEcallApplication iEcallApplication, ILicenseScreenState iLicenseScreenState) {
        super(iEcallApplication, "App.Ecall.SOS", 3300000);
        this.licenseScreenState = iLicenseScreenState;
    }

    public void showLicencePopup() {
        this.forceSOSScreenShowing(15);
    }

    public void forceSOSScreenShowing(int n) {
        this.log.log(10000000, "SOSOpenClosePopupHandler#forceSOSScreenShowing(): show ScreenId: %1 ", (long)n);
        EcallUtil.logStructFieldForDbg(this.log, class$de$audi$app$ecall$core$bap$EcallScreenNames == null ? (class$de$audi$app$ecall$core$bap$EcallScreenNames = SOSOpenClosePopupHandler.class$("de.audi.app.ecall.core.bap.EcallScreenNames")) : class$de$audi$app$ecall$core$bap$EcallScreenNames, n);
        this.setValueForEcallPopupChoiceModel(n);
        this.getHmiServiceApp().showPopup(this.SCREENS_POPUP_ID);
        this.setPopupConsumptionStrategy(this.getStrategyTypeForScreen(n));
    }

    public void onContextEntered() {
        super.onContextEntered();
        int n = this.licenseScreenState.getLincenseScreenId();
        if (n != 0) {
            this.forceSOSScreenShowing(n);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

