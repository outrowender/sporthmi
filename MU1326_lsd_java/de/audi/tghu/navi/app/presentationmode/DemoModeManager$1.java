/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.presentationmode;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;

class DemoModeManager$1
extends NavCommand {
    private final /* synthetic */ DemoModeManager this$0;

    DemoModeManager$1(DemoModeManager demoModeManager, String string) {
        this.this$0 = demoModeManager;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.stopCurrentDemoModeGuidance();
        this.getCommandList().commandFinished();
    }
}

