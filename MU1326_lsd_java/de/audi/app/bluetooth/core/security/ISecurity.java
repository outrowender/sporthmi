/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

public interface ISecurity {
    default public void inquiryActive(boolean bl) {
    }

    default public void connectionActive(boolean bl) {
    }

    default public void serviceDiscoveryActive(boolean bl) {
    }

    default public void securityExitAction() {
    }

    default public void securityEntryAction() {
    }

    default public void speedDisclaimerEntered() {
    }
}

