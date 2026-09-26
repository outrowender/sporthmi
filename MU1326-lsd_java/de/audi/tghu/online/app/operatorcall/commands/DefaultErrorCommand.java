/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.command.Command;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;

public class DefaultErrorCommand
extends Command {
    private AbstractModelHandler modelHandler;

    public DefaultErrorCommand(AbstractModelHandler abstractModelHandler) {
        super(Online.getInstance().getOperatorCallLogChannel());
        this.modelHandler = abstractModelHandler;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "DefaultErrorCommand#execute: executing started!");
        this.modelHandler.showDefaultError(true, 1);
    }
}

