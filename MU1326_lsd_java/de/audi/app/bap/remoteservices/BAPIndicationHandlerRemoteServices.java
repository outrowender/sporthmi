/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.generated.remoteservices.AbstractBAPIndicationHandlerRemoteServices;
import de.audi.app.bap.remoteservices.BAPModuleRemoteServices;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup$Builder;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData;
import de.audi.atip.interapp.bap.remoteservices.data.VTANData$Builder;
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
import de.vw.mib.bap.requests.StatusArray;

public class BAPIndicationHandlerRemoteServices
extends AbstractBAPIndicationHandlerRemoteServices {
    private final BAPModuleRemoteServices remoteServicesModule;

    public BAPIndicationHandlerRemoteServices(BAPModuleRemoteServices bAPModuleRemoteServices) {
        super(bAPModuleRemoteServices, bAPModuleRemoteServices.getLogChannel());
        this.remoteServicesModule = bAPModuleRemoteServices;
    }

    @Override
    public void processIndicationStatusArrayAck(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        this.logChannel.log(10000, "[BAPIndicationHandlerRemoteServices#processIndicationStatusArrayAck] not supported.");
    }

    @Override
    protected void processBapConfigStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, BAP_Config_Status bAP_Config_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processBapConfigStatus]");
    }

    @Override
    protected void processFunctionListStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FunctionList_Status functionList_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processFunctionListStatus]");
    }

    @Override
    protected void processFsgControlStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Control_Status fSG_Control_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processFsgControlStatus]");
    }

    @Override
    protected void processFsgSetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Setup_Status fSG_Setup_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processFsgSetupStatus]");
    }

    @Override
    protected void processFsgOperationStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_OperationState_Status fSG_OperationState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processFsgOperationStateStatus] state: %1", (long)fSG_OperationState_Status.op_State);
        this.remoteServicesModule.setFsgOperationState(fSG_OperationState_Status.op_State);
    }

    @Override
    protected void processStartEngineChallengeResult(BAPFunctionMethodASG bAPFunctionMethodASG, StartEngineChallenge_Result startEngineChallenge_Result) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processStartEngineChallengeResult]");
    }

    @Override
    protected void processStartEngineAuthenticationStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, StartEngineAuthentication_Status startEngineAuthentication_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processStartEngineAuthenticationStatus]");
    }

    @Override
    protected void processStartEngineSignatureStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, StartEngineSignature_Status startEngineSignature_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processStartEngineSignatureStatus]");
    }

    @Override
    protected void processMobDevKeyChallengeResult(BAPFunctionMethodASG bAPFunctionMethodASG, MobDevKeyChallenge_Result mobDevKeyChallenge_Result) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processMobDevKeyChallengeResult]");
    }

    @Override
    protected void processMobDevKeyAuthStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeyAuth_Status mobDevKeyAuth_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processMobDevKeyAuthStatus]");
    }

    @Override
    protected void processMobDevKeyCommandStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeyCommand_Status mobDevKeyCommand_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processMobDevKeyCommandStatus]");
    }

    @Override
    protected void processMobDevKeyActiveKeyStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeyActiveKey_Status mobDevKeyActiveKey_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processMobDevKeyActiveKeyStatus]");
    }

    @Override
    protected void processMobDevKeyControlResult(BAPFunctionMethodASG bAPFunctionMethodASG, MobDevKeyControl_Result mobDevKeyControl_Result) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerRemoteServices#processMobDevKeyControlResult]");
    }

    @Override
    protected void processMobDevKeySetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, MobDevKeySetup_Status mobDevKeySetup_Status) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerRemoteServices#processMobDevKeySetupStatus] serializer=%1", (Object)mobDevKeySetup_Status.toString());
        MobileKeySetup$Builder mobileKeySetup$Builder = MobileKeySetup.builder();
        mobileKeySetup$Builder.setMobDevKeyEnabled(mobDevKeySetup_Status.setup.mobileDeviceKeyEnabled);
        mobileKeySetup$Builder.setSmartCardEnabled(mobDevKeySetup_Status.setup.smartcardEnabled);
        mobileKeySetup$Builder.setMobileDeviceKeyReset(mobDevKeySetup_Status.setup.mobileDeviceKeyReset);
        mobileKeySetup$Builder.setSmartcardActivationRequested(mobDevKeySetup_Status.setup.smartcardActivationRequested);
        mobileKeySetup$Builder.setCanBeModified_Setup(mobDevKeySetup_Status.modificationState_Setup.canBeModified);
        mobileKeySetup$Builder.setModificationReason_Setup(mobDevKeySetup_Status.modificationReason_Setup);
        mobileKeySetup$Builder.setCanBeModified_Smartcard(mobDevKeySetup_Status.modificationState_Smartcard.canBeModified);
        mobileKeySetup$Builder.setModificationReason_Smartcard(mobDevKeySetup_Status.modificationReason_Smartcard);
        mobileKeySetup$Builder.setCanBeModified_Reset(mobDevKeySetup_Status.modificationState_Reset.canBeModified);
        mobileKeySetup$Builder.setModificationReason_Reset(mobDevKeySetup_Status.modificationReason_Reset);
        MobileKeySetup mobileKeySetup = mobileKeySetup$Builder.build();
        this.remoteServicesModule.getDataRemoteServices().setCurrentMobileKeySetup(mobileKeySetup);
        this.remoteServicesModule.getAppServiceListenerRemoteServices().onMobDevKeySetup(mobileKeySetup);
    }

    @Override
    protected void processVtanAuthDataResult(BAPFunctionMethodASG bAPFunctionMethodASG, VTANAuthData_Result vTANAuthData_Result) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerRemoteServices#processVtanAuthDataResult] result=%1", (Object)vTANAuthData_Result.toString());
        boolean bl = vTANAuthData_Result.resultCode == 0;
        String string = "";
        if (bl) {
            string = vTANAuthData_Result.vtanauthenticationData.toString();
        }
        this.remoteServicesModule.getAppServiceListenerRemoteServices().onVTANAuthDataFinished(bl, string);
    }

    @Override
    protected void processVtanDecryptionResult(BAPFunctionMethodASG bAPFunctionMethodASG, VTANDecryption_Result vTANDecryption_Result) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerRemoteServices#processVtanDecryptionResult] result=%1", (Object)vTANDecryption_Result.toString());
        boolean bl = vTANDecryption_Result.resultCode == 0;
        VTANData$Builder vTANData$Builder = VTANData.builder();
        vTANData$Builder.setUserName(vTANDecryption_Result.param1.toString());
        vTANData$Builder.setVTAN(vTANDecryption_Result.vtan.toString());
        this.remoteServicesModule.getAppServiceListenerRemoteServices().onVTANDecryptionFinished(bl, vTANData$Builder.build());
    }
}

