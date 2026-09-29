/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionlists;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.phone.AbstractFunctionListPhone;
import de.audi.app.combi.bap.fw.CombiCodingAccess;
import de.vw.mib.bap.generated.telephone.serializer.FunctionList_Status;

public class FunctionListPhoneEvo
extends AbstractFunctionListPhone {
    @Override
    protected void initFunctionListStatusWithVariantAndRegion(int n, int n2) {
        this.functionSupported = new boolean[this.getMaxFctID() + 1];
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(this.getFctListBAPFctID());
        FunctionList_Status functionList_Status = (FunctionList_Status)this.moduleFsg.createStatusSerializer(this.getFctListBAPFctID());
        this.initCommonFunctions(functionList_Status);
        switch (n) {
            case 0: 
            case 1: {
                this.initVariantStdHighPrem(functionList_Status);
                break;
            }
            case 2: 
            case 3: {
                this.initVariantMMIKombi(functionList_Status);
                break;
            }
            default: {
                this.initVariantStdHighPrem(functionList_Status);
            }
        }
        bAPFunctionPropertyFSG.setInitialStatus(functionList_Status);
    }

    private void initCommonFunctions(FunctionList_Status functionList_Status) {
        functionList_Status.fctGetAllSupported = true;
        this.functionSupported[1] = true;
        functionList_Status.fctBapConfigSupported = true;
        this.functionSupported[2] = true;
        functionList_Status.fctFunctionListSupported = true;
        this.functionSupported[3] = true;
        functionList_Status.fctHeartbeatSupported = true;
        this.functionSupported[4] = true;
        functionList_Status.fctFsg_SetupSupported = true;
        this.functionSupported[14] = true;
        functionList_Status.fctFsg_OperationStateSupported = true;
        this.functionSupported[15] = true;
    }

    private void initVariantStdHighPrem(FunctionList_Status functionList_Status) {
        functionList_Status.fctMobileServiceSupportAvailable = true;
        this.functionSupported[16] = true;
        functionList_Status.fctActiveUserSupported = false;
        this.functionSupported[17] = false;
        functionList_Status.fctRegisterStateSupported = true;
        this.functionSupported[18] = true;
        functionList_Status.fctLockStateSupported = true;
        this.functionSupported[19] = true;
        functionList_Status.fctNetworkProviderSupported = true;
        this.functionSupported[20] = true;
        functionList_Status.fctSignalQualitySupported = true;
        this.functionSupported[21] = true;
        functionList_Status.fctCallStateSupported = true;
        this.functionSupported[22] = true;
        functionList_Status.fctCallInfoSupported = true;
        this.functionSupported[23] = true;
        functionList_Status.fctCallDurationSyncSupported = false;
        this.functionSupported[24] = false;
        functionList_Status.fctDisconnectReasonSupported = true;
        this.functionSupported[25] = true;
        functionList_Status.fctDialNumberSupported = true;
        this.functionSupported[26] = true;
        functionList_Status.fctDialServiceSupported = true;
        this.functionSupported[27] = true;
        functionList_Status.fctConfirmEmergencyCallSupported = true;
        this.functionSupported[28] = true;
        functionList_Status.fctHangupCallSupported = true;
        this.functionSupported[29] = true;
        functionList_Status.fctAcceptCallSupported = true;
        this.functionSupported[30] = true;
        functionList_Status.fctCallHoldSupported = true;
        this.functionSupported[31] = true;
        functionList_Status.fctResumeCallSupported = true;
        this.functionSupported[32] = true;
        functionList_Status.fctHandsFreeOnOffSupported = false;
        this.functionSupported[33] = false;
        functionList_Status.fctMicroMuteOnOffSupported = true;
        this.functionSupported[34] = true;
        functionList_Status.fctMpreleaseActiveCallAcceptWaitingCallSupported = true;
        this.functionSupported[35] = true;
        functionList_Status.fctMpswapSupported = true;
        this.functionSupported[36] = true;
        functionList_Status.fctMpcallHoldAcceptWaitingCallSupported = true;
        this.functionSupported[37] = true;
        functionList_Status.fctMpreleaseAllCallsAcceptWaitingCallSupported = false;
        this.functionSupported[38] = false;
        functionList_Status.fctMpsetWaitingCallOnHoldSupported = true;
        this.functionSupported[39] = true;
        functionList_Status.fctCcjoinSupported = true;
        this.functionSupported[40] = true;
        functionList_Status.fctCcsplitSupported = false;
        this.functionSupported[41] = false;
        functionList_Status.fctKeypadSupported = false;
        this.functionSupported[42] = false;
        functionList_Status.fctMobileBatteryLevelSupported = true;
        this.functionSupported[43] = true;
        functionList_Status.fctDataConnectionIndicationSupported = false;
        this.functionSupported[44] = false;
        functionList_Status.fctMissedCallIndicationSupported = true;
        this.functionSupported[45] = true;
        functionList_Status.fctMissedCallsSupported = false;
        this.functionSupported[46] = false;
        functionList_Status.fctReceivedCallsSupported = false;
        this.functionSupported[47] = false;
        functionList_Status.fctDialedNumbersSupported = false;
        this.functionSupported[48] = false;
        functionList_Status.fctCombinedNumbersSupported = true;
        this.functionSupported[49] = true;
        functionList_Status.fctCallStackDeleteAllSupported = false;
        this.functionSupported[50] = false;
        functionList_Status.fctSmsstateSupported = true;
        this.functionSupported[55] = true;
        functionList_Status.fctRingToneMuteOnOffSupported = true;
        this.functionSupported[56] = true;
        functionList_Status.fctAutomaticRedialSupported = false;
        this.functionSupported[57] = false;
        functionList_Status.fctAutomaticRedialExtendedInfoSupported = false;
        this.functionSupported[58] = false;
        functionList_Status.fctSupportedServiceNumbersSupported = true;
        this.functionSupported[59] = true;
        functionList_Status.fctFavoriteListSupported = true;
        this.functionSupported[60] = true;
        functionList_Status.fctPbStateSupported = true;
        this.functionSupported[51] = true;
        functionList_Status.fctPhonebookSupported = !CombiCodingAccess.isTextReplacementActivated();
        this.functionSupported[52] = functionList_Status.fctPhonebookSupported;
        functionList_Status.fctPbSpellerSupported = true;
        this.functionSupported[53] = true;
        functionList_Status.fctGetNextListPosSupported = true;
        this.functionSupported[54] = true;
    }

    private void initVariantMMIKombi(FunctionList_Status functionList_Status) {
        this.initVariantStdHighPrem(functionList_Status);
        functionList_Status.fctDialNumberSupported = false;
        this.functionSupported[26] = false;
        functionList_Status.fctDialServiceSupported = false;
        this.functionSupported[27] = false;
        functionList_Status.fctDataConnectionIndicationSupported = true;
        this.functionSupported[44] = true;
        functionList_Status.fctCombinedNumbersSupported = false;
        this.functionSupported[49] = false;
        functionList_Status.fctPbStateSupported = false;
        this.functionSupported[51] = false;
        functionList_Status.fctPhonebookSupported = false;
        this.functionSupported[52] = false;
        functionList_Status.fctPbSpellerSupported = false;
        this.functionSupported[53] = false;
        functionList_Status.fctGetNextListPosSupported = false;
        this.functionSupported[54] = false;
        functionList_Status.fctSmsstateSupported = true;
        this.functionSupported[55] = true;
        functionList_Status.fctSupportedServiceNumbersSupported = false;
        this.functionSupported[59] = false;
        functionList_Status.fctFavoriteListSupported = false;
        this.functionSupported[60] = false;
    }

    @Override
    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    @Override
    protected int getMaxFctID() {
        return 60;
    }

    @Override
    public int getGetAllFctID() {
        return 1;
    }

    @Override
    public int getBAPConfigBAPFctID() {
        return 2;
    }

    @Override
    public int getFctListBAPFctID() {
        return 3;
    }

    @Override
    public int getOperationStateBAPFctID() {
        return 15;
    }
}

