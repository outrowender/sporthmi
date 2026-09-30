/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eNRC
extends IEnum {
    public static final int NRC_GENERAL_REJECT = 16;
    public static final int NRC_SERVICE_NOT_SUPPORTED = 17;
    public static final int NRC_SUB_FUNCTION_NOT_SUPPORTED = 18;
    public static final int NRC_INCORRECT_MESSAGE_LENGTH_INVALID_FORMAT = 19;
    public static final int NRC_BUSY_REPEAT_REQUEST = 33;
    public static final int NRC_CONDITIONS_NOT_CORRECT = 34;
    public static final int NRC_REQUEST_SEQUENCE_ERROR = 36;
    public static final int NRC_NO_RESPONSE_FROM_SUBNET_COMPONENT = 37;
    public static final int NRC_FAILURE_PREVENTS_EXECUTION_OF_REQUESTED_ACTION = 38;
    public static final int NRC_REQUEST_OUT_OF_RANGE = 49;
    public static final int NRC_SECURITY_ACCESS_DENIED = 51;
    public static final int NRC_INVALID_KEY = 53;
    public static final int NRC_EXCEED_NUMBER_OF_ATTEMPTS = 54;
    public static final int NRC_REQUIRED_TIME_DELAY_NOT_EXPIRED = 55;
    public static final int NRC_UPLOAD_DOWNLOAD_NOT_ACCEPTED = 112;
    public static final int NRC_TRANSFER_DATA_SUSPENDED = 113;
    public static final int NRC_GENERAL_PROGRAMMING_FAILURE = 114;
    public static final int NRC_WRONG_BLOCK_SEQUENCE_COUNTER = 115;
    public static final int NRC_RESPONSE_PENDING = 120;
    public static final int NRC_SUB_FUNCTION_NOT_SUPPORTED_IN_ACTIVE_DIAGNOSTIC_SESSION = 126;
    public static final int NRC_SERVICE_NOT_SUPPORTED_IN_ACTIVE_DIAGNOSTIC_SESSION = 127;
    public static final int NRC_RPM_TOO_HIGH = 129;
    public static final int NRC_RPM_TOO_LOW = 130;
    public static final int NRC_ENGINE_IS_RUNNING = 131;
    public static final int NRC_ENGINE_IS_NOT_RUNNING = 132;
    public static final int NRC_ENGINE_RUN_TIME_TOO_LOW = 133;
    public static final int NRC_TEMPERATURE_TOO_HIGH = 134;
    public static final int NRC_TEMPERATURE_TOO_LOW = 135;
    public static final int NRC_VEHICLE_SPEED_TOO_HIGH = 136;
    public static final int NRC_VEHICLE_SPEED_TOO_LOW = 137;
    public static final int NRC_THROTTLE_PEDAL_TOO_HIGH = 138;
    public static final int NRC_THROTTLE_PEDAL_TOO_LOW = 139;
    public static final int NRC_TRANSMISSION_RANGE_NOT_IN_NEUTRAL = 140;
    public static final int NRC_TRANSMISSION_RANGE_NOT_IN_GEAR = 141;
    public static final int NRC_BRAKE_SWITCH_NOT_CLOSED = 143;
    public static final int NRC_SHIFTER_LEVER_NOT_IN_PARK = 144;
    public static final int NRC_TORQUE_CONVERTER_CLUTCH_LOCKED = 145;
    public static final int NRC_VOLTAGE_TOO_HIGH = 146;
    public static final int NRC_VOLTAGE_TOO_LOW = 147;
}

