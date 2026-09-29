/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractCommand;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.AbortionErrorCommand;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;

public class DialNumberCommand
extends AbstractCommand {
    private TelephoneHandler telHandler;

    public DialNumberCommand(TelephoneHandler telephoneHandler, AbstractOperatorCall abstractOperatorCall) {
        super(abstractOperatorCall, "DialNumber");
        this.telHandler = telephoneHandler;
    }

    @Override
    public void execute() {
        if (this.listener.getServiceType() == 1 && !this.listener.isTelephoneReady() && !this.isChina()) {
            this.listener.setCallStarted(false);
            this.listener.replyToSDS(8);
            this.getCmdList().commandAborted("DialNumberCommand#execute: phone is not ready -> abort!", "DialNumberCommand#execute: phone is not ready -> abort!");
            return;
        }
        if (!this.listener.isAnotherCallRunning()) {
            this.listener.setDialingNumberTriggered(true);
            this.telHandler.dialNumber(this.listener);
        } else {
            this.listener.setCallRunning(false);
            this.listener.replyToSDS(4);
            this.listener.leaveJokerKeyMode();
            this.getCmdList().setErrorCommand(new AbortionErrorCommand());
            this.getCmdList().commandAborted("DialNumberCommand#execute: a private call is running. Nothing to do", "DialNumberCommand#execute: a private call is running. Nothing to do");
        }
    }

    private boolean isChina() {
        return this.listener.getCommandListManager().getFramework().getSysConst(442) == 2;
    }
}

