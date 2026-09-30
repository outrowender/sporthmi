/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public interface DSICarVehicleStatesListener
extends DSIListener {
    public void updateOilLevelViewOption(CarViewOption var1, int var2);

    public void updateOilLevelData(OilLevelData var1, int var2);

    public void updateVINViewOption(CarViewOption var1, int var2);

    public void updateVINData(String var1, int var2);

    public void updateKeyViewOption(CarViewOption var1, int var2);

    public void updateKeyData(KeyData var1, int var2);

    public void updateDrvSchoolSystem(boolean var1, int var2);

    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions var1, int var2);

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions var1, int var2);

    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions var1, int var2);

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent var1, int var2);

    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent var1, int var2);

    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions var1, int var2);

    public void updateSemiStaticVehicleData(SemiStaticVehicleData var1, int var2);

    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR var1, int var2);
}

