/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusAllListener;
import de.audi.tghu.command.Command;

final class AbstractBAPModuleInitializationManagerASG$CommandGetAll
extends Command
implements IBAPFunctionStatusAllListener {
    private final BAPFunctionGetAll getAllFunction;
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG this$0;

    public AbstractBAPModuleInitializationManagerASG$CommandGetAll(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        this.this$0 = abstractBAPModuleInitializationManagerASG;
        super(abstractBAPModuleInitializationManagerASG.logChannel);
        this.getAllFunction = AbstractBAPModuleInitializationManagerASG.access$000(abstractBAPModuleInitializationManagerASG).getBAPFunctionGetAll();
    }

    @Override
    public void execute() {
        this.this$0.setInitState(6);
        if (this.getAllFunction != null) {
            this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandGetAll#execute] send GetAll request");
            this.getAllFunction.setStatusAllListener(this);
            this.getAllFunction.getAllREQ();
        } else {
            this.this$0.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG.CommandGetAll#execute] getAll function not found");
            this.commandList.stop("GetAll function not available");
        }
    }

    @Override
    public void notifyStatusAllIndicationReceived(int n) {
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandGetAll#notifyStatusAllIndicationReceived] properties can now be updated");
        this.getAllFunction.resetStatusAllListener();
        this.commandList.commandFinished();
    }
}

