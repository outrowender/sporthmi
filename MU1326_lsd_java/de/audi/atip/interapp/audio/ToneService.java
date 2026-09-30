/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface ToneService {
    public static final int PHONE_RINGTONE_SCENARIO_NONE = 0;
    public static final int PHONE_RINGTONE_SCENARIO_HFP_INBAND = 1;
    public static final int PHONE_RINGTONE_SCENARIO_OUTBAND = 2;
    public static final int PHONE_RINGTONE_SCENARIO_INDIVIDUAL = 3;
    public static final int MEDIA_ONLINE_DEFAULT_INPUT_GAIN_OFFSET = 0;

    public void updateMicGainLevel(int var1);

    public void updateMicGainRange(int var1, int var2);

    public void updatePhoneAudioScenario(int var1);

    public void updateBTLinkKeyAvailable(int var1, boolean var2);

    public void setMicGainLevel(int var1);

    public void updateUserDefinedRingtone(String var1, String var2);

    public void setDuration(int var1, int var2);

    public void setThreeDMode(int var1);

    public void setSurround(boolean var1);

    public void setSurroundForActiveEntertainment(boolean var1);

    public void setInputGainOffSet(short var1);
}

