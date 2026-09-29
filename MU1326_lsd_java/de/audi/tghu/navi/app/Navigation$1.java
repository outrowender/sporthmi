/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.command.NavCommand;

class Navigation$1
extends NavCommand {
    private final /* synthetic */ Navigation this$0;

    Navigation$1(Navigation navigation) {
        this.this$0 = navigation;
    }

    @Override
    public void execute() {
        this.env.getChoiceModel(170).setValue(0);
        this.env.getChoiceModel(170).setValue(3);
        this.getCommandList().commandFinished();
    }
}

