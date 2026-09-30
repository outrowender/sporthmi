/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence;

import de.esolutions.fw.comm.core.IEnum;

public interface RequestStatus
extends IEnum {
    public static final int PERS_STATUS_OK = 0;
    public static final int PERS_STATUS_NO_ENGINE = 1;
    public static final int PERS_STATUS_VERSION_MISMATCH = 2;
    public static final int PERS_STATUS_TYPE_MISMATCH = 3;
    public static final int PERS_STATUS_INVALID_HANDLE = 4;
    public static final int PERS_STATUS_INVALID_NAME = 5;
    public static final int PERS_STATUS_DOES_NOT_EXIST = 6;
    public static final int PERS_STATUS_IN_USE = 7;
    public static final int PERS_STATUS_NO_TRANSACTION = 8;
    public static final int PERS_STATUS_FAILED = 9;
    public static final int PERS_STATUS_NOT_SUBSCRIBED = 10;
    public static final int PERS_STATUS_INVALID_TIMEOUT = 11;
    public static final int PERS_STATUS_TIMEOUT = 12;
    public static final int PERS_STATUS_REDUNDANT_REQUEST_REJECTED = 13;
    public static final int PERS_STATUS_OVERLOAD = 14;
    public static final int PERS_STATUS_TRANSACTION_PENDING = 15;
}

