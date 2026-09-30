/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eRegStatus
extends IEnum {
    public static final int REG_OK = 0;
    public static final int REG_CLIENT_ALREADY_REGISTERED = 1;
    public static final int REG_CLIENT_ID_ALREADY_REGISTERED = 2;
    public static final int REG_ERROR = 3;
}

