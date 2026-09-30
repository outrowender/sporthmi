/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.display;

import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
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
import org.dsi.ifc.carkombi.DSICarKombiListener;
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

abstract class KombiBrightnessDsiWrapper
implements DSICarKombiListener,
IDSIClient {
    public void asyncException(int n, String string, int n2) {
    }

    public void setDSI(DSIBase dSIBase) {
    }

    public int[] getAutoNotifications() {
        return null;
    }

    public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
    }

    public void updateSIAServiceData(SIAServiceData sIAServiceData, int n) {
    }

    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
    }

    public void indicateEndOfSIAReset(boolean bl) {
    }

    public void updateSIAHistoryListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    public void responseSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo, SIAHistoryListRecord[] sIAHistoryListRecordArray) {
    }

    public void updateSIAHistoryListTotalNumberOfElements(int n, int n2) {
    }

    public void updateSIADistanceOilUser(SIADistanceData sIADistanceData, int n) {
    }

    public void updateSIADistanceAirFilterUser(SIADistanceData sIADistanceData, int n) {
    }

    public void updateSIADistanceOilFilterUser(SIADistanceData sIADistanceData, int n) {
    }

    public void updateSIAInspectionDistanceUser(SIADistanceData sIADistanceData, int n) {
    }

    public void updateSIADailyAverageMileage(int n, int n2, int n3) {
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
    }

    public void updateBCIndications(BCIndications bCIndications, int n) {
    }

    public void updateBCCurrentConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCCurrentConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
    }

    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
    }

    public void updateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
    }

    public void updateBCCycleAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCCycleAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
    }

    public void updateBCVZADisplay(boolean bl, int n) {
    }

    public void updateBCLifeTipsDisplay(boolean bl, int n) {
    }

    public void updateBCConsumerDisplay(boolean bl, int n) {
    }

    public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
    }

    public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
    }

    public void updateBCRefuelVolume1(BCRefuelVolume bCRefuelVolume, int n) {
    }

    public void updateBCRefuelVolume2(BCRefuelVolume bCRefuelVolume, int n) {
    }

    public void updateBCMenue1Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    public void updateBCMenue2Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    public void updateBCMenue3Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    public void updateBCOilTemperature(boolean bl, int n) {
    }

    public void updateBCDigitalSpeed(boolean bl, int n) {
    }

    public void updateBCStopwatch(boolean bl, int n) {
    }

    public void updateBCVzaMFA(boolean bl, int n) {
    }

    public void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
    }

    public void updateBCGearRecommendation(boolean bl, int n) {
    }

    public void updateBCRearSeatbeltWarning(boolean bl, int n) {
    }

    public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
    }

    public void indicateEndOfBCMenuReset(boolean bl) {
    }

    public void updateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
    }

    public void responseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    public void responseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
    }

    public void responseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
    }

    public void responseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
    }

    public void responseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
    }

    public void responseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    public void acknowledgeBcSetFactoryDefault(boolean bl) {
    }

    public void acknowledgeHUDSetFactoryDefault(boolean bl) {
    }

    public void acknowledgeDCSetFactoryDefault(boolean bl) {
    }

    public void acknowledgeBcStatisticsReset(int n) {
    }

    public void updateBCStatisticsDistanceAC1(BCStatisticsAC bCStatisticsAC, int n) {
    }

    public void updateBCStatisticsDistanceAC2(BCStatisticsAC bCStatisticsAC, int n) {
    }

    public void updateBCStatisticsDistanceRE(BCStatisticsRE bCStatisticsRE, int n) {
    }

    public void updateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
    }

    public void updateBCStatisticsDistanceCurrentIntervalAC1(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCStatisticsDistanceCurrentIntervalAC2(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCStatisticsDistanceCurrentIntervalRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
    }

    public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
    }

    public void updateBCStatisticsTimeAC1(BCStatisticsAC bCStatisticsAC, int n) {
    }

    public void updateBCStatisticsTimeAC2(BCStatisticsAC bCStatisticsAC, int n) {
    }

    public void updateBCStatisticsTimeRE(BCStatisticsRE bCStatisticsRE, int n) {
    }

    public void updateBCStatisticsTimeZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
    }

    public void updateBCStatisticsTimeCurrentPeriodAC1(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCStatisticsTimeCurrentPeriodAC2(CarBCConsumption carBCConsumption, int n) {
    }

    public void updateBCStatisticsTimeCurrentPeriodRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
    }

    public void updateBCStatisticsTimeCurrentPeriodZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
    }

    public void updateBCStatisticsConfig(BCStatisticsConfig bCStatisticsConfig, int n) {
    }

    public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
    }

    public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
    }

    public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
    }

    public void updateBCCoolantTemperature(CarBCTemperature carBCTemperature, int n) {
    }

    public void updateBCComfortPowerConsumption(BCComfortPowerConsumption bCComfortPowerConsumption, int n) {
    }

    public void updateBCTotalCurrentRange(CarBCDistance carBCDistance, int n) {
    }

    public void updateBCZeroEmissionDistanceST(CarBCDistance carBCDistance, int n) {
    }

    public void updateBCZeroEmissionDistanceLT(CarBCDistance carBCDistance, int n) {
    }

    public void updateBCZeroEmissionDistanceCY(CarBCDistance carBCDistance, int n) {
    }

    public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
    }

    public void updateBCZeroEmissionTimeLT(CarBCTime carBCTime, int n) {
    }

    public void updateBCZeroEmissionTimeCY(CarBCTime carBCTime, int n) {
    }

    public void updateBCMaxValues(BCMaxValues bCMaxValues, int n) {
    }

    public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    public void updateBCResetTimeStampLT(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    public void updateBCResetTimeStampCY(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    public void updateBCAstaMFA(boolean bl, int n) {
    }

    public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
    }

    public void updateHUDHeightAdjustment(byte by, int n) {
    }

    public void updateHUDBrightness(byte by, int n) {
    }

    public void updateHUDColour(int n, int n2, int n3) {
    }

    public void updateHUDContent(HUDContent hUDContent, int n) {
    }

    public void updateHUDInfo(boolean bl, int n) {
    }

    public void updateHUDSystemOnOff(boolean bl, int n) {
    }

    public void updateHUDRotationAdjustment(int n, int n2) {
    }

    public void updateHUDPresets(int n, int n2, int n3) {
    }

    public void updateHUDCollectiveTopics(HUDCollectiveTopics hUDCollectiveTopics, int n) {
    }

    public void updateHUDAutoSkinSwitch(boolean bl, int n) {
    }

    public void responseHUDSectionConfigList(CarArrayListUpdateInfo carArrayListUpdateInfo, HUDSectionConfigListRecord[] hUDSectionConfigListRecordArray) {
    }

    public void updateHUDSectionConfigListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    public void updateHUDSectionConfigListTotalNumberOfElements(int n, int n2) {
    }

    public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
    }

    public void updateDCBrightness(int n, int n2) {
    }

    public void updateDCVolume(int n, int n2) {
    }

    public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
    }

    public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
    }

    public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
    }

    public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
    }

    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
    }

    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
    }

    public void responseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
    }

    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
    }

    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
    }

    public void updateDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2, int n) {
    }

    public void updateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
    }

    public void responseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
    }

    public void updateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
    }

    public void updateDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency, int n) {
    }

    public void updateDCActiveDisplayPreset(int n, int n2) {
    }

    public void updateDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration, int n) {
    }

    public void updateCompassInfo(int n, int n2, int n3) {
    }

    public void updateHUDLicense(boolean bl, int n) {
    }

    public void updateDCLEDConfiguration(boolean bl, int n) {
    }
}

