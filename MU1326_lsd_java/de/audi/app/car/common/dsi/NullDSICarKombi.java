/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.HUDCollectiveTopics;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDSectionConfigListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class NullDSICarKombi
implements DSICarKombi {
    private final LogChannel logChan;

    public NullDSICarKombi(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void resetSIAValue(int n) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCVZADisplay(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCLifeTipsDisplay(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCConsumerDisplay(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCMenueConfig(BCMenueConfiguration bCMenueConfiguration, int n) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void resetBCMenue(int n) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCOilTemperature(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCDigitalSpeed(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCStopwatch(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCVzaMFA(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCGearRecommendation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCRearSeatbeltWarning(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void requestVehicleStateList(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBcSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void resetBCStatistics(BCStatisticsReset bCStatisticsReset) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDHeightAdjustment(byte by) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDBrightness(byte by) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDContent(HUDContent hUDContent) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDRotationAdjustment(int n) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDColour(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCBrightness(int n) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCVolume(int n) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCDisplay1MainSelection(DCMainItems dCMainItems) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCDisplay2MainSelection(DCMainItems dCMainItems) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCDisplay3MainSelection(DCMainItems dCMainItems) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setBCAstaMFA(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void requestSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setSIADistanceOilUser(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setSIADistanceAirFilterUser(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setSIADistanceOilFilterUser(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setSIAInspectionDistanceUser(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void requestDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCActiveDisplayPreset(int n) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDLicense(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setDCLEDConfiguration(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDPresets(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDCollectiveTopics(HUDCollectiveTopics hUDCollectiveTopics) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDAutoSkinSwitch(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void requestHUDSectionConfigList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }

    @Override
    public void setHUDSectionConfigList(CarArrayListUpdateInfo carArrayListUpdateInfo, HUDSectionConfigListRecord[] hUDSectionConfigListRecordArray) {
        this.logChan.log(1000, "null-call at NullDSICarKombi");
    }
}

