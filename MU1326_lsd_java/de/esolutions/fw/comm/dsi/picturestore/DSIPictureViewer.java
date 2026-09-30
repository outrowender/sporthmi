/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

public interface DSIPictureViewer {
    public static final String IPL_COMM_UUID = "0fc52f10-dbb3-5bf0-b0eb-e432f4c5622f";
    public static final String IPL_COMM_INTERFACE_KEY = "aecd60cb-98f6-5343-9891-115a3d0e8843";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public static interface Consts {
        public static final String VERSION = "2.11.11";
        public static final int PICTUREVIEWERRESULT_OK = 0;
        public static final int PICTUREVIEWERRESULT_ERROR = 1;
        public static final int VIEWERMODE_PICTURESTORE = 0;
        public static final int VIEWERMODE_FILEBROWSER = 1;
        public static final int SELECTIONMODE_OFF = 0;
        public static final int SELECTIONMODE_SINGLE = 1;
        public static final int SELECTIONMODE_MULTI = 2;
        public static final int FILETYPE_UNKNOWNFILE = 0;
        public static final int FILETYPE_FOLDER = 1;
        public static final int FILETYPE_IMAGE = 2;
        public static final int SCROLLMODE_SCROLLMODE_NORMAL = 0;
        public static final int SCROLLMODE_SCROLLMODE_FAST = 1;
        public static final int VIEWERSTATE_STATE_UNKNOWN = 0;
        public static final int VIEWERSTATE_STATE_INITIALIZED = 1;
        public static final int VIEWERSTATE_STATE_ACTIVE = 2;
        public static final int VIEWERSTATE_STATE_SCROLLING = 3;
        public static final int VIEWERSTATE_STATE_SELECTING = 4;
        public static final int VIEWERSTATE_STATE_ANIMATION_CENTERVIEW = 5;
        public static final int VIEWERSTATE_STATE_ANIMATION_SIDEVIEW = 6;
        public static final int ANIMATIONTYPE_CENTERVIEW = 0;
        public static final int ANIMATIONTYPE_SIDEVIEW = 1;
        public static final int ANIMATIONMODE_ANIMATIONMODE_STILL = 0;
        public static final int ANIMATIONMODE_ANIMATIONMODE_ANIMATE = 1;
        public static final int IMPORTFILTER_IMPORT_SOURCE_UNDEFINED = 1;
        public static final int IMPORTFILTER_IMPORT_SOURCE_USB = 2;
        public static final int IMPORTFILTER_IMPORT_SOURCE_SDCARD = 4;
        public static final int IMPORTFILTER_IMPORT_SOURCE_ONLINE = 8;
        public static final int VIEWFILTER_DATETYPE_IMPORTDATE = 0;
        public static final int VIEWFILTER_DATETYPE_CREATIONDATE = 1;
        public static final int SORTING_IMPORTDATE_ASCENDING = 0;
        public static final int SORTING_IMPORTDATE_DESCENDING = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

