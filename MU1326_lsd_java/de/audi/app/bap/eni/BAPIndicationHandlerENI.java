/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.eni.BAPModuleENI;
import de.audi.app.bap.fw.arrays.ArrayUtilsASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.generated.eni.AbstractBAPIndicationHandlerENI;
import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.eni.data.Monitorings;
import de.audi.atip.interapp.bap.eni.data.PrivacySetup;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.audi.atip.interapp.bap.eni.data.SupportedRemoteProcesses;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.generated.eni.serializer.ActiveMonitorings_Status;
import de.vw.mib.bap.generated.eni.serializer.ActiveTrip_Status;
import de.vw.mib.bap.generated.eni.serializer.AlertList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.AlertList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.eni.serializer.ChallengeData_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.ChallengeData_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.ConnectionState_Status;
import de.vw.mib.bap.generated.eni.serializer.CurrentOnlineUpdateState_Status;
import de.vw.mib.bap.generated.eni.serializer.DestinationList_ASGcapacity_Status;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.eni.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.eni.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.eni.serializer.FoDList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.FoDList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.FoDState_Status;
import de.vw.mib.bap.generated.eni.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.eni.serializer.MobileDeviceKeyCount_Status;
import de.vw.mib.bap.generated.eni.serializer.OLBSettings_Status;
import de.vw.mib.bap.generated.eni.serializer.OLBTripList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.OLBTripList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateState_Deprecated_Status;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_Status;
import de.vw.mib.bap.generated.eni.serializer.RemoteProcessCommands_Status;
import de.vw.mib.bap.generated.eni.serializer.RemoteProcessState_Status;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.TriggerRemoteProcess_Result;
import de.vw.mib.bap.generated.eni.serializer.UserList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.UserList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.UserList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.VTANDataEncrypted_Status;
import de.vw.mib.bap.requests.StatusArray;

