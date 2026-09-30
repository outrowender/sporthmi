/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.mfl.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.mfl.serializer.KeyConfiguration_StatusAck;
import de.vw.mib.bap.requests.StatusAckProperty;

public class InitializationManagerMFL
extends AbstractBAPModuleInitializationManagerFSG
implements IAcknowledgeListener {
    public InitializationManagerMFL(AbstractCombiModule abstractCombiModule, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractCombiModule, bAPFunctionPropertyFSG, iDSIBAPController, iPowerState);
    }

    public void appStateChanged(String string, int n) {
        if ("Car".equals(string)) {
            this.logChannel.log(100000000, "[InitializationManagerMFL#appStateChanged] appName=%1, value=%2", (Object)string, (long)n);
            this.processAppStateChanged(n);
        }
    }

    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStateMFL = ");
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

    public boolean isOpStateNormalOperation() {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        return fSG_OperationState_Status.op_State == 0;
    }

    protected void startInitialization() {
        super.startInitialization();
        this.fsgOperationStateFunction.addAcknowledgeListener(this);
    }

    public void processAcknowledge(int n, int n2) {
        this.logChannel.log(10000000, "[InitializationManagerMFL#processAcknowledge] %1 %2", (long)n, (long)n2);
        if (n == this.fsgOperationStateFunction.getFctID() && n2 == 0) {
            if (this.isOpStateNormalOperation()) {
                this.logChannel.log(1000000, "[InitializationManagerMFL#processAcknowledge] opState is normal, try to resend KeyConfiguration");
                CommandList commandList = new CommandList(this.cmdListManager);
                commandList.add(new CommandResendKeyConfiguration());
                this.cmdListManager.start();
                commandList.execute(this.getClass().getName());
            }
        } else {
            this.logChannel.log(100000, "[InitializationManagerMFL#processAcknowledge] unhandled FctID %1", (long)n);
        }
    }

    private final class CommandResendKeyConfiguration
    extends Command {
        private BAPFunctionPropertyFSG keyConfig;

        public CommandResendKeyConfiguration() {
            super(InitializationManagerMFL.this.logChannel);
            this.keyConfig = ((AbstractBAPModuleFSG)InitializationManagerMFL.this.module).getBAPFunctionPropertyFSG(17);
        }

        private boolean isDefaultKeyConfig(StatusAckProperty statusAckProperty) {
            KeyConfiguration_StatusAck keyConfiguration_StatusAck = new KeyConfiguration_StatusAck();
            InitializationManagerMFL.this.logChannel.log(1000000, "[InitializationManagerMFL.CommandResendKeyConfiguration#isDefaultKeyConfig] %1", (Object)statusAckProperty.toString());
            boolean bl = false;
            if (statusAckProperty.equalTo(keyConfiguration_StatusAck)) {
                bl = true;
            }
            return bl;
        }

        public void execute() {
            if (!this.isDefaultKeyConfig(this.keyConfig.getLastStatusAck())) {
                this.keyConfig.resendLastStatusAck();
            } else {
                InitializationManagerMFL.this.logChannel.log(1000000, "[InitializationManagerMFL.CommandResendKeyConfiguration#execute] don't resend default KeyConfiguration");
            }
            this.commandList.commandFinished();
        }
    }
}

