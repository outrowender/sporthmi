/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;

public class NullDSICarDriverAssistance
implements DSICarDriverAssistance {
    private final LogChannel logChan;

    public NullDSICarDriverAssistance(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCGongState(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCGongVolume(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCDrivingProgram(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCTimeGap(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCDefaultMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVSystem(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVWarning(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVGong(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVGongVolume(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVBrakeJerk(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVDistanceWarning(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWABrightness(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWAWarningTime(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWAFrequency(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWASystem(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWAGongState(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWAGongVolume(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVActivation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVContrast(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVBrightness(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    public void setNVPedestrianAssistance(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVColorPA(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVDesignPA(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVDisplay(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVZoomPanning(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVSound(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVSymbol(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setLDWWarningTime(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setLDWSteeringWheelVibration(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setHCAInterventionStyle(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setHCAToleranceLevel(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setTSDSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setMKESystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setLdwhcaSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setTsdSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCCurveAssist(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCSpeedLimitAdoption(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCTrafficJamAssist(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    public void setACCSpeedLimitOffset(CarBCSpeed carBCSpeed) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCSpeedLimitOffset(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setACCSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWARCTA(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setSWAExitAssist(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVObjectDetection(NVObjectDetection nVObjectDetection) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setLDWHCASystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setMKESetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPASystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPASetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPAConfigInformation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPAConfigWarning(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setCurveAssistSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setCurveAssistSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVWarningTimegap(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setAWVSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPAWarningTimegap(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPACCSensibility(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPACCMaxSpeed(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setPACCDrivingProgram(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVWarningTimegap(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setNVSystem(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setLDWHCAWarningSound(boolean bl, int n) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setTSDSpeedWarningAcoustics(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }

    @Override
    public void setFTASystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDriverAssistance");
    }
}

