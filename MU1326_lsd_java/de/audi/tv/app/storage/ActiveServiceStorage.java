/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.storage.ActiveServiceStorage$StorageDataContainer;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class ActiveServiceStorage {
    public static final ServiceInfo DEFAULT_SERVICE_INFO = new ServiceInfo(0L, 0, "", 15, 0);
    private static final int VERSION;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;

    ActiveServiceStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    ServiceInfo load() {
        ActiveServiceStorage$StorageDataContainer activeServiceStorage$StorageDataContainer = new ActiveServiceStorage$StorageDataContainer(this);
        activeServiceStorage$StorageDataContainer.readAndDeserialize();
        return activeServiceStorage$StorageDataContainer.getServiceInfo();
    }

    void save(ServiceInfo serviceInfo) {
        ActiveServiceStorage$StorageDataContainer activeServiceStorage$StorageDataContainer = new ActiveServiceStorage$StorageDataContainer(this);
        activeServiceStorage$StorageDataContainer.setServiceInfo(serviceInfo);
        activeServiceStorage$StorageDataContainer.serializeAndWrite();
    }

    static /* synthetic */ IStorageAccess access$000(ActiveServiceStorage activeServiceStorage) {
        return activeServiceStorage.storageAccess;
    }

    static /* synthetic */ LogChannel access$100(ActiveServiceStorage activeServiceStorage) {
        return activeServiceStorage.lc;
    }
}

