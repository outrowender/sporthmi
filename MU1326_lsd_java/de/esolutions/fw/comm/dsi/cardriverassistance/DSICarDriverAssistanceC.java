/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSICarDriverAssistanceC {
    public void setACCGongState(boolean var1) throws MethodException;

    public void setACCGongVolume(int var1) throws MethodException;

    public void setACCDrivingProgram(int var1) throws MethodException;

    public void setACCTimeGap(int var1) throws MethodException;

    public void setACCDefaultMode(int var1) throws MethodException;

    public void setACCCurveAssist(boolean var1) throws MethodException;

    public void setACCSpeedLimitAdoption(boolean var1) throws MethodException;

    public void setACCTrafficJamAssist(boolean var1) throws MethodException;

    public void setACCSpeedLimitOffset(int var1) throws MethodException;

    public void setACCDistanceWarning(ACCDistanceWarning var1) throws MethodException;

    public void setACCSetFactoryDefault() throws MethodException;

    public void setPACCSensibility(boolean var1) throws MethodException;

    public void setPACCMaxSpeed(int var1, int var2) throws MethodException;

    public void setPACCDrivingProgram(int var1) throws MethodException;

    public void setAWVSystem(int var1) throws MethodException;

    public void setAWVWarning(boolean var1) throws MethodException;

    public void setAWVGong(boolean var1) throws MethodException;

    public void setAWVGongVolume(int var1) throws MethodException;

    public void setAWVBrakeJerk(boolean var1) throws MethodException;

    public void setAWVEmergencyBrake(AWVEmergencyBrake var1) throws MethodException;

    public void setAWVDistanceWarning(boolean var1) throws MethodException;

    public void setAWVWarningTimegap(int var1) throws MethodException;

    public void setAWVSetFactoryDefault() throws MethodException;

    public void setSWABrightness(int var1) throws MethodException;

    public void setSWAWarningTime(int var1) throws MethodException;

    public void setSWAFrequency(int var1) throws MethodException;

    public void setSWASystem(int var1) throws MethodException;

    public void setSWAGongState(boolean var1) throws MethodException;

    public void setSWAGongVolume(int var1) throws MethodException;

    public void setSWARCTA(boolean var1) throws MethodException;

    public void setSWAExitAssist(boolean var1) throws MethodException;

    public void setNVActivation(boolean var1) throws MethodException;

    public void setNVContrast(int var1) throws MethodException;

    public void setNVBrightness(int var1) throws MethodException;

    public void setNVObjectDetection(NVObjectDetection var1) throws MethodException;

    public void setNVColorPA(int var1) throws MethodException;

    public void setNVDesignPA(int var1) throws MethodException;

    public void setNVDisplay(int var1) throws MethodException;

    public void setNVZoomPanning(int var1) throws MethodException;

    public void setNVSound(int var1) throws MethodException;

    public void setNVSymbol(boolean var1) throws MethodException;

    public void setNVSetFactoryDefault() throws MethodException;

    public void setNVWarningTimegap(int var1) throws MethodException;

    public void setNVSystem(boolean var1) throws MethodException;

    public void setLDWWarningTime(int var1) throws MethodException;

    public void setLDWSteeringWheelVibration(int var1) throws MethodException;

    public void setHCAInterventionStyle(int var1) throws MethodException;

    public void setHCAToleranceLevel(int var1) throws MethodException;

    public void setLdwhcaSetFactoryDefault() throws MethodException;

    public void setLDWHCASystemOnOff(boolean var1) throws MethodException;

    public void setLDWHCAWarningSound(boolean var1, int var2) throws MethodException;

    public void setTSDSystemOnOff(boolean var1) throws MethodException;

    public void setTSDRoadSignFilter(TSDRoadSignFilter var1) throws MethodException;

    public void setTsdSetFactoryDefault() throws MethodException;

    public void setTSDSpeedWarningThreshold(boolean var1, CarBCSpeed var2) throws MethodException;

    public void setTSDTrailerSpeedLimit(CarBCSpeed var1) throws MethodException;

    public void setTSDSpeedWarningAcoustics(boolean var1) throws MethodException;

    public void setMKESystemOnOff(boolean var1) throws MethodException;

    public void setMKESetFactoryDefault() throws MethodException;

    public void setPASystemOnOff(boolean var1) throws MethodException;

    public void setPASetFactoryDefault() throws MethodException;

    public void setPAConfigInformation(boolean var1) throws MethodException;

    public void setPAConfigWarning(boolean var1) throws MethodException;

    public void setPAWarningTimegap(int var1) throws MethodException;

    public void setCurveAssistSystemOnOff(boolean var1) throws MethodException;

    public void setCurveAssistSetFactoryDefault() throws MethodException;

    public void setFTASystemOnOff(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

