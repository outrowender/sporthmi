/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.ecall;

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
import de.vw.mib.bap.generated.ecall.serializer.AcceptCall_Result;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_ChangedArray;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_GetArray;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_StatusArray;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_Ack;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_SetGet;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_Status;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_StatusAck;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.ecall.serializer.CallState_Ack;
import de.vw.mib.bap.generated.ecall.serializer.CallState_Status;
import de.vw.mib.bap.generated.ecall.serializer.CallState_StatusAck;
import de.vw.mib.bap.generated.ecall.serializer.DialNumber_Result;
import de.vw.mib.bap.generated.ecall.serializer.DialNumber_StartResult;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_ChangedArray;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_GetArray;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_StatusArray;
import de.vw.mib.bap.generated.ecall.serializer.DisconnectReason_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Control_SetGet;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.ecall.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.ecall.serializer.FunctionalRestrictions_Status;
import de.vw.mib.bap.generated.ecall.serializer.HangupCall_Result;
import de.vw.mib.bap.generated.ecall.serializer.HangupCall_StartResult;
import de.vw.mib.bap.generated.ecall.serializer.NetworkProvider_Status;
import de.vw.mib.bap.generated.ecall.serializer.RegisterState_Status;
import de.vw.mib.bap.generated.ecall.serializer.ServiceControl_Result;
import de.vw.mib.bap.generated.ecall.serializer.ServiceControl_StartResult;
import de.vw.mib.bap.generated.ecall.serializer.ServiceRequest_Status;
import de.vw.mib.bap.generated.ecall.serializer.ServiceState_Status;
import de.vw.mib.bap.generated.ecall.serializer.SignalQuality_Status;
import de.vw.mib.bap.generated.ecall.serializer.SupportedServices_Status;
import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationEcall
implements IFunctionRegistrationASG {
    private BAPFunctionGetAll getAll;
    private BAPFunctionPropertyASG bapConfig;
    private BAPFunctionPropertyASG functionList;
    private BAPFunctionPropertyASG fsgControl;
    private BAPFunctionPropertyASG fsgSetup;
    private BAPFunctionPropertyASG fsgOperationState;
    private BAPFunctionPropertyASG audioState;
    private BAPFunctionPropertyASG callState;
    private BAPFunctionMethodASG hangupCall;
    private BAPFunctionMethodASG acceptCall;
    private BAPFunctionPropertyASG disconnectReason;
    private BAPFunctionPropertyASG registerState;
    private BAPFunctionPropertyASG networkProvider;
    private BAPFunctionPropertyASG signalQuality;
    private BAPFunctionPropertyASG serviceRequest;
    private BAPFunctionMethodASG serviceControl;
    private BAPFunctionPropertyASG serviceState;
    private BAPFunctionPropertyASG supportedServices;
    private BAPFunctionPropertyASG functionalRestrictions;
    private BAPFunctionArrayASG allowedEmergencyNumbers;
    private BAPFunctionMethodASG dialNumber;
    private BAPFunctionArrayASG disasterWarning;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(15);
    private final List allMethods = new ArrayList(4);
    private final List allArrays = new ArrayList(2);

    public FunctionRegistrationEcall(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel = abstractBAPModuleASG.getLogChannel();
        this.initialize(abstractBAPModuleASG);
    }

    private void initialize(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationEcall#initialize] start initialization");
        this.getAll = abstractBAPModuleASG.createBAPFunctionGetAll(1);
        this.initializeProperties(abstractBAPModuleASG);
        this.initializeMethods(abstractBAPModuleASG);
        this.initializeArrays(abstractBAPModuleASG);
        this.initialized = true;
        this.logChannel.log(-2137614336, "[FunctionRegistrationEcall#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationEcall#initializeProperties] initialize properties");
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
        this.audioState = abstractBAPModuleASG.createBAPFunctionPropertyASG(16);
        this.audioState.setStatusSerializer(new AudioState_Status());
        this.audioState.setStatusAckSerializer(new AudioState_StatusAck());
        this.allProperties.add(this.audioState);
        this.callState = abstractBAPModuleASG.createBAPFunctionPropertyASG(17);
        this.callState.setStatusSerializer(new CallState_Status());
        this.callState.setStatusAckSerializer(new CallState_StatusAck());
        this.allProperties.add(this.callState);
        this.disconnectReason = abstractBAPModuleASG.createBAPFunctionPropertyASG(20);
        this.disconnectReason.setStatusSerializer(new DisconnectReason_Status());
        this.allProperties.add(this.disconnectReason);
        this.registerState = abstractBAPModuleASG.createBAPFunctionPropertyASG(21);
        this.registerState.setStatusSerializer(new RegisterState_Status());
        this.allProperties.add(this.registerState);
        this.networkProvider = abstractBAPModuleASG.createBAPFunctionPropertyASG(22);
        this.networkProvider.setStatusSerializer(new NetworkProvider_Status());
        this.allProperties.add(this.networkProvider);
        this.signalQuality = abstractBAPModuleASG.createBAPFunctionPropertyASG(23);
        this.signalQuality.setStatusSerializer(new SignalQuality_Status());
        this.allProperties.add(this.signalQuality);
        this.serviceRequest = abstractBAPModuleASG.createBAPFunctionPropertyASG(24);
        this.serviceRequest.setStatusSerializer(new ServiceRequest_Status());
        this.allProperties.add(this.serviceRequest);
        this.serviceState = abstractBAPModuleASG.createBAPFunctionPropertyASG(26);
        this.serviceState.setStatusSerializer(new ServiceState_Status());
        this.allProperties.add(this.serviceState);
        this.supportedServices = abstractBAPModuleASG.createBAPFunctionPropertyASG(27);
        this.supportedServices.setStatusSerializer(new SupportedServices_Status());
        this.allProperties.add(this.supportedServices);
        this.functionalRestrictions = abstractBAPModuleASG.createBAPFunctionPropertyASG(28);
        this.functionalRestrictions.setStatusSerializer(new FunctionalRestrictions_Status());
        this.allProperties.add(this.functionalRestrictions);
    }

    private void initializeMethods(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationEcall#initializeMethods] initialize methods");
        this.hangupCall = abstractBAPModuleASG.createBAPFunctionMethodASG(18);
        this.hangupCall.setResultSerializer(new HangupCall_Result());
        this.allMethods.add(this.hangupCall);
        this.acceptCall = abstractBAPModuleASG.createBAPFunctionMethodASG(19);
        this.acceptCall.setResultSerializer(new AcceptCall_Result());
        this.allMethods.add(this.acceptCall);
        this.serviceControl = abstractBAPModuleASG.createBAPFunctionMethodASG(25);
        this.serviceControl.setResultSerializer(new ServiceControl_Result());
        this.allMethods.add(this.serviceControl);
        this.dialNumber = abstractBAPModuleASG.createBAPFunctionMethodASG(30);
        this.dialNumber.setResultSerializer(new DialNumber_Result());
        this.allMethods.add(this.dialNumber);
    }

    private void initializeArrays(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationEcall#initializeArrays] initialize arrays");
        this.allowedEmergencyNumbers = abstractBAPModuleASG.createBAPFunctionArrayASG(29, new RetryConfig(4, 2500));
        this.allowedEmergencyNumbers.setChangedArraySerializer(new AllowedEmergencyNumbers_ChangedArray());
        this.allowedEmergencyNumbers.setStatusArraySerializer(new AllowedEmergencyNumbers_StatusArray());
        this.allArrays.add(this.allowedEmergencyNumbers);
        this.disasterWarning = abstractBAPModuleASG.createBAPFunctionArrayASG(31, new RetryConfig(4, 3000));
        this.disasterWarning.setChangedArraySerializer(new DisasterWarning_ChangedArray());
        this.disasterWarning.setStatusArraySerializer(new DisasterWarning_StatusArray());
        this.allArrays.add(this.disasterWarning);
    }

    @Override
    public BAPFunctionMethodASG getBAPFunctionMethodASG(int n) {
        try {
            return (BAPFunctionMethodASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationEcall#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(51, n));
            return null;
        }
    }

    @Override
    public BAPFunctionPropertyASG getBAPFunctionPropertyASG(int n) {
        try {
            return (BAPFunctionPropertyASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationEcall#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(51, n));
            return null;
        }
    }

    @Override
    public BAPFunctionArrayASG getBAPFunctionArrayASG(int n) {
        try {
            return (BAPFunctionArrayASG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationEcall#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(51, n));
            return null;
        }
    }

    @Override
    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationEcall#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(51), (long)n);
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
                return this.audioState;
            }
            case 17: {
                return this.callState;
            }
            case 18: {
                return this.hangupCall;
            }
            case 19: {
                return this.acceptCall;
            }
            case 20: {
                return this.disconnectReason;
            }
            case 21: {
                return this.registerState;
            }
            case 22: {
                return this.networkProvider;
            }
            case 23: {
                return this.signalQuality;
            }
            case 24: {
                return this.serviceRequest;
            }
            case 25: {
                return this.serviceControl;
            }
            case 26: {
                return this.serviceState;
            }
            case 27: {
                return this.supportedServices;
            }
            case 28: {
                return this.functionalRestrictions;
            }
            case 29: {
                return this.allowedEmergencyNumbers;
            }
            case 30: {
                return this.dialNumber;
            }
            case 31: {
                return this.disasterWarning;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#getBAPFunction] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
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
        this.logChannel.log(-2137614336, "[FunctionRegistrationEcall#resetBAPFunctions]");
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
                return new HangupCall_StartResult();
            }
            case 25: {
                return new ServiceControl_StartResult();
            }
            case 30: {
                return new DialNumber_StartResult();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#createStartResulForMethodASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
        return null;
    }

    @Override
    public AbortResultMethod createAbortResulForMethodASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#createAbortResulForMethodASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
        return null;
    }

    @Override
    public SetGetProperty createSetGetForPropertyASG(int n) {
        switch (n) {
            case 13: {
                return new FSG_Control_SetGet();
            }
            case 16: {
                return new AudioState_SetGet();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#createSetGetForPropertyASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
        return null;
    }

    @Override
    public AckProperty createAckForPropertyASG(int n) {
        switch (n) {
            case 16: {
                return new AudioState_Ack();
            }
            case 17: {
                return new CallState_Ack();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#createAckForPropertyASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
        return null;
    }

    @Override
    public GetArray createGetArrayForArrayASG(int n) {
        switch (n) {
            case 29: {
                return new AllowedEmergencyNumbers_GetArray();
            }
            case 31: {
                return new DisasterWarning_GetArray();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#createGetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
        return null;
    }

    @Override
    public SetGetArray createSetGetArrayForArrayASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#createSetGetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
        return null;
    }

    @Override
    public SetGetArray createSetArrayForArrayASG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationEcall#createSetArrayForArrayASG] function not supported by ASG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(51), (Object)FunctionIDs.getDescription(51, n));
        return null;
    }
}

