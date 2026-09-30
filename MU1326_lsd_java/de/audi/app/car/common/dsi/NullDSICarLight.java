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

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightComingHome(TimeState timeState) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightLeavingHome(TimeState timeState) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightSwitchOnSensitivity(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightDayLight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightHeadLightSystem(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightGlidingLightSystem(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightAdaptive(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightTourist(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightMaskedHighBeam(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightAutomaticLight(boolean bl, boolean bl2) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightIlluminationSet(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightColour(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightState(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightEnvironment(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightSpeed(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightTemperature(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightIlluminationProfile(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightActiveProfile(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightContourLightColor(IntLightRGBValues intLightRGBValues) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightFollowUpTime(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightBrightness(IntLightBrightness intLightBrightness) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightLaserLight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setIntLightDoorContact(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightSignatureLight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }

    public void setExtLightHeadlightRange(int n) {
        this.logChan.log(1000, "null-call at NullDSICarLight");
    }
}

