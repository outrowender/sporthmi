/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListNull;
import de.audi.tghu.command.ICommandListSupplier;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.Job;

public class CommandListInterceptor
extends BaseInterceptor {
    public static final int WAKEUPS_THRESHOLD = 5;
    private final LogChannel logChannel;
    private int wakeUpCount;
    private final ICommandListSupplier supplier;

    public CommandListInterceptor(LogChannel logChannel, ICommandListSupplier iCommandListSupplier) {
        this.logChannel = logChannel;
        this.supplier = iCommandListSupplier;
        this.wakeUpCount = 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void execute(Job job) {
        CommandList commandList;
        Object object = job.getPayload();
        if (object instanceof CommandListNull) {
            return;
        }
        if (!(object instanceof CommandList)) {
            this.logChannel.log(10000, "CommandListInterceptor#execute() - given job is no commandlist!!! ");
            return;
        }
        CommandList commandList2 = commandList = (CommandList)object;
        synchronized (commandList2) {
            long l;
            this.logChannel.log(1000000, "CommandListInterceptor#execute() - Starting execution of %1 ", (Object)commandList);
            long l2 = commandList.getManager().getFramework().getMonotonicTime();
            block17: while (commandList.hasNext()) {
                Command command = commandList.next();
                long l3 = command.getTimeout();
                int n = commandList.getPos() + 1;
                int n2 = commandList.size();
                this.logChannel.log(1000000, "CommandListInterceptor#execute() - Execute command %2 of %3: '%1'  ", (Object)command, (long)n, (long)n2);
                l = commandList.getManager().getFramework().getMonotonicTime();
                try {
                    command.execute();
                }
                catch (Exception exception) {
                    this.logChannel.log(100000, "CommandListInterceptor#execute() - Failed to execute command: %1! Aborting active command list %2! ", (Object)command, (Object)commandList);
                    commandList.commandAborted(exception);
                    break;
                }
                this.wakeUpCount = 0;
                if (l3 == -1L) {
                    while (commandList.hasActiveCommand()) {
                        try {
                            commandList.wait();
                        }
                        catch (InterruptedException interruptedException) {
                            Thread.interrupted();
                        }
                        this.checkWakeUpCount();
                    }
                    continue;
                }
                boolean bl = true;
                while (commandList.hasActiveCommand()) {
                    if (bl) {
                        long l4 = l + l3 + 1L - commandList.getManager().getFramework().getMonotonicTime();
                        if (l4 > 0L) {
                            try {
                                commandList.wait(l4);
                            }
                            catch (InterruptedException interruptedException) {
                                Thread.interrupted();
                            }
                            this.checkWakeUpCount();
                            continue;
                        }
                        if (this.supplier != null && !this.supplier.isApplicationOperable()) {
                            this.logChannel.log(100000, "CommandListInterceptor#execute() - time is up for '%1', but application seems to be not operable any longer!", (Object)command);
                            bl = false;
                            continue;
                        }
                        String string = new Buffer().append("Command '").append(command).append("' did not respond in time").toString();
                        this.logChannel.log(10000, "CommandListInterceptor#execute() - %1! ", (Object)string);
                        commandList.commandAborted(string, "timeout");
                        continue block17;
                    }
                    this.logChannel.log(100000, "CommandListInterceptor#execute() - timeouts currently disabled for '%1'!", (Object)command);
                    try {
                        commandList.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                    this.checkWakeUpCount();
                }
            }
            int n = commandList.getStatus();
            switch (n) {
                case 1: {
                    this.logChannel.log(1000000, "CommandListInterceptor#execute() - Active command list %1 has been stopped!", (Object)commandList);
                    break;
                }
                case 2: {
                    this.logChannel.log(10000, "CommandListInterceptor#execute() - Active command list %1 has been aborted! ", (Object)commandList);
                    break;
                }
            }
            if (n == 1 || n == 2) {
                try {
                    if (commandList.getErrorCommand() != null) {
                        commandList.getErrorCommand().execute();
                    }
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "CommandListInterceptor#execute() - Failed to execute error command!");
                }
            }
            long l5 = commandList.getManager().getFramework().getMonotonicTime();
            long l6 = l5 - l2;
            l = l2 - commandList.getQueuingTime();
            this.logChannel.log(1000000, "CommandListInterceptor#execute() - '%1' [execution time: %2 ms, queue time: %3 ms] ", (Object)commandList.getName(), l6, l);
        }
    }

    private void checkWakeUpCount() {
        ++this.wakeUpCount;
        if (this.wakeUpCount >= 5) {
            this.logChannel.log(100000, "CommandListInterceptor#checkWakeUpCount() - counted %1 wake-ups during wait!", (long)this.wakeUpCount);
        }
    }
}

