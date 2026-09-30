/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

import de.audi.atip.interapp.tv.TVStation;

public interface ITVFavoritesListener {
    public static final int NO_VALID_POSITION = -1;

    public void selectFavorite(TVStation var1);

    public void stationAddedToFavorites(TVStation var1, int var2);

    public void stationRemovedFromFavorites(TVStation var1, int var2);

    public void allStationsRemovedFromFavorites();

    public void initializeFavorites(TVStation[] var1);
}

