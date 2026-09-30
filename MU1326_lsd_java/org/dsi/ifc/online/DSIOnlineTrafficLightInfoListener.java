/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSIOnlineTrafficLightInfoListener
extends DSIListener {
    public void updateTrafficLightInfo(int var1, int var2, int[] var3, int var4, int var5, int var6);

    public void updateTrafficLightSpeed(CarBCSpeed var1, int var2);

    public void updateTrafficLightTime(int var1, int var2, int var3);
}

