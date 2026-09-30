/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.base.DSIBase;

public interface DSIMobileEquipmentTopology
extends DSIBase {
    public static final String VERSION = "2.11.9";
    public static final int RT_REQUESTCHANGETOPOLOGY = 1000;
    public static final int ATTR_TOPOLOGY = 1;
    public static final int ATTR_USAGE = 2;
    public static final int RP_RESPONSECHANGETOPOLOGY = 2000;
    public static final int USAGE_NAD = 0;
    public static final int USAGE_HFP = 1;

    public void requestChangeTopology(int[] var1);
}

