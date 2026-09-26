/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.app.mfl.InitializationManagerMFL$CommandResendKeyConfiguration;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.mfl.serializer.FSG_OperationState_Status;

public class InitializationManagerMFL
extends AbstractBAPModuleInitializationManagerFSG
implements IAcknowledgeListener {
    public InitializationManagerMFL(AbstractCombiModule abstractCombiModule, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractCombiModule, bAPFunctionPropertyFSG, iDSIBAPController, iPowerState);
    }

    @Override
    public void appStateChanged(String string, int n) {
        if ("Car".equals(string)) {
            this.logChannel.log(14808325, "[InitializationManagerMFL#appStateChanged] appName=%1, value=%2", (Object)string, (long)n);
            this.processAppStateChanged(n);
        }
    }

    @Override
    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStateMFL = ");
        buffer.append(this.getAppState());
        buffer.append('\n');
        return buffer.toString();
    }

    @Override
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
                this.logChannel.log(10000, "[InitializationManagerMFL#setFSGOperationStateValue] invalid opState: %1", (long)n);
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

    @Override
    public boolean isOpStateNormalOperation() {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        return fSG_OperationState_Status.op_State == 0;
    }

    @Override
    protected void startInitialization() {
        super.startInitialization();
        this.fsgOperationStateFunction.addAcknowledgeListener(this);
    }

    @Override
    public void processAcknowledge(int n, int n2) {
        this.logChannel.log(-2137614336, "[InitializationManagerMFL#processAcknowledge] %1 %2", (long)n, (long)n2);
        if (n == this.fsgOperationStateFunction.getFctID() && n2 == 0) {
            if (this.isOpStateNormalOperation()) {
                this.logChannel.log(1078071040, "[InitializationManagerMFL#processAcknowledge] opState is normal, try to resend KeyConfiguration");
                CommandList commandList = new CommandList(this.cmdListManager);
                commandList.add(new InitializationManagerMFL$CommandResendKeyConfiguration(this));
                this.cmdListManager.start();
                commandList.execute(super.getClass().getName());
            }
        } else {
            this.logChannel.log(-1601830656, "[InitializationManagerMFL#processAcknowledge] unhandled FctID %1", (long)n);
        }
    }

    static /* synthetic */ LogChannel access$000(InitializationManagerMFL initializationManagerMFL) {
        return initializationManagerMFL.logChannel;
    }

    static /* synthetic */ AbstractBAPModule access$100(InitializationManagerMFL initializationManagerMFL) {
        return initializationManagerMFL.module;
    }

    static /* synthetic */ LogChannel access$200(InitializationManagerMFL initializationManagerMFL) {
        return initializationManagerMFL.logChannel;
    }

    static /* synthetic */ LogChannel access$300(InitializationManagerMFL initializationManagerMFL) {
        return initializationManagerMFL.logChannel;
    }
}

