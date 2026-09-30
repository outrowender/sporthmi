/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition;

import de.esolutions.fw.comm.core.method.MethodException;
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
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarAirConditionReply {
    public static final String IPL_COMM_UUID = "c791e146-d96d-50ac-96cd-5519a0a20ef4";
    public static final String IPL_COMM_INTERFACE_KEY = "30c8a0e9-7f16-5069-b300-aec7e607644e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.15";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.15";

    public void requestAirconPopup(AirconContent var1) throws MethodException;

    public void acknowlegdeAirconPopup(AirconContent var1) throws MethodException;

    public void updateAirconContent(AirconContent var1, int var2) throws MethodException;

    public void updateAirconAirCirculationMan(boolean var1, int var2) throws MethodException;

    public void updateAirconAirCirculationAuto(boolean var1, int var2) throws MethodException;

    public void updateAirconAirCirculationSensitivity(int var1, int var2) throws MethodException;

    public void updateAirconAirCirculationMiddleExhaustion(int var1, int var2) throws MethodException;

    public void updateAirconRearWindowHeater(boolean var1, int var2) throws MethodException;

    public void updateAirconIndirectVentilation(boolean var1, int var2) throws MethodException;

    public void updateAirconPopupTime(int var1, int var2) throws MethodException;

    public void updateAirconHeater(boolean var1, int var2) throws MethodException;

    public void updateAirconRearAuxHeater(boolean var1, int var2) throws MethodException;

    public void updateAirconFrontWindowHeater(boolean var1, int var2) throws MethodException;

    public void updateAirconDefrost(boolean var1, int var2) throws MethodException;

    public void updateAirconMaxDefrost(boolean var1, int var2) throws MethodException;

    public void updateAirconSolar(boolean var1, int var2) throws MethodException;

    public void updateAirconAC(boolean var1, int var2) throws MethodException;

    public void updateAirconMaxAC(boolean var1, int var2) throws MethodException;

    public void updateAirconEcoAC(boolean var1, int var2) throws MethodException;

    public void updateAirconRearControl(boolean var1, int var2) throws MethodException;

    public void updateAirconRearControlFondPlus(boolean var1, int var2) throws MethodException;

    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater var1, int var2) throws MethodException;

    public void updateAirconFrontWindowHeaterAuto(boolean var1, int var2) throws MethodException;

    public void updateAirconBlowerCompensation(AirconBlowerCompensation var1, int var2) throws MethodException;

    public void updateAirconSynchronisation(AirconSynchronisation var1, int var2) throws MethodException;

    public void updateAirconSuppressVisualisation(boolean var1, int var2) throws MethodException;

    public void updateAirconResidualHeat(boolean var1, int var2) throws MethodException;

    public void updateAirconSystemOnOffRow1(boolean var1, int var2) throws MethodException;

    public void updateAirconSystemOnOffRow2(boolean var1, int var2) throws MethodException;

    public void updateAirconSystemOnOffRow3(boolean var1, int var2) throws MethodException;

    public void updateAirconTempZone1(AirconTemp var1, int var2) throws MethodException;

    public void updateAirconAirVolumeZone1(AirconAirVolume var1, int var2) throws MethodException;

    public void updateAirconAirDistributionZone1(AirconAirDistribution var1, int var2) throws MethodException;

    public void updateAirconFootwellTempZone1(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterZone1(int var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatVentilationZone1(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempZone2(AirconTemp var1, int var2) throws MethodException;

    public void updateAirconAirVolumeZone2(AirconAirVolume var1, int var2) throws MethodException;

    public void updateAirconAirDistributionZone2(AirconAirDistribution var1, int var2) throws MethodException;

    public void updateAirconFootwellTempZone2(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterZone2(int var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatVentilationZone2(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempZone3(AirconTemp var1, int var2) throws MethodException;

    public void updateAirconAirVolumeZone3(AirconAirVolume var1, int var2) throws MethodException;

    public void updateAirconAirDistributionZone3(AirconAirDistribution var1, int var2) throws MethodException;

    public void updateAirconFootwellTempZone3(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterZone3(int var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatVentilationZone3(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempZone4(AirconTemp var1, int var2) throws MethodException;

    public void updateAirconAirVolumeZone4(AirconAirVolume var1, int var2) throws MethodException;

    public void updateAirconAirDistributionZone4(AirconAirDistribution var1, int var2) throws MethodException;

    public void updateAirconFootwellTempZone4(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterZone4(int var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatVentilationZone4(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempZone5(AirconTemp var1, int var2) throws MethodException;

    public void updateAirconAirVolumeZone5(AirconAirVolume var1, int var2) throws MethodException;

    public void updateAirconAirDistributionZone5(AirconAirDistribution var1, int var2) throws MethodException;

    public void updateAirconFootwellTempZone5(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterZone5(int var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatVentilationZone5(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempZone6(AirconTemp var1, int var2) throws MethodException;

    public void updateAirconAirVolumeZone6(AirconAirVolume var1, int var2) throws MethodException;

    public void updateAirconAirDistributionZone6(AirconAirDistribution var1, int var2) throws MethodException;

    public void updateAirconFootwellTempZone6(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterZone6(int var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatVentilationZone6(int var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatHeaterDistributionZone1(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterDistributionZone2(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterDistributionZone3(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterDistributionZone4(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterDistributionZone5(int var1, int var2) throws MethodException;

    public void updateAirconSeatHeaterDistributionZone6(int var1, int var2) throws MethodException;

    public void updateAirconSeatVentilationDistributionZone1(int var1, int var2) throws MethodException;

    public void updateAirconSeatVentilationDistributionZone2(int var1, int var2) throws MethodException;

    public void updateAirconSeatVentilationDistributionZone3(int var1, int var2) throws MethodException;

    public void updateAirconSeatVentilationDistributionZone4(int var1, int var2) throws MethodException;

    public void updateAirconSeatVentilationDistributionZone5(int var1, int var2) throws MethodException;

    public void updateAirconSeatVentilationDistributionZone6(int var1, int var2) throws MethodException;

    public void updateAirconTempStepZone1(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempStepZone2(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempStepZone3(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempStepZone4(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempStepZone5(int var1, int var2, int var3) throws MethodException;

    public void updateAirconTempStepZone6(int var1, int var2, int var3) throws MethodException;

    public void updateAirconViewOptionsMaster(AirconMasterViewOptions var1, int var2) throws MethodException;

    public void updateAirconViewOptionsRow1(AirconRowViewOptions var1, int var2) throws MethodException;

    public void updateAirconViewOptionsRow2(AirconRowViewOptions var1, int var2) throws MethodException;

    public void updateAirconViewOptionsRow3(AirconRowViewOptions var1, int var2) throws MethodException;

    public void acknowledgeAirconSetFactoryDefaultMaster(boolean var1) throws MethodException;

    public void acknowledgeAirconSetFactoryDefaultRow(int var1, boolean var2) throws MethodException;

    public void acknowledgeAirconNozzleControlRow1(boolean var1, boolean var2) throws MethodException;

    public void acknowledgeAirconNozzleControlRow2(boolean var1, boolean var2) throws MethodException;

    public void acknowledgeAirconNozzleControlRow3(boolean var1, boolean var2) throws MethodException;

    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo var1, AirconNozzleListRecord[] var2) throws MethodException;

    public void responseAirconNozzleListRow2(CarArrayListUpdateInfo var1, AirconNozzleListRecord[] var2) throws MethodException;

    public void responseAirconNozzleListRow3(CarArrayListUpdateInfo var1, AirconNozzleListRecord[] var2) throws MethodException;

    public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo var1, int[] var2, int var3) throws MethodException;

    public void updateAirconNozzleListUpdateInfoRow2(CarArrayListUpdateInfo var1, int[] var2, int var3) throws MethodException;

    public void updateAirconNozzleListUpdateInfoRow3(CarArrayListUpdateInfo var1, int[] var2, int var3) throws MethodException;

    public void updateAirconNozzleListTotalNumberOfElementsRow1(int var1, int var2) throws MethodException;

    public void updateAirconNozzleListTotalNumberOfElementsRow2(int var1, int var2) throws MethodException;

    public void updateAirconNozzleListTotalNumberOfElementsRow3(int var1, int var2) throws MethodException;

    public void updateAirconSideWindowDefrost(boolean var1, int var2) throws MethodException;

    public void updateAirconPureAir(AirconPureAirSetup var1, int var2, int var3) throws MethodException;

    public void updateAirconFreshAirState(AirconFreshAirCartridge var1, AirconFreshAirCartridge var2, int var3) throws MethodException;

    public void updateAirconFreshAirConfig(AirconFreshAirConfiguration var1, int var2) throws MethodException;

    public void updateAirconAirQuality(AirconAirQuality var1, int var2) throws MethodException;

    public void updateAirconNozzleStatusRow1(boolean var1, int var2) throws MethodException;

    public void updateAirconNozzleStatusRow2(boolean var1, int var2) throws MethodException;

    public void updateAirconNozzleStatusRow3(boolean var1, int var2) throws MethodException;

    public void updateAirconClimateStyleZone1(int var1, int var2) throws MethodException;

    public void updateAirconClimateStyleZone2(int var1, int var2) throws MethodException;

    public void updateAirconClimateStyleZone3(int var1, int var2) throws MethodException;

    public void updateAirconClimateStyleZone4(int var1, int var2) throws MethodException;

    public void updateAirconClimateStyleZone5(int var1, int var2) throws MethodException;

    public void updateAirconClimateStyleZone6(int var1, int var2) throws MethodException;

    public void updateAirconClimateStateZone1(int var1, int var2) throws MethodException;

    public void updateAirconClimateStateZone2(int var1, int var2) throws MethodException;

    public void updateAirconClimateStateZone3(int var1, int var2) throws MethodException;

    public void updateAirconClimateStateZone4(int var1, int var2) throws MethodException;

    public void updateAirconClimateStateZone5(int var1, int var2) throws MethodException;

    public void updateAirconClimateStateZone6(int var1, int var2) throws MethodException;

    public void updateAirconSeatNeckHeaterZone1(boolean var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatNeckHeaterZone2(boolean var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatNeckHeaterZone3(boolean var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatNeckHeaterZone4(boolean var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatNeckHeaterZone5(boolean var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatNeckHeaterZone6(boolean var1, int var2, int var3) throws MethodException;

    public void updateAirconSeatSurfaceHeaterZone1(boolean var1, boolean var2, int var3, int var4) throws MethodException;

    public void updateAirconSeatSurfaceHeaterZone2(boolean var1, boolean var2, int var3, int var4) throws MethodException;

    public void updateAirconSeatSurfaceHeaterZone3(boolean var1, boolean var2, int var3, int var4) throws MethodException;

    public void updateAirconSeatSurfaceHeaterZone4(boolean var1, boolean var2, int var3, int var4) throws MethodException;

    public void updateAirconSeatSurfaceHeaterZone5(boolean var1, boolean var2, int var3, int var4) throws MethodException;

    public void updateAirconSeatSurfaceHeaterZone6(boolean var1, boolean var2, int var3, int var4) throws MethodException;

    public void updateAirconIndividualClimatisationZone1(boolean var1, int var2) throws MethodException;

    public void updateAirconIndividualClimatisationZone2(boolean var1, int var2) throws MethodException;

    public void updateAirconIndividualClimatisationZone3(boolean var1, int var2) throws MethodException;

    public void updateAirconIndividualClimatisationZone4(boolean var1, int var2) throws MethodException;

    public void updateAirconIndividualClimatisationZone5(boolean var1, int var2) throws MethodException;

    public void updateAirconIndividualClimatisationZone6(boolean var1, int var2) throws MethodException;

    public void updateAirconIonisatorZone1(int var1, int var2) throws MethodException;

    public void updateAirconIonisatorZone2(int var1, int var2) throws MethodException;

    public void updateAirconIonisatorZone3(int var1, int var2) throws MethodException;

    public void updateAirconIonisatorZone4(int var1, int var2) throws MethodException;

    public void updateAirconIonisatorZone5(int var1, int var2) throws MethodException;

    public void updateAirconIonisatorZone6(int var1, int var2) throws MethodException;

    public void updateAirconBodyCloseMeasuresZone1(boolean var1, AirconBCMeasuresConfiguration var2, int var3) throws MethodException;

    public void updateAirconBodyCloseMeasuresZone2(boolean var1, AirconBCMeasuresConfiguration var2, int var3) throws MethodException;

    public void updateAirconBodyCloseMeasuresZone3(boolean var1, AirconBCMeasuresConfiguration var2, int var3) throws MethodException;

    public void updateAirconBodyCloseMeasuresZone4(boolean var1, AirconBCMeasuresConfiguration var2, int var3) throws MethodException;

    public void updateAirconBodyCloseMeasuresZone5(boolean var1, AirconBCMeasuresConfiguration var2, int var3) throws MethodException;

    public void updateAirconBodyCloseMeasuresZone6(boolean var1, AirconBCMeasuresConfiguration var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

