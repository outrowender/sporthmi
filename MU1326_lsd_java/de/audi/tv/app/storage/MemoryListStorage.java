/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.storage.MemoryListStorage$StorageDataContainer;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class MemoryListStorage {
    private static final int VERSION;
    public static final int FAVORITES_MAX_ROWS;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;

    MemoryListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    void write(ServiceInfo[] serviceInfoArray) {
        this.lc.log(-2137614336, "[MemoryListStorage.write]");
        MemoryListStorage$StorageDataContainer memoryListStorage$StorageDataContainer = new MemoryListStorage$StorageDataContainer(this);
        memoryListStorage$StorageDataContainer.setRows(serviceInfoArray);
        memoryListStorage$StorageDataContainer.serializeAndWrite();
    }

    ServiceInfo[] read() {
        this.lc.log(-2137614336, "[MemoryListStorage.read]");
        MemoryListStorage$StorageDataContainer memoryListStorage$StorageDataContainer = new MemoryListStorage$StorageDataContainer(this);
        memoryListStorage$StorageDataContainer.readAndDeserialize();
        return memoryListStorage$StorageDataContainer.getRows();
    }

    ServiceInfo[] createEmptyMemoryList() {
        return new ServiceInfo[50];
    }

    static /* synthetic */ IStorageAccess access$000(MemoryListStorage memoryListStorage) {
        return memoryListStorage.storageAccess;
    }

    static /* synthetic */ LogChannel access$100(MemoryListStorage memoryListStorage) {
        return memoryListStorage.lc;
    }
}

