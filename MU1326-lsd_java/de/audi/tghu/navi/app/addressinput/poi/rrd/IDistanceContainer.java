/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IDistanceContainer {
    default public RrdCalculationInfo getDistance(int n) {
    }

    default public void storeRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }
}

