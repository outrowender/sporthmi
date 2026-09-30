/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;

public interface DSINavAsiaRemoteHMIListener
extends DSIListener {
    public void updateCurrentCityAndStreet(String var1, String var2, int var3);

    public void updateDayNightView(int var1, int var2);

    public void updateDestination(double[] var1, double[] var2, int var3);

    public void updateDestinationDistanceAndTime(double[] var1, int[] var2, int var3);

    public void updatePositionInfo(double var1, double var3, double var5, double var7, double var9, int var11);

    public void updateNavigationState(boolean var1, boolean var2, int var3);
}

