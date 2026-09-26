/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.presentationmode;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;

class DemoModeManager$2
extends NavCommand {
    private final /* synthetic */ DemoModeManager this$0;

    DemoModeManager$2(DemoModeManager demoModeManager, String string) {
        this.this$0 = demoModeManager;
        super(string);
    }

    @Override
    public void execute() {
        DemoModeManager.access$000(this.this$0).updateDemoModeState(this.env.getContainer().isEtcDemoMode());
        this.getCommandList().commandFinished();
    }
}

