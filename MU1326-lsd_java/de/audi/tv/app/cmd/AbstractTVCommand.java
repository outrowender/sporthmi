/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public abstract class AbstractTVCommand
extends Command {
    public static final int CMD_ADD_FAVORITE;
    public static final int CMD_REMOVE_FAVORITE;
    public static final int CMD_SELECT_STATION;
    public static final int CMD_UPDATE_STATIONS;
    public static final int CMD_DSI;
    private final int cmdType;

    public AbstractTVCommand(LogChannel logChannel, int n) {
        super(logChannel);
        this.cmdType = n;
    }

    protected void commandFinished() {
        this.logger.log(-2137614336, "[AbstractTVCommand.commandFinished] '%1'", (Object)this);
        this.commandList.commandFinished();
    }

    public boolean isDSICmd() {
        return this.cmdType == 4;
    }
}

