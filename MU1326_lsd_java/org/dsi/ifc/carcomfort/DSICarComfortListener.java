/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
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

public interface DSICarComfortListener
extends DSIListener {
    public void updateRGSViewOptions(RGSViewOptions var1, int var2);

    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData var1, int var2);

    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData var1, int var2);

    public void updateRGSPreCrashSystem(boolean var1, int var2);

    public void acknowledgeRgsSetFactoryDefault(boolean var1);

    public void updateRGSPreSenseSystem(boolean var1, int var2);

    public void updateRGSPreSenseWarning(int var1, int var2);

    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection var1, int var2);

    public void updateDoorLockingViewOptions(DoorLockingViewOptions var1, int var2);

    public void updateDoorLockingMessage(DoorLockingMessage var1, int var2);

    public void updateDoorLockingLockStatus(DoorLockingLockStatus var1, int var2);

    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus var1, int var2);

    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings var1, int var2);

    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings var1, int var2);

    public void updateDoorLockingClBootOpen(boolean var1, int var2);

    public void updateDoorLockingBootOpen(boolean var1, int var2);

    public void updateDoorLockingBootClose(boolean var1, int var2);

    public void updateDoorLockingUnlockingMode(int var1, int var2);

    public void updateDoorLockingAutoLock(int var1, int var2);

    public void updateDoorLockingAutoUnlock(boolean var1, int var2);

    public void updateDoorLockingClBootLock(boolean var1, int var2);

    public void updateDoorLockingMirrorProtection(boolean var1, int var2);

    public void updateDoorLockingConfirmation(boolean var1, int var2);

    public void updateDoorLockingRainClosing(boolean var1, int var2);

    public void updateDoorLockingRearBlind(DoorLockingRearBlind var1, int var2);

    public void acknowledgeDoorLockingSetFactoryDefault(boolean var1);

    public void acknowledgeDoorLockingRemoteLockUnlock(String var1, boolean var2);

    public void acknowledgeDoorLockingRemoteBlinking(boolean var1);

    public void acknowledgeDoorLockingRemoteHorn(boolean var1);

    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String var1);

    public void receivedDoorLockingRemoteLockUnlockAuthentification(String var1, int var2);

    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo var1, DoorLockingUserListRA1[] var2);

    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo var1, int[] var2);

    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo var1, int var2);

    public void updateDoorLockingUserListTotalNumberOfElements(int var1, int var2);

    public void updateDoorLockingActiveUser(int var1, int var2);

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff var1, int var2);

    public void acknowledgeDoorLockingUserProfileControl(int var1, boolean var2);

    public void updateDoorLockingUserProfileControlProcessing(boolean var1, int var2, boolean var3, int var4);

    public void updateDoorLockingWindowAutoClose(boolean var1, int var2);

    public void updateDoorLockingBlindsControl(int var1, int var2);

    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState var1, int var2);

    public void updateDoorLockingLeftSideBlindControl(int var1, int var2);

    public void updateDoorLockingRightSideBlindControl(int var1, int var2);

    public void updateDoorLockingTurnIndRepeat(boolean var1, int var2);

    public void updateDoorLockingKeyless(boolean var1, int var2);

    public void updateWiperViewOptions(WiperViewOptions var1, int var2);

    public void updateWiperServicePosition(boolean var1, int var2);

    public void updateWiperRainSensorOnOff(boolean var1, int var2);

    public void updateWiperRainSensorConfig(int var1, int var2);

    public void updateWiperRearWiping(boolean var1, int var2);

    public void updateWiperTearsWiping(boolean var1, int var2);

    public void updateWiperWinterPosition(boolean var1, int var2);

    public void updateEasyEntrySteeringColumn(boolean var1, int var2);

    public void acknowledgeWiperSetFactoryDefault(boolean var1);

    public void updateUGDOViewOptions(UGDOViewOptions var1, int var2);

    public void updateUGDOLearningData(UGDOLearningData var1, int var2);

    public void updateUGDODestinationReached(UGDODestinationReached var1, int var2);

    public void updateUGDOOpenDoor(UGDOOpenDoor var1, int var2);

    public void updateUGDOContent(UGDOContent var1, int var2);

    public void updateUGDOVersionData(UGDOVersionData var1, int var2);

    public void acknowledgeUGDOSetFactoryDefault(boolean var1);

    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo var1, int var2);

    public void updateUGDOButtonListTotalNumberOfElements(int var1, int var2);

    public void requestUGDOPopup(UGDOContent var1);

    public void acknowledgeUGDOPopup(UGDOContent var1);

    public void acknowledgeUGDODeleteButton(boolean var1);

    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation var1);

    public void acknowledgeUGDOLearning(int var1, int var2);

    public void requestUGDOSynchronisation(UGDOSynchronisation var1);

    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo var1, UGDOButtonListRA0[] var2);

    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo var1, UGDOButtonListRA1[] var2);

    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo var1, UGDOButtonListRA2[] var2);

    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo var1, UGDOButtonListRA3[] var2);

    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo var1, UGDOButtonListRA4[] var2);

    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo var1, UGDOButtonListRA5[] var2);

    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo var1, int[] var2);

    public void updateRDKViewOptions(RDKViewOptions var1, int var2);

    public void updateRDKSystemOnOff(boolean var1, int var2);

    public void updateRDKTireSetupTireList(RDKTireInfo[] var1, int var2);

    public void updateRDKTireSetupSelectedTire(int var1, int var2);

    public void updateRDKTireDisplay(RDKTireDisplayData var1, int var2);

    public void updateRDKSpeedLimit(int var1, int var2);

    public void responseRDKTireChanged(int var1);

    public void responseRDKPressureChanged(int var1);

    public void responseRDKLifeMonitoring();

    public void updateRDKPressureLevel(byte var1, int var2);

    public void acknowledgeRDKSetFactoryDefault(boolean var1);

    public void acknowledgeRDKPressureChanged(boolean var1);

    public void updateMirrorViewOptions(MirrorViewOptions var1, int var2);

    public void updateMirrorLowering(boolean var1, int var2);

    public void updateMirrorSyncAdjust(boolean var1, int var2);

    public void updateMirrorFolding(boolean var1, int var2);

    public void updateMirrorDimming(boolean var1, int var2);

    public void updateMirrorHeating(boolean var1, int var2);

    public void acknowledgeMirrorSetFactoryDefault(boolean var1);

    public void updateBrakeViewOptions(BrakeViewOptions var1, int var2);

    public void updateBrakeElectricalParking(boolean var1, int var2);

    public void updateBrakeAutoHold(int var1, int var2);

    public void updateBrakeEscMode(int var1, int var2);

    public void updateBrakeHdcMode(boolean var1, int var2);

    public void updateRDKDifferentialPressure(RDKWheelPressures var1, int var2);

    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime var1, int var2);

    public void acknowledgeDoorLockingPrompt(int var1);

    public void requestDoorLockingPrompt(int var1);

    public void updateDoorLockingPromptContent(int var1, int var2);

    public void acknowledgeMascotSetFactoryDefault(boolean var1);

    public void updateMascotViewOptions(MascotViewOptions var1, int var2);

    public void updateMascotControl(int var1, int var2, int var3);

    public void updateMascotMode(int var1, int var2);
}

