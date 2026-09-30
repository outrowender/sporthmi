/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

import de.esolutions.fw.comm.core.IEnum;

public interface ShutdownRequest
extends IEnum {
    public static final int ONOFF_SHUTDOWN_NONE = 0;
    public static final int ONOFF_SHUTDOWN_NORMAL = 1;
    public static final int ONOFF_SHUTDOWN_RESTART = 2;
    public static final int ONOFF_SHUTDOWN_FAST = 3;
    public static final int ONOFF_SHUTDOWN_FINAL = 4;
}

