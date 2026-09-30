/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.tghu.navi.app.addressinput.poi.rrd.IDistanceContainer;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class DummyDistanceContainer
implements IDistanceContainer {
    public RrdCalculationInfo getDistance(int n) {
        return null;
    }

    public void storeRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }
}

