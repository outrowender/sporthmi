/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface ToneService {
    public static final int PHONE_RINGTONE_SCENARIO_NONE;
    public static final int PHONE_RINGTONE_SCENARIO_HFP_INBAND;
    public static final int PHONE_RINGTONE_SCENARIO_OUTBAND;
    public static final int PHONE_RINGTONE_SCENARIO_INDIVIDUAL;
    public static final int MEDIA_ONLINE_DEFAULT_INPUT_GAIN_OFFSET;

    default public void updateMicGainLevel(int n) {
    }

    default public void updateMicGainRange(int n, int n2) {
    }

    default public void updatePhoneAudioScenario(int n) {
    }

    default public void updateBTLinkKeyAvailable(int n, boolean bl) {
    }

    default public void setMicGainLevel(int n) {
    }

    default public void updateUserDefinedRingtone(String string, String string2) {
    }

    default public void setDuration(int n, int n2) {
    }

    default public void setThreeDMode(int n) {
    }

    default public void setSurround(boolean bl) {
    }

    default public void setSurroundForActiveEntertainment(boolean bl) {
    }

    default public void setInputGainOffSet(short s) {
    }
}

