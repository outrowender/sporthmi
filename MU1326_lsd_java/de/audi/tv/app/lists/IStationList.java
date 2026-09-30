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
    public SelectedItem getSelected();

    public void markFavorites(long[] var1);

    public void unmarkFavorites(long[] var1);

    public AbstractTVStationRow getRowByIndex(int var1);

    public BaseListModelApp getEmptyTmpList();

    public BaseListModelApp getTmpList();

    public AbstractTVStationRow getTmpStation();

    public ServiceInfo[] getServices();

    public ServiceInfo[] getScanList();

    public void updateSelectionInList(BaseListModelApp var1, IFavoritesList var2);

    public void setStationList(List var1, IFavoritesList var2);

    public void updateSelectedProgram(ProgramInfo var1, boolean var2);

    public void updateSelectedService(ServiceInfo var1, boolean var2);

    public ServiceInfo getServiceForUniqueID(long var1);

    public void updateStationLogos(LogoInfo[] var1);

    public void updateServiceLinking(boolean var1);
}

