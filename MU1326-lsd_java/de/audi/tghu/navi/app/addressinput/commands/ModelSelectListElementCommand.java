/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;

public class ModelSelectListElementCommand
extends NavCommand {
    private IMatchspellerModelAccess modelAccess;

    public ModelSelectListElementCommand(IMatchspellerModelAccess iMatchspellerModelAccess) {
        this.modelAccess = iMatchspellerModelAccess;
    }

    @Override
    public void execute() {
        this.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

