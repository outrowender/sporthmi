/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface CarFuncAdap {
    public static final int CAR_FUNCTION_ADAP_LENGTH = 56;
    public static final byte CAR_FUNCTION_ACC = 0;
    public static final byte CAR_FUNCTION_AMBIENT_ILLUMINATION = 1;
    public static final byte CAR_FUNCTION_PDC = 2;
    public static final byte CAR_FUNCTION_AWV = 3;
    public static final byte CAR_FUNCTION_LANE_DEPARTURE_WARNING = 4;
    public static final byte CAR_FUNCTION_LANE_ASSISTANT = 5;
    public static final byte CAR_FUNCTION_EXTERIOR_ILLUMINATION = 6;
    public static final byte CAR_FUNCTION_WINDOWS = 7;
    public static final byte CAR_FUNCTION_CLIMA_CONFIGURATION = 8;
    public static final byte CAR_FUNCTION_AUXILIARY_HEATING = 9;
    public static final byte CAR_FUNCTION_BOARD_COMUTER = 10;
    public static final byte CAR_FUNCTION_RDK = 11;
    public static final byte CAR_FUNCTION_WIPER = 12;
    public static final byte CAR_FUNCTION_SIA = 13;
    public static final byte CAR_FUNCTION_SEAT_CONFIGURATION = 14;
    public static final byte CAR_FUNCTION_CENTRAL_LOCKING = 15;
    public static final byte CAR_FUNCTION_COMPASS = 16;
    public static final byte CAR_FUNCTION_CHARISMA = 17;
    public static final byte CAR_FUNCTION_OIL_LEVEL = 18;
    public static final byte CAR_FUNCTION_VIN = 19;
    public static final byte CAR_FUNCTION_CLOCK = 20;
    public static final byte CAR_FUNCTION_AIR_DAMPER = 21;
    public static final byte CAR_FUNCTION_HEADUP_DISPLAY = 22;
    public static final byte CAR_FUNCTION_CENTRAL_UNIT_MASTER = 23;
    public static final byte CAR_FUNCTION_HYBRID = 24;
    public static final byte CAR_FUNCTION_UGDO = 25;
    public static final byte CAR_FUNCTION_NIGHT_VISION = 26;
    public static final byte CAR_FUNCTION_SIDE_VIEW = 27;
    public static final byte CAR_FUNCTION_REVERSIBLE_BELT_PRE_LOAD = 28;
    public static final byte CAR_FUNCTION_MFL_JOCKER = 29;
    public static final byte CAR_FUNCTION_ROAD_SIGN_IDENTIFICATION = 30;
    public static final byte CAR_FUNCTION_ATTENTION_IDENTIFICATION = 31;
    public static final byte CAR_FUNCTION_ADAPTIVE_KEY = 32;
    public static final byte CAR_FUNCTION_CAR_MIRROR = 33;
    public static final byte CAR_FUNCTION_DRIVING_SCHOOL = 34;
    public static final byte CAR_FUNCTION_WEARINESS_RECOGNITION = 35;
    public static final byte CAR_FUNCTION_BCME = 36;
    public static final byte CAR_FUNCTION_BATTERY_STATE = 37;
    public static final byte CAR_FUNCTION_BRAKE = 38;
    public static final byte CAR_FUNCTION_START_STOP_REASONS = 39;
    public static final byte CAR_FUNCTION_ANGLE_OF_SLOPE = 40;
    public static final byte CAR_FUNCTION_BATTERY_MANAGEMENT = 41;
    public static final byte CAR_FUNCTION_REAR_SEAT_ENTERTAINMENT = 42;
    public static final byte CAR_FUNCTION_SPECIAL_FUNCTIONS = 43;
    public static final byte CAR_FUNCTION_TRAILER_ASSISTENT = 44;
    public static final byte CAR_FUNCTION_TV_TUNER = 45;
    public static final byte CAR_FUNCTION_AUX_COOLING = 46;
    public static final byte CAR_FUNCTION_PEDESTRIAN_ASSIST = 47;
    public static final byte CAR_FUNCTION_SEAT_PNEUMATIC = 48;
    public static final byte CAR_FUNCTION_CURVE_ASSIST = 49;
    public static final byte CAR_FUNCTION_E_CALL = 50;
    public static final byte CAR_FUNCTION_ENI = 51;
    public static final byte CAR_FUNCTION_SPORT_HMI = 52;
    public static final byte CAR_FUNCTION_AD_BLUE = 53;
    public static final byte CAR_FUNCTION_THINK_BLUE = 54;
    public static final byte CAR_FUNCTION_PEA = 55;

    public boolean isMenuDisplayActivated(short var1);

    public boolean isMenuDisClamp15OffActivated(short var1);

    public boolean isMenuDisOverThresholdHighActivated(short var1);

    public boolean isMenuDisStandstillActivated(short var1);

    public boolean isMenuDisAfterDisclaimerActivated(short var1);

    public byte getByteCoding(short var1);
}

