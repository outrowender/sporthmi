/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW;

import de.esolutions.fw.comm.core.IEnum;

public interface eAntennaStateDSRC
extends IEnum {
    public static final int DSRC_ANTENNA_STATE_OK = 1;
    public static final int DSRC_ANTENNA_STATE_SHORTCUT = 2;
    public static final int DSRC_ANTENNA_STATE_OPEN_LOAD = 3;
    public static final int DSRC_ANTENNA_STATE_NOT_AVAILABLE = 255;
}

