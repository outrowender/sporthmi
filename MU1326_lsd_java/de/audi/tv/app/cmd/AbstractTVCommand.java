/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cmd;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public abstract class AbstractTVCommand
extends Command {
    public static final int CMD_ADD_FAVORITE = 0;
    public static final int CMD_REMOVE_FAVORITE = 1;
    public static final int CMD_SELECT_STATION = 2;
    public static final int CMD_UPDATE_STATIONS = 3;
    public static final int CMD_DSI = 4;
    private final int cmdType;

    public AbstractTVCommand(LogChannel logChannel, int n) {
        super(logChannel);
        this.cmdType = n;
    }

    protected void commandFinished() {
        this.logger.log(10000000, "[AbstractTVCommand.commandFinished] '%1'", (Object)this);
        this.commandList.commandFinished();
    }

    public boolean isDSICmd() {
        return this.cmdType == 4;
    }
}

