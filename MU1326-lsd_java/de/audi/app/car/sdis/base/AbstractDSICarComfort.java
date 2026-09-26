/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;
import org.dsi.ifc.carcomfort.DoorLockingMessage;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;
import org.dsi.ifc.carcomfort.MascotViewOptions;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public class AbstractDSICarComfort
implements DSICarComfortListener {
    protected LogChannel logger;

    public AbstractDSICarComfort(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logStub();
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.logStub();
    }

    @Override
    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.logStub();
    }

    @Override
    public void updateRGSPreCrashSystem(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeRgsSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateRGSPreSenseSystem(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateRGSPreSenseWarning(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingClBootOpen(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingBootOpen(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingBootClose(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingUnlockingMode(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingAutoLock(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingAutoUnlock(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingClBootLock(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingConfirmation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingRainClosing(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
        this.logStub();
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
        this.logStub();
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
        this.logStub();
    }

    @Override
    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        this.logStub();
    }

    @Override
    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingActiveUser(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingUserProfileOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
        this.logStub();
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateWiperServicePosition(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateWiperRainSensorOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateWiperRainSensorConfig(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateWiperRearWiping(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateWiperTearsWiping(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateWiperWinterPosition(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWiperSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
        this.logStub();
    }

    @Override
    public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
        this.logStub();
    }

    @Override
    public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
        this.logStub();
    }

    @Override
    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
        this.logStub();
    }

    @Override
    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    @Override
    public void requestUGDOPopup(UGDOContent uGDOContent) {
        this.logStub();
    }

    @Override
    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
        this.logStub();
    }

    @Override
    public void acknowledgeUGDODeleteButton(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.logStub();
    }

    @Override
    public void acknowledgeUGDOLearning(int n, int n2) {
        this.logStub();
    }

    @Override
    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.logStub();
    }

    @Override
    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        this.logStub();
    }

    @Override
    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        this.logStub();
    }

    @Override
    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        this.logStub();
    }

    @Override
    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        this.logStub();
    }

    @Override
    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        this.logStub();
    }

    @Override
    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    @Override
    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateRDKSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
        this.logStub();
    }

    @Override
    public void updateRDKTireSetupSelectedTire(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        this.logStub();
    }

    @Override
    public void updateRDKSpeedLimit(int n, int n2) {
        this.logStub();
    }

    @Override
    public void responseRDKTireChanged(int n) {
        this.logStub();
    }

    @Override
    public void responseRDKPressureChanged(int n) {
        this.logStub();
    }

    @Override
    public void responseRDKLifeMonitoring() {
        this.logStub();
    }

    @Override
    public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateMirrorLowering(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateMirrorSyncAdjust(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateMirrorFolding(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateMirrorDimming(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateMirrorHeating(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateBrakeElectricalParking(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateBrakeAutoHold(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateBrakeEscMode(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateRDKPressureLevel(byte by, int n) {
        this.logStub();
    }

    @Override
    public void updateBrakeHdcMode(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
        this.logStub();
    }

    @Override
    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingBlindsControl(int n, int n2) {
        this.logStub();
    }

    @Override
    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        this.logStub();
    }

    @Override
    public void acknowledgeRDKSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeRDKPressureChanged(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeDoorLockingPrompt(int n) {
        this.logStub();
    }

    @Override
    public void requestDoorLockingPrompt(int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingPromptContent(int n, int n2) {
        this.logStub();
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
    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingRightSideBlindControl(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateDoorLockingKeyless(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeMascotSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateMascotViewOptions(MascotViewOptions mascotViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateMascotControl(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateMascotMode(int n, int n2) {
        this.logStub();
    }
}

