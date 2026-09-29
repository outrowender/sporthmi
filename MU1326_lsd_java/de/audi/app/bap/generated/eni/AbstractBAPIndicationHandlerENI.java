/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.eni;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandlerASG;
import de.audi.atip.log.LogChannel;
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
import de.vw.mib.bap.generated.eni.serializer.ServiceList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.TriggerRemoteProcess_Result;
import de.vw.mib.bap.generated.eni.serializer.UserList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.UserList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.VTANDataEncrypted_Status;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractBAPIndicationHandlerENI
extends AbstractBAPIndicationHandlerASG {
    public AbstractBAPIndicationHandlerENI(AbstractBAPModuleASG abstractBAPModuleASG, LogChannel logChannel) {
        super(abstractBAPModuleASG, logChannel);
    }

    @Override
    public void processIndicationResult(BAPFunctionMethodASG bAPFunctionMethodASG, ResultMethod resultMethod) {
        switch (bAPFunctionMethodASG.getFctID()) {
            case 18: {
                this.processTriggerRemoteProcessResult(bAPFunctionMethodASG, (TriggerRemoteProcess_Result)resultMethod);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerENI#processIndicationResult not implemented for fctID=%1", (Object)bAPFunctionMethodASG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, StatusProperty statusProperty) {
        switch (bAPFunctionPropertyASG.getFctID()) {
            case 2: {
                this.processBapConfigStatus(bAPFunctionPropertyASG, (BAP_Config_Status)statusProperty);
                break;
            }
            case 3: {
                this.processFunctionListStatus(bAPFunctionPropertyASG, (FunctionList_Status)statusProperty);
                break;
            }
            case 13: {
                this.processFsgControlStatus(bAPFunctionPropertyASG, (FSG_Control_Status)statusProperty);
                break;
            }
            case 14: {
                this.processFsgSetupStatus(bAPFunctionPropertyASG, (FSG_Setup_Status)statusProperty);
                break;
            }
            case 15: {
                this.processFsgOperationStateStatus(bAPFunctionPropertyASG, (FSG_OperationState_Status)statusProperty);
                break;
            }
            case 17: {
                this.processDestinationListAsGcapacityStatus(bAPFunctionPropertyASG, (DestinationList_ASGcapacity_Status)statusProperty);
                break;
            }
            case 19: {
                this.processRemoteProcessCommandsStatus(bAPFunctionPropertyASG, (RemoteProcessCommands_Status)statusProperty);
                break;
            }
            case 20: {
                this.processRemoteProcessStateStatus(bAPFunctionPropertyASG, (RemoteProcessState_Status)statusProperty);
                break;
            }
            case 23: {
                this.processActiveMonitoringsStatus(bAPFunctionPropertyASG, (ActiveMonitorings_Status)statusProperty);
                break;
            }
            case 24: {
                this.processPrivacySetupStatus(bAPFunctionPropertyASG, (PrivacySetup_Status)statusProperty);
                break;
            }
            case 26: {
                this.processMobileDeviceKeyCountStatus(bAPFunctionPropertyASG, (MobileDeviceKeyCount_Status)statusProperty);
                break;
            }
            case 27: {
                this.processVtanDataEncryptedStatus(bAPFunctionPropertyASG, (VTANDataEncrypted_Status)statusProperty);
                break;
            }
            case 28: {
                this.processOnlineUpdateStateDeprecatedStatus(bAPFunctionPropertyASG, (OnlineUpdateState_Deprecated_Status)statusProperty);
                break;
            }
            case 29: {
                this.processConnectionStateStatus(bAPFunctionPropertyASG, (ConnectionState_Status)statusProperty);
                break;
            }
            case 32: {
                this.processFoDStateStatus(bAPFunctionPropertyASG, (FoDState_Status)statusProperty);
                break;
            }
            case 33: {
                this.processActiveTripStatus(bAPFunctionPropertyASG, (ActiveTrip_Status)statusProperty);
                break;
            }
            case 34: {
                this.processOlbSettingsStatus(bAPFunctionPropertyASG, (OLBSettings_Status)statusProperty);
                break;
            }
            case 36: {
                this.processCurrentOnlineUpdateStateStatus(bAPFunctionPropertyASG, (CurrentOnlineUpdateState_Status)statusProperty);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerENI#processIndicationStatus not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, StatusAckProperty statusAckProperty) {
        switch (bAPFunctionPropertyASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerENI#processIndicationStatusAck not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
    }

    @Override
    public void processIndicationChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChangedArray changedArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            case 16: {
                this.processDestinationsListChangedArray(bAPFunctionArrayASG, (DestinationsList_ChangedArray)changedArray);
                break;
            }
            case 21: {
                this.processUserListChangedArray(bAPFunctionArrayASG, (UserList_ChangedArray)changedArray);
                break;
            }
            case 22: {
                this.processServiceListChangedArray(bAPFunctionArrayASG, (ServiceList_ChangedArray)changedArray);
                break;
            }
            case 25: {
                this.processAlertListChangedArray(bAPFunctionArrayASG, (AlertList_ChangedArray)changedArray);
                break;
            }
            case 30: {
                this.processChallengeDataChangedArray(bAPFunctionArrayASG, (ChallengeData_ChangedArray)changedArray);
                break;
            }
            case 31: {
                this.processFoDListChangedArray(bAPFunctionArrayASG, (FoDList_ChangedArray)changedArray);
                break;
            }
            case 35: {
                this.processOlbTripListChangedArray(bAPFunctionArrayASG, (OLBTripList_ChangedArray)changedArray);
                break;
            }
            case 37: {
                this.processOnlineUpdateListChangedArray(bAPFunctionArrayASG, (OnlineUpdateList_ChangedArray)changedArray);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerENI#processIndicationChangedArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            case 16: {
                this.processDestinationsListStatusArray(bAPFunctionArrayASG, (DestinationsList_StatusArray)statusArray);
                break;
            }
            case 21: {
                this.processUserListStatusArray(bAPFunctionArrayASG, (UserList_StatusArray)statusArray);
                break;
            }
            case 22: {
                this.processServiceListStatusArray(bAPFunctionArrayASG, (ServiceList_StatusArray)statusArray);
                break;
            }
            case 25: {
                this.processAlertListStatusArray(bAPFunctionArrayASG, (AlertList_StatusArray)statusArray);
                break;
            }
            case 30: {
                this.processChallengeDataStatusArray(bAPFunctionArrayASG, (ChallengeData_StatusArray)statusArray);
                break;
            }
            case 31: {
                this.processFoDListStatusArray(bAPFunctionArrayASG, (FoDList_StatusArray)statusArray);
                break;
            }
            case 35: {
                this.processOlbTripListStatusArray(bAPFunctionArrayASG, (OLBTripList_StatusArray)statusArray);
                break;
            }
            case 37: {
                this.processOnlineUpdateListStatusArray(bAPFunctionArrayASG, (OnlineUpdateList_StatusArray)statusArray);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerENI#processIndicationStatusArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
            }
        }
    }

    protected abstract void processBapConfigStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, BAP_Config_Status bAP_Config_Status) {
    }

    protected abstract void processFunctionListStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FunctionList_Status functionList_Status) {
    }

    protected abstract void processFsgControlStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Control_Status fSG_Control_Status) {
    }

    protected abstract void processFsgSetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Setup_Status fSG_Setup_Status) {
    }

    protected abstract void processFsgOperationStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_OperationState_Status fSG_OperationState_Status) {
    }

    protected abstract void processDestinationsListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, DestinationsList_ChangedArray destinationsList_ChangedArray) {
    }

    protected abstract void processDestinationsListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, DestinationsList_StatusArray destinationsList_StatusArray) {
    }

    protected abstract void processDestinationListAsGcapacityStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, DestinationList_ASGcapacity_Status destinationList_ASGcapacity_Status) {
    }

    protected abstract void processTriggerRemoteProcessResult(BAPFunctionMethodASG bAPFunctionMethodASG, TriggerRemoteProcess_Result triggerRemoteProcess_Result) {
    }

    protected abstract void processRemoteProcessCommandsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RemoteProcessCommands_Status remoteProcessCommands_Status) {
    }

    protected abstract void processRemoteProcessStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RemoteProcessState_Status remoteProcessState_Status) {
    }

    protected abstract void processUserListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, UserList_ChangedArray userList_ChangedArray) {
    }

    protected abstract void processUserListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, UserList_StatusArray userList_StatusArray) {
    }

    protected abstract void processServiceListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ServiceList_ChangedArray serviceList_ChangedArray) {
    }

    protected abstract void processServiceListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, ServiceList_StatusArray serviceList_StatusArray) {
    }

    protected abstract void processActiveMonitoringsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ActiveMonitorings_Status activeMonitorings_Status) {
    }

    protected abstract void processPrivacySetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, PrivacySetup_Status privacySetup_Status) {
    }

    protected abstract void processAlertListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, AlertList_ChangedArray alertList_ChangedArray) {
    }

    protected abstract void processAlertListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, AlertList_StatusArray alertList_StatusArray) {
    }

    protected abstract void processMobileDeviceKeyCountStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobileDeviceKeyCount_Status mobileDeviceKeyCount_Status) {
    }

    protected abstract void processVtanDataEncryptedStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, VTANDataEncrypted_Status vTANDataEncrypted_Status) {
    }

    protected abstract void processOnlineUpdateStateDeprecatedStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, OnlineUpdateState_Deprecated_Status onlineUpdateState_Deprecated_Status) {
    }

    protected abstract void processConnectionStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ConnectionState_Status connectionState_Status) {
    }

    protected abstract void processChallengeDataChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChallengeData_ChangedArray challengeData_ChangedArray) {
    }

    protected abstract void processChallengeDataStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChallengeData_StatusArray challengeData_StatusArray) {
    }

    protected abstract void processFoDListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, FoDList_ChangedArray foDList_ChangedArray) {
    }

    protected abstract void processFoDListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, FoDList_StatusArray foDList_StatusArray) {
    }

    protected abstract void processFoDStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FoDState_Status foDState_Status) {
    }

    protected abstract void processActiveTripStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ActiveTrip_Status activeTrip_Status) {
    }

    protected abstract void processOlbSettingsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, OLBSettings_Status oLBSettings_Status) {
    }

    protected abstract void processOlbTripListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, OLBTripList_ChangedArray oLBTripList_ChangedArray) {
    }

    protected abstract void processOlbTripListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, OLBTripList_StatusArray oLBTripList_StatusArray) {
    }

    protected abstract void processCurrentOnlineUpdateStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, CurrentOnlineUpdateState_Status currentOnlineUpdateState_Status) {
    }

    protected abstract void processOnlineUpdateListChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, OnlineUpdateList_ChangedArray onlineUpdateList_ChangedArray) {
    }

    protected abstract void processOnlineUpdateListStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, OnlineUpdateList_StatusArray onlineUpdateList_StatusArray) {
    }
}

