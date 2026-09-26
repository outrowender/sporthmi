/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.search;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DSISearchDataProviderListener;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;

public class OnlineSearchDataProvider
implements DSISearchDataProviderListener,
IDSIClient {
    private static String LOGCLASS = "OnlineSearchDataProvider";
    private DSISearchDataProvider dsi;
    private DSIActivator dsiActivator;
    protected LogChannel log;
    private DataSet[] dataSet;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProvider;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProviderListener;

    public void init(IFrameworkAccess iFrameworkAccess) {
        this.dsiActivator = new DSIActivator(iFrameworkAccess, (class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = OnlineSearchDataProvider.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName(), (class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = OnlineSearchDataProvider.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener).getName(), new Integer(6), this, this);
        this.dsiActivator.start(iFrameworkAccess.getBundleCxt());
    }

    public OnlineSearchDataProvider(LogChannel logChannel) {
        this.log = logChannel;
    }

    public void updateSourceData(List list) {
        this.log.log(1078071040, "OnlineSearchDataProvider#updateSourceData");
        ArrayList arrayList = new ArrayList(list.size());
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            DataSet dataSet = new DataSet(i2 + 1, 17, 1, new Searchable[0]);
            IGrid iGrid = (IGrid)list.get(i2);
            if (this.isPreview(iGrid)) continue;
            ArrayList arrayList2 = new ArrayList(2);
            int n2 = 0;
            Iterator iterator = iGrid.iterator();
            while (iterator.hasNext()) {
                IGridCell iGridCell = (IGridCell)iterator.next();
                if (iGridCell.getVisibility() == 2 || iGridCell.getType() != 0) continue;
                Searchable searchable = new Searchable(++n2, iGridCell.getStringValue());
                arrayList2.add(searchable);
            }
            dataSet.data = (Searchable[])arrayList2.toArray(new Searchable[arrayList2.size()]);
            arrayList.add(dataSet);
        }
        this.dataSet = (DataSet[])arrayList.toArray(new DataSet[arrayList.size()]);
        this.invalidateAllData(9);
    }

    private boolean isPreview(IGrid iGrid) {
        List list = iGrid.getDrawerTypes();
        if (list == null || list.size() == 0) {
            return false;
        }
        return list.contains("Audi_Connect_Preview");
    }

    public void registerProviderSource(int n) {
        if (this.dsi == null) {
            this.log.log(10000, "OnlineSearchDataProvider#registerProviderSource: no DSI");
            return;
        }
        this.dsi.registerProviderSource(n);
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        if (this.dsi == null) {
            this.log.log(10000, "OnlineSearchDataProvider#sourceDataAvailabilityChanged: no DSI");
            return;
        }
        this.dsi.sourceDataAvailabilityChanged(n, bl);
    }

    public void invalidateAllData(int n) {
        if (this.dsi == null) {
            this.log.log(10000, "OnlineSearchDataProvider#invalidateAllData: no DSI");
            return;
        }
        this.dsi.invalidateAllData(n);
    }

    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
        if (this.dsi == null) {
            this.log.log(10000, "OnlineSearchDataProvider#storeDataSets: no DSI");
            return;
        }
        this.dsi.storeDataSets(n, dataSetArray, n2);
    }

    public void deleteDataSet(int n, long l) {
        if (this.dsi == null) {
            this.log.log(10000, "OnlineSearchDataProvider#deleteDataSet: no DSI");
            return;
        }
        this.dsi.deleteDataSet(n, l);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#asyncException: [error %1] [msg %2] [requestType %3]", (Object)Integer.toString(n), (Object)string, (Object)Integer.toString(n2));
    }

    @Override
    public void registerProviderSourceResult(int n, int n2) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#invalidateAllDataResult: [success %1] [source %2]", (long)n, (long)n2);
    }

    @Override
    public void activateProviderSource(int n) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#activateProviderSource: [source %1]", (long)n);
    }

    @Override
    public void invalidateAllDataResult(int n, int n2) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#invalidateAllDataResul:t [success %1] [source %2]", (long)n, (long)n2);
    }

    @Override
    public void provideData(int n, int n2, int n3) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#provideData: [offset %1] [source %2] [count %3]", (long)n2, (long)n, (long)n3);
        if (this.dataSet != null) {
            this.storeDataSets(9, this.dataSet, this.dataSet.length);
        }
    }

    @Override
    public void storeDataSetsResult(int n, int n2) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#storeDataSetsResult: [success %1] [source %2]", (long)n, (long)n2);
    }

    @Override
    public void deleteDataSetResult(int n, int n2, long l) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#deleteDataSetResult: [success %1] [source %2] [dataID %3]", (long)n, (long)n2, l);
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.log.log(-2137614336, "OnlineSearchDataProvider#setDSI()");
        this.dsi = (DSISearchDataProvider)dSIBase;
        if (dSIBase == null) {
            return;
        }
        if (dSIBase instanceof DSISearchDataProvider) {
            this.registerProviderSource(9);
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

