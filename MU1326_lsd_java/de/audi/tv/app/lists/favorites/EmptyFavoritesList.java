/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import de.audi.tv.app.lists.favorites.IFavoritesList;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class EmptyFavoritesList
implements IFavoritesList {
    @Override
    public void addFavorite(ServiceInfo serviceInfo, long l, boolean bl) {
    }

    @Override
    public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray, long l) {
    }

    @Override
    public ServiceInfo getServiceByIndex(int n) {
        return null;
    }

    @Override
    public void removeService(long l) {
    }

    @Override
    public void clearList(boolean bl) {
    }

    @Override
    public ServiceInfo[] getServices() {
        return new ServiceInfo[0];
    }

    @Override
    public ServiceInfo[] getServicesFromMemory() {
        return new ServiceInfo[0];
    }

    @Override
    public long[] getFavoritesIDs() {
        return new long[0];
    }

    @Override
    public boolean updateSelectedProgram(ProgramInfo programInfo) {
        return false;
    }

    @Override
    public boolean updateSelectedService(ServiceInfo serviceInfo) {
        return false;
    }

    @Override
    public ServiceInfo getServiceForUniqueID(long l) {
        return null;
    }

    @Override
    public void updateStationLogos(LogoInfo[] logoInfoArray) {
    }

    @Override
    public long getFavoriteID(ServiceInfo serviceInfo) {
        return 0L;
    }
}

