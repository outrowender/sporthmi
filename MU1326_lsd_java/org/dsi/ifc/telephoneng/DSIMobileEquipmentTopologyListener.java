/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.base.DSIListener;

public interface DSIMobileEquipmentTopologyListener
extends DSIListener {
    public void responseChangeTopology(int var1);

    public void updateTopology(int[] var1, int var2);

    public void updateUsage(int[] var1, int var2);
}

