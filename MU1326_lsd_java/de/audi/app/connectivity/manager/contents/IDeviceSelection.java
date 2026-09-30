/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

public interface IDeviceSelection {
    public int getType();

    public String getDeviceIdentifier();

    public String getName();

    public boolean isConnected();
}

