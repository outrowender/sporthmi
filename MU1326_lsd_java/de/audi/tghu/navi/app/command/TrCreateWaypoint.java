/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TrCreateWaypoint
extends NavCommand {
    public void execute() {
        this.getDSINavigation().trCreateWaypoint();
        this.getCommandList().commandFinished();
    }
}

