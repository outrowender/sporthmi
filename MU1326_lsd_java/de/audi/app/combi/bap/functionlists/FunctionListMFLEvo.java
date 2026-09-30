/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionlists;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.mfl.AbstractFunctionListMFL;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.vw.mib.bap.generated.mfl.serializer.FunctionList_Status;

public class FunctionListMFLEvo
extends AbstractFunctionListMFL {
    protected void initFunctionListStatusWithVariantAndRegion(int n, int n2) {
        this.functionSupported = new boolean[this.getMaxFctID() + 1];
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(this.getFctListBAPFctID());
        FunctionList_Status functionList_Status = (FunctionList_Status)this.moduleFsg.createStatusSerializer(this.getFctListBAPFctID());
        this.initCommonFunctions(functionList_Status);
        switch (n) {
            case 0: {
                this.initVariantStd(functionList_Status);
                break;
            }
            case 1: {
                this.initVariantHighPrem(functionList_Status);
                break;
            }
            case 2: 
            case 3: {
                this.initVariantMMIKombi(functionList_Status);
                break;
            }
            default: {
                this.initVariantHighPrem(functionList_Status);
            }
        }
        bAPFunctionPropertyFSG.setInitialStatus(functionList_Status);
    }

    private void initCommonFunctions(FunctionList_Status functionList_Status) {
        boolean bl;
        functionList_Status.fct_GetAllAvailable = true;
        this.functionSupported[1] = true;
        functionList_Status.fct_Bap_ConfigAvailable = true;
        this.functionSupported[2] = true;
        functionList_Status.fct_FunctionListAvailable = true;
        this.functionSupported[3] = true;
        functionList_Status.fct_HeartBeatAvailable = true;
        this.functionSupported[4] = true;
        functionList_Status.fct_Fsg_SetupAvailable = true;
        this.functionSupported[14] = true;
        functionList_Status.fct_Fsg_OperationStateAvailable = true;
        this.functionSupported[15] = true;
        CarFuncAdap carFuncAdap = this.moduleFsg.getFrameworkAccess().getSysConstManager().getCarFuncAdaptation();
        this.functionSupported[16] = functionList_Status.fct_InstrumentClusterFunctionsAvailable = (bl = carFuncAdap.isMenuDisplayActivated((short)29));
        this.functionSupported[17] = functionList_Status.fct_KeyConfigurationAvailable = bl;
        functionList_Status.fct_KeyActionAvailable = true;
        this.functionSupported[18] = true;
    }

    private void initVariantStd(FunctionList_Status functionList_Status) {
        functionList_Status.fct_Pu_ContentAvailable = false;
        this.functionSupported[19] = false;
        functionList_Status.fct_Pu_ActionAvailable = false;
        this.functionSupported[20] = false;
    }

    private void initVariantHighPrem(FunctionList_Status functionList_Status) {
        this.initVariantStd(functionList_Status);
    }

    private void initVariantMMIKombi(FunctionList_Status functionList_Status) {
        functionList_Status.fct_Pu_ContentAvailable = true;
        this.functionSupported[19] = true;
        functionList_Status.fct_Pu_ActionAvailable = true;
        this.functionSupported[20] = true;
    }

    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    protected int getMaxFctID() {
        return 20;
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

