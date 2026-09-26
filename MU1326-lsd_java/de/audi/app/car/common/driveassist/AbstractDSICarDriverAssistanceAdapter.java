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

    @Override
    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = AbstractDSICarDriverAssistanceAdapter.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener).getName();
    }

    @Override
    public final String getDSIClassName() {
        return (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = AbstractDSICarDriverAssistanceAdapter.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance).getName();
    }

    @Override
    public final boolean isUsingDSI() {
        return true;
    }

    @Override
    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateACCGongState(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateACCGongVolume(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateACCDrivingProgram(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateACCTimeGap(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateACCDefaultMode(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAWVDistanceWarning(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateAWVSystem(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAWVWarning(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAWVGong(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAWVGongVolume(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAWVBrakeJerk(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake, int n) {
        this.logStub();
    }

    @Override
    public void updateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateSWABrightness(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSWAWarningTime(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSWAFrequency(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSWASystem(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSWAGongState(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSWAGongVolume(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateNVActivation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateNVContrast(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateNVBrightness(int n, int n2) {
        this.logStub();
    }

    public void updateNVPedestrianAssistance(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateNVColorPA(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateNVDesignPA(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateNVDisplay(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateNVZoomPanning(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateNVSound(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateNVSymbol(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateLDWWarningTime(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateLDWSteeringWheelVibration(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateHCAInterventionStyle(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateHCAToleranceLevel(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDTrailerDetection(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSign1(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSign2(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSign3(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter, int n) {
        this.logStub();
    }

    @Override
    public void updateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateMKESystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeLdwhcaSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeTsdSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateACCCurveAssist(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateACCSpeedLimitAdoption(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateACCTrafficJamAssist(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateACCSpeedLimitOffset(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeACCSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
        this.logStub();
    }

    @Override
    public void updateSWARCTA(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSWAExitAssist(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateNVObjectDetection(NVObjectDetection nVObjectDetection, int n) {
        this.logStub();
    }

    @Override
    public void updateLDWHCASystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSystemMessages(TSDSystemMessages tSDSystemMessages, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeMKESetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updatePAViewOptions(PAViewOptions pAViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updatePASystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgePASetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updatePAConfigInformation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePAConfigWarning(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateCurveAssistSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeCurveAssistSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateAWVWarningTimegap(int n, int n2) {
        this.logStub();
    }

    @Override
    public void acknowledgeAWVSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updatePAWarningTimegap(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePACCSensibility(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePACCMaxSpeed(CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    @Override
    public void updatePACCMeanVelocity(CarBCSpeed carBCSpeed, int n) {
        this.logStub();
    }

    @Override
    public void updatePACCMeanConsumption(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    @Override
    public void updatePACCCoastingPercentage(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePACCDrivingProgram(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePACCSystemState(int n, int n2) {
        this.logStub();
    }

    @Override
    public void acknowledgeNVSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateNVSystem(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateNVWarningTimegap(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateLDWHCAWarningSound(boolean bl, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateTSDSign4(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSign5(TSDSignFct tSDSignFct, int n) {
        this.logStub();
    }

    @Override
    public void updateTSDSpeedWarningAcoustics(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateFTAViewOptions(FTAViewOptions fTAViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateFTASystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
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

