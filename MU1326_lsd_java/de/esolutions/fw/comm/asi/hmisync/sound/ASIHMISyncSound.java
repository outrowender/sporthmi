/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound;

public interface ASIHMISyncSound {
    public static final String IPL_COMM_UUID = "77c20339-10b3-4457-b2a9-6deff271cdc2";
    public static final String IPL_COMM_INTERFACE_KEY = "b04b00ad-13da-5a0a-80a6-aa17af0966af";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.1.00";

    public static interface Consts {
        public static final int SOUNDSTATE_ENABLED = 0;
        public static final int SOUNDSTATE_DISABLED_AM_UNAVAILABLE = 1;
        public static final int SOUNDSTATE_DISABLED_OTHER = 128;
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 14;
        public static final short updateRequestIDs = 27;
        public static final short updateReplyIDs = 26;
        public static final short updateSoundState = 28;
        public static final short updateAmplifier = 15;
        public static final short updateBassRange = 18;
        public static final short updateBassValue = 19;
        public static final short updateTrebleRange = 33;
        public static final short updateTrebleValue = 34;
        public static final short updateBalanceRange = 16;
        public static final short updateBalanceValue = 17;
        public static final short updateFaderRange = 20;
        public static final short updateFaderValue = 21;
        public static final short updateSubwooferRange = 29;
        public static final short updateSubwooferValue = 30;
        public static final short updateSurroundRange = 31;
        public static final short updateSurroundValue = 32;
        public static final short updateNoiseCompensationRange = 22;
        public static final short updateNoiseCompensationValue = 23;
        public static final short updateThreeDModeRange = 39;
        public static final short updateThreeDModeValue = 40;
        public static final short updateSoundShapeRange = 42;
        public static final short updateSoundShapeValue = 43;
        public static final short updatePresetPositionList = 25;
        public static final short updatePresetPosition = 24;
        public static final short updatePresetEQList = 38;
        public static final short updatePresetEQ = 37;

        public static short[] getIDs() {
            return new short[]{14, 27, 26, 28, 15, 18, 19, 33, 34, 16, 17, 20, 21, 29, 30, 31, 32, 22, 23, 39, 40, 42, 43, 25, 24, 38, 37};
        }
    }

    public static class RequestIDs {
        public static final short setBassValue = 4;
        public static final short setTrebleValue = 13;
        public static final short setBalanceValue = 3;
        public static final short setFaderValue = 5;
        public static final short setSubwooferValue = 11;
        public static final short setSurroundValue = 12;
        public static final short setNoiseCompensationValue = 6;
        public static final short setThreeDModeValue = 36;
        public static final short setSoundShape = 41;
        public static final short setPresetPosition = 10;
        public static final short setPresetEQ = 35;
        public static final short setNotification_7 = 7;
        public static final short setNotification_9 = 9;
        public static final short setNotification_8 = 8;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{4, 13, 3, 5, 11, 12, 6, 36, 41, 10, 35, 7, 9, 8, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 14L;
        public static final long RequestIDs = 27L;
        public static final long ReplyIDs = 26L;
        public static final long SoundState = 28L;
        public static final long Amplifier = 15L;
        public static final long BassRange = 18L;
        public static final long BassValue = 19L;
        public static final long TrebleRange = 33L;
        public static final long TrebleValue = 34L;
        public static final long BalanceRange = 16L;
        public static final long BalanceValue = 17L;
        public static final long FaderRange = 20L;
        public static final long FaderValue = 21L;
        public static final long SubwooferRange = 29L;
        public static final long SubwooferValue = 30L;
        public static final long SurroundRange = 31L;
        public static final long SurroundValue = 32L;
        public static final long NoiseCompensationRange = 22L;
        public static final long NoiseCompensationValue = 23L;
        public static final long ThreeDModeRange = 39L;
        public static final long ThreeDModeValue = 40L;
        public static final long SoundShapeRange = 42L;
        public static final long SoundShapeValue = 43L;
        public static final long PresetPositionList = 25L;
        public static final long PresetPosition = 24L;
        public static final long PresetEQList = 38L;
        public static final long PresetEQ = 37L;
    }
}

