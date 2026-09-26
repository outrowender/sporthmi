/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.FavoritesList;

public interface IMediaFavoriteListListener {
    default public void listChanged(FavoritesList favoritesList) {
    }
}

