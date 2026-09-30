/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

class DSIGeneralVehicleStatesListenerBase
implements DSIGeneralVehicleStatesListener {
    DSIGeneralVehicleStatesListenerBase() {
    }

    public void asyncException(int n, String string, int n2) {
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

    public void updateAirbagData(AirbagData airbagData, int n) {
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

    public void updateSTPState(int n, int n2) {
    }

    public void updateAutomaticGearShiftTransMode(int n, int n2) {
    }

    public void updateAppConnectTrigger(int n, int n2) {
    }
}

