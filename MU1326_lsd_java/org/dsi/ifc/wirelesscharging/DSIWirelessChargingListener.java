/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.wirelesscharging;

import org.dsi.ifc.base.DSIListener;

public interface DSIWirelessChargingListener
extends DSIListener {
    public void updateChargingInfo(int var1, int var2);

    public void updateBatteryLevel(int var1, int var2);
}

