/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface PortalAuthenticationServiceCallbackListener {
    public void validatePairingCodeResult(boolean var1, int var2, int var3);

    public void validateCredentialsResult(boolean var1, int var2, int var3);

    public void loginResult(int var1);
}

