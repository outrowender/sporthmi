/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.AbstractStationList;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IListContentSupplier;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.NormAreaSublist;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.favorites.FavoritesActionListener;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.storage.FavoriteListSaver;
import de.audi.tv.app.storage.TVStorage;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVFavoritesList
extends AbstractStationList
implements IFavoritesList,
IListContentSupplier {
    private static final int LOAD_MODE = 0;
    private static final int MOVE_MODE = 1;
    private int operationMode = 0;
    private AbstractTVStationRow moveRow;
    private int moveIndex;
    public final DefaultTVListener tvListener = new TVListenerImpl();
    public final DSICallListener callListener = new CallListener();
    private final FavoriteListSaver listSaver;
    private final NormAreaSublist normAreaSublist;
    public List favoritesListeners = new ArrayList(4);
    private final StationMapper mapper;
    private final FavoritesActionListener.FavoriteMoveModeListener moveModeListener;
    private ProgramInfo activeProgram = null;
    static /* synthetic */ Class class$de$audi$tv$app$lists$TVFavoritesList;

    public TVFavoritesList(TVEnv tVEnv, TVStorage tVStorage, DSITV dSITV, StationMapper stationMapper, NormAreaSublist normAreaSublist, FavoritesActionListener.FavoriteMoveModeListener favoriteMoveModeListener) {
        super(tVEnv, tVStorage, dSITV, 2600045, (class$de$audi$tv$app$lists$TVFavoritesList == null ? (class$de$audi$tv$app$lists$TVFavoritesList = TVFavoritesList.class$("de.audi.tv.app.lists.TVFavoritesList")) : class$de$audi$tv$app$lists$TVFavoritesList).getName());
        this.listSaver = new FavoriteListSaver(tVEnv.framework, this, tVStorage);
        this.mapper = stationMapper;
        this.stationList.setListener(new ListListener());
        OptionListener optionListener = new OptionListener();
        tVEnv.getOptionModel(2600091).setListener(optionListener, 2600045);
        this.normAreaSublist = normAreaSublist;
        this.moveModeListener = favoriteMoveModeListener;
    }

    public void registerFavoritesListener(ITVListsListener iTVListsListener) {
        this.favoritesListeners.add(iTVListsListener);
        iTVListsListener.updateFavoritesListSize(this.stationList.getLength());
        iTVListsListener.updateFavoritesList();
    }

    public void updateListSize() {
        for (int i2 = 0; i2 < this.favoritesListeners.size(); ++i2) {
            ITVListsListener iTVListsListener = (ITVListsListener)this.favoritesListeners.get(i2);
            iTVListsListener.updateFavoritesListSize(this.stationList.getLength());
            iTVListsListener.updateFavoritesList();
        }
    }

    public void updateList() {
        for (int i2 = 0; i2 < this.favoritesListeners.size(); ++i2) {
            ITVListsListener iTVListsListener = (ITVListsListener)this.favoritesListeners.get(i2);
            iTVListsListener.updateFavoritesList();
        }
    }

    public void favoritesCleared() {
        for (int i2 = 0; i2 < this.favoritesListeners.size(); ++i2) {
            ITVListsListener iTVListsListener = (ITVListsListener)this.favoritesListeners.get(i2);
            iTVListsListener.favoritesCleared();
        }
    }

    public void favoriteAdded() {
        for (int i2 = 0; i2 < this.favoritesListeners.size(); ++i2) {
            ITVListsListener iTVListsListener = (ITVListsListener)this.favoritesListeners.get(i2);
            iTVListsListener.favoriteAdded();
        }
    }

    public void resetToDefault() {
        this.clearList(true);
    }

    public ServiceInfo[] getServices() {
        BaseListModelApp baseListModelApp = this.stationList.getCopy();
        ServiceInfo[] serviceInfoArray = new ServiceInfo[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            serviceInfoArray[i2] = ((AbstractTVStationRow)baseListModelApp.getRow((int)i2)).service;
        }
        return serviceInfoArray;
    }

    public ServiceInfo[] getServicesFromMemory() {
        return this.storage.loadMemoryList();
    }

    public long[] getFavoritesIDs() {
        long[] lArray = new long[this.stationList.getLength()];
        for (int i2 = 0; i2 < this.stationList.getLength(); ++i2) {
            lArray[i2] = this.stationList.getRow(i2).getUniqueID();
        }
        return lArray;
    }

    protected synchronized void updateSelection(BaseListModelApp baseListModelApp, ServiceInfo serviceInfo, ProgramInfo programInfo) {
        long l = this.mapper.getServiceID(serviceInfo);
        if (programInfo != null) {
            this.evaluateProgramInfo(baseListModelApp, programInfo, new long[]{l});
        }
        this.stationList.setSelectedUniqueID(l);
    }

    public void removeService(long l) {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRowByUniqueID(l);
        this.env.lcMain.log(10000000, "[TVFavoritesList.removeService] %1", (Object)abstractTVStationRow.service);
        this.stationList.remove(abstractTVStationRow);
        this.normAreaSublist.remove(abstractTVStationRow.service);
        this.updateSelection(this.stationList, this.activeProgram.serviceInfo, null);
        this.updateListSize();
        this.listSaver.save();
    }

    public void clearList(boolean bl) {
        this.stationList.removeAll();
        this.normAreaSublist.clear();
        if (!bl) {
            this.favoritesCleared();
        }
        this.updateListSize();
        this.listSaver.save();
    }

    public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray, long l) {
        BaseListModelApp baseListModelApp = this.stationList.getEmptyCopy();
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            AbstractTVStationRow abstractTVStationRow = this.env.getRowFactory().createTVStationRow(lArray[i2], serviceInfoArray[i2], 0);
            abstractTVStationRow.makeFavorite(true);
            this.env.lcMain.log(10000000, "[TVFavoritesList.addService] %1", (Object)abstractTVStationRow);
            baseListModelApp.append(abstractTVStationRow);
        }
        baseListModelApp.setSelectedUniqueID(l);
        this.stationList.update(baseListModelApp);
        this.listSaver.save();
        this.updateListSize();
    }

    public void addFavorite(ServiceInfo serviceInfo, long l, boolean bl) {
        if (serviceInfo != null && this.getFavoriteID(l) == 0L) {
            BaseListModelApp baseListModelApp = this.stationList.getCopy();
            AbstractTVStationRow abstractTVStationRow = this.env.getRowFactory().createTVStationRow(l, serviceInfo, 0);
            abstractTVStationRow.makeFavorite(true);
            this.env.lcMain.log(10000000, "[TVFavoritesList.addService] %2, selected: %1", bl, (Object)abstractTVStationRow);
            baseListModelApp.append(abstractTVStationRow);
            if (bl) {
                baseListModelApp.setSelectedUniqueID(l);
                if (this.mapper.getServiceID(this.activeProgram.serviceInfo) == l) {
                    this.evaluateProgramInfo(this.stationList, this.activeProgram, new long[]{l});
                }
            }
            this.normAreaSublist.add(serviceInfo);
            this.stationList.update(baseListModelApp);
            this.listSaver.save();
            this.favoriteAdded();
            this.updateListSize();
        }
    }

    public ServiceInfo getServiceByIndex(int n) {
        AbstractTVStationRow abstractTVStationRow = this.getRowByIndex(n);
        if (abstractTVStationRow == null) {
            return null;
        }
        return abstractTVStationRow.service;
    }

    public AbstractTVStationRow getRowByIndex(int n) {
        return (AbstractTVStationRow)this.stationList.getRow(n);
    }

    public boolean updateSelectedProgram(ProgramInfo programInfo) {
        boolean bl;
        this.activeProgram = TVUtil.getClonedProgramInfo(programInfo);
        long l = this.getFavoriteID(programInfo.serviceInfo);
        boolean bl2 = bl = l > 0L;
        if (bl) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRowByUniqueID(l);
            this.activeProgram.serviceInfo = abstractTVStationRow.service;
            this.updateSelection(this.stationList, this.activeProgram.serviceInfo, this.activeProgram);
            this.setCASstatus(programInfo.casStatus);
        } else {
            this.stationList.setSelectedIndex(-1);
        }
        return bl;
    }

    public boolean updateSelectedService(ServiceInfo serviceInfo) {
        boolean bl;
        long l = this.getFavoriteID(serviceInfo);
        boolean bl2 = bl = l > 0L;
        if (bl) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRowByUniqueID(l);
            ServiceInfo serviceInfo2 = abstractTVStationRow.service;
            this.updateSelection(this.stationList, serviceInfo2, null);
            this.setMuteStatus(0);
            this.setCASstatus(0);
        } else {
            this.stationList.setSelectedIndex(-1);
        }
        return bl;
    }

    public long getFavoriteID(ServiceInfo serviceInfo) {
        long l = this.mapper.getServiceID(serviceInfo);
        return this.getFavoriteID(l);
    }

    private long getFavoriteID(long l) {
        long[] lArray = this.getFavoritesIDs();
        Long[] longArray = this.mapper.getMatchingNamePidServiceIDs(l);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            for (int i3 = 0; i3 < longArray.length; ++i3) {
                if (longArray[i3] != lArray[i2]) continue;
                return longArray[i3];
            }
        }
        return 0L;
    }

    public ServiceInfo getServiceForUniqueID(long l) {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRowByUniqueID(l);
        if (abstractTVStationRow == null) {
            return null;
        }
        return abstractTVStationRow.service;
    }

    public int getIndexForUniqueID(long l) {
        return this.stationList.getIndexForUniqueID(this.getFavoriteID(l));
    }

    public BaseListModelApp getTmpList() {
        return this.stationList.getCopy();
    }

    public SelectedItem getSelected() {
        return this.stationList.getSelected();
    }

    public void updateStationLogos(LogoInfo[] logoInfoArray) {
    }

    private void deactivateMoveMode(BaseListModelApp baseListModelApp) {
        baseListModelApp.trigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
        this.moveModeListener.leaveMoveMode();
        this.operationMode = 0;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class CallListener
    extends DSICallListener {
        private CallListener() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            TVFavoritesList.this.deactivateMoveMode(TVFavoritesList.this.stationList);
        }
    }

    private class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            if (TVFavoritesList.this.operationMode == 0) {
                TVFavoritesList.this.env.lcHMI.log(100000000, "[TVFavoritesList.itemSelected] [%2] %1", (Object)evoListRow, (long)n2);
                TVFavoritesList.this.dsi.changeService(((AbstractTVStationRow)evoListRow).service, true);
                TVFavoritesList.this.stationList.fireEvent(n4);
            } else if (n2 != TVFavoritesList.this.moveIndex) {
                TVFavoritesList.this.env.lcMain.log(10000000, "[TVFavoritesList.itemSelected] move favorite from index %1 to index %2 .", (long)TVFavoritesList.this.moveIndex, (long)n2);
                BaseListModelApp baseListModelApp = TVFavoritesList.this.stationList.getCopy();
                long l = evoListRow.getUniqueID();
                if (n2 < TVFavoritesList.this.moveIndex) {
                    baseListModelApp.remove(TVFavoritesList.this.moveRow);
                    baseListModelApp.insertBefore(l, TVFavoritesList.this.moveRow);
                } else if (n2 > TVFavoritesList.this.moveIndex) {
                    baseListModelApp.remove(TVFavoritesList.this.moveRow);
                    baseListModelApp.insertAfter(l, TVFavoritesList.this.moveRow);
                }
                TVFavoritesList.this.deactivateMoveMode(baseListModelApp);
                TVFavoritesList.this.stationList.update(baseListModelApp);
                TVFavoritesList.this.updateList();
                TVFavoritesList.this.listSaver.save();
            } else {
                TVFavoritesList.this.deactivateMoveMode(TVFavoritesList.this.stationList);
            }
        }
    }

    private class OptionListener
    extends DefaultOptionListener {
        private OptionListener() {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
            if (n == 2600091) {
                TVFavoritesList.this.env.lcMain.log(10000000, "[TVFavoritesList.itemSelected] entering favorite move mode.");
                TVFavoritesList.this.operationMode = 1;
                TVFavoritesList.this.moveRow = (AbstractTVStationRow)TVFavoritesList.this.stationList.getRow(n3);
                TVFavoritesList.this.moveIndex = TVFavoritesList.this.stationList.getIndexForUniqueID(TVFavoritesList.this.moveRow.getUniqueID());
                TVFavoritesList.this.moveModeListener.enterMoveMode();
                TVFavoritesList.this.stationList.trigger(ModelTrigger.ACTIVATE_MOVE_MODE);
            }
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        public void updateMuteState(int n) {
            TVFavoritesList.this.setMuteStatus(n);
        }
    }
}

