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
    public void addFavoriteListListener(IMediaFavoriteListListener var1);

    public void removeFavoriteListListener(IMediaFavoriteListListener var1);

    public IFavoritesBrowserList getFavoriteBrowserList();

    public void updateFavorite(MediaFavorite var1);

    public void listChanged(FavoritesList var1);

    public void init();

    public void deinit();

    public void activate(ISourceSlot var1);

    public void deactivate();

    public void update(byte var1, ISourceSlot var2);

    public void setPlayer(IPlayer var1);
}

