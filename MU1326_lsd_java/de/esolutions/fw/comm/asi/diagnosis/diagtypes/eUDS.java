/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eUDS
extends IEnum {
    public static final int UDS_SESSION_CONTROL = 16;
    public static final int UDS_ECU_RESET = 17;
    public static final int UDS_CLEAR_DTC_INFORMATION = 20;
    public static final int UDS_READ_DTC_INFORMATION = 25;
    public static final int UDS_READ_DATA_BY_IDENTIFIER = 34;
    public static final int UDS_READ_MEMORY_BY_ADRESS = 35;
    public static final int UDS_SECURITY_ACCESS = 39;
    public static final int UDS_COMMUNICATION_CONTROL = 40;
    public static final int UDS_WRITE_DATA_BY_IDENTIFIER = 46;
    public static final int UDS_IO_CONTROL_BY_IDENTIFIER = 47;
    public static final int UDS_ROUTINE_CONTROL = 49;
    public static final int UDS_REQUEST_DOWNLOAD = 52;
    public static final int UDS_REQUEST_UPLOAD = 53;
    public static final int UDS_TRANSFER_DATA = 54;
    public static final int UDS_TRANSFER_DATA_EXIT = 55;
    public static final int UDS_WRITE_MEMORY_BY_ADRESS = 61;
    public static final int UDS_TESTER_PRESENT = 62;
    public static final int UDS_CONTROL_DTC_SETTINGS = 133;
    public static final int UDS_RESPONSE_ON_EVENT = 134;
}

