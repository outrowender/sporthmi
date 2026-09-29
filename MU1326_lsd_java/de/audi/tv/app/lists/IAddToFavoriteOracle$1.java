/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.lists.IAddToFavoriteOracle;

final class IAddToFavoriteOracle$1
implements IAddToFavoriteOracle {
    IAddToFavoriteOracle$1() {
    }

    @Override
    public boolean isAddToFavorites(EvoListRow evoListRow, int n, int n2, int n3) {
        return false;
    }

    @Override
    public boolean isTuneBeforeAddingToFavoritesRequired() {
        return true;
    }
}

