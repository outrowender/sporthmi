/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.ecall;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandlerASG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.ecall.serializer.AcceptCall_Result;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_ChangedArray;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_StatusArray;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_Status;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_StatusAck;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.ecall.serializer.CallState_Status;
import de.vw.mib.bap.generated.ecall.serializer.CallState_StatusAck;
import de.vw.mib.bap.generated.ecall.serializer.DialNumber_Result;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_ChangedArray;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_StatusArray;
import de.vw.mib.bap.generated.ecall.serializer.DisconnectReason_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.ecall.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.ecall.serializer.FunctionalRestrictions_Status;
import de.vw.mib.bap.generated.ecall.serializer.HangupCall_Result;
import de.vw.mib.bap.generated.ecall.serializer.NetworkProvider_Status;
import de.vw.mib.bap.generated.ecall.serializer.RegisterState_Status;
import de.vw.mib.bap.generated.ecall.serializer.ServiceControl_Result;
import de.vw.mib.bap.generated.ecall.serializer.ServiceRequest_Status;
import de.vw.mib.bap.generated.ecall.serializer.ServiceState_Status;
import de.vw.mib.bap.generated.ecall.serializer.SignalQuality_Status;
import de.vw.mib.bap.generated.ecall.serializer.SupportedServices_Status;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractBAPIndicationHandlerEcall
extends AbstractBAPIndicationHandlerASG {
    public AbstractBAPIndicationHandlerEcall(AbstractBAPModuleASG abstractBAPModuleASG, LogChannel logChannel) {
        super(abstractBAPModuleASG, logChannel);
    }

    @Override
    public void processIndicationResult(BAPFunctionMethodASG bAPFunctionMethodASG, ResultMethod resultMethod) {
        switch (bAPFunctionMethodASG.getFctID()) {
            case 18: {
                this.processHangupCallResult(bAPFunctionMethodASG, (HangupCall_Result)resultMethod);
                break;
            }
            case 19: {
                this.processAcceptCallResult(bAPFunctionMethodASG, (AcceptCall_Result)resultMethod);
                break;
            }
            case 25: {
                this.processServiceControlResult(bAPFunctionMethodASG, (ServiceControl_Result)resultMethod);
                break;
            }
            case 30: {
                this.processDialNumberResult(bAPFunctionMethodASG, (DialNumber_Result)resultMethod);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerEcall#processIndicationResult not implemented for fctID=%1", (Object)bAPFunctionMethodASG.getFctIDDescription());
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
            case 16: {
                this.processAudioStateStatus(bAPFunctionPropertyASG, (AudioState_Status)statusProperty);
                break;
            }
            case 17: {
                this.processCallStateStatus(bAPFunctionPropertyASG, (CallState_Status)statusProperty);
                break;
            }
            case 20: {
                this.processDisconnectReasonStatus(bAPFunctionPropertyASG, (DisconnectReason_Status)statusProperty);
                break;
            }
            case 21: {
                this.processRegisterStateStatus(bAPFunctionPropertyASG, (RegisterState_Status)statusProperty);
                break;
            }
            case 22: {
                this.processNetworkProviderStatus(bAPFunctionPropertyASG, (NetworkProvider_Status)statusProperty);
                break;
            }
            case 23: {
                this.processSignalQualityStatus(bAPFunctionPropertyASG, (SignalQuality_Status)statusProperty);
                break;
            }
            case 24: {
                this.processServiceRequestStatus(bAPFunctionPropertyASG, (ServiceRequest_Status)statusProperty);
                break;
            }
            case 26: {
                this.processServiceStateStatus(bAPFunctionPropertyASG, (ServiceState_Status)statusProperty);
                break;
            }
            case 27: {
                this.processSupportedServicesStatus(bAPFunctionPropertyASG, (SupportedServices_Status)statusProperty);
                break;
            }
            case 28: {
                this.processFunctionalRestrictionsStatus(bAPFunctionPropertyASG, (FunctionalRestrictions_Status)statusProperty);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerEcall#processIndicationStatus not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, StatusAckProperty statusAckProperty) {
        switch (bAPFunctionPropertyASG.getFctID()) {
            case 16: {
                this.processAudioStateStatusAck(bAPFunctionPropertyASG, (AudioState_StatusAck)statusAckProperty);
                break;
            }
            case 17: {
                this.processCallStateStatusAck(bAPFunctionPropertyASG, (CallState_StatusAck)statusAckProperty);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerEcall#processIndicationStatusAck not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChangedArray changedArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            case 29: {
                this.processAllowedEmergencyNumbersChangedArray(bAPFunctionArrayASG, (AllowedEmergencyNumbers_ChangedArray)changedArray);
                break;
            }
            case 31: {
                this.processDisasterWarningChangedArray(bAPFunctionArrayASG, (DisasterWarning_ChangedArray)changedArray);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerEcall#processIndicationChangedArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            case 29: {
                this.processAllowedEmergencyNumbersStatusArray(bAPFunctionArrayASG, (AllowedEmergencyNumbers_StatusArray)statusArray);
                break;
            }
            case 31: {
                this.processDisasterWarningStatusArray(bAPFunctionArrayASG, (DisasterWarning_StatusArray)statusArray);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerEcall#processIndicationStatusArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
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

    protected abstract void processAudioStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, AudioState_Status audioState_Status) {
    }

    protected abstract void processAudioStateStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, AudioState_StatusAck audioState_StatusAck) {
    }

    protected abstract void processCallStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, CallState_Status callState_Status) {
    }

    protected abstract void processCallStateStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, CallState_StatusAck callState_StatusAck) {
    }

    protected abstract void processHangupCallResult(BAPFunctionMethodASG bAPFunctionMethodASG, HangupCall_Result hangupCall_Result) {
    }

    protected abstract void processAcceptCallResult(BAPFunctionMethodASG bAPFunctionMethodASG, AcceptCall_Result acceptCall_Result) {
    }

    protected abstract void processDisconnectReasonStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, DisconnectReason_Status disconnectReason_Status) {
    }

    protected abstract void processRegisterStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RegisterState_Status registerState_Status) {
    }

    protected abstract void processNetworkProviderStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, NetworkProvider_Status networkProvider_Status) {
    }

    protected abstract void processSignalQualityStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, SignalQuality_Status signalQuality_Status) {
    }

    protected abstract void processServiceRequestStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ServiceRequest_Status serviceRequest_Status) {
    }

    protected abstract void processServiceControlResult(BAPFunctionMethodASG bAPFunctionMethodASG, ServiceControl_Result serviceControl_Result) {
    }

    protected abstract void processServiceStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ServiceState_Status serviceState_Status) {
    }

    protected abstract void processSupportedServicesStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, SupportedServices_Status supportedServices_Status) {
    }

    protected abstract void processFunctionalRestrictionsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FunctionalRestrictions_Status functionalRestrictions_Status) {
    }

    protected abstract void processAllowedEmergencyNumbersChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, AllowedEmergencyNumbers_ChangedArray allowedEmergencyNumbers_ChangedArray) {
    }

    protected abstract void processAllowedEmergencyNumbersStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, AllowedEmergencyNumbers_StatusArray allowedEmergencyNumbers_StatusArray) {
    }

    protected abstract void processDialNumberResult(BAPFunctionMethodASG bAPFunctionMethodASG, DialNumber_Result dialNumber_Result) {
    }

    protected abstract void processDisasterWarningChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, DisasterWarning_ChangedArray disasterWarning_ChangedArray) {
    }

    protected abstract void processDisasterWarningStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, DisasterWarning_StatusArray disasterWarning_StatusArray) {
    }
}

