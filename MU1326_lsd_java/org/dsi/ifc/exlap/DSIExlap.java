/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exlap;

import org.dsi.ifc.base.DSIBase;

public interface DSIExlap
extends DSIBase {
    public static final String VERSION = "2.11.3";
    public static final int ATTR_AVAILABLESERVICES = 1;
    public static final int RESULTTYPE_OK = 0;
    public static final int RESULTTYPE_ERROR = 1;
    public static final int STATUS_AVAILABLE = 0;
    public static final int STATUS_CAN_BE_BOUGHT = 1;
    public static final int RT_START = 1000;
    public static final int RT_STOP = 1001;
    public static final int RP_STARTRESULT = 2000;
    public static final int RP_STOPRESULT = 2002;

    public void start();

    public void stop();
}

