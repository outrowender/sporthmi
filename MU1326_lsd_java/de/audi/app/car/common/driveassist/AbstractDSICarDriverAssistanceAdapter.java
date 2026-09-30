/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
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

public abstract class AbstractDSICarDriverAssistanceAdapter
extends AbstractCarComponent
implements DSICarDriverAssistanceListener {
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;

    public AbstractDSICarDriverAssistanceAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarDriverAssistance getDSI() {
        return (DSICarDriverAssistance)this.getBaseDSI();
    }

    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = AbstractDSICarDriverAssistanceAdapter.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener).getName();
    }

    public final String getDSIClassName() {
        return (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = AbstractDSICarDriverAssistanceAdapter.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance).getName();
    }

    public final boolean isUsingDSI() {
        return true;
    }

    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        this.logStub();
    }

    public void updateACCGongState(boolean bl, int n) {
        this.logStub();
    }

    public void updateACCGongVolume(int n, int n2) {
        this.logStub();
    }

    public void updateACCDrivingProgram(int n, int n2) {
        this.logStub();
    }

    public void updateACCTimeGap(int n, int n2) {
        this.logStub();
    }

    public void updateACCDefaultMode(int n, int n2) {
        this.logStub();
    }

    public void updateAWVDistanceWarning(boolean bl, int n) {
        this.logStub();
    }

    public void updateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        this.logStub();
    }

    public void updateAWVSystem(int n, int n2) {
        this.logStub();
    }

    public void updateAWVWarning(boolean bl, int n) {
        this.logStub();
    }

    public void updateAWVGong(boolean bl, int n) {
        this.logStub();
    }

    public void updateAWVGongVolume(int n, int n2) {
        this.logStub();
    }

    public void updateAWVBrakeJerk(boolean bl, int n) {
        this.logStub();
    }

    public void updateAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake, int n) {
        this.logStub();
    }

    public void updateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        this.logStub();
    }

    public void updateSWABrightness(int n, int n2) {
        this.logStub();
    }

    public void updateSWAWarningTime(int n, int n2) {
        this.logStub();
    }

    public void updateSWAFrequency(int n, int n2) {
        this.logStub();
    }

    public void updateSWASystem(int n, int n2) {
        this.logStub();
    }

    public void updateSWAGongState(boolean bl, int n) {
        this.logStub();
    }

    public void updateSWAGongVolume(int n, int n2) {
        this.logStub();
    }

    public void updateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        this.logStub();
    }

    public void updateNVActivation(boolean bl, int n) {
        this.logStub();
    }

    public void updateNVContrast(int n, int n2) {
        this.logStub();
    }

    public void updateNVBrightness(int n, int n2) {
        this.logStub();
    }

    public void updateNVPedestrianAssistance(boolean bl, int n) {
        this.logStub();
    }

    public void updateNVColorPA(int n, int n2) {
        this.logStub();
    }

    public void updateNVDesignPA(int n, int n2) {
        this.logStub();
    }

    public void updateNVDisplay(int n, int n2) {
        this.logStub();
    }

    public void updateNVZoomPanning(int n, int n2) {
        this.logStub();
    }

    public void updateNVSound(int n, int n2) {
        this.logStub();
    }

    public void updateNVSymbol(boolean bl, int n) {
        this.logStub();
    }

    public void updateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        this.logStub();
    }

    public void updateLDWWarningTime(int n, int n2) {
        this.logStub();
    }

    public void updateLDWSteeringWheelVibration(int n, int n2) {
        this.logStub();
    }

    public void updateHCAInterventionStyle(int n, int n2) {
        this.logStub();
    }

    public void updateHCAToleranceLevel(int n, int n2) {
        this.logStub();
    }

    public void updateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        this.logStub();
    }

    public void updateTSDSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void updateTSDTrailerDetection(boolean bl, int n) {
        this.logStub();
    }

    public void updateTSDSign1(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    public void updateTSDSign2(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    public void updateTSDSign3(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    public void updateTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter, int n) {
        this.logStub();
    }

    public void updateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        this.logStub();
    }

    public void updateMKESystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgeLdwhcaSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeTsdSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateACCCurveAssist(boolean bl, int n) {
        this.logStub();
    }

    public void updateACCSpeedLimitAdoption(boolean bl, int n) {
        this.logStub();
    }

    public void updateACCTrafficJamAssist(boolean bl, int n) {
        this.logStub();
    }

    public void updateACCSpeedLimitOffset(int n, int n2) {
        this.logStub();
    }

    public void updateACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning, int n) {
        this.logStub();
    }

    public void acknowledgeACCSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
        this.logStub();
    }

    public void updateSWARCTA(boolean bl, int n) {
        this.logStub();
    }

    public void updateSWAExitAssist(boolean bl, int n) {
        this.logStub();
    }

    public void updateNVObjectDetection(NVObjectDetection nVObjectDetection, int n) {
        this.logStub();
    }

    public void updateLDWHCASystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void updateTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    public void updateTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    public void updateTSDSystemMessages(TSDSystemMessages tSDSystemMessages, int n) {
        this.logStub();
    }

    public void acknowledgeMKESetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updatePAViewOptions(PAViewOptions pAViewOptions, int n) {
        this.logStub();
    }

    public void updatePASystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgePASetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updatePAConfigInformation(boolean bl, int n) {
        this.logStub();
    }

    public void updatePAConfigWarning(boolean bl, int n) {
        this.logStub();
    }

    public void updateCurveAssistSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgeCurveAssistSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateAWVWarningTimegap(int n, int n2) {
        this.logStub();
    }

    public void acknowledgeAWVSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updatePAWarningTimegap(int n, int n2) {
        this.logStub();
    }

    public void updatePACCSensibility(boolean bl, int n) {
        this.logStub();
    }

    public void updatePACCMaxSpeed(CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    public void updatePACCMeanVelocity(CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    public void updatePACCMeanConsumption(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updatePACCCoastingPercentage(int n, int n2) {
        this.logStub();
    }

    public void updatePACCDrivingProgram(int n, int n2) {
        this.logStub();
    }

    public void updatePACCSystemState(int n, int n2) {
        this.logStub();
    }

    public void acknowledgeNVSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateNVSystem(boolean bl, int n) {
        this.logStub();
    }

    public void updateNVWarningTimegap(int n, int n2) {
        this.logStub();
    }

    public void updateLDWHCAWarningSound(boolean bl, int n, int n2) {
        this.logStub();
    }

    public void updateTSDSign4(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    public void updateTSDSign5(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    public void updateTSDSpeedWarningAcoustics(boolean bl, int n) {
        this.logStub();
    }

    public void updateFTAViewOptions(FTAViewOptions fTAViewOptions, int n) {
        this.logStub();
    }

    public void updateFTASystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void updateFTASensorData(FTASensorData fTASensorData, int n) {
        this.logStub();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

