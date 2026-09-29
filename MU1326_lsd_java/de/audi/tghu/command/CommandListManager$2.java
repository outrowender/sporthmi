/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandListSupplier;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;

class CommandListManager$2
extends BaseJobFilter {
    private final /* synthetic */ ICommandListSupplier val$supplier;
    private final /* synthetic */ LogChannel val$cmdLogChannel;
    private final /* synthetic */ CommandListManager this$0;

    CommandListManager$2(CommandListManager commandListManager, ICommandListSupplier iCommandListSupplier, LogChannel logChannel) {
        this.this$0 = commandListManager;
        this.val$supplier = iCommandListSupplier;
        this.val$cmdLogChannel = logChannel;
    }

    @Override
    public void enqueue(Job job, int n) {
        CommandList commandList = (CommandList)job.getPayload();
        if (!this.val$supplier.isDSIsAvailable(commandList)) {
            this.val$cmdLogChannel.log(-1601830656, "CommandListQueue#enqueue() - commandlist dropped. DSI for %1 not ready!", (Object)this.val$supplier.getApplicationName(commandList));
        } else {
            super.enqueue(job, n);
        }
    }
}

