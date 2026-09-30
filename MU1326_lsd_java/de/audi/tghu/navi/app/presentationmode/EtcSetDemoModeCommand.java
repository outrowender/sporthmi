/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.presentationmode;

import de.audi.tghu.navi.app.command.NavCommand;

public class EtcSetDemoModeCommand
extends NavCommand {
    private boolean etcDemoMode;

    public EtcSetDemoModeCommand(boolean bl) {
        this.etcDemoMode = bl;
    }

    public void execute() {
        if (this.dsiResponseContainer.isEtcDemoMode() != this.etcDemoMode) {
            this.logger.log(1000000, "ETCSetDemoMode#execute() - calling etcSetDemoMode() ");
            this.getDSINavigation().etcSetDemoMode(this.etcDemoMode);
        } else {
            this.getCommandList().commandFinished();
        }
    }

    public void updateEtcDemoModeState(boolean bl) {
        this.env.getLogChannel().log(1000000, "EtcSetDemoModeCommand#updateEtcDemoModeState() - DemoMode in ResponseContainer set to = %1", bl);
        this.dsiResponseContainer.setEtcDemoMode(bl);
        this.getCommandList().commandFinished();
    }
}

