/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import org.dsi.ifc.tvtuner.ServiceInfo;

public interface IFavoriteActionHandler {
    public void handleDeleteFavorite(int var1);

    public void handleAddFavorite(int var1);

    public void handleAddFavorite(ServiceInfo var1);

    public void handleDeleteAllFavorites();
}

