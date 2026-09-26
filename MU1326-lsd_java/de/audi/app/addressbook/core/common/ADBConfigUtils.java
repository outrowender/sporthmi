/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.atip.base.IFrameworkAccess;

public class ADBConfigUtils {
    public static int getDefaultSortOrder(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4255);
    }

    public static int getMaxPhoneEntries(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4256);
    }

    public static int getMaxPublicEntries(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4254);
    }

    public static boolean getDefaultPublicVisibility(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4258) == 1;
    }

    public static int getSpeedDialType(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4424);
    }

    public static int getMaxSpeedDialEntries(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4425);
    }
}

