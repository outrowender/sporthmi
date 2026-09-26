/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.dsi;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIResponseErrorHandler;

public class TelEvoDSIResponseErrorHandler
extends AbstractPhoneComponent
implements ITelDSIResponseErrorHandler {
    private static final int ERROR_CHOICE_FUNCTION_NA_NET;
    private static final int ERROR_CHOICE_FUNCTION_NA_PHONE;
    private static final int ERROR_CHOICE_SYSTEM_BUSY;
    private static final int ERROR_CHOICE_GENERAL;

    public TelEvoDSIResponseErrorHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void handleResult(int n, int n2) {
        n2 = 0;
        switch (n) {
            case 0: 
            case 1: 
            case 5: 
            case 65537: 
            case 65538: {
                break;
            }
            case 3: {
                this.showErrorPopup(2, n2);
                break;
            }
            case 2: {
                this.showErrorPopup(1, n2);
                break;
            }
            case 6: {
                this.showErrorPopup(3, n2);
                break;
            }
            case 65539: {
                this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(n2, 915670016);
                break;
            }
            case 65540: {
                this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(n2, 932447232);
                break;
            }
            default: {
                this.log.log(-2137614336, "[TelEvoDSIResponseErrorHandler#notifyError] showing general error popup for result %1", (long)n);
                this.showErrorPopup(4, n2);
            }
        }
    }

    private void showErrorPopup(int n, int n2) {
        this.getChoiceModel(-2036988928).setValue(n);
        this.log.log(10000, "[TelEvoDSIResponseErrorHandler#showErrorPopup] showing error popup!");
        this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(n2, 882115584);
    }
}

