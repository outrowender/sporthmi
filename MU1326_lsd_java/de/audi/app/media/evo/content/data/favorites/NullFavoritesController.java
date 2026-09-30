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
import de.audi.app.media.source.ISourceSlot;

public class NullFavoritesController
implements IFavoritesController {
    public void addFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
    }

    public void removeFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
    }

    public IFavoritesBrowserList getFavoriteBrowserList() {
        return new IFavoritesBrowserList(){

            public void selectFavoriteEntry(int n) {
            }
        };
    }

    public void updateFavorite(MediaFavorite mediaFavorite) {
    }

    public void listChanged(FavoritesList favoritesList) {
    }

    public void init() {
    }

    public void deinit() {
    }

    public void activate(ISourceSlot iSourceSlot) {
    }

    public void deactivate() {
    }

    public void update(byte by, ISourceSlot iSourceSlot) {
    }

    public void setPlayer(IPlayer iPlayer) {
    }
}

