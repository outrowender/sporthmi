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

    public void processIndicationStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, StatusAckProperty statusAckProperty) {
        switch (bAPFunctionPropertyASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationStatusAck not implemented for fctID=%1", (Object)bAPFunctionPropertyASG.getFctIDDescription());
    }

    public void processIndicationChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, ChangedArray changedArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationChangedArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
    }

    public void processIndicationStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        switch (bAPFunctionArrayASG.getFctID()) {
            default: 
        }
        this.logChannel.log(10000, "AbstractBAPIndicationHandlerRemoteServices#processIndicationStatusArray not implemented for fctID=%1", (Object)bAPFunctionArrayASG.getFctIDDescription());
    }

    protected abstract void processBapConfigStatus(BAPFunctionPropertyASG var1, BAP_Config_Status var2);

    protected abstract void processFunctionListStatus(BAPFunctionPropertyASG var1, FunctionList_Status var2);

    protected abstract void processFsgControlStatus(BAPFunctionPropertyASG var1, FSG_Control_Status var2);

    protected abstract void processFsgSetupStatus(BAPFunctionPropertyASG var1, FSG_Setup_Status var2);

    protected abstract void processFsgOperationStateStatus(BAPFunctionPropertyASG var1, FSG_OperationState_Status var2);

    protected abstract void processStartEngineChallengeResult(BAPFunctionMethodASG var1, StartEngineChallenge_Result var2);

    protected abstract void processStartEngineAuthenticationStatus(BAPFunctionPropertyASG var1, StartEngineAuthentication_Status var2);

    protected abstract void processStartEngineSignatureStatus(BAPFunctionPropertyASG var1, StartEngineSignature_Status var2);

    protected abstract void processMobDevKeyChallengeResult(BAPFunctionMethodASG var1, MobDevKeyChallenge_Result var2);

    protected abstract void processMobDevKeyAuthStatus(BAPFunctionPropertyASG var1, MobDevKeyAuth_Status var2);

    protected abstract void processMobDevKeyCommandStatus(BAPFunctionPropertyASG var1, MobDevKeyCommand_Status var2);

    protected abstract void processMobDevKeyActiveKeyStatus(BAPFunctionPropertyASG var1, MobDevKeyActiveKey_Status var2);

    protected abstract void processMobDevKeySetupStatus(BAPFunctionPropertyASG var1, MobDevKeySetup_Status var2);

    protected abstract void processVtanAuthDataResult(BAPFunctionMethodASG var1, VTANAuthData_Result var2);

    protected abstract void processVtanDecryptionResult(BAPFunctionMethodASG var1, VTANDecryption_Result var2);

    protected abstract void processMobDevKeyControlResult(BAPFunctionMethodASG var1, MobDevKeyControl_Result var2);
}

