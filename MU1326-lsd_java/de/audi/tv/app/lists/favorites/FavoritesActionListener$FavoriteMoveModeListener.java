/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import de.audi.tv.app.lists.favorites.FavoritesActionListener;
import de.audi.tv.app.lists.favorites.FavoritesActionListener$1;

public class FavoritesActionListener$FavoriteMoveModeListener {
    private final /* synthetic */ FavoritesActionListener this$0;

    private FavoritesActionListener$FavoriteMoveModeListener(FavoritesActionListener favoritesActionListener) {
        this.this$0 = favoritesActionListener;
        FavoritesActionListener.access$500(favoritesActionListener).setValue(0);
    }

    public void enterMoveMode() {
        FavoritesActionListener.access$500(this.this$0).setValue(1);
    }

    public void leaveMoveMode() {
        FavoritesActionListener.access$500(this.this$0).setValue(0);
    }

    /* synthetic */ FavoritesActionListener$FavoriteMoveModeListener(FavoritesActionListener favoritesActionListener, FavoritesActionListener$1 favoritesActionListener$1) {
        this(favoritesActionListener);
    }
}

