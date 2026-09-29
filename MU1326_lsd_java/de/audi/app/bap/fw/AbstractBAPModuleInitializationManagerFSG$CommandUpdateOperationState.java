/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.tghu.command.Command;

final class AbstractBAPModuleInitializationManagerFSG$CommandUpdateOperationState
extends Command {
    private final /* synthetic */ AbstractBAPModuleInitializationManagerFSG this$0;

    public AbstractBAPModuleInitializationManagerFSG$CommandUpdateOperationState(AbstractBAPModuleInitializationManagerFSG abstractBAPModuleInitializationManagerFSG) {
        this.this$0 = abstractBAPModuleInitializationManagerFSG;
        super(abstractBAPModuleInitializationManagerFSG.logChannel);
    }

    @Override
    public void execute() {
        this.this$0.updateOperationState();
        this.commandList.commandFinished();
    }
}

