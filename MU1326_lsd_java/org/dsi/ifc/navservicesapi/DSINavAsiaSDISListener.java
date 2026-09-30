/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.AddressDataSDIS;

public interface DSINavAsiaSDISListener
extends DSIListener {
    public void updateRouteGuidanceActive(boolean var1, int var2);

    public void updateCarPosition(double var1, double var3, int var5, int var6, int var7, int var8);

    public void updateDestinationInfo(AddressDataSDIS[] var1, int var2);

    public void updateNextDestinationInfo(int var1, int var2, int var3, int var4);

    public void startGuidanceToDestinationsResult(int var1);
}

