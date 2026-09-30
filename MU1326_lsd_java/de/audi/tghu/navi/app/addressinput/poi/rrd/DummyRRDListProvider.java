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
    public NavLocationWgs84[] getRRDCalculationList() {
        return new NavLocationWgs84[0];
    }

    public void updateDirectionAndAirDistance(PosPosition posPosition) {
    }

    public int getRRDListCalculationLimit() {
        return 0;
    }

    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    public void unitsChanged() {
    }
}

