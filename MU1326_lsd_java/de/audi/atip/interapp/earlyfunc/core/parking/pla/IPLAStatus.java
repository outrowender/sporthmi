/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.earlyfunc.core.parking.pla;

public interface IPLAStatus {
    public static final int INVALID_OPTION_FLAG = -1;
    public static final int PLASTATUS_INVALID_MODE = -1;
    public static final int PLASTATUS_IDLE_MODE_ACTIVE = 0;
    public static final int PLASTATUS_SEARCH_MODE_ACTIVE = 1;
    public static final int PLASTATUS_PARK_IN_MODE_SELECTION_ACTIVE = 2;
    public static final int PLASTATUS_PARK_OUT_MODE_SELECTION_ACTIVE = 3;
    public static final int PLASTATUS_PARK_IN_ACTIVE = 4;
    public static final int PLASTATUS_PARK_OUT_ACTIVE = 5;
    public static final int PLASTATUS_STANDBY_MODE_ACTIVE = 6;
    public static final int PLAACTIVESIDE_NO_SELECTION = 0;
    public static final int PLAACTIVESIDE_LEFT_SIDE = 1;
    public static final int PLAACTIVESIDE_RIGHT_SIDE = 2;
    public static final int PLADRIVINGDIRECTION_NO_DIRECTION = 0;
    public static final int PLADRIVINGDIRECTION_POS_OK = 1;
    public static final int PLADRIVINGDIRECTION_FORWARD = 2;
    public static final int PLADRIVINGDIRECTION_BACKWARD = 3;
    public static final int PLASYMBOLVIEWOPTION_INVISIBLE = 0;
    public static final int PLASYMBOLVIEWOPTION_INACTIVE = 1;
    public static final int PLASYMBOLVIEWOPTION_ACTIVE = 2;
    public static final int PLASELECTION_NO_SELECTION = -1;
    public static final int PLASELECTION_BACKWARD_PARALLEL_TO_ROAD_RIGHT = 0;
    public static final int PLASELECTION_FORWARD_PARKBOX_RIGHT = 1;
    public static final int PLASELECTION_BACKWARD_PARKBOX_RIGHT = 2;
    public static final int PLASELECTION_BACKWARD_PARALLEL_TO_ROAD_LEFT = 3;
    public static final int PLASELECTION_FORWARD_PARKBOX_LEFT = 4;
    public static final int PLASELECTION_BACKWARD_PARKBOX_LEFT = 5;

    public int getActiveSide();

    public boolean isSystemActiveOPS();

    public int getDrivingDirection();

    public boolean isBrakeSymbol();

    public boolean isPosOKSymbol();

    public int getSteeringInterventionSymbol();

    public boolean isInteractionProhibited();

    public boolean isBackwardParallelToRoadSlotFound();

    public boolean isForwardParkboxSlotFound();

    public boolean isBackwardParkboxSlotFound();

    public int getPreSelection();
}

