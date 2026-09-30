/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.fw.AbstractFunctionListASG;
import de.vw.mib.bap.generated.remoteservices.serializer.FunctionList_Status;
import de.vw.mib.bap.requests.StatusProperty;

public class FunctionListRemoteServices
extends AbstractFunctionListASG {
    public void setFunctionListConfiguration(StatusProperty statusProperty) {
        if (statusProperty instanceof FunctionList_Status) {
            this.moduleAsg.getLogChannel().log(1000000, "[FunctionListRemoteServices#setFunctionListConfiguration] %1", (Object)statusProperty);
            FunctionList_Status functionList_Status = (FunctionList_Status)statusProperty;
            this.functionSupported[1] = true;
            this.functionSupported[2] = true;
            this.functionSupported[3] = true;
            this.functionSupported[4] = functionList_Status.fctList.fctHeartbeatAvailable;
            this.functionSupported[13] = functionList_Status.fctList.fctFsg_ControlAvailable;
            this.functionSupported[14] = functionList_Status.fctList.fctFsg_SetupAvailable;
            this.functionSupported[15] = functionList_Status.fctList.fctFsg_OperationStateAvailable;
            this.functionSupported[16] = functionList_Status.fctList.fctStartEngineChallengeAvailable;
            this.functionSupported[17] = functionList_Status.fctList.fctStartEngineAuthenticationAvailable;
            this.functionSupported[18] = functionList_Status.fctList.fctStartEngineSignatureAvailable;
            this.functionSupported[19] = functionList_Status.fctList.fctMobDevKeyChallengeAvailable;
            this.functionSupported[20] = functionList_Status.fctList.fctMobDevKeyAuthAvailable;
            this.functionSupported[21] = functionList_Status.fctList.fctMobDevKeyCommandAvailable;
            this.functionSupported[22] = functionList_Status.fctList.fctMobDevKeyActiveKeyAvailable;
            this.functionSupported[23] = functionList_Status.fctList.fctMobDevKeySetupAvailable;
            this.functionSupported[24] = functionList_Status.fctList.fctVtanauthDataAvailable;
            this.functionSupported[25] = functionList_Status.fctList.fctVtandecryptionAvailable;
            this.functionSupported[26] = functionList_Status.fctList.fctMobDevKeyControlAvailable;
        } else {
            this.moduleAsg.getLogChannel().log(10000, "[FunctionListRemoteServices#setFunctionListConfiguration] wrong status entity");
        }
    }

    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    protected int getMaxFctID() {
        return 26;
    }

    public int getGetAllFctID() {
        return 1;
    }

    public int getBAPConfigBAPFctID() {
        return 2;
    }

    public int getFctListBAPFctID() {
        return 3;
    }

    public int getOperationStateBAPFctID() {
        return 15;
    }
}

