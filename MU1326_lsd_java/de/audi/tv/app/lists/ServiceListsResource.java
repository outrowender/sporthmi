/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.cmd.ITVCmdManager;
import de.audi.tv.app.cmd.TVCmdManager;
import de.audi.tv.app.cmd.TVCommandList;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.EmptyStationList;
import de.audi.tv.app.lists.IServiceListsResource;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.LogoList;
import de.audi.tv.app.lists.ServiceListsResource$OptionListener;
import de.audi.tv.app.lists.ServiceListsResource$SelectServiceListener;
import de.audi.tv.app.lists.ServiceListsResource$SelectedServiceDebouncedListener;
import de.audi.tv.app.lists.ServiceListsResource$SettingListener;
import de.audi.tv.app.lists.ServiceListsResource$TVListenerImpl;
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
    public static final int TV_FULLSCREEN_ID;
    private IStationList stationList = new EmptyStationList();
    private IFavoritesList favoritesList = new EmptyFavoritesList();
    private final LogoList logoList;
    public final ISettingListener settingListener = new ServiceListsResource$SettingListener(this, null);
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
    public final ServiceListsResource$TVListenerImpl tvListener = new ServiceListsResource$TVListenerImpl(this, null);
    public final DSICallListener selectServiceListener = new ServiceListsResource$SelectServiceListener(this, null);
    public final ServiceListsResource$SelectedServiceDebouncedListener selectionListener = new ServiceListsResource$SelectedServiceDebouncedListener(this, null);

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
        this.log.log(1078071040, "[ServiceListsResource.registerFavoritesList] loading favorites from memory.");
        ServiceListsResource$OptionListener serviceListsResource$OptionListener = new ServiceListsResource$OptionListener(this, null);
        this.env.getOptionModel(1890330368).setListener(serviceListsResource$OptionListener, 1085024000);
        this.env.getOptionModel(1890330368).setCustomIDListener(serviceListsResource$OptionListener, 2);
        TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
        tVCommandList.add(this.cmdManager.createLoadFavoritesCmd(this));
        tVCommandList.add(this.cmdManager.createSetFavoritesCmd(this, this.mapper));
        this.cmdManager.enqueue(tVCommandList);
    }

    public void registerFavoritesList(IFavoritesList iFavoritesList, ServiceInfo[] serviceInfoArray) {
        this.favoritesList = iFavoritesList;
        this.setFavoritesToAdd(serviceInfoArray);
        this.log.log(1078071040, "[ServiceListsResource.registerFavoritesList] loading given favorites.");
        TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
        tVCommandList.add(this.cmdManager.createSetFavoritesCmd(this, this.mapper));
        this.cmdManager.enqueue(tVCommandList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
    @Override
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
    @Override
    public ServiceInfo[] getNewServiceList() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ServiceInfo[] serviceInfoArray = this.updatedServices;
            this.updatedServices = new ServiceInfo[0];
            return serviceInfoArray;
        }
    }

    @Override
    public void setFavorites(ServiceInfo[] serviceInfoArray, long[] lArray) {
        SelectedItem selectedItem = this.stationList.getSelected();
        long l = selectedItem != null ? selectedItem.getUniqueID() : -1L;
        this.favoritesList.setFavorites(serviceInfoArray, lArray, l);
    }

    @Override
    public void addFavorite(ServiceInfo serviceInfo, long l) {
        SelectedItem selectedItem = this.stationList.getSelected();
        long l2 = selectedItem != null ? selectedItem.getUniqueID() : -1L;
        boolean bl = l2 == l;
        this.favoritesList.addFavorite(serviceInfo, l, bl);
        if (bl) {
            this.setSelectedService(serviceInfo);
        }
    }

    @Override
    public void clearFavorites() {
        this.favoritesList.clearList(false);
    }

    @Override
    public void removeFavorite(ServiceInfo serviceInfo, long l) {
        this.favoritesList.removeService(l);
    }

    @Override
    public void markFavorites(long[] lArray) {
        this.stationList.markFavorites(lArray);
        this.logoList.addFavoriteNamePids(this.mapper.getNamePidForUniqueIds(lArray));
    }

    @Override
    public void unmarkFavorites(long[] lArray) {
        this.stationList.unmarkFavorites(lArray);
        this.logoList.removeFavoriteNamePids(this.mapper.getNamePidForUniqueIds(lArray));
    }

    @Override
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

    @Override
    public void loadFavoritesFromMemory() {
        ServiceInfo[] serviceInfoArray = this.favoritesList.getServicesFromMemory();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            arrayList.add(serviceInfoArray[i2]);
        }
        this.setFavoritesToAdd((ServiceInfo[])arrayList.toArray(new ServiceInfo[arrayList.size()]));
    }

    @Override
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

    @Override
    public void setStationList(List list) {
        this.stationList.setStationList(list, this.favoritesList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ProgramInfo getSelectedProgram() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ProgramInfo programInfo = this.selectedProgram;
            this.selectedProgram = null;
            return programInfo;
        }
    }

    @Override
    public void setSelectedProgram(ProgramInfo programInfo) {
        if (programInfo != null) {
            boolean bl = this.favoritesList.updateSelectedProgram(programInfo);
            this.stationList.updateSelectedProgram(programInfo, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ServiceInfo getSelectedService() {
        ServiceListsResource serviceListsResource = this;
        synchronized (serviceListsResource) {
            ServiceInfo serviceInfo = this.selectedService;
            this.selectedService = null;
            return serviceInfo;
        }
    }

    @Override
    public void setSelectedService(ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            boolean bl = this.favoritesList.updateSelectedService(serviceInfo);
            this.stationList.updateSelectedService(serviceInfo, bl);
        }
    }

    @Override
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
        this.log.log(1078071040, "[ServiceListsResource.handleDeleteFavorite] removing favorite: %1", (Object)serviceInfo);
        TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
        tVCommandList.add(this.cmdManager.createRemoveFavoriteCmd(this, this.mapper));
        this.cmdManager.enqueue(tVCommandList);
    }

    @Override
    public void handleDeleteFavorite(int n) {
        ServiceInfo serviceInfo = this.favoritesList.getServiceByIndex(n);
        this.handleDeleteFavorite(serviceInfo);
    }

    @Override
    public void handleAddFavorite(int n) {
        AbstractTVStationRow abstractTVStationRow = this.stationList.getRowByIndex(n);
        if (null != abstractTVStationRow) {
            ServiceInfo serviceInfo = abstractTVStationRow.service;
            this.handleAddFavorite(serviceInfo);
        } else {
            this.log.log(-1601830656, "[ServiceListsResource.handleAddFavorite] Cannot find row for targetRowIndex %1", (long)n);
        }
    }

    @Override
    public void handleAddFavorite(ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            this.setFavoritesToAdd(new ServiceInfo[]{serviceInfo});
            this.log.log(1078071040, "[ServiceListsResource.handleAddFavorite] adding favorite: %1", (Object)serviceInfo);
            TVCommandList tVCommandList = this.cmdManager.createCmdList(0);
            tVCommandList.add(this.cmdManager.createAddFavoriteCmd(this, this.mapper));
            this.cmdManager.enqueue(tVCommandList);
        } else {
            this.log.log(-1601830656, "[ServiceListsResource.handleAddFavorite] Favorite to add was null");
        }
    }

    @Override
    public void handleDeleteAllFavorites() {
        this.log.log(1078071040, "[ServiceListsResource.handleDeleteAllFavorites] removing all favorites");
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

    static /* synthetic */ LogChannel access$500(ServiceListsResource serviceListsResource) {
        return serviceListsResource.log;
    }

    static /* synthetic */ IStationList access$600(ServiceListsResource serviceListsResource) {
        return serviceListsResource.stationList;
    }

    static /* synthetic */ void access$700(ServiceListsResource serviceListsResource, ServiceInfo[] serviceInfoArray) {
        serviceListsResource.setUpdatedServices(serviceInfoArray);
    }

    static /* synthetic */ ITVCmdManager access$800(ServiceListsResource serviceListsResource) {
        return serviceListsResource.cmdManager;
    }

    static /* synthetic */ StationMapper access$900(ServiceListsResource serviceListsResource) {
        return serviceListsResource.mapper;
    }

    static /* synthetic */ void access$1000(ServiceListsResource serviceListsResource, ProgramInfo programInfo) {
        serviceListsResource.setProgram(programInfo);
    }

    static /* synthetic */ void access$1100(ServiceListsResource serviceListsResource, ServiceInfo serviceInfo) {
        serviceListsResource.setService(serviceInfo);
    }

    static /* synthetic */ int access$1202(ServiceListsResource serviceListsResource, int n) {
        serviceListsResource.stationListSorting = n;
        return serviceListsResource.stationListSorting;
    }
}

