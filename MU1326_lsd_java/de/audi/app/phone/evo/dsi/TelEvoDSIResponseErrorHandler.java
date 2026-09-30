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
    private static final int ERROR_CHOICE_FUNCTION_NA_NET = 2;
    private static final int ERROR_CHOICE_FUNCTION_NA_PHONE = 1;
    private static final int ERROR_CHOICE_SYSTEM_BUSY = 3;
    private static final int ERROR_CHOICE_GENERAL = 4;

    public TelEvoDSIResponseErrorHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

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
                this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(n2, 300086);
                break;
            }
            case 65540: {
                this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(n2, 300087);
                break;
            }
            default: {
                this.log.log(10000000, "[TelEvoDSIResponseErrorHandler#notifyError] showing general error popup for result %1", (long)n);
                this.showErrorPopup(4, n2);
            }
        }
    }

    private void showErrorPopup(int n, int n2) {
        this.getChoiceModel(300678).setValue(n);
        this.log.log(10000, "[TelEvoDSIResponseErrorHandler#showErrorPopup] showing error popup!");
        this.getApplication().getFrameworkAccess().getHMIService().showPartialPopup(n2, 300084);
    }
}

