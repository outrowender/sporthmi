/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.interapp;

public interface IMediaBluetoothStateProvider {
    public void connectionProcessStarted();

    public void connectionProcessStopped();

    public void inquiryStarted();

    public void inquiryStopped();

    public void serviceDiscoveryStarted();

    public void serviceDiscoveryStopped();
}

