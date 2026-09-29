/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.presentationmode;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;

class DemoModeManager$3
extends NavCommand {
    private final /* synthetic */ DemoModeManager this$0;

    DemoModeManager$3(DemoModeManager demoModeManager) {
        this.this$0 = demoModeManager;
    }

    @Override
    public void execute() {
        boolean bl;
        boolean bl2 = this.dsiResponseContainer.isEtcDemoMode();
        boolean bl3 = this.dsiResponseContainer.isRgActive();
        boolean bl4 = bl = DemoModeManager.access$100(this.this$0) != null;
        if (!bl2 || !bl || bl3) {
            this.logger.log(-1601830656, "DemoModeManager#restartDemoModeRoute() - etcDemoMode: %1, demoModeRouteSet: %2, rgActive: %3 ", bl2, bl, bl3);
            this.getCommandList().commandAborted("Demo mode not longer active or RG restarted");
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

