/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.utils.LoggingUtils;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FSG_OperationState_Status;

class InitializationManagerOnlineFunctions
extends AbstractBAPModuleInitializationManagerFSG {
    public InitializationManagerOnlineFunctions(AbstractBAPModuleFSG abstractBAPModuleFSG, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractBAPModuleFSG, bAPFunctionPropertyFSG, iDSIBAPController, iPowerState);
    }

    protected int getAppState() {
        return 1;
    }

    public synchronized void updateHMIState() {
        int n;
        this.logChannel.log(100000000, "[InitializationManagerOnlineFunctions#updateHMIState] called for lsgID=%1", (Object)this.lsgIDDescription);
        if (!this.isDsiBapAvailable()) {
            n = 0;
        } else if (this.getBapStackState() == 0) {
            n = 0;
            this.setInitState(0);
        } else if (this.getBapStackState() == 1) {
            n = this.getInitState() >= 9 ? 2 : 1;
        } else {
            this.logChannel.log(10000, "[InitializationManagerOnlineFunctions#updateHMIState] module: %1 invalid bapStackState: %2", (Object)this.lsgIDDescription, (long)this.getBapStackState());
            return;
        }
        if (this.getHMIState() != n) {
            this.logChannel.log(10000000, "[InitializationManagerOnlineFunctions#updateHMIState] new hmi state for lsgID=%1 is now: %2", (Object)this.lsgIDDescription, (Object)LoggingUtils.getHMIStateDescription(n));
            if (n == 1) {
                this.setInitState(2);
            } else if (n == 2) {
                this.setInitState(10);
            } else {
                this.setHMIState(n);
                this.module.resetBAPFunctions();
            }
            this.dsiController.setHMIState(this.module.getLSGID(), n);
        } else {
            this.logChannel.log(10000000, "[InitializationManagerOnlineFunctions#updateHMIState] hmi state didn't change (hmiState=%1, bapStackState=%2, initstate=%3)", (Object)new Integer(this.getHMIState()), (Object)new Integer(this.getBapStackState()), (Object)new Integer(this.getInitState()));
        }
    }

    public void appStateChanged(String string, int n) {
    }

    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStateOnlineFunctions = ");
        buffer.append(this.getAppState());
        buffer.append('\n');
        return buffer.toString();
    }

    public boolean isOpStateNormalOperation() {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        return fSG_OperationState_Status.op_State == 0;
    }

    public boolean setFSGOperationStateValue(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                n2 = 15;
                break;
            }
            default: {
                this.logChannel.log(10000, "[InitializationManagerOnlineFunctions#setFSGOperationStateValue] invalid opState: %1", (long)n);
                return false;
            }
        }
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        if (fSG_OperationState_Status.op_State != n2) {
            fSG_OperationState_Status.op_State = n2;
            return true;
        }
        return false;
    }
}

