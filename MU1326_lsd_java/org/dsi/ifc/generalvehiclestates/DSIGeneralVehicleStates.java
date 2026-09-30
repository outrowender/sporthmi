/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;

public interface DSIGeneralVehicleStates
extends DSIBase {
    public static final String VERSION = "2.11.18";
    public static final int RT_SETDSSSKOMBIWARNING = 1000;
    public static final int RT_SETTLODATA = 1001;
    public static final int RT_SETAPPCONNECTSTATE = 1002;
    public static final int ATTR_AIRBAGDATA = 2;
    public static final int ATTR_TANKINFO = 4;
    public static final int ATTR_DIMMEDHEADLIGHT = 5;
    public static final int ATTR_ACOUSTICPARKINGSYSTEM = 6;
    public static final int ATTR_CARVELOCITYTHRESHOLD = 7;
    public static final int ATTR_TVVELOCITYTHRESHOLD = 8;
    public static final int ATTR_HDDVELOCITYTHRESHOLD = 9;
    public static final int ATTR_BROWSERSLIDESHOWVELOCITYTHRESHOLD = 10;
    public static final int ATTR_BROWSERBORDBOOKVELOCITYTHRESHOLD = 11;
    public static final int ATTR_BROWSERTRAVELAGENTVELOCITYTHRESHOLD = 12;
    public static final int ATTR_BROWSERWEBVELOCITYTHRESHOLD = 13;
    public static final int ATTR_BWSVELOCITYTHRESHOLD = 14;
    public static final int ATTR_RADIOTEXTVELOCITYTHRESHOLD = 15;
    public static final int ATTR_DISPLAYDAYNIGHTDESIGN = 16;
    public static final int ATTR_BTBONDINGVELOCITYTHRESHOLD = 17;
    public static final int ATTR_MESSAGINGVELOCITYTHRESHOLD = 18;
    public static final int ATTR_DESTINATIONINPUTVELOCITYTHRESHOLD = 19;
    public static final int ATTR_REVERSEGEAR = 20;
    public static final int ATTR_DSSSVIEWOPTION = 21;
    public static final int ATTR_VEHICLESTANDSTILL = 22;
    public static final int ATTR_SERVICEKEYDATA = 23;
    public static final int ATTR_SERVICEKEYVIEWOPTION = 24;
    public static final int ATTR_PERSONALIZATIONSTATUS = 25;
    public static final int ATTR_TLOVIEWOPTIONS = 26;
    public static final int ATTR_EMERGENCYASSISTVOLLOWERING = 27;
    public static final int ATTR_PARKINGBRAKE = 28;
    public static final int ATTR_APPCONNECTTRIGGER = 30;
    public static final int ATTR_STPSTATE = 31;
    public static final int ATTR_AUTOMATICGEARSHIFTTRANSMODE = 32;
    public static final int AIRBAGCRASHINTENSITY_NOCRASH = 0;
    public static final int AIRBAGCRASHINTENSITY_INTENSITY1 = 1;
    public static final int AIRBAGCRASHINTENSITY_INTENSITY2 = 2;
    public static final int AIRBAGCRASHINTENSITY_INTENSITY3 = 3;
    public static final int DSSSWARNING_NO_WARNING = 0;
    public static final int DSSSWARNING_RED_TRAFFIC_LIGHT_GUIDANCE = 1;
    public static final int DSSSWARNING_STOP_SIGN_WARNING = 2;
    public static final int DSSSWARNING_REAR_END_COLLISION_AVOIDANCE_WARNING = 3;
    public static final int DSSSWARNING_INTERSECTION_COLLISION_AVOIDANCE_WARNING_RIGHT = 4;
    public static final int DSSSWARNING_INTERSECTION_COLLISION_AVOIDANCE_WARNING_LEFT = 5;
    public static final int DSSSWARNING_TURN_RIGHT_COLLISION_AVOIDANCE = 6;
    public static final int DSSSWARNING_TURN_LEFT_COLLISION_AVOIDANCE = 7;
    public static final int DSSSWARNING_PEDESTRIAN_CROSSING_RIGHT = 8;
    public static final int DSSSWARNING_PEDESTRIAN_CROSSING_LEFT = 9;
    public static final int DSSSWARNING_BICYCLE_COLLISION_RIGHT = 10;
    public static final int DSSSWARNING_BICYCLE_COLLISION_LEFT = 11;
    public static final int TLOTIMESTATE_UNAVAILABLE = 0;
    public static final int TLOTIMESTATE_STOPTHENPROCEED = 1;
    public static final int TLOTIMESTATE_STOPANDREMAIN = 2;
    public static final int TLOTIMESTATE_PREMOVEMENT = 3;
    public static final int TLOTIMESTATE_PERMISSIVEMOVEMENTALLOWED = 4;
    public static final int TLOTIMESTATE_PROTECTEDMOVEMENTALLOWED = 5;
    public static final int TLOTIMESTATE_PERMISSIVECLEARANCE = 6;
    public static final int TLOTIMESTATE_PROTECTEDCLEARANCE = 7;
    public static final int TLOTIMESTATE_CAUTIONCONFLICTINGTRAFFIC = 8;
    public static final int TLOHMISTATE_INIT = 0;
    public static final int TLOHMISTATE_ACTIVEFUNCTIONCONNECTIONOK = 1;
    public static final int TLOHMISTATE_STANDBYNORMALMODEWAITINGFORNEWDATA = 2;
    public static final int TLOHMISTATE_SWITCHEDOFFBYDRIVER = 3;
    public static final int TLOHMISTATE_FILTEREDOUTNOTDISPLAYED = 4;
    public static final int TLOSTARTSTOPINFO_RUNNINGENGINENOTNECESSARY = 0;
    public static final int TLOSTARTSTOPINFO_RUNNINGENGINENOTREALYNECESSARY = 1;
    public static final int TLOSTARTSTOPINFO_RUNNINGENGINESTRONGLYNECESSARY = 2;
    public static final int TLOSTARTSTOPINFO_SYSTEMERROR = 3;
    public static final int EMERGENCYASSISTVOLLOWERING_INIT = 0;
    public static final int EMERGENCYASSISTVOLLOWERING_NOLOWERING = 1;
    public static final int EMERGENCYASSISTVOLLOWERING_LOWERING = 2;
    public static final int EMERGENCYASSISTVOLLOWERING_MUTE = 3;
    public static final int APPCONNECTTRIGGER_IDLE = 0;
    public static final int APPCONNECTTRIGGER_REQUEST = 1;
    public static final int APPCONNECTTRIGGER_RELEASE = 2;
    public static final int STPSTATE_INIT = 0;
    public static final int STPSTATE_NOT_ACTIVE = 1;
    public static final int STPSTATE_NOT_ACTIVATABLE = 3;
    public static final int STPSTATE_ACTIVATABLE = 5;
    public static final int STPSTATE_ACTIVE = 6;
    public static final int STPSTATE_ACTIVE_ESK0 = 8;
    public static final int STPSTATE_ACTIVE_ESK1 = 9;
    public static final int STPSTATE_ACTIVE_ESK2 = 10;
    public static final int STPSTATE_ACTIVE_ESK3 = 11;
    public static final int STPSTATE_ACTIVE_EMERGENCY = 12;
    public static final int STPSTATE_ACTIVE_STABLE_STATE = 13;
    public static final int STPSTATE_ACTIVE_ADOPTION = 14;
    public static final int STPSTATE_ERROR = 15;

    public void setDSSSKombiWarning(int var1);

    public void setTLOData(int var1, int var2, TLOInfoElement[] var3);

    public void setAppConnectState(boolean var1);
}

