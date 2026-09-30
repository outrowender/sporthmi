/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSICarComfortC {
    public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData var1) throws MethodException;

    public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData var1) throws MethodException;

    public void setRGSPreCrashSystem(boolean var1) throws MethodException;

    public void setRgsSetFactoryDefault() throws MethodException;

    public void setRGSPreSenseSystem(boolean var1) throws MethodException;

    public void setRGSPreSenseWarning(int var1) throws MethodException;

    public void setRGSLocalHazardInformation(RGSLocalHazardInformation var1) throws MethodException;

    public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings var1) throws MethodException;

    public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings var1) throws MethodException;

    public void setDoorLockingClBootOpen(boolean var1) throws MethodException;

    public void setDoorLockingBootOpen(boolean var1) throws MethodException;

    public void setDoorLockingBootClose(boolean var1) throws MethodException;

    public void startDoorLockingRemoteLockUnlock(String var1) throws MethodException;

    public void abortDoorLockingRemoteLockUnlock() throws MethodException;

    public void sendDoorLockingRemoteLockUnlockSignature(String var1) throws MethodException;

    public void startDoorLockingRemoteBlinking(int var1) throws MethodException;

    public void startDoorLockingRemoteHorn(int var1) throws MethodException;

    public void setDoorLockingUnlockingMode(int var1) throws MethodException;

    public void setDoorLockingAutoLock(int var1) throws MethodException;

    public void setDoorLockingAutoUnlock(boolean var1) throws MethodException;

    public void setDoorLockingClBootLock(boolean var1) throws MethodException;

    public void setDoorLockingMirrorProtection(boolean var1) throws MethodException;

    public void setDoorLockingConfirmation(boolean var1) throws MethodException;

    public void setDoorLockingRainClosing(boolean var1) throws MethodException;

    public void setDoorLockingRearBlind(DoorLockingRearBlind var1) throws MethodException;

    public void setDoorLockingSetFactoryDefault() throws MethodException;

    public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo var1) throws MethodException;

    public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo var1, DoorLockingUserListRA1[] var2) throws MethodException;

    public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo var1, int[] var2) throws MethodException;

    public void setDoorLockingActiveUser(int var1) throws MethodException;

    public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff var1) throws MethodException;

    public void startDoorLockingUserProfileControl(int var1, int var2) throws MethodException;

    public void abortDoorLockingUserProfileControl() throws MethodException;

    public void setDoorLockingWindowAutoClose(boolean var1) throws MethodException;

    public void setDoorlockingBlindsControl(int var1) throws MethodException;

    public void setDoorlockingBlindsControlExtended(int var1) throws MethodException;

    public void setDoorLockingLeftSideBlindControl(int var1) throws MethodException;

    public void setDoorLockingRightSideBlindControl(int var1) throws MethodException;

    public void setDoorLockingTurnIndRepeat(boolean var1) throws MethodException;

    public void setDoorLockingKeyless(boolean var1) throws MethodException;

    public void setWiperServicePosition(boolean var1) throws MethodException;

    public void setWiperRainSensorOnOff(boolean var1) throws MethodException;

    public void setWiperRainSensorConfig(int var1) throws MethodException;

    public void setWiperRearWiping(boolean var1) throws MethodException;

    public void setWiperTearsWiping(boolean var1) throws MethodException;

    public void setWiperWinterPosition(boolean var1) throws MethodException;

    public void setEasyEntrySteeringColumn(boolean var1) throws MethodException;

    public void setWiperSetFactoryDefault() throws MethodException;

    public void setUGDOLearningData(UGDOLearningData var1) throws MethodException;

    public void showUGDOPopup(UGDOContent var1) throws MethodException;

    public void cancelUGDOPopup(UGDOContent var1) throws MethodException;

    public void deleteUGDOButton(UGDOSoftkeys var1) throws MethodException;

    public void setUGDOSetFactoryDefault() throws MethodException;

    public void setUGDODestinationReached(UGDODestinationReached var1) throws MethodException;

    public void setUGDOOpenDoor(UGDOOpenDoor var1) throws MethodException;

    public void setUGDOSynchronisation(UGDOSynchronisation var1) throws MethodException;

    public void responseUGDOSynchronisation(UGDOSynchronisation var1) throws MethodException;

    public void startUGDOLearning(int var1, int var2) throws MethodException;

    public void abortUGDOLearning() throws MethodException;

    public void requestUGDOButtonList(UGDOButtonListUpdateInfo var1) throws MethodException;

    public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo var1, UGDOButtonListRA0[] var2) throws MethodException;

    public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo var1, UGDOButtonListRA1[] var2) throws MethodException;

    public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo var1, UGDOButtonListRA2[] var2) throws MethodException;

    public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo var1, UGDOButtonListRA3[] var2) throws MethodException;

    public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo var1, UGDOButtonListRA4[] var2) throws MethodException;

    public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo var1, UGDOButtonListRA5[] var2) throws MethodException;

    public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo var1, int[] var2) throws MethodException;

    public void setRDKSystemOnOff(boolean var1) throws MethodException;

    public void setRDKTireSetupSelectedTire(int var1) throws MethodException;

    public void setRDKSpeedLimit(int var1) throws MethodException;

    public void setRDKTireChanged() throws MethodException;

    public void setRDKPressureChanged() throws MethodException;

    public void requestRDKLifeMonitoring() throws MethodException;

    public void setRDKPressureLevel(byte var1) throws MethodException;

    public void setRDKSetFactoryDefault() throws MethodException;

    public void setMirrorLowering(boolean var1) throws MethodException;

    public void setMirrorSyncAdjust(boolean var1) throws MethodException;

    public void setMirrorFolding(boolean var1) throws MethodException;

    public void setMirrorDimming(boolean var1) throws MethodException;

    public void setMirrorHeating(boolean var1) throws MethodException;

    public void setMirrorSetFactoryDefault() throws MethodException;

    public void setBrakeElectricalParking(boolean var1) throws MethodException;

    public void setBrakeAutoHold(int var1) throws MethodException;

    public void setBrakeEscMode(int var1) throws MethodException;

    public void setBrakeHdcMode(boolean var1) throws MethodException;

    public void setHMIIsReady(boolean var1) throws MethodException;

    public void showDoorLockingPrompt(int var1) throws MethodException;

    public void cancelDoorLockingPrompt(int var1) throws MethodException;

    public void setMascotSetFactoryDefault() throws MethodException;

    public void setMascotControl(int var1) throws MethodException;

    public void setMascotMode(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

