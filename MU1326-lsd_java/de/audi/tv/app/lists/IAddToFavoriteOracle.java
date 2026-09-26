/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.lists.IAddToFavoriteOracle$1;

public interface IAddToFavoriteOracle {
    public static final IAddToFavoriteOracle DEFAULT_IMPLEMENTATION = new IAddToFavoriteOracle$1();

    default public boolean isAddToFavorites(EvoListRow evoListRow, int n, int n2, int n3) {
    }

    default public boolean isTuneBeforeAddingToFavoritesRequired() {
    }
}

