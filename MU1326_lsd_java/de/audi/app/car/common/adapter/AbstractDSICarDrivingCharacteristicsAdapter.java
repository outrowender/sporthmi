/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.adapter;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public abstract class AbstractDSICarDrivingCharacteristicsAdapter
extends AbstractCarComponent
implements DSICarDrivingCharacteristicsListener {
    private static volatile boolean hmiIsReady = false;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;

    public AbstractDSICarDrivingCharacteristicsAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarDrivingCharacteristics getDSI() {
        return (DSICarDrivingCharacteristics)this.getBaseDSI();
    }

    @Override
    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = AbstractDSICarDrivingCharacteristicsAdapter.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener).getName();
    }

    @Override
    public final String getDSIClassName() {
        return (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = AbstractDSICarDrivingCharacteristicsAdapter.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics).getName();
    }

    @Override
    public final boolean isUsingDSI() {
        return true;
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        if (!hmiIsReady) {
            hmiIsReady = true;
            this.getDSI().setHMIIsReady(true);
        }
    }

    @Override
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlLiftMode(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlCarJackMode(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlTrailerMode(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlLoadingMode(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlActiveProfile(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlAccessibleAirProfiles(SuspensionControlAirProfiles suspensionControlAirProfiles, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlAccessibleDRCProfiles(SuspensionControlDRCProfiles suspensionControlDRCProfiles, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlVehicleStatus(int n, int n2) {
        this.logStub();
    }

    public void updateSuspensionControlCurrentNiveau(int n, int n2) {
        this.logStub();
    }

    public void updateSuspensionControlTargetNiveau(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateCharismaActiveProfile(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateCharismaActiveOperationMode(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateCharismaContent(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateCharismaTrailerDetection(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateCharismaTrailerSetting(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateCharismaProgButton(CharismaProgButton charismaProgButton, int n) {
        this.logStub();
    }

    @Override
    public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        this.logStub();
    }

    @Override
    public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.logStub();
    }

    @Override
    public void requestCharismaPopup(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeCharismaPopup(int n) {
        this.logStub();
    }

    public void acknowledgeFpaSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeCharismaSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateTADContent(int n, int n2) {
        this.logStub();
    }

    @Override
    public void requestTADPopup(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeTADPopup(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeTADSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeTADMaxMinAngleReset(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateTADCurrentRollAngle(float f2, int n) {
        this.logStub();
    }

    @Override
    public void updateTADCurrentPitchAngle(float f2, int n) {
        this.logStub();
    }

    @Override
    public void updateTADPosMaxRollAngle(float f2, int n) {
        this.logStub();
    }

    @Override
    public void updateTADNegMaxRollAngle(float f2, int n) {
        this.logStub();
    }

    @Override
    public void updateTADPosMaxPitchAngle(float f2, int n) {
        this.logStub();
    }

    @Override
    public void updateTADNegMaxPitchAngle(float f2, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlCurrentLevel(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlTargetLevel(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlHeightInfo(SuspensionControlHeightInfo suspensionControlHeightInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages suspensionControlOperationMessages, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlSnowChainMode(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlVehicleStateControl(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSpoilerViewOptions(SpoilerViewOptions spoilerViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateSpoilerPositionSelection(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSpoilerState(SpoilerState spoilerState, int n) {
        this.logStub();
    }

    @Override
    public void updateSpoilerActuation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSpoilerMessages(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSpoilerSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeSpoilerSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlActiveMode(int n, boolean bl, int n2) {
        this.logStub();
    }

    @Override
    public void updateeABCEasyEntry(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateeABCPitchControl(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateeABCSpecialPosition(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateeABCPreview(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateeABCPreviewState(SuspensionControleABCPreview suspensionControleABCPreview, int n) {
        this.logStub();
    }

    @Override
    public void updateSuspensionControlActuatorInfo(SuspensionControlActuatorInfo suspensionControlActuatorInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateCharismaSound(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSoundViewOptions(SoundViewOptions soundViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateSoundStyle(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateSoundSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateSoundOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeSoundSetFactoryDefault(boolean bl) {
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

