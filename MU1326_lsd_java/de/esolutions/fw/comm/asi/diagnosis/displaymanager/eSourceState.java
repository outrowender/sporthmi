/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.displaymanager;

import de.esolutions.fw.comm.core.IEnum;

public interface eSourceState
extends IEnum {
    public static final int SOURCE_STATE_NOT_VALID = 0;
    public static final int SOURCE_STATE_SIGNAL_VALID = 1;
    public static final int SOURCE_STATE_NOT_AVAILABLE = 255;
}

