/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public interface IRemoteHMIConnectedDevices {
    default public String[] getConnectedDevices() {
    }

    default public String[] getMACAddresses() {
    }

    default public boolean[] getActivationStates() {
    }
}

