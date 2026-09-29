/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.NavigationStartup;
import de.audi.tghu.navi.app.command.NavCommand;

class NavigationStartup$2
extends NavCommand {
    private final /* synthetic */ NavigationStartup this$0;

    NavigationStartup$2(NavigationStartup navigationStartup, String string) {
        this.this$0 = navigationStartup;
        super(string);
    }

    @Override
    public void execute() {
        this.navigation.getOperationManager().taskCompleted(8);
        this.navigation.getOperationManager().setNavigationMainInitialized(true);
        this.getCommandList().commandFinished();
    }
}

