/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.command.Command;
import de.audi.tghu.online.app.Online;

public class AbortionErrorCommand
extends Command {
    public AbortionErrorCommand() {
        super(Online.getInstance().getOperatorCallLogChannel());
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "AbortionErrorCommand#execute: this is a dummy error command, that does nothing except tracing this log");
    }
}

