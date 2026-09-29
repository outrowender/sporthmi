/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKWheelPressures;

public interface IRDKTireDisplay {
    default public void initialize() {
    }

    default public void updateDisplayData(RDKTireDisplayData rDKTireDisplayData) {
    }

    default public void updateTireSetupTireList(RDKTireInfo[] rDKTireInfoArray) {
    }

    default public void updateTireSetupSelectedTire(int n) {
    }

    default public void updateSpeedLimit(int n) {
    }

    default public void updateDifferentialPressure(RDKWheelPressures rDKWheelPressures) {
    }
}

