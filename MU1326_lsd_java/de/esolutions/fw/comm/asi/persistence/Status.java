/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence;

import de.esolutions.fw.comm.core.IEnum;

public interface Status
extends IEnum {
    public static final int OK = 0;
    public static final int NO_SUCH_ATTRIBUTE = 1;
    public static final int NOT_ALLOWED = 2;
    public static final int NOT_SUBSCRIBED = 3;
}

