/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;
import org.dsi.ifc.base.DSIBase;

public interface DSIAndroidAuto
extends DSIBase {
    public static final String VERSION = "2.11.3";
    public static final int ATTR_NOWPLAYINGDATA = 3;
    public static final int ATTR_PLAYBACKSTATE = 4;
    public static final int ATTR_PLAYPOSITION = 5;
    public static final int ATTR_COVERARTURL = 6;
    public static final int ATTR_TELEPHONYSTATE = 7;
    public static final int ATTR_CALLSTATE = 8;
    public static final int ATTR_NAVIGATIONNEXTTURNEVENT = 11;
    public static final int ATTR_NAVIGATIONNEXTTURNDISTANCE = 12;
    public static final int RT_STARTSERVICE = 1001;
    public static final int RT_POSTBUTTONEVENT = 1003;
    public static final int RT_POSTTOUCHEVENT = 1004;
    public static final int RT_POSTROTARYEVENT = 1005;
    public static final int RT_REQUESTNIGHTMODE = 1007;
    public static final int RT_RESPONSEMODECHANGE = 1008;
    public static final int RT_SETMODE = 1009;
    public static final int RP_SETMODE = 2001;
    public static final int IN_REQUESTMODECHANGE = 3003;
    public static final int IN_SETEXTERNALDESTINATION = 3004;
    public static final int APPLICATIONID_UNKNOWN = 0;
    public static final int APPLICATIONID_PHONE = 1;
    public static final int APPLICATIONID_NAVIGATION = 2;
    public static final int APPLICATIONID_SPEECH = 3;
    public static final int APPLICATIONOWNER_UNKNOWN = 0;
    public static final int APPLICATIONOWNER_MAINUNIT = 1;
    public static final int APPLICATIONOWNER_DEVICE = 2;
    public static final int RESOURCE_UNKNOWN = 0;
    public static final int RESOURCE_VIDEO = 1;
    public static final int RESOURCE_MICROPHONE = 2;
    public static final int RESOURCE_AUDIO_MEDIA = 3;
    public static final int RESOURCE_AUDIO_GUIDANCE = 4;
    public static final int RESOURCE_AUDIO_SYSTEM_UI = 5;
    public static final int RESOURCE_AUDIO_TELEPHONY = 6;
    public static final int RESOURCEOWNER_UNDEFINED = 0;
    public static final int RESOURCEOWNER_MAINUNIT = 1;
    public static final int RESOURCEOWNER_DEVICE = 2;
    public static final int RESOURCETRANSFERTYPE_UNKNOWN = 0;
    public static final int RESOURCETRANSFERTYPE_TAKE = 1;
    public static final int RESOURCETRANSFERTYPE_UNTAKE = 2;
    public static final int RESOURCETRANSFERTYPE_BORROW = 3;
    public static final int RESOURCETRANSFERTYPE_UNBORROW = 4;
    public static final int BUTTON_UNKNOWN = 0;
    public static final int BUTTON_SELECT = 1;
    public static final int BUTTON_HOME = 2;
    public static final int BUTTON_BACK = 3;
    public static final int BUTTON_VOICE = 4;
    public static final int BUTTON_LEFT = 5;
    public static final int BUTTON_RIGHT = 6;
    public static final int BUTTON_UP = 7;
    public static final int BUTTON_DOWN = 8;
    public static final int BUTTON_SKIP_FORWARD = 9;
    public static final int BUTTON_SKIP_BACKWARD = 10;
    public static final int BUTTON_SEEK_FORWARD = 11;
    public static final int BUTTON_SEEK_BACKWARD = 12;
    public static final int BUTTON_ACCEPT_CALL = 13;
    public static final int BUTTON_END_CALL = 14;
    public static final int BUTTON_PLAY_PAUSE = 15;
    public static final int BUTTON_PRIMARY = 16;
    public static final int BUTTON_SECONDARY = 17;
    public static final int BUTTON_MEDIA = 18;
    public static final int BUTTON_NAVIGATION = 19;
    public static final int BUTTON_PHONE = 20;
    public static final int BUTTON_CAR = 21;
    public static final int BUTTON_PLAY = 22;
    public static final int BUTTON_PAUSE = 23;
    public static final int BUTTONSTATE_PRESSED = 0;
    public static final int BUTTONSTATE_RELEASED = 1;
    public static final int TOUCHSOURCE_TOUCHPAD = 0;
    public static final int TOUCHSOURCE_TOUCHSCREEN = 1;
    public static final int CALLSTATE_DISCONNECTED = 0;
    public static final int CALLSTATE_ACTIVE = 1;
    public static final int CALLSTATE_HOLDING = 2;
    public static final int CALLSTATE_CONNECTING = 3;
    public static final int CALLDIRECTION_INCOMING = 0;
    public static final int CALLDIRECTION_OUTGOING = 1;
    public static final int CALLDIRECTION_UNKNOWN = 2;
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
    public static final int REGISTRATIONSTATE_UNKNOWN = 0;
    public static final int REGISTRATIONSTATE_NOT_REGISTERED = 1;
    public static final int REGISTRATIONSTATE_SEARCHING = 2;
    public static final int REGISTRATIONSTATE_DENIED = 3;
    public static final int REGISTRATIONSTATE_REGISTRED_HOME = 4;
    public static final int REGISTRATIONSTATE_ROAMING = 5;
    public static final int REGISTRATIONSTATE_EMERGENCY_CALLS_ONLY = 6;
    public static final int POINTERACTION_DOWN = 0;
    public static final int POINTERACTION_UP = 1;
    public static final int POINTERACTION_MOVED = 2;
    public static final int POINTERACTION_POINTER_DOWN = 5;
    public static final int POINTERACTION_POINTER_UP = 6;
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

    public void postTouchEvent(int var1, TouchEvent[] var2, int var3, int var4);

    public void postRotaryEvent(int var1);

    public void setMode(Resource[] var1, AppState[] var2);

    public void responseModeChange(Resource[] var1, AppState[] var2);

    public void requestNightMode(boolean var1);
}

