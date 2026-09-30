/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider;

import de.esolutions.fw.comm.core.IEnum;

public interface ResultCode
extends IEnum {
    public static final int OK = 0;
    public static final int PROFILE_ERROR = 1;
    public static final int DB_ERROR = 2;
    public static final int INTERNAL_ERROR = 3;
    public static final int FORMAT_ERROR = 4;
}

