/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.core.IEnum;

public interface OnlineState
extends IEnum {
    public static final int ONLINE_STATE_UNKNOWN = 0;
    public static final int ONLINE_STATE_BLOCKED = 1;
    public static final int ONLINE_STATE_PENDING = 2;
    public static final int ONLINE_STATE_IDLE_ALLOWED = 3;
    public static final int ONLINE_STATE_CONNECTED_ALLOWED = 4;
}

