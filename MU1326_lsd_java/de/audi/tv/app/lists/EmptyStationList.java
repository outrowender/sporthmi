/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import java.util.List;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

class EmptyStationList
implements IStationList {
    EmptyStationList() {
    }

    public SelectedItem getSelected() {
        return null;
    }

    public void markFavorites(long[] lArray) {
    }

    public void unmarkFavorites(long[] lArray) {
    }

    public AbstractTVStationRow getRowByIndex(int n) {
        return null;
    }

    public BaseListModelApp getEmptyTmpList() {
        return null;
    }

    public BaseListModelApp getTmpList() {
        return null;
    }

    public AbstractTVStationRow getTmpStation() {
        return null;
    }

    public void updateSelectionInList(BaseListModelApp baseListModelApp, IFavoritesList iFavoritesList) {
    }

    public void setStationList(List list, IFavoritesList iFavoritesList) {
    }

    public void updateSelectedProgram(ProgramInfo programInfo, boolean bl) {
    }

    public void updateSelectedService(ServiceInfo serviceInfo, boolean bl) {
    }

    public ServiceInfo getServiceForUniqueID(long l) {
        return null;
    }

    public ServiceInfo[] getServices() {
        return new ServiceInfo[0];
    }

    public ServiceInfo[] getScanList() {
        return new ServiceInfo[0];
    }

    public void updateStationLogos(LogoInfo[] logoInfoArray) {
    }

    public void updateServiceLinking(boolean bl) {
    }
}

