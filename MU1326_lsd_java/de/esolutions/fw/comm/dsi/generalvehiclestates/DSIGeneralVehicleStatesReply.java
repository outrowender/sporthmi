/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

public interface DSIGeneralVehicleStatesReply {
    public static final String IPL_COMM_UUID = "be2f0709-0d19-5602-8c96-36664db9baa5";
    public static final String IPL_COMM_INTERFACE_KEY = "1478b2dc-c598-51ec-96fc-05c4419eeba2";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.18";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.18";

    public void updateAirbagData(AirbagData var1, int var2) throws MethodException;

    public void updateTankInfo(TankInfo var1, int var2) throws MethodException;

    public void updateDimmedHeadlight(boolean var1, int var2) throws MethodException;

    public void updateAcousticParkingSystem(boolean var1, int var2) throws MethodException;

    public void updateReverseGear(boolean var1, int var2) throws MethodException;

    public void updateVehicleStandstill(boolean var1, int var2) throws MethodException;

    public void updateCarVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateTVVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateHDDVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateBrowserSlideShowVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateBrowserBordBookVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateBrowserTravelAgentVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateBrowserWebVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateBWSVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateRadiotextVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateDisplayDayNightDesign(boolean var1, int var2) throws MethodException;

    public void updateBTBondingVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateMessagingVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateDestinationInputVelocityThreshold(boolean var1, int var2) throws MethodException;

    public void updateDSSSViewOption(CarViewOption var1, int var2) throws MethodException;

    public void updateServiceKeyData(byte[] var1, int var2) throws MethodException;

    public void updateServiceKeyViewOption(CarViewOption var1, int var2) throws MethodException;

    public void updatePersonalizationStatus(boolean var1, int var2, int var3) throws MethodException;

    public void updateTLOViewOptions(TLOViewOptions var1, int var2) throws MethodException;

    public void updateEmergencyAssistVolLowering(int var1, int var2) throws MethodException;

    public void updateParkingBrake(boolean var1, int var2) throws MethodException;

    public void updateAppConnectTrigger(int var1, int var2) throws MethodException;

    public void updateSTPState(int var1, int var2) throws MethodException;

    public void updateAutomaticGearShiftTransMode(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

