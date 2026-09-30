/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class RegisterServiceCommand
extends Command {
    protected IService service;
    protected IServiceWorker worker;
    protected boolean doRegister;

    public RegisterServiceCommand(IService iService, IServiceWorker iServiceWorker, boolean bl) {
        super("RegisterService");
        this.service = iService;
        this.worker = iServiceWorker;
        this.doRegister = bl;
    }

    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doRegisterService(this.service, this.worker, this.doRegister);
    }

    public ServiceInstanceID getDependentInstanceID() {
        return null;
    }

    public String getArgsString() {
        return "instance=" + this.service.getInstanceID() + (this.doRegister ? " register" : " unregister");
    }
}

