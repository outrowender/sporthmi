/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite.d5;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.favorite.d5.FavoriteStore;

class FavoriteStore$NotifyObserversCommand
extends NavCommand {
    private final /* synthetic */ FavoriteStore this$0;

    public FavoriteStore$NotifyObserversCommand(FavoriteStore favoriteStore) {
        this.this$0 = favoriteStore;
        super("notify observers");
    }

    @Override
    public void execute() {
        FavoriteStore.access$000(this.this$0);
        this.getCommandList().commandFinished();
    }
}

