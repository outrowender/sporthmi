/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.Job;

class CommandListManager$3
extends BaseInterceptor {
    private final /* synthetic */ CommandListManager this$0;

    CommandListManager$3(CommandListManager commandListManager) {
        this.this$0 = commandListManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute(Job job) {
        CommandList commandList = (CommandList)job.getPayload();
        CommandListManager.access$000(this.this$0, commandList, -1);
        CommandListManager.access$100(this.this$0, commandList);
        try {
            super.execute(job);
        }
        finally {
            commandList.epilogue();
            CommandListManager.access$100(this.this$0, null);
        }
    }
}

