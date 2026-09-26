/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.tv.app.storage.MemoryListStorage;
import de.audi.tv.app.storage.ServiceStoreHelper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.dsi.ifc.tvtuner.ServiceInfo;

class MemoryListStorage$StorageDataContainer
extends AbstractStorageDataContainer {
    private ServiceInfo[] rows;
    private final /* synthetic */ MemoryListStorage this$0;

    MemoryListStorage$StorageDataContainer(MemoryListStorage memoryListStorage) {
        this.this$0 = memoryListStorage;
        super(MemoryListStorage.access$000(memoryListStorage), 1, 1007, 19);
        this.rows = this.this$0.createEmptyMemoryList();
    }

    @Override
    protected void handleCRC32Error() {
        MemoryListStorage.access$100(this.this$0).log(10000, "[MemoryListStorage.handleCRC32Error]");
        this.rows = this.this$0.createEmptyMemoryList();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        MemoryListStorage.access$100(this.this$0).log(-1601830656, "[MemoryListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
        this.rows = this.this$0.createEmptyMemoryList();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        MemoryListStorage.access$100(this.this$0).log(1078071040, "[MemoryListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        this.rows = this.this$0.createEmptyMemoryList();
    }

    void setRows(ServiceInfo[] serviceInfoArray) {
        this.rows = serviceInfoArray;
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        MemoryListStorage.access$100(this.this$0).log(-2137614336, "[MemoryListStorage.serialize]");
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

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        MemoryListStorage.access$100(this.this$0).log(-2137614336, "[MemoryListStorage.deserialize]");
        int n = dataInputStream.readInt();
        if (n != 50) {
            MemoryListStorage.access$100(this.this$0).log(-1601830656, "[MemoryListStorage.deserialize] List size mismatch! stored:%1 expected:%2", (long)n, (long)0);
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

