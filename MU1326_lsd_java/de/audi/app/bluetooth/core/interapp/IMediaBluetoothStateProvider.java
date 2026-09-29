/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.interapp;

public interface IMediaBluetoothStateProvider {
    default public void connectionProcessStarted() {
    }

    default public void connectionProcessStopped() {
    }

    default public void inquiryStarted() {
    }

    default public void inquiryStopped() {
    }

    default public void serviceDiscoveryStarted() {
    }

    default public void serviceDiscoveryStopped() {
    }
}

