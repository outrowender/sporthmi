/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.remoteservices;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandlerASG;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.remoteservices.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyActiveKey_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyAuth_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyChallenge_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyCommand_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeyControl_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.StartEngineAuthentication_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.StartEngineChallenge_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.StartEngineSignature_Status;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANAuthData_Result;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANDecryption_Result;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractBAPIndicationHandlerRemoteServices
extends AbstractBAPIndicationHandlerASG {
    public AbstractBAPIndicationHandlerRemoteServices(AbstractBAPModuleASG abstractBAPModuleASG, LogChannel logChannel) {
        super(abstractBAPModuleASG, logChannel);
    }

    @Override
    public void processIndicationResult(BAPFunctionMethodASG bAPFunctionMethodASG, ResultMethod resultMethod) {
        switch (bAPFunctionMethodASG.getFctID()) {
            case 16: {
                this.processStartEngineChallengeResult(bAPFunctionMethodASG, (StartEngineChallenge_Result)resultMethod);
                break;
            }
            case 19: {
                this.processMobDevKeyChallengeResult(bAPFunctionMethodASG, (MobDevKeyChallenge_Result)resultMethod);
                break;
            }
            case 24: {
                this.processVtanAuthDataResult(bAPFunctionMethodASG, (VTANAuthData_Result)resultMethod);
                break;
            }
            case 25: {
                this.processVtanDecryptionResult(bAPFunctionMethodASG, (VTANDecryption_Result)resultMethod);
                break;
            }
            case 26: {
                this.processMobDevKeyControlResult(bAPFunctionMethodASG, (MobDevKeyControl_Result)resultMethod);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationResult not implemented for fctID=%1", (Object)bAPFunctionMethodASG.getFctIDDescription());
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
                this.processStartEngineAuthenticationStatus(bAPFunctionPropertyASG, (StartEngineAuthentication_Status)statusProperty);
                break;
            }
            case 18: {
                this.processStartEngineSignatureStatus(bAPFunctionPropertyASG, (StartEngineSignature_Status)statusProperty);
                break;
            }
            case 20: {
                this.processMobDevKeyAuthStatus(bAPFunctionPropertyASG, (MobDevKeyAuth_Status)statusProperty);
                break;
            }
            case 21: {
                this.processMobDevKeyCommandStatus(bAPFunctionPropertyASG, (MobDevKeyCommand_Status)statusProperty);
                break;
            }
            case 22: {
                this.processMobDevKeyActiveKeyStatus(bAPFunctionPropertyASG, (MobDevKeyActiveKey_Status)statusProperty);
                break;
            }
            case 23: {
                this.processMobDevKeySetupStatus(bAPFunctionPropertyASG, (MobDevKeySetup_Status)statusProperty);
                break;
            }
            default: {
                this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationStatus not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
            }
        }
    }

    @Override
    public void processIndicationStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, StatusAckProperty statusAckProperty) {
        switch (bAPFunctionPropertyASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationStatusAck not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
    }

    @Override
    public void processIndicationChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChangedArray changedArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationChangedArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
    }

    @Override
    public void processIndicationStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationStatusArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
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

    protected abstract void processStartEngineChallengeResult(BAPFunctionMethodASG bAPFunctionMethodASG, StartEngineChallenge_Result startEngineChallenge_Result) {
    }

    protected abstract void processStartEngineAuthenticationStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, StartEngineAuthentication_Status startEngineAuthentication_Status) {
    }

    protected abstract void processStartEngineSignatureStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, StartEngineSignature_Status startEngineSignature_Status) {
    }

    protected abstract void processMobDevKeyChallengeResult(BAPFunctionMethodASG bAPFunctionMethodASG, MobDevKeyChallenge_Result mobDevKeyChallenge_Result) {
    }

    protected abstract void processMobDevKeyAuthStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeyAuth_Status mobDevKeyAuth_Status) {
    }

    protected abstract void processMobDevKeyCommandStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeyCommand_Status mobDevKeyCommand_Status) {
    }

    protected abstract void processMobDevKeyActiveKeyStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeyActiveKey_Status mobDevKeyActiveKey_Status) {
    }

    protected abstract void processMobDevKeySetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeySetup_Status mobDevKeySetup_Status) {
    }

    protected abstract void processVtanAuthDataResult(BAPFunctionMethodASG bAPFunctionMethodASG, VTANAuthData_Result vTANAuthData_Result) {
    }

    protected abstract void processVtanDecryptionResult(BAPFunctionMethodASG bAPFunctionMethodASG, VTANDecryption_Result vTANDecryption_Result) {
    }

    protected abstract void processMobDevKeyControlResult(BAPFunctionMethodASG bAPFunctionMethodASG, MobDevKeyControl_Result mobDevKeyControl_Result) {
    }
}

