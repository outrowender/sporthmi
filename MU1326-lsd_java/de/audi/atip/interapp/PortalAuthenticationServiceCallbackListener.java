/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface PortalAuthenticationServiceCallbackListener {
    default public void validatePairingCodeResult(boolean bl, int n, int n2) {
    }

    default public void validateCredentialsResult(boolean bl, int n, int n2) {
    }

    default public void loginResult(int n) {
    }
}

