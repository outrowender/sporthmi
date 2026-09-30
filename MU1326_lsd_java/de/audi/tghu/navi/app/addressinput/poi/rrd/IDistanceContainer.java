/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IDistanceContainer {
    public RrdCalculationInfo getDistance(int var1);

    public void storeRRDDistances(RrdCalculationInfo[] var1);
}

