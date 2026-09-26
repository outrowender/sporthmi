/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

import de.audi.atip.interapp.tv.TVStation;
import org.dsi.ifc.tvtuner.LogoInfo;

public interface ITVFavoritesService {
    default public void addServiceToFavorites(TVStation tVStation) {
    }

    default public int highlightSelectedStation(TVStation tVStation) {
    }

    default public void removeServiceFromFavorites(TVStation tVStation) {
    }

    default public void removeAllServicesFromFavorites() {
    }

    default public void updateServiceLogos(LogoInfo[] logoInfoArray) {
    }

    default public void removeAllSeviceLogos() {
    }

    default public void cancelStoreMode() {
    }
}

