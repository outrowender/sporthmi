/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

import de.esolutions.fw.comm.core.IEnum;

public interface RunMode
extends IEnum {
    public static final int ONOFF_RUNMODE_UNKNOWN = 0;
    public static final int ONOFF_RUNMODE_NORMAL = 1;
    public static final int ONOFF_RUNMODE_SWDL = 2;
    public static final int ONOFF_RUNMODE_RPODUCTION = 3;
    public static final int ONOFF_RUNMODE_ESO_SCREENING = 4;
    public static final int ONOFF_RUNMODE_HB_TESTMODE = 5;
    public static final int ONOFF_RUNMODE_ULP_UNKNOWN = 100;
    public static final int ONOFF_RUNMODE_ULP_UOTA = 101;
    public static final int ONOFF_RUNMODE_ULP_PHONE = 102;
}

