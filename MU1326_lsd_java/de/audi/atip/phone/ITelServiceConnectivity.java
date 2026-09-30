/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.phone.ITelServiceConnectivityListener;

public interface ITelServiceConnectivity {
    public static final int NAD_ROLE_PRIMARY = 0;
    public static final int NAD_ROLE_ASSOCIATED = 1;
    public static final int NAD_ROLE_DATA = 2;

    public void setNadMode(int var1, ITelServiceConnectivityListener var2);

    public void changePhoneModulePowerState(boolean var1, ITelServiceConnectivityListener var2);

    public void togglePhones(ITelServiceConnectivityListener var1);

    public void setNadRole(int var1, ITelServiceConnectivityListener var2);

    public void requestCurrentNadModulePowerState();
}

