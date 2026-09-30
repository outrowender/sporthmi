/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSICarComfortReply {
    public static final String IPL_COMM_UUID = "2e8af354-835e-5d86-ab41-fa96126e848b";
    public static final String IPL_COMM_INTERFACE_KEY = "a372bb2c-865c-5994-9ed0-8d60b782c773";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.32";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.32";

    public void updateRGSViewOptions(RGSViewOptions var1, int var2) throws MethodException;

    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData var1, int var2) throws MethodException;

    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData var1, int var2) throws MethodException;

    public void updateRGSPreCrashSystem(boolean var1, int var2) throws MethodException;

    public void acknowledgeRgsSetFactoryDefault(boolean var1) throws MethodException;

    public void updateRGSPreSenseSystem(boolean var1, int var2) throws MethodException;

    public void updateRGSPreSenseWarning(int var1, int var2) throws MethodException;

    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection var1, int var2) throws MethodException;

    public void updateDoorLockingViewOptions(DoorLockingViewOptions var1, int var2) throws MethodException;

    public void updateDoorLockingMessage(DoorLockingMessage var1, int var2) throws MethodException;

    public void updateDoorLockingLockStatus(DoorLockingLockStatus var1, int var2) throws MethodException;

    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus var1, int var2) throws MethodException;

    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings var1, int var2) throws MethodException;

    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings var1, int var2) throws MethodException;

    public void updateDoorLockingClBootOpen(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingBootOpen(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingBootClose(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingUnlockingMode(int var1, int var2) throws MethodException;

    public void updateDoorLockingAutoLock(int var1, int var2) throws MethodException;

    public void updateDoorLockingAutoUnlock(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingClBootLock(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingMirrorProtection(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingConfirmation(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingRainClosing(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingRearBlind(DoorLockingRearBlind var1, int var2) throws MethodException;

    public void acknowledgeDoorLockingSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeDoorLockingRemoteLockUnlock(String var1, boolean var2) throws MethodException;

    public void acknowledgeDoorLockingRemoteBlinking(boolean var1) throws MethodException;

    public void acknowledgeDoorLockingRemoteHorn(boolean var1) throws MethodException;

    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String var1) throws MethodException;

    public void receivedDoorLockingRemoteLockUnlockAuthentification(String var1, int var2) throws MethodException;

    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo var1, DoorLockingUserListRA1[] var2) throws MethodException;

    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo var1, int[] var2) throws MethodException;

    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo var1, int var2) throws MethodException;

    public void updateDoorLockingUserListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateDoorLockingActiveUser(int var1, int var2) throws MethodException;

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff var1, int var2) throws MethodException;

    public void acknowledgeDoorLockingUserProfileControl(int var1, boolean var2) throws MethodException;

    public void updateDoorLockingUserProfileControlProcessing(boolean var1, int var2, boolean var3, int var4) throws MethodException;

    public void updateDoorLockingWindowAutoClose(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingBlindsControl(int var1, int var2) throws MethodException;

    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState var1, int var2) throws MethodException;

    public void updateDoorLockingLeftSideBlindControl(int var1, int var2) throws MethodException;

    public void updateDoorLockingRightSideBlindControl(int var1, int var2) throws MethodException;

    public void updateDoorLockingTurnIndRepeat(boolean var1, int var2) throws MethodException;

    public void updateDoorLockingKeyless(boolean var1, int var2) throws MethodException;

    public void updateWiperViewOptions(WiperViewOptions var1, int var2) throws MethodException;

    public void updateWiperServicePosition(boolean var1, int var2) throws MethodException;

    public void updateWiperRainSensorOnOff(boolean var1, int var2) throws MethodException;

    public void updateWiperRainSensorConfig(int var1, int var2) throws MethodException;

    public void updateWiperRearWiping(boolean var1, int var2) throws MethodException;

    public void updateWiperTearsWiping(boolean var1, int var2) throws MethodException;

    public void updateWiperWinterPosition(boolean var1, int var2) throws MethodException;

    public void updateEasyEntrySteeringColumn(boolean var1, int var2) throws MethodException;

    public void acknowledgeWiperSetFactoryDefault(boolean var1) throws MethodException;

    public void updateUGDOViewOptions(UGDOViewOptions var1, int var2) throws MethodException;

    public void updateUGDOLearningData(UGDOLearningData var1, int var2) throws MethodException;

    public void updateUGDODestinationReached(UGDODestinationReached var1, int var2) throws MethodException;

    public void updateUGDOOpenDoor(UGDOOpenDoor var1, int var2) throws MethodException;

    public void updateUGDOContent(UGDOContent var1, int var2) throws MethodException;

    public void updateUGDOVersionData(UGDOVersionData var1, int var2) throws MethodException;

    public void acknowledgeUGDOSetFactoryDefault(boolean var1) throws MethodException;

    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo var1, int var2) throws MethodException;

    public void updateUGDOButtonListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void requestUGDOPopup(UGDOContent var1) throws MethodException;

    public void acknowledgeUGDOPopup(UGDOContent var1) throws MethodException;

    public void acknowledgeUGDODeleteButton(boolean var1) throws MethodException;

    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation var1) throws MethodException;

    public void acknowledgeUGDOLearning(int var1, int var2) throws MethodException;

    public void requestUGDOSynchronisation(UGDOSynchronisation var1) throws MethodException;

    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo var1, UGDOButtonListRA0[] var2) throws MethodException;

    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo var1, UGDOButtonListRA1[] var2) throws MethodException;

    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo var1, UGDOButtonListRA2[] var2) throws MethodException;

    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo var1, UGDOButtonListRA3[] var2) throws MethodException;

    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo var1, UGDOButtonListRA4[] var2) throws MethodException;

    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo var1, UGDOButtonListRA5[] var2) throws MethodException;

    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo var1, int[] var2) throws MethodException;

    public void updateRDKViewOptions(RDKViewOptions var1, int var2) throws MethodException;

    public void updateRDKSystemOnOff(boolean var1, int var2) throws MethodException;

    public void updateRDKTireSetupTireList(RDKTireInfo[] var1, int var2) throws MethodException;

    public void updateRDKTireSetupSelectedTire(int var1, int var2) throws MethodException;

    public void updateRDKTireDisplay(RDKTireDisplayData var1, int var2) throws MethodException;

    public void updateRDKSpeedLimit(int var1, int var2) throws MethodException;

    public void responseRDKTireChanged(int var1) throws MethodException;

    public void responseRDKPressureChanged(int var1) throws MethodException;

    public void responseRDKLifeMonitoring() throws MethodException;

    public void updateRDKPressureLevel(byte var1, int var2) throws MethodException;

    public void acknowledgeRDKSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeRDKPressureChanged(boolean var1) throws MethodException;

    public void updateMirrorViewOptions(MirrorViewOptions var1, int var2) throws MethodException;

    public void updateMirrorLowering(boolean var1, int var2) throws MethodException;

    public void updateMirrorSyncAdjust(boolean var1, int var2) throws MethodException;

    public void updateMirrorFolding(boolean var1, int var2) throws MethodException;

    public void updateMirrorDimming(boolean var1, int var2) throws MethodException;

    public void updateMirrorHeating(boolean var1, int var2) throws MethodException;

    public void acknowledgeMirrorSetFactoryDefault(boolean var1) throws MethodException;

    public void updateBrakeViewOptions(BrakeViewOptions var1, int var2) throws MethodException;

    public void updateBrakeElectricalParking(boolean var1, int var2) throws MethodException;

    public void updateBrakeAutoHold(int var1, int var2) throws MethodException;

    public void updateBrakeEscMode(int var1, int var2) throws MethodException;

    public void updateBrakeHdcMode(boolean var1, int var2) throws MethodException;

    public void updateRDKDifferentialPressure(RDKWheelPressures var1, int var2) throws MethodException;

    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime var1, int var2) throws MethodException;

    public void acknowledgeDoorLockingPrompt(int var1) throws MethodException;

    public void requestDoorLockingPrompt(int var1) throws MethodException;

    public void updateDoorLockingPromptContent(int var1, int var2) throws MethodException;

    public void acknowledgeMascotSetFactoryDefault(boolean var1) throws MethodException;

    public void updateMascotViewOptions(MascotViewOptions var1, int var2) throws MethodException;

    public void updateMascotControl(int var1, int var2, int var3) throws MethodException;

    public void updateMascotMode(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

