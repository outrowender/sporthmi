/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.ddp2;

public interface CombiService {
    public static final int NAVI_RG_INVALID = 0;
    public static final int NAVI_RG_NOTACTIVE = 1;
    public static final int NAVI_RG_CALCULATING = 2;
    public static final int NAVI_RG_NEWCALC = 3;
    public static final int NAVI_RG_OFFMAP = 4;
    public static final int NAVI_RG_OFFROAD = 5;
    public static final int NAVI_RG_ACTIVE = 6;
    public static final int PHONE_CALLSTATE_INVALID = 0;
    public static final int PHONE_CALLSTATE_NOACTIVECALL = 1;
    public static final int PHONE_CALLSTATE_ON_HOLD = 2;
    public static final int PHONE_CALLSTATE_ACTIVE = 3;
    public static final int PHONE_CALLSTATE_DISCONNECTING = 4;
    public static final int PHONE_CALLSTATE_DIALING = 5;
    public static final int PHONE_CALLSTATE_INCOMING = 6;
    public static final int PHONE_CALLTYPE_INVALID = 0;
    public static final int PHONE_CALLTYPE_NORMAL = 1;
    public static final int PHONE_CALLTYPE_CONFERENCE = 2;
    public static final int PHONE_CALLTYPE_EMERGENCY = 3;
    public static final int PHONE_MIC_MUTE_OFF = 0;
    public static final int PHONE_MIC_MUTE_ON = 1;

    public void updateMicMuteState(int var1);

    public void updateRGState(int var1);

    public void updateCallStatus(int var1, int var2);

    public void updateHUDDisplayContent(boolean var1);

    public void showMMIHintFrame(String var1, String var2);

    public void notifyHookKeyPressed();

    public void updateNavInitialized(int var1, int var2);
}

