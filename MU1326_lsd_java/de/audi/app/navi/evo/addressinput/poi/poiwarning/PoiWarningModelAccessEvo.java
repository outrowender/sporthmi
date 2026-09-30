/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.poiwarning;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningModelAccess;

public class PoiWarningModelAccessEvo
extends PoiWarningModelAccess {
    private final IHMIServiceApp hmiService;
    private static final int terminalId = 0;

    public PoiWarningModelAccessEvo(NavigationEnv navigationEnv, IconHandler iconHandler) {
        super(navigationEnv, iconHandler);
        this.hmiService = navigationEnv.getHMIService();
    }

    public void showPoiWarningMaxPopUp() {
        this.hmiService.showPartialPopup(0, 400182);
    }

    public void showPpoiWarningMaxPopUp() {
        this.hmiService.showPartialPopup(0, 400183);
    }

    public void showPoiApproachPopUp() {
        this.hmiService.showPartialPopup(0, 400186);
    }

    public void hideWarningPopUp() {
        this.hmiService.removePartialPopup(0, 400186);
    }
}

