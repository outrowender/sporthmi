/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.eni;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.IFunctionRegistrationASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.fw.functiontypes.RetryConfig;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.eni.serializer.ActiveMonitorings_Status;
import de.vw.mib.bap.generated.eni.serializer.ActiveTrip_SetGet;
import de.vw.mib.bap.generated.eni.serializer.ActiveTrip_Status;
import de.vw.mib.bap.generated.eni.serializer.AlertList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.AlertList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.AlertList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.eni.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.eni.serializer.ChallengeData_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.ChallengeData_GetArray;
import de.vw.mib.bap.generated.eni.serializer.ChallengeData_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.ConnectionState_Status;
import de.vw.mib.bap.generated.eni.serializer.CurrentOnlineUpdateState_Status;
import de.vw.mib.bap.generated.eni.serializer.DestinationList_ASGcapacity_SetGet;
import de.vw.mib.bap.generated.eni.serializer.DestinationList_ASGcapacity_Status;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_SetGetArray;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.FSG_Control_SetGet;
import de.vw.mib.bap.generated.eni.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.eni.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.eni.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.eni.serializer.FoDList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.FoDList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.FoDList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.FoDState_Status;
import de.vw.mib.bap.generated.eni.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.eni.serializer.MobileDeviceKeyCount_Status;
import de.vw.mib.bap.generated.eni.serializer.OLBSettings_SetGet;
import de.vw.mib.bap.generated.eni.serializer.OLBSettings_Status;
import de.vw.mib.bap.generated.eni.serializer.OLBTripList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.OLBTripList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.OLBTripList_SetGetArray;
import de.vw.mib.bap.generated.eni.serializer.OLBTripList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_SetGetArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateState_Deprecated_Status;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_SetGet;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_Status;
import de.vw.mib.bap.generated.eni.serializer.RemoteProcessCommands_Status;
import de.vw.mib.bap.generated.eni.serializer.RemoteProcessState_Status;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_SetGetArray;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.TriggerRemoteProcess_Result;
import de.vw.mib.bap.generated.eni.serializer.TriggerRemoteProcess_StartResult;
import de.vw.mib.bap.generated.eni.serializer.UserList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.UserList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.UserList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.VTANDataEncrypted_Status;
import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationENI
implements IFunctionRegistrationASG {
    private BAPFunctionGetAll getAll;
    private BAPFunctionPropertyASG bapConfig;
    private BAPFunctionPropertyASG functionList;
    private BAPFunctionPropertyASG fsgControl;
    private BAPFunctionPropertyASG fsgSetup;
    private BAPFunctionPropertyASG fsgOperationState;
    private BAPFunctionArrayASG destinationsList;
    private BAPFunctionPropertyASG destinationListAsGcapacity;
    private BAPFunctionMethodASG triggerRemoteProcess;
    private BAPFunctionPropertyASG remoteProcessCommands;
    private BAPFunctionPropertyASG remoteProcessState;
    private BAPFunctionArrayASG userList;
    private BAPFunctionArrayASG serviceList;
    private BAPFunctionPropertyASG activeMonitorings;
    private BAPFunctionPropertyASG privacySetup;
    private BAPFunctionArrayASG alertList;
    private BAPFunctionPropertyASG mobileDeviceKeyCount;
    private BAPFunctionPropertyASG vtanDataEncrypted;
    private BAPFunctionPropertyASG onlineUpdateStateDeprecated;
    private BAPFunctionPropertyASG connectionState;
    private BAPFunctionArrayASG challengeData;
    private BAPFunctionArrayASG foDList;
    private BAPFunctionPropertyASG foDState;
    private BAPFunctionPropertyASG activeTrip;
    private BAPFunctionPropertyASG olbSettings;
    private BAPFunctionArrayASG olbTripList;
    private BAPFunctionPropertyASG currentOnlineUpdateState;
    private BAPFunctionArrayASG onlineUpdateList;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(18);
    private final List allMethods = new ArrayList(1);
    private final List allArrays = new ArrayList(8);

    public FunctionRegistrationENI(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel = abstractBAPModuleASG.getLogChannel();
        this.initialize(abstractBAPModuleASG);
    }

    private void initialize(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationENI#initialize] start initialization");
        this.getAll = abstractBAPModuleASG.createBAPFunctionGetAll(1);
        this.initializeProperties(abstractBAPModuleASG);
        this.initializeMethods(abstractBAPModuleASG);
        this.initializeArrays(abstractBAPModuleASG);
        this.initialized = true;
        this.logChannel.log(-2137614336, "[FunctionRegistrationENI#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationENI#initializeProperties] initialize properties");
        this.bapConfig = abstractBAPModuleASG.createBAPFunctionPropertyASG(2);
        this.bapConfig.setResetSerializer(new BAP_Config_Reset());
        this.bapConfig.setStatusSerializer(new BAP_Config_Status());
        this.allProperties.add(this.bapConfig);
        this.functionList = abstractBAPModuleASG.createBAPFunctionPropertyASG(3);
        this.functionList.setStatusSerializer(new FunctionList_Status());
        this.allProperties.add(this.functionList);
        this.fsgControl = abstractBAPModuleASG.createBAPFunctionPropertyASG(13);
        this.fsgControl.setStatusSerializer(new FSG_Control_Status());
        this.allProperties.add(this.fsgControl);
        this.fsgSetup = abstractBAPModuleASG.createBAPFunctionPropertyASG(14);
        this.fsgSetup.setStatusSerializer(new FSG_Setup_Status());
        this.allProperties.add(this.fsgSetup);
        this.fsgOperationState = abstractBAPModuleASG.createBAPFunctionPropertyASG(15);
        this.fsgOperationState.setStatusSerializer(new FSG_OperationState_Status());
        this.allProperties.add(this.fsgOperationState);
        this.destinationListAsGcapacity = abstractBAPModuleASG.createBAPFunctionPropertyASG(17);
        this.destinationListAsGcapacity.setStatusSerializer(new DestinationList_ASGcapacity_Status());
        this.allProperties.add(this.destinationListAsGcapacity);
        this.remoteProcessCommands = abstractBAPModuleASG.createBAPFunctionPropertyASG(19);
        this.remoteProcessCommands.setStatusSerializer(new RemoteProcessCommands_Status());
        this.allProperties.add(this.remoteProcessCommands);
        this.remoteProcessState = abstractBAPModuleASG.createBAPFunctionPropertyASG(20);
        this.remoteProcessState.setStatusSerializer(new RemoteProcessState_Status());
        this.allProperties.add(this.remoteProcessState);
        this.activeMonitorings = abstractBAPModuleASG.createBAPFunctionPropertyASG(23);
        this.activeMonitorings.setStatusSerializer(new ActiveMonitorings_Status());
        this.allProperties.add(this.activeMonitorings);
        this.privacySetup = abstractBAPModuleASG.createBAPFunctionPropertyASG(24);
        this.privacySetup.setStatusSerializer(new PrivacySetup_Status());
        this.allProperties.add(this.privacySetup);
        this.mobileDeviceKeyCount = abstractBAPModuleASG.createBAPFunctionPropertyASG(26);
        this.mobileDeviceKeyCount.setStatusSerializer(new MobileDeviceKeyCount_Status());
        this.allProperties.add(this.mobileDeviceKeyCount);
        this.vtanDataEncrypted = abstractBAPModuleASG.createBAPFunctionPropertyASG(27);
        VTANDataEncrypted_Status vTANDataEncrypted_Status = new VTANDataEncrypted_Status();
        vTANDataEncrypted_Status.vtandataEncrypted.setRawContent();
        this.vtanDataEncrypted.setStatusSerializer(vTANDataEncrypted_Status);
        this.allProperties.add(this.vtanDataEncrypted);
        this.onlineUpdateStateDeprecated = abstractBAPModuleASG.createBAPFunctionPropertyASG(28);
        this.onlineUpdateStateDeprecated.setStatusSerializer(new OnlineUpdateState_Deprecated_Status());
        this.allProperties.add(this.onlineUpdateStateDeprecated);
        this.connectionState = abstractBAPModuleASG.createBAPFunctionPropertyASG(29);
        this.connectionState.setStatusSerializer(new ConnectionState_Status());
        this.allProperties.add(this.connectionState);
        this.foDState = abstractBAPModuleASG.createBAPFunctionPropertyASG(32);
        this.foDState.setStatusSerializer(new FoDState_Status());
        this.allProperties.add(this.foDState);
        this.activeTrip = abstractBAPModuleASG.createBAPFunctionPropertyASG(33);
        this.activeTrip.setStatusSerializer(new ActiveTrip_Status());
        this.allProperties.add(this.activeTrip);
        this.olbSettings = abstractBAPModuleASG.createBAPFunctionPropertyASG(34);
        this.olbSettings.setStatusSerializer(new OLBSettings_Status());
        this.allProperties.add(this.olbSettings);
        this.currentOnlineUpdateState = abstractBAPModuleASG.createBAPFunctionPropertyASG(36);
        this.currentOnlineUpdateState.setStatusSerializer(new CurrentOnlineUpdateState_Status());
        this.allProperties.add(this.currentOnlineUpdateState);
    }

    private void initializeMethods(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationENI#initializeMethods] initialize methods");
        this.triggerRemoteProcess = abstractBAPModuleASG.createBAPFunctionMethodASG(18);
        this.triggerRemoteProcess.setResultSerializer(new TriggerRemoteProcess_Result());
        this.allMethods.add(this.triggerRemoteProcess);
    }

    private void initializeArrays(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationENI#initializeArrays] initialize arrays");
        this.destinationsList = abstractBAPModuleASG.createBAPFunctionArrayASG(16, new RetryConfig(4, 1200));
        this.destinationsList.setChangedArraySerializer(new DestinationsList_ChangedArray());
        this.destinationsList.setStatusArraySerializer(new DestinationsList_StatusArray());
        this.allArrays.add(this.destinationsList);
        this.userList = abstractBAPModuleASG.createBAPFunctionArrayASG(21, new RetryConfig(4, 2500));
        this.userList.setChangedArraySerializer(new UserList_ChangedArray());
        this.userList.setStatusArraySerializer(new UserList_StatusArray());
        this.allArrays.add(this.userList);
        this.serviceList = abstractBAPModuleASG.createBAPFunctionArrayASG(22, new RetryConfig(4, 2500));
        this.serviceList.setChangedArraySerializer(new ServiceList_ChangedArray());
        this.serviceList.setStatusArraySerializer(new ServiceList_StatusArray());
        this.allArrays.add(this.serviceList);
        this.alertList = abstractBAPModuleASG.createBAPFunctionArrayASG(25);
        this.alertList.setChangedArraySerializer(new AlertList_ChangedArray());
        this.alertList.setStatusArraySerializer(new AlertList_StatusArray());
        this.allArrays.add(this.alertList);
        this.challengeData = abstractBAPModuleASG.createBAPFunctionArrayASG(30);
        this.challengeData.setChangedArraySerializer(new ChallengeData_ChangedArray());
        this.challengeData.setStatusArraySerializer(new ChallengeData_StatusArray());
        this.allArrays.add(this.challengeData);
        this.foDList = abstractBAPModuleASG.createBAPFunctionArrayASG(31);
        this.foDList.setChangedArraySerializer(new FoDList_ChangedArray());
        this.foDList.setStatusArraySerializer(new FoDList_StatusArray());
        this.allArrays.add(this.foDList);
        this.olbTripList = abstractBAPModuleASG.createBAPFunctionArrayASG(35);
        this.olbTripList.setChangedArraySerializer(new OLBTripList_ChangedArray());
        this.olbTripList.setStatusArraySerializer(new OLBTripList_StatusArray());
        this.allArrays.add(this.olbTripList);
        this.onlineUpdateList = abstractBAPModuleASG.createBAPFunctionArrayASG(37);
        this.onlineUpdateList.setChangedArraySerializer(new OnlineUpdateList_ChangedArray());
        this.onlineUpdateList.setStatusArraySerializer(new OnlineUpdateList_StatusArray());
        this.allArrays.add(this.onlineUpdateList);
    }

    @Override
    public BAPFunctionMethodASG getBAPFunctionMethodASG(int n) {
        try {
            return (BAPFunctionMethodASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationENI#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(55, n));
            return null;
        }
    }

    @Override
    public BAPFunctionPropertyASG getBAPFunctionPropertyASG(int n) {
        try {
            return (BAPFunctionPropertyASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationENI#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(55, n));
            return null;
        }
    }

    @Override
    public BAPFunctionArrayASG getBAPFunctionArrayASG(int n) {
        try {
            return (BAPFunctionArrayASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationENI#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(55, n));
            return null;
        }
    }

    @Override
    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationENI#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(55), (long)n);
        }
        switch (n) {
            case 1: {
                return this.getAll;
            }
            case 2: {
                return this.bapConfig;
            }
            case 3: {
                return this.functionList;
            }
            case 13: {
                return this.fsgControl;
            }
            case 14: {
                return this.fsgSetup;
            }
            case 15: {
                return this.fsgOperationState;
            }
            case 16: {
                return this.destinationsList;
            }
            case 17: {
                return this.destinationListAsGcapacity;
            }
            case 18: {
                return this.triggerRemoteProcess;
            }
            case 19: {
                return this.remoteProcessCommands;
            }
            case 20: {
                return this.remoteProcessState;
            }
            case 21: {
                return this.userList;
            }
            case 22: {
                return this.serviceList;
            }
            case 23: {
                return this.activeMonitorings;
            }
            case 24: {
                return this.privacySetup;
            }
            case 25: {
                return this.alertList;
            }
            case 26: {
                return this.mobileDeviceKeyCount;
            }
            case 27: {
                return this.vtanDataEncrypted;
            }
            case 28: {
                return this.onlineUpdateStateDeprecated;
            }
            case 29: {
                return this.connectionState;
            }
            case 30: {
                return this.challengeData;
            }
            case 31: {
                return this.foDList;
            }
            case 32: {
                return this.foDState;
            }
            case 33: {
                return this.activeTrip;
            }
            case 34: {
                return this.olbSettings;
            }
            case 35: {
                return this.olbTripList;
            }
            case 36: {
                return this.currentOnlineUpdateState;
            }
            case 37: {
                return this.onlineUpdateList;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#getBAPFunction] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }

    @Override
    public List getAllProperties() {
        return this.allProperties;
    }

    @Override
    public List getAllMethods() {
        return this.allMethods;
    }

    @Override
    public List getAllArrays() {
        return this.allArrays;
    }

    @Override
    public void resetBAPFunctions() {
        this.logChannel.log(-2137614336, "[FunctionRegistrationENI#resetBAPFunctions]");
        Iterator iterator = this.allArrays.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allProperties.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allMethods.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
    }

    @Override
    public StartResultMethod createStartResulForMethodASG(int n) {
        switch (n) {
            case 18: {
                return new TriggerRemoteProcess_StartResult();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#createStartResulForMethodASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }

    @Override
    public AbortResultMethod createAbortResulForMethodASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#createAbortResulForMethodASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }

    @Override
    public SetGetProperty createSetGetForPropertyASG(int n) {
        switch (n) {
            case 13: {
                return new FSG_Control_SetGet();
            }
            case 17: {
                return new DestinationList_ASGcapacity_SetGet();
            }
            case 24: {
                return new PrivacySetup_SetGet();
            }
            case 33: {
                return new ActiveTrip_SetGet();
            }
            case 34: {
                return new OLBSettings_SetGet();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#createSetGetForPropertyASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }

    @Override
    public AckProperty createAckForPropertyASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#createAckForPropertyASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }

    @Override
    public GetArray createGetArrayForArrayASG(int n) {
        switch (n) {
            case 16: {
                return new DestinationsList_GetArray();
            }
            case 21: {
                return new UserList_GetArray();
            }
            case 22: {
                return new ServiceList_GetArray();
            }
            case 25: {
                return new AlertList_GetArray();
            }
            case 30: {
                return new ChallengeData_GetArray();
            }
            case 31: {
                return new FoDList_GetArray();
            }
            case 35: {
                return new OLBTripList_GetArray();
            }
            case 37: {
                return new OnlineUpdateList_GetArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#createGetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }

    @Override
    public SetGetArray createSetGetArrayForArrayASG(int n) {
        switch (n) {
            case 16: {
                return new DestinationsList_SetGetArray();
            }
            case 22: {
                return new ServiceList_SetGetArray();
            }
            case 35: {
                return new OLBTripList_SetGetArray();
            }
            case 37: {
                return new OnlineUpdateList_SetGetArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#createSetGetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }

    @Override
    public SetGetArray createSetArrayForArrayASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationENI#createSetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(55), (Object)FunctionIDs.getDescription(55, n));
        return null;
    }
}

