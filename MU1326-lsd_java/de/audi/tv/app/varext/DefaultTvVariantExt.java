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
    @Override
    public int getVirtualButtonModelId(int n) {
        return -1;
    }

    @Override
    public SpellerModelApp getParentalRatingPasswordSpeller(IHMIServiceApp iHMIServiceApp) {
        return iHMIServiceApp.getSpellerModel(1336682240);
    }

    @Override
    public ChoiceModelApp getSdisForcedNavigationChoice(IHMIServiceApp iHMIServiceApp) {
        return iHMIServiceApp.getChoiceModel(-760469760);
    }
}

