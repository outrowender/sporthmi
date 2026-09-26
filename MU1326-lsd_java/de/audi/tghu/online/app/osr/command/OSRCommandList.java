/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import java.util.Collection;

public class OSRCommandList
extends CommandList {
    private final OnlineServiceRegistrationSubsystem application;

    public OSRCommandList(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        super(onlineServiceRegistrationSubsystem.getCommandListManager());
        this.application = onlineServiceRegistrationSubsystem;
    }

    public OSRCommandList(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem, int n) {
        super(onlineServiceRegistrationSubsystem.getCommandListManager(), n);
        this.application = onlineServiceRegistrationSubsystem;
    }

    public OnlineServiceRegistrationSubsystem getApplication() {
        return this.application;
    }

    @Override
    public ICommandList add(Command command) {
        LogChannel logChannel = this.application.getLogChannelCL();
        logChannel.log(1078071040, "ORSCommandList#addCommand: %1", (Object)command.getName());
        return super.add(command);
    }

    public CommandList cancelCurrentCommand() {
        int n = this.getPos();
        this.commandAborted("cancelCurrentCommand - aborted by user");
        Collection collection = this.getCommands();
        AbstractOSRCommand[] abstractOSRCommandArray = (AbstractOSRCommand[])collection.toArray(new AbstractOSRCommand[collection.size()]);
        OSRCommandList oSRCommandList = new OSRCommandList(this.getApplication());
        for (int i2 = n; i2 >= 0; --i2) {
            AbstractOSRCommand abstractOSRCommand = abstractOSRCommandArray[i2].cancelCommand();
            if (abstractOSRCommand == null) continue;
            ((CommandList)oSRCommandList).add(abstractOSRCommand);
        }
        return oSRCommandList;
    }
}

