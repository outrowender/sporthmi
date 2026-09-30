/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sse;

import org.dsi.ifc.base.DSIBase;

public interface DSISSE
extends DSIBase {
    public static final String VERSION = "2.11.3";
    public static final int ATTR_MICGAINLEVEL = 1;
    public static final int ATTR_MODE = 2;
    public static final int ATTR_MICMUTESTATE = 3;
    public static final int RT_REQUESTSETMODE = 1000;
    public static final int RT_REQUESTSETMICGAINLEVEL = 1001;
    public static final int RT_REQUESTSETMICMUTESTATE = 1002;
    public static final int RP_RESPONSESETMODE = 2000;
    public static final int RP_RESPONSESETMICGAINLEVEL = 2001;
    public static final int RP_RESPONSESETMICMUTESTATE = 2002;
    public static final int RESPONSE_OK = 0;
    public static final int RESPONSE_ERROR = 1;
    public static final int MODE_HFP_OFF = 0;
    public static final int MODE_HFP_ON = 1;
    public static final int MODE_SDS_INTERN_ON = 2;
    public static final int MODE_SDS_INTERN_OFF = 3;
    public static final int MODE_SDS_EXTERN_ON = 4;
    public static final int MODE_SDS_EXTERN_OFF = 5;
    public static final int MODE_NONE = 6;
    public static final int MODE_SDS_SMARTPHONE_INT_ON = 7;
    public static final int MODE_SDS_SMARTPHONE_INT_OFF = 8;
    public static final int MODE_TEL_SMARTPHONE_INT_ON = 9;
    public static final int MODE_TEL_SMARTPHONE_INT_OFF = 10;
    public static final int MICMUTESTATE_ON = 0;
    public static final int MICMUTESTATE_OFF = 1;

    public void requestSetMode(int var1);

    public void requestSetMicGainLevel(int var1);

    public void requestSetMicMuteState(int var1);
}

