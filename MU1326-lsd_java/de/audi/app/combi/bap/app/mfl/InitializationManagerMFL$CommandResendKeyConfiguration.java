/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.mfl.InitializationManagerMFL;
import de.audi.tghu.command.Command;
import de.vw.mib.bap.generated.mfl.serializer.KeyConfiguration_StatusAck;
import de.vw.mib.bap.requests.StatusAckProperty;

final class InitializationManagerMFL$CommandResendKeyConfiguration
extends Command {
    private BAPFunctionPropertyFSG keyConfig;
    private final /* synthetic */ InitializationManagerMFL this$0;

    public InitializationManagerMFL$CommandResendKeyConfiguration(InitializationManagerMFL initializationManagerMFL) {
        this.this$0 = initializationManagerMFL;
        super(InitializationManagerMFL.access$000(initializationManagerMFL));
        this.keyConfig = ((AbstractBAPModuleFSG)InitializationManagerMFL.access$100(initializationManagerMFL)).getBAPFunctionPropertyFSG(17);
    }

    private boolean isDefaultKeyConfig(StatusAckProperty statusAckProperty) {
        KeyConfiguration_StatusAck keyConfiguration_StatusAck = new KeyConfiguration_StatusAck();
        InitializationManagerMFL.access$200(this.this$0).log(1078071040, "[InitializationManagerMFL.CommandResendKeyConfiguration#isDefaultKeyConfig] %1", (Object)statusAckProperty.toString());
        boolean bl = false;
        if (statusAckProperty.equalTo(keyConfiguration_StatusAck)) {
            bl = true;
        }
        return bl;
    }

    @Override
    public void execute() {
        if (!this.isDefaultKeyConfig(this.keyConfig.getLastStatusAck())) {
            this.keyConfig.resendLastStatusAck();
        } else {
            InitializationManagerMFL.access$300(this.this$0).log(1078071040, "[InitializationManagerMFL.CommandResendKeyConfiguration#execute] don't resend default KeyConfiguration");
        }
        this.commandList.commandFinished();
    }
}

