/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

public interface ITerminalModeConfiguration {
    public boolean isTerminalMode();

    public boolean hasKnob();

    public boolean hasTouchpad();

    public boolean hasTouchscreenHigh();

    public boolean hasTouchscreenLow();

    public boolean hasTouchscreen();

    public boolean isRightHandDrive();

    public String getScreenName();

    public int getScreenResolutionX();

    public int getScreenResolutionY();

    public int getWindowResolutionX();

    public int getWindowResolutionY();

    public int getTouchPadResolutionX();

    public int getTouchPadResolutionY();

    public int getPhysicalDisplayHeight();

    public int getPhysicalDisplayWidth();

    public int getDSICarPlayScreenResolution();

    public int getCarPlayPhysicalDisplayHeight();

    public int getCarPlayPhysicalDisplayWidth();

    public boolean isAutoConnect();

    public boolean shouldShowDisclaimerAtLeastOnce();

    public boolean getStoreUserAcceptState();

    public boolean isKnobDirectionInverted();

    public int getScreenOffsetX();

    public int getScreenOffsetY();

    public boolean isTouchScreenInputWidget();

    public boolean hasTwoVirtualButtonModels();

    public boolean supportsDeletionOfConnectedDevices();

    public boolean hasBothPhoneMFLKeys();

    public boolean usesOldMediaConnector();

    public int applicationOffset();

    public boolean isOnHoldWhenPhoneCallActive();
}

