/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirQuality;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirConditionListener;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class AbstractDSICarAirCondition
implements DSICarAirConditionListener {
    protected LogChannel logger;

    public AbstractDSICarAirCondition(LogChannel logChannel) {
        this.logger = logChannel;
    }

    protected void logStub() {
        try {
            StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
            String string = "??";
            if (stackTraceElementArray.length > 1) {
                StackTraceElement stackTraceElement = stackTraceElementArray[1];
                string = new StringBuffer().append(stackTraceElement.getClassName()).append(".").append(stackTraceElementArray[1].getMethodName()).toString();
            }
            this.logger.log(1078071040, "%1 not implemented", (Object)string);
        }
        catch (Exception exception) {
            this.logger.log(10000, "Exception: ", (Throwable)exception);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logStub();
    }

    @Override
    public void requestAirconPopup(AirconContent airconContent) {
        this.logStub();
    }

    @Override
    public void acknowlegdeAirconPopup(AirconContent airconContent) {
        this.logStub();
    }

    @Override
    public void updateAirconContent(AirconContent airconContent, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirCirculationMan(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirCirculationAuto(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirCirculationSensitivity(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconAirCirculationMiddleExhaustion(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconRearWindowHeater(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconIndirectVentilation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconPopupTime(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconHeater(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconRearAuxHeater(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFrontWindowHeater(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconDefrost(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconMaxDefrost(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSolar(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAC(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconMaxAC(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconRearControl(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
        this.logStub();
    }

    public void updateAirconStyle(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconFrontWindowHeaterAuto(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSuppressVisualisation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconResidualHeat(boolean bl, int n) {
        this.logStub();
    }

    public void updateAirconSystemOnOffMaster(boolean bl, int n) {
        this.logStub();
    }

    public void updateAirconSystemOnOffSlave1(boolean bl, int n) {
        this.logStub();
    }

    public void updateAirconSystemOnOffSlave2(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFootwellTempZone1(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone1(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone1(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFootwellTempZone2(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone2(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone2(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFootwellTempZone3(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone3(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone3(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFootwellTempZone4(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone4(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone4(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconTempZone5(AirconTemp airconTemp, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirVolumeZone5(AirconAirVolume airconAirVolume, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirDistributionZone5(AirconAirDistribution airconAirDistribution, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFootwellTempZone5(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone5(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone5(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconTempZone6(AirconTemp airconTemp, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirVolumeZone6(AirconAirVolume airconAirVolume, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirDistributionZone6(AirconAirDistribution airconAirDistribution, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFootwellTempZone6(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone6(int n, int n2) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone6(int n, int n2) {
        this.logStub();
    }

    public void acknowledgeAirconSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone5(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone6(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone5(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone6(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconTempStepZone1(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconTempStepZone2(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconTempStepZone3(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconTempStepZone4(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconTempStepZone5(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconTempStepZone6(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconEcoAC(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconRearControlFondPlus(boolean bl, int n) {
        this.logStub();
    }

    public void updateAirconIonisator(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSystemOnOffRow2(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSystemOnOffRow3(boolean bl, int n) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone1New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone1New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone2New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone2New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone3New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone3New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone4New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone4New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone5New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone5New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatHeaterZone6New(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateAirconSeatVentilationZone6New(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconViewOptionsRow3(AirconRowViewOptions airconRowViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeAirconSetFactoryDefaultMaster(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeAirconSetFactoryDefaultRow(int n, boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
        this.logStub();
    }

    @Override
    public void acknowledgeAirconNozzleControlRow2(boolean bl, boolean bl2) {
        this.logStub();
    }

    @Override
    public void acknowledgeAirconNozzleControlRow3(boolean bl, boolean bl2) {
        this.logStub();
    }

    @Override
    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        this.logStub();
    }

    @Override
    public void responseAirconNozzleListRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        this.logStub();
    }

    @Override
    public void responseAirconNozzleListRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow1(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow2(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow3(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSideWindowDefrost(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconPureAir(AirconPureAirSetup airconPureAirSetup, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconFreshAirState(AirconFreshAirCartridge airconFreshAirCartridge, AirconFreshAirCartridge airconFreshAirCartridge2, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconAirQuality(AirconAirQuality airconAirQuality, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleStatusRow1(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleStatusRow2(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconNozzleStatusRow3(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStyleZone1(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStyleZone2(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStyleZone3(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStyleZone4(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStyleZone5(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStyleZone6(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStateZone1(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStateZone2(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStateZone3(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStateZone4(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStateZone5(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconClimateStateZone6(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatNeckHeaterZone1(boolean bl, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatNeckHeaterZone2(boolean bl, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatNeckHeaterZone3(boolean bl, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatNeckHeaterZone4(boolean bl, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatNeckHeaterZone5(boolean bl, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatNeckHeaterZone6(boolean bl, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone1(boolean bl, boolean bl2, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone2(boolean bl, boolean bl2, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone3(boolean bl, boolean bl2, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone4(boolean bl, boolean bl2, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone5(boolean bl, boolean bl2, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone6(boolean bl, boolean bl2, int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconIndividualClimatisationZone1(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconIndividualClimatisationZone2(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconIndividualClimatisationZone3(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconIndividualClimatisationZone4(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconIndividualClimatisationZone5(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconIndividualClimatisationZone6(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconIonisatorZone1(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconIonisatorZone2(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconIonisatorZone3(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconIonisatorZone4(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconIonisatorZone5(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconIonisatorZone6(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone1(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone2(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone3(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone4(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone5(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone6(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterZone1(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterZone2(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterZone3(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterZone4(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterZone5(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatHeaterZone6(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationZone1(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationZone2(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationZone3(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationZone4(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationZone5(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateAirconSeatVentilationZone6(int n, int n2, int n3) {
        this.logStub();
    }
}

