/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.fw.AbstractFunctionListASG;
import de.vw.mib.bap.generated.eni.serializer.FunctionList_Status;
import de.vw.mib.bap.requests.StatusProperty;

public final class FunctionListENI
extends AbstractFunctionListASG {
    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    protected int getMaxFctID() {
        return 37;
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

    public boolean isInModuleSpecificRange(int n) {
        return 14 == n || super.isInModuleSpecificRange(n);
    }

    public void setFunctionListConfiguration(StatusProperty statusProperty) {
        if (statusProperty instanceof FunctionList_Status) {
            this.moduleAsg.getLogChannel().log(1000000, "[FunctionListENI#setFunctionListConfiguration] %1", (Object)statusProperty);
            FunctionList_Status functionList_Status = (FunctionList_Status)statusProperty;
            this.functionSupported[1] = true;
            this.functionSupported[2] = true;
            this.functionSupported[3] = true;
            this.functionSupported[4] = functionList_Status.fctList.fctHeartbeatAvailable;
            this.functionSupported[13] = true;
            this.functionSupported[14] = functionList_Status.fctList.fctFsg_SetupAvailable;
            this.functionSupported[15] = functionList_Status.fctList.fctFsg_OperationStateAvailable;
            this.functionSupported[16] = functionList_Status.fctList.fctDestinationsListAvailable;
            this.functionSupported[17] = functionList_Status.fctList.fctDestinationList_AsgcapacityAvailable;
            this.functionSupported[18] = functionList_Status.fctList.fctIdTriggerRemoteProcessAvailable;
            this.functionSupported[19] = functionList_Status.fctList.fctIdRemoteProcessCommandsAvailable;
            this.functionSupported[20] = functionList_Status.fctList.fctIdRemoteProcessStateAvailable;
            this.functionSupported[21] = functionList_Status.fctList.fctIdUserListAvailable;
            this.functionSupported[22] = functionList_Status.fctList.fctIdServiceListAvailable;
            this.functionSupported[23] = functionList_Status.fctList.fctIdActiveMonitoringsAvailable;
            this.functionSupported[24] = functionList_Status.fctList.fctIdPrivacySetupAvailable;
            this.functionSupported[25] = functionList_Status.fctList.fctIdAlertListAvailable;
            this.functionSupported[26] = functionList_Status.fctList.fctIdMobileDeviceKeyCountAvailable;
            this.functionSupported[27] = functionList_Status.fctList.fctIdVtandataEncryptedAvailable;
            this.functionSupported[29] = functionList_Status.fctList.fctIdConnectionStateAvailable;
            this.functionSupported[30] = functionList_Status.fctList.fctIdChallengeDataAvailable;
            this.functionSupported[31] = functionList_Status.fctList.fctIdFoDlistAvailable;
            this.functionSupported[32] = functionList_Status.fctList.fctIdFoDstateAvailable;
            this.functionSupported[33] = functionList_Status.fctList.fctIdActiveTripAvailable;
            this.functionSupported[34] = functionList_Status.fctList.fctIdOlbsettingsAvailable;
            this.functionSupported[35] = functionList_Status.fctList.fctIdOlbtripListAvailable;
            this.functionSupported[36] = functionList_Status.fctList.currentOnlineUpdateStateAvailable;
            this.functionSupported[37] = functionList_Status.fctList.onlineUpdateListAvailable;
        } else {
            this.moduleAsg.getLogChannel().log(10000, "[FunctionListENI#setFunctionListConfiguration] wrong status entity");
        }
    }
}

