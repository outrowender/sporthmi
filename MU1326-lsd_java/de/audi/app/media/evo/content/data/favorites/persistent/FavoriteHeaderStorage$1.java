/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites.persistent;

import de.audi.app.media.evo.content.data.favorites.persistent.FavoriteHeaderData;
import de.audi.app.media.evo.content.data.favorites.persistent.FavoriteHeaderStorage;
import java.util.Comparator;

class FavoriteHeaderStorage$1
implements Comparator {
    private final /* synthetic */ FavoriteHeaderStorage this$0;

    FavoriteHeaderStorage$1(FavoriteHeaderStorage favoriteHeaderStorage) {
        this.this$0 = favoriteHeaderStorage;
    }

    @Override
    public int compare(Object object, Object object2) {
        FavoriteHeaderData favoriteHeaderData = (FavoriteHeaderData)object;
        FavoriteHeaderData favoriteHeaderData2 = (FavoriteHeaderData)object2;
        if (favoriteHeaderData.getLastUsed() < favoriteHeaderData2.getLastUsed()) {
            return 1;
        }
        if (favoriteHeaderData.getLastUsed() > favoriteHeaderData2.getLastUsed()) {
            return -1;
        }
        return 0;
    }
}

