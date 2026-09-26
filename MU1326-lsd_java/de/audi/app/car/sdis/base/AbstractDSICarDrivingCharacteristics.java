/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
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

public class AbstractDSICarDrivingCharacteristics
implements DSICarDrivingCharacteristicsListener {
    protected LogChannel logger;

    public AbstractDSICarDrivingCharacteristics(LogChannel logChannel) {
        this.logger = logChannel;
    }

    protected void logStub() {
        try {
            StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
            String string = "??";
            if (stackTraceElementArray.length > 1) {
                StackTraceElement stackTraceElement = stackTraceElementArray[1];
                string = new StringBuffer().append(stackTraceElement.getClassName()).append(".").append(stackTraceElementArray[1].getMethodName()).toString();
            }
            this.logger.log(1078071040, "%1 not implemented", (Object)string);
        }
        catch (Exception exception) {
            this.logger.log(10000, "Exception: ", (Throwable)exception);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logStub();
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
}

