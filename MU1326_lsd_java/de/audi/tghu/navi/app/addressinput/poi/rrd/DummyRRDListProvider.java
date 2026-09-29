/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class DummyRRDListProvider
implements IRRDListProvider {
    @Override
    public NavLocationWgs84[] getRRDCalculationList() {
        return new NavLocationWgs84[0];
    }

    @Override
    public void updateDirectionAndAirDistance(PosPosition posPosition) {
    }

    @Override
    public int getRRDListCalculationLimit() {
        return 0;
    }

    @Override
    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    @Override
    public void unitsChanged() {
    }
}

