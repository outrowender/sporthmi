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
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.DefaultListContentSupplier;
import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.lists.IListContentSupplier;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.storage.TVStorage;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TVServiceHandler {
    private final LogChannel lc;
    private final TVEnv env;
    public final ITVEventListener eventListener = new EventListener();
    public final DefaultTVListener tvListener = new TVListener();
    public final ITVListsListener listsListener = new ListsListener();
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
        this.lc.log(10000000, "[TVServiceHandler.addListener] %1 %2", (Object)tVServiceListener.getName(), (Object)tVServiceListener);
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
        this.lc.log(10000000, "[TVServiceHandler.removeListener] %1 %2", (Object)tVServiceListener.getName(), (Object)tVServiceListener);
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
            this.lc.log(100000, "[TVServiceHandler.getSdsList] supplier list is null!");
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

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            Object object = TVServiceHandler.this.mutex;
            synchronized (object) {
                TVServiceHandler.this.isAvAvailable = startUpConfig.avSrcAvail;
                TVServiceHandler.this.updateSourceList();
            }
        }
    }

    private class EventListener
    extends TVEventDefaultListener {
        private EventListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerAvailable() {
            Object object = TVServiceHandler.this.mutex;
            synchronized (object) {
                TVServiceHandler.this.isTvAvailable = true;
                TVServiceHandler.this.updateSourceList();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerUnavailable() {
            Object object = TVServiceHandler.this.mutex;
            synchronized (object) {
                TVServiceHandler.this.isTvAvailable = false;
                TVServiceHandler.this.updateSourceList();
            }
        }
    }

    private class ListsListener
    extends DefaultTVListsListener {
        private ListsListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateFavoritesList() {
            Object object = TVServiceHandler.this.mutex;
            synchronized (object) {
                SDSListEntry[] sDSListEntryArray = TVServiceHandler.this.getSdsList(TVServiceHandler.this.favoritesList.getTmpList());
                if (sDSListEntryArray.length != 0 != TVServiceHandler.this.isFavoritesAvailable) {
                    TVServiceHandler.this.isFavoritesAvailable = sDSListEntryArray.length > 0;
                    TVServiceHandler.this.updateSourceList();
                }
                TVServiceHandler.this.updateList(sDSListEntryArray, 2);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateStationList() {
            Object object = TVServiceHandler.this.mutex;
            synchronized (object) {
                TVServiceHandler.this.updateList(TVServiceHandler.this.getSdsList(TVServiceHandler.this.stationList.getTmpList()), 1);
            }
        }
    }
}

