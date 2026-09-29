/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TriggerNavigationRestartCommand
extends NavCommand {
    @Override
    public void execute() {
        this.getDSINavigation(0).etcTriggerNavigationRestart(1);
        this.getCommandList().commandFinished();
    }
}

