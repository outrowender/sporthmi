/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mobilityhorizon;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizonListener
extends DSIListener {
    public void updateLocations(MobilityHorizonLocation[] var1, int var2);

    public void updateConsideredLocationTypes(int[] var1, int var2);

    public void updateDriveTrainMode(int var1, int var2);

    public void updateMobilityHorizonStatus(int var1, int var2);

    public void requestLocationRangeLevelResult(int var1, int var2);

    public void locationRangeLevelChanged(int var1);
}

