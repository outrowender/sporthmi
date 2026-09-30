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

public class MemoryListStorage {
    private static final int VERSION = 1;
    public static final int FAVORITES_MAX_ROWS = 50;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;

    MemoryListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    void write(ServiceInfo[] serviceInfoArray) {
        this.lc.log(10000000, "[MemoryListStorage.write]");
        StorageDataContainer storageDataContainer = new StorageDataContainer();
        storageDataContainer.setRows(serviceInfoArray);
        storageDataContainer.serializeAndWrite();
    }

    ServiceInfo[] read() {
        this.lc.log(10000000, "[MemoryListStorage.read]");
        StorageDataContainer storageDataContainer = new StorageDataContainer();
        storageDataContainer.readAndDeserialize();
        return storageDataContainer.getRows();
    }

    ServiceInfo[] createEmptyMemoryList() {
        return new ServiceInfo[50];
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        private ServiceInfo[] rows;

        StorageDataContainer() {
            super(MemoryListStorage.this.storageAccess, 1, 1007, 19);
            this.rows = MemoryListStorage.this.createEmptyMemoryList();
        }

        protected void handleCRC32Error() {
            MemoryListStorage.this.lc.log(10000, "[MemoryListStorage.handleCRC32Error]");
            this.rows = MemoryListStorage.this.createEmptyMemoryList();
        }

        protected void handleStorageReadError(Exception exception) {
            MemoryListStorage.this.lc.log(100000, "[MemoryListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
            this.rows = MemoryListStorage.this.createEmptyMemoryList();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            MemoryListStorage.this.lc.log(1000000, "[MemoryListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
            this.rows = MemoryListStorage.this.createEmptyMemoryList();
        }

        void setRows(ServiceInfo[] serviceInfoArray) {
            this.rows = serviceInfoArray;
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            MemoryListStorage.this.lc.log(10000000, "[MemoryListStorage.serialize]");
            dataOutputStream.writeInt(this.rows.length);
            for (int i2 = 0; i2 < this.rows.length; ++i2) {
                boolean bl = this.rows[i2] != null;
                dataOutputStream.writeBoolean(bl);
                if (!bl) continue;
                ServiceStoreHelper.serializeServices(this.rows[i2], dataOutputStream);
            }
        }

        ServiceInfo[] getRows() {
            return this.rows;
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            MemoryListStorage.this.lc.log(10000000, "[MemoryListStorage.deserialize]");
            int n = dataInputStream.readInt();
            if (n != 50) {
                MemoryListStorage.this.lc.log(100000, "[MemoryListStorage.deserialize] List size mismatch! stored:%1 expected:%2", (long)n, 50L);
                return;
            }
            this.rows = new ServiceInfo[n];
            for (int i2 = 0; i2 < this.rows.length; ++i2) {
                boolean bl = dataInputStream.readBoolean();
                if (!bl) continue;
                this.rows[i2] = ServiceStoreHelper.deserializeServices(dataInputStream);
            }
        }
    }
}

