/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.storage.ServiceStoreHelper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class ActiveServiceStorage {
    public static final ServiceInfo DEFAULT_SERVICE_INFO = new ServiceInfo(0L, 0, "", 15, 0);
    private static final int VERSION = 1;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;

    ActiveServiceStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    ServiceInfo load() {
        StorageDataContainer storageDataContainer = new StorageDataContainer();
        storageDataContainer.readAndDeserialize();
        return storageDataContainer.getServiceInfo();
    }

    void save(ServiceInfo serviceInfo) {
        StorageDataContainer storageDataContainer = new StorageDataContainer();
        storageDataContainer.setServiceInfo(serviceInfo);
        storageDataContainer.serializeAndWrite();
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        private ServiceInfo serviceInfo;

        StorageDataContainer() {
            super(ActiveServiceStorage.this.storageAccess, 1, 1007, 29);
            this.serviceInfo = DEFAULT_SERVICE_INFO;
        }

        protected void handleCRC32Error() {
            ActiveServiceStorage.this.lc.log(10000, "[ActiveServiceStorage.handleCRC32Error]");
            this.serviceInfo = DEFAULT_SERVICE_INFO;
        }

        protected void handleStorageReadError(Exception exception) {
            ActiveServiceStorage.this.lc.log(100000, "[ActiveServiceStorage.handleStorageReadError] %1", (Object)exception.getMessage());
            this.serviceInfo = DEFAULT_SERVICE_INFO;
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            ActiveServiceStorage.this.lc.log(1000000, "[ActiveServiceStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
            this.serviceInfo = DEFAULT_SERVICE_INFO;
        }

        void setServiceInfo(ServiceInfo serviceInfo) {
            this.serviceInfo = serviceInfo;
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            ActiveServiceStorage.this.lc.log(10000000, "[ActiveServiceStorage.serialize]");
            ServiceStoreHelper.serializeServices(this.serviceInfo, dataOutputStream);
        }

        ServiceInfo getServiceInfo() {
            return this.serviceInfo;
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            ActiveServiceStorage.this.lc.log(10000000, "[ActiveServiceStorage.deserialize]");
            this.serviceInfo = ServiceStoreHelper.deserializeServices(dataInputStream);
        }
    }
}

