/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.IFavoriteSelectionListener;
import de.audi.app.media.source.ISourceSlot;

public interface IFavoritesMediaBrowser
extends IFavoriteSelectionListener {
    public void init();

    public void deinit();

    public void activate(ISourceSlot var1);

    public void deactivate();
}

