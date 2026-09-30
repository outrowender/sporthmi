/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCIndications;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCMaxValues;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCRefuelVolume;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsAC;
import org.dsi.ifc.carkombi.BCStatisticsConfig;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.carkombi.BCStatisticsRE;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.HUDCollectiveTopics;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDSectionConfigListRecord;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIADistanceData;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;

public interface DSICarKombiListener
extends DSIListener {
    public void updateSIAViewOptions(SIAViewOptions var1, int var2);

    public void updateSIAServiceData(SIAServiceData var1, int var2);

    public void updateSIAOilInspection(SIAOilInspection var1, int var2);

    public void indicateEndOfSIAReset(boolean var1);

    public void updateSIAHistoryListUpdateInfo(CarArrayListUpdateInfo var1, int[] var2, int var3);

    public void responseSIAHistoryList(CarArrayListUpdateInfo var1, SIAHistoryListRecord[] var2);

    public void updateSIAHistoryListTotalNumberOfElements(int var1, int var2);

    public void updateSIADistanceOilUser(SIADistanceData var1, int var2);

    public void updateSIADistanceAirFilterUser(SIADistanceData var1, int var2);

    public void updateSIADistanceOilFilterUser(SIADistanceData var1, int var2);

    public void updateSIAInspectionDistanceUser(SIADistanceData var1, int var2);

    public void updateSIADailyAverageMileage(int var1, int var2, int var3);

    public void updateBCViewOptions(BCViewOptions var1, int var2);

    public void updateBCIndications(BCIndications var1, int var2);

    public void updateBCCurrentConsumption1(CarBCConsumption var1, int var2);

    public void updateBCCurrentConsumption2(CarBCConsumption var1, int var2);

    public void updateBCCurrentRange1(CarBCCurrentRange var1, int var2);

    public void updateBCCurrentRange2(CarBCCurrentRange var1, int var2);

    public void updateBCTotalDistance(CarBCDistance var1, int var2);

    public void updateBCShortTermAverageConsumption1(CarBCConsumption var1, int var2);

    public void updateBCShortTermAverageConsumption2(CarBCConsumption var1, int var2);

    public void updateBCShortTermGeneral(BCShortTermGeneralData var1, int var2);

    public void updateBCLongTermAverageConsumption1(CarBCConsumption var1, int var2);

    public void updateBCLongTermAverageConsumption2(CarBCConsumption var1, int var2);

    public void updateBCLongTermGeneral(BCLongTermGeneralData var1, int var2);

    public void updateBCCycleAverageConsumption1(CarBCConsumption var1, int var2);

    public void updateBCCycleAverageConsumption2(CarBCConsumption var1, int var2);

    public void updateBCCycleGeneral(BCCycleGeneralData var1, int var2);

    public void updateBCVZADisplay(boolean var1, int var2);

    public void updateBCLifeTipsDisplay(boolean var1, int var2);

    public void updateBCConsumerDisplay(boolean var1, int var2);

    public void updateBCTankLevel1(BCTankLevel var1, int var2);

    public void updateBCTankLevel2(BCTankLevel var1, int var2);

    public void updateBCRefuelVolume1(BCRefuelVolume var1, int var2);

    public void updateBCRefuelVolume2(BCRefuelVolume var1, int var2);

    public void updateBCMenue1Config(BCMenueConfiguration var1, int var2);

    public void updateBCMenue2Config(BCMenueConfiguration var1, int var2);

    public void updateBCMenue3Config(BCMenueConfiguration var1, int var2);

    public void updateBCOilTemperature(boolean var1, int var2);

    public void updateBCDigitalSpeed(boolean var1, int var2);

    public void updateBCStopwatch(boolean var1, int var2);

    public void updateBCVzaMFA(boolean var1, int var2);

    public void updateBCSpeedWarning(BCSpeedWarningSettings var1, int var2);

    public void updateBCGearRecommendation(boolean var1, int var2);

    public void updateBCRearSeatbeltWarning(boolean var1, int var2);

    public void updateBCOutsideTemperature(CarBCTemperature var1, int var2);

    public void indicateEndOfBCMenuReset(boolean var1);

    public void updateBCVehicleStateListTotalNumberOfElements(int var1, int var2);

    public void responseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH var1, int[] var2);

    public void responseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH var1, int var2, int var3, String var4, String var5);

    public void responseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH var1, ListWarningIDsDynValues[] var2);

    public void responseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH var1, int var2, String var3);

    public void responseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH var1, ListDynValues[] var2);

    public void responseVehicleStateListPos(BCVehicleStateUpdateInfoAH var1, int[] var2);

    public void acknowledgeBcSetFactoryDefault(boolean var1);

    public void acknowledgeHUDSetFactoryDefault(boolean var1);

    public void acknowledgeDCSetFactoryDefault(boolean var1);

    public void acknowledgeBcStatisticsReset(int var1);

    public void updateBCStatisticsDistanceAC1(BCStatisticsAC var1, int var2);

    public void updateBCStatisticsDistanceAC2(BCStatisticsAC var1, int var2);

    public void updateBCStatisticsDistanceRE(BCStatisticsRE var1, int var2);

    public void updateBCStatisticsDistanceZE(BCStatisticsZE var1, BCZeroEmissionAbsoluteDistance var2, int var3);

    public void updateBCStatisticsDistanceCurrentIntervalAC1(CarBCConsumption var1, int var2);

    public void updateBCStatisticsDistanceCurrentIntervalAC2(CarBCConsumption var1, int var2);

    public void updateBCStatisticsDistanceCurrentIntervalRE(BCAverageRecoveredEnergy var1, int var2);

    public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative var1, BCZeroEmissionAbsoluteDistance var2, int var3);

    public void updateBCStatisticsTimeAC1(BCStatisticsAC var1, int var2);

    public void updateBCStatisticsTimeAC2(BCStatisticsAC var1, int var2);

    public void updateBCStatisticsTimeRE(BCStatisticsRE var1, int var2);

    public void updateBCStatisticsTimeZE(BCStatisticsZE var1, BCZeroEmissionAbsoluteTime var2, int var3);

    public void updateBCStatisticsTimeCurrentPeriodAC1(CarBCConsumption var1, int var2);

    public void updateBCStatisticsTimeCurrentPeriodAC2(CarBCConsumption var1, int var2);

    public void updateBCStatisticsTimeCurrentPeriodRE(BCAverageRecoveredEnergy var1, int var2);

    public void updateBCStatisticsTimeCurrentPeriodZE(BCZeroEmissionRelative var1, BCZeroEmissionAbsoluteTime var2, int var3);

    public void updateBCStatisticsConfig(BCStatisticsConfig var1, int var2);

    public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU var1, int var2);

    public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU var1, int var2);

    public void updateBCOilTemperatureValue(CarBCTemperature var1, int var2);

    public void updateBCCoolantTemperature(CarBCTemperature var1, int var2);

    public void updateBCComfortPowerConsumption(BCComfortPowerConsumption var1, int var2);

    public void updateBCTotalCurrentRange(CarBCDistance var1, int var2);

    public void updateBCZeroEmissionDistanceST(CarBCDistance var1, int var2);

    public void updateBCZeroEmissionDistanceLT(CarBCDistance var1, int var2);

    public void updateBCZeroEmissionDistanceCY(CarBCDistance var1, int var2);

    public void updateBCZeroEmissionTimeST(CarBCTime var1, int var2);

    public void updateBCZeroEmissionTimeLT(CarBCTime var1, int var2);

    public void updateBCZeroEmissionTimeCY(CarBCTime var1, int var2);

    public void updateBCMaxValues(BCMaxValues var1, int var2);

    public void updateBCResetTimeStampST(BCResetTimeStamp var1, int var2);

    public void updateBCResetTimeStampLT(BCResetTimeStamp var1, int var2);

    public void updateBCResetTimeStampCY(BCResetTimeStamp var1, int var2);

    public void updateBCAstaMFA(boolean var1, int var2);

    public void updateHUDViewOptions(HUDViewOptions var1, int var2);

    public void updateHUDHeightAdjustment(byte var1, int var2);

    public void updateHUDBrightness(byte var1, int var2);

    public void updateHUDColour(int var1, int var2, int var3);

    public void updateHUDContent(HUDContent var1, int var2);

    public void updateHUDInfo(boolean var1, int var2);

    public void updateHUDSystemOnOff(boolean var1, int var2);

    public void updateHUDRotationAdjustment(int var1, int var2);

    public void updateHUDPresets(int var1, int var2, int var3);

    public void updateHUDCollectiveTopics(HUDCollectiveTopics var1, int var2);

    public void updateHUDAutoSkinSwitch(boolean var1, int var2);

    public void responseHUDSectionConfigList(CarArrayListUpdateInfo var1, HUDSectionConfigListRecord[] var2);

    public void updateHUDSectionConfigListUpdateInfo(CarArrayListUpdateInfo var1, int[] var2, int var3);

    public void updateHUDSectionConfigListTotalNumberOfElements(int var1, int var2);

    public void updateDCViewOptions(DCViewOptions var1, int var2);

    public void updateDCBrightness(int var1, int var2);

    public void updateDCVolume(int var1, int var2);

    public void updateDCElementContentSelectionListTotalNumberOfElements(int var1, int var2);

    public void updateDCDisplay1Setup(DCMainItems var1, DCDisplayedAdditionalInfos var2, DCAdditionalInfo var3, DCAdditionalInfo var4, int var5);

    public void updateDCDisplay2Setup(DCMainItems var1, DCDisplayedAdditionalInfos var2, DCAdditionalInfo var3, DCAdditionalInfo var4, int var5);

    public void updateDCDisplay3Setup(DCMainItems var1, DCDisplayedAdditionalInfos var2, DCAdditionalInfo var3, DCAdditionalInfo var4, int var5);

    public void updateDCDisplay1MainSelection(DCMainItems var1, int var2);

    public void updateDCDisplay2MainSelection(DCMainItems var1, int var2);

    public void updateDCDisplay3MainSelection(DCMainItems var1, int var2);

    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo var1, int[] var2);

    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo var1, DCElementContentSelectionListRA1[] var2);

    public void responseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo var1, DCElementContentSelectionListRA2[] var2);

    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo var1, int[] var2, int var3);

    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument var1, int var2);

    public void updateDCAdditionalInstrument2Setup(DCAdditionalInstrument2 var1, int var2);

    public void updateDCDisplayPresetsListTotalNumberOfElements(int var1, int var2);

    public void responseDCDisplayPresetsList(CarArrayListUpdateInfo var1, DCDisplayPresetsListRecord[] var2);

    public void updateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo var1, DCDisplayPresetsListRecord[] var2, int var3);

    public void updateDCDisplayDependencySetup(DCDisplayDependency var1, int var2);

    public void updateDCActiveDisplayPreset(int var1, int var2);

    public void updateDCDisplayViewConfiguration(DCDisplayViewConfiguration var1, int var2);

    public void updateCompassInfo(int var1, int var2, int var3);

    public void updateHUDLicense(boolean var1, int var2);

    public void updateDCLEDConfiguration(boolean var1, int var2);
}

