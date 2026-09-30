/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.hybrid.IHybridStatisticsConfig;
import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HybridStatisticsPersistenceManager {
    private final IStorageAccess storageAccess;
    private final LogChannel logChannel;
    private static final int[] CONFIG_STORAGE_ACCESS_KEYS = new int[]{100, 101};
    private static final int[] HISTORY_STORAGE_ACCESS_KEYS = new int[]{102, 103, 104};
    private final ConfigPersistenceHandler[] configPersistenceHandlers;
    private final HistoryPersistenceHandler[] historyPersistenceHandlers;

    public HybridStatisticsPersistenceManager(ICarApplication iCarApplication, LogChannel logChannel) {
        int n;
        this.storageAccess = iCarApplication.getFrameworkAccess().getStorageMgr();
        this.logChannel = logChannel;
        this.configPersistenceHandlers = new ConfigPersistenceHandler[CONFIG_STORAGE_ACCESS_KEYS.length];
        for (n = 0; n < CONFIG_STORAGE_ACCESS_KEYS.length; ++n) {
            this.configPersistenceHandlers[n] = new ConfigPersistenceHandler(this.storageAccess, 0, 1006, CONFIG_STORAGE_ACCESS_KEYS[n]);
        }
        this.historyPersistenceHandlers = new HistoryPersistenceHandler[HISTORY_STORAGE_ACCESS_KEYS.length];
        for (n = 0; n < HISTORY_STORAGE_ACCESS_KEYS.length; ++n) {
            this.historyPersistenceHandlers[n] = new HistoryPersistenceHandler(this.storageAccess, 0, 1006, HISTORY_STORAGE_ACCESS_KEYS[n]);
        }
    }

    public boolean saveConfig(int n, IHybridStatisticsConfig iHybridStatisticsConfig) {
        ConfigPersistenceHandler configPersistenceHandler = this.getConfigStorageHandlerForKey(n);
        if (null != configPersistenceHandler) {
            return configPersistenceHandler.write(iHybridStatisticsConfig);
        }
        return false;
    }

    public IHybridStatisticsConfig loadConfig(int n) {
        ConfigPersistenceHandler configPersistenceHandler = this.getConfigStorageHandlerForKey(n);
        if (null != configPersistenceHandler) {
            return configPersistenceHandler.read();
        }
        return null;
    }

    public boolean saveHistory(int n, IMemoryBufferEntry[] iMemoryBufferEntryArray) {
        HistoryPersistenceHandler historyPersistenceHandler = this.getHistoryStorageHandlerForKey(n);
        if (null != historyPersistenceHandler) {
            return historyPersistenceHandler.write(iMemoryBufferEntryArray);
        }
        return false;
    }

    public IMemoryBufferEntry[] loadHistory(int n) {
        HistoryPersistenceHandler historyPersistenceHandler = this.getHistoryStorageHandlerForKey(n);
        if (null != historyPersistenceHandler) {
            return historyPersistenceHandler.read();
        }
        return new IMemoryBufferEntry[0];
    }

    private ConfigPersistenceHandler getConfigStorageHandlerForKey(int n) {
        for (int i2 = 0; i2 < CONFIG_STORAGE_ACCESS_KEYS.length; ++i2) {
            if (n != CONFIG_STORAGE_ACCESS_KEYS[i2]) continue;
            return this.configPersistenceHandlers[i2];
        }
        return null;
    }

    private HistoryPersistenceHandler getHistoryStorageHandlerForKey(int n) {
        for (int i2 = 0; i2 < HISTORY_STORAGE_ACCESS_KEYS.length; ++i2) {
            if (n != HISTORY_STORAGE_ACCESS_KEYS[i2]) continue;
            return this.historyPersistenceHandlers[i2];
        }
        return null;
    }

    private final class ConfigPersistenceHandler
    extends AbstractStorageDataContainer {
        private volatile IHybridStatisticsConfig storageData;

        private ConfigPersistenceHandler(IStorageAccess iStorageAccess, int n, int n2, int n3) {
            super(iStorageAccess, n, n2, n3);
        }

        private boolean write(IHybridStatisticsConfig iHybridStatisticsConfig) {
            if (null == iHybridStatisticsConfig) {
                return false;
            }
            this.storageData = iHybridStatisticsConfig;
            this.serializeAndWrite();
            HybridStatisticsPersistenceManager.this.logChannel.log(10000000, "[ConfigPersistenceHandler#write] storage size: %1", (long)this.getSize());
            return true;
        }

        private IHybridStatisticsConfig read() {
            this.readAndDeserialize();
            HybridStatisticsPersistenceManager.this.logChannel.log(10000000, "[ConfigPersistenceHandler#read] storage size: %1", (long)this.getSize());
            return this.storageData;
        }

        protected void handleCRC32Error() {
            HybridStatisticsPersistenceManager.this.logChannel.log(100000, "[ConfigPersistenceHandler#handleCRC32Error]");
        }

        protected void handleStorageReadError(Exception exception) {
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
            HybridStatisticsPersistenceManager.this.logChannel.log(100000, "[ConfigPersistenceHandler#convertContainer] persistedVersion=%1, containerVersion=%2", (long)n, (long)n2);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(1);
            IHybridStatisticsConfig iHybridStatisticsConfig = this.storageData;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(iHybridStatisticsConfig);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            int n = dataInputStream.readInt();
            HybridStatisticsPersistenceManager.this.logChannel.log(10000000, "[ConfigPersistenceHandler#deserialize] arrayLength=%1", (long)n);
            if (1 != n) {
                HybridStatisticsPersistenceManager.this.logChannel.log(10000, "[ConfigPersistenceHandler#deserialize] array length not valid: %1", (long)n);
                return;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            try {
                IHybridStatisticsConfig iHybridStatisticsConfig;
                this.storageData = iHybridStatisticsConfig = (IHybridStatisticsConfig)objectInputStream.readObject();
            }
            catch (ClassNotFoundException classNotFoundException) {
                HybridStatisticsPersistenceManager.this.logChannel.log(10000, "[ConfigPersistenceHandler#deserialize] %1", (Throwable)classNotFoundException);
            }
        }
    }

    private final class HistoryPersistenceHandler
    extends AbstractStorageDataContainer {
        private volatile IMemoryBufferEntry[] storageDataArray;

        private HistoryPersistenceHandler(IStorageAccess iStorageAccess, int n, int n2, int n3) {
            super(iStorageAccess, n, n2, n3);
            this.storageDataArray = new IMemoryBufferEntry[0];
        }

        private boolean write(IMemoryBufferEntry[] iMemoryBufferEntryArray) {
            if (null == iMemoryBufferEntryArray) {
                return false;
            }
            this.storageDataArray = iMemoryBufferEntryArray;
            this.serializeAndWrite();
            HybridStatisticsPersistenceManager.this.logChannel.log(10000000, "[HistoryPersistenceHandler#write] storage size: %1", (long)this.getSize());
            return true;
        }

        private IMemoryBufferEntry[] read() {
            this.readAndDeserialize();
            HybridStatisticsPersistenceManager.this.logChannel.log(10000000, "[HistoryPersistenceHandler#read] storage size: %1", (long)this.getSize());
            return this.storageDataArray;
        }

        protected void handleCRC32Error() {
            HybridStatisticsPersistenceManager.this.logChannel.log(100000, "[HistoryPersistenceHandler#handleCRC32Error]");
        }

        protected void handleStorageReadError(Exception exception) {
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
            HybridStatisticsPersistenceManager.this.logChannel.log(100000, "[HistoryPersistenceHandler#convertContainer] persistedVersion=%1, containerVersion=%2", (long)n, (long)n2);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            int n = this.storageDataArray.length;
            HybridStatisticsPersistenceManager.this.logChannel.log(10000000, "[HistoryPersistenceHandler#serialize] arrayLength=%1", (long)n);
            dataOutputStream.writeInt(n);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            for (int i2 = 0; i2 < n; ++i2) {
                IMemoryBufferEntry iMemoryBufferEntry = this.storageDataArray[i2];
                objectOutputStream.writeObject(iMemoryBufferEntry);
            }
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            int n = dataInputStream.readInt();
            HybridStatisticsPersistenceManager.this.logChannel.log(10000000, "[HistoryPersistenceHandler#deserialize] arrayLength=%1", (long)n);
            if (0 > n || 200 < n) {
                HybridStatisticsPersistenceManager.this.logChannel.log(10000, "[HistoryPersistenceHandler#deserialize] array length not valid: %1", (long)n);
                return;
            }
            this.storageDataArray = new IMemoryBufferEntry[n];
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            for (int i2 = 0; i2 < n; ++i2) {
                try {
                    IMemoryBufferEntry iMemoryBufferEntry;
                    this.storageDataArray[i2] = iMemoryBufferEntry = (IMemoryBufferEntry)objectInputStream.readObject();
                    continue;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    HybridStatisticsPersistenceManager.this.logChannel.log(10000, "[HistoryPersistenceHandler#deserialize] %1", (Throwable)classNotFoundException);
                }
            }
        }
    }
}

