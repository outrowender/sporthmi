/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.Proxy;

public class ConnectProxyCommand
extends Command {
    protected Proxy proxy;

    public ConnectProxyCommand(Proxy proxy) {
        super("ConnectProxy");
        this.setDependentInstanceID(proxy.getInstanceID());
        this.proxy = proxy;
    }

    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doConnectProxy(this.proxy);
    }

    public void drop(ICommandExecutor iCommandExecutor, boolean bl) {
        iCommandExecutor.dropConnectProxy(this.proxy, bl);
    }

    public String getArgsString() {
        return "instance=" + this.proxy.getInstanceID();
    }
}

