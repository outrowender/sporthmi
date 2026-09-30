/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

public interface IAppState {
    public static final int APPLICATIONID_UNKNOWN = 0;
    public static final int APPLICATIONID_PHONE = 1;
    public static final int APPLICATIONID_NAVIGATION = 2;
    public static final int APPLICATIONID_SPEECH = 3;
    public static final int APPLICATIONOWNER_UNKNOWN = 0;
    public static final int APPLICATIONOWNER_MAINUNIT = 1;
    public static final int APPLICATIONOWNER_DEVICE = 2;
    public static final int APPLICATIONOWNER_NOBODY = 3;
    public static final int SPEECHMODE_UNKNOWN = 0;
    public static final int SPEECHMODE_SPEEKING = 1;
    public static final int SPEECHMODE_RECOGNIZING = 2;

    public int getAppStateId();

    public int getOwner();

    public int getSpeechMode();
}

