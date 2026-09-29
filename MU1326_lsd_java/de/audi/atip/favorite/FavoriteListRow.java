/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.favorite;

import de.audi.atip.favorite.IFavoriteStorage;
import de.audi.atip.hmi.model.list.EvoListRow;

public abstract class FavoriteListRow
extends EvoListRow {
    public FavoriteListRow(long l, int n) {
        super(l, n);
    }

    public abstract IFavoriteStorage getIFavorite() {
    }
}

