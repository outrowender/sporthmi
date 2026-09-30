/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.favorite;

import de.audi.atip.favorite.FavoriteListRow;
import java.io.Serializable;

public interface IFavoriteStorage
extends Serializable {
    public FavoriteListRow getFavoriteListRow();
}

