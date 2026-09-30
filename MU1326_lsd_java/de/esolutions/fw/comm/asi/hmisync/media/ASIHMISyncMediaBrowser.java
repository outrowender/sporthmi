/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

public interface ASIHMISyncMediaBrowser {
    public static final String IPL_COMM_UUID = "04780aa8-9662-4220-9900-4a1e11586d28";
    public static final String IPL_COMM_INTERFACE_KEY = "8f2aa3cc-0c22-5ffa-83d3-4e78162cf3e6";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.2.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int BROWSEMODE_RAW = 0;
        public static final int BROWSEMODE_DATABASE = 1;
        public static final int SELECTIONTYPE_INDEX = 0;
        public static final int SELECTIONTYPE_ALL = 1;
    }

    public static class ReplyIDs {
        public static final short responseChangeFolder = 9;
        public static final short responseAddSelection = 8;
        public static final short responseList = 10;
        public static final short updateASIVersion = 15;
        public static final short updateRequestIDs = 23;
        public static final short updateReplyIDs = 22;
        public static final short updateActiveSlot = 16;
        public static final short updateBrowseMode = 18;
        public static final short updateDatabaseMode = 19;
        public static final short updateRawMode = 21;
        public static final short updateBrowseFolder = 17;
        public static final short updateListSize = 20;

        public static short[] getIDs() {
            return new short[]{9, 8, 10, 15, 23, 22, 16, 18, 19, 21, 17, 20};
        }
    }

    public static class RequestIDs {
        public static final short activate = 0;
        public static final short deactivate = 6;
        public static final short setBrowseMode = 11;
        public static final short changeFolder = 2;
        public static final short addSelection = 1;
        public static final short requestList = 7;
        public static final short setNotification_12 = 12;
        public static final short setNotification_14 = 14;
        public static final short setNotification_13 = 13;
        public static final short clearNotification_3 = 3;
        public static final short clearNotification_5 = 5;
        public static final short clearNotification_4 = 4;

        public static short[] getIDs() {
            return new short[]{0, 6, 11, 2, 1, 7, 12, 14, 13, 3, 5, 4};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 15L;
        public static final long RequestIDs = 23L;
        public static final long ReplyIDs = 22L;
        public static final long ActiveSlot = 16L;
        public static final long BrowseMode = 18L;
        public static final long DatabaseMode = 19L;
        public static final long RawMode = 21L;
        public static final long BrowseFolder = 17L;
        public static final long ListSize = 20L;
    }
}

