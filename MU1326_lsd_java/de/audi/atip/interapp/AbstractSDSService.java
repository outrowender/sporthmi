/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface AbstractSDSService {
    public static final byte RESPONSE_TYPE_NONE;
    public static final byte RESPONSE_TYPE_NOK_ONLY;
    public static final byte RESPONSE_TYPE_ALL;
    public static final byte PTT_DISABLER_NONE;
    public static final byte PTT_DISABLER_NOT_READY;
    public static final byte PTT_DISABLER_OPS_RVC;
    public static final byte PTT_DISABLER_PHONE_CALL;
    public static final byte PTT_DISABLER_SWDL;
    public static final byte PTT_DISABLER_VOLUME_SETTING;
    public static final byte PTT_DISABLER_LANGUAGE_LOADING;
    public static final byte PTT_DISABLER_LANGUAGE_NOT_AVAILABLE;
    public static final byte PTT_DISABLER_DRIVE_SELECT;
    public static final byte PTT_DISABLER_APS;
    public static final byte PTT_DISABLER_TERMINAL_MODE_PHONE_CALL;
    public static final byte[] pttDisablerPrio;

    default public void disablePTT(boolean bl, boolean bl2, byte by) {
    }

    default public void sendResult(int n) {
    }

    default public void abortPostTraining() {
    }

    default public boolean isSDSAborting() {
    }

    default public boolean isSDSActive() {
    }

    static {
        pttDisablerPrio = new byte[]{2, 9, 8, 3, 10, 7, 6, 4, 5};
    }
}

