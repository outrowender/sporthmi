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
import de.audi.atip.interapp.bap.eni.data.MobileKeyCount$Builder;
import de.audi.atip.interapp.bap.eni.data.Monitorings;
import de.audi.atip.interapp.bap.eni.data.Monitorings$Builder;
import de.audi.atip.interapp.bap.eni.data.PrivacySetup;
import de.audi.atip.interapp.bap.eni.data.PrivacySetup$Builder;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState$Builder;
import de.audi.atip.interapp.bap.eni.data.SupportedRemoteProcesses;
import de.audi.atip.interapp.bap.eni.data.SupportedRemoteProcesses$Builder;
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

    @Override
    public void processIndicationStatusArrayAck(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        this.logChannel.log(10000, "[BAPIndicationHandlerENI#processIndicationStatusArrayAck] not supported.");
    }

    @Override
    protected void processBapConfigStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, BAP_Config_Status bAP_Config_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processBapConfigStatus]");
    }

    @Override
    protected void processFunctionListStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FunctionList_Status functionList_Status) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerENI#processFunctionListStatus]");
        this.eniModule.getAppServiceListenerENI().onPrivacyModeSupported(functionList_Status.fctList.fctIdPrivacySetupAvailable);
    }

    @Override
    protected void processFsgControlStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Control_Status fSG_Control_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processFsgControlStatus]");
    }

    @Override
    protected void processFsgSetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Setup_Status fSG_Setup_Status) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerENI#processFsgSetupStatus]");
        this.eniModule.getAppServiceListenerENI().onFleetModeAvailability(fSG_Setup_Status.setup_Extensions.fleetModeEnabledDf3_4);
    }

    @Override
    protected void processFsgOperationStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_OperationState_Status fSG_OperationState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processFsgOperationStateStatus] state: %1", (long)fSG_OperationState_Status.op_State);
        this.eniModule.setFsgOperationState(fSG_OperationState_Status.op_State);
    }

    @Override
    protected void processDestinationsListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, DestinationsList_ChangedArray destinationsList_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processDestinationsListChangedArray]");
        this.eniModule.getBapArrayDataENI().getDestinationList().clear();
        ArrayUtilsASG.requestArrayElements(bAPFunctionArrayASG, 1, 0, true, new DestinationsList_GetArray());
    }

    @Override
    protected void processDestinationsListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, DestinationsList_StatusArray destinationsList_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processDestinationsListStatusArray]");
        this.eniModule.getBapArrayDataENI().getDestinationList().mergeElementsInList(destinationsList_StatusArray);
        if (this.eniModule.getBapArrayDataENI().getDestinationList().hasMoreElementsToRequest(destinationsList_StatusArray)) {
            ArrayUtilsASG.requestNextArrayElements(bAPFunctionArrayASG, BAPIndicationHandlerENI.lastPosIdAlreadyReceived(destinationsList_StatusArray.getArrayData()), 1, 0, true, new DestinationsList_GetArray());
        } else {
            int n = this.eniModule.getBapArrayDataENI().getDestinationList().size() > 0 ? 0 : 1;
            this.eniModule.getAppServiceENI().setDestinationListCapacity(n);
            this.eniModule.getAppServiceListenerENI().onDestinationList(this.eniModule.getBapArrayDataENI().destinations());
        }
    }

    @Override
    protected void processDestinationListAsGcapacityStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, DestinationList_ASGcapacity_Status destinationList_ASGcapacity_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processDestinationListAsGcapacityStatus] serializer.asgcapacity: %1", (long)destinationList_ASGcapacity_Status.asgcapacity);
    }

    @Override
    protected void processTriggerRemoteProcessResult(BAPFunctionMethodASG bAPFunctionMethodASG, TriggerRemoteProcess_Result triggerRemoteProcess_Result) {
        if (triggerRemoteProcess_Result != null) {
            boolean bl = triggerRemoteProcess_Result.triggerResult == 0;
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processTriggerRemoteProcessResult] succeeded: %1", bl);
            this.eniModule.getAppServiceListenerENI().onRemoteProcessFinished(bl);
        } else {
            this.logChannel.log(-1601830656, "[BAPIndicationHandlerENI#processTriggerRemoteProcessResult] indication error! Serializer is null.");
        }
    }

    @Override
    protected void processRemoteProcessCommandsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RemoteProcessCommands_Status remoteProcessCommands_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processRemoteProcessCommandsStatus]");
        SupportedRemoteProcesses$Builder supportedRemoteProcesses$Builder = SupportedRemoteProcesses.builder();
        supportedRemoteProcesses$Builder.setConfirmServiceExpirationWarningSupported(remoteProcessCommands_Status.supportedCommands0.confirmServiceExpiryWarningSupported);
        supportedRemoteProcesses$Builder.setDeleteUserListSupported(remoteProcessCommands_Status.supportedCommands0.remoteDeleteUserListSupported);
        supportedRemoteProcesses$Builder.setPairMainUserUsingPairingCodeSupported(remoteProcessCommands_Status.supportedCommands0.pairMainUserPairingCodeSupported);
        supportedRemoteProcesses$Builder.setPairMainUserUsingVehiclePinSupported(remoteProcessCommands_Status.supportedCommands0.pairMainUserVehiclePinSupported);
        supportedRemoteProcesses$Builder.setTerminateRemoteProcessSupported(remoteProcessCommands_Status.supportedCommands0.terminationByUserSupported);
        supportedRemoteProcesses$Builder.setUpdateUserListSupported(remoteProcessCommands_Status.supportedCommands0.remoteUpdateUserListSupported);
        this.eniModule.getAppServiceListenerENI().onSupportedRemoteProcesses(supportedRemoteProcesses$Builder.build());
    }

    @Override
    protected void processRemoteProcessStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RemoteProcessState_Status remoteProcessState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processRemoteProcessStateStatus]");
        RemoteProcessState$Builder remoteProcessState$Builder = RemoteProcessState.builder();
        remoteProcessState$Builder.setExceptionState(remoteProcessState_Status.exceptionState);
        remoteProcessState$Builder.setRemoteProcessKind(remoteProcessState_Status.commandType);
        remoteProcessState$Builder.setState(remoteProcessState_Status.processState);
        remoteProcessState$Builder.setUserListRequestInfo(remoteProcessState_Status.additionalData);
        RemoteProcessState remoteProcessState = remoteProcessState$Builder.build();
        this.eniModule.getAppServiceListenerENI().onRemoteProcessState(remoteProcessState);
        IBAPFunction iBAPFunction = this.eniModule.getBAPFunction(18);
        if (iBAPFunction != null) {
            iBAPFunction.onRemoteProcessState(remoteProcessState);
        }
    }

    @Override
    protected void processUserListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, UserList_ChangedArray userList_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processUserListChangedArray]");
        this.eniModule.getBapArrayDataENI().getUserList().clear();
        ArrayUtilsASG.requestArrayElements(bAPFunctionArrayASG, 3, 0, false, new UserList_GetArray());
    }

    @Override
    protected void processUserListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, UserList_StatusArray userList_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processUserListStatusArray]");
        this.eniModule.getBapArrayDataENI().getUserList().mergeElementsInList(userList_StatusArray);
        if (this.eniModule.getBapArrayDataENI().getUserList().hasMoreElementsToRequest(userList_StatusArray)) {
            ArrayUtilsASG.requestNextArrayElements(bAPFunctionArrayASG, BAPIndicationHandlerENI.lastPosIdAlreadyReceived(userList_StatusArray.getArrayData()), 3, 0, false, new UserList_GetArray());
        } else {
            this.eniModule.getAppServiceListenerENI().onUserList(this.eniModule.getBapArrayDataENI().users());
        }
    }

    @Override
    protected void processServiceListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ServiceList_ChangedArray serviceList_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processServiceListChangedArray]");
        this.eniModule.getBapArrayDataENI().getServiceList().clear();
        this.eniModule.getBAPFunctionArrayASG(22).reset();
        ArrayUtilsASG.requestArrayElements(bAPFunctionArrayASG, 1, 1, false, new ServiceList_GetArray());
    }

    @Override
    protected void processServiceListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, ServiceList_StatusArray serviceList_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processServiceListStatusArray]");
        this.eniModule.getBapArrayDataENI().getServiceList().mergeElementsInList(serviceList_StatusArray);
        if (this.eniModule.getBapArrayDataENI().getServiceList().hasMoreElementsToRequest(serviceList_StatusArray)) {
            ArrayUtilsASG.requestNextArrayElements(bAPFunctionArrayASG, BAPIndicationHandlerENI.lastPosIdAlreadyReceived(serviceList_StatusArray.getArrayData()), 1, 1, false, new ServiceList_GetArray());
        } else {
            this.eniModule.getAppServiceListenerENI().onServiceList(this.eniModule.getBapArrayDataENI().services());
        }
    }

    @Override
    protected void processActiveMonitoringsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ActiveMonitorings_Status activeMonitorings_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processActiveMonitoringsStatus]");
        Monitorings$Builder monitorings$Builder = Monitorings.builder();
        monitorings$Builder.setGeofenceEnabled(activeMonitorings_Status.monitoringStatus.geofenceActive);
        monitorings$Builder.setSpeedAlertEnabled(activeMonitorings_Status.monitoringStatus.speedAlertActive);
        monitorings$Builder.setValetAlertEnabled(activeMonitorings_Status.monitoringStatus.valetAlertActive);
        this.eniModule.getAppServiceListenerENI().onMonitorings(monitorings$Builder.build());
    }

    @Override
    protected void processPrivacySetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, PrivacySetup_Status privacySetup_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processPrivacySetupStatus]");
        PrivacySetup$Builder privacySetup$Builder = PrivacySetup.builder();
        privacySetup$Builder.setPrivacyModeOn(privacySetup_Status.setup.privacyModeIsActive);
        privacySetup$Builder.setCanBeModified(privacySetup_Status.modificationState.canBeModified);
        privacySetup$Builder.setModificationReason(privacySetup_Status.modificationReason);
        this.eniModule.getAppServiceListenerENI().onPrivacySetup(privacySetup$Builder.build());
    }

    @Override
    protected void processAlertListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, AlertList_ChangedArray alertList_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processAlertListChangedArray]");
    }

    @Override
    protected void processAlertListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, AlertList_StatusArray alertList_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processAlertListStatusArray]");
    }

    @Override
    protected void processMobileDeviceKeyCountStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobileDeviceKeyCount_Status mobileDeviceKeyCount_Status) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerENI#processMobileDeviceKeyCountStatus]");
        MobileKeyCount$Builder mobileKeyCount$Builder = MobileKeyCount.builder();
        mobileKeyCount$Builder.setKeyCountBackend(mobileDeviceKeyCount_Status.keyCountBackend);
        mobileKeyCount$Builder.setKeyCountBackendState(mobileDeviceKeyCount_Status.keyCountBackendState);
        mobileKeyCount$Builder.setVtanAvailable(mobileDeviceKeyCount_Status.notificationState.vtanAvailableInBackendDf3_6);
        this.eniModule.getAppServiceListenerENI().onMobileDeviceKeyCount(mobileKeyCount$Builder.build());
    }

    @Override
    protected void processVtanDataEncryptedStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, VTANDataEncrypted_Status vTANDataEncrypted_Status) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerENI#processVtanDataEncryptedStatus] serializer=%1", (Object)vTANDataEncrypted_Status.toString());
        this.eniModule.getAppServiceListenerENI().onVtanDataEncrypted(vTANDataEncrypted_Status.vtandataEncrypted.toString());
    }

    @Override
    protected void processOnlineUpdateStateDeprecatedStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, OnlineUpdateState_Deprecated_Status onlineUpdateState_Deprecated_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processOnlineUpdateStateDeprecatedStatus]");
    }

    @Override
    protected void processConnectionStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ConnectionState_Status connectionState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processConnectionStateStatus]");
    }

    @Override
    protected void processChallengeDataChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChallengeData_ChangedArray challengeData_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processChallengeDataChangedArray]");
    }

    @Override
    protected void processChallengeDataStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChallengeData_StatusArray challengeData_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processChallengeDataStatusArray]");
    }

    @Override
    protected void processFoDListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, FoDList_ChangedArray foDList_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processFoDListChangedArray]");
    }

    @Override
    protected void processFoDListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, FoDList_StatusArray foDList_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processFoDListStatusArray]");
    }

    @Override
    protected void processFoDStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FoDState_Status foDState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processFoDStateStatus]");
    }

    @Override
    protected void processActiveTripStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ActiveTrip_Status activeTrip_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processActiveTripStatus]");
    }

    @Override
    protected void processOlbSettingsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, OLBSettings_Status oLBSettings_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processOlbSettingsStatus]");
    }

    @Override
    protected void processOlbTripListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, OLBTripList_ChangedArray oLBTripList_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processOlbTripListChangedArray]");
    }

    @Override
    protected void processOlbTripListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, OLBTripList_StatusArray oLBTripList_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processOlbTripListStatusArray]");
    }

    @Override
    protected void processCurrentOnlineUpdateStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, CurrentOnlineUpdateState_Status currentOnlineUpdateState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processCurrentOnlineUpdateStateStatus]");
    }

    @Override
    protected void processOnlineUpdateListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, OnlineUpdateList_ChangedArray onlineUpdateList_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processOnlineUpdateListChangedArray]");
    }

    @Override
    protected void processOnlineUpdateListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, OnlineUpdateList_StatusArray onlineUpdateList_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerENI#processOnlineUpdateListStatusArray]");
    }

    private static int lastPosIdAlreadyReceived(BAPArrayData bAPArrayData) {
        if (bAPArrayData.size() == 0) {
            return 0;
        }
        return bAPArrayData.get(bAPArrayData.size() - 1).getPos();
    }
}

