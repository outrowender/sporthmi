/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.Monitor;

public class DelayedStopMonitor
extends Monitor {
    protected Command monitoredCommand;
    private boolean monitoredCommandPassed;
    private boolean stopRequested;

    public DelayedStopMonitor(LogChannel logChannel) {
        super(logChannel);
        this.initialize(null);
    }

    public final void initialize(Command command) {
        this.monitoredCommand = command;
        this.monitoredCommandPassed = false;
        this.stopRequested = false;
    }

    @Override
    public void epilogue(CommandList commandList) {
        super.epilogue(commandList);
        if (!this.isActive()) {
            this.initialize(null);
        }
    }

    @Override
    public boolean processCommand(Command command) {
        if (command == this.monitoredCommand) {
            this.logChannel.log(1078071040, "DelayedStopMonitor#processCommand() - monitored command: %2 passed (stopRequested: %1) ", this.stopRequested, (Object)command);
            this.monitoredCommandPassed = true;
        }
        return !this.stopRequested || !this.monitoredCommandPassed;
    }

    @Override
    public boolean stopMonitoredLists(String string) {
        this.logChannel.log(1078071040, "DelayedStopMonitor#stopMonitoredLists() - monitored command passed: %1", this.monitoredCommandPassed);
        this.stopRequested = true;
        return super.stopMonitoredLists(string);
    }

    @Override
    protected boolean checkStop(CommandList commandList) {
        return this.stopRequested && this.monitoredCommandPassed;
    }
}

