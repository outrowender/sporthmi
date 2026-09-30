/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.base.DSIListener;
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

public interface DSICarDriverAssistanceListener
extends DSIListener {
    public void updateACCViewOptions(ACCViewOptions var1, int var2);

    public void updateACCGongState(boolean var1, int var2);

    public void updateACCGongVolume(int var1, int var2);

    public void updateACCDrivingProgram(int var1, int var2);

    public void updateACCTimeGap(int var1, int var2);

    public void updateACCDefaultMode(int var1, int var2);

    public void updateACCCurveAssist(boolean var1, int var2);

    public void updateACCSpeedLimitAdoption(boolean var1, int var2);

    public void updateACCTrafficJamAssist(boolean var1, int var2);

    public void updateACCSpeedLimitOffset(int var1, int var2);

    public void updateACCDistanceWarning(ACCDistanceWarning var1, int var2);

    public void updatePACCSensibility(boolean var1, int var2);

    public void updatePACCMaxSpeed(CarBCSpeed var1, int var2);

    public void updatePACCMeanVelocity(CarBCSpeed var1, int var2);

    public void updatePACCMeanConsumption(CarBCConsumption var1, int var2);

    public void updatePACCCoastingPercentage(int var1, int var2);

    public void updatePACCDrivingProgram(int var1, int var2);

    public void updatePACCSystemState(int var1, int var2);

    public void acknowledgeACCSetFactoryDefault(boolean var1);

    public void updateAWVDistanceWarning(boolean var1, int var2);

    public void updateAWVViewOptions(AWVViewOptions var1, int var2);

    public void updateAWVSystem(int var1, int var2);

    public void updateAWVWarning(boolean var1, int var2);

    public void updateAWVGong(boolean var1, int var2);

    public void updateAWVGongVolume(int var1, int var2);

    public void updateAWVBrakeJerk(boolean var1, int var2);

    public void updateAWVEmergencyBrake(AWVEmergencyBrake var1, int var2);

    public void updateAWVWarningTimegap(int var1, int var2);

    public void acknowledgeAWVSetFactoryDefault(boolean var1);

    public void updateSWAViewOptions(SWAViewOptions var1, int var2);

    public void updateSWABrightness(int var1, int var2);

    public void updateSWAWarningTime(int var1, int var2);

    public void updateSWAFrequency(int var1, int var2);

    public void updateSWASystem(int var1, int var2);

    public void updateSWAGongState(boolean var1, int var2);

    public void updateSWAGongVolume(int var1, int var2);

    public void updateSWARCTASensorData(SWARCTASensorData var1, int var2);

    public void updateSWARCTA(boolean var1, int var2);

    public void updateSWAExitAssist(boolean var1, int var2);

    public void updateNVViewOptions(NVViewOptions var1, int var2);

    public void updateNVActivation(boolean var1, int var2);

    public void updateNVContrast(int var1, int var2);

    public void updateNVBrightness(int var1, int var2);

    public void updateNVObjectDetection(NVObjectDetection var1, int var2);

    public void updateNVColorPA(int var1, int var2);

    public void updateNVDesignPA(int var1, int var2);

    public void updateNVDisplay(int var1, int var2);

    public void updateNVZoomPanning(int var1, int var2);

    public void updateNVSound(int var1, int var2);

    public void updateNVSymbol(boolean var1, int var2);

    public void acknowledgeNVSetFactoryDefault(boolean var1);

    public void updateNVSystem(boolean var1, int var2);

    public void updateNVWarningTimegap(int var1, int var2);

    public void updateLDWHCAViewOptions(LDWHCAViewOptions var1, int var2);

    public void updateLDWWarningTime(int var1, int var2);

    public void updateLDWSteeringWheelVibration(int var1, int var2);

    public void updateHCAInterventionStyle(int var1, int var2);

    public void updateHCAToleranceLevel(int var1, int var2);

    public void acknowledgeLdwhcaSetFactoryDefault(boolean var1);

    public void updateLDWHCASystemOnOff(boolean var1, int var2);

    public void updateLDWHCAWarningSound(boolean var1, int var2, int var3);

    public void updateTSDViewOptions(TSDViewOptions var1, int var2);

    public void updateTSDSystemOnOff(boolean var1, int var2);

    public void updateTSDTrailerDetection(boolean var1, int var2);

    public void updateTSDSign1(TSDSignFct var1, int var2);

    public void updateTSDSign2(TSDSignFct var1, int var2);

    public void updateTSDSign3(TSDSignFct var1, int var2);

    public void updateTSDSign4(TSDSignFct var1, int var2);

    public void updateTSDSign5(TSDSignFct var1, int var2);

    public void updateTSDRoadSignFilter(TSDRoadSignFilter var1, int var2);

    public void acknowledgeTsdSetFactoryDefault(boolean var1);

    public void updateTSDSpeedWarningThreshold(boolean var1, CarBCSpeed var2, int var3);

    public void updateTSDTrailerSpeedLimit(CarBCSpeed var1, int var2);

    public void updateTSDSystemMessages(TSDSystemMessages var1, int var2);

    public void updateTSDSpeedWarningAcoustics(boolean var1, int var2);

    public void updateMKEViewOptions(MKEViewOptions var1, int var2);

    public void updateMKESystemOnOff(boolean var1, int var2);

    public void acknowledgeMKESetFactoryDefault(boolean var1);

    public void updatePAViewOptions(PAViewOptions var1, int var2);

    public void updatePASystemOnOff(boolean var1, int var2);

    public void acknowledgePASetFactoryDefault(boolean var1);

    public void updatePAConfigInformation(boolean var1, int var2);

    public void updatePAConfigWarning(boolean var1, int var2);

    public void updatePAWarningTimegap(int var1, int var2);

    public void updateCurveAssistSystemOnOff(boolean var1, int var2);

    public void acknowledgeCurveAssistSetFactoryDefault(boolean var1);

    public void updateFTAViewOptions(FTAViewOptions var1, int var2);

    public void updateFTASystemOnOff(boolean var1, int var2);

    public void updateFTASensorData(FTASensorData var1, int var2);
}

