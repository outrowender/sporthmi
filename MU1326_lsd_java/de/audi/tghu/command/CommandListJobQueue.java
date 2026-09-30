/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.TimedJobQueue;
import java.util.List;

public class CommandListJobQueue
extends TimedJobQueue {
    private final LogChannel logChannel;
    private final CommandListManager manager;

    public CommandListJobQueue(LogChannel logChannel, CommandListManager commandListManager) {
        super(commandListManager.getFramework().getMonotonicTimeSource());
        this.logChannel = logChannel;
        this.manager = commandListManager;
    }

    public synchronized void abortQueuedExecution(String string, String string2, Object object, boolean bl) {
        this.logChannel.log(10000000, "CommandListQueue#abortExecution( %1, %2 )", (Object)string, (Object)string2);
        int n = this.length();
        for (int i2 = 0; i2 < n; ++i2) {
            CommandList commandList = (CommandList)((Job)this.getJobs().get(i2)).getPayload();
            this.manager.stopCommandList(commandList, string, object, bl);
        }
    }

    public synchronized String printStatus() {
        Buffer buffer = new Buffer(500);
        if (this.manager.getActiveCommandList() != null) {
            buffer.append("active commandlist: ").append(this.manager.getActiveCommandList());
        } else {
            buffer.append("no active commandlist");
        }
        buffer.append(Formatter.LINE_SEPARATOR);
        int n = this.length();
        if (n > 0) {
            for (int i2 = 0; i2 < n; ++i2) {
                CommandList commandList = (CommandList)((Job)this.getJobs().get(i2)).getPayload();
                buffer.append("Queue #").append(i2).append(": ").append(commandList);
            }
        } else {
            buffer.append("empty commandlist queue");
        }
        return buffer.toString();
    }

    public List getCommandLists() {
        return this.getJobs();
    }
}

