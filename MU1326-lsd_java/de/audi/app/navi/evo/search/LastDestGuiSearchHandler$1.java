/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.LastDestGuiSearchHandler;
import de.audi.tghu.navi.app.command.NavCommand;

class LastDestGuiSearchHandler$1
extends NavCommand {
    private final /* synthetic */ LastDestGuiSearchHandler this$0;

    LastDestGuiSearchHandler$1(LastDestGuiSearchHandler lastDestGuiSearchHandler, String string) {
        this.this$0 = lastDestGuiSearchHandler;
        super(string);
    }

    @Override
    public void execute() {
        LastDestGuiSearchHandler.access$000(this.this$0).setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

