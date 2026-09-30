/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

import de.esolutions.fw.comm.core.IEnum;

public interface eState
extends IEnum {
    public static final int STATE_NOT_AVAILABLE = 0;
    public static final int STATE_READY = 1;
    public static final int STATE_RUNNING = 2;
    public static final int STATE_ERROR = 3;
}

