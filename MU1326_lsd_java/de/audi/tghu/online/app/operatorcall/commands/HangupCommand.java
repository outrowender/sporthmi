/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractCommand;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;

public class HangupCommand
extends AbstractCommand {
    private TelephoneHandler telHandler;

    public HangupCommand(AbstractOperatorCall abstractOperatorCall, String string) {
        super(abstractOperatorCall, string);
    }

    public HangupCommand(TelephoneHandler telephoneHandler, AbstractOperatorCall abstractOperatorCall) {
        super(abstractOperatorCall, "Hangup");
        this.telHandler = telephoneHandler;
    }

    @Override
    public void execute() {
        this.telHandler.hangUp();
    }
}

