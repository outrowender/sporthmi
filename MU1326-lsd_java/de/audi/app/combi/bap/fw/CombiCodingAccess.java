/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw;

import de.audi.atip.base.IFrameworkAccess;

public class CombiCodingAccess {
    private static IFrameworkAccess frameworkAccess;

    public static void init(IFrameworkAccess iFrameworkAccess) {
        frameworkAccess = iFrameworkAccess;
    }

    public static boolean isReducedAudioInformation() {
        return frameworkAccess.getSysConst(471) == 2;
    }

    public static boolean isSDSPresent() {
        return frameworkAccess.getSysConst(460) == 1;
    }

    public static boolean isNaviPresent() {
        return frameworkAccess.getSysConst(459) == 1;
    }

    public static boolean isTextReplacementActivated() {
        return frameworkAccess.getSysApp().getDiagnosisCOD().isDashboardTextReplacementActivated();
    }
}

