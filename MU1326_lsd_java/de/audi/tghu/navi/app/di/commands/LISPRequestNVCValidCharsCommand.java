/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class LISPRequestNVCValidCharsCommand
extends NavCommand {
    private final int nvcRange;
    private final int offset;
    private final int windowSize;
    private boolean lispRequestNVCListResultResponsed = false;
    private boolean liResultResponsed = false;

    public LISPRequestNVCValidCharsCommand(int n, int n2, int n3) {
        this.nvcRange = n;
        this.offset = n2;
        this.windowSize = n3;
    }

    public void execute() {
        this.logger.log(10000000, "LISPRequestNVCValidCharsCommand#execute() with nvcRange = %1, offset = %2, windowSize = %3", (long)this.nvcRange, (long)this.offset, (long)this.windowSize);
        this.getDSINavigation().lispRequestNVCList(this.nvcRange, this.offset, this.windowSize);
    }

    public void liResult(long l) {
        this.logger.log(10000000, "LISPRequestNVCValidCharsCommand#liResult - returnCode=%1", l);
        if (l == 0L) {
            this.liResultResponsed = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    private void checkFinished() {
        if (this.lispRequestNVCListResultResponsed && this.liResultResponsed) {
            this.getCommandList().commandFinished();
        }
    }

    public void lispRequestNVCListResult(int n, String string, int n2) {
        this.logger.log(10000000, "LISPRequestNVCValidCharsCommand#lispRequestNVCListResult - validCharacters=%1, totalCount = %2", (Object)string, (long)n2);
        this.dsiResponseContainer.setNextValidCharsAndCount(string, n2);
        this.lispRequestNVCListResultResponsed = true;
        this.checkFinished();
    }
}

