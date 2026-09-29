/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

import de.audi.atip.base.IFrameworkAccess;

public final class ExlapUtil {
    private ExlapUtil() {
    }

    public static int readExlapStatus(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getStorageMgr().getInt(1115, 1, ExlapUtil.getExlapDefaultStatus(iFrameworkAccess));
    }

    public static void persistExlapStatus(IFrameworkAccess iFrameworkAccess, int n) {
        iFrameworkAccess.getStorageMgr().setInt(1115, 1, n);
    }

    public static boolean convertExlapStatus(int n) {
        return n == 1;
    }

    public static int convertExlapStatus(boolean bl) {
        return bl ? 1 : 0;
    }

    private static int getExlapDefaultStatus(IFrameworkAccess iFrameworkAccess) {
        if (iFrameworkAccess.isBentley()) {
            return 0;
        }
        return 1;
    }
}

