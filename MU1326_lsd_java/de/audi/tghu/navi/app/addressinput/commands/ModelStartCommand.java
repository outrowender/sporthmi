/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;

public class ModelStartCommand
extends NavCommand {
    private IMatchspellerModelAccess modelAccess;

    public ModelStartCommand(IMatchspellerModelAccess iMatchspellerModelAccess) {
        this.modelAccess = iMatchspellerModelAccess;
    }

    public void execute() {
        this.modelAccess.onStart(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

