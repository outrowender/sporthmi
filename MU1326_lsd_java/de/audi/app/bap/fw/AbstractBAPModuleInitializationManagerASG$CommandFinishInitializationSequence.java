/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.tghu.command.Command;

final class AbstractBAPModuleInitializationManagerASG$CommandFinishInitializationSequence
extends Command {
    private final /* synthetic */ AbstractBAPModuleInitializationManagerASG this$0;

    public AbstractBAPModuleInitializationManagerASG$CommandFinishInitializationSequence(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        this.this$0 = abstractBAPModuleInitializationManagerASG;
        super(abstractBAPModuleInitializationManagerASG.logChannel);
    }

    @Override
    public void execute() {
        this.this$0.setInitState(9);
        this.this$0.updateHMIState();
        this.this$0.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG.CommandFinishInitializationSequence#execute] initialization sequence completed for lsgID=%1: %1", (Object)this.this$0.lsgIDDescription);
        this.commandList.commandFinished();
    }
}

