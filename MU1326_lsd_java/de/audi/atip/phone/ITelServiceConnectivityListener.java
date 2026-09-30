/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

public interface ITelServiceConnectivityListener {
    public void responseSetNadMode(int var1);

    public void responseChangePhoneModulePowerState(int var1);

    public void responseTogglePhones(int var1);

    public void responseSetNadRole(int var1);
}

