/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.AbstractStationList;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.IAddToFavoriteOracle;
import de.audi.tv.app.lists.IListContentSupplier;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.storage.TVStorage;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVStationList
extends AbstractStationList
implements IStationList,
IListContentSupplier {
    private static final int REMOVE_TIMER_DELAY = 30000;
    public final DefaultTVListener tvListener = new TVListenerImpl();
    public final ISettingListener settingListener = new SettingListener();
    private TmpStationRemover tmpStationRemover = null;
    private Object removeMutex = new Object();
    private List stationListeners = new ArrayList(2);
    private final StationMapper mapper;
    private volatile boolean isServiceLinkingActive = true;
    private volatile int stationListSorting = 0;
    private IAddToFavoriteOracle addToFavoriteOracle = IAddToFavoriteOracle.DEFAULT_IMPLEMENTATION;
    private ProgramInfo activeProgram = null;
    static /* synthetic */ Class class$de$audi$tv$app$lists$TVStationList;

    public TVStationList(TVEnv tVEnv, TVStorage tVStorage, DSITV dSITV, StationMapper stationMapper) {
        super(tVEnv, tVStorage, dSITV, 2600000, (class$de$audi$tv$app$lists$TVStationList == null ? (class$de$audi$tv$app$lists$TVStationList = TVStationList.class$("de.audi.tv.app.lists.TVStationList")) : class$de$audi$tv$app$lists$TVStationList).getName());
        this.mapper = stationMapper;
        this.stationList.setListener(new ListListener());
    }

    public void resetToDefault() {
        BaseListModelApp baseListModelApp = this.stationList.getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(i2);
            abstractTVStationRow.updateLogo(null);
            baseListModelApp.setRow(i2, abstractTVStationRow);
        }
        this.stationList.update(baseListModelApp);
    }

    public void registerListener(ITVListsListener iTVListsListener) {
        this.stationListeners.add(iTVListsListener);
    }

    public void registerAddToFavoriteOracle(IAddToFavoriteOracle iAddToFavoriteOracle) {
        if (iAddToFavoriteOracle == null) {
            iAddToFavoriteOracle = IAddToFavoriteOracle.DEFAULT_IMPLEMENTATION;
        }
        this.addToFavoriteOracle = iAddToFavoriteOracle;
    }

    private void notifyUpdateList() {
        for (int i2 = 0; i2 < this.stationListeners.size(); ++i2) {
            ITVListsListener iTVListsListener = (ITVListsListener)this.stationListeners.get(i2);
            iTVListsListener.updateStationList();
        }
    }

    private void notifyUpdateSelectedStation(AbstractTVStationRow abstractTVStationRow) {
        for (int i2 = 0; i2 < this.stationListeners.size(); ++i2) {
            ITVListsListener iTVListsListener = (ITVListsListener)this.stationListeners.get(i2);
            iTVListsListener.updateSelectedStation(abstractTVStationRow);
        }
    }

    private void notifyAddFavoriteRequested(ServiceInfo serviceInfo) {
        for (int i2 = 0; i2 < this.stationListeners.size(); ++i2) {
            ITVListsListener iTVListsListener = (ITVListsListener)this.stationListeners.get(i2);
            iTVListsListener.addFavoriteRequested(serviceInfo);
        }
    }

    private AbstractTVStationRow getTemporaryService() {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRow(0);
        if (abstractTVStationRow != null && abstractTVStationRow.tmpAdded) {
            return abstractTVStationRow;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateSelection(BaseListModelApp baseListModelApp, ServiceInfo serviceInfo, ProgramInfo programInfo, boolean bl) {
        long l;
        AbstractTVStationRow abstractTVStationRow;
        if (serviceInfo == null) {
            baseListModelApp.setSelectedIndex(-1);
            this.env.lcMain.log(100000, "[TVStationList.updateSelection] service is null!");
            return;
        }
        SelectedItem selectedItem = baseListModelApp.getSelected();
        if (selectedItem != null) {
            AbstractTVStationRow abstractTVStationRow2 = (AbstractTVStationRow)baseListModelApp.getRowByUniqueID(selectedItem.getUniqueID());
            abstractTVStationRow2.resetProgramInfo();
            baseListModelApp.setRow(selectedItem.getIndex(), abstractTVStationRow2);
        }
        AbstractTVStationRow abstractTVStationRow3 = abstractTVStationRow = baseListModelApp.contains(l = this.getUniqueId(baseListModelApp, serviceInfo)) ? (abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRowByUniqueID(l)) : this.env.getRowFactory().createTVStationRow(l, serviceInfo, this.stationListSorting, true);
        if (bl) {
            abstractTVStationRow.makeFavorite(true);
        }
        AbstractTVStationRow abstractTVStationRow4 = this.getTemporaryService();
        Object object = this.removeMutex;
        synchronized (object) {
            if ((!baseListModelApp.contains(abstractTVStationRow.getUniqueID()) || abstractTVStationRow4 != null && abstractTVStationRow4.getUniqueID() == abstractTVStationRow.getUniqueID()) && this.tmpStationRemover != null) {
                this.tmpStationRemover.cancel();
                this.tmpStationRemover = null;
            }
        }
        this.addTunedRow(baseListModelApp, abstractTVStationRow);
        if (programInfo != null) {
            this.evaluateProgramInfo(baseListModelApp, programInfo, new long[]{l});
            abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRowByUniqueID(l);
        }
        if ((object = abstractTVStationRow.getProperties()) != null) {
            this.env.getPropertyModel(2600117).setProperties(((PropertyListCell)object).getCategory(), ((PropertyListCell)object).getProperties());
        }
        baseListModelApp.setSelectedUniqueID(abstractTVStationRow.getUniqueID());
        this.env.getChoiceModel(2600029).setValue(baseListModelApp.getSelected().getIndex());
        this.env.getChoiceModel(2600119).setValue(bl ? 1 : 0);
        Object object2 = this.removeMutex;
        synchronized (object2) {
            abstractTVStationRow4 = (AbstractTVStationRow)baseListModelApp.getRow(0);
            if (this.tmpStationRemover == null && abstractTVStationRow4 != null && abstractTVStationRow.getUniqueID() != abstractTVStationRow4.getUniqueID()) {
                this.tmpStationRemover = new TmpStationRemover();
                this.tmpStationRemover.activate();
            }
        }
    }

    private long getUniqueId(BaseListModelApp baseListModelApp, ServiceInfo serviceInfo) {
        long l = this.mapper.getServiceID(serviceInfo);
        if (this.isServiceLinkingActive && !baseListModelApp.contains(l)) {
            Long[] longArray = this.mapper.getMatchingNamePidServiceIDs(l);
            for (int i2 = 0; i2 < longArray.length; ++i2) {
                if (!baseListModelApp.contains(longArray[i2])) continue;
                l = longArray[i2];
                break;
            }
        }
        return l;
    }

    private void addTunedRow(BaseListModelApp baseListModelApp, AbstractTVStationRow abstractTVStationRow) {
        if (!baseListModelApp.contains(abstractTVStationRow.getUniqueID())) {
            if (baseListModelApp.getLength() == 0) {
                baseListModelApp.append(abstractTVStationRow);
            } else if (((AbstractTVStationRow)baseListModelApp.getRow((int)0)).tmpAdded) {
                baseListModelApp.setRow(0, abstractTVStationRow);
            } else {
                baseListModelApp.insertBefore(baseListModelApp.getRow(0).getUniqueID(), abstractTVStationRow);
            }
        }
    }

    public SelectedItem getSelected() {
        return this.stationList.getSelected();
    }

    public void markFavorites(long[] lArray) {
        this.changeFavoriteState(lArray, true);
    }

    public void unmarkFavorites(long[] lArray) {
        this.changeFavoriteState(lArray, false);
    }

    private void changeFavoriteState(long[] lArray, boolean bl) {
        BaseListModelApp baseListModelApp = this.stationList.getCopy();
        SelectedItem selectedItem = baseListModelApp.getSelected();
        int n = selectedItem != null ? selectedItem.getIndex() : -1;
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            Long[] longArray = this.mapper.getMatchingNamePidServiceIDs(lArray[i2]);
            for (int i3 = 0; i3 < longArray.length; ++i3) {
                int n2 = baseListModelApp.getIndexForUniqueID(longArray[i3]);
                if (n2 == -1) continue;
                AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(n2);
                abstractTVStationRow.makeFavorite(bl);
                baseListModelApp.setRow(n2, abstractTVStationRow);
                if (n2 != n) continue;
                PropertyListCell propertyListCell = abstractTVStationRow.getProperties();
                if (propertyListCell != null) {
                    this.env.getPropertyModel(2600117).setProperties(propertyListCell.getCategory(), propertyListCell.getProperties());
                }
                int n3 = bl ? 1 : 0;
                this.env.getChoiceModel(2600119).setValue(n3);
            }
        }
        this.stationList.update(baseListModelApp);
    }

    public AbstractTVStationRow getRowByIndex(int n) {
        return (AbstractTVStationRow)this.stationList.getRow(n);
    }

    public BaseListModelApp getEmptyTmpList() {
        return this.stationList.getEmptyCopy();
    }

    public AbstractTVStationRow getTmpStation() {
        return this.getTemporaryService();
    }

    public void setStationList(List list, IFavoritesList iFavoritesList) {
        BaseListModelApp baseListModelApp = this.stationList.getEmptyCopy();
        baseListModelApp.append((EvoListRow[])list.toArray(new EvoListRow[list.size()]));
        this.updateSelectionInList(baseListModelApp, iFavoritesList);
        this.stationList.update(baseListModelApp);
        this.updateErrorIcon();
        this.notifyUpdateList();
    }

    public int getStationListModelId() {
        return this.stationList.getID();
    }

    public void updateSelectionInList(BaseListModelApp baseListModelApp, IFavoritesList iFavoritesList) {
        ServiceInfo serviceInfo = this.storage.getTunedService();
        boolean bl = iFavoritesList.getFavoriteID(serviceInfo) != 0L;
        this.updateSelection(baseListModelApp, this.storage.getTunedService(), this.activeProgram, bl);
    }

    public void updateSelectedProgram(ProgramInfo programInfo, boolean bl) {
        this.activeProgram = programInfo;
        this.updateSelection(this.stationList, programInfo.serviceInfo, programInfo, bl);
        this.setCASstatus(programInfo.casStatus);
        this.notifyUpdateSelectedStation((AbstractTVStationRow)this.stationList.getRow(this.stationList.getSelected().getIndex()));
    }

    public void updateSelectedService(ServiceInfo serviceInfo, boolean bl) {
        this.updateSelection(this.stationList, serviceInfo, null, bl);
        this.setMuteStatus(0);
        this.setCASstatus(0);
    }

    public int getIndexForUniqueID(long l) {
        return this.stationList.getIndexForUniqueID(l);
    }

    public BaseListModelApp getTmpList() {
        return this.stationList.getCopy();
    }

    public ServiceInfo getServiceForUniqueID(long l) {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRowByUniqueID(l);
        if (abstractTVStationRow != null) {
            return abstractTVStationRow.service;
        }
        return null;
    }

    public ServiceInfo[] getServices() {
        BaseListModelApp baseListModelApp = this.getTmpList();
        ServiceInfo[] serviceInfoArray = new ServiceInfo[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            serviceInfoArray[i2] = ((AbstractTVStationRow)baseListModelApp.getRow((int)i2)).service;
        }
        return serviceInfoArray;
    }

    public ServiceInfo[] getScanList() {
        int n;
        BaseListModelApp baseListModelApp = this.getTmpList();
        ServiceInfo[] serviceInfoArray = new ServiceInfo[baseListModelApp.getLength()];
        SelectedItem selectedItem = baseListModelApp.getSelected();
        int n2 = selectedItem != null ? selectedItem.getIndex() + 1 : 0;
        int n3 = 0;
        for (n = n2; n < baseListModelApp.getLength(); ++n) {
            serviceInfoArray[n3] = ((AbstractTVStationRow)baseListModelApp.getRow((int)n)).service;
            ++n3;
        }
        for (n = 0; n < n2; ++n) {
            serviceInfoArray[n3] = ((AbstractTVStationRow)baseListModelApp.getRow((int)n)).service;
            ++n3;
        }
        return serviceInfoArray;
    }

    public void updateStationLogos(LogoInfo[] logoInfoArray) {
        BaseListModelApp baseListModelApp = this.getTmpList();
        block0: for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(i2);
            for (int i3 = 0; i3 < logoInfoArray.length; ++i3) {
                if (abstractTVStationRow.service.namePID != logoInfoArray[i3].namePID) continue;
                abstractTVStationRow.updateLogo(logoInfoArray[i3].channelLogo);
                baseListModelApp.setRow(i2, abstractTVStationRow);
                continue block0;
            }
        }
        this.stationList.update(baseListModelApp);
    }

    public void updateServiceLinking(boolean bl) {
        this.isServiceLinkingActive = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            TVStationList.this.env.lcHMI.log(10000000, "[TVStationList.itemSelected] [%2] %1", (Object)evoListRow, (long)n2);
            if (TVStationList.this.addToFavoriteOracle.isAddToFavorites(evoListRow, n, n2, n3)) {
                TVStationList.this.notifyAddFavoriteRequested(((AbstractTVStationRow)evoListRow).service);
            } else {
                TVStationList.this.dsi.changeService(((AbstractTVStationRow)evoListRow).service, true);
                TVStationList.this.stationList.fireEvent(n4);
            }
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            if (TVStationList.this.addToFavoriteOracle.isTuneBeforeAddingToFavoritesRequired()) {
                TVStationList.this.dsi.changeService(((AbstractTVStationRow)evoListRow).service, true);
            }
            TVStationList.this.notifyAddFavoriteRequested(((AbstractTVStationRow)evoListRow).service);
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        public void updateMuteState(int n) {
            TVStationList.this.setMuteStatus(n);
        }
    }

    private class SettingListener
    extends ISettingListener.Stub {
        private SettingListener() {
        }

        public void updateStationListSorting(int n) {
            TVStationList.this.stationListSorting = n;
        }
    }

    private class TmpStationRemover
    implements TimerListener {
        private final Timer timer = new Timer("tmpStationRemoveDelay", 30000L, true, this);
        private boolean canceled = false;

        private TmpStationRemover() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            Object object = TVStationList.this.removeMutex;
            synchronized (object) {
                if (!this.canceled) {
                    AbstractTVStationRow abstractTVStationRow = TVStationList.this.getTemporaryService();
                    if (abstractTVStationRow != null) {
                        SelectedItem selectedItem = TVStationList.this.stationList.getSelected();
                        TVStationList.this.stationList.remove(abstractTVStationRow);
                        if (selectedItem != null) {
                            TVStationList.this.stationList.setSelectedUniqueID(selectedItem.getUniqueID());
                        }
                        TVStationList.this.notifyUpdateList();
                    }
                    TVStationList.this.tmpStationRemover = null;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void cancelTimer(Timer timer) {
            Object object = TVStationList.this.removeMutex;
            synchronized (object) {
                this.canceled = true;
            }
        }

        public void activate() {
            this.timer.start();
        }

        public void cancel() {
            this.timer.cancel();
        }
    }
}

