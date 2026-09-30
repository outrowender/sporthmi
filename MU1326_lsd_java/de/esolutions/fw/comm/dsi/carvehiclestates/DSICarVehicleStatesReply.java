/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSICarVehicleStatesReply {
    public static final String IPL_COMM_UUID = "01233b5d-75cd-5163-928f-f10a23ccd2e7";
    public static final String IPL_COMM_INTERFACE_KEY = "49b8560c-29e3-50ed-b6e3-35667b14ad8f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.28";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.28";

    public void updateOilLevelViewOption(CarViewOption var1, int var2) throws MethodException;

    public void updateOilLevelData(OilLevelData var1, int var2) throws MethodException;

    public void updateVINViewOption(CarViewOption var1, int var2) throws MethodException;

    public void updateVINData(String var1, int var2) throws MethodException;

    public void updateKeyViewOption(CarViewOption var1, int var2) throws MethodException;

    public void updateKeyData(KeyData var1, int var2) throws MethodException;

    public void updateDrvSchoolSystem(boolean var1, int var2) throws MethodException;

    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions var1, int var2) throws MethodException;

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions var1, int var2) throws MethodException;

    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions var1, int var2) throws MethodException;

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent var1, int var2) throws MethodException;

    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent var1, int var2) throws MethodException;

    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions var1, int var2) throws MethodException;

    public void updateSemiStaticVehicleData(SemiStaticVehicleData var1, int var2) throws MethodException;

    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

