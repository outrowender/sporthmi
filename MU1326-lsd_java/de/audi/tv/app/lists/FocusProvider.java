/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.AbstractStationList;
import de.audi.tv.app.lists.IFocusProvider;
import de.audi.tv.app.lists.TVFavoritesList;
import de.audi.tv.app.lists.TVStationList;

public class FocusProvider
implements IFocusProvider {
    private final TVStationList stationList;
    private final TVFavoritesList favoritesList;

    public FocusProvider(TVStationList tVStationList, TVFavoritesList tVFavoritesList) {
        this.stationList = tVStationList;
        this.favoritesList = tVFavoritesList;
    }

    @Override
    public AbstractStationList getFocusedList(int n) {
        return n == 0 ? this.stationList : this.favoritesList;
    }
}

