/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.DSICarLightListener;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightStatus;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public abstract class AbstractDSICarLightAdapter
extends AbstractCarComponent
implements DSICarLightListener {
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLightListener;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLight;

    public AbstractDSICarLightAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarLight getDSI() {
        return (DSICarLight)this.getBaseDSI();
    }

    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carlight$DSICarLightListener == null ? (class$org$dsi$ifc$carlight$DSICarLightListener = AbstractDSICarLightAdapter.class$("org.dsi.ifc.carlight.DSICarLightListener")) : class$org$dsi$ifc$carlight$DSICarLightListener).getName();
    }

    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carlight$DSICarLight == null ? (class$org$dsi$ifc$carlight$DSICarLight = AbstractDSICarLightAdapter.class$("org.dsi.ifc.carlight.DSICarLight")) : class$org$dsi$ifc$carlight$DSICarLight).getName();
    }

    public final boolean isUsingDSI() {
        return true;
    }

    public void updateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet1(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet2(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet3(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet4(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet5(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet6(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet7(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationSet8(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightTemperature(boolean bl, int n) {
        this.logStub();
    }

    public void updateIntLightColour(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightState(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightEnvironment(boolean bl, int n) {
        this.logStub();
    }

    public void updateIntLightSpeed(boolean bl, int n) {
        this.logStub();
    }

    public void updateIntLightBrightness(int n, int n2) {
        this.logStub();
    }

    public void updateExtLightComingHome(TimeState timeState, int n) {
        this.logStub();
    }

    public void updateExtLightLeavingHome(TimeState timeState, int n) {
        this.logStub();
    }

    public void updateExtLightSwitchOnSensitivity(int n, int n2) {
        this.logStub();
    }

    public void updateExtLightDaylight(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightTourist(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightAdaptive(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightHeadLightSystem(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightGlidingSystem(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightViewOptions(ExtLightViewOptions extLightViewOptions, int n) {
        this.logStub();
    }

    public void updateExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings, int n) {
        this.logStub();
    }

    public void updateExtLightMaskedHighBeam(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightLampErrorDetection(ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray, int n) {
        this.logStub();
    }

    public void updateExtLightLampErrorDetectionTrailer(ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray, int n) {
        this.logStub();
    }

    public void updateExtLightSensorErrorDetection(ExtLightSensorErrorDetectionState[] extLightSensorErrorDetectionStateArray, int n) {
        this.logStub();
    }

    public void updateExtLightStatus(ExtLightStatus extLightStatus, int n) {
        this.logStub();
    }

    public void updateExtLightAutomaticLight(boolean bl, boolean bl2, int n) {
        this.logStub();
    }

    public void acknowledgeIntLightSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeExtLightSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile1(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile2(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile3(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile4(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile5(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile6(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile7(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightIlluminationProfile8(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightActiveProfile(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues, int n) {
        this.logStub();
    }

    public void updateIntLightContourLightColor(IntLightRGBValues intLightRGBValues, int n) {
        this.logStub();
    }

    public void updateIntLightFollowUpTime(int n, int n2) {
        this.logStub();
    }

    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
        this.logStub();
    }

    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        this.logStub();
    }

    public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    public void updateExtLightLampErrorDetectionTrailer(ExtLightLampErrorDetectionStateTrailer[] extLightLampErrorDetectionStateTrailerArray, int n) {
        this.logStub();
    }

    public void updateIntLightBrightness(IntLightBrightness intLightBrightness, int n) {
        this.logStub();
    }

    public void updateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateExtLightLaserLight(boolean bl, int n) {
        this.logStub();
    }

    public void updateIntLightDoorContact(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightSignatureLight(boolean bl, int n) {
        this.logStub();
    }

    public void updateExtLightHeadlightRange(int n, int n2) {
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

