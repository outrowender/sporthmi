/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfort;
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

public abstract class AbstractDSICarComfortAdapter
extends AbstractCarComponent
implements DSICarComfortListener {
    private static volatile boolean hmiIsReady = false;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;

    public AbstractDSICarComfortAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarComfort getDSI() {
        return (DSICarComfort)this.getBaseDSI();
    }

    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = AbstractDSICarComfortAdapter.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener).getName();
    }

    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = AbstractDSICarComfortAdapter.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort).getName();
    }

    public final boolean isUsingDSI() {
        return true;
    }

    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        if (!hmiIsReady) {
            hmiIsReady = true;
            this.getDSI().setHMIIsReady(true);
        }
    }

    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        this.logStub();
    }

    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.logStub();
    }

    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.logStub();
    }

    public void updateRGSPreCrashSystem(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        this.logStub();
    }

    public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
        this.logStub();
    }

    public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
        this.logStub();
    }

    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
        this.logStub();
    }

    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
        this.logStub();
    }

    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
        this.logStub();
    }

    public void updateDoorLockingBootOpen(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingAutoBootOpen(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingUnlockingMode(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingAutoLock(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingAutoUnlock(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingBootLock(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingConfirmation(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingRainClosing(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
        this.logStub();
    }

    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        this.logStub();
    }

    public void updateWiperServicePosition(boolean bl, int n) {
        this.logStub();
    }

    public void updateWiperRainSensorOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void updateWiperRainSensorConfig(int n, int n2) {
        this.logStub();
    }

    public void updateWiperRearWiping(boolean bl, int n) {
        this.logStub();
    }

    public void updateWiperTearsWiping(boolean bl, int n) {
        this.logStub();
    }

    public void updateWiperWinterPosition(boolean bl, int n) {
        this.logStub();
    }

    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
        this.logStub();
    }

    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        this.logStub();
    }

    public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
        this.logStub();
    }

    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
        this.logStub();
    }

    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
        this.logStub();
    }

    public void requestUGDOPopup(UGDOContent uGDOContent) {
        this.logStub();
    }

    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
        this.logStub();
    }

    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        this.logStub();
    }

    public void updateRDKSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
        this.logStub();
    }

    public void updateRDKTireSetupSelectedTire(int n, int n2) {
        this.logStub();
    }

    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        this.logStub();
    }

    public void updateRDKSpeedLimit(int n, int n2) {
        this.logStub();
    }

    public void responseRDKTireChanged(int n) {
        this.logStub();
    }

    public void responseRDKPressureChanged(int n) {
        this.logStub();
    }

    public void responseRDKLifeMonitoring() {
        this.logStub();
    }

    public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
        this.logStub();
    }

    public void updateMirrorLowering(boolean bl, int n) {
        this.logStub();
    }

    public void updateMirrorSyncAdjust(boolean bl, int n) {
        this.logStub();
    }

    public void updateMirrorFolding(boolean bl, int n) {
        this.logStub();
    }

    public void updateMirrorDimming(boolean bl, int n) {
        this.logStub();
    }

    public void updateMirrorHeating(boolean bl, int n) {
        this.logStub();
    }

    public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
        this.logStub();
    }

    public void updateBrakeElectricalParking(boolean bl, int n) {
        this.logStub();
    }

    public void updateBrakeAutoHold(int n, int n2) {
        this.logStub();
    }

    public void updateBrakeEscMode(int n, int n2) {
        this.logStub();
    }

    public void acknowledgeWiperSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeRgsSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateRGSPreSenseSystem(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingBootOpen(boolean bl, int n) {
        this.logStub();
    }

    public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
        this.logStub();
    }

    public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
        this.logStub();
    }

    public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
        this.logStub();
    }

    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void acknowledgeUGDODeleteButton(boolean bl) {
        this.logStub();
    }

    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.logStub();
    }

    public void acknowledgeUGDOLearning(int n) {
        this.logStub();
    }

    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.logStub();
    }

    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        this.logStub();
    }

    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        this.logStub();
    }

    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        this.logStub();
    }

    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        this.logStub();
    }

    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        this.logStub();
    }

    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    public void updateRGSPreSenseWarning(int n, int n2) {
        this.logStub();
    }

    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
        this.logStub();
    }

    public void updateDoorLockingClBootOpen(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingBootClose(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingClBootLock(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
        this.logStub();
    }

    public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
        this.logStub();
    }

    public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
        this.logStub();
    }

    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
        this.logStub();
    }

    public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
        this.logStub();
    }

    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        this.logStub();
    }

    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
        this.logStub();
    }

    public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingActiveUser(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingUserProfileOnOff(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
        this.logStub();
    }

    public void acknowledgeUGDOLearning(int n, int n2) {
        this.logStub();
    }

    public void updateRDKPressureLevel(byte by, int n) {
        this.logStub();
    }

    public void updateBrakeHdcMode(boolean bl, int n) {
        this.logStub();
    }

    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
        this.logStub();
    }

    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
        this.logStub();
    }

    public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
        this.logStub();
    }

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
        this.logStub();
    }

    public void updateDoorLockingBlindsControl(int n, int n2) {
        this.logStub();
    }

    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        this.logStub();
    }

    public void acknowledgeRDKSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeRDKPressureChanged(boolean bl) {
        this.logStub();
    }

    public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
        this.logStub();
    }

    public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgeDoorLockingPrompt(int n) {
        this.logStub();
    }

    public void requestDoorLockingPrompt(int n) {
        this.logStub();
    }

    public void updateDoorLockingPromptContent(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
        this.logStub();
    }

    public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingRightSideBlindControl(int n, int n2) {
        this.logStub();
    }

    public void updateDoorLockingKeyless(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgeMascotSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateMascotViewOptions(MascotViewOptions mascotViewOptions, int n) {
        this.logStub();
    }

    public void updateMascotControl(int n, int n2, int n3) {
        this.logStub();
    }

    public void updateMascotMode(int n, int n2) {
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

