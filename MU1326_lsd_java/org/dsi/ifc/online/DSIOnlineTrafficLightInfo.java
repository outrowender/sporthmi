/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlineTrafficLightInfo
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int ATTR_TRAFFICLIGHTINFO = 1;
    public static final int ATTR_TRAFFICLIGHTSPEED = 2;
    public static final int ATTR_TRAFFICLIGHTTIME = 3;
    public static final int TRAFFICLIGHT_NONE = 0;
    public static final int TRAFFICLIGHT_GREEN = 1;
    public static final int TRAFFICLIGHT_YELLOW = 2;
    public static final int TRAFFICLIGHT_RED = 3;
    public static final int TRAFFICLIGHT_GRAY = 4;
    public static final int TRAFFICLIGHT_SYNCHRONISED_LIGHTS = 5;
    public static final int TRAFFICLIGHTLEVEL_NONE = 0;
    public static final int TRAFFICLIGHTLEVEL_INFO = 1;
    public static final int TRAFFICLIGHTLEVEL_WARNING = 2;
    public static final int TRAFFICLIGHTLAYOUT_VERTICALREDTOP = 0;
    public static final int TRAFFICLIGHTLAYOUT_HORIZONTALREDLEFT = 1;
    public static final int TRAFFICLIGHTLAYOUT_HORIZONTALREDRIGHT = 2;
    public static final int TIMETOGREENSPECIAL_SMALLERTHAN1MIN = 250;
    public static final int TIMETOGREENSPECIAL_GREATERTHAN1MIN = 251;
    public static final int TIMETOGREENSPECIAL_GREATERTHAN2MIN = 252;
    public static final int TIMETOGREENSPECIAL_GREATERTHAN3MIN = 253;
    public static final int TIMETOGREENSPECIAL_GREATERTHAN4MIN = 254;
    public static final int TIMETOGREENSPECIAL_GREATERTHAN5MIN = 255;
    public static final int DIRECTION_STRAIGHT = 0;
    public static final int DIRECTION_SLIGHT_LEFT = 32;
    public static final int DIRECTION_LEFT = 64;
    public static final int DIRECTION_SHARP_LEFT = 96;
    public static final int DIRECTION_UTURN_LEFT = 114;
    public static final int DIRECTION_SLIGHT_RIGHT = 224;
    public static final int DIRECTION_RIGHT = 192;
    public static final int DIRECTION_SHARP_RIGHT = 160;
    public static final int DIRECTION_UTURN_RIGHT = 146;
    public static final int DIRECTION_INVALID = 255;
}

