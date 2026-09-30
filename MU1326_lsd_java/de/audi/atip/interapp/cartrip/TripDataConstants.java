/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.cartrip;

import de.esolutions.fw.util.commons.Buffer;

public class TripDataConstants {
    public static final int DATA_TYPE_EMPTY = 0;
    public static final int DATA_TYPE_TIME_TRAVELED_SINCE = 1;
    public static final int DATA_TYPE_TOTAL_TIME_TRAVELED = 2;
    public static final int DATA_TYPE_DISTANCE_TRAVELED_SINCE = 3;
    public static final int DATA_TYPE_TOTAL_DISTANCE_TRAVELED = 4;
    public static final int DATA_TYPE_RANGE = 5;
    public static final int DATA_TYPE_DISTANCE_TO_NEXT_PETROL_STATION = 6;
    public static final int DATA_TYPE_CONSUMPTION_SINCE = 7;
    public static final int DATA_TYPE_TOTAL_CONSUMPTION = 8;
    public static final int DATA_TYPE_SPEED_SINCE = 9;
    public static final int DATA_TYPE_TOTAL_SPEED = 10;
    public static final int DATA_TYPE_ARRIVAL_AND_DISTANCE_TO_DESTINATION = 11;
    public static final int DATA_TYPE_ARRIVAL_AND_DISTANCE_TO_STOPOVER = 12;
    public static final int DATA_TYPE_TIME_AND_DISTANCE_TO_DESTINATION = 13;
    public static final int DATA_TYPE_TIME_AND_DISTANCE_TO_STOPOVER = 14;
    public static final int DATA_TYPE_SPEED_LIMIT = 15;
    public static final int DATA_TYPE_ALTITUDE = 16;
    public static final int DATA_TYPE_DIRECTION_OF_TRAVEL = 17;
    public static final int DATA_TYPE_NUMBER_OF_SATELLITES = 18;
    public static final int DATA_TYPE_DATE = 19;
    public static final int DATA_TYPE_TIME = 20;
    public static final int DATA_TYPE_AMBIENT_TEMPERATURE = 21;
    public static final int DATA_TYPE_LONGITUDINAL_ACCELERATION_ACTUAL = 22;
    public static final int DATA_TYPE_LATERAL_ACCELERATION_ACTUAL = 23;
    public static final int DATA_TYPE_SPEED_ACTUAL = 24;
    public static final int DATA_TYPE_LONGITUDINAL_ACCELERATION_MAX = 25;
    public static final int DATA_TYPE_LATERAL_ACCELERATION_MAX = 26;
    public static final int DATA_TYPE_SPEED_MAX = 27;
    public static final int DATA_TYPE_STEERING_ANGLE = 28;
    public static final int DATA_TYPE_ELECTRICAL_TOTAL_DISTANCE_TRAVELED = 29;
    public static final int DATA_TYPE_TOTAL_ENGINE_OFF_TRAVELED = 30;
    public static final int DATA_TYPE_ELECTRICAL_DISTANCE_TRAVELED_SINCE = 31;
    public static final int DATA_TYPE_ENGINE_OFF_TRAVELED_SINCE = 32;
    public static final int DATA_TYPE_REMAINING_ELECTRICAL_RANGE = 33;
    public static final int DATA_TYPE_REMAINING_CHARGE_TIME = 34;
    public static final int DATA_TYPE_REMAINING_TOTAL_RANGE = 35;
    public static final int DATA_TYPE_ARRIVAL_TIME = 40;
    public static final int DATA_TYPE_ARRIVAL_TIME_AT_STOPOVER = 41;
    public static final int DATA_TYPE_TIME_TO_DESTINATION = 42;
    public static final int DATA_TYPE_TIME_TO_STOPOVER = 43;
    public static final int DATA_TYPE_DISTANCE_TO_DESTINATION = 44;
    public static final int DATA_TYPE_DISTANCE_TO_STOPOVER = 45;
    public static final int DATA_TYPE_LONGITUDINAL_ACCELERATION_MAX_POS = 46;
    public static final int DATA_TYPE_LONGITUDINAL_ACCELERATION_MAX_NEG = 47;
    public static final int DATA_TYPE_LATERAL_ACCELERATION_MAX_LEFT = 48;
    public static final int DATA_TYPE_LATERAL_ACCELERATION_MAX_RIGHT = 49;
    public static final int DATA_TYPE_TIME_SINCE_RESET = 50;
    public static final int DATA_TYPE_TIME_TRAVELED_SINCE_SINGLE = 51;
    public static final int DATA_TYPE_DISTANCE_TRAVELED_SINCE_SINGLE = 52;
    public static final int DATA_TYPE_CONSUMPTION_SINCE_SINGLE = 53;
    public static final int DATA_TYPE_SPEED_SINCE_SINGLE = 54;
    public static final int DATA_TYPE_ENGINE_OFF_TRAVELED_SINCE_SINGLE = 55;

