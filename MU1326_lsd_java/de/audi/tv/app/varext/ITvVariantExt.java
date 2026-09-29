/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.varext;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public interface ITvVariantExt {
    public static final int VIRTUALBUTTON_NONE;

    default public int getVirtualButtonModelId(int n) {
    }

    default public SpellerModelApp getParentalRatingPasswordSpeller(IHMIServiceApp iHMIServiceApp) {
    }

    default public ChoiceModelApp getSdisForcedNavigationChoice(IHMIServiceApp iHMIServiceApp) {
    }
}

