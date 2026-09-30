/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

public interface ASIHMISyncRadio {
    public static final String IPL_COMM_UUID = "3a42bf26-0f99-40c8-bc3a-452fc046e0ca";
    public static final String IPL_COMM_INTERFACE_KEY = "33f94559-8b21-58d2-8753-54f393719e53";
    public static final String IPL_COMM_INTERFACE_VERSION = "3.3.11";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int BAND_FM = 1;
        public static final int BAND_AM = 4;
        public static final int BAND_DAB = 5;
        public static final int BAND_SDARS = 7;
        public static final int BAND_TI = 10;
        public static final int BAND_UNI = 11;
        public static final int SEEK_MODE_UP = 1;
        public static final int SEEK_MODE_DOWN = 2;
        public static final int SEEK_MODE_ABORT = 3;
        public static final int SEEK_STATE_NOT_SUPPORTED = 0;
        public static final int SEEK_STATE_ACTIVE = 1;
        public static final int SEEK_STATE_INACTIVE = 2;
        public static final int AUDIOSTATUS_ANALOG = 1;
        public static final int AUDIOSTATUS_DIGITAL = 2;
        public static final int AUDIOSTATUS_MUTE = 3;
        public static final int AUDIOSTATUS_ANALOG_BALLGAME = 4;
        public static final int AUDIOSTATUS_DIGITAL_AVAILABLE = 5;
        public static final int LAYER0 = 0;
        public static final int LAYER1 = 1;
        public static final int LAYER2 = 2;
    }

    public static class ReplyIDs {
        public static final short stationDetailsUpdated = 20;
        public static final short updateASIVersion = 11;
        public static final short updateRequestIDs = 18;
        public static final short updateReplyIDs = 17;
        public static final short updateBandList = 14;
        public static final short updateActiveBand = 12;
        public static final short updateRadioStationList = 22;
        public static final short updateActiveStation = 21;
        public static final short updateSeekStatus = 16;
        public static final short updateWavebands = 19;

        public static short[] getIDs() {
            return new short[]{20, 11, 18, 17, 14, 12, 22, 21, 16, 19};
        }
    }

    public static class RequestIDs {
        public static final short selectStation = 6;
        public static final short selectBand = 5;
        public static final short seekStation = 4;
        public static final short enableStationDetails = 3;
        public static final short setNotification_7 = 7;
        public static final short setNotification_9 = 9;
        public static final short setNotification_8 = 8;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{6, 5, 4, 3, 7, 9, 8, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 11L;
        public static final long RequestIDs = 18L;
        public static final long ReplyIDs = 17L;
        public static final long BandList = 14L;
        public static final long ActiveBand = 12L;
        public static final long RadioStationList = 22L;
        public static final long ActiveStation = 21L;
        public static final long SeekStatus = 16L;
        public static final long Wavebands = 19L;
    }
}

