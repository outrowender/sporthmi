/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class ETCSetDemoMode
extends NavCommand {
    private boolean etcDemoMode;

    public ETCSetDemoMode(boolean bl) {
        this.etcDemoMode = bl;
    }

    public void execute() {
        if (this.dsiResponseContainer.isEtcDemoMode() != this.etcDemoMode) {
            this.logger.log(1000000, "ETCSetDemoMode#execute() - calling etcSetDemoMode(%1) ", this.etcDemoMode);
            this.getDSINavigation().etcSetDemoMode(this.etcDemoMode);
        } else {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "ETCSetDemoMode#execute() - commandFinished without calling etcSetDemoMode (is already in the state it should be changed to) ", this.etcDemoMode);
            }
            this.getCommandList().commandFinished();
        }
    }

    public void updateEtcDemoModeState(boolean bl) {
        this.logger.log(1000000, "ETCSetDemoMode#updateEtcDemoModeState( %1 ) ", bl);
        super.updateEtcDemoModeState(bl);
        this.getCommandList().commandFinished();
    }
}

