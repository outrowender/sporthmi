/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.cmd.ITVCmdManager;
import de.audi.tv.app.cmd.TVCmdManager;
import de.audi.tv.app.cmd.TVCommandList;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.EmptyStationList;
import de.audi.tv.app.lists.IServiceListsResource;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.LogoList;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.favorites.EmptyFavoritesList;
import de.audi.tv.app.lists.favorites.IFavoriteActionHandler;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.settings.ISettingListener;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class ServiceListsResource
implements IServiceListsResource,
IFavoriteActionHandler {
    public static final int TV_FULLSCREEN_ID = 2;
    private IStationList stationList = new EmptyStationList();
    private IFavoritesList favoritesList = new EmptyFavoritesList();
    private final LogoList logoList;
    public final ISettingListener settingListener = new SettingListener();
    private ServiceInfo[] favoritesToAdd = new ServiceInfo[0];
    private ServiceInfo[] favoritesToRemove = new ServiceInfo[0];
    private ServiceInfo[] updatedServices = new ServiceInfo[0];
    private ProgramInfo selectedProgram = null;
    private ServiceInfo selectedService = null;
    private volatile int stationListSorting = 0;
    private final ITVCmdManager cmdManager;
    private final LogChannel log;
    private final StationMapper mapper;
    private final TVEnv env;
    public final TVListenerImpl tvListener = new TVListenerImpl();
    public final DSICallListener selectServiceListener = new SelectServiceListener();
    public final SelectedServiceDebouncedListener selectionListener = new SelectedServiceDebouncedListener();

    public ServiceListsResource(TVEnv tVEnv, TVCmdManager tVCmdManager, StationMapper stationMapper, LogoList logoList) {
        this.env = tVEnv;
        this.log = tVEnv.lcMain;
        this.cmdManager = tVCmdManager;
        this.mapper = stationMapper;
        this.logoList = logoList;
    }

    public void registerStationList(IStationList iStationList) {
        this.stationList = iStationList;
    }

    public void registerFavoritesList(IFavoritesList iFavoritesList) {
        this.favoritesList = iFavoritesList;
        this.log.log(1000000, "[ServiceListsResource.registerFavoritesList] loading favorites from memory.");
        OptionListener optionListener = new OptionListener();
        this.env.getOptionModel(2600048).setListener(optionListener, 2600000);
        this.env.getOptionModel(2600048).setCustomIDListener(optionListener, 2);
        TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
        tVCommandList.add(this.cmdManager.createLoadFavoritesCmd(this));
        tVCommandList.add(this.cmdManager.createSetFavoritesCmd(this, this.mapper));
        this.cmdManager.enqueue(tVCommandList);
    }

    public void registerFavoritesList(IFavoritesList iFavoritesList, ServiceInfo[] serviceInfoArray) {
        this.favoritesList = iFavoritesList;
        this.setFavoritesToAdd(serviceInfoArray);
        this.log.log(1000000, "[ServiceListsResource.registerFavoritesList] loading given favorites.");
        TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
        tVCommandList.add(this.cmdManager.createSetFavoritesCmd(this, this.mapper));
        this.cmdManager.enqueue(tVCommandList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceInfo[] getNewFavorites() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ServiceInfo[] serviceInfoArray = this.favoritesToAdd;
            this.favoritesToAdd = new ServiceInfo[0];
            return serviceInfoArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceInfo[] getOldFavorites() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ServiceInfo[] serviceInfoArray = this.favoritesToRemove;
            this.favoritesToRemove = new ServiceInfo[0];
            return serviceInfoArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceInfo[] getNewServiceList() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ServiceInfo[] serviceInfoArray = this.updatedServices;
            this.updatedServices = new ServiceInfo[0];
            return serviceInfoArray;
        }
    }

    public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray) {
        SelectedItem selectedItem = this.stationList.getSelected();
        long l = selectedItem != null ? selectedItem.getUniqueID() : -1L;
        this.favoritesList.setFavorites(serviceInfoArray, lArray, l);
    }

    public void addFavorite(ServiceInfo serviceInfo, long l) {
        SelectedItem selectedItem = this.stationList.getSelected();
        long l2 = selectedItem != null ? selectedItem.getUniqueID() : -1L;
        boolean bl = l2 == l;
        this.favoritesList.addFavorite(serviceInfo, l, bl);
        if (bl) {
            this.setSelectedService(serviceInfo);
        }
    }

    public void clearFavorites() {
        this.favoritesList.clearList(false);
    }

    public void removeFavorite(ServiceInfo serviceInfo, long l) {
        this.favoritesList.removeService(l);
    }

    public void markFavorites(long[] lArray) {
        this.stationList.markFavorites(lArray);
        this.logoList.addFavoriteNamePids(this.mapper.getNamePidForUniqueIds(lArray));
    }

    public void unmarkFavorites(long[] lArray) {
        this.stationList.unmarkFavorites(lArray);
        this.logoList.removeFavoriteNamePids(this.mapper.getNamePidForUniqueIds(lArray));
    }

    public long[] getFavoritesIDs() {
        long[] lArray = this.favoritesList.getFavoritesIDs();
        ArrayList arrayList = new ArrayList(lArray.length);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            Long[] longArray = this.mapper.getMatchingNamePidServiceIDs(lArray[i2]);
            for (int i3 = 0; i3 < longArray.length; ++i3) {
                arrayList.add(longArray[i3]);
            }
        }
        long[] lArray2 = new long[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); ++i4) {
            lArray2[i4] = (Long)arrayList.get(i4);
        }
        return lArray2;
    }

    public void loadFavoritesFromMemory() {
        ServiceInfo[] serviceInfoArray = this.favoritesList.getServicesFromMemory();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            arrayList.add(serviceInfoArray[i2]);
        }
        this.setFavoritesToAdd((ServiceInfo[])arrayList.toArray(new ServiceInfo[arrayList.size()]));
    }

    public List createNewStationList(ServiceInfo[] serviceInfoArray, long[] lArray, long[] lArray2) {
        ArrayList arrayList = new ArrayList(serviceInfoArray.length);
        AbstractTVStationRow abstractTVStationRow = this.stationList.getTmpStation();
        int n = this.stationListSorting;
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            AbstractTVStationRow abstractTVStationRow2 = this.env.getRowFactory().createTVStationRow(lArray[i2], serviceInfoArray[i2], n);
            abstractTVStationRow2.updateLogo(this.logoList.getLogoForNamePID(serviceInfoArray[i2].namePID));
            abstractTVStationRow2 = this.checkIfRowIsFavorite(abstractTVStationRow2, lArray[i2], lArray2);
            arrayList.add(abstractTVStationRow2);
            if (abstractTVStationRow == null || abstractTVStationRow.getUniqueID() != lArray[i2]) continue;
            abstractTVStationRow = null;
        }
        if (abstractTVStationRow != null) {
            abstractTVStationRow = this.checkIfRowIsFavorite(abstractTVStationRow, abstractTVStationRow.getUniqueID(), lArray2);
            arrayList.add(0, abstractTVStationRow);
        }
        return arrayList;
    }

    public void setStationList(List list) {
        this.stationList.setStationList(list, this.favoritesList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ProgramInfo getSelectedProgram() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ProgramInfo programInfo = this.selectedProgram;
            this.selectedProgram = null;
            return programInfo;
        }
    }

    public void setSelectedProgram(ProgramInfo programInfo) {
        if (programInfo != null) {
            boolean bl = this.favoritesList.updateSelectedProgram(programInfo);
            this.stationList.updateSelectedProgram(programInfo, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceInfo getSelectedService() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ServiceInfo serviceInfo = this.selectedService;
            this.selectedService = null;
            return serviceInfo;
        }
    }

    public void setSelectedService(ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            boolean bl = this.favoritesList.updateSelectedService(serviceInfo);
            this.stationList.updateSelectedService(serviceInfo, bl);
        }
    }

    public void updateLogoList(LogoInfo[] logoInfoArray) {
        this.stationList.updateStationLogos(logoInfoArray);
        this.favoritesList.updateStationLogos(logoInfoArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setFavoritesToAdd(ServiceInfo[] serviceInfoArray) {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            this.favoritesToAdd = this.addToArray(this.favoritesToAdd, serviceInfoArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setFavoritesToRemove(ServiceInfo[] serviceInfoArray) {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            this.favoritesToRemove = this.addToArray(this.favoritesToRemove, serviceInfoArray);
        }
    }

    private AbstractTVStationRow checkIfRowIsFavorite(AbstractTVStationRow abstractTVStationRow, long l, long[] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (l != lArray[i2]) continue;
            abstractTVStationRow.makeFavorite(true);
            return abstractTVStationRow;
        }
        return abstractTVStationRow;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setUpdatedServices(ServiceInfo[] serviceInfoArray) {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            this.updatedServices = this.addToArray(this.updatedServices, serviceInfoArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setProgram(ProgramInfo programInfo) {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            this.selectedProgram = programInfo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setService(ServiceInfo serviceInfo) {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            this.selectedService = serviceInfo;
        }
    }

    private ServiceInfo[] addToArray(ServiceInfo[] serviceInfoArray, ServiceInfo[] serviceInfoArray2) {
        ServiceInfo[] serviceInfoArray3 = new ServiceInfo[serviceInfoArray.length + serviceInfoArray2.length];
        System.arraycopy((Object)serviceInfoArray, 0, (Object)serviceInfoArray3, 0, serviceInfoArray.length);
        System.arraycopy((Object)serviceInfoArray2, 0, (Object)serviceInfoArray3, serviceInfoArray.length, serviceInfoArray2.length);
        return serviceInfoArray3;
    }

    public void handleDeleteFavorite(ServiceInfo serviceInfo) {
        this.setFavoritesToRemove(new ServiceInfo[]{serviceInfo});
        this.log.log(1000000, "[ServiceListsResource.handleDeleteFavorite] removing favorite: %1", (Object)serviceInfo);
        TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
        tVCommandList.add(this.cmdManager.createRemoveFavoriteCmd(this, this.mapper));
        this.cmdManager.enqueue(tVCommandList);
    }

    public void handleDeleteFavorite(int n) {
        ServiceInfo serviceInfo = this.favoritesList.getServiceByIndex(n);
        this.handleDeleteFavorite(serviceInfo);
    }

    public void handleAddFavorite(int n) {
        AbstractTVStationRow abstractTVStationRow = this.stationList.getRowByIndex(n);
        if (null != abstractTVStationRow) {
            ServiceInfo serviceInfo = abstractTVStationRow.service;
            this.handleAddFavorite(serviceInfo);
        } else {
            this.log.log(100000, "[ServiceListsResource.handleAddFavorite] Cannot find row for targetRowIndex %1", (long)n);
        }
    }

    public void handleAddFavorite(ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            this.setFavoritesToAdd(new ServiceInfo[]{serviceInfo});
            this.log.log(1000000, "[ServiceListsResource.handleAddFavorite] adding favorite: %1", (Object)serviceInfo);
            TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
            tVCommandList.add(this.cmdManager.createAddFavoriteCmd(this, this.mapper));
            this.cmdManager.enqueue(tVCommandList);
        } else {
            this.log.log(100000, "[ServiceListsResource.handleAddFavorite] Favorite to add was null");
        }
    }

    public void handleDeleteAllFavorites() {
        this.log.log(1000000, "[ServiceListsResource.handleDeleteAllFavorites] removing all favorites");
        ServiceInfo[] serviceInfoArray = this.favoritesList.getServices();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            arrayList.add(serviceInfoArray[i2]);
        }
        this.setFavoritesToRemove((ServiceInfo[])arrayList.toArray(new ServiceInfo[arrayList.size()]));
        TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
        tVCommandList.add(this.cmdManager.createClearFavoritesCmd(this, this.mapper));
        this.cmdManager.enqueue(tVCommandList);
    }

    private class OptionListener
    extends DefaultOptionListener {
        private OptionListener() {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
            ServiceListsResource.this.log.log(1000000, "[ServiceListsResource.OptionListener.keyTyped] %1, %2, %3", (long)n2, (long)n3, (long)n4);
            if (n4 == 2) {
                SelectedItem selectedItem = ServiceListsResource.this.stationList.getSelected();
                if (selectedItem != null) {
                    ServiceListsResource.this.handleAddFavorite(selectedItem.getIndex());
                }
            } else if (n == 2600048) {
                ServiceListsResource.this.handleAddFavorite(n3);
            }
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        public void updateServiceList(ServiceInfo[] serviceInfoArray) {
            ServiceListsResource.this.setUpdatedServices(serviceInfoArray);
            TVCommandList tVCommandList = ServiceListsResource.this.cmdManager.createCmdList(0);
            tVCommandList.add(ServiceListsResource.this.cmdManager.createUpdateStationListCmd(ServiceListsResource.this, ServiceListsResource.this.mapper));
            ServiceListsResource.this.cmdManager.enqueue(tVCommandList);
        }

        public void updateLogoList(LogoInfo[] logoInfoArray) {
        }
    }

    private class SettingListener
    extends ISettingListener.Stub {
        private SettingListener() {
        }

        public void updateStationListSorting(int n) {
            ServiceListsResource.this.stationListSorting = n;
        }
    }

    private class SelectServiceListener
    extends DSICallListener {
        private SelectServiceListener() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            ServiceListsResource.this.setService(serviceInfo);
            TVCommandList tVCommandList = ServiceListsResource.this.cmdManager.createCmdList(0);
            tVCommandList.add(ServiceListsResource.this.cmdManager.createUpdateSelectedStationCmd(ServiceListsResource.this, false));
            ServiceListsResource.this.cmdManager.enqueue(tVCommandList);
        }

        public void enableServiceLinking(boolean bl) {
            ServiceListsResource.this.stationList.updateServiceLinking(bl);
        }
    }

    private class SelectedServiceDebouncedListener
    extends TVEventDefaultListener {
        private SelectedServiceDebouncedListener() {
        }

        public void onSelectedServiceDebounced(ProgramInfo programInfo) {
            ServiceListsResource.this.setProgram(programInfo);
            TVCommandList tVCommandList = ServiceListsResource.this.cmdManager.createCmdList(0);
            tVCommandList.add(ServiceListsResource.this.cmdManager.createUpdateSelectedStationCmd(ServiceListsResource.this, true));
            ServiceListsResource.this.cmdManager.enqueue(tVCommandList);
        }
    }
}

