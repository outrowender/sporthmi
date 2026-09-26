/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;

class CommandListManager$1
extends BaseJobFilter {
    private final /* synthetic */ LogChannel val$cmdLogChannel;
    private final /* synthetic */ CommandListManager this$0;

    CommandListManager$1(CommandListManager commandListManager, LogChannel logChannel) {
        this.this$0 = commandListManager;
        this.val$cmdLogChannel = logChannel;
    }

    @Override
    public void enqueue(Job job, int n) {
        CommandList commandList = (CommandList)job.getPayload();
        this.val$cmdLogChannel.log(-2137614336, "CommandListQueue#enqueue( %1 ) ", (Object)commandList.getName());
        commandList.prologue();
        CommandListManager.access$000(this.this$0, commandList, 1);
        super.enqueue(job, n);
    }
}

