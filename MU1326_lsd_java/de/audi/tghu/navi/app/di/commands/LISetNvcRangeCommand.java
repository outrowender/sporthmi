/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class LISetNvcRangeCommand
extends NavCommand {
    private final int nvcRange;

    public LISetNvcRangeCommand(int n) {
        this.nvcRange = n;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute - nvcRange=%2", (Object)this.CLASS_NAME, (long)this.nvcRange);
        this.getDSINavigation().liSetNVCRange(this.nvcRange);
    }

    public void liResult(long l) {
        this.logger.log(10000000, "%1#liResult - returnCode=%2", (Object)this.CLASS_NAME, l);
        if (l == 0L) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }
}

