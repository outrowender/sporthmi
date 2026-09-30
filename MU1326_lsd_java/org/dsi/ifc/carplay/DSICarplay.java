/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public interface DSICarplay
extends DSIBase {
    public static final String VERSION = "2.11.10";
    public static final int ATTR_DEVICEINFO = 2;
    public static final int ATTR_NOWPLAYINGDATA = 3;
    public static final int ATTR_PLAYBACKSTATE = 4;
    public static final int ATTR_PLAYPOSITION = 5;
    public static final int ATTR_COVERARTURL = 6;
    public static final int ATTR_TELEPHONYSTATE = 7;
    public static final int ATTR_CALLSTATE = 8;
    public static final int ATTR_MODE = 9;
    public static final int ATTR_TEXTINPUTSTATE = 10;
    public static final int ATTR_MAINAUDIOTYPE = 12;
    public static final int RT_STARTSERVICE = 1000;
    public static final int RT_POSTBUTTONEVENT = 1002;
    public static final int RT_POSTTOUCHEVENT = 1003;
    public static final int RT_POSTROTARYEVENT = 1004;
    public static final int RT_RESPONSEBTDEACTIVATION = 1005;
    public static final int RT_REQUESTUI = 1006;
    public static final int RT_REQUESTMODECHANGE = 1007;
    public static final int RT_POSTCHARACTEREVENT = 1009;
    public static final int RT_REQUESTNIGHTMODE = 1011;
    public static final int RT_REQUESTSIRIACTION = 1012;
    public static final int RT_RESPONSEUPDATEMODE = 1013;
    public static final int RT_RESPONSEUPDATEMAINAUDIOTYPE = 1014;
    public static final int RT_REQUESTUI2 = 1015;
    public static final int RP_RESPONSEMODECHANGE = 2000;
    public static final int IN_REQUESTBTDEACTIVATION = 3001;
    public static final int IN_DUCKAUDIO = 3002;
    public static final int IN_UNDUCKAUDIO = 3003;
    public static final int IN_OEMAPPSELECTED = 3004;
    public static final int CHANGEMODERESULT_OK = 0;
    public static final int CHANGEMODERESULT_REJECTED = 1;
    public static final int SPEECHMODE_UNKNOWN = 0;
    public static final int SPEECHMODE_NONE = 1;
    public static final int SPEECHMODE_SPEAKING = 2;
    public static final int SPEECHMODE_RECOGNIZING = 3;
    public static final int APPLICATIONID_UNKNOWN = 0;
    public static final int APPLICATIONID_PHONE = 1;
    public static final int APPLICATIONID_NAVIGATION = 2;
    public static final int APPLICATIONID_SPEECH = 3;
    public static final int APPLICATIONOWNER_UNKNOWN = 0;
    public static final int APPLICATIONOWNER_MAINUNIT = 1;
    public static final int APPLICATIONOWNER_DEVICE = 2;
    public static final int RESOURCE_UNKNOWN = 0;
    public static final int RESOURCE_MAIN_AUDIO = 1;
    public static final int RESOURCE_MAIN_SCREEN = 2;
    public static final int RESOURCEOWNER_UNDEFINED = 0;
    public static final int RESOURCEOWNER_MAINUNIT = 1;
    public static final int RESOURCEOWNER_DEVICE = 2;
    public static final int RESOURCETRANSFERTYPE_UNKNOWN = 0;
    public static final int RESOURCETRANSFERTYPE_TAKE = 1;
    public static final int RESOURCETRANSFERTYPE_UNTAKE = 2;
    public static final int RESOURCETRANSFERTYPE_BORROW = 3;
    public static final int RESOURCETRANSFERTYPE_UNBORROW = 4;
    public static final int RESOURCETRANSFERPRIORITY_UNKNOWN = 0;
    public static final int RESOURCETRANSFERPRIORITY_USER_INITIATED = 1;
    public static final int RESOURCETRANSFERPRIORITY_NICE_TO_HAVE = 2;
    public static final int RESOURCESHARINGPOLICY_UKNOWN = 0;
    public static final int RESOURCESHARINGPOLICY_ALWAYS = 1;
    public static final int RESOURCESHARINGPOLICY_USER_INITIATED = 2;
    public static final int RESOURCESHARINGPOLICY_NEVER = 3;
    public static final int UI_UNKNOWN = 0;
    public static final int UI_HOME = 1;
    public static final int UI_PHONE = 2;
    public static final int UI_NAVIGATION = 3;
    public static final int UI_MEDIA = 4;
    public static final int UI_MEDIA_NOWPLAYING = 5;
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
    public static final int BUTTON_PAUSE = 18;
    public static final int BUTTON_PLAY = 19;
    public static final int BUTTON_FLASH_CALL = 20;
    public static final int BUTTONSTATE_PRESSED = 0;
    public static final int BUTTONSTATE_RELEASED = 1;
    public static final int TOUCHSOURCE_TOUCHPAD = 0;
    public static final int TOUCHSOURCE_TOUCHSCREEN = 1;
    public static final int TEXTINPUTSTATE_INACTIVE = 0;
    public static final int TEXTINPUTSTATE_ACTIVE = 1;
    public static final int SCREENRESOLUTION_800_BY_480 = 0;
    public static final int SCREENRESOLUTION_960_BY_540 = 1;
    public static final int SCREENRESOLUTION_1024_BY_480 = 2;
    public static final int SCREENRESOLUTION_CUSTOM = 3;
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
    public static final int SIGNALSTRENGTH_0_BARS_NO_SERVICE = 0;
    public static final int SIGNALSTRENGTH_1_BAR = 1;
    public static final int SIGNALSTRENGTH_2_BARS = 2;
    public static final int SIGNALSTRENGTH_3_BARS = 3;
    public static final int SIGNALSTRENGTH_4_BARS = 4;
    public static final int SIGNALSTRENGTH_5_BARS = 5;
    public static final int REGISTRATIONSTATE_UNKNOWN = 0;
    public static final int REGISTRATIONSTATE_NOT_REGISTERED = 1;
    public static final int REGISTRATIONSTATE_SEARCHING = 2;
    public static final int REGISTRATIONSTATE_DENIED = 3;
    public static final int REGISTRATIONSTATE_REGISTRED_HOME = 4;
    public static final int REGISTRATIONSTATE_ROAMING = 5;
    public static final int REGISTRATIONSTATE_EMERGENCY_CALLS_ONLY = 6;
    public static final int SIRIACTION_PREWARM = 0;
    public static final int SIRIACTION_START = 1;
    public static final int SIRIACTION_STOP = 2;
    public static final int AUDIOTYPE_NONE = 0;
    public static final int AUDIOTYPE_ALERT = 1;
    public static final int AUDIOTYPE_MEDIA = 2;
    public static final int AUDIOTYPE_TELEPHONY = 3;
    public static final int AUDIOTYPE_SPEECHRECOGNITION = 4;
    public static final int INPUTFEATURE_KNOB = 1;
    public static final int INPUTFEATURE_LOWFIDELITYTOUCH = 2;
    public static final int INPUTFEATURE_HIGHFIDELITYTOUCH = 4;
    public static final int INPUTFEATURE_TOUCHPAD = 8;

    public void startService(ServiceConfiguration var1);

    public void postButtonEvent(int var1, int var2);

    public void postTouchEvent(int var1, int var2, TouchEvent[] var3);

    public void postRotaryEvent(int var1);

    public void postCharacterEvent(int var1, String[] var2);

    public void requestModeChange(ResourceRequest[] var1, AppStateRequest[] var2, String var3);

    public void responseUpdateMode(Resource[] var1, AppState[] var2);

    public void responseBTDeactivation();

    public void requestUI(int var1);

    public void requestNightMode(boolean var1);

    public void requestSIRIAction(int var1);

    public void responseUpdateMainAudioType(int var1);

    public void requestUI2(String var1);
}

