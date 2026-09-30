/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komogfxstreamsink;

import org.dsi.ifc.base.DSIBase;

public interface DSIKOMOGfxStreamSink
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int RT_SETFGLAYER = 1000;
    public static final int RT_FADEIN = 1001;
    public static final int RT_FADEOUT = 1002;
    public static final int RP_SETFGLAYERRESULT = 2000;
    public static final int RP_FADEINRESULT = 2001;
    public static final int RP_FADEOUTRESULT = 2002;
    public static final int ATTR_GFXSTATE = 1;
    public static final int ATTR_REQUESTSYNC = 2;
    public static final int ATTR_DATARATE = 3;
    public static final int GFXSTATE_UNAVAILABLE = 0;
    public static final int GFXSTATE_AVAILABLE = 1;
    public static final int FGREFPIC_EMPTY = 0;
    public static final int FGREFPIC_KDK = 1;
    public static final int FGREFPIC_EV = 2;
    public static final int FGREFPIC_MAP = 3;
    public static final int FADESPEED_BLIT = 0;
    public static final int FADESPEED_FADE = 1;
    public static final int SYNCREQUEST_SYNCSATISFIED = 0;
    public static final int SYNCREQUEST_SYNCNEEDED = 1;
    public static final int DATARATE_OFF = 0;
    public static final int DATARATE_REDUCEDBANDWIDTH = 1;
    public static final int DATARATE_FULL = 2;

    public void setFGLayer(int var1);

    public void fadeIn(int var1, int var2, int var3);

    public void fadeOut(int var1);
}

