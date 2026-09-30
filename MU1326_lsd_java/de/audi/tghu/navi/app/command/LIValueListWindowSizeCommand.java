/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class LIValueListWindowSizeCommand
extends NavCommand {
    private final int windowsize;

    public LIValueListWindowSizeCommand(int n) {
        this.windowsize = n;
    }

    public void execute() {
        this.getDSINavigation().liValueListWindowSize(this.windowsize);
        this.getCommandList().commandFinished();
    }
}

