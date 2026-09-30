/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.navsd.serializer.FSG_OperationState_Status;

public class InitializationManagerNavi
extends AbstractBAPModuleInitializationManagerFSG {
    public InitializationManagerNavi(AbstractCombiModule abstractCombiModule, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractCombiModule, bAPFunctionPropertyFSG, iDSIBAPController, iPowerState);
    }

    public void appStateChanged(String string, int n) {
        this.logChannel.log(100000000, "[CombiModuleNavi.InitializationManagerNavi#appStateChanged] appName=%1, value=%2", (Object)string, (long)n);
        if ("Navi".equals(string) || "AppNavAsia".equals(string)) {
            this.processAppStateChanged(n);
        }
    }

    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStateNavi = ");
        buffer.append(this.getAppState());
        buffer.append('\n');
        return buffer.toString();
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
                this.logChannel.log(10000, "[CombiModuleNavi.InitializationManagerNavi#setFSGOperationStateValue] invalid opState: %1", (long)n);
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

    public boolean isOpStateNormalOperation() {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        return fSG_OperationState_Status.op_State == 0;
    }
}

