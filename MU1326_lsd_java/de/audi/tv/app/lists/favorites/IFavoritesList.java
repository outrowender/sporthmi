/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface IFavoritesList {
    public void addFavorite(ServiceInfo var1, long var2, boolean var4);

    public void setFavorites(ServiceInfo[] var1, long[] var2, long var3);

    public ServiceInfo getServiceByIndex(int var1);

    public void removeService(long var1);

    public void clearList(boolean var1);

    public ServiceInfo[] getServices();

    public ServiceInfo[] getServicesFromMemory();

    public long[] getFavoritesIDs();

    public boolean updateSelectedProgram(ProgramInfo var1);

    public boolean updateSelectedService(ServiceInfo var1);

    public ServiceInfo getServiceForUniqueID(long var1);

    public long getFavoriteID(ServiceInfo var1);

    public void updateStationLogos(LogoInfo[] var1);
}

