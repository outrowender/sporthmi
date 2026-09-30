/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.Proxy;

public class DisconnectProxyCommand
extends Command {
    protected Proxy proxy;

    public DisconnectProxyCommand(Proxy proxy) {
        super("DisconnectProxy");
        this.proxy = proxy;
    }

    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doDisconnectProxy(this.proxy);
    }

    public String getArgsString() {
        return "instance=" + this.proxy.getInstanceID();
    }
}

