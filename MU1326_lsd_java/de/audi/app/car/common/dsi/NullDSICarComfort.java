/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
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
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public class NullDSICarComfort
implements DSICarComfort {
    private final LogChannel logChan;

    public NullDSICarComfort(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData rGSBeltPretensionData) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData rGSBeltPretensionData) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRGSPreCrashSystem(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingBootOpen(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    public void setDoorLockingAutoBootOpen(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingUnlockingMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingAutoLock(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingAutoUnlock(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    public void setDoorLockingBootLock(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingMirrorProtection(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingConfirmation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingRainClosing(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setWiperServicePosition(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setWiperRainSensorOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setWiperRainSensorConfig(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setWiperRearWiping(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setWiperTearsWiping(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setWiperWinterPosition(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setEasyEntrySteeringColumn(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOLearningData(UGDOLearningData uGDOLearningData) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void showUGDOPopup(UGDOContent uGDOContent) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void cancelUGDOPopup(UGDOContent uGDOContent) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    public void deleteUGDOButton(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void deleteUGDOButton(UGDOSoftkeys uGDOSoftkeys) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRDKSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRDKTireSetupSelectedTire(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRDKSpeedLimit(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRDKTireChanged() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRDKPressureChanged() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void requestRDKLifeMonitoring() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMirrorLowering(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMirrorSyncAdjust(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMirrorFolding(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMirrorDimming(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMirrorHeating(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setBrakeElectricalParking(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setBrakeAutoHold(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setBrakeEscMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setWiperSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMirrorSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    public void setUgdoSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRgsSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRGSPreSenseSystem(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDODestinationReached(UGDODestinationReached uGDODestinationReached) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void responseUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void startUGDOLearning(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void abortUGDOLearning() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void requestUGDOButtonList(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRGSPreSenseWarning(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRGSLocalHazardInformation(RGSLocalHazardInformation rGSLocalHazardInformation) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingClBootOpen(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingBootClose(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void startDoorLockingRemoteLockUnlock(String string) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void abortDoorLockingRemoteLockUnlock() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void sendDoorLockingRemoteLockUnlockSignature(String string) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void startDoorLockingRemoteBlinking(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void startDoorLockingRemoteHorn(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingClBootLock(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingActiveUser(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    public void setDoorLockingUserProfileOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void startDoorLockingUserProfileControl(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRDKPressureLevel(byte by) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setBrakeHdcMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void abortDoorLockingUserProfileControl() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingWindowAutoClose(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorlockingBlindsControl(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setRDKSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingTurnIndRepeat(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void showDoorLockingPrompt(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void cancelDoorLockingPrompt(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorlockingBlindsControlExtended(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingLeftSideBlindControl(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingRightSideBlindControl(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setDoorLockingKeyless(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMascotSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMascotControl(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }

    @Override
    public void setMascotMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarComfort");
    }
}

