/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.varext;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public interface ITvVariantExt {
    public static final int VIRTUALBUTTON_NONE = -1;

    public int getVirtualButtonModelId(int var1);

    public SpellerModelApp getParentalRatingPasswordSpeller(IHMIServiceApp var1);

    public ChoiceModelApp getSdisForcedNavigationChoice(IHMIServiceApp var1);
}

