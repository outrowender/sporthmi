/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.varext;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.tv.app.varext.ITvVariantExt;

public class DefaultTvVariantExt
implements ITvVariantExt {
    public int getVirtualButtonModelId(int n) {
        return -1;
    }

    public SpellerModelApp getParentalRatingPasswordSpeller(IHMIServiceApp iHMIServiceApp) {
        return iHMIServiceApp.getSpellerModel(2600015);
    }

    public ChoiceModelApp getSdisForcedNavigationChoice(IHMIServiceApp iHMIServiceApp) {
        return iHMIServiceApp.getChoiceModel(2600146);
    }
}

