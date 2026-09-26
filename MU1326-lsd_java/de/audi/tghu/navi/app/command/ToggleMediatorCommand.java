/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.command.NavCommand;

public class ToggleMediatorCommand
extends NavCommand {
    private int modelID;

    public ToggleMediatorCommand(int n) {
        this.modelID = n;
    }

    @Override
    public void execute() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(this.modelID);
        if (choiceModelApp != null) {
            this.logger.log(-2137614336, "ToggleMediatorCommand#execute() - toggle mediator: %1", (long)this.modelID);
            int n = choiceModelApp.getValue();
            int n2 = n == 0 ? 1 : 0;
            choiceModelApp.setValue(n2);
        } else {
            this.logger.log(-1601830656, "ToggleMediatorCommand#execute() - failed to resolve modelID: %1", (long)this.modelID);
        }
        this.getCommandList().commandFinished();
    }
}

