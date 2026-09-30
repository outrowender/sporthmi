/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;
import org.dsi.ifc.base.DSIBase;

public interface DSIAndroidAuto2
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int ATTR_CALLSTATE = 1;
    public static final int ATTR_TELEPHONYSTATE = 2;
    public static final int ATTR_NOWPLAYINGDATA = 3;
    public static final int ATTR_PLAYBACKSTATE = 4;
    public static final int ATTR_PLAYPOSITION = 5;
    public static final int ATTR_COVERARTURL = 6;
    public static final int ATTR_NAVIGATIONNEXTTURNEVENT = 7;
    public static final int ATTR_NAVIGATIONNEXTTURNDISTANCE = 8;
    public static final int RT_VIDEOFOCUSNOTIFICATION = 1001;
    public static final int RT_AUDIOFOCUSNOTIFICATION = 1002;
    public static final int RT_MICROPHONENOTIFICATION = 1003;
    public static final int RT_NAVFOCUSNOTIFICATION = 1004;
    public static final int RT_STARTSERVICE = 1005;
    public static final int RT_POSTBUTTONEVENT = 1006;
    public static final int RT_POSTTOUCHEVENT = 1007;
    public static final int RT_POSTROTARYEVENT = 1008;
    public static final int RT_SETNIGHTMODE = 1009;
    public static final int RT_BLUETOOTHPAIRINGRESPONSE = 1010;
    public static final int RT_BLUETOOTHAUTHENTICATIONDATA = 1011;
    public static final int IN_VIDEOFOCUSREQUESTNOTIFICATION = 3001;
    public static final int IN_VIDEOAVAILABLE = 3002;
    public static final int IN_AUDIOFOCUSREQUESTNOTIFICATION = 3003;
    public static final int IN_AUDIOAVAILABLE = 3004;
    public static final int IN_VOICESESSIONNOTIFICATION = 3005;
    public static final int IN_MICROPHONEREQUESTNOTIFICATION = 3006;
    public static final int IN_NAVFOCUSREQUESTNOTIFICATION = 3007;
    public static final int IN_SETEXTERNALDESTINATION = 3008;
    public static final int IN_BLUETOOTHPAIRINGREQUEST = 3009;

    public void videoFocusNotification(int var1, boolean var2);

    public void audioFocusNotification(int var1, boolean var2);

    public void microphoneNotification(int var1, boolean var2);

    public void navFocusNotification(int var1, boolean var2);

    public void startService(ServiceConfiguration var1);

    public void postButtonEvent(int var1, int var2);

    public void postTouchEvent(int var1, TouchEvent[] var2, int var3, int var4);

    public void postRotaryEvent(int var1);

    public void setNightMode(boolean var1);

    public void bluetoothPairingResponse(boolean var1);

    public void bluetoothAuthenticationData(String var1);
}

