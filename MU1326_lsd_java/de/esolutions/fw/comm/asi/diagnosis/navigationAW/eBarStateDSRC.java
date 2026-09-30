/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW;

import de.esolutions.fw.comm.core.IEnum;

public interface eBarStateDSRC
extends IEnum {
    public static final int DSRC_BAR_STATE_NOT_OK = 0;
    public static final int DSRC_BAR_STATE_OK = 1;
    public static final int DSRC_BAR_STATE_NO_COMMUNICATION = 254;
    public static final int DSRC_BAR_STATE_NOT_AVAILABLE = 255;
}

