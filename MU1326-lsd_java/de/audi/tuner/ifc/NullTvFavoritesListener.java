/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.tv.ITVFavoritesListener;
import de.audi.atip.interapp.tv.TVStation;
import de.audi.atip.log.LogChannel;

public class NullTvFavoritesListener
extends NullService
implements ITVFavoritesListener {
    public NullTvFavoritesListener(LogChannel logChannel) {
        super(logChannel, "NullTvFavoritesListener");
    }

    @Override
    public void selectFavorite(TVStation tVStation) {
        this.log();
    }

    @Override
    public void stationAddedToFavorites(TVStation tVStation, int n) {
        this.log();
    }

    @Override
    public void stationRemovedFromFavorites(TVStation tVStation, int n) {
        this.log();
    }

    @Override
    public void allStationsRemovedFromFavorites() {
        this.log();
    }

    @Override
    public void initializeFavorites(TVStation[] tVStationArray) {
        this.log();
    }
}

