/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.phone.ITelServiceConnectivityListener;

public interface ITelServiceConnectivity {
    public static final int NAD_ROLE_PRIMARY;
    public static final int NAD_ROLE_ASSOCIATED;
    public static final int NAD_ROLE_DATA;

    default public void setNadMode(int n, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
    }

    default public void changePhoneModulePowerState(boolean bl, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
    }

    default public void togglePhones(ITelServiceConnectivityListener iTelServiceConnectivityListener) {
    }

    default public void setNadRole(int n, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
    }

    default public void requestCurrentNadModulePowerState() {
    }
}

