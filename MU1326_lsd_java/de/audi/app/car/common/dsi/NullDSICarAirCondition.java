/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class NullDSICarAirCondition
implements DSICarAirCondition {
    private final LogChannel logChan;

    public NullDSICarAirCondition(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconAirCirculationMan(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconAirCirculationAuto(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconMiddleExhaustion(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconRearWindowHeater(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconIndirectVentilation(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconPopupTime(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconHeater(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconRearAuxHeater(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconFrontWindowHeater(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconDefrost(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSolar(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconAC(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconRearControl(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSteeringWheelHeater(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconStyle(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconFrontWindowHeaterAuto(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconBlowerCompensation(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSynchronisation(AirconSynchronisation airconSynchronisation) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSuppressVisualisation(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSystemOnOffMaster(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSystemOnOffSlave1(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSystemOnOffSlave2(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconAirCirculationSensitivity(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconResidualHeat(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void showAirconPopup(AirconContent airconContent) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void cancelAirconPopup(AirconContent airconContent, int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconContent(AirconContent airconContent) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconTempZone(int n, AirconTemp airconTemp) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconAirVolume(int n, AirconAirVolume airconAirVolume) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconAirDistribution(int n, AirconAirDistribution airconAirDistribution) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconFootwellTemp(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSeatHeater(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSeatVentilation(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconHMIIsReady(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSetFactoryDefault() {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconMaxDefrost(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconMaxAC(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSeatHeaterDistribution(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSeatVentilationDistribution(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconTempStep(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconEcoAC(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconRearControlFondPlus(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconStyleExtended(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconIonisator(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSystemOnOffRow(int n, boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSeatHeater2(int n, int n2, int n3) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconSeatVentilation2(int n, int n2, int n3) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconClimateStyle(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSetFactoryDefaultMaster() {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSetFactoryDefaultRow(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconNozzleControlRow1(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconNozzleControlRow2(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconNozzleControlRow3(int n) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void requestAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSideWindowDefrost(boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconPureAir(AirconPureAirSetup airconPureAirSetup) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconAirQuality(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSeatNeckHeater(int n, boolean bl, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSeatSurfaceHeater(int n, boolean bl, boolean bl2, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconIndividualClimatisation(int n, boolean bl) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    public void setAirconIonisator2(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconBodyCloseMeasures(int n, boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSeatHeater(int n, int n2, int n3) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconSeatVentilation(int n, int n2, int n3) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }

    @Override
    public void setAirconIonisator(int n, int n2) {
        this.logChan.log(1000, "null-call at DSICarAirCondition");
    }
}

