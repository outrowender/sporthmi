/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

public interface ASIHMISyncCarSportChrono {
    public static final String IPL_COMM_UUID = "f6e30936-2963-4f91-ac52-c32bdac06478";
    public static final String IPL_COMM_INTERFACE_KEY = "206974b6-62b0-5276-9413-00d6e1532c16";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "2.0.00";

    public static interface Consts {
        public static final int SC_DATA_STATUS_DONE = 0;
        public static final int SC_DATA_STATUS_CONTINUE = 1;
        public static final int SC_DATA_STATUS_UNAVAILABLE = 2;
        public static final int SC_DATA_STATUS_ERROR = 255;
        public static final int SC_RECORD_START = 0;
        public static final int SC_RECORD_PAUSE = 1;
        public static final int SC_RECORD_NEXTLAP = 2;
        public static final int SC_RECORD_STOP = 3;
        public static final int SC_RECORD_SPLITTIME = 4;
        public static final int SC_RECORD_MODE_IDLE = 0;
        public static final int SC_RECORD_MODE_PAUSED = 1;
        public static final int SC_RECORD_MODE_RUNNING = 2;
        public static final int SC_RECORD_MODE_BUSY = 3;
        public static final int SC_TRACK_TRANSFER_OK = 0;
        public static final int SC_TRACK_TRANSFER_FULL = 1;
        public static final int SC_TRACK_TRANSFER_BLOCKED = 2;
        public static final int SC_TRACK_TRANSFER_OTHER_USER = 3;
        public static final int SC_TRACK_TRANSFER_RECORD_RUNNING = 4;
        public static final int SC_TRACK_TRANSFER_ERROR = 255;
        public static final int SC_TRANSFER_STATE_IDLE = 0;
        public static final int SC_TRANSFER_STATE_RUNNING = 1;
        public static final int SC_TRANSFER_STATE_PENDING = 2;
        public static final int SC_SET_REF_LAP_OK = 0;
        public static final int SC_SET_REF_LAP_ALREADY_SET = 1;
        public static final int SC_SET_REF_LAP_RECORDING_RUNNING = 2;
        public static final int SC_SET_REF_LAP_ERROR = 255;
        public static final int SC_SAVE_REF_LAP_OK = 0;
        public static final int SC_SAVE_REF_LAP_NO_SUCH_TRACK = 1;
        public static final int SC_SAVE_REF_LAP_NO_SUCH_LAP = 2;
        public static final int SC_SAVE_REF_LAP_ERROR = 255;
    }

    public static class ReplyIDs {
        public static final short responseRecordData = 7;
        public static final short responseTrackData = 9;
        public static final short responseInitTrackTransfer = 6;
        public static final short responseSetTrackData = 8;
        public static final short responseSetReferenceLap = 29;
        public static final short responseReferenceLapData = 27;
        public static final short responseSaveReferenceLap = 28;
        public static final short updateASIVersion = 15;
        public static final short updateRequestIDs = 20;
        public static final short updateReplyIDs = 19;
        public static final short updateSCVisibilityState = 21;
        public static final short updateActiveRecord = 16;
        public static final short updateActiveRecordData = 17;
        public static final short updateRecordMode = 18;
        public static final short updateTrackList = 22;
        public static final short updateTransferState = 23;
        public static final short updateRecordingTime = 25;
        public static final short updateRecordingRange = 24;
        public static final short updateSelectedReferenceLapUid = 33;
        public static final short updateReferenceLapList = 32;

        public static short[] getIDs() {
            return new short[]{7, 9, 6, 8, 29, 27, 28, 15, 20, 19, 21, 16, 17, 18, 22, 23, 25, 24, 33, 32};
        }
    }

    public static class RequestIDs {
        public static final short requestRecordData = 4;
        public static final short setRecord = 13;
        public static final short requestTrackData = 5;
        public static final short initTrackTransfer = 3;
        public static final short setTrackData = 14;
        public static final short setReferenceLap = 31;
        public static final short requestReferenceLapData = 26;
        public static final short saveReferenceLap = 30;
        public static final short setNotification_10 = 10;
        public static final short setNotification_12 = 12;
        public static final short setNotification_11 = 11;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{4, 13, 5, 3, 14, 31, 26, 30, 10, 12, 11, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 15L;
        public static final long RequestIDs = 20L;
        public static final long ReplyIDs = 19L;
        public static final long SCVisibilityState = 21L;
        public static final long ActiveRecord = 16L;
        public static final long ActiveRecordData = 17L;
        public static final long RecordMode = 18L;
        public static final long TrackList = 22L;
        public static final long TransferState = 23L;
        public static final long RecordingTime = 25L;
        public static final long RecordingRange = 24L;
        public static final long SelectedReferenceLapUid = 33L;
        public static final long ReferenceLapList = 32L;
    }
}

