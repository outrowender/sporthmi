/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

public interface CarFuncAdap {
    public static final int CAR_FUNCTION_ADAP_LENGTH;
    public static final byte CAR_FUNCTION_ACC;
    public static final byte CAR_FUNCTION_AMBIENT_ILLUMINATION;
    public static final byte CAR_FUNCTION_PDC;
    public static final byte CAR_FUNCTION_AWV;
    public static final byte CAR_FUNCTION_LANE_DEPARTURE_WARNING;
    public static final byte CAR_FUNCTION_LANE_ASSISTANT;
    public static final byte CAR_FUNCTION_EXTERIOR_ILLUMINATION;
    public static final byte CAR_FUNCTION_WINDOWS;
    public static final byte CAR_FUNCTION_CLIMA_CONFIGURATION;
    public static final byte CAR_FUNCTION_AUXILIARY_HEATING;
    public static final byte CAR_FUNCTION_BOARD_COMUTER;
    public static final byte CAR_FUNCTION_RDK;
    public static final byte CAR_FUNCTION_WIPER;
    public static final byte CAR_FUNCTION_SIA;
    public static final byte CAR_FUNCTION_SEAT_CONFIGURATION;
    public static final byte CAR_FUNCTION_CENTRAL_LOCKING;
    public static final byte CAR_FUNCTION_COMPASS;
    public static final byte CAR_FUNCTION_CHARISMA;
    public static final byte CAR_FUNCTION_OIL_LEVEL;
    public static final byte CAR_FUNCTION_VIN;
    public static final byte CAR_FUNCTION_CLOCK;
    public static final byte CAR_FUNCTION_AIR_DAMPER;
    public static final byte CAR_FUNCTION_HEADUP_DISPLAY;
    public static final byte CAR_FUNCTION_CENTRAL_UNIT_MASTER;
    public static final byte CAR_FUNCTION_HYBRID;
    public static final byte CAR_FUNCTION_UGDO;
    public static final byte CAR_FUNCTION_NIGHT_VISION;
    public static final byte CAR_FUNCTION_SIDE_VIEW;
    public static final byte CAR_FUNCTION_REVERSIBLE_BELT_PRE_LOAD;
    public static final byte CAR_FUNCTION_MFL_JOCKER;
    public static final byte CAR_FUNCTION_ROAD_SIGN_IDENTIFICATION;
    public static final byte CAR_FUNCTION_ATTENTION_IDENTIFICATION;
    public static final byte CAR_FUNCTION_ADAPTIVE_KEY;
    public static final byte CAR_FUNCTION_CAR_MIRROR;
    public static final byte CAR_FUNCTION_DRIVING_SCHOOL;
    public static final byte CAR_FUNCTION_WEARINESS_RECOGNITION;
    public static final byte CAR_FUNCTION_BCME;
    public static final byte CAR_FUNCTION_BATTERY_STATE;
    public static final byte CAR_FUNCTION_BRAKE;
    public static final byte CAR_FUNCTION_START_STOP_REASONS;
    public static final byte CAR_FUNCTION_ANGLE_OF_SLOPE;
    public static final byte CAR_FUNCTION_BATTERY_MANAGEMENT;
    public static final byte CAR_FUNCTION_REAR_SEAT_ENTERTAINMENT;
    public static final byte CAR_FUNCTION_SPECIAL_FUNCTIONS;
    public static final byte CAR_FUNCTION_TRAILER_ASSISTENT;
    public static final byte CAR_FUNCTION_TV_TUNER;
    public static final byte CAR_FUNCTION_AUX_COOLING;
    public static final byte CAR_FUNCTION_PEDESTRIAN_ASSIST;
    public static final byte CAR_FUNCTION_SEAT_PNEUMATIC;
    public static final byte CAR_FUNCTION_CURVE_ASSIST;
    public static final byte CAR_FUNCTION_E_CALL;
    public static final byte CAR_FUNCTION_ENI;
    public static final byte CAR_FUNCTION_SPORT_HMI;
    public static final byte CAR_FUNCTION_AD_BLUE;
    public static final byte CAR_FUNCTION_THINK_BLUE;
    public static final byte CAR_FUNCTION_PEA;

    default public boolean isMenuDisplayActivated(short s) {
    }

    default public boolean isMenuDisClamp15OffActivated(short s) {
    }

    default public boolean isMenuDisOverThresholdHighActivated(short s) {
    }

    default public boolean isMenuDisStandstillActivated(short s) {
    }

    default public boolean isMenuDisAfterDisclaimerActivated(short s) {
    }

    default public byte getByteCoding(short s) {
    }
}

