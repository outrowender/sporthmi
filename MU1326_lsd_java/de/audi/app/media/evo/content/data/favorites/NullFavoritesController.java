/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesBrowserList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.data.favorites.IMediaFavoriteListListener;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.evo.content.data.favorites.NullFavoritesController$1;
import de.audi.app.media.source.ISourceSlot;

public class NullFavoritesController
implements IFavoritesController {
    @Override
    public void addFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
    }

    @Override
    public void removeFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
    }

    @Override
    public IFavoritesBrowserList getFavoriteBrowserList() {
        return new NullFavoritesController$1(this);
    }

    @Override
    public void updateFavorite(MediaFavorite mediaFavorite) {
    }

    @Override
    public void listChanged(FavoritesList favoritesList) {
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void activate(ISourceSlot iSourceSlot) {
    }

    @Override
    public void deactivate() {
    }

    @Override
    public void update(byte by, ISourceSlot iSourceSlot) {
    }

    @Override
    public void setPlayer(IPlayer iPlayer) {
    }
}

