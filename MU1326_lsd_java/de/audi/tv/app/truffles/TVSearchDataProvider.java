/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.lists.ISearchBreak;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.truffles.ISearchGUI;
import de.audi.tv.app.truffles.NullDSISearchDataProvider;
import de.audi.tv.app.truffles.TVSearchDataProvider$InvalidationTruffleCmd;
import de.audi.tv.app.truffles.TVSearchDataProvider$ListsListener;
import de.audi.tv.app.truffles.TVSearchDataProvider$SearchBreakListener;
import de.audi.tv.app.truffles.TrufflesCommandHandler;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DSISearchDataProviderListener;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVSearchDataProvider
implements DSISearchDataProviderListener {
    public final ITVListsListener listsListener = new TVSearchDataProvider$ListsListener(this, null);
    public final ISearchBreak searchListener = new TVSearchDataProvider$SearchBreakListener(this, null);
    private DSISearchDataProvider dsi;
    private final LogChannel log;
    private final IStationList stationList;
    private final IFavoritesList favoritesList;
    private final StationMapper mapper;
    private final SimpleIntIntMap waitingInvalids = new SimpleIntIntMap(10);
    private boolean searchIsBlocked;
    private final TrufflesCommandHandler cmdHandler;
    private final ISearchGUI searchGUI;

    public TVSearchDataProvider(LogChannel logChannel, IStationList iStationList, IFavoritesList iFavoritesList, StationMapper stationMapper, TrufflesCommandHandler trufflesCommandHandler, ISearchGUI iSearchGUI) {
        this.log = logChannel;
        this.stationList = iStationList;
        this.favoritesList = iFavoritesList;
        this.mapper = stationMapper;
        this.dsi = new NullDSISearchDataProvider(logChannel);
        this.cmdHandler = trufflesCommandHandler;
        this.searchGUI = iSearchGUI;
    }

    public void setDeviceService(DSIBase dSIBase) {
        this.dsi = (DSISearchDataProvider)dSIBase;
        this.init();
    }

    public boolean isDsiFound() {
        return !(this.dsi instanceof NullDSISearchDataProvider);
    }

    private void init() {
        this.dsi.registerProviderSource(20027);
        this.dsi.registerProviderSource(27);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(-2137614336, "[TVSearchDataProvider.asyncException] %1", (Object)string);
    }

    @Override
    public void registerProviderSourceResult(int n, int n2) {
        this.log.log(-2137614336, "[TVSearchDataProvider.registerProviderSourceResult] success:%1 source:%2", (long)n, (long)n2);
    }

    @Override
    public void activateProviderSource(int n) {
        this.log.log(-2137614336, "[TVSearchDataProvider.activateProviderSource] %1", (long)n);
    }

    @Override
    public void invalidateAllDataResult(int n, int n2) {
        this.log.log(-2137614336, "[TVSearchDataProvider.invalidateAllDataResult] success:%1 source:%2", (long)n, (long)n2);
    }

    @Override
    public void provideData(int n, int n2, int n3) {
        int n4;
        this.log.log(-2137614336, "[TVSearchDataProvider.provideData] source:%1 offset:%2 count:%3", (long)n, (long)n2, (long)n3);
        ServiceInfo[] serviceInfoArray = new ServiceInfo[]{};
        boolean bl = false;
        switch (n) {
            case 27: {
                serviceInfoArray = this.stationList.getServices();
                break;
            }
            case 20027: {
                serviceInfoArray = this.favoritesList.getServices();
                bl = true;
                break;
            }
        }
        DataSet[] dataSetArray = new DataSet[serviceInfoArray.length];
        for (n4 = 0; n4 < serviceInfoArray.length; ++n4) {
            dataSetArray[n4] = this.getTVDataSet(serviceInfoArray[n4], bl);
        }
        n4 = dataSetArray.length - n2;
        n4 = n4 > 0 ? Math.min(n4, n3) : 0;
        DataSet[] dataSetArray2 = new DataSet[n4];
        if (n4 > 0) {
            System.arraycopy((Object)dataSetArray, n2, (Object)dataSetArray2, 0, n4);
        }
        this.log.log(-2137614336, "[TVSearchDataProvider.provideData] source:%1 count:%2", (long)n, (long)dataSetArray2.length);
        this.dsi.storeDataSets(n, dataSetArray2, dataSetArray2.length);
    }

    private DataSet getTVDataSet(ServiceInfo serviceInfo, boolean bl) {
        long l = this.mapper.getServiceID(serviceInfo);
        if (bl) {
            l = StationMapper.flagUniqueIDAsFavorite(l);
        }
        return new DataSet(l, 19, 0, new Searchable[]{new Searchable(22, serviceInfo.getName(), 0)});
    }

    @Override
    public void storeDataSetsResult(int n, int n2) {
        this.log.log(-2137614336, "[TVSearchDataProvider.storeDataSetsResult] success:%1 source:%2", (long)n, (long)n2);
    }

    @Override
    public void deleteDataSetResult(int n, int n2, long l) {
        this.log.log(-2137614336, "[TVSearchDataProvider.deleteDataSetResult] success:%1 source:%2 dataSetId%3", (long)n, (long)n2, l);
    }

    private void invalidateData(int n) {
        this.cmdHandler.add(new TVSearchDataProvider$InvalidationTruffleCmd(this, n));
        this.searchGUI.runCommands();
    }

    static /* synthetic */ LogChannel access$200(TVSearchDataProvider tVSearchDataProvider) {
        return tVSearchDataProvider.log;
    }

    static /* synthetic */ SimpleIntIntMap access$300(TVSearchDataProvider tVSearchDataProvider) {
        return tVSearchDataProvider.waitingInvalids;
    }

    static /* synthetic */ boolean access$400(TVSearchDataProvider tVSearchDataProvider) {
        return tVSearchDataProvider.searchIsBlocked;
    }

    static /* synthetic */ void access$500(TVSearchDataProvider tVSearchDataProvider, int n) {
        tVSearchDataProvider.invalidateData(n);
    }

    static /* synthetic */ boolean access$402(TVSearchDataProvider tVSearchDataProvider, boolean bl) {
        tVSearchDataProvider.searchIsBlocked = bl;
        return tVSearchDataProvider.searchIsBlocked;
    }

    static /* synthetic */ DSISearchDataProvider access$600(TVSearchDataProvider tVSearchDataProvider) {
        return tVSearchDataProvider.dsi;
    }
}

