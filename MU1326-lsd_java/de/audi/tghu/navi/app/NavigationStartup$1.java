/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationStartup;
import de.audi.tghu.navi.app.command.NavCommand;

class NavigationStartup$1
extends NavCommand {
    private final /* synthetic */ NavigationStartup this$0;

    NavigationStartup$1(NavigationStartup navigationStartup, String string) {
        this.this$0 = navigationStartup;
        super(string);
    }

    @Override
    public void execute() {
        NavigationStartup.access$000(this.this$0).taskCompleted(4);
        CommandList commandList = this.navigation.getRouteManager().evaluateGuidanceStatus();
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

