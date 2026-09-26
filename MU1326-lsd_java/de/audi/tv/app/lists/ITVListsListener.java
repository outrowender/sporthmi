/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.AbstractTVStationRow;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface ITVListsListener {
    default public void updateFavoritesListSize(int n) {
    }

    default public void updateStationList() {
    }

    default public void updateFavoritesList() {
    }

    default public void updateSelectedStation(AbstractTVStationRow abstractTVStationRow) {
    }

    default public void favoriteAdded() {
    }

    default public void favoritesCleared() {
    }

    default public void addFavoriteRequested(ServiceInfo serviceInfo) {
    }
}

