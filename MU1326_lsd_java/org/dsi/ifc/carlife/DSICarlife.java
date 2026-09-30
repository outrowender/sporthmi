/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public interface DSICarlife
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int ATTR_CALLSTATE = 1;
    public static final int ATTR_NOWPLAYINGDATA = 2;
    public static final int ATTR_PLAYBACKSTATE = 3;
    public static final int ATTR_PLAYMODESTATE = 4;
    public static final int ATTR_PLAYPOSITION = 5;
    public static final int ATTR_COVERARTURL = 6;
    public static final int ATTR_NAVIGATIONNEXTTURNINFO = 7;
    public static final int ATTR_DEVICEINFO = 8;
    public static final int ATTR_VIDEOAVAILABLE = 9;
    public static final int RT_STARTSERVICE = 1000;
    public static final int RT_POSTBUTTONEVENT = 1001;
    public static final int RT_POSTTOUCHEVENT = 1002;
    public static final int RT_POSTROTARYEVENT = 1003;
    public static final int RT_SETMODE = 1004;
    public static final int RT_REQUESTNIGHTMODE = 1005;
    public static final int RT_POSTCHARACTEREVENT = 1006;
    public static final int RT_RESPONSEMODECHANGE = 1007;
    public static final int RP_RESPONSESETMODE = 2000;
    public static final int IN_REQUESTMODECHANGE = 3000;
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

    public void startService(ServiceConfiguration var1);

    public void postButtonEvent(int var1, int var2);

    public void postTouchEvent(int var1, TouchEvent[] var2, int var3);

    public void postRotaryEvent(int var1);

    public void postCharacterEvent(int var1, String[] var2);

    public void setMode(Resource[] var1, AppState[] var2);

    public void requestNightMode(boolean var1);

    public void responseModeChange(Resource[] var1, AppState[] var2);
}

