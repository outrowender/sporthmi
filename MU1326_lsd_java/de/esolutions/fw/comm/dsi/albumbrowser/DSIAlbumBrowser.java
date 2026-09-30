/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.albumbrowser;

public interface DSIAlbumBrowser {
    public static final String IPL_COMM_UUID = "2af5bc21-5cbd-5430-a909-9cc19692a1d2";
    public static final String IPL_COMM_INTERFACE_KEY = "185c4ed3-4d8a-5abf-933a-db6607faeebe";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.6";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.6";

    public static interface Consts {
        public static final String VERSION = "2.11.6";
        public static final int BROWSERSTATE_STATE_UNKNOWN = 0;
        public static final int BROWSERSTATE_STATE_INITIALIZED = 1;
        public static final int BROWSERSTATE_STATE_ACTIVE = 2;
        public static final int BROWSERSTATE_STATE_SCROLLING = 3;
        public static final int BROWSERSTATE_STATE_SELECTING = 4;
        public static final int BROWSERSTATE_STATE_ANIMATION_ENTRY = 5;
        public static final int BROWSERSTATE_STATE_PREVIEW = 6;
        public static final int BROWSERSTATE_STATE_ANIMATION_OPEN = 7;
        public static final int BROWSERSTATE_STATE_ANIMATION_CLOSE = 8;
        public static final int BROWSERSTATE_STATE_ANIMATION_PREV_OPEN = 9;
        public static final int BROWSERSTATE_STATE_ANIMATION_PREVSCROLLING = 10;
        public static final int BROWSERSTATE_STATE_SINGLE = 11;
        public static final int BROWSERSTATE_STATE_ANIMATION_PREV_CLOSE = 12;
        public static final int SCROLLMODE_SCROLLMODE_NORMAL = 0;
        public static final int SCROLLMODE_SCROLLMODE_FAST = 1;
        public static final int ANIMATIONMODE_ANIMATIONMODE_STILL = 0;
        public static final int ANIMATIONMODE_ANIMATIONMODE_ANIMATE = 1;
        public static final int ALBUMFLAGS_ENTRYFLAG_UNKNOWN_ALBUM = 1;
        public static final int ALBUMFLAGS_ENTRYFLAG_UNKNOWN_ARTIST = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

