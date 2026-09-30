/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

public interface IMenuCoding {
    public static final String PROP_SET_MENU_CODING = "SetMenuCoding";
    public static final String PROP_SIMULATE_FSG = "SimulateFSG";
    public static final int MFLG_BASE = 200;
    public static final int MFLG_INVALID = -1;
    public static final int MFLG_ACC = 0;
    public static final int MFLG_INT_LIGHT = 1;
    public static final int MFLG_PARKING = 2;
    public static final int MFLG_AWV = 3;
    public static final int MFLG_LDW = 4;
    public static final int MFLG_SWA = 5;
    public static final int MFLG_EXT_LIGHT = 6;
    public static final int MFLG_WINDOW = 7;
    public static final int MFLG_AIRCONDITION = 8;
    public static final int MFLG_AUXHEATER = 9;
    public static final int MFLG_BC_CLUSTER = 10;
    public static final int MFLG_RDK = 11;
    public static final int MFLG_WIPER = 12;
    public static final int MFLG_SIA = 13;
    public static final int MFLG_SEAT = 14;
    public static final int MFLG_CENTRAL_LOCKING = 15;
    public static final int MFLG_COMPASS = 16;
    public static final int MFLG_CHARISMA = 17;
    public static final int MFLG_OILLEVEL = 18;
    public static final int MFLG_VIN = 19;
    public static final int MFLG_CLOCK = 20;
    public static final int MFLG_AIRSUSPENSION = 21;
    public static final int MFLG_HUD = 22;
    public static final int MFLG_UNITMASTER = 23;
    public static final int MFLG_HYBRID = 24;
    public static final int MFLG_UGDO = 25;
    public static final int MFLG_NIGHTVISION = 26;
    public static final int MFLG_SIDEVIEW = 27;
    public static final int MFLG_RGS = 28;
    public static final int MFLG_MFL_JOKER = 29;
    public static final int MFLG_TSD = 30;
    public static final int MFLG_ATTENTION_IDENT = 31;
    public static final int MFLG_KEYDATA = 32;
    public static final int MFLG_MIRROR = 33;
    public static final int MFLG_DRIVING_SCHOOL = 34;
    public static final int MFLG_MKE = 35;
    public static final int MFLG_BCME = 36;
    public static final int NUM_MENUFLAGS = 37;
    public static final int MFLG_BATTERY = -1;
    public static final int VISIBLE_BIT = 0;
    public static final int IGNITION_BIT = 1;
    public static final int SPEEDTHR_BIT = 2;
    public static final int STANDSTILL_BIT = 3;
    public static final byte AVAIL_AT_ALL = 1;
    public static final byte AVAIL_ANY_CLAMP15_STS = 2;
    public static final byte AVAIL_ANY_SPEED = 4;
    public static final byte AVAIL_WHEN_STANDSTILL = 8;
    public static final byte AVAIL_ALWAYS = 7;
    public static final int AVAIL_ON_CAR_STS_NORMAL = 0;
    public static final int NOT_AVAIL_ON_CAR_STS_CL15 = 1;
    public static final int NOT_AVAIL_ON_CAR_STS_SPEED = 2;
    public static final int NOT_AVAIL_ON_CAR_STS_ENGINE = 3;
    public static final int VO_REASON_NORMAL = 0;
    public static final int VO_REASON_ERROR = 1;
    public static final int VO_REASON_KL15 = 2;
    public static final int VO_REASON_SPEED = 3;
    public static final int VO_REASON_ENGINE = 4;
    public static final int VO_REASON_ERR16 = 16;
    public static final int VO_REASON_ERR20 = 20;
    public static final int VO_REASON_HMI_AUXHEATER_ERROR = 1000;
    public static final int VO_STATE_NORMAL = 2;
    public static final int VO_STATE_INVISIBLE = 0;
    public static final int VO_STATE_NOT_ACCESSIBLE = 1;
}

