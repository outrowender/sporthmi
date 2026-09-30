/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

public interface DSIGeneralVehicleStatesListener
extends DSIListener {
    public void updateAirbagData(AirbagData var1, int var2);

    public void updateTankInfo(TankInfo var1, int var2);

    public void updateDimmedHeadlight(boolean var1, int var2);

    public void updateAcousticParkingSystem(boolean var1, int var2);

    public void updateReverseGear(boolean var1, int var2);

    public void updateVehicleStandstill(boolean var1, int var2);

    public void updateCarVelocityThreshold(boolean var1, int var2);

    public void updateTVVelocityThreshold(boolean var1, int var2);

    public void updateHDDVelocityThreshold(boolean var1, int var2);

    public void updateBrowserSlideShowVelocityThreshold(boolean var1, int var2);

    public void updateBrowserBordBookVelocityThreshold(boolean var1, int var2);

    public void updateBrowserTravelAgentVelocityThreshold(boolean var1, int var2);

    public void updateBrowserWebVelocityThreshold(boolean var1, int var2);

    public void updateBWSVelocityThreshold(boolean var1, int var2);

    public void updateRadiotextVelocityThreshold(boolean var1, int var2);

    public void updateDisplayDayNightDesign(boolean var1, int var2);

    public void updateBTBondingVelocityThreshold(boolean var1, int var2);

    public void updateMessagingVelocityThreshold(boolean var1, int var2);

    public void updateDestinationInputVelocityThreshold(boolean var1, int var2);

    public void updateDSSSViewOption(CarViewOption var1, int var2);

    public void updateServiceKeyData(byte[] var1, int var2);

    public void updateServiceKeyViewOption(CarViewOption var1, int var2);

    public void updatePersonalizationStatus(boolean var1, int var2, int var3);

    public void updateTLOViewOptions(TLOViewOptions var1, int var2);

    public void updateEmergencyAssistVolLowering(int var1, int var2);

    public void updateParkingBrake(boolean var1, int var2);

    public void updateAppConnectTrigger(int var1, int var2);

    public void updateSTPState(int var1, int var2);

    public void updateAutomaticGearShiftTransMode(int var1, int var2);
}

