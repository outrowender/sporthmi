/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

public interface IAppState {
    public static final int APPLICATIONID_UNKNOWN;
    public static final int APPLICATIONID_PHONE;
    public static final int APPLICATIONID_NAVIGATION;
    public static final int APPLICATIONID_SPEECH;
    public static final int APPLICATIONOWNER_UNKNOWN;
    public static final int APPLICATIONOWNER_MAINUNIT;
    public static final int APPLICATIONOWNER_DEVICE;
    public static final int APPLICATIONOWNER_NOBODY;
    public static final int SPEECHMODE_UNKNOWN;
    public static final int SPEECHMODE_SPEEKING;
    public static final int SPEECHMODE_RECOGNIZING;

    default public int getAppStateId() {
    }

    default public int getOwner() {
    }

    default public int getSpeechMode() {
    }
}

