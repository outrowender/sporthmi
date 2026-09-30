/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.Monitor;

public class RMLMonitor
extends Monitor {
    public RMLMonitor(LogChannel logChannel) {
        super(logChannel);
    }

    protected boolean checkStop(CommandList commandList) {
        return !commandList.hasActiveCommand();
    }
}

