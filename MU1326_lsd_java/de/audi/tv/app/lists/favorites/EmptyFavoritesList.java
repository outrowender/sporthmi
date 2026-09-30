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
    public void addFavorite(ServiceInfo serviceInfo, long l, boolean bl) {
    }

    public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray, long l) {
    }

    public ServiceInfo getServiceByIndex(int n) {
        return null;
    }

    public void removeService(long l) {
    }

    public void clearList(boolean bl) {
    }

    public ServiceInfo[] getServices() {
        return new ServiceInfo[0];
    }

    public ServiceInfo[] getServicesFromMemory() {
        return new ServiceInfo[0];
    }

    public long[] getFavoritesIDs() {
        return new long[0];
    }

    public boolean updateSelectedProgram(ProgramInfo programInfo) {
        return false;
    }

    public boolean updateSelectedService(ServiceInfo serviceInfo) {
        return false;
    }

    public ServiceInfo getServiceForUniqueID(long l) {
        return null;
    }

    public void updateStationLogos(LogoInfo[] logoInfoArray) {
    }

    public long getFavoriteID(ServiceInfo serviceInfo) {
        return 0L;
    }
}

