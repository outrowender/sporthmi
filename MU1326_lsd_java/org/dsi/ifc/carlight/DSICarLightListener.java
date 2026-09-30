/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public interface DSICarLightListener
extends DSIListener {
    public void updateIntLightViewOptions(IntLightViewOptions var1, int var2);

    public void updateIntLightIlluminationSet1(int var1, int var2);

    public void updateIntLightIlluminationSet2(int var1, int var2);

    public void updateIntLightIlluminationSet3(int var1, int var2);

    public void updateIntLightIlluminationSet4(int var1, int var2);

    public void updateIntLightIlluminationSet5(int var1, int var2);

    public void updateIntLightIlluminationSet6(int var1, int var2);

    public void updateIntLightIlluminationSet7(int var1, int var2);

    public void updateIntLightIlluminationSet8(int var1, int var2);

    public void updateIntLightTemperature(boolean var1, int var2);

    public void updateIntLightColour(int var1, int var2);

    public void updateIntLightState(int var1, int var2);

    public void updateIntLightEnvironment(boolean var1, int var2);

    public void updateIntLightSpeed(boolean var1, int var2);

    public void updateIntLightBrightness(IntLightBrightness var1, int var2);

    public void updateIntLightIlluminationProfile1(int var1, int var2);

    public void updateIntLightIlluminationProfile2(int var1, int var2);

    public void updateIntLightIlluminationProfile3(int var1, int var2);

    public void updateIntLightIlluminationProfile4(int var1, int var2);

    public void updateIntLightIlluminationProfile5(int var1, int var2);

    public void updateIntLightIlluminationProfile6(int var1, int var2);

    public void updateIntLightIlluminationProfile7(int var1, int var2);

    public void updateIntLightIlluminationProfile8(int var1, int var2);

    public void updateIntLightActiveProfile(int var1, int var2);

    public void updateIntLightAmbientLightColor(IntLightRGBValues var1, int var2);

    public void updateIntLightContourLightColor(IntLightRGBValues var1, int var2);

    public void updateIntLightFollowUpTime(int var1, int var2);

    public void updateIntLightDoorContact(boolean var1, int var2);

    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo var1, int var2);

    public void updateIntLightRGBColorListTotalNumberOfElements(int var1, int var2);

    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo var1, IntLightRGBColorListRA0[] var2);

    public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo var1, int[] var2);

    public void updateExtLightComingHome(TimeState var1, int var2);

    public void updateExtLightLeavingHome(TimeState var1, int var2);

    public void updateExtLightSwitchOnSensitivity(int var1, int var2);

    public void updateExtLightDaylight(boolean var1, int var2);

    public void updateExtLightTourist(boolean var1, int var2);

    public void updateExtLightAdaptive(boolean var1, int var2);

    public void updateExtLightHeadLightSystem(boolean var1, int var2);

    public void updateExtLightGlidingSystem(boolean var1, int var2);

    public void updateExtLightViewOptions(ExtLightViewOptions var1, int var2);

    public void updateExtLightMotorwayBlinking(MotorwayBlinkingSettings var1, int var2);

    public void updateExtLightMaskedHighBeam(boolean var1, int var2);

    public void updateExtLightLampErrorDetection(ExtLightLampErrorDetectionState[] var1, int var2);

    public void updateExtLightLampErrorDetectionTrailer(ExtLightLampErrorDetectionStateTrailer[] var1, int var2);

    public void updateExtLightSensorErrorDetection(ExtLightSensorErrorDetectionState[] var1, int var2);

    public void updateExtLightAutomaticLight(boolean var1, boolean var2, int var3);

    public void acknowledgeIntLightSetFactoryDefault(boolean var1);

    public void acknowledgeExtLightSetFactoryDefault(boolean var1);

    public void updateExtLightLaserLight(boolean var1, int var2);

    public void updateExtLightSignatureLight(boolean var1, int var2);

    public void updateExtLightHeadlightRange(int var1, int var2);
}

