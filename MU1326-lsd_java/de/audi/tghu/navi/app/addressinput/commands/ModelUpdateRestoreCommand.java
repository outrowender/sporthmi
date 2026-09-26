/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.IRestorableModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;

public class ModelUpdateRestoreCommand
extends NavCommand {
    private final IRestorableModelAccess modelAccess;

    public ModelUpdateRestoreCommand(IRestorableModelAccess iRestorableModelAccess) {
        this.modelAccess = iRestorableModelAccess;
    }

    @Override
    public void execute() {
        this.modelAccess.onRestore();
        this.getCommandList().commandFinished();
    }
}

