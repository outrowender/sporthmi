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

    protected abstract void processBapConfigStatus(BAPFunctionPropertyASG var1, BAP_Config_Status var2);

    protected abstract void processFunctionListStatus(BAPFunctionPropertyASG var1, FunctionList_Status var2);

    protected abstract void processFsgControlStatus(BAPFunctionPropertyASG var1, FSG_Control_Status var2);

    protected abstract void processFsgSetupStatus(BAPFunctionPropertyASG var1, FSG_Setup_Status var2);

    protected abstract void processFsgOperationStateStatus(BAPFunctionPropertyASG var1, FSG_OperationState_Status var2);

    protected abstract void processAudioStateStatus(BAPFunctionPropertyASG var1, AudioState_Status var2);

    protected abstract void processAudioStateStatusAck(BAPFunctionPropertyASG var1, AudioState_StatusAck var2);

    protected abstract void processCallStateStatus(BAPFunctionPropertyASG var1, CallState_Status var2);

    protected abstract void processCallStateStatusAck(BAPFunctionPropertyASG var1, CallState_StatusAck var2);

    protected abstract void processHangupCallResult(BAPFunctionMethodASG var1, HangupCall_Result var2);

    protected abstract void processAcceptCallResult(BAPFunctionMethodASG var1, AcceptCall_Result var2);

    protected abstract void processDisconnectReasonStatus(BAPFunctionPropertyASG var1, DisconnectReason_Status var2);

    protected abstract void processRegisterStateStatus(BAPFunctionPropertyASG var1, RegisterState_Status var2);

    protected abstract void processNetworkProviderStatus(BAPFunctionPropertyASG var1, NetworkProvider_Status var2);

    protected abstract void processSignalQualityStatus(BAPFunctionPropertyASG var1, SignalQuality_Status var2);

    protected abstract void processServiceRequestStatus(BAPFunctionPropertyASG var1, ServiceRequest_Status var2);

    protected abstract void processServiceControlResult(BAPFunctionMethodASG var1, ServiceControl_Result var2);

    protected abstract void processServiceStateStatus(BAPFunctionPropertyASG var1, ServiceState_Status var2);

    protected abstract void processSupportedServicesStatus(BAPFunctionPropertyASG var1, SupportedServices_Status var2);

    protected abstract void processFunctionalRestrictionsStatus(BAPFunctionPropertyASG var1, FunctionalRestrictions_Status var2);

    protected abstract void processAllowedEmergencyNumbersChangedArray(BAPFunctionArrayASG var1, AllowedEmergencyNumbers_ChangedArray var2);

    protected abstract void processAllowedEmergencyNumbersStatusArray(BAPFunctionArrayASG var1, AllowedEmergencyNumbers_StatusArray var2);

    protected abstract void processDialNumberResult(BAPFunctionMethodASG var1, DialNumber_Result var2);

    protected abstract void processDisasterWarningChangedArray(BAPFunctionArrayASG var1, DisasterWarning_ChangedArray var2);

    protected abstract void processDisasterWarningStatusArray(BAPFunctionArrayASG var1, DisasterWarning_StatusArray var2);
}

