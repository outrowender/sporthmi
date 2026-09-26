/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.tghu.command.Command;

final class AbstractBAPModuleInitializationManagerFSG$CommandFinishInitializationSequence
extends Command {
    private final /* synthetic */ AbstractBAPModuleInitializationManagerFSG this$0;

    public AbstractBAPModuleInitializationManagerFSG$CommandFinishInitializationSequence(AbstractBAPModuleInitializationManagerFSG abstractBAPModuleInitializationManagerFSG) {
        this.this$0 = abstractBAPModuleInitializationManagerFSG;
        super(abstractBAPModuleInitializationManagerFSG.logChannel);
    }

    @Override
    public void execute() {
        this.this$0.setInitState(9);
        this.this$0.updateOperationState();
        this.this$0.updateHMIState();
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG.CommandFinishInitializationSequence#execute] initialization sequence completed for lsgID=%1", (Object)this.this$0.lsgIDDescription);
        this.commandList.commandFinished();
    }
}

