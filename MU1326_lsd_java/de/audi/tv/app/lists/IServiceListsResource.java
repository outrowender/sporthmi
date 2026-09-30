/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import java.util.List;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface IServiceListsResource {
    public ServiceInfo[] getNewFavorites();

    public ServiceInfo[] getOldFavorites();

    public ServiceInfo[] getNewServiceList();

    public void setFavorites(ServiceInfo[] var1, long[] var2);

    public void addFavorite(ServiceInfo var1, long var2);

    public void clearFavorites();

    public void removeFavorite(ServiceInfo var1, long var2);

    public void markFavorites(long[] var1);

    public void unmarkFavorites(long[] var1);

    public long[] getFavoritesIDs();

    public void loadFavoritesFromMemory();

    public List createNewStationList(ServiceInfo[] var1, long[] var2, long[] var3);

    public void setStationList(List var1);

    public ProgramInfo getSelectedProgram();

    public void setSelectedProgram(ProgramInfo var1);

    public ServiceInfo getSelectedService();

    public void setSelectedService(ServiceInfo var1);

    public void updateLogoList(LogoInfo[] var1);
}

