/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IRRDListener {
    default public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    default public void enterRRD(int n) {
    }

    default public void exitRRD(int n) {
    }

    default public void cleanUp() {
    }
}

