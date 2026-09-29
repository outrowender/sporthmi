/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.lists.favorites.FavoritesActionListener;
import de.audi.tv.app.lists.favorites.FavoritesActionListener$1;

class FavoritesActionListener$OptionListener
extends DefaultOptionListener {
    private final /* synthetic */ FavoritesActionListener this$0;

    private FavoritesActionListener$OptionListener(FavoritesActionListener favoritesActionListener) {
        this.this$0 = favoritesActionListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (n4 == 2) {
            SelectedItem selectedItem = FavoritesActionListener.access$300(this.this$0).getSelected();
            if (selectedItem != null) {
                FavoritesActionListener.access$400(this.this$0).handleDeleteFavorite(selectedItem.getIndex());
            }
        } else if (n == 1739335424) {
            FavoritesActionListener.access$400(this.this$0).handleDeleteFavorite(n3);
        }
    }

    /* synthetic */ FavoritesActionListener$OptionListener(FavoritesActionListener favoritesActionListener, FavoritesActionListener$1 favoritesActionListener$1) {
        this(favoritesActionListener);
    }
}

