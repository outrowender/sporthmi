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

    public void processIndicationStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, StatusAckProperty statusAckProperty) {
        switch (bAPFunctionPropertyASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerENI#processIndicationStatusAck not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
    }

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

    protected abstract void processBapConfigStatus(BAPFunctionPropertyASG var1, BAP_Config_Status var2);

    protected abstract void processFunctionListStatus(BAPFunctionPropertyASG var1, FunctionList_Status var2);

    protected abstract void processFsgControlStatus(BAPFunctionPropertyASG var1, FSG_Control_Status var2);

    protected abstract void processFsgSetupStatus(BAPFunctionPropertyASG var1, FSG_Setup_Status var2);

    protected abstract void processFsgOperationStateStatus(BAPFunctionPropertyASG var1, FSG_OperationState_Status var2);

    protected abstract void processDestinationsListChangedArray(BAPFunctionArrayASG var1, DestinationsList_ChangedArray var2);

    protected abstract void processDestinationsListStatusArray(BAPFunctionArrayASG var1, DestinationsList_StatusArray var2);

    protected abstract void processDestinationListAsGcapacityStatus(BAPFunctionPropertyASG var1, DestinationList_ASGcapacity_Status var2);

    protected abstract void processTriggerRemoteProcessResult(BAPFunctionMethodASG var1, TriggerRemoteProcess_Result var2);

    protected abstract void processRemoteProcessCommandsStatus(BAPFunctionPropertyASG var1, RemoteProcessCommands_Status var2);

    protected abstract void processRemoteProcessStateStatus(BAPFunctionPropertyASG var1, RemoteProcessState_Status var2);

    protected abstract void processUserListChangedArray(BAPFunctionArrayASG var1, UserList_ChangedArray var2);

    protected abstract void processUserListStatusArray(BAPFunctionArrayASG var1, UserList_StatusArray var2);

    protected abstract void processServiceListChangedArray(BAPFunctionArrayASG var1, ServiceList_ChangedArray var2);

    protected abstract void processServiceListStatusArray(BAPFunctionArrayASG var1, ServiceList_StatusArray var2);

    protected abstract void processActiveMonitoringsStatus(BAPFunctionPropertyASG var1, ActiveMonitorings_Status var2);

    protected abstract void processPrivacySetupStatus(BAPFunctionPropertyASG var1, PrivacySetup_Status var2);

    protected abstract void processAlertListChangedArray(BAPFunctionArrayASG var1, AlertList_ChangedArray var2);

    protected abstract void processAlertListStatusArray(BAPFunctionArrayASG var1, AlertList_StatusArray var2);

    protected abstract void processMobileDeviceKeyCountStatus(BAPFunctionPropertyASG var1, MobileDeviceKeyCount_Status var2);

    protected abstract void processVtanDataEncryptedStatus(BAPFunctionPropertyASG var1, VTANDataEncrypted_Status var2);

    protected abstract void processOnlineUpdateStateDeprecatedStatus(BAPFunctionPropertyASG var1, OnlineUpdateState_Deprecated_Status var2);

    protected abstract void processConnectionStateStatus(BAPFunctionPropertyASG var1, ConnectionState_Status var2);

    protected abstract void processChallengeDataChangedArray(BAPFunctionArrayASG var1, ChallengeData_ChangedArray var2);

    protected abstract void processChallengeDataStatusArray(BAPFunctionArrayASG var1, ChallengeData_StatusArray var2);

    protected abstract void processFoDListChangedArray(BAPFunctionArrayASG var1, FoDList_ChangedArray var2);

    protected abstract void processFoDListStatusArray(BAPFunctionArrayASG var1, FoDList_StatusArray var2);

    protected abstract void processFoDStateStatus(BAPFunctionPropertyASG var1, FoDState_Status var2);

    protected abstract void processActiveTripStatus(BAPFunctionPropertyASG var1, ActiveTrip_Status var2);

    protected abstract void processOlbSettingsStatus(BAPFunctionPropertyASG var1, OLBSettings_Status var2);

    protected abstract void processOlbTripListChangedArray(BAPFunctionArrayASG var1, OLBTripList_ChangedArray var2);

    protected abstract void processOlbTripListStatusArray(BAPFunctionArrayASG var1, OLBTripList_StatusArray var2);

    protected abstract void processCurrentOnlineUpdateStateStatus(BAPFunctionPropertyASG var1, CurrentOnlineUpdateState_Status var2);

    protected abstract void processOnlineUpdateListChangedArray(BAPFunctionArrayASG var1, OnlineUpdateList_ChangedArray var2);

    protected abstract void processOnlineUpdateListStatusArray(BAPFunctionArrayASG var1, OnlineUpdateList_StatusArray var2);
}

