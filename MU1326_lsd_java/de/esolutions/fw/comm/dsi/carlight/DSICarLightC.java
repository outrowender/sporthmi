/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public interface DSICarLightC {
    public void setExtLightComingHome(TimeState var1) throws MethodException;

    public void setExtLightLeavingHome(TimeState var1) throws MethodException;

    public void setExtLightSwitchOnSensitivity(int var1) throws MethodException;

    public void setExtLightDayLight(boolean var1) throws MethodException;

    public void setExtLightHeadLightSystem(boolean var1) throws MethodException;

    public void setExtLightGlidingLightSystem(boolean var1) throws MethodException;

    public void setExtLightAdaptive(boolean var1) throws MethodException;

    public void setExtLightTourist(boolean var1) throws MethodException;

    public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings var1) throws MethodException;

    public void setExtLightMaskedHighBeam(boolean var1) throws MethodException;

    public void setExtLightAutomaticLight(boolean var1, boolean var2) throws MethodException;

    public void setExtLightSetFactoryDefault() throws MethodException;

    public void setExtLightLaserLight(boolean var1) throws MethodException;

    public void setExtLightSignatureLight(boolean var1) throws MethodException;

    public void setExtLightHeadlightRange(int var1) throws MethodException;

    public void setIntLightIlluminationSet(int var1, int var2) throws MethodException;

    public void setIntLightColour(int var1) throws MethodException;

    public void setIntLightState(int var1) throws MethodException;

    public void setIntLightEnvironment(boolean var1) throws MethodException;

    public void setIntLightSpeed(boolean var1) throws MethodException;

    public void setIntLightTemperature(boolean var1) throws MethodException;

    public void setIntLightBrightness(IntLightBrightness var1) throws MethodException;

    public void setIntLightSetFactoryDefault() throws MethodException;

    public void setIntLightIlluminationProfile(int var1, int var2) throws MethodException;

    public void setIntLightActiveProfile(int var1) throws MethodException;

    public void setIntLightAmbientLightColor(IntLightRGBValues var1) throws MethodException;

    public void setIntLightContourLightColor(IntLightRGBValues var1) throws MethodException;

    public void setIntLightFollowUpTime(int var1) throws MethodException;

    public void setIntLightDoorContact(boolean var1) throws MethodException;

    public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

