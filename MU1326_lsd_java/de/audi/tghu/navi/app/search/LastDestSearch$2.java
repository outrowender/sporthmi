/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.search.LastDestSearch;

class LastDestSearch$2
extends NavCommand {
    private final /* synthetic */ LastDestSearch this$0;

    LastDestSearch$2(LastDestSearch lastDestSearch) {
        this.this$0 = lastDestSearch;
    }

    @Override
    public void execute() {
        this.this$0.languageChanged();
        this.getCommandList().commandFinished();
    }
}

