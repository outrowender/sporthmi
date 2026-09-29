/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class LISPCancelSpellerCommand
extends NavCommand {
    private boolean liResultResponded = false;
    private boolean isSpellerActiveResponded = false;

    @Override
    public void execute() {
        if (this.dsiResponseContainer.isLiIsSpellerActive()) {
            this.logger.log(-2137614336, "LISPCancelSpellerCommand#execute() - calling lispCancelSpeller() ");
            this.getDSINavigation().lispCancelSpeller();
        } else {
            this.getCommandList().commandFinished();
        }
    }

    private void checkFinished() {
        if (this.isSpellerActiveResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl) {
        this.logger.log(-2137614336, "LISPCancelSpellerCommand#updateLispIsSpellerActive( %1 ) ", bl);
        super.updateLispIsSpellerActive(bl);
        this.isSpellerActiveResponded = true;
        this.checkFinished();
    }

    @Override
    public void liResult(long l) {
        this.logger.log(-2137614336, "LISPCancelSpellerCommand#liResult( %1 ) ", l);
        super.liResult(l);
        this.liResultResponded = true;
        this.checkFinished();
    }
}

