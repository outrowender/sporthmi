/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.tghu.navi.app.addressinput.poi.rrd.IDistanceContainer;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class DistanceContainer
implements IDistanceContainer {
    private RrdCalculationInfo[] distances;

    public DistanceContainer(int n) {
        this.distances = new RrdCalculationInfo[n];
        this.resetDistances();
    }

    private void resetDistances() {
        if (this.distances != null) {
            this.distances = new RrdCalculationInfo[this.distances.length];
        }
    }

    @Override
    public RrdCalculationInfo getDistance(int n) {
        RrdCalculationInfo rrdCalculationInfo = null;
        if (this.distances != null && 0 <= n && n < this.distances.length) {
            rrdCalculationInfo = this.distances[n];
        }
        return rrdCalculationInfo;
    }

    @Override
    public void storeRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.distances = new RrdCalculationInfo[this.distances.length];
        System.arraycopy((Object)rrdCalculationInfoArray, 0, (Object)this.distances, 0, rrdCalculationInfoArray.length >= this.distances.length ? this.distances.length : rrdCalculationInfoArray.length);
    }
}

