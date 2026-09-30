/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.core.IEnum;

public interface ThrottlingState
extends IEnum {
    public static final int THROTTLING_UNKNOWN = 0;
    public static final int THROTTLING_ACTIVE = 1;
    public static final int THROTTLING_NOT_ACTIVE = 2;
}

