/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.FTASensorData;
import org.dsi.ifc.cardriverassistance.FTAViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDSystemMessages;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSICarDriverAssistanceReply {
    public static final String IPL_COMM_UUID = "1b8b4cb5-341f-5615-b7d8-31e37f3889c7";
    public static final String IPL_COMM_INTERFACE_KEY = "af7b3820-5766-5f83-9d75-8c232c3d0d2e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.22";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.22";

    public void updateACCViewOptions(ACCViewOptions var1, int var2) throws MethodException;

    public void updateACCGongState(boolean var1, int var2) throws MethodException;

    public void updateACCGongVolume(int var1, int var2) throws MethodException;

    public void updateACCDrivingProgram(int var1, int var2) throws MethodException;

    public void updateACCTimeGap(int var1, int var2) throws MethodException;

    public void updateACCDefaultMode(int var1, int var2) throws MethodException;

    public void updateACCCurveAssist(boolean var1, int var2) throws MethodException;

    public void updateACCSpeedLimitAdoption(boolean var1, int var2) throws MethodException;

    public void updateACCTrafficJamAssist(boolean var1, int var2) throws MethodException;

    public void updateACCSpeedLimitOffset(int var1, int var2) throws MethodException;

    public void updateACCDistanceWarning(ACCDistanceWarning var1, int var2) throws MethodException;

    public void updatePACCSensibility(boolean var1, int var2) throws MethodException;

    public void updatePACCMaxSpeed(CarBCSpeed var1, int var2) throws MethodException;

    public void updatePACCMeanVelocity(CarBCSpeed var1, int var2) throws MethodException;

    public void updatePACCMeanConsumption(CarBCConsumption var1, int var2) throws MethodException;

    public void updatePACCCoastingPercentage(int var1, int var2) throws MethodException;

    public void updatePACCDrivingProgram(int var1, int var2) throws MethodException;

    public void updatePACCSystemState(int var1, int var2) throws MethodException;

    public void acknowledgeACCSetFactoryDefault(boolean var1) throws MethodException;

    public void updateAWVDistanceWarning(boolean var1, int var2) throws MethodException;

    public void updateAWVViewOptions(AWVViewOptions var1, int var2) throws MethodException;

    public void updateAWVSystem(int var1, int var2) throws MethodException;

    public void updateAWVWarning(boolean var1, int var2) throws MethodException;

    public void updateAWVGong(boolean var1, int var2) throws MethodException;

    public void updateAWVGongVolume(int var1, int var2) throws MethodException;

    public void updateAWVBrakeJerk(boolean var1, int var2) throws MethodException;

    public void updateAWVEmergencyBrake(AWVEmergencyBrake var1, int var2) throws MethodException;

    public void updateAWVWarningTimegap(int var1, int var2) throws MethodException;

    public void acknowledgeAWVSetFactoryDefault(boolean var1) throws MethodException;

    public void updateSWAViewOptions(SWAViewOptions var1, int var2) throws MethodException;

    public void updateSWABrightness(int var1, int var2) throws MethodException;

    public void updateSWAWarningTime(int var1, int var2) throws MethodException;

    public void updateSWAFrequency(int var1, int var2) throws MethodException;

    public void updateSWASystem(int var1, int var2) throws MethodException;

    public void updateSWAGongState(boolean var1, int var2) throws MethodException;

    public void updateSWAGongVolume(int var1, int var2) throws MethodException;

    public void updateSWARCTASensorData(SWARCTASensorData var1, int var2) throws MethodException;

    public void updateSWARCTA(boolean var1, int var2) throws MethodException;

    public void updateSWAExitAssist(boolean var1, int var2) throws MethodException;

    public void updateNVViewOptions(NVViewOptions var1, int var2) throws MethodException;

    public void updateNVActivation(boolean var1, int var2) throws MethodException;

    public void updateNVContrast(int var1, int var2) throws MethodException;

    public void updateNVBrightness(int var1, int var2) throws MethodException;

    public void updateNVObjectDetection(NVObjectDetection var1, int var2) throws MethodException;

    public void updateNVColorPA(int var1, int var2) throws MethodException;

    public void updateNVDesignPA(int var1, int var2) throws MethodException;

    public void updateNVDisplay(int var1, int var2) throws MethodException;

    public void updateNVZoomPanning(int var1, int var2) throws MethodException;

    public void updateNVSound(int var1, int var2) throws MethodException;

    public void updateNVSymbol(boolean var1, int var2) throws MethodException;

    public void acknowledgeNVSetFactoryDefault(boolean var1) throws MethodException;

    public void updateNVSystem(boolean var1, int var2) throws MethodException;

    public void updateNVWarningTimegap(int var1, int var2) throws MethodException;

    public void updateLDWHCAViewOptions(LDWHCAViewOptions var1, int var2) throws MethodException;

    public void updateLDWWarningTime(int var1, int var2) throws MethodException;

    public void updateLDWSteeringWheelVibration(int var1, int var2) throws MethodException;

    public void updateHCAInterventionStyle(int var1, int var2) throws MethodException;

    public void updateHCAToleranceLevel(int var1, int var2) throws MethodException;

    public void acknowledgeLdwhcaSetFactoryDefault(boolean var1) throws MethodException;

    public void updateLDWHCASystemOnOff(boolean var1, int var2) throws MethodException;

    public void updateLDWHCAWarningSound(boolean var1, int var2, int var3) throws MethodException;

    public void updateTSDViewOptions(TSDViewOptions var1, int var2) throws MethodException;

    public void updateTSDSystemOnOff(boolean var1, int var2) throws MethodException;

    public void updateTSDTrailerDetection(boolean var1, int var2) throws MethodException;

    public void updateTSDSign1(TSDSignFct var1, int var2) throws MethodException;

    public void updateTSDSign2(TSDSignFct var1, int var2) throws MethodException;

    public void updateTSDSign3(TSDSignFct var1, int var2) throws MethodException;

    public void updateTSDSign4(TSDSignFct var1, int var2) throws MethodException;

    public void updateTSDSign5(TSDSignFct var1, int var2) throws MethodException;

    public void updateTSDRoadSignFilter(TSDRoadSignFilter var1, int var2) throws MethodException;

    public void acknowledgeTsdSetFactoryDefault(boolean var1) throws MethodException;

    public void updateTSDSpeedWarningThreshold(boolean var1, CarBCSpeed var2, int var3) throws MethodException;

    public void updateTSDTrailerSpeedLimit(CarBCSpeed var1, int var2) throws MethodException;

    public void updateTSDSystemMessages(TSDSystemMessages var1, int var2) throws MethodException;

    public void updateTSDSpeedWarningAcoustics(boolean var1, int var2) throws MethodException;

    public void updateMKEViewOptions(MKEViewOptions var1, int var2) throws MethodException;

    public void updateMKESystemOnOff(boolean var1, int var2) throws MethodException;

    public void acknowledgeMKESetFactoryDefault(boolean var1) throws MethodException;

    public void updatePAViewOptions(PAViewOptions var1, int var2) throws MethodException;

    public void updatePASystemOnOff(boolean var1, int var2) throws MethodException;

    public void acknowledgePASetFactoryDefault(boolean var1) throws MethodException;

    public void updatePAConfigInformation(boolean var1, int var2) throws MethodException;

    public void updatePAConfigWarning(boolean var1, int var2) throws MethodException;

    public void updatePAWarningTimegap(int var1, int var2) throws MethodException;

    public void updateCurveAssistSystemOnOff(boolean var1, int var2) throws MethodException;

    public void acknowledgeCurveAssistSetFactoryDefault(boolean var1) throws MethodException;

    public void updateFTAViewOptions(FTAViewOptions var1, int var2) throws MethodException;

    public void updateFTASystemOnOff(boolean var1, int var2) throws MethodException;

    public void updateFTASensorData(FTASensorData var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

