/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.adapter;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
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
import org.dsi.ifc.carkombi.BCTemperature;
import org.dsi.ifc.carkombi.BCTotalDistance;
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
import org.dsi.ifc.carkombi.DSICarKombi;
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

public abstract class AbstractDSICarKombiAdapter
extends AbstractCarComponent
implements DSICarKombiListener {
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;

    public AbstractDSICarKombiAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarKombi getDSI() {
        if (this.getBaseDSI() != null) {
            return (DSICarKombi)this.getBaseDSI();
        }
        return null;
    }

    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = AbstractDSICarKombiAdapter.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener).getName();
    }

    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = AbstractDSICarKombiAdapter.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName();
    }

    public final boolean isUsingDSI() {
        return true;
    }

    public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
        this.logStub();
    }

    public void updateSIAServiceData(SIAServiceData sIAServiceData, int n) {
        this.logStub();
    }

    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
        this.logStub();
    }

    public void indicateEndOfSIAReset(boolean bl) {
        this.logStub();
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        this.logStub();
    }

    public void updateBCIndications(BCIndications bCIndications, int n) {
        this.logStub();
    }

    public void updateBCTotalDistance(BCTotalDistance bCTotalDistance, int n) {
        this.logStub();
    }

    public void updateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
        this.logStub();
    }

    public void updateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
        this.logStub();
    }

    public void updateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
        this.logStub();
    }

    public void updateBCVZADisplay(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCLifeTipsDisplay(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCConsumerDisplay(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCTankLevel1(byte by, int n) {
        this.logStub();
    }

    public void updateBCTankLevel2(byte by, int n) {
        this.logStub();
    }

    public void updateBCRefuelVolume1(BCRefuelVolume bCRefuelVolume, int n) {
        this.logStub();
    }

    public void updateBCRefuelVolume2(BCRefuelVolume bCRefuelVolume, int n) {
        this.logStub();
    }

    public void updateBCMenue1Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        this.logStub();
    }

    public void updateBCMenue2Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        this.logStub();
    }

    public void updateBCMenue3Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        this.logStub();
    }

    public void updateBCOilTemperature(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCDigitalSpeed(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCStopwatch(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCVzaMFA(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
        this.logStub();
    }

    public void updateBCGearRecommendation(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCRearSeatbeltWarning(boolean bl, int n) {
        this.logStub();
    }

    public void indicateEndOfBCMenuReset(boolean bl) {
        this.logStub();
    }

    public void updateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void responseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        this.logStub();
    }

    public void responseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
        this.logStub();
    }

    public void responseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
        this.logStub();
    }

    public void responseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
        this.logStub();
    }

    public void responseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
        this.logStub();
    }

    public void responseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        this.logStub();
    }

    public void acknowledgeBcSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeBcStatisticsReset(int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceAC1(BCStatisticsAC bCStatisticsAC, int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceAC2(BCStatisticsAC bCStatisticsAC, int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceRE(BCStatisticsRE bCStatisticsRE, int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceCurrentIntervalRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeAC1(BCStatisticsAC bCStatisticsAC, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeAC2(BCStatisticsAC bCStatisticsAC, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeRE(BCStatisticsRE bCStatisticsRE, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeCurrentPeriodRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeCurrentPeriodZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
        this.logStub();
    }

    public void updateBCStatisticsConfig(BCStatisticsConfig bCStatisticsConfig, int n) {
        this.logStub();
    }

    public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
        this.logStub();
    }

    public void updateHUDHeightAdjustment(byte by, int n) {
        this.logStub();
    }

    public void updateHUDBrightness(byte by, int n) {
        this.logStub();
    }

    public void updateHUDContent(HUDContent hUDContent, int n) {
        this.logStub();
    }

    public void updateHUDInfo(boolean bl, int n) {
        this.logStub();
    }

    public void updateCompassInfo(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
        this.logStub();
    }

    public void updateBCCoolantTemperature(CarBCTemperature carBCTemperature, int n) {
        this.logStub();
    }

    public void updateBCComfortPowerConsumption(BCComfortPowerConsumption bCComfortPowerConsumption, int n) {
        this.logStub();
    }

    public void updateHUDRotationAdjustment(int n, int n2) {
        this.logStub();
    }

    public void updateBCCurrentConsumption1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCCurrentConsumption2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        this.logStub();
    }

    public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        this.logStub();
    }

    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCCycleAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCCycleAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceCurrentIntervalAC1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCStatisticsDistanceCurrentIntervalAC2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeCurrentPeriodAC1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateBCStatisticsTimeCurrentPeriodAC2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void acknowledgeHUDSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        this.logStub();
    }

    public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        this.logStub();
    }

    public void updateBCTotalCurrentRange(CarBCDistance carBCDistance, int n) {
        this.logStub();
    }

    public void updateBCZeroEmissionDistanceST(CarBCDistance carBCDistance, int n) {
        this.logStub();
    }

    public void updateBCZeroEmissionDistanceLT(CarBCDistance carBCDistance, int n) {
        this.logStub();
    }

    public void updateBCZeroEmissionDistanceCY(CarBCDistance carBCDistance, int n) {
        this.logStub();
    }

    public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
        this.logStub();
    }

    public void updateBCZeroEmissionTimeLT(CarBCTime carBCTime, int n) {
        this.logStub();
    }

    public void updateBCZeroEmissionTimeCY(CarBCTime carBCTime, int n) {
        this.logStub();
    }

    public void updateBCMaxValues(BCMaxValues bCMaxValues, int n) {
        this.logStub();
    }

    public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
        this.logStub();
    }

    public void updateBCResetTimeStampLT(BCResetTimeStamp bCResetTimeStamp, int n) {
        this.logStub();
    }

    public void updateBCResetTimeStampCY(BCResetTimeStamp bCResetTimeStamp, int n) {
        this.logStub();
    }

    public void updateHUDColour(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateHUDSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
        this.logStub();
    }

    public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
        this.logStub();
    }

    public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
        this.logStub();
    }

    public void updateBCOutsideTemperature2(BCTemperature bCTemperature, int n) {
        this.logStub();
    }

    public void updateBCOilTemperatureValue(BCTemperature bCTemperature, int n) {
        this.logStub();
    }

    public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
        this.logStub();
    }

    public void acknowledgeDCSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
        this.logStub();
    }

    public void updateDCBrightness(int n, int n2) {
        this.logStub();
    }

    public void updateDCVolume(int n, int n2) {
        this.logStub();
    }

    public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        this.logStub();
    }

    public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        this.logStub();
    }

    public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        this.logStub();
    }

    public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
        this.logStub();
    }

    public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
        this.logStub();
    }

    public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
        this.logStub();
    }

    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        this.logStub();
    }

    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
        this.logStub();
    }

    public void updateBCAstaMFA(boolean bl, int n) {
        this.logStub();
    }

    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
        this.logStub();
    }

    public void updateSIAHistoryListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        this.logStub();
    }

    public void responseSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo, SIAHistoryListRecord[] sIAHistoryListRecordArray) {
        this.logStub();
    }

    public void updateSIAHistoryListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateSIADistanceOilUser(SIADistanceData sIADistanceData, int n) {
        this.logStub();
    }

    public void updateSIADistanceAirFilterUser(SIADistanceData sIADistanceData, int n) {
        this.logStub();
    }

    public void updateSIADistanceOilFilterUser(SIADistanceData sIADistanceData, int n) {
        this.logStub();
    }

    public void updateSIAInspectionDistanceUser(SIADistanceData sIADistanceData, int n) {
        this.logStub();
    }

    public void updateSIADailyAverageMileage(int n, int n2, int n3) {
        this.logStub();
    }

    public void responseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        this.logStub();
    }

    public void updateDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2, int n) {
        this.logStub();
    }

    public void updateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void responseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        this.logStub();
    }

    public void updateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
        this.logStub();
    }

    public void updateDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency, int n) {
        this.logStub();
    }

    public void updateDCActiveDisplayPreset(int n, int n2) {
        this.logStub();
    }

    public void updateDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration, int n) {
        this.logStub();
    }

    public void updateHUDLicense(boolean bl, int n) {
        this.logStub();
    }

    public void updateDCLEDConfiguration(boolean bl, int n) {
        this.logStub();
    }

    public void updateHUDPresets(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateHUDCollectiveTopics(HUDCollectiveTopics hUDCollectiveTopics, int n) {
        this.logStub();
    }

    public void updateHUDAutoSkinSwitch(boolean bl, int n) {
        this.logStub();
    }

    public void responseHUDSectionConfigList(CarArrayListUpdateInfo carArrayListUpdateInfo, HUDSectionConfigListRecord[] hUDSectionConfigListRecordArray) {
        this.logStub();
    }

    public void updateHUDSectionConfigListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        this.logStub();
    }

    public void updateHUDSectionConfigListTotalNumberOfElements(int n, int n2) {
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

