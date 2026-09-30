/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IRRDListener {
    public void updateRrdCalculationInfo(RrdCalculationInfo[] var1);

    public void enterRRD(int var1);

    public void exitRRD(int var1);

    public void cleanUp();
}

