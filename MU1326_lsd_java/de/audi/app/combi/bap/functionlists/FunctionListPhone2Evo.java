/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionlists;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.phone2.AbstractFunctionListPhone2;
import de.vw.mib.bap.generated.telephone2.serializer.FunctionList_Status;

public class FunctionListPhone2Evo
extends AbstractFunctionListPhone2 {
    @Override
    protected void initFunctionListStatusWithVariantAndRegion(int n, int n2) {
        this.functionSupported = new boolean[this.getMaxFctID() + 1];
        if (n == 0) {
            return;
        }
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(this.getFctListBAPFctID());
        FunctionList_Status functionList_Status = (FunctionList_Status)this.moduleFsg.createStatusSerializer(this.getFctListBAPFctID());
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
        functionList_Status.fctMobileServiceSupportSupported = true;
        this.functionSupported[16] = true;
        functionList_Status.fctRegisterState2Supported = true;
        this.functionSupported[17] = true;
        functionList_Status.fctLockState2Supported = true;
        this.functionSupported[18] = true;
        functionList_Status.fctNetworkProvider2Supported = true;
        this.functionSupported[19] = true;
        functionList_Status.fctSignalQuality2Supported = true;
        this.functionSupported[20] = true;
        functionList_Status.fctDataConnectionIndication2Supported = true;
        this.functionSupported[21] = true;
        functionList_Status.fctEmailStateSupported = true;
        this.functionSupported[22] = true;
        functionList_Status.fctPhoneModuleStateSupported = true;
        this.functionSupported[23] = true;
        functionList_Status.fctConnectionStateSupported = true;
        this.functionSupported[24] = true;
        functionList_Status.fctAutomaticCallForwardingSupported = true;
        this.functionSupported[25] = true;
        functionList_Status.fctPhonebookDownloadProgressSupported = true;
        this.functionSupported[26] = true;
        bAPFunctionPropertyFSG.setInitialStatus(functionList_Status);
    }

    @Override
    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    @Override
    protected int getMaxFctID() {
        return 26;
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

