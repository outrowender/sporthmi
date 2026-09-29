/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

import de.audi.atip.interapp.tv.TVStation;

public interface ITVFavoritesListener {
    public static final int NO_VALID_POSITION;

    default public void selectFavorite(TVStation tVStation) {
    }

    default public void stationAddedToFavorites(TVStation tVStation, int n) {
    }

    default public void stationRemovedFromFavorites(TVStation tVStation, int n) {
    }

    default public void allStationsRemovedFromFavorites() {
    }

    default public void initializeFavorites(TVStation[] tVStationArray) {
    }
}

