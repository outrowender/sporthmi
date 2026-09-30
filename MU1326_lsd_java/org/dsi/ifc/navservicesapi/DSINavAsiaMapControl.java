/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;

public interface DSINavAsiaMapControl
extends DSIBase {
    public static final String VERSION = "2.11.16";
    public static final int RT_SENDTORESUME = 1000;
    public static final int RT_SENDTOSUSPEND = 1001;
    public static final int RT_SETVIEWTYPE = 1002;
    public static final int RT_SETDATARATE = 1003;
    public static final int RT_SETZOOMLEVEL = 1004;
    public static final int ATTR_MAPSTATUS = 1;
    public static final int ATTR_VIEWTYPE = 2;
    public static final int ATTR_DATARATE = 3;
    public static final int ATTR_ZOOMLEVEL = 4;
    public static final int ATTR_RECOMMENDEDZOOM = 5;
    public static final int MAPSTATUS_SUSPENDED = 0;
    public static final int MAPSTATUS_STARTING = 1;
    public static final int MAPSTATUS_READY = 2;
    public static final int MAPSTATUS_RESTARING = 3;
    public static final int MAPSTATUS_ERORR = 4;
    public static final int VIEWTYPE_MAP = 0;
    public static final int VIEWTYPE_KDK = 1;
    public static final int DATARATE_REDUCED = 0;
    public static final int DATARATE_FULL = 1;
    public static final int DATARATE_OFF = 2;

    public void sendToResume();

    public void sendToSuspend();

    public void setViewType(int var1);

    public void setDataRate(int var1);

    public void setZoomLevel(float var1);
}

