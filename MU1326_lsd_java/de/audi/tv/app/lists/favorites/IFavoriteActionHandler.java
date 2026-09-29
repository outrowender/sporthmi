/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import org.dsi.ifc.tvtuner.ServiceInfo;

public interface IFavoriteActionHandler {
    default public void handleDeleteFavorite(int n) {
    }

    default public void handleAddFavorite(int n) {
    }

    default public void handleAddFavorite(ServiceInfo serviceInfo) {
    }

    default public void handleDeleteAllFavorites() {
    }
}

