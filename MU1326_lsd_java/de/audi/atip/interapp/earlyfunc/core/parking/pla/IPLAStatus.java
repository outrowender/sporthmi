/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.earlyfunc.core.parking.pla;

public interface IPLAStatus {
    public static final int INVALID_OPTION_FLAG;
    public static final int PLASTATUS_INVALID_MODE;
    public static final int PLASTATUS_IDLE_MODE_ACTIVE;
    public static final int PLASTATUS_SEARCH_MODE_ACTIVE;
    public static final int PLASTATUS_PARK_IN_MODE_SELECTION_ACTIVE;
    public static final int PLASTATUS_PARK_OUT_MODE_SELECTION_ACTIVE;
    public static final int PLASTATUS_PARK_IN_ACTIVE;
    public static final int PLASTATUS_PARK_OUT_ACTIVE;
    public static final int PLASTATUS_STANDBY_MODE_ACTIVE;
    public static final int PLAACTIVESIDE_NO_SELECTION;
    public static final int PLAACTIVESIDE_LEFT_SIDE;
    public static final int PLAACTIVESIDE_RIGHT_SIDE;
    public static final int PLADRIVINGDIRECTION_NO_DIRECTION;
    public static final int PLADRIVINGDIRECTION_POS_OK;
    public static final int PLADRIVINGDIRECTION_FORWARD;
    public static final int PLADRIVINGDIRECTION_BACKWARD;
    public static final int PLASYMBOLVIEWOPTION_INVISIBLE;
    public static final int PLASYMBOLVIEWOPTION_INACTIVE;
    public static final int PLASYMBOLVIEWOPTION_ACTIVE;
    public static final int PLASELECTION_NO_SELECTION;
    public static final int PLASELECTION_BACKWARD_PARALLEL_TO_ROAD_RIGHT;
    public static final int PLASELECTION_FORWARD_PARKBOX_RIGHT;
    public static final int PLASELECTION_BACKWARD_PARKBOX_RIGHT;
    public static final int PLASELECTION_BACKWARD_PARALLEL_TO_ROAD_LEFT;
    public static final int PLASELECTION_FORWARD_PARKBOX_LEFT;
    public static final int PLASELECTION_BACKWARD_PARKBOX_LEFT;

    default public int getActiveSide() {
    }

    default public boolean isSystemActiveOPS() {
    }

    default public int getDrivingDirection() {
    }

    default public boolean isBrakeSymbol() {
    }

    default public boolean isPosOKSymbol() {
    }

    default public int getSteeringInterventionSymbol() {
    }

    default public boolean isInteractionProhibited() {
    }

    default public boolean isBackwardParallelToRoadSlotFound() {
    }

    default public boolean isForwardParkboxSlotFound() {
    }

    default public boolean isBackwardParkboxSlotFound() {
    }

    default public int getPreSelection() {
    }
}

