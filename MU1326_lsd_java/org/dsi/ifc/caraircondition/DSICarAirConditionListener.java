/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.base.DSIListener;
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

public interface DSICarAirConditionListener
extends DSIListener {
    public void requestAirconPopup(AirconContent var1);

    public void acknowlegdeAirconPopup(AirconContent var1);

    public void updateAirconContent(AirconContent var1, int var2);

    public void updateAirconAirCirculationMan(boolean var1, int var2);

    public void updateAirconAirCirculationAuto(boolean var1, int var2);

    public void updateAirconAirCirculationSensitivity(int var1, int var2);

    public void updateAirconAirCirculationMiddleExhaustion(int var1, int var2);

    public void updateAirconRearWindowHeater(boolean var1, int var2);

    public void updateAirconIndirectVentilation(boolean var1, int var2);

    public void updateAirconPopupTime(int var1, int var2);

    public void updateAirconHeater(boolean var1, int var2);

    public void updateAirconRearAuxHeater(boolean var1, int var2);

    public void updateAirconFrontWindowHeater(boolean var1, int var2);

    public void updateAirconDefrost(boolean var1, int var2);

    public void updateAirconMaxDefrost(boolean var1, int var2);

    public void updateAirconSolar(boolean var1, int var2);

    public void updateAirconAC(boolean var1, int var2);

    public void updateAirconMaxAC(boolean var1, int var2);

    public void updateAirconEcoAC(boolean var1, int var2);

    public void updateAirconRearControl(boolean var1, int var2);

    public void updateAirconRearControlFondPlus(boolean var1, int var2);

    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater var1, int var2);

    public void updateAirconFrontWindowHeaterAuto(boolean var1, int var2);

    public void updateAirconBlowerCompensation(AirconBlowerCompensation var1, int var2);

    public void updateAirconSynchronisation(AirconSynchronisation var1, int var2);

    public void updateAirconSuppressVisualisation(boolean var1, int var2);

    public void updateAirconResidualHeat(boolean var1, int var2);

    public void updateAirconSystemOnOffRow1(boolean var1, int var2);

    public void updateAirconSystemOnOffRow2(boolean var1, int var2);

    public void updateAirconSystemOnOffRow3(boolean var1, int var2);

    public void updateAirconTempZone1(AirconTemp var1, int var2);

    public void updateAirconAirVolumeZone1(AirconAirVolume var1, int var2);

    public void updateAirconAirDistributionZone1(AirconAirDistribution var1, int var2);

    public void updateAirconFootwellTempZone1(int var1, int var2);

    public void updateAirconSeatHeaterZone1(int var1, int var2, int var3);

    public void updateAirconSeatVentilationZone1(int var1, int var2, int var3);

    public void updateAirconTempZone2(AirconTemp var1, int var2);

    public void updateAirconAirVolumeZone2(AirconAirVolume var1, int var2);

    public void updateAirconAirDistributionZone2(AirconAirDistribution var1, int var2);

    public void updateAirconFootwellTempZone2(int var1, int var2);

    public void updateAirconSeatHeaterZone2(int var1, int var2, int var3);

    public void updateAirconSeatVentilationZone2(int var1, int var2, int var3);

    public void updateAirconTempZone3(AirconTemp var1, int var2);

    public void updateAirconAirVolumeZone3(AirconAirVolume var1, int var2);

    public void updateAirconAirDistributionZone3(AirconAirDistribution var1, int var2);

    public void updateAirconFootwellTempZone3(int var1, int var2);

    public void updateAirconSeatHeaterZone3(int var1, int var2, int var3);

    public void updateAirconSeatVentilationZone3(int var1, int var2, int var3);

    public void updateAirconTempZone4(AirconTemp var1, int var2);

    public void updateAirconAirVolumeZone4(AirconAirVolume var1, int var2);

    public void updateAirconAirDistributionZone4(AirconAirDistribution var1, int var2);

    public void updateAirconFootwellTempZone4(int var1, int var2);

    public void updateAirconSeatHeaterZone4(int var1, int var2, int var3);

    public void updateAirconSeatVentilationZone4(int var1, int var2, int var3);

    public void updateAirconTempZone5(AirconTemp var1, int var2);

    public void updateAirconAirVolumeZone5(AirconAirVolume var1, int var2);

    public void updateAirconAirDistributionZone5(AirconAirDistribution var1, int var2);

    public void updateAirconFootwellTempZone5(int var1, int var2);

    public void updateAirconSeatHeaterZone5(int var1, int var2, int var3);

    public void updateAirconSeatVentilationZone5(int var1, int var2, int var3);

    public void updateAirconTempZone6(AirconTemp var1, int var2);

    public void updateAirconAirVolumeZone6(AirconAirVolume var1, int var2);

    public void updateAirconAirDistributionZone6(AirconAirDistribution var1, int var2);

    public void updateAirconFootwellTempZone6(int var1, int var2);

    public void updateAirconSeatHeaterZone6(int var1, int var2, int var3);

    public void updateAirconSeatVentilationZone6(int var1, int var2, int var3);

    public void updateAirconSeatHeaterDistributionZone1(int var1, int var2);

    public void updateAirconSeatHeaterDistributionZone2(int var1, int var2);

    public void updateAirconSeatHeaterDistributionZone3(int var1, int var2);

    public void updateAirconSeatHeaterDistributionZone4(int var1, int var2);

    public void updateAirconSeatHeaterDistributionZone5(int var1, int var2);

    public void updateAirconSeatHeaterDistributionZone6(int var1, int var2);

    public void updateAirconSeatVentilationDistributionZone1(int var1, int var2);

    public void updateAirconSeatVentilationDistributionZone2(int var1, int var2);

    public void updateAirconSeatVentilationDistributionZone3(int var1, int var2);

    public void updateAirconSeatVentilationDistributionZone4(int var1, int var2);

    public void updateAirconSeatVentilationDistributionZone5(int var1, int var2);

    public void updateAirconSeatVentilationDistributionZone6(int var1, int var2);

    public void updateAirconTempStepZone1(int var1, int var2, int var3);

    public void updateAirconTempStepZone2(int var1, int var2, int var3);

    public void updateAirconTempStepZone3(int var1, int var2, int var3);

    public void updateAirconTempStepZone4(int var1, int var2, int var3);

    public void updateAirconTempStepZone5(int var1, int var2, int var3);

    public void updateAirconTempStepZone6(int var1, int var2, int var3);

    public void updateAirconViewOptionsMaster(AirconMasterViewOptions var1, int var2);

    public void updateAirconViewOptionsRow1(AirconRowViewOptions var1, int var2);

    public void updateAirconViewOptionsRow2(AirconRowViewOptions var1, int var2);

    public void updateAirconViewOptionsRow3(AirconRowViewOptions var1, int var2);

    public void acknowledgeAirconSetFactoryDefaultMaster(boolean var1);

    public void acknowledgeAirconSetFactoryDefaultRow(int var1, boolean var2);

    public void acknowledgeAirconNozzleControlRow1(boolean var1, boolean var2);

    public void acknowledgeAirconNozzleControlRow2(boolean var1, boolean var2);

    public void acknowledgeAirconNozzleControlRow3(boolean var1, boolean var2);

    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo var1, AirconNozzleListRecord[] var2);

    public void responseAirconNozzleListRow2(CarArrayListUpdateInfo var1, AirconNozzleListRecord[] var2);

    public void responseAirconNozzleListRow3(CarArrayListUpdateInfo var1, AirconNozzleListRecord[] var2);

    public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo var1, int[] var2, int var3);

    public void updateAirconNozzleListUpdateInfoRow2(CarArrayListUpdateInfo var1, int[] var2, int var3);

    public void updateAirconNozzleListUpdateInfoRow3(CarArrayListUpdateInfo var1, int[] var2, int var3);

    public void updateAirconNozzleListTotalNumberOfElementsRow1(int var1, int var2);

    public void updateAirconNozzleListTotalNumberOfElementsRow2(int var1, int var2);

    public void updateAirconNozzleListTotalNumberOfElementsRow3(int var1, int var2);

    public void updateAirconSideWindowDefrost(boolean var1, int var2);

    public void updateAirconPureAir(AirconPureAirSetup var1, int var2, int var3);

    public void updateAirconFreshAirState(AirconFreshAirCartridge var1, AirconFreshAirCartridge var2, int var3);

    public void updateAirconFreshAirConfig(AirconFreshAirConfiguration var1, int var2);

    public void updateAirconAirQuality(AirconAirQuality var1, int var2);

    public void updateAirconNozzleStatusRow1(boolean var1, int var2);

    public void updateAirconNozzleStatusRow2(boolean var1, int var2);

    public void updateAirconNozzleStatusRow3(boolean var1, int var2);

    public void updateAirconClimateStyleZone1(int var1, int var2);

    public void updateAirconClimateStyleZone2(int var1, int var2);

    public void updateAirconClimateStyleZone3(int var1, int var2);

    public void updateAirconClimateStyleZone4(int var1, int var2);

    public void updateAirconClimateStyleZone5(int var1, int var2);

    public void updateAirconClimateStyleZone6(int var1, int var2);

    public void updateAirconClimateStateZone1(int var1, int var2);

    public void updateAirconClimateStateZone2(int var1, int var2);

    public void updateAirconClimateStateZone3(int var1, int var2);

    public void updateAirconClimateStateZone4(int var1, int var2);

    public void updateAirconClimateStateZone5(int var1, int var2);

    public void updateAirconClimateStateZone6(int var1, int var2);

    public void updateAirconSeatNeckHeaterZone1(boolean var1, int var2, int var3);

    public void updateAirconSeatNeckHeaterZone2(boolean var1, int var2, int var3);

    public void updateAirconSeatNeckHeaterZone3(boolean var1, int var2, int var3);

    public void updateAirconSeatNeckHeaterZone4(boolean var1, int var2, int var3);

    public void updateAirconSeatNeckHeaterZone5(boolean var1, int var2, int var3);

    public void updateAirconSeatNeckHeaterZone6(boolean var1, int var2, int var3);

    public void updateAirconSeatSurfaceHeaterZone1(boolean var1, boolean var2, int var3, int var4);

    public void updateAirconSeatSurfaceHeaterZone2(boolean var1, boolean var2, int var3, int var4);

    public void updateAirconSeatSurfaceHeaterZone3(boolean var1, boolean var2, int var3, int var4);

    public void updateAirconSeatSurfaceHeaterZone4(boolean var1, boolean var2, int var3, int var4);

    public void updateAirconSeatSurfaceHeaterZone5(boolean var1, boolean var2, int var3, int var4);

    public void updateAirconSeatSurfaceHeaterZone6(boolean var1, boolean var2, int var3, int var4);

    public void updateAirconIndividualClimatisationZone1(boolean var1, int var2);

    public void updateAirconIndividualClimatisationZone2(boolean var1, int var2);

    public void updateAirconIndividualClimatisationZone3(boolean var1, int var2);

    public void updateAirconIndividualClimatisationZone4(boolean var1, int var2);

    public void updateAirconIndividualClimatisationZone5(boolean var1, int var2);

    public void updateAirconIndividualClimatisationZone6(boolean var1, int var2);

    public void updateAirconIonisatorZone1(int var1, int var2);

    public void updateAirconIonisatorZone2(int var1, int var2);

    public void updateAirconIonisatorZone3(int var1, int var2);

    public void updateAirconIonisatorZone4(int var1, int var2);

    public void updateAirconIonisatorZone5(int var1, int var2);

    public void updateAirconIonisatorZone6(int var1, int var2);

    public void updateAirconBodyCloseMeasuresZone1(boolean var1, AirconBCMeasuresConfiguration var2, int var3);

    public void updateAirconBodyCloseMeasuresZone2(boolean var1, AirconBCMeasuresConfiguration var2, int var3);

    public void updateAirconBodyCloseMeasuresZone3(boolean var1, AirconBCMeasuresConfiguration var2, int var3);

    public void updateAirconBodyCloseMeasuresZone4(boolean var1, AirconBCMeasuresConfiguration var2, int var3);

    public void updateAirconBodyCloseMeasuresZone5(boolean var1, AirconBCMeasuresConfiguration var2, int var3);

    public void updateAirconBodyCloseMeasuresZone6(boolean var1, AirconBCMeasuresConfiguration var2, int var3);
}

