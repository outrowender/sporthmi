/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

import de.audi.atip.interapp.tv.TVStation;
import org.dsi.ifc.tvtuner.LogoInfo;

public interface ITVFavoritesService {
    public void addServiceToFavorites(TVStation var1);

    public int highlightSelectedStation(TVStation var1);

    public void removeServiceFromFavorites(TVStation var1);

    public void removeAllServicesFromFavorites();

    public void updateServiceLogos(LogoInfo[] var1);

    public void removeAllSeviceLogos();

    public void cancelStoreMode();
}

