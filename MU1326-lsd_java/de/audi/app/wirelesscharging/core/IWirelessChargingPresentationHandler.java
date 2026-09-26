/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

public interface IWirelessChargingPresentationHandler {
    default public void updateStatusBar(int n) {
    }

    default public void onWLCDeviceBeingCharged() {
    }

    default public void onForeignObjectDetected() {
    }

    default public void onRemindWLCDeviceStillInPhonebox() {
    }

    default public void clearPresentation() {
    }

    default public void removeReminder() {
    }

    default public void popupRemoved(int n, int n2) {
    }
}

