/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.remoteservices;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.IFunctionRegistrationASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.remoteservices.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.remoteservices.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_Control_SetGet;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyActiveKey_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyAuth_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyChallenge_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyChallenge_StartResult;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyCommand_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyControl_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyControl_StartResult;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_SetGet;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.StartEngineAuthentication_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.StartEngineChallenge_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.StartEngineChallenge_StartResult;
import de.vw.mib.bap.generated.remoteservices.serializer.StartEngineSignature_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANAuthData_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANAuthData_StartResult;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANDecryption_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANDecryption_StartResult;
import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationRemoteServices
implements IFunctionRegistrationASG {
    private BAPFunctionGetAll getAll;
    private BAPFunctionPropertyASG bapConfig;
    private BAPFunctionPropertyASG functionList;
    private BAPFunctionPropertyASG fsgControl;
    private BAPFunctionPropertyASG fsgSetup;
    private BAPFunctionPropertyASG fsgOperationState;
    private BAPFunctionMethodASG startEngineChallenge;
    private BAPFunctionPropertyASG startEngineAuthentication;
    private BAPFunctionPropertyASG startEngineSignature;
    private BAPFunctionMethodASG mobDevKeyChallenge;
    private BAPFunctionPropertyASG mobDevKeyAuth;
    private BAPFunctionPropertyASG mobDevKeyCommand;
    private BAPFunctionPropertyASG mobDevKeyActiveKey;
    private BAPFunctionPropertyASG mobDevKeySetup;
    private BAPFunctionMethodASG vtanAuthData;
    private BAPFunctionMethodASG vtanDecryption;
    private BAPFunctionMethodASG mobDevKeyControl;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(11);
    private final List allMethods = new ArrayList(5);
    private final List allArrays = new ArrayList();

    public FunctionRegistrationRemoteServices(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel = abstractBAPModuleASG.getLogChannel();
        this.initialize(abstractBAPModuleASG);
    }

    private void initialize(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(10000000, "[FunctionRegistrationRemoteServices#initialize] start initialization");
        this.getAll = abstractBAPModuleASG.createBAPFunctionGetAll(1);
        this.initializeProperties(abstractBAPModuleASG);
        this.initializeMethods(abstractBAPModuleASG);
        this.initialized = true;
        this.logChannel.log(10000000, "[FunctionRegistrationRemoteServices#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(10000000, "[FunctionRegistrationRemoteServices#initializeProperties] initialize properties");
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
        this.startEngineAuthentication = abstractBAPModuleASG.createBAPFunctionPropertyASG(17);
        this.startEngineAuthentication.setStatusSerializer(new StartEngineAuthentication_Status());
        this.allProperties.add(this.startEngineAuthentication);
        this.startEngineSignature = abstractBAPModuleASG.createBAPFunctionPropertyASG(18);
        this.startEngineSignature.setStatusSerializer(new StartEngineSignature_Status());
        this.allProperties.add(this.startEngineSignature);
        this.mobDevKeyAuth = abstractBAPModuleASG.createBAPFunctionPropertyASG(20);
        this.mobDevKeyAuth.setStatusSerializer(new MobDevKeyAuth_Status());
        this.allProperties.add(this.mobDevKeyAuth);
        this.mobDevKeyCommand = abstractBAPModuleASG.createBAPFunctionPropertyASG(21);
        this.mobDevKeyCommand.setStatusSerializer(new MobDevKeyCommand_Status());
        this.allProperties.add(this.mobDevKeyCommand);
        this.mobDevKeyActiveKey = abstractBAPModuleASG.createBAPFunctionPropertyASG(22);
        this.mobDevKeyActiveKey.setStatusSerializer(new MobDevKeyActiveKey_Status());
        this.allProperties.add(this.mobDevKeyActiveKey);
        this.mobDevKeySetup = abstractBAPModuleASG.createBAPFunctionPropertyASG(23);
        this.mobDevKeySetup.setStatusSerializer(new MobDevKeySetup_Status());
        this.allProperties.add(this.mobDevKeySetup);
    }

    private void initializeMethods(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(10000000, "[FunctionRegistrationRemoteServices#initializeMethods] initialize methods");
        this.startEngineChallenge = abstractBAPModuleASG.createBAPFunctionMethodASG(16);
        this.startEngineChallenge.setResultSerializer(new StartEngineChallenge_Result());
        this.allMethods.add(this.startEngineChallenge);
        this.mobDevKeyChallenge = abstractBAPModuleASG.createBAPFunctionMethodASG(19);
        this.mobDevKeyChallenge.setResultSerializer(new MobDevKeyChallenge_Result());
        this.allMethods.add(this.mobDevKeyChallenge);
        this.vtanAuthData = abstractBAPModuleASG.createBAPFunctionMethodASG(24);
        VTANAuthData_Result vTANAuthData_Result = new VTANAuthData_Result();
        vTANAuthData_Result.vtanauthenticationData.setRawContent();
        this.vtanAuthData.setResultSerializer(vTANAuthData_Result);
        this.allMethods.add(this.vtanAuthData);
        this.vtanDecryption = abstractBAPModuleASG.createBAPFunctionMethodASG(25);
        this.vtanDecryption.setResultSerializer(new VTANDecryption_Result());
        this.allMethods.add(this.vtanDecryption);
        this.mobDevKeyControl = abstractBAPModuleASG.createBAPFunctionMethodASG(26);
        this.mobDevKeyControl.setResultSerializer(new MobDevKeyControl_Result());
        this.allMethods.add(this.mobDevKeyControl);
    }

    public BAPFunctionMethodASG getBAPFunctionMethodASG(int n) {
        try {
            return (BAPFunctionMethodASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(78, n));
            return null;
        }
    }

    public BAPFunctionPropertyASG getBAPFunctionPropertyASG(int n) {
        try {
            return (BAPFunctionPropertyASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(78, n));
            return null;
        }
    }

    public BAPFunctionArrayASG getBAPFunctionArrayASG(int n) {
        try {
            return (BAPFunctionArrayASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(78, n));
            return null;
        }
    }

    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(78), (long)n);
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
                return this.startEngineChallenge;
            }
            case 17: {
                return this.startEngineAuthentication;
            }
            case 18: {
                return this.startEngineSignature;
            }
            case 19: {
                return this.mobDevKeyChallenge;
            }
            case 20: {
                return this.mobDevKeyAuth;
            }
            case 21: {
                return this.mobDevKeyCommand;
            }
            case 22: {
                return this.mobDevKeyActiveKey;
            }
            case 23: {
                return this.mobDevKeySetup;
            }
            case 24: {
                return this.vtanAuthData;
            }
            case 25: {
                return this.vtanDecryption;
            }
            case 26: {
                return this.mobDevKeyControl;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#getBAPFunction] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }

    public List getAllProperties() {
        return this.allProperties;
    }

    public List getAllMethods() {
        return this.allMethods;
    }

    public List getAllArrays() {
        return this.allArrays;
    }

    public void resetBAPFunctions() {
        this.logChannel.log(10000000, "[FunctionRegistrationRemoteServices#resetBAPFunctions]");
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

    public StartResultMethod createStartResulForMethodASG(int n) {
        switch (n) {
            case 16: {
                return new StartEngineChallenge_StartResult();
            }
            case 19: {
                return new MobDevKeyChallenge_StartResult();
            }
            case 24: {
                return new VTANAuthData_StartResult();
            }
            case 25: {
                return new VTANDecryption_StartResult();
            }
            case 26: {
                return new MobDevKeyControl_StartResult();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#createStartResulForMethodASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }

    public AbortResultMethod createAbortResulForMethodASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#createAbortResulForMethodASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }

    public SetGetProperty createSetGetForPropertyASG(int n) {
        switch (n) {
            case 13: {
                return new FSG_Control_SetGet();
            }
            case 23: {
                return new MobDevKeySetup_SetGet();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#createSetGetForPropertyASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }

    public AckProperty createAckForPropertyASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#createAckForPropertyASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }

    public GetArray createGetArrayForArrayASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#createGetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }

    public SetGetArray createSetGetArrayForArrayASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#createSetGetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }

    public SetGetArray createSetArrayForArrayASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationRemoteServices#createSetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(78), (Object)FunctionIDs.getDescription(78, n));
        return null;
    }
}

