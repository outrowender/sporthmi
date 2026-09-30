/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class ClientHandlerUpdateCommand
extends Command {
    protected IClientHandler clientHandler;
    protected boolean connected;

    public ClientHandlerUpdateCommand(IClientHandler iClientHandler, boolean bl) {
        super("ClientHandlerUpdate");
        this.clientHandler = iClientHandler;
        this.connected = bl;
    }

    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doClientHandlerUpdate(this.clientHandler, this.connected);
    }

    public String getArgsString() {
        return "agent=#" + this.clientHandler.getPeerAgentID() + " connected=" + this.connected;
    }
}

