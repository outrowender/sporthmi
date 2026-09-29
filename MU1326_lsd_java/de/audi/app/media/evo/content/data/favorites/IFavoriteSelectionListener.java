/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.selection.IFavoritePlayerSelectionListener;

public interface IFavoriteSelectionListener {
    default public void playFavoriteSelection(MediaFavorite mediaFavorite, IFavoritePlayerSelectionListener iFavoritePlayerSelectionListener) {
    }
}

