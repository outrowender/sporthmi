/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

public interface ASIHMISyncAudio {
    public static final String IPL_COMM_UUID = "0f18f39e-8ba2-4652-9298-39ffbea5b9fe";
    public static final String IPL_COMM_INTERFACE_KEY = "f10bdb8c-3351-5035-a073-26fb210dd987";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.3.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int AUDIOCONTEXT_JOIN = -1;
        public static final int AUDIOCONTEXT_UNJOIN = -2;
        public static final int AUDIOCONTEXT_NONE = 0;
        public static final int AUDIOCONTEXT_A2LS = 1;
        public static final int AUDIOCONTEXT_RADIO = 2;
        public static final int AUDIOCONTEXT_MEDIA = 3;
        public static final int AUDIOCONTEXT_TV = 4;
        public static final int AUDIOSTATE_IN_CHANGE = 0;
        public static final int AUDIOSTATE_READY = 1;
        public static final int AUDIOSTATE_A2LS_PENDING = 2;
        public static final int VOLUMELOCKSTATE_INACTIVE = 0;
        public static final int VOLUMELOCKSTATE_ACTIVE = 1;
        public static final int RESULTCODE_A2LS_OK = 0;
        public static final int RESULTCODE_A2LS_ERROR = 1;
        public static final int RESULTCODE_A2LS_UNAVAILABLE = 2;
        public static final int RESULTCODE_A2LS_CONNECTED = 3;
        public static final int AUDIBLESTATE_AUDIBLE = 0;
        public static final int AUDIBLESTATE_NAV_ANNOUNCEMENT = 1;
        public static final int AUDIBLESTATE_CALL = 2;
        public static final int AUDIBLESTATE_SDS = 4;
        public static final int AUDIBLESTATE_TA = 8;
        public static final int AUDIBLESTATE_APS = 16;
        public static final int AUDIBLESTATE_STANDBY = 32;
        public static final int AUDIBLESTATE_OTHER = 0x100000;
    }

    public static class ReplyIDs {
        public static final short responseEnableA2LS = 7;
        public static final short updateASIVersion = 13;
        public static final short updateRequestIDs = 20;
        public static final short updateReplyIDs = 19;
        public static final short updateAudioContext = 14;
        public static final short updateFrontAudioContext = 15;
        public static final short updateVolumeLockState = 25;
        public static final short updateA2LSState = 23;
        public static final short updateVolumeRange = 18;
        public static final short updateVolume = 17;
        public static final short updateAudibleState = 24;

        public static short[] getIDs() {
            return new short[]{7, 13, 20, 19, 14, 15, 25, 23, 18, 17, 24};
        }
    }

    public static class RequestIDs {
        public static final short setAudioContext = 8;
        public static final short forceFrontAudioContext = 21;
        public static final short requestEnableA2LS = 22;
        public static final short disableA2LS = 4;
        public static final short setVolume = 12;
        public static final short increaseVolume = 6;
        public static final short decreaseVolume = 3;
        public static final short setNotification_9 = 9;
        public static final short setNotification_11 = 11;
        public static final short setNotification_10 = 10;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{8, 21, 22, 4, 12, 6, 3, 9, 11, 10, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 13L;
        public static final long RequestIDs = 20L;
        public static final long ReplyIDs = 19L;
        public static final long AudioContext = 14L;
        public static final long FrontAudioContext = 15L;
        public static final long VolumeLockState = 25L;
        public static final long A2LSState = 23L;
        public static final long VolumeRange = 18L;
        public static final long Volume = 17L;
        public static final long AudibleState = 24L;
    }
}

