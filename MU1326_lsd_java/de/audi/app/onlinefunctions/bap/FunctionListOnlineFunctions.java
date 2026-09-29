/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.onlinefunctions.bap.AbstractFunctionListOnlineFunctionsBAP;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FunctionList_Status;

public class FunctionListOnlineFunctions
extends AbstractFunctionListOnlineFunctionsBAP {
    @Override
    protected void initFunctionListStatusWithVariantAndRegion(int n, int n2) {
        this.functionSupported = new boolean[this.getMaxFctID() + 1];
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(this.getFctListBAPFctID());
        FunctionList_Status functionList_Status = (FunctionList_Status)this.moduleFsg.createStatusSerializer(this.getFctListBAPFctID());
        this.initFunctions(functionList_Status);
        bAPFunctionPropertyFSG.setInitialStatus(functionList_Status);
    }

    private void initFunctions(FunctionList_Status functionList_Status) {
        functionList_Status.fctGetAllAvailable = true;
        this.functionSupported[1] = true;
        functionList_Status.fctBap_ConfigAvailable = true;
        this.functionSupported[2] = true;
        functionList_Status.fctFunctionListAvailable = true;
        this.functionSupported[3] = true;
        functionList_Status.fctHeartbeatAvailable = true;
        this.functionSupported[4] = true;
        functionList_Status.fctFsg_SetupAvailable = false;
        this.functionSupported[14] = false;
        functionList_Status.fctFsg_ControlAvailable = false;
        this.functionSupported[13] = false;
        functionList_Status.fctFsg_OperationStateAvailable = true;
        this.functionSupported[15] = true;
        functionList_Status.fctTrafficLightOnline_InfoAvailable = true;
        this.functionSupported[16] = true;
        functionList_Status.fctTrafficLightOnline_SpeedAvailable = true;
        this.functionSupported[17] = true;
        functionList_Status.fctTrafficLightOnline_TimeAvailable = true;
        this.functionSupported[18] = true;
    }

    @Override
    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    @Override
    protected int getMaxFctID() {
        return 18;
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