    public static String getDescription(int n) {
        switch (n) {
            case 1: {
                return "DATA_TYPE_TIME_TRAVELED_SINCE";
            }
            case 2: {
                return "DATA_TYPE_TOTAL_TIME_TRAVELED";
            }
            case 3: {
                return "DATA_TYPE_DISTANCE_TRAVELED_SINCE";
            }
            case 4: {
                return "DATA_TYPE_TOTAL_DISTANCE_TRAVELED";
            }
            case 5: {
                return "DATA_TYPE_RANGE";
            }
            case 6: {
                return "DATA_TYPE_DISTANCE_TO_NEXT_PETROL_STATION";
            }
            case 7: {
                return "DATA_TYPE_CONSUMPTION_SINCE";
            }
            case 8: {
                return "DATA_TYPE_TOTAL_CONSUMPTION";
            }
            case 9: {
                return "DATA_TYPE_SPEED_SINCE";
            }
            case 10: {
                return "DATA_TYPE_TOTAL_SPEED";
            }
            case 11: {
                return "DATA_TYPE_ARRIVAL_AND_DISTANCE_TO_DESTINATION";
            }
            case 12: {
                return "DATA_TYPE_ARRIVAL_AND_DISTANCE_TO_STOPOVER";
            }
            case 13: {
                return "DATA_TYPE_TIME_AND_DISTANCE_TO_DESTINATION";
            }
            case 14: {
                return "DATA_TYPE_TIME_AND_DISTANCE_TO_STOPOVER";
            }
            case 15: {
                return "DATA_TYPE_SPEED_LIMIT";
            }
            case 16: {
                return "DATA_TYPE_ALTITUDE";
            }
            case 17: {
                return "DATA_TYPE_DIRECTION_OF_TRAVEL";
            }
            case 18: {
                return "DATA_TYPE_NUMBER_OF_SATELLITES";
            }
            case 19: {
                return "DATA_TYPE_DATE";
            }
            case 20: {
                return "DATA_TYPE_TIME";
            }
            case 21: {
                return "DATA_TYPE_AMBIENT_TEMPERATURE";
            }
            case 22: {
                return "DATA_TYPE_LONGITUDINAL_ACCELERATION_ACTUAL";
            }
            case 23: {
                return "DATA_TYPE_LATERAL_ACCELERATION_ACTUAL";
            }
            case 24: {
                return "DATA_TYPE_SPEED_ACTUAL";
            }
            case 25: {
                return "DATA_TYPE_LONGITUDINAL_ACCELERATION_MAX";
            }
            case 26: {
                return "DATA_TYPE_LATERAL_ACCELERATION_MAX";
            }
            case 27: {
                return "DATA_TYPE_SPEED_MAX";
            }
            case 28: {
                return "DATA_TYPE_STEERING_ANGLE";
            }
            case 29: {
                return "DATA_TYPE_ELECTRICAL_TOTAL_DISTANCE_TRAVELED";
            }
            case 30: {
                return "DATA_TYPE_TOTAL_ENGINE_OFF_TRAVELED";
            }
            case 31: {
                return "DATA_TYPE_ELECTRICAL_DISTANCE_TRAVELED_SINCE";
            }
            case 32: {
                return "DATA_TYPE_ENGINE_OFF_TRAVELED_SINCE";
            }
            case 33: {
                return "DATA_TYPE_REMAINING_ELECTRICAL_RANGE";
            }
            case 34: {
                return "DATA_TYPE_REMAINING_CHARGE_TIME";
            }
            case 35: {
                return "DATA_TYPE_REMAINING_TOTAL_RANGE";
            }
            case 50: {
                return "DATA_TYPE_TIME_SINCE_RESET";
            }
            case 51: {
                return "DATA_TYPE_TIME_TRAVELED_SINCE_SINGLE";
            }
            case 52: {
                return "DATA_TYPE_DISTANCE_TRAVELED_SINCE_SINGLE";
            }
            case 53: {
                return "DATA_TYPE_CONSUMPTION_SINCE_SINGLE";
            }
            case 54: {
                return "DATA_TYPE_SPEED_SINCE_SINGLE";
            }
            case 55: {
                return "DATA_TYPE_ENGINE_OFF_TRAVELED_SINCE_SINGLE";
            }
        }
        Buffer buffer = new Buffer("UNKNOWN ");
        buffer.append('(');
        buffer.append(n);
        buffer.append(')');
        return buffer.toString();
    }
}

