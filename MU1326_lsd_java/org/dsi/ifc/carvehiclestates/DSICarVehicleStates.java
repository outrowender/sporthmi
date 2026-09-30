/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.base.DSIBase;

public interface DSICarVehicleStates
extends DSIBase {
    public static final String VERSION = "2.11.28";
    public static final int ATTR_OILLEVELVIEWOPTION = 1;
    public static final int ATTR_OILLEVELDATA = 2;
    public static final int ATTR_VINVIEWOPTION = 3;
    public static final int ATTR_VINDATA = 4;
    public static final int ATTR_KEYVIEWOPTION = 5;
    public static final int ATTR_KEYDATA = 6;
    public static final int ATTR_DRVSCHOOLSYSTEM = 10;
    public static final int ATTR_VEHICLEINFOVIEWOPTIONS = 11;
    public static final int ATTR_DYNAMICVEHICLEINFOHIGHFREQUENTVIEWOPTIONS = 12;
    public static final int ATTR_DYNAMICVEHICLEINFOMIDFREQUENTVIEWOPTIONS = 13;
    public static final int ATTR_DYNAMICVEHICLEINFOHIGHFREQUENT = 14;
    public static final int ATTR_DYNAMICVEHICLEINFOMIDFREQUENT = 15;
    public static final int ATTR_SEMISTATICVEHICLEDATAVIEWOPTIONS = 16;
    public static final int ATTR_SEMISTATICVEHICLEDATA = 17;
    public static final int ATTR_DYNAMICVEHICLEINFOSCR = 18;
    public static final int RT_SETCARMENUSTATE = 1000;
    public static final int OILLEVELWARNINGS_MIN = 0;
    public static final int OILLEVELWARNINGS_UNDERFILL = 1;
    public static final int OILLEVELWARNINGS_OVERFILL = 2;
    public static final int OILLEVELWARNINGS_SENSORERROR = 3;
    public static final int OILLEVELWARNINGS_OILOK = 4;
    public static final int OILLEVELWARNINGS_CHECKOIL = 5;
    public static final int OILLEVELWARNINGS_TILT = 6;
    public static final int OILLEVELWARNINGS_NOTUNDERHOTRUNNINGCONDITIONS = 7;
    public static final int OILLEVELWARNINGS_RUNNINGENGINE = 8;
    public static final int OILLEVELWARNINGS_NOTDEFINED = 9;
    public static final int OILLEVELWARNINGS_OILLEVELNOTAVAILABLE = 10;
    public static final int OILLEVELWARNINGS_SYSTEMERROR = 11;
    public static final int SCRSTATE_INIT = 0;
    public static final int SCRSTATE_NORMAL = 1;
    public static final int SCRSTATE_WARNING1 = 2;
    public static final int SCRSTATE_WARNING2 = 3;
    public static final int SCRSTATE_SYSTEMERROR = 4;
    public static final int SCRSTATE_TILT = 5;
    public static final int SCRSTATE_FROZENMEDIUM = 6;
    public static final int SCRSTATE_WARNING3 = 7;
    public static final int BLINKINGSTATE_NOBLINKING = 0;
    public static final int BLINKINGSTATE_LEFTBLINKING = 1;
    public static final int BLINKINGSTATE_RIGHTBLINKING = 2;
    public static final int BLINKINGSTATE_LEFTRIGHTBLINKING = 3;
    public static final int GEARUNIT_NO_GEAR = 0;
    public static final int GEARUNIT_NO_RECOMMENDATION = 0;
    public static final int GEARUNIT_GEAR1 = 1;
    public static final int GEARUNIT_GEAR2 = 2;
    public static final int GEARUNIT_GEAR3 = 3;
    public static final int GEARUNIT_GEAR4 = 4;
    public static final int GEARUNIT_GEAR5 = 5;
    public static final int GEARUNIT_GEAR6 = 6;
    public static final int GEARUNIT_GEAR7 = 7;
    public static final int GEARUNIT_GEAR8 = 8;
    public static final int GEARUNIT_GEAR9 = 9;
    public static final int GEARUNIT_GEAR10 = 10;
    public static final int CLUTCH_NOT_CLUTCHED_IN = 0;
    public static final int CLUTCH_CLUTCHED_IN = 1;
    public static final int GEARTRANSMISSIONMODE_NO_POSITION = 0;
    public static final int GEARTRANSMISSIONMODE_POSITION_P = 1;
    public static final int GEARTRANSMISSIONMODE_POSITION_R = 2;
    public static final int GEARTRANSMISSIONMODE_POSITION_N = 3;
    public static final int GEARTRANSMISSIONMODE_POSITION_D = 4;
    public static final int GEARTRANSMISSIONMODE_POSITION_S = 5;
    public static final int GEARTRANSMISSIONMODE_POSITION_M_TAP = 6;
    public static final int GEARTRANSMISSIONMODE_POSITION_M_BRIEF = 7;
    public static final int GEARTRANSMISSIONMODE_POSITION_E = 8;
    public static final int GEARTRANSMISSIONMODE_POSITION_B = 9;
    public static final int GEARTRANSMISSIONMODE_POSITION_MS = 10;
    public static final int GEARTRANSMISSIONMODE_POSITION_S_PLUS = 11;
    public static final int GEARTRANSMISSIONMODE_POSITION_MS_PLUS = 12;
    public static final int GEARTRANSMISSIONMODE_POSITION_OFFROAD = 13;
    public static final int RECUPLEVEL_NO_PRESENTATION = 0;
    public static final int RECUPLEVEL_LEVEL_1 = 1;
    public static final int RECUPLEVEL_LEVEL_2 = 2;
    public static final int RECUPLEVEL_LEVEL_3 = 3;
    public static final int RECUPLEVEL_LEVEL_4 = 4;
    public static final int RECUPLEVEL_LEVEL_5 = 5;
    public static final int HDCCOLOR_STANDARD = 0;
    public static final int HDCCOLOR_ALTERNATIVE = 1;
    public static final int EDSDISPLAY_NODISPLAY = 0;
    public static final int EDSDISPLAY_EDSNOTACTIVE = 1;
    public static final int EDSDISPLAY_EDSACTIVEFRONTAXLE = 2;
    public static final int EDSDISPLAY_EDSACTIVEREARAXLE = 3;
    public static final int EDSDISPLAY_EDSACTIVEFRONTREARAXLE = 4;
    public static final int EDSDISPLAY_EDSOVERTEMP = 5;
    public static final int EDSDISPLAY_EDSERROR = 6;
    public static final int SERVICEKEYID_UNKNOWN = 0;
    public static final int SERVICEKEYID_SK1 = 1;
    public static final int SERVICEKEYID_SK1A = 2;
    public static final int SERVICEKEYID_SK2 = 3;
    public static final int SERVICEKEYID_SK3 = 4;
    public static final int INJECTIONSYSTEM_TURBO = 0;
    public static final int INJECTIONSYSTEM_ASPIRATION = 1;

    public void setCarMenuState(boolean var1);
}

