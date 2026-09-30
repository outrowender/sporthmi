/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface IAddToFavoriteOracle {
    public static final IAddToFavoriteOracle DEFAULT_IMPLEMENTATION = new IAddToFavoriteOracle(){

        public boolean isAddToFavorites(EvoListRow evoListRow, int n, int n2, int n3) {
            return false;
        }

        public boolean isTuneBeforeAddingToFavoritesRequired() {
            return true;
        }
    };

    public boolean isAddToFavorites(EvoListRow var1, int var2, int var3, int var4);

    public boolean isTuneBeforeAddingToFavoritesRequired();
}

