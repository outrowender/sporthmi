/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IRRDListProvider {
    default public NavLocationWgs84[] getRRDCalculationList() {
    }

    default public void updateDirectionAndAirDistance(PosPosition posPosition) {
    }

    default public int getRRDListCalculationLimit() {
    }

    default public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    default public void unitsChanged() {
    }
}

