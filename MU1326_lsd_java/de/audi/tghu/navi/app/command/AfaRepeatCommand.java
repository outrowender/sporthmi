/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class AfaRepeatCommand
extends NavCommand {
    private int source;

    public AfaRepeatCommand(int n) {
        this.source = n;
    }

    public void execute() {
        this.logger.log(1000000, "AfaRepeatCommand#execute() - calling afaRepeat( %1 ) ", (long)this.source);
        this.getDSINavigation().afaRepeat(this.source);
        this.getCommandList().commandFinished();
    }
}

