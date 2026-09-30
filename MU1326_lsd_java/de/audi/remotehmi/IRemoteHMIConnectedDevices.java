/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public interface IRemoteHMIConnectedDevices {
    public String[] getConnectedDevices();

    public String[] getMACAddresses();

    public boolean[] getActivationStates();
}

