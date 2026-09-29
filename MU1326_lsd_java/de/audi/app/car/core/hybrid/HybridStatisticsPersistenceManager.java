/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.hybrid.HybridStatisticsPersistenceManager$ConfigPersistenceHandler;
import de.audi.app.car.core.hybrid.HybridStatisticsPersistenceManager$HistoryPersistenceHandler;
import de.audi.app.car.core.hybrid.IHybridStatisticsConfig;
import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;

public class HybridStatisticsPersistenceManager {
    private final IStorageAccess storageAccess;
    private final LogChannel logChannel;
    private static final int[] CONFIG_STORAGE_ACCESS_KEYS = new int[]{100, 101};
    private static final int[] HISTORY_STORAGE_ACCESS_KEYS = new int[]{102, 103, 104};
    private final HybridStatisticsPersistenceManager$ConfigPersistenceHandler[] configPersistenceHandlers;
    private final HybridStatisticsPersistenceManager$HistoryPersistenceHandler[] historyPersistenceHandlers;

    public HybridStatisticsPersistenceManager(ICarApplication iCarApplication, LogChannel logChannel) {
        int n;
        this.storageAccess = iCarApplication.getFrameworkAccess().getStorageMgr();
        this.logChannel = logChannel;
        this.configPersistenceHandlers = new HybridStatisticsPersistenceManager$ConfigPersistenceHandler[CONFIG_STORAGE_ACCESS_KEYS.length];
        for (n = 0; n < CONFIG_STORAGE_ACCESS_KEYS.length; ++n) {
            this.configPersistenceHandlers[n] = new HybridStatisticsPersistenceManager$ConfigPersistenceHandler(this, this.storageAccess, 0, 1006, CONFIG_STORAGE_ACCESS_KEYS[n], null);
        }
        this.historyPersistenceHandlers = new HybridStatisticsPersistenceManager$HistoryPersistenceHandler[HISTORY_STORAGE_ACCESS_KEYS.length];
        for (n = 0; n < HISTORY_STORAGE_ACCESS_KEYS.length; ++n) {
            this.historyPersistenceHandlers[n] = new HybridStatisticsPersistenceManager$HistoryPersistenceHandler(this, this.storageAccess, 0, 1006, HISTORY_STORAGE_ACCESS_KEYS[n], null);
        }
    }

    public boolean saveConfig(int n, IHybridStatisticsConfig iHybridStatisticsConfig) {
        HybridStatisticsPersistenceManager$ConfigPersistenceHandler hybridStatisticsPersistenceManager$ConfigPersistenceHandler = this.getConfigStorageHandlerForKey(n);
        if (null != hybridStatisticsPersistenceManager$ConfigPersistenceHandler) {
            return HybridStatisticsPersistenceManager$ConfigPersistenceHandler.access$200(hybridStatisticsPersistenceManager$ConfigPersistenceHandler, iHybridStatisticsConfig);
        }
        return false;
    }

    public IHybridStatisticsConfig loadConfig(int n) {
        HybridStatisticsPersistenceManager$ConfigPersistenceHandler hybridStatisticsPersistenceManager$ConfigPersistenceHandler = this.getConfigStorageHandlerForKey(n);
        if (null != hybridStatisticsPersistenceManager$ConfigPersistenceHandler) {
            return HybridStatisticsPersistenceManager$ConfigPersistenceHandler.access$300(hybridStatisticsPersistenceManager$ConfigPersistenceHandler);
        }
        return null;
    }

    public boolean saveHistory(int n, IMemoryBufferEntry[] iMemoryBufferEntryArray) {
        HybridStatisticsPersistenceManager$HistoryPersistenceHandler hybridStatisticsPersistenceManager$HistoryPersistenceHandler = this.getHistoryStorageHandlerForKey(n);
        if (null != hybridStatisticsPersistenceManager$HistoryPersistenceHandler) {
            return HybridStatisticsPersistenceManager$HistoryPersistenceHandler.access$400(hybridStatisticsPersistenceManager$HistoryPersistenceHandler, iMemoryBufferEntryArray);
        }
        return false;
    }

    public IMemoryBufferEntry[] loadHistory(int n) {
        HybridStatisticsPersistenceManager$HistoryPersistenceHandler hybridStatisticsPersistenceManager$HistoryPersistenceHandler = this.getHistoryStorageHandlerForKey(n);
        if (null != hybridStatisticsPersistenceManager$HistoryPersistenceHandler) {
            return HybridStatisticsPersistenceManager$HistoryPersistenceHandler.access$500(hybridStatisticsPersistenceManager$HistoryPersistenceHandler);
        }
        return new IMemoryBufferEntry[0];
    }

    private HybridStatisticsPersistenceManager$ConfigPersistenceHandler getConfigStorageHandlerForKey(int n) {
        for (int i2 = 0; i2 < CONFIG_STORAGE_ACCESS_KEYS.length; ++i2) {
            if (n != CONFIG_STORAGE_ACCESS_KEYS[i2]) continue;
            return this.configPersistenceHandlers[i2];
        }
        return null;
    }

    private HybridStatisticsPersistenceManager$HistoryPersistenceHandler getHistoryStorageHandlerForKey(int n) {
        for (int i2 = 0; i2 < HISTORY_STORAGE_ACCESS_KEYS.length; ++i2) {
            if (n != HISTORY_STORAGE_ACCESS_KEYS[i2]) continue;
            return this.historyPersistenceHandlers[i2];
        }
        return null;
    }

    static /* synthetic */ LogChannel access$600(HybridStatisticsPersistenceManager hybridStatisticsPersistenceManager) {
        return hybridStatisticsPersistenceManager.logChannel;
    }
}

