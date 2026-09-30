/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.system;

import org.dsi.ifc.base.DSIBase;

public interface DSIHMIWatchDog
extends DSIBase {
    public static final String VERSION = "2.11.0";
    public static final int RT_ERRORLOGDUMPRESULT = 1000;
    public static final int RT_HEARTBEAT = 1001;
    public static final int RT_HMIREADY = 1002;
    public static final int ATTR_QUERYHEARTBEAT = 1;
    public static final int IN_TRIGGERERRORLOGDUMP = 3000;
    public static final int RESULTCODE_OK = 0;
    public static final int RESULTCODE_FAIL = 1;

    public void heartbeat(int var1);

    public void errorlogDumpResult(int var1);

    public void hmiReady();
}

