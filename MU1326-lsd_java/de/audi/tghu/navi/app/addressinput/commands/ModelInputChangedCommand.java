/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;

public class ModelInputChangedCommand
extends NavCommand {
    private IMatchspellerModelAccess modelAccess;

    public ModelInputChangedCommand(IMatchspellerModelAccess iMatchspellerModelAccess) {
        this.modelAccess = iMatchspellerModelAccess;
    }

    @Override
    public void execute() {
        this.modelAccess.onInputChanged();
        this.getCommandList().commandFinished();
    }
}

