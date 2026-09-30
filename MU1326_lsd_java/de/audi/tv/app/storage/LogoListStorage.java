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
import org.dsi.ifc.tvtuner.LogoInfo;

public class LogoListStorage {
    private final IStorageAccess storageAccess;
    private final LogChannel lc;
    private static final int VERSION = 1;

    public LogoListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    public void write(LogoInfo[] logoInfoArray) {
        this.lc.log(10000000, "[LogoListStorage.write]");
        StorageDataContainer storageDataContainer = new StorageDataContainer();
        storageDataContainer.setRows(logoInfoArray);
        storageDataContainer.serializeAndWrite();
    }

    public LogoInfo[] read() {
        this.lc.log(10000000, "[LogoListStorage.read]");
        StorageDataContainer storageDataContainer = new StorageDataContainer();
        storageDataContainer.readAndDeserialize();
        return storageDataContainer.getRows();
    }

    private LogoInfo[] createEmptyMemoryList() {
        return new LogoInfo[50];
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        private LogoInfo[] rows;

        StorageDataContainer() {
            super(LogoListStorage.this.storageAccess, 1, 1007, 3);
            this.rows = LogoListStorage.this.createEmptyMemoryList();
        }

        protected void handleCRC32Error() {
            LogoListStorage.this.lc.log(10000, "[LogoListStorage.handleCRC32Error]");
            this.rows = LogoListStorage.this.createEmptyMemoryList();
        }

        protected void handleStorageReadError(Exception exception) {
            LogoListStorage.this.lc.log(100000, "[LogoListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
            this.rows = LogoListStorage.this.createEmptyMemoryList();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            LogoListStorage.this.lc.log(1000000, "[LogoListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
            this.rows = LogoListStorage.this.createEmptyMemoryList();
        }

        void setRows(LogoInfo[] logoInfoArray) {
            this.rows = logoInfoArray;
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            LogoListStorage.this.lc.log(10000000, "[LogoListStorage.serialize]");
            dataOutputStream.writeInt(this.rows.length);
            for (int i2 = 0; i2 < this.rows.length; ++i2) {
                boolean bl = this.rows[i2] != null;
                dataOutputStream.writeBoolean(bl);
                if (!bl) continue;
                ServiceStoreHelper.serializeLogo(this.rows[i2], dataOutputStream);
            }
        }

        LogoInfo[] getRows() {
            return this.rows;
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            LogoListStorage.this.lc.log(10000000, "[LogoListStorage.deserialize]");
            int n = dataInputStream.readInt();
            if (n != 50) {
                LogoListStorage.this.lc.log(100000, "[LogoListStorage.deserialize] List size mismatch! stored:%1 expected:%2", (long)n, 50L);
                return;
            }
            this.rows = new LogoInfo[n];
            for (int i2 = 0; i2 < this.rows.length; ++i2) {
                boolean bl = dataInputStream.readBoolean();
                if (!bl) continue;
                this.rows[i2] = ServiceStoreHelper.deserializeLogo(dataInputStream);
            }
        }
    }
}

