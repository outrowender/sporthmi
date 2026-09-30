/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo;

import de.esolutions.fw.comm.core.IEnum;

public interface RESULT_TYPE
extends IEnum {
    public static final int RESULT_OK = 1;
    public static final int RESULT_ERROR_GENERIC = 2;
    public static final int RESULT_ERROR_LOCATION_NOT_VALID = 3;
    public static final int RESULT_ERROR_DATABASES_NOT_AVAILABLE = 4;
}

