/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.lists.favorites.FavoritesActionListener;
import de.audi.tv.app.lists.favorites.FavoritesActionListener$1;

class FavoritesActionListener$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ FavoritesActionListener this$0;

    private FavoritesActionListener$ButtonListener(FavoritesActionListener favoritesActionListener) {
        this.this$0 = favoritesActionListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        if (n == 1722558208) {
            FavoritesActionListener.access$400(this.this$0).handleDeleteAllFavorites();
        }
    }

    /* synthetic */ FavoritesActionListener$ButtonListener(FavoritesActionListener favoritesActionListener, FavoritesActionListener$1 favoritesActionListener$1) {
        this(favoritesActionListener);
    }
}

