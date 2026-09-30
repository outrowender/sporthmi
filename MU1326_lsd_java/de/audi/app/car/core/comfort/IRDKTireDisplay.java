/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKWheelPressures;

public interface IRDKTireDisplay {
    public void initialize();

    public void updateDisplayData(RDKTireDisplayData var1);

    public void updateTireSetupTireList(RDKTireInfo[] var1);

    public void updateTireSetupSelectedTire(int var1);

    public void updateSpeedLimit(int var1);

    public void updateDifferentialPressure(RDKWheelPressures var1);
}

