/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesBrowserList;
import de.audi.app.media.evo.content.data.favorites.IMediaFavoriteListListener;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.source.ISourceSlot;

public interface IFavoritesController {
    default public void addFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
    }

    default public void removeFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
    }

    default public IFavoritesBrowserList getFavoriteBrowserList() {
    }

    default public void updateFavorite(MediaFavorite mediaFavorite) {
    }

    default public void listChanged(FavoritesList favoritesList) {
    }

    default public void init() {
    }

    default public void deinit() {
    }

    default public void activate(ISourceSlot iSourceSlot) {
    }

    default public void deactivate() {
    }

    default public void update(byte by, ISourceSlot iSourceSlot) {
    }

    default public void setPlayer(IPlayer iPlayer) {
    }
}

