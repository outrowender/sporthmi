/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TVServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.DefaultListContentSupplier;
import de.audi.tv.app.lists.IListContentSupplier;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.sds.TVServiceHandler$EventListener;
import de.audi.tv.app.sds.TVServiceHandler$ListsListener;
import de.audi.tv.app.sds.TVServiceHandler$TVListener;
import de.audi.tv.app.storage.TVStorage;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TVServiceHandler {
    private final LogChannel lc;
    private final TVEnv env;
    public final ITVEventListener eventListener = new TVServiceHandler$EventListener(this, null);
    public final DefaultTVListener tvListener = new TVServiceHandler$TVListener(this, null);
    public final ITVListsListener listsListener = new TVServiceHandler$ListsListener(this, null);
    private IListContentSupplier stationList = new DefaultListContentSupplier();
    private IListContentSupplier favoritesList = new DefaultListContentSupplier();
    private final List listeners = new ArrayList();
    private boolean isAvAvailable = false;
    private boolean isFavoritesAvailable = false;
    private boolean isTvAvailable = false;
    private final SimpleIntObjectMap listMap = new SimpleIntObjectMap();
    private int[] sources = new int[0];
    private final Object mutex = new Object();

    public TVServiceHandler(LogChannel logChannel, TVEnv tVEnv, TVStorage tVStorage) {
        this.lc = logChannel;
        this.env = tVEnv;
        this.isAvAvailable = tVStorage.isAvSourceAvailable();
        this.listMap.add(1, new SDSListEntry[0]);
        this.listMap.add(2, new SDSListEntry[0]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(TVServiceListener tVServiceListener) {
        this.lc.log(-2137614336, "[TVServiceHandler.addListener] %1 %2", (Object)tVServiceListener.getName(), (Object)tVServiceListener);
        Object object = this.mutex;
        synchronized (object) {
            this.listeners.add(tVServiceListener);
            tVServiceListener.updateSourceList(this.sources);
            tVServiceListener.updateTVStationList((SDSListEntry[])this.listMap.get(1), 1);
            tVServiceListener.updateTVStationList((SDSListEntry[])this.listMap.get(2), 2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(TVServiceListener tVServiceListener) {
        this.lc.log(-2137614336, "[TVServiceHandler.removeListener] %1 %2", (Object)tVServiceListener.getName(), (Object)tVServiceListener);
        Object object = this.mutex;
        synchronized (object) {
            this.listeners.remove(tVServiceListener);
        }
    }

    public void registerStationList(IListContentSupplier iListContentSupplier) {
        this.stationList = iListContentSupplier;
    }

    public void registerFavoritesList(IListContentSupplier iListContentSupplier) {
        this.favoritesList = iListContentSupplier;
    }

    private void updateSourceList() {
        IntList intList = new IntList();
        if (this.isTvAvailable) {
            intList.add(1);
            if (this.isFavoritesAvailable) {
                intList.add(2);
            }
            if (this.isAvAvailable && this.env.getConfiguration().hasAV()) {
                intList.add(3);
            }
        }
        this.sources = intList.toArray();
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((TVServiceListener)iterator.next()).updateSourceList(this.sources);
        }
    }

    private SDSListEntry[] getSdsList(BaseListModelApp baseListModelApp) {
        if (baseListModelApp == null) {
            this.lc.log(-1601830656, "[TVServiceHandler.getSdsList] supplier list is null!");
            return new SDSListEntry[0];
        }
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < sDSListEntryArray.length; ++i2) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(i2);
            sDSListEntryArray[i2] = new SDSListEntry(abstractTVStationRow.service.name, abstractTVStationRow.getUniqueID());
        }
        return sDSListEntryArray;
    }

    private void updateList(SDSListEntry[] sDSListEntryArray, int n) {
        this.listMap.add(n, sDSListEntryArray);
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((TVServiceListener)iterator.next()).updateTVStationList(sDSListEntryArray, n);
        }
    }

    static /* synthetic */ Object access$300(TVServiceHandler tVServiceHandler) {
        return tVServiceHandler.mutex;
    }

    static /* synthetic */ boolean access$402(TVServiceHandler tVServiceHandler, boolean bl) {
        tVServiceHandler.isAvAvailable = bl;
        return tVServiceHandler.isAvAvailable;
    }

    static /* synthetic */ void access$500(TVServiceHandler tVServiceHandler) {
        tVServiceHandler.updateSourceList();
    }

    static /* synthetic */ boolean access$602(TVServiceHandler tVServiceHandler, boolean bl) {
        tVServiceHandler.isTvAvailable = bl;
        return tVServiceHandler.isTvAvailable;
    }

    static /* synthetic */ IListContentSupplier access$700(TVServiceHandler tVServiceHandler) {
        return tVServiceHandler.favoritesList;
    }

    static /* synthetic */ SDSListEntry[] access$800(TVServiceHandler tVServiceHandler, BaseListModelApp baseListModelApp) {
        return tVServiceHandler.getSdsList(baseListModelApp);
    }

    static /* synthetic */ boolean access$900(TVServiceHandler tVServiceHandler) {
        return tVServiceHandler.isFavoritesAvailable;
    }

    static /* synthetic */ boolean access$902(TVServiceHandler tVServiceHandler, boolean bl) {
        tVServiceHandler.isFavoritesAvailable = bl;
        return tVServiceHandler.isFavoritesAvailable;
    }

    static /* synthetic */ void access$1000(TVServiceHandler tVServiceHandler, SDSListEntry[] sDSListEntryArray, int n) {
        tVServiceHandler.updateList(sDSListEntryArray, n);
    }

    static /* synthetic */ IListContentSupplier access$1100(TVServiceHandler tVServiceHandler) {
        return tVServiceHandler.stationList;
    }
}

