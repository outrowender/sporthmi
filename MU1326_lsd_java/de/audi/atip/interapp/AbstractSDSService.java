/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface AbstractSDSService {
    public static final byte RESPONSE_TYPE_NONE = 0;
    public static final byte RESPONSE_TYPE_NOK_ONLY = 1;
    public static final byte RESPONSE_TYPE_ALL = 2;
    public static final byte PTT_DISABLER_NONE = 0;
    public static final byte PTT_DISABLER_NOT_READY = 1;
    public static final byte PTT_DISABLER_OPS_RVC = 2;
    public static final byte PTT_DISABLER_PHONE_CALL = 3;
    public static final byte PTT_DISABLER_SWDL = 4;
    public static final byte PTT_DISABLER_VOLUME_SETTING = 5;
    public static final byte PTT_DISABLER_LANGUAGE_LOADING = 6;
    public static final byte PTT_DISABLER_LANGUAGE_NOT_AVAILABLE = 7;
    public static final byte PTT_DISABLER_DRIVE_SELECT = 8;
    public static final byte PTT_DISABLER_APS = 9;
    public static final byte PTT_DISABLER_TERMINAL_MODE_PHONE_CALL = 10;
    public static final byte[] pttDisablerPrio = new byte[]{2, 9, 8, 3, 10, 7, 6, 4, 5};

    public void disablePTT(boolean var1, boolean var2, byte var3);

    public void sendResult(int var1);

    public void abortPostTraining();

    public boolean isSDSAborting();

    public boolean isSDSActive();
}

