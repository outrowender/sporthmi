/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class RegisterRemoteServiceCommand
extends Command {
    protected ServiceInstanceID instanceID;
    protected short agentID;
    protected boolean doRegister;

    public RegisterRemoteServiceCommand(ServiceInstanceID serviceInstanceID, short s, boolean bl) {
        super("RegisterRemoteService");
        this.instanceID = serviceInstanceID;
        this.agentID = s;
        this.doRegister = bl;
    }

    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doRegisterRemoteService(this.instanceID, this.agentID, this.doRegister);
    }

    public ServiceInstanceID getDependentInstanceID() {
        return null;
    }

    public String getArgsString() {
        return "instance=" + this.instanceID + " agent=#" + this.agentID + (this.doRegister ? " register" : " unregister");
    }
}

