/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.configuration;

public interface IMediaConfiguration {
    public boolean isSourceInstalled(int var1);

    public int getLastModeSource();

    public boolean isRippingEnabled();

    public boolean isAudioIndepend();

    public boolean isImportEnabled();

    public boolean isImportOverrideActive();

    public boolean isSpeedThresholdDisabled();

    public boolean isWLANStateSynchronizationDisabled();

    public boolean isBluetoothListBrowsing();

    public boolean isSpeedThresholdEnabledEver();

    public boolean isGracenoteEnabled();

    public boolean isGracenoteOnlineAvailable();

    public boolean isTVinMedia();

    public boolean isDVDVideoFormatSettingAvailable();

    public boolean isIAP2Supported();
}

