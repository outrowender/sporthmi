/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.AbstractTVStationRow;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface ITVListsListener {
    public void updateFavoritesListSize(int var1);

    public void updateStationList();

    public void updateFavoritesList();

    public void updateSelectedStation(AbstractTVStationRow var1);

    public void favoriteAdded();

    public void favoritesCleared();

    public void addFavoriteRequested(ServiceInfo var1);
}

