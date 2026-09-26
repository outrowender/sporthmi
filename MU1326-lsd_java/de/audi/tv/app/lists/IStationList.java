/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import java.util.List;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface IStationList {
    default public SelectedItem getSelected() {
    }

    default public void markFavorites(long[] lArray) {
    }

    default public void unmarkFavorites(long[] lArray) {
    }

    default public AbstractTVStationRow getRowByIndex(int n) {
    }

    default public BaseListModelApp getEmptyTmpList() {
    }

    default public BaseListModelApp getTmpList() {
    }

    default public AbstractTVStationRow getTmpStation() {
    }

    default public ServiceInfo[] getServices() {
    }

    default public ServiceInfo[] getScanList() {
    }

    default public void updateSelectionInList(BaseListModelApp baseListModelApp, IFavoritesList iFavoritesList) {
    }

    default public void setStationList(List list, IFavoritesList iFavoritesList) {
    }

    default public void updateSelectedProgram(ProgramInfo programInfo, boolean bl) {
    }

    default public void updateSelectedService(ServiceInfo serviceInfo, boolean bl) {
    }

    default public ServiceInfo getServiceForUniqueID(long l) {
    }

    default public void updateStationLogos(LogoInfo[] logoInfoArray) {
    }

    default public void updateServiceLinking(boolean bl) {
    }
}

