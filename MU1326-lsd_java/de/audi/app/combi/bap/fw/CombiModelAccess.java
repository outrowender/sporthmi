/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public final class CombiModelAccess {
    private static IFrameworkAccess frameworkAccess;

    public static void init(IFrameworkAccess iFrameworkAccess) {
        frameworkAccess = iFrameworkAccess;
    }

    public static boolean isSDSDisabledForCurrentLanguage() {
        return frameworkAccess.getHmiServiceApp().getChoiceModel(241).getValue() == 1;
    }

    public static ChoiceModelApp getChoiceModel(int n) {
        return frameworkAccess.getHmiServiceApp().getChoiceModel(n);
    }
}

