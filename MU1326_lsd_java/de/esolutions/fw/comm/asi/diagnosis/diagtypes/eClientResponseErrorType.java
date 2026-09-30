/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eClientResponseErrorType
extends IEnum {
    public static final int ERR_RESPONSE_ERROR_UNKNOWN = 0;
    public static final int ERR_ROUTINE_REQUEST_SEQUENCE_ERROR = 1;
    public static final int ERR_ROUTINE_ACTION_NOT_SUPPORTED = 2;
    public static final int ERR_REQUEST_OUT_OF_RANGE = 3;
}

