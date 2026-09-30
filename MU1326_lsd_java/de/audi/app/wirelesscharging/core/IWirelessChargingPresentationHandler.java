/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

public interface IWirelessChargingPresentationHandler {
    public void updateStatusBar(int var1);

    public void onWLCDeviceBeingCharged();

    public void onForeignObjectDetected();

    public void onRemindWLCDeviceStillInPhonebox();

    public void clearPresentation();

    public void removeReminder();

    public void popupRemoved(int var1, int var2);
}

