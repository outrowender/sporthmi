/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
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
import de.audi.tv.app.lists.TVFavoritesList$CallListener;
import de.audi.tv.app.lists.TVFavoritesList$ListListener;
import de.audi.tv.app.lists.TVFavoritesList$OptionListener;
import de.audi.tv.app.lists.TVFavoritesList$TVListenerImpl;
import de.audi.tv.app.lists.favorites.FavoritesActionListener$FavoriteMoveModeListener;
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
    private static final int LOAD_MODE;
    private static final int MOVE_MODE;
    private int operationMode = 0;
    private AbstractTVStationRow moveRow;
    private int moveIndex;
    public final DefaultTVListener tvListener = new TVFavoritesList$TVListenerImpl(this, null);
    public final DSICallListener callListener = new TVFavoritesList$CallListener(this, null);
    private final FavoriteListSaver listSaver;
    private final NormAreaSublist normAreaSublist;
    public List favoritesListeners = new ArrayList(4);
    private final StationMapper mapper;
    private final FavoritesActionListener$FavoriteMoveModeListener moveModeListener;
    private ProgramInfo activeProgram = null;
    static /* synthetic */ Class class$de$audi$tv$app$lists$TVFavoritesList;

    public TVFavoritesList(TVEnv tVEnv, TVStorage tVStorage, DSITV dSITV, StationMapper stationMapper, NormAreaSublist normAreaSublist, FavoritesActionListener$FavoriteMoveModeListener favoriteMoveModeListener) {
        super(tVEnv, tVStorage, dSITV, 1839998720, (class$de$audi$tv$app$lists$TVFavoritesList == null ? (class$de$audi$tv$app$lists$TVFavoritesList = TVFavoritesList.class$("de.audi.tv.app.lists.TVFavoritesList")) : class$de$audi$tv$app$lists$TVFavoritesList).getName());
        this.listSaver = new FavoriteListSaver(tVEnv.framework, this, tVStorage);
        this.mapper = stationMapper;
        this.stationList.setListener(new TVFavoritesList$ListListener(this, null));
        TVFavoritesList$OptionListener tVFavoritesList$OptionListener = new TVFavoritesList$OptionListener(this, null);
        tVEnv.getOptionModel(-1683216640).setListener(tVFavoritesList$OptionListener, 1839998720);
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

    @Override
    public ServiceInfo[] getServices() {
        BaseListModelApp baseListModelApp = this.stationList.getCopy();
        ServiceInfo[] serviceInfoArray = new ServiceInfo[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            serviceInfoArray[i2] = ((AbstractTVStationRow)baseListModelApp.getRow((int)i2)).service;
        }
        return serviceInfoArray;
    }

    @Override
    public ServiceInfo[] getServicesFromMemory() {
        return this.storage.loadMemoryList();
    }

    @Override
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

    @Override
    public void removeService(long l) {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRowByUniqueID(l);
        this.env.lcMain.log(-2137614336, "[TVFavoritesList.removeService] %1", (Object)abstractTVStationRow.service);
        this.stationList.remove(abstractTVStationRow);
        this.normAreaSublist.remove(abstractTVStationRow.service);
        this.updateSelection(this.stationList, this.activeProgram.serviceInfo, null);
        this.updateListSize();
        this.listSaver.save();
    }

    @Override
    public void clearList(boolean bl) {
        this.stationList.removeAll();
        this.normAreaSublist.clear();
        if (!bl) {
            this.favoritesCleared();
        }
        this.updateListSize();
        this.listSaver.save();
    }

    @Override
    public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray, long l) {
        BaseListModelApp baseListModelApp = this.stationList.getEmptyCopy();
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            AbstractTVStationRow abstractTVStationRow = this.env.getRowFactory().createTVStationRow(lArray[i2], serviceInfoArray[i2], 0);
            abstractTVStationRow.makeFavorite(true);
            this.env.lcMain.log(-2137614336, "[TVFavoritesList.addService] %1", (Object)abstractTVStationRow);
            baseListModelApp.append(abstractTVStationRow);
        }
        baseListModelApp.setSelectedUniqueID(l);
        this.stationList.update(baseListModelApp);
        this.listSaver.save();
        this.updateListSize();
    }

    @Override
    public void addFavorite(ServiceInfo serviceInfo, long l, boolean bl) {
        if (serviceInfo != null && this.getFavoriteID(l) == 0L) {
            BaseListModelApp baseListModelApp = this.stationList.getCopy();
            AbstractTVStationRow abstractTVStationRow = this.env.getRowFactory().createTVStationRow(l, serviceInfo, 0);
            abstractTVStationRow.makeFavorite(true);
            this.env.lcMain.log(-2137614336, "[TVFavoritesList.addService] %2, selected: %1", bl, (Object)abstractTVStationRow);
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

    @Override
    public ServiceInfo getServiceByIndex(int n) {
        AbstractTVStationRow abstractTVStationRow = this.getRowByIndex(n);
        if (abstractTVStationRow == null) {
            return null;
        }
        return abstractTVStationRow.service;
    }

    @Override
    public AbstractTVStationRow getRowByIndex(int n) {
        return (AbstractTVStationRow)this.stationList.getRow(n);
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public ServiceInfo getServiceForUniqueID(long l) {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRowByUniqueID(l);
        if (abstractTVStationRow == null) {
            return null;
        }
        return abstractTVStationRow.service;
    }

    @Override
    public int getIndexForUniqueID(long l) {
        return this.stationList.getIndexForUniqueID(this.getFavoriteID(l));
    }

    @Override
    public BaseListModelApp getTmpList() {
        return this.stationList.getCopy();
    }

    @Override
    public SelectedItem getSelected() {
        return this.stationList.getSelected();
    }

    @Override
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

    static /* synthetic */ void access$400(TVFavoritesList tVFavoritesList, BaseListModelApp baseListModelApp) {
        tVFavoritesList.deactivateMoveMode(baseListModelApp);
    }

    static /* synthetic */ int access$502(TVFavoritesList tVFavoritesList, int n) {
        tVFavoritesList.operationMode = n;
        return tVFavoritesList.operationMode;
    }

    static /* synthetic */ AbstractTVStationRow access$602(TVFavoritesList tVFavoritesList, AbstractTVStationRow abstractTVStationRow) {
        tVFavoritesList.moveRow = abstractTVStationRow;
        return tVFavoritesList.moveRow;
    }

    static /* synthetic */ int access$702(TVFavoritesList tVFavoritesList, int n) {
        tVFavoritesList.moveIndex = n;
        return tVFavoritesList.moveIndex;
    }

    static /* synthetic */ AbstractTVStationRow access$600(TVFavoritesList tVFavoritesList) {
        return tVFavoritesList.moveRow;
    }

    static /* synthetic */ FavoritesActionListener$FavoriteMoveModeListener access$800(TVFavoritesList tVFavoritesList) {
        return tVFavoritesList.moveModeListener;
    }

    static /* synthetic */ int access$500(TVFavoritesList tVFavoritesList) {
        return tVFavoritesList.operationMode;
    }

    static /* synthetic */ int access$700(TVFavoritesList tVFavoritesList) {
        return tVFavoritesList.moveIndex;
    }

    static /* synthetic */ FavoriteListSaver access$900(TVFavoritesList tVFavoritesList) {
        return tVFavoritesList.listSaver;
    }
}

