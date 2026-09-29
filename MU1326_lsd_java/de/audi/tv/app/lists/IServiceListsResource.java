/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import java.util.List;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface IServiceListsResource {
    default public ServiceInfo[] getNewFavorites() {
    }

    default public ServiceInfo[] getOldFavorites() {
    }

    default public ServiceInfo[] getNewServiceList() {
    }

    default public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray) {
    }

    default public void addFavorite(ServiceInfo serviceInfo, long l) {
    }

    default public void clearFavorites() {
    }

    default public void removeFavorite(ServiceInfo serviceInfo, long l) {
    }

    default public void markFavorites(long[] lArray) {
    }

    default public void unmarkFavorites(long[] lArray) {
    }

    default public long[] getFavoritesIDs() {
    }

    default public void loadFavoritesFromMemory() {
    }

    default public List createNewStationList(ServiceInfo[] serviceInfoArray, long[] lArray, long[] lArray2) {
    }

    default public void setStationList(List list) {
    }

    default public ProgramInfo getSelectedProgram() {
    }

    default public void setSelectedProgram(ProgramInfo programInfo) {
    }

    default public ServiceInfo getSelectedService() {
    }

    default public void setSelectedService(ServiceInfo serviceInfo) {
    }

    default public void updateLogoList(LogoInfo[] logoInfoArray) {
    }
}

