/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.command.NavCommand;

class Navigation$2
extends NavCommand {
    private final /* synthetic */ Navigation this$0;

    Navigation$2(Navigation navigation, String string) {
        this.this$0 = navigation;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getFramework().getLanguageMgr().responseSetLanguage("LANG_COMPONENT_NAVI", true);
        this.getCommandList().commandFinished();
    }
}

