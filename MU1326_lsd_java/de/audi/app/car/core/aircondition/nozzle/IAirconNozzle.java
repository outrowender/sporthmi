/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

public interface IAirconNozzle {
    public static final int ASG_ID_0X09_BROADCAST = 9;
    public static final int FLAG_0X7F = 127;
    public static final int INVALID_NOZZLE_ID = -1;
    public static final int R1_CENTER_LEFT_NOZZLE_ID = 1;
    public static final int R1_CENTER_RIGHT_NOZZLE_ID = 2;
    public static final int R1_CENTER_LEFT_NOZZLE_POS = 1;
    public static final int R1_CENTER_RIGHT_NOZZLE_POS = 2;
    public static final int RANGE_AIRFLOW_MIN = 0;
    public static final int RANGE_AIRFLOW_MAX = 100;
    public static final int RANGE_AIRFLOW_STEP = 1;
    public static final int RANGE_POSITION_MIN = -100;
    public static final int RANGE_POSITION_MAX = 100;
    public static final int RANGE_POSITION_STEP = 1;
    public static final int NOZZLE_STYLE_MANUAL = 0;
    public static final int NOZZLE_STYLE_DIFFUS = 1;
    public static final int NOZZLE_STYLE_FOCUS = 2;
}

