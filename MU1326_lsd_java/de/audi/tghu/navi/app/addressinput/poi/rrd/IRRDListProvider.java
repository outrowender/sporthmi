/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IRRDListProvider {
    public NavLocationWgs84[] getRRDCalculationList();

    public void updateDirectionAndAirDistance(PosPosition var1);

    public int getRRDListCalculationLimit();

    public void updateRRDDistances(RrdCalculationInfo[] var1);

    public void unitsChanged();
}

