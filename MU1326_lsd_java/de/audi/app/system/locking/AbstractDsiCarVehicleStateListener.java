/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
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
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

abstract class AbstractDsiCarVehicleStateListener
implements DSICarVehicleStatesListener,
DSIGeneralVehicleStatesListener {
    AbstractDsiCarVehicleStateListener() {
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
    }

    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
    }

    public void updateVINViewOption(CarViewOption carViewOption, int n) {
    }

    public void updateVINData(String string, int n) {
    }

    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
    }

    public void updateKeyData(KeyData keyData, int n) {
    }

    public void updateDrvSchoolSystem(boolean bl, int n) {
    }

    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
    }

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
    }

    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
    }

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
    }

    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
    }

    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
    }

    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
    }

    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
    }

    public void updateAirbagData(AirbagData airbagData, int n) {
    }

    public void updateTankInfo(TankInfo tankInfo, int n) {
    }

    public void updateDimmedHeadlight(boolean bl, int n) {
    }

    public void updateAcousticParkingSystem(boolean bl, int n) {
    }

    public void updateReverseGear(boolean bl, int n) {
    }

    public void updateVehicleStandstill(boolean bl, int n) {
    }

    public void updateCarVelocityThreshold(boolean bl, int n) {
    }

    public void updateTVVelocityThreshold(boolean bl, int n) {
    }

    public void updateHDDVelocityThreshold(boolean bl, int n) {
    }

    public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
    }

    public void updateBrowserBordBookVelocityThreshold(boolean bl, int n) {
    }

    public void updateBrowserTravelAgentVelocityThreshold(boolean bl, int n) {
    }

    public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
    }

    public void updateBWSVelocityThreshold(boolean bl, int n) {
    }

    public void updateRadiotextVelocityThreshold(boolean bl, int n) {
    }

    public void updateDisplayDayNightDesign(boolean bl, int n) {
    }

    public void updateBTBondingVelocityThreshold(boolean bl, int n) {
    }

    public void updateMessagingVelocityThreshold(boolean bl, int n) {
    }

    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
    }

    public void updateDSSSViewOption(CarViewOption carViewOption, int n) {
    }

    public void updateServiceKeyData(byte[] byArray, int n) {
    }

    public void updateServiceKeyViewOption(CarViewOption carViewOption, int n) {
    }

    public void updatePersonalizationStatus(boolean bl, int n, int n2) {
    }

    public void updateTLOViewOptions(TLOViewOptions tLOViewOptions, int n) {
    }

    public void updateEmergencyAssistVolLowering(int n, int n2) {
    }

    public void updateParkingBrake(boolean bl, int n) {
    }

    public void updateAppConnectTrigger(int n, int n2) {
    }

    public void updateSTPState(int n, int n2) {
    }

    public void updateAutomaticGearShiftTransMode(int n, int n2) {
    }
}

