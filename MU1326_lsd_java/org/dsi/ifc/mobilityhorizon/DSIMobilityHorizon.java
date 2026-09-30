/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mobilityhorizon;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizon
extends DSIBase {
    public static final String VERSION = "2.11.8";
    public static final int RT_SETCONSUMPTIONINFO = 1000;
    public static final int RT_SETLOCATIONS = 1001;
    public static final int RT_SETCONSIDEREDLOCATIONTYPES = 1002;
    public static final int RT_SETDRIVETRAINMODE = 1003;
    public static final int RT_REQUESTLOCATIONRANGELEVEL = 1004;
    public static final int RP_REQUESTLOCATIONRANGELEVELRESULT = 2000;
    public static final int IN_LOCATIONRANGELEVELCHANGED = 3000;
    public static final int ATTR_LOCATIONS = 1;
    public static final int ATTR_CONSIDEREDLOCATIONTYPES = 2;
    public static final int ATTR_DRIVETRAINMODE = 3;
    public static final int ATTR_MOBILITYHORIZONSTATUS = 4;
    public static final int UNIT_UNKNOWN = 0;
    public static final int UNIT_LITER = 1;
    public static final int UNIT_KILOGRAM = 2;
    public static final int UNIT_KILOWATT_HOUR = 3;
    public static final int LOCATIONTYPE_NONE = 0;
    public static final int LOCATIONTYPE_ONEWAY = 1;
    public static final int LOCATIONTYPE_HOME = 2;
    public static final int LOCATIONTYPE_USERDEFINED = 3;
    public static final int DRIVETRAINMODE_PRIMARY = 0;
    public static final int DRIVETRAINMODE_SECONDARY = 1;
    public static final int DRIVETRAINMODE_COMBINED = 2;
    public static final int MOBILITYHORIZONSTATUS_SYSTEMNOTREADY = 0;
    public static final int MOBILITYHORIZONSTATUS_SYSTEMREADY = 1;
    public static final int MOBILITYHORIZONSTATUS_NODATABASEFOUND = 2;
    public static final int MOBILITYHORIZONSTATUS_DATABASEDEFECT = 3;
    public static final int MOBILITYHORIZONSTATUS_CRITICALENERGYLEVEL_1 = 4;
    public static final int MOBILITYHORIZONSTATUS_CRITICALENERGYLEVEL_2 = 5;
    public static final int MOBILITYHORIZONSTATUS_NOTENOUGHENERGY = 6;
    public static final int MOBILITYHORIZONSTATUS_OTHERFAILURE = 99;
    public static final int LOCATIONRANGETYPE_TARGET = 0;
    public static final int LOCATIONRANGETYPE_HOME = 1;
    public static final int LOCATIONRANGETYPE_USERDEFINED = 2;
    public static final int LOCATIONRANGELEVEL_UNDEFINED = 0;
    public static final int LOCATIONRANGELEVEL_INRANGE = 1;
    public static final int LOCATIONRANGELEVEL_CRITICAL = 2;
    public static final int LOCATIONRANGELEVEL_OUTOFRANGE = 3;

    public void setConsumptionInfo(ConsumptionInfo[] var1);

    public void setLocations(MobilityHorizonLocation[] var1);

    public void setConsideredLocationTypes(int[] var1);

    public void setDriveTrainMode(int var1);

    public void requestLocationRangeLevel(int var1);
}

