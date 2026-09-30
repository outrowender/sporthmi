/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife;

public interface DSICarlife {
    public static final String IPL_COMM_UUID = "cb507d49-a334-5d1c-a54e-98b3813496f3";
    public static final String IPL_COMM_INTERFACE_KEY = "d18a17d8-40d1-5e95-ae5e-3766d4fdba21";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public static interface Consts {
        public static final String VERSION = "2.11.2";
        public static final int APPLICATIONID_UNKNOWN = 0;
        public static final int APPLICATIONID_NAVIGATION = 1;
        public static final int APPLICATIONID_SPEECH = 2;
        public static final int APPLICATIONOWNER_UNKNOWN = 0;
        public static final int APPLICATIONOWNER_MAINUNIT = 1;
        public static final int APPLICATIONOWNER_DEVICE = 2;
        public static final int CALLSTATE_DISCONNECTED = 0;
        public static final int CALLSTATE_ACTIVE = 1;
        public static final int CALLSTATE_HOLDING = 2;
        public static final int CALLSTATE_CONNECTING = 3;
        public static final int CALLDIRECTION_INCOMING = 0;
        public static final int CALLDIRECTION_OUTGOING = 1;
        public static final int CALLDIRECTION_UNKNOWN = 2;
        public static final int RESOURCE_UNKNOWN = 0;
        public static final int RESOURCE_VIDEO = 1;
        public static final int RESOURCE_AUDIO_MICROPHONE = 2;
        public static final int RESOURCE_AUDIO_MEDIA = 3;
        public static final int RESOURCE_AUDIO_TTS = 4;
        public static final int RESOURCEOWNER_UNKNOWN = 0;
        public static final int RESOURCEOWNER_MAINUNIT = 1;
        public static final int RESOURCEOWNER_DEVICE = 2;
        public static final int PLAYBACKSTATE_STOPPED = 0;
        public static final int PLAYBACKSTATE_PLAYING = 1;
        public static final int PLAYBACKSTATE_PAUSED = 2;
        public static final int PLAYBACKSTATE_SEEKFORWARD = 3;
        public static final int PLAYBACKSTATE_SEEKBACKWARD = 4;
        public static final int PLAYBACKMODESHUFFLE_OFF = 0;
        public static final int PLAYBACKMODESHUFFLE_SONGS = 1;
        public static final int PLAYBACKMODESHUFFLE_ALBUMS = 2;
        public static final int PLAYBACKMODEREPEAT_OFF = 0;
        public static final int PLAYBACKMODEREPEAT_ONE = 1;
        public static final int PLAYBACKMODEREPEAT_ALL = 2;
        public static final int BUTTON_UNKNOWN = 0;
        public static final int BUTTON_SELECT = 1;
        public static final int BUTTON_BACK = 2;
        public static final int BUTTON_JS_LEFT = 3;
        public static final int BUTTON_JS_RIGHT = 4;
        public static final int BUTTON_JS_UP = 5;
        public static final int BUTTON_JS_DOWN = 6;
        public static final int BUTTON_JS_SE = 7;
        public static final int BUTTON_JS_SW = 8;
        public static final int BUTTON_JS_NE = 9;
        public static final int BUTTON_JS_NW = 10;
        public static final int BUTTON_EAST = 11;
        public static final int BUTTON_WEST = 12;
        public static final int BUTTON_SKIP_FORWARD = 13;
        public static final int BUTTON_SKIP_BACKWARD = 14;
        public static final int BUTTON_SEEK_FORWARD = 15;
        public static final int BUTTON_SEEK_BACKWARD = 16;
        public static final int BUTTON_PLAY_PAUSE = 17;
        public static final int BUTTON_PLAY = 18;
        public static final int BUTTON_PAUSE = 19;
        public static final int BUTTON_START_SPEECH = 20;
        public static final int BUTTON_STOP_SPEECH = 21;
        public static final int BUTTONSTATE_PRESSED = 0;
        public static final int BUTTONSTATE_RELEASED = 1;
        public static final int TOUCHSOURCE_TOUCHPAD = 0;
        public static final int TOUCHSOURCE_TOUCHSCREEN = 1;
        public static final int POINTERACTION_UNKNOWN = 0;
        public static final int POINTERACTION_DOWN = 1;
        public static final int POINTERACTION_MOVE = 2;
        public static final int POINTERACTION_UP = 3;
        public static final int POINTERACTION_ROTATE = 4;
        public static final int POINTERACTION_GESTURE = 5;
        public static final int NAVIGATIONTURNSIDE_UNSPECIFIED = 0;
        public static final int NAVIGATIONTURNSIDE_LEFT = 1;
        public static final int NAVIGATIONTURNSIDE_RIGHT = 2;
        public static final int NAVIGATIONTURNEVENT_UNKNOWN = 0;
        public static final int NAVIGATIONTURNEVENT_DEPART = 1;
        public static final int NAVIGATIONTURNEVENT_NAME_CHANGE = 2;
        public static final int NAVIGATIONTURNEVENT_SLIGHT_TURN = 3;
        public static final int NAVIGATIONTURNEVENT_TURN = 4;
        public static final int NAVIGATIONTURNEVENT_SHARP_TURN = 5;
        public static final int NAVIGATIONTURNEVENT_U_TURN = 6;
        public static final int NAVIGATIONTURNEVENT_ON_RAMP = 7;
        public static final int NAVIGATIONTURNEVENT_OFF_RAMP = 8;
        public static final int NAVIGATIONTURNEVENT_FORK = 9;
        public static final int NAVIGATIONTURNEVENT_MERGE = 10;
        public static final int NAVIGATIONTURNEVENT_ROUNDABOUT_ENTER = 11;
        public static final int NAVIGATIONTURNEVENT_ROUNDABOUT_EXIT = 12;
        public static final int NAVIGATIONTURNEVENT_ROUNDABOUT_ENTER_AND_EXIT = 13;
        public static final int NAVIGATIONTURNEVENT_STRAIGHT = 14;
        public static final int NAVIGATIONTURNEVENT_FERRY_BOAT = 16;
        public static final int NAVIGATIONTURNEVENT_FERRY_TRAIN = 17;
        public static final int NAVIGATIONTURNEVENT_DESTINATION = 19;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

