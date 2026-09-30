/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class RegisterProxyListenerCommand
extends Command {
    protected Proxy proxy;
    protected IProxyListener listener;
    protected boolean doRegister;

    public RegisterProxyListenerCommand(Proxy proxy, IProxyListener iProxyListener, boolean bl) {
        super("RegisterProxyListener");
        this.proxy = proxy;
        this.listener = iProxyListener;
        this.doRegister = bl;
    }

    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doRegisterProxyListener(this.proxy, this.listener, this.doRegister);
    }

    public ServiceInstanceID getDependentInstanceID() {
        return null;
    }

    public String getArgsString() {
        return "instance=" + this.proxy.getInstanceID() + (this.doRegister ? " register" : " unregister");
    }
}

