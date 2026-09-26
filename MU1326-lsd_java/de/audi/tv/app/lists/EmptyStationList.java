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

    @Override
    public SelectedItem getSelected() {
        return null;
    }

    @Override
    public void markFavorites(long[] lArray) {
    }

    @Override
    public void unmarkFavorites(long[] lArray) {
    }

    @Override
    public AbstractTVStationRow getRowByIndex(int n) {
        return null;
    }

    @Override
    public BaseListModelApp getEmptyTmpList() {
        return null;
    }

    @Override
    public BaseListModelApp getTmpList() {
        return null;
    }

    @Override
    public AbstractTVStationRow getTmpStation() {
        return null;
    }

    @Override
    public void updateSelectionInList(BaseListModelApp baseListModelApp, IFavoritesList iFavoritesList) {
    }

    @Override
    public void setStationList(List list, IFavoritesList iFavoritesList) {
    }

    @Override
    public void updateSelectedProgram(ProgramInfo programInfo, boolean bl) {
    }

    @Override
    public void updateSelectedService(ServiceInfo serviceInfo, boolean bl) {
    }

    @Override
    public ServiceInfo getServiceForUniqueID(long l) {
        return null;
    }

    @Override
    public ServiceInfo[] getServices() {
        return new ServiceInfo[0];
    }

    @Override
    public ServiceInfo[] getScanList() {
        return new ServiceInfo[0];
    }

    @Override
    public void updateStationLogos(LogoInfo[] logoInfoArray) {
    }

    @Override
    public void updateServiceLinking(boolean bl) {
    }
}

