/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface IFavoritesList {
    default public void addFavorite(ServiceInfo serviceInfo, long l, boolean bl) {
    }

    default public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray, long l) {
    }

    default public ServiceInfo getServiceByIndex(int n) {
    }

    default public void removeService(long l) {
    }

    default public void clearList(boolean bl) {
    }

    default public ServiceInfo[] getServices() {
    }

    default public ServiceInfo[] getServicesFromMemory() {
    }

    default public long[] getFavoritesIDs() {
    }

    default public boolean updateSelectedProgram(ProgramInfo programInfo) {
    }

    default public boolean updateSelectedService(ServiceInfo serviceInfo) {
    }

    default public ServiceInfo getServiceForUniqueID(long l) {
    }

    default public long getFavoriteID(ServiceInfo serviceInfo) {
    }

    default public void updateStationLogos(LogoInfo[] logoInfoArray) {
    }
}