public final class BAPIndicationHandlerENI
extends AbstractBAPIndicationHandlerENI {
    private final BAPModuleENI eniModule;

    public BAPIndicationHandlerENI(BAPModuleENI bAPModuleENI) {
        super(bAPModuleENI, bAPModuleENI.getLogChannel());
        this.eniModule = bAPModuleENI;
    }

    public void processIndicationStatusArrayAck(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        this.logChannel.log(10000, "[BAPIndicationHandlerENI#processIndicationStatusArrayAck] not supported.");
    }

    protected void processBapConfigStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, BAP_Config_Status bAP_Config_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processBapConfigStatus]");
    }

    protected void processFunctionListStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FunctionList_Status functionList_Status) {
        this.logChannel.log(1000000, "[BAPIndicationHandlerENI#processFunctionListStatus]");
        this.eniModule.getAppServiceListenerENI().onPrivacyModeSupported(functionList_Status.fctList.fctIdPrivacySetupAvailable);
    }

    protected void processFsgControlStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Control_Status fSG_Control_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processFsgControlStatus]");
    }

    protected void processFsgSetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Setup_Status fSG_Setup_Status) {
        this.logChannel.log(1000000, "[BAPIndicationHandlerENI#processFsgSetupStatus]");
        this.eniModule.getAppServiceListenerENI().onFleetModeAvailability(fSG_Setup_Status.setup_Extensions.fleetModeEnabledDf3_4);
    }

    protected void processFsgOperationStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_OperationState_Status fSG_OperationState_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processFsgOperationStateStatus] state: %1", (long)fSG_OperationState_Status.op_State);
        this.eniModule.setFsgOperationState(fSG_OperationState_Status.op_State);
    }

    protected void processDestinationsListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, DestinationsList_ChangedArray destinationsList_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processDestinationsListChangedArray]");
        this.eniModule.getBapArrayDataENI().getDestinationList().clear();
        ArrayUtilsASG.requestArrayElements(bAPFunctionArrayASG, 1, 0, true, new DestinationsList_GetArray());
    }

    protected void processDestinationsListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, DestinationsList_StatusArray destinationsList_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processDestinationsListStatusArray]");
        this.eniModule.getBapArrayDataENI().getDestinationList().mergeElementsInList(destinationsList_StatusArray);
        if (this.eniModule.getBapArrayDataENI().getDestinationList().hasMoreElementsToRequest(destinationsList_StatusArray)) {
            ArrayUtilsASG.requestNextArrayElements(bAPFunctionArrayASG, BAPIndicationHandlerENI.lastPosIdAlreadyReceived(destinationsList_StatusArray.getArrayData()), 1, 0, true, new DestinationsList_GetArray());
        } else {
            int n = this.eniModule.getBapArrayDataENI().getDestinationList().size() > 0 ? 0 : 1;
            this.eniModule.getAppServiceENI().setDestinationListCapacity(n);
            this.eniModule.getAppServiceListenerENI().onDestinationList(this.eniModule.getBapArrayDataENI().destinations());
        }
    }

    protected void processDestinationListAsGcapacityStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, DestinationList_ASGcapacity_Status destinationList_ASGcapacity_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processDestinationListAsGcapacityStatus] serializer.asgcapacity: %1", (long)destinationList_ASGcapacity_Status.asgcapacity);
    }

    protected void processTriggerRemoteProcessResult(BAPFunctionMethodASG bAPFunctionMethodASG, TriggerRemoteProcess_Result triggerRemoteProcess_Result) {
        if (triggerRemoteProcess_Result != null) {
            boolean bl = triggerRemoteProcess_Result.triggerResult == 0;
            this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processTriggerRemoteProcessResult] succeeded: %1", bl);
            this.eniModule.getAppServiceListenerENI().onRemoteProcessFinished(bl);
        } else {
            this.logChannel.log(100000, "[BAPIndicationHandlerENI#processTriggerRemoteProcessResult] indication error! Serializer is null.");
        }
    }

    protected void processRemoteProcessCommandsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RemoteProcessCommands_Status remoteProcessCommands_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processRemoteProcessCommandsStatus]");
        SupportedRemoteProcesses.Builder builder = SupportedRemoteProcesses.builder();
        builder.setConfirmServiceExpirationWarningSupported(remoteProcessCommands_Status.supportedCommands0.confirmServiceExpiryWarningSupported);
        builder.setDeleteUserListSupported(remoteProcessCommands_Status.supportedCommands0.remoteDeleteUserListSupported);
        builder.setPairMainUserUsingPairingCodeSupported(remoteProcessCommands_Status.supportedCommands0.pairMainUserPairingCodeSupported);
        builder.setPairMainUserUsingVehiclePinSupported(remoteProcessCommands_Status.supportedCommands0.pairMainUserVehiclePinSupported);
        builder.setTerminateRemoteProcessSupported(remoteProcessCommands_Status.supportedCommands0.terminationByUserSupported);
        builder.setUpdateUserListSupported(remoteProcessCommands_Status.supportedCommands0.remoteUpdateUserListSupported);
        this.eniModule.getAppServiceListenerENI().onSupportedRemoteProcesses(builder.build());
    }

    protected void processRemoteProcessStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RemoteProcessState_Status remoteProcessState_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processRemoteProcessStateStatus]");
        RemoteProcessState.Builder builder = RemoteProcessState.builder();
        builder.setExceptionState(remoteProcessState_Status.exceptionState);
        builder.setRemoteProcessKind(remoteProcessState_Status.commandType);
        builder.setState(remoteProcessState_Status.processState);
        builder.setUserListRequestInfo(remoteProcessState_Status.additionalData);
        RemoteProcessState remoteProcessState = builder.build();
        this.eniModule.getAppServiceListenerENI().onRemoteProcessState(remoteProcessState);
        IBAPFunction iBAPFunction = this.eniModule.getBAPFunction(18);
        if (iBAPFunction != null) {
            iBAPFunction.onRemoteProcessState(remoteProcessState);
        }
    }

    protected void processUserListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, UserList_ChangedArray userList_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processUserListChangedArray]");
        this.eniModule.getBapArrayDataENI().getUserList().clear();
        ArrayUtilsASG.requestArrayElements(bAPFunctionArrayASG, 3, 0, false, new UserList_GetArray());
    }

    protected void processUserListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, UserList_StatusArray userList_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processUserListStatusArray]");
        this.eniModule.getBapArrayDataENI().getUserList().mergeElementsInList(userList_StatusArray);
        if (this.eniModule.getBapArrayDataENI().getUserList().hasMoreElementsToRequest(userList_StatusArray)) {
            ArrayUtilsASG.requestNextArrayElements(bAPFunctionArrayASG, BAPIndicationHandlerENI.lastPosIdAlreadyReceived(userList_StatusArray.getArrayData()), 3, 0, false, new UserList_GetArray());
        } else {
            this.eniModule.getAppServiceListenerENI().onUserList(this.eniModule.getBapArrayDataENI().users());
        }
    }

    protected void processServiceListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ServiceList_ChangedArray serviceList_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processServiceListChangedArray]");
        this.eniModule.getBapArrayDataENI().getServiceList().clear();
        this.eniModule.getBAPFunctionArrayASG(22).reset();
        ArrayUtilsASG.requestArrayElements(bAPFunctionArrayASG, 1, 1, false, new ServiceList_GetArray());
    }

    protected void processServiceListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, ServiceList_StatusArray serviceList_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processServiceListStatusArray]");
        this.eniModule.getBapArrayDataENI().getServiceList().mergeElementsInList(serviceList_StatusArray);
        if (this.eniModule.getBapArrayDataENI().getServiceList().hasMoreElementsToRequest(serviceList_StatusArray)) {
            ArrayUtilsASG.requestNextArrayElements(bAPFunctionArrayASG, BAPIndicationHandlerENI.lastPosIdAlreadyReceived(serviceList_StatusArray.getArrayData()), 1, 1, false, new ServiceList_GetArray());
        } else {
            this.eniModule.getAppServiceListenerENI().onServiceList(this.eniModule.getBapArrayDataENI().services());
        }
    }

    protected void processActiveMonitoringsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ActiveMonitorings_Status activeMonitorings_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processActiveMonitoringsStatus]");
        Monitorings.Builder builder = Monitorings.builder();
        builder.setGeofenceEnabled(activeMonitorings_Status.monitoringStatus.geofenceActive);
        builder.setSpeedAlertEnabled(activeMonitorings_Status.monitoringStatus.speedAlertActive);
        builder.setValetAlertEnabled(activeMonitorings_Status.monitoringStatus.valetAlertActive);
        this.eniModule.getAppServiceListenerENI().onMonitorings(builder.build());
    }

    protected void processPrivacySetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, PrivacySetup_Status privacySetup_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processPrivacySetupStatus]");
        PrivacySetup.Builder builder = PrivacySetup.builder();
        builder.setPrivacyModeOn(privacySetup_Status.setup.privacyModeIsActive);
        builder.setCanBeModified(privacySetup_Status.modificationState.canBeModified);
        builder.setModificationReason(privacySetup_Status.modificationReason);
        this.eniModule.getAppServiceListenerENI().onPrivacySetup(builder.build());
    }

    protected void processAlertListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, AlertList_ChangedArray alertList_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processAlertListChangedArray]");
    }

    protected void processAlertListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, AlertList_StatusArray alertList_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processAlertListStatusArray]");
    }

    protected void processMobileDeviceKeyCountStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobileDeviceKeyCount_Status mobileDeviceKeyCount_Status) {
        this.logChannel.log(1000000, "[BAPIndicationHandlerENI#processMobileDeviceKeyCountStatus]");
        MobileKeyCount.Builder builder = MobileKeyCount.builder();
        builder.setKeyCountBackend(mobileDeviceKeyCount_Status.keyCountBackend);
        builder.setKeyCountBackendState(mobileDeviceKeyCount_Status.keyCountBackendState);
        builder.setVtanAvailable(mobileDeviceKeyCount_Status.notificationState.vtanAvailableInBackendDf3_6);
        this.eniModule.getAppServiceListenerENI().onMobileDeviceKeyCount(builder.build());
    }

    protected void processVtanDataEncryptedStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, VTANDataEncrypted_Status vTANDataEncrypted_Status) {
        this.logChannel.log(1000000, "[BAPIndicationHandlerENI#processVtanDataEncryptedStatus] serializer=%1", (Object)vTANDataEncrypted_Status.toString());
        this.eniModule.getAppServiceListenerENI().onVtanDataEncrypted(vTANDataEncrypted_Status.vtandataEncrypted.toString());
    }

    protected void processOnlineUpdateStateDeprecatedStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, OnlineUpdateState_Deprecated_Status onlineUpdateState_Deprecated_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processOnlineUpdateStateDeprecatedStatus]");
    }

    protected void processConnectionStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ConnectionState_Status connectionState_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processConnectionStateStatus]");
    }

    protected void processChallengeDataChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChallengeData_ChangedArray challengeData_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processChallengeDataChangedArray]");
    }

    protected void processChallengeDataStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChallengeData_StatusArray challengeData_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processChallengeDataStatusArray]");
    }

    protected void processFoDListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, FoDList_ChangedArray foDList_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processFoDListChangedArray]");
    }

    protected void processFoDListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, FoDList_StatusArray foDList_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processFoDListStatusArray]");
    }

    protected void processFoDStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FoDState_Status foDState_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processFoDStateStatus]");
    }

    protected void processActiveTripStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ActiveTrip_Status activeTrip_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processActiveTripStatus]");
    }

    protected void processOlbSettingsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, OLBSettings_Status oLBSettings_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processOlbSettingsStatus]");
    }

    protected void processOlbTripListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, OLBTripList_ChangedArray oLBTripList_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processOlbTripListChangedArray]");
    }

    protected void processOlbTripListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, OLBTripList_StatusArray oLBTripList_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processOlbTripListStatusArray]");
    }

    protected void processCurrentOnlineUpdateStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, CurrentOnlineUpdateState_Status currentOnlineUpdateState_Status) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processCurrentOnlineUpdateStateStatus]");
    }

    protected void processOnlineUpdateListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, OnlineUpdateList_ChangedArray onlineUpdateList_ChangedArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processOnlineUpdateListChangedArray]");
    }

    protected void processOnlineUpdateListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, OnlineUpdateList_StatusArray onlineUpdateList_StatusArray) {
        this.logChannel.log(10000000, "[BAPIndicationHandlerENI#processOnlineUpdateListStatusArray]");
    }

    private static int lastPosIdAlreadyReceived(BAPArrayData bAPArrayData) {
        if (bAPArrayData.size() == 0) {
            return 0;
        }
        return bAPArrayData.get(bAPArrayData.size() - 1).getPos();
    }
}

