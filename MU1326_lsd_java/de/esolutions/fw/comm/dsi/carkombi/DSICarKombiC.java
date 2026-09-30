/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi;

import de.esolutions.fw.comm.core.method.MethodException;
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
import org.dsi.ifc.carkombi.HUDCollectiveTopics;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDSectionConfigListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarKombiC {
    public void resetSIAValue(int var1) throws MethodException;

    public void requestSIAHistoryList(CarArrayListUpdateInfo var1) throws MethodException;

    public void setSIADistanceOilUser(int var1, int var2) throws MethodException;

    public void setSIADistanceAirFilterUser(int var1, int var2) throws MethodException;

    public void setSIADistanceOilFilterUser(int var1, int var2) throws MethodException;

    public void setSIAInspectionDistanceUser(int var1, int var2) throws MethodException;

    public void setBCVZADisplay(boolean var1) throws MethodException;

    public void setBCLifeTipsDisplay(boolean var1) throws MethodException;

    public void setBCConsumerDisplay(boolean var1) throws MethodException;

    public void setBCMenueConfig(BCMenueConfiguration var1, int var2) throws MethodException;

    public void resetBCMenue(int var1) throws MethodException;

    public void setBCOilTemperature(boolean var1) throws MethodException;

    public void setBCDigitalSpeed(boolean var1) throws MethodException;

    public void setBCStopwatch(boolean var1) throws MethodException;

    public void setBCVzaMFA(boolean var1) throws MethodException;

    public void setBCSpeedWarning(BCSpeedWarningSettings var1) throws MethodException;

    public void setBCGearRecommendation(boolean var1) throws MethodException;

    public void setBCRearSeatbeltWarning(boolean var1) throws MethodException;

    public void requestVehicleStateList(BCVehicleStateUpdateInfoAH var1) throws MethodException;

    public void setBcSetFactoryDefault() throws MethodException;

    public void resetBCStatistics(BCStatisticsReset var1) throws MethodException;

    public void setBCAstaMFA(boolean var1) throws MethodException;

    public void setHUDHeightAdjustment(byte var1) throws MethodException;

    public void setHUDBrightness(byte var1) throws MethodException;

    public void setHUDContent(HUDContent var1) throws MethodException;

    public void setHUDRotationAdjustment(int var1) throws MethodException;

    public void setHUDColour(int var1, int var2) throws MethodException;

    public void setHUDSetFactoryDefault() throws MethodException;

    public void setHUDSystemOnOff(boolean var1) throws MethodException;

    public void setHUDPresets(int var1, int var2) throws MethodException;

    public void setHUDCollectiveTopics(HUDCollectiveTopics var1) throws MethodException;

    public void setHUDAutoSkinSwitch(boolean var1) throws MethodException;

    public void requestHUDSectionConfigList(CarArrayListUpdateInfo var1) throws MethodException;

    public void setHUDSectionConfigList(CarArrayListUpdateInfo var1, HUDSectionConfigListRecord[] var2) throws MethodException;

    public void setDCSetFactoryDefault() throws MethodException;

    public void setDCBrightness(int var1) throws MethodException;

    public void setDCVolume(int var1) throws MethodException;

    public void setDCDisplay1MainSelection(DCMainItems var1) throws MethodException;

    public void setDCDisplay2MainSelection(DCMainItems var1) throws MethodException;

    public void setDCDisplay3MainSelection(DCMainItems var1) throws MethodException;

    public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo var1) throws MethodException;

    public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo var1, DCElementContentSelectionListRA1[] var2) throws MethodException;

    public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo var1, DCElementContentSelectionListRA2[] var2) throws MethodException;

    public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo var1, int[] var2) throws MethodException;

    public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument var1) throws MethodException;

    public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 var1) throws MethodException;

    public void requestDCDisplayPresetsList(CarArrayListUpdateInfo var1) throws MethodException;

    public void setDCDisplayPresetsList(CarArrayListUpdateInfo var1, DCDisplayPresetsListRecord[] var2) throws MethodException;

    public void setDCDisplayDependencySetup(DCDisplayDependency var1) throws MethodException;

    public void setDCActiveDisplayPreset(int var1) throws MethodException;

    public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration var1) throws MethodException;

    public void setHUDLicense(boolean var1) throws MethodException;

    public void setDCLEDConfiguration(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

