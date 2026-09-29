/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.ddp2;

public interface CombiService {
    public static final int NAVI_RG_INVALID;
    public static final int NAVI_RG_NOTACTIVE;
    public static final int NAVI_RG_CALCULATING;
    public static final int NAVI_RG_NEWCALC;
    public static final int NAVI_RG_OFFMAP;
    public static final int NAVI_RG_OFFROAD;
    public static final int NAVI_RG_ACTIVE;
    public static final int PHONE_CALLSTATE_INVALID;
    public static final int PHONE_CALLSTATE_NOACTIVECALL;
    public static final int PHONE_CALLSTATE_ON_HOLD;
    public static final int PHONE_CALLSTATE_ACTIVE;
    public static final int PHONE_CALLSTATE_DISCONNECTING;
    public static final int PHONE_CALLSTATE_DIALING;
    public static final int PHONE_CALLSTATE_INCOMING;
    public static final int PHONE_CALLTYPE_INVALID;
    public static final int PHONE_CALLTYPE_NORMAL;
    public static final int PHONE_CALLTYPE_CONFERENCE;
    public static final int PHONE_CALLTYPE_EMERGENCY;
    public static final int PHONE_MIC_MUTE_OFF;
    public static final int PHONE_MIC_MUTE_ON;

    default public void updateMicMuteState(int n) {
    }

    default public void updateRGState(int n) {
    }

    default public void updateCallStatus(int n, int n2) {
    }

    default public void updateHUDDisplayContent(boolean bl) {
    }

    default public void showMMIHintFrame(String string, String string2) {
    }

    default public void notifyHookKeyPressed() {
    }

    default public void updateNavInitialized(int n, int n2) {
    }
}

