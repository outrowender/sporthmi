/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

public interface ISecurity {
    public void inquiryActive(boolean var1);

    public void connectionActive(boolean var1);

    public void serviceDiscoveryActive(boolean var1);

    public void securityExitAction();

    public void securityEntryAction();

    public void speedDisclaimerEntered();
}

