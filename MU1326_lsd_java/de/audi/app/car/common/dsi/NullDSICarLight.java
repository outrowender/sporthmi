/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public class NullDSICarLight
implements DSICarLight {
    private final LogChannel logChan;

    public NullDSICarLight(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightComingHome(TimeState timeState) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightLeavingHome(TimeState timeState) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightSwitchOnSensitivity(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightDayLight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightHeadLightSystem(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightGlidingLightSystem(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightAdaptive(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightTourist(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightMaskedHighBeam(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightAutomaticLight(boolean bl, boolean bl2) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightIlluminationSet(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightColour(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightState(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightEnvironment(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightSpeed(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightTemperature(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightIlluminationProfile(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightActiveProfile(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightContourLightColor(IntLightRGBValues intLightRGBValues) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightFollowUpTime(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightBrightness(IntLightBrightness intLightBrightness) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightLaserLight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setIntLightDoorContact(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightSignatureLight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    @Override
    public void setExtLightHeadlightRange(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }
}

