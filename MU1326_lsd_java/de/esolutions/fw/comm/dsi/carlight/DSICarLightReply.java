/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSICarLightReply {
    public static final String IPL_COMM_UUID = "6fd298cf-7a4c-5cc0-9482-6d593f42abf7";
    public static final String IPL_COMM_INTERFACE_KEY = "9fa84c8c-aed2-5cbc-9bde-ffca3b651341";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.20";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.20";

    public void updateIntLightViewOptions(IntLightViewOptions var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet1(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet2(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet3(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet4(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet5(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet6(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet7(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationSet8(int var1, int var2) throws MethodException;

    public void updateIntLightTemperature(boolean var1, int var2) throws MethodException;

    public void updateIntLightColour(int var1, int var2) throws MethodException;

    public void updateIntLightState(int var1, int var2) throws MethodException;

    public void updateIntLightEnvironment(boolean var1, int var2) throws MethodException;

    public void updateIntLightSpeed(boolean var1, int var2) throws MethodException;

    public void updateIntLightBrightness(IntLightBrightness var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile1(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile2(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile3(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile4(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile5(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile6(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile7(int var1, int var2) throws MethodException;

    public void updateIntLightIlluminationProfile8(int var1, int var2) throws MethodException;

    public void updateIntLightActiveProfile(int var1, int var2) throws MethodException;

    public void updateIntLightAmbientLightColor(IntLightRGBValues var1, int var2) throws MethodException;

    public void updateIntLightContourLightColor(IntLightRGBValues var1, int var2) throws MethodException;

    public void updateIntLightFollowUpTime(int var1, int var2) throws MethodException;

    public void updateIntLightDoorContact(boolean var1, int var2) throws MethodException;

    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo var1, int var2) throws MethodException;

    public void updateIntLightRGBColorListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo var1, IntLightRGBColorListRA0[] var2) throws MethodException;

    public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo var1, int[] var2) throws MethodException;

    public void updateExtLightComingHome(TimeState var1, int var2) throws MethodException;

    public void updateExtLightLeavingHome(TimeState var1, int var2) throws MethodException;

    public void updateExtLightSwitchOnSensitivity(int var1, int var2) throws MethodException;

    public void updateExtLightDaylight(boolean var1, int var2) throws MethodException;

    public void updateExtLightTourist(boolean var1, int var2) throws MethodException;

    public void updateExtLightAdaptive(boolean var1, int var2) throws MethodException;

    public void updateExtLightHeadLightSystem(boolean var1, int var2) throws MethodException;

    public void updateExtLightGlidingSystem(boolean var1, int var2) throws MethodException;

    public void updateExtLightViewOptions(ExtLightViewOptions var1, int var2) throws MethodException;

    public void updateExtLightMotorwayBlinking(MotorwayBlinkingSettings var1, int var2) throws MethodException;

    public void updateExtLightMaskedHighBeam(boolean var1, int var2) throws MethodException;

    public void updateExtLightLampErrorDetection(ExtLightLampErrorDetectionState[] var1, int var2) throws MethodException;

    public void updateExtLightLampErrorDetectionTrailer(ExtLightLampErrorDetectionStateTrailer[] var1, int var2) throws MethodException;

    public void updateExtLightSensorErrorDetection(ExtLightSensorErrorDetectionState[] var1, int var2) throws MethodException;

    public void updateExtLightAutomaticLight(boolean var1, boolean var2, int var3) throws MethodException;

    public void acknowledgeIntLightSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeExtLightSetFactoryDefault(boolean var1) throws MethodException;

    public void updateExtLightLaserLight(boolean var1, int var2) throws MethodException;

    public void updateExtLightSignatureLight(boolean var1, int var2) throws MethodException;

    public void updateExtLightHeadlightRange(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

