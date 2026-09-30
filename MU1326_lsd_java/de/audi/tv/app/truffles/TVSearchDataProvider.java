/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.lists.ISearchBreak;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.truffles.ISearchGUI;
import de.audi.tv.app.truffles.NullDSISearchDataProvider;
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
    public final ITVListsListener listsListener = new ListsListener();
    public final ISearchBreak searchListener = new SearchBreakListener();
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

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000000, "[TVSearchDataProvider.asyncException] %1", (Object)string);
    }

    public void registerProviderSourceResult(int n, int n2) {
        this.log.log(10000000, "[TVSearchDataProvider.registerProviderSourceResult] success:%1 source:%2", (long)n, (long)n2);
    }

    public void activateProviderSource(int n) {
        this.log.log(10000000, "[TVSearchDataProvider.activateProviderSource] %1", (long)n);
    }

    public void invalidateAllDataResult(int n, int n2) {
        this.log.log(10000000, "[TVSearchDataProvider.invalidateAllDataResult] success:%1 source:%2", (long)n, (long)n2);
    }

    public void provideData(int n, int n2, int n3) {
        int n4;
        this.log.log(10000000, "[TVSearchDataProvider.provideData] source:%1 offset:%2 count:%3", (long)n, (long)n2, (long)n3);
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
        this.log.log(10000000, "[TVSearchDataProvider.provideData] source:%1 count:%2", (long)n, (long)dataSetArray2.length);
        this.dsi.storeDataSets(n, dataSetArray2, dataSetArray2.length);
    }

    private DataSet getTVDataSet(ServiceInfo serviceInfo, boolean bl) {
        long l = this.mapper.getServiceID(serviceInfo);
        if (bl) {
            l = StationMapper.flagUniqueIDAsFavorite(l);
        }
        return new DataSet(l, 19, 0, new Searchable[]{new Searchable(22, serviceInfo.getName(), 0)});
    }

    public void storeDataSetsResult(int n, int n2) {
        this.log.log(10000000, "[TVSearchDataProvider.storeDataSetsResult] success:%1 source:%2", (long)n, (long)n2);
    }

    public void deleteDataSetResult(int n, int n2, long l) {
        this.log.log(10000000, "[TVSearchDataProvider.deleteDataSetResult] success:%1 source:%2 dataSetId%3", (long)n, (long)n2, l);
    }

    private void invalidateData(int n) {
        this.cmdHandler.add(new InvalidationTruffleCmd(n));
        this.searchGUI.runCommands();
    }

    private class ListsListener
    extends DefaultTVListsListener {
        private ListsListener() {
        }

        public void updateStationList() {
            TVSearchDataProvider.this.log.log(10000000, "[TVSearchDataProvider.updateStationList] invalidate data for station list]");
            this.invalidate(27);
        }

        public void updateFavoritesList() {
            TVSearchDataProvider.this.log.log(10000000, "[TVSearchDataProvider.updateFavoritesList] invalidate data for favorites]");
            this.invalidate(20027);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void invalidate(int n) {
            SimpleIntIntMap simpleIntIntMap = TVSearchDataProvider.this.waitingInvalids;
            synchronized (simpleIntIntMap) {
                if (TVSearchDataProvider.this.searchIsBlocked) {
                    TVSearchDataProvider.this.waitingInvalids.add(n, n);
                } else {
                    TVSearchDataProvider.this.invalidateData(n);
                }
            }
        }
    }

    private class SearchBreakListener
    implements ISearchBreak {
        private SearchBreakListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void cursorInSearchResult(boolean bl) {
            if (bl) {
                SimpleIntIntMap simpleIntIntMap = TVSearchDataProvider.this.waitingInvalids;
                synchronized (simpleIntIntMap) {
                    TVSearchDataProvider.this.searchIsBlocked = true;
                }
            }
            SimpleIntIntMap simpleIntIntMap = TVSearchDataProvider.this.waitingInvalids;
            synchronized (simpleIntIntMap) {
                int[] nArray = TVSearchDataProvider.this.waitingInvalids.getKeys();
                TVSearchDataProvider.this.waitingInvalids.clear();
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    TVSearchDataProvider.this.invalidateData(nArray[i2]);
                }
                TVSearchDataProvider.this.searchIsBlocked = false;
            }
        }
    }

    private class InvalidationTruffleCmd
    implements TrufflesCommandHandler.ITrufflesCommand {
        private int id;

        public InvalidationTruffleCmd(int n) {
            this.id = n;
        }

        public int getPriority() {
            return 0;
        }

        public void execute() {
            TVSearchDataProvider.this.dsi.invalidateAllData(this.id);
        }
    }
}

