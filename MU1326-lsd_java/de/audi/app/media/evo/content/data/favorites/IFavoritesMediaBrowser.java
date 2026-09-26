/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.IFavoriteSelectionListener;
import de.audi.app.media.source.ISourceSlot;

public interface IFavoritesMediaBrowser
extends IFavoriteSelectionListener {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void activate(ISourceSlot iSourceSlot) {
    }

    default public void deactivate() {
    }
}

