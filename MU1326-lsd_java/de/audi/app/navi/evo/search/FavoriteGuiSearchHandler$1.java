/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.FavoriteGuiSearchHandler;
import de.audi.tghu.navi.app.command.NavCommand;

class FavoriteGuiSearchHandler$1
extends NavCommand {
    private final /* synthetic */ FavoriteGuiSearchHandler this$0;

    FavoriteGuiSearchHandler$1(FavoriteGuiSearchHandler favoriteGuiSearchHandler, String string) {
        this.this$0 = favoriteGuiSearchHandler;
        super(string);
    }

    @Override
    public void execute() {
        FavoriteGuiSearchHandler.access$000(this.this$0).setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

