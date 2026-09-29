/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Monitor {
    protected Set monitoredCommandlists;
    protected LogChannel logChannel;

    public Monitor(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.monitoredCommandlists = new HashSet();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void prologue(CommandList commandList) {
        Set set = this.monitoredCommandlists;
        synchronized (set) {
            this.monitoredCommandlists.add(commandList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void epilogue(CommandList commandList) {
        Set set = this.monitoredCommandlists;
        synchronized (set) {
            this.monitoredCommandlists.remove(commandList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isActive() {
        Set set = this.monitoredCommandlists;
        synchronized (set) {
            return !this.monitoredCommandlists.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean stopMonitoredLists(String string) {
        Set set = this.monitoredCommandlists;
        synchronized (set) {
            boolean bl = this.isActive();
            this.logChannel.log(-2137614336, "Monitor#stopMonitoredLists( %2 ) - active: %1", bl, (Object)string);
            if (bl) {
                Iterator iterator = this.monitoredCommandlists.iterator();
                while (iterator.hasNext()) {
                    CommandList commandList = (CommandList)iterator.next();
                    if (!this.checkStop(commandList)) continue;
                    commandList.stop(string);
                }
            }
            return bl;
        }
    }

    public boolean processCommand(Command command) {
        return true;
    }

    protected boolean checkStop(CommandList commandList) {
        return true;
    }
}

