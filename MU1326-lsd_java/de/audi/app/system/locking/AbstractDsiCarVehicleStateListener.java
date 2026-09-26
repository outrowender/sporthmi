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

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
    }

    @Override
    public void updateVINViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updateVINData(String string, int n) {
    }

    @Override
    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updateKeyData(KeyData keyData, int n) {
    }

    @Override
    public void updateDrvSchoolSystem(boolean bl, int n) {
    }

    @Override
    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
    }

    @Override
    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
    }

    @Override
    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
    }

    @Override
    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
    }

    @Override
    public void updateAirbagData(AirbagData airbagData, int n) {
    }

    @Override
    public void updateTankInfo(TankInfo tankInfo, int n) {
    }

    @Override
    public void updateDimmedHeadlight(boolean bl, int n) {
    }

    @Override
    public void updateAcousticParkingSystem(boolean bl, int n) {
    }

    @Override
    public void updateReverseGear(boolean bl, int n) {
    }

    @Override
    public void updateVehicleStandstill(boolean bl, int n) {
    }

    @Override
    public void updateCarVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateTVVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateHDDVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserBordBookVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserTravelAgentVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBWSVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateRadiotextVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
    }

    @Override
    public void updateBTBondingVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateMessagingVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateDSSSViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updateServiceKeyData(byte[] byArray, int n) {
    }

    @Override
    public void updateServiceKeyViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updatePersonalizationStatus(boolean bl, int n, int n2) {
    }

    @Override
    public void updateTLOViewOptions(TLOViewOptions tLOViewOptions, int n) {
    }

    @Override
    public void updateEmergencyAssistVolLowering(int n, int n2) {
    }

    @Override
    public void updateParkingBrake(boolean bl, int n) {
    }

    @Override
    public void updateAppConnectTrigger(int n, int n2) {
    }

    @Override
    public void updateSTPState(int n, int n2) {
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n, int n2) {
    }
}

