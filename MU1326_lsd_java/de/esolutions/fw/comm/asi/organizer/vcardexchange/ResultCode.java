/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange;

import de.esolutions.fw.comm.core.IEnum;

public interface ResultCode
extends IEnum {
    public static final int OK = 0;
    public static final int PARSE_ERROR = 1;
    public static final int FILE_NOT_FOUND = 2;
    public static final int INTERNAL_ERROR = 3;
}

