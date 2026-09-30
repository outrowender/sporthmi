/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang.dsi;

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

abstract class DsiCarComfortManagerDsiWrapper
implements DSICarComfortListener {
    DsiCarComfortManagerDsiWrapper() {
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
    }

    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
    }

    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
    }

    public void updateRGSPreCrashSystem(boolean bl, int n) {
    }

    public void acknowledgeRgsSetFactoryDefault(boolean bl) {
    }

    public void updateRGSPreSenseSystem(boolean bl, int n) {
    }

    public void updateRGSPreSenseWarning(int n, int n2) {
    }

    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
    }

    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
    }

    public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
    }

    public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
    }

    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
    }

    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
    }

    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
    }

    public void updateDoorLockingClBootOpen(boolean bl, int n) {
    }

    public void updateDoorLockingBootOpen(boolean bl, int n) {
    }

    public void updateDoorLockingBootClose(boolean bl, int n) {
    }

    public void updateDoorLockingUnlockingMode(int n, int n2) {
    }

    public void updateDoorLockingAutoLock(int n, int n2) {
    }

    public void updateDoorLockingAutoUnlock(boolean bl, int n) {
    }

    public void updateDoorLockingClBootLock(boolean bl, int n) {
    }

    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
    }

    public void updateDoorLockingConfirmation(boolean bl, int n) {
    }

    public void updateDoorLockingRainClosing(boolean bl, int n) {
    }

    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
    }

    public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
    }

    public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
    }

    public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
    }

    public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
    }

    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
    }

    public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
    }

    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
    }

    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
    }

    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
    }

    public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
    }

    public void updateDoorLockingActiveUser(int n, int n2) {
    }

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }

    public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
    }

    public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
    }

    public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
    }

    public void updateDoorLockingBlindsControl(int n, int n2) {
    }

    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
    }

    public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
    }

    public void updateDoorLockingRightSideBlindControl(int n, int n2) {
    }

    public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
    }

    public void updateDoorLockingKeyless(boolean bl, int n) {
    }

    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
    }

    public void updateWiperServicePosition(boolean bl, int n) {
    }

    public void updateWiperRainSensorOnOff(boolean bl, int n) {
    }

    public void updateWiperRainSensorConfig(int n, int n2) {
    }

    public void updateWiperRearWiping(boolean bl, int n) {
    }

    public void updateWiperTearsWiping(boolean bl, int n) {
    }

    public void updateWiperWinterPosition(boolean bl, int n) {
    }

    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
    }

    public void acknowledgeWiperSetFactoryDefault(boolean bl) {
    }

    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
    }

    public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
    }

    public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
    }

    public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
    }

    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
    }

    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
    }

    public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
    }

    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
    }

    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
    }

    public void requestUGDOPopup(UGDOContent uGDOContent) {
    }

    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
    }

    public void acknowledgeUGDODeleteButton(boolean bl) {
    }

    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    public void acknowledgeUGDOLearning(int n, int n2) {
    }

    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
    }

    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
    }

    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
    }

    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
    }

    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
    }

    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
    }

    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
    }

    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
    }

    public void updateRDKSystemOnOff(boolean bl, int n) {
    }

    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
    }

    public void updateRDKTireSetupSelectedTire(int n, int n2) {
    }

    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
    }

    public void updateRDKSpeedLimit(int n, int n2) {
    }

    public void responseRDKTireChanged(int n) {
    }

    public void responseRDKPressureChanged(int n) {
    }

    public void responseRDKLifeMonitoring() {
    }

    public void updateRDKPressureLevel(byte by, int n) {
    }

    public void acknowledgeRDKSetFactoryDefault(boolean bl) {
    }

    public void acknowledgeRDKPressureChanged(boolean bl) {
    }

    public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
    }

    public void updateMirrorLowering(boolean bl, int n) {
    }

    public void updateMirrorSyncAdjust(boolean bl, int n) {
    }

    public void updateMirrorFolding(boolean bl, int n) {
    }

    public void updateMirrorDimming(boolean bl, int n) {
    }

    public void updateMirrorHeating(boolean bl, int n) {
    }

    public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
    }

    public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
    }

    public void updateBrakeElectricalParking(boolean bl, int n) {
    }

    public void updateBrakeAutoHold(int n, int n2) {
    }

    public void updateBrakeEscMode(int n, int n2) {
    }

    public void updateBrakeHdcMode(boolean bl, int n) {
    }

    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
    }

    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
    }

    public void acknowledgeDoorLockingPrompt(int n) {
    }

    public void requestDoorLockingPrompt(int n) {
    }

    public void updateDoorLockingPromptContent(int n, int n2) {
    }

    public void acknowledgeMascotSetFactoryDefault(boolean bl) {
    }

    public void updateMascotViewOptions(MascotViewOptions mascotViewOptions, int n) {
    }

    public void updateMascotControl(int n, int n2, int n3) {
    }

    public void updateMascotMode(int n, int n2) {
    }
}

