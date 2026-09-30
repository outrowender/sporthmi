/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.fw.AbstractFunctionListASG;
import de.vw.mib.bap.generated.ecall.serializer.FunctionList_FctList;
import de.vw.mib.bap.generated.ecall.serializer.FunctionList_Status;
import de.vw.mib.bap.requests.StatusProperty;

public final class FunctionListEcall
extends AbstractFunctionListASG {
    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    protected int getMaxFctID() {
        return 31;
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

    public void setFunctionListConfiguration(StatusProperty statusProperty) {
        if (statusProperty instanceof FunctionList_Status) {
            this.moduleAsg.getLogChannel().log(1000000, "[FunctionListEcall#setFunctionListConfiguration] %1", (Object)statusProperty);
            FunctionList_FctList functionList_FctList = ((FunctionList_Status)statusProperty).fctList;
            this.functionSupported[1] = true;
            this.functionSupported[2] = true;
            this.functionSupported[3] = true;
            this.functionSupported[4] = functionList_FctList.fct_HeartBeatAvailable;
            this.functionSupported[13] = functionList_FctList.fct_Fsg_ControlAvailable;
            this.functionSupported[14] = functionList_FctList.fct_Fsg_SetupAvailable;
            this.functionSupported[15] = functionList_FctList.fct_Fsg_OperationStateAvailable;
            this.functionSupported[16] = functionList_FctList.fct_AudioStateAvailable;
            this.functionSupported[17] = functionList_FctList.fct_CallStateAvailable;
            this.functionSupported[18] = functionList_FctList.fct_HangupCallAvailable;
            this.functionSupported[19] = functionList_FctList.fct_AcceptCallAvailable;
            this.functionSupported[20] = functionList_FctList.fct_DisconnectReasonAvailable;
            this.functionSupported[21] = functionList_FctList.fct_RegisterStateAvailable;
            this.functionSupported[22] = functionList_FctList.fct_NetworkProviderAvailable;
            this.functionSupported[23] = functionList_FctList.fct_SignalQualityAvailable;
            this.functionSupported[24] = functionList_FctList.fct_ServiceRequestAvailable;
            this.functionSupported[25] = functionList_FctList.fct_ServiceControlAvailable;
            this.functionSupported[26] = functionList_FctList.fct_ServiceStateAvailable;
            this.functionSupported[27] = functionList_FctList.fct_SupportedServicesAvailable;
            this.functionSupported[28] = functionList_FctList.fct_FunctionalRestrictionsAvailable;
            this.functionSupported[29] = functionList_FctList.fct_AllowedEmergencyNumbersAvailable;
            this.functionSupported[30] = functionList_FctList.fct_DialNumberAvailable;
            this.functionSupported[31] = functionList_FctList.fct_DisasterWarningAvailable;
        } else {
            this.moduleAsg.getLogChannel().log(10000, "[FunctionListEcall#setFunctionListConfiguration] wrong status entity");
        }
    }
}

