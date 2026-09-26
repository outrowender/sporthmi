/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.HybridStatisticsPersistenceManager;
import de.audi.app.car.core.hybrid.HybridStatisticsPersistenceManager$1;
import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class HybridStatisticsPersistenceManager$HistoryPersistenceHandler
extends AbstractStorageDataContainer {
    private volatile IMemoryBufferEntry[] storageDataArray;
    private final /* synthetic */ HybridStatisticsPersistenceManager this$0;

    private HybridStatisticsPersistenceManager$HistoryPersistenceHandler(HybridStatisticsPersistenceManager hybridStatisticsPersistenceManager, IStorageAccess iStorageAccess, int n, int n2, int n3) {
        this.this$0 = hybridStatisticsPersistenceManager;
        super(iStorageAccess, n, n2, n3);
        this.storageDataArray = new IMemoryBufferEntry[0];
    }

    private boolean write(IMemoryBufferEntry[] iMemoryBufferEntryArray) {
        if (null == iMemoryBufferEntryArray) {
            return false;
        }
        this.storageDataArray = iMemoryBufferEntryArray;
        this.serializeAndWrite();
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-2137614336, "[HistoryPersistenceHandler#write] storage size: %1", (long)this.getSize());
        return true;
    }

    private IMemoryBufferEntry[] read() {
        this.readAndDeserialize();
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-2137614336, "[HistoryPersistenceHandler#read] storage size: %1", (long)this.getSize());
        return this.storageDataArray;
    }

    @Override
    protected void handleCRC32Error() {
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-1601830656, "[HistoryPersistenceHandler#handleCRC32Error]");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-1601830656, "[HistoryPersistenceHandler#convertContainer] persistedVersion=%1, containerVersion=%2", (long)n, (long)n2);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        int n = this.storageDataArray.length;
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-2137614336, "[HistoryPersistenceHandler#serialize] arrayLength=%1", (long)n);
        dataOutputStream.writeInt(n);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        for (int i2 = 0; i2 < n; ++i2) {
            IMemoryBufferEntry iMemoryBufferEntry = this.storageDataArray[i2];
            objectOutputStream.writeObject(iMemoryBufferEntry);
        }
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-2137614336, "[HistoryPersistenceHandler#deserialize] arrayLength=%1", (long)n);
        if (0 > n || 200 < n) {
            HybridStatisticsPersistenceManager.access$600(this.this$0).log(10000, "[HistoryPersistenceHandler#deserialize] array length not valid: %1", (long)n);
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
                HybridStatisticsPersistenceManager.access$600(this.this$0).log(10000, "[HistoryPersistenceHandler#deserialize] %1", (Throwable)classNotFoundException);
            }
        }
    }

    /* synthetic */ HybridStatisticsPersistenceManager$HistoryPersistenceHandler(HybridStatisticsPersistenceManager hybridStatisticsPersistenceManager, IStorageAccess iStorageAccess, int n, int n2, int n3, HybridStatisticsPersistenceManager$1 hybridStatisticsPersistenceManager$1) {
        this(hybridStatisticsPersistenceManager, iStorageAccess, n, n2, n3);
    }

    static /* synthetic */ boolean access$400(HybridStatisticsPersistenceManager$HistoryPersistenceHandler hybridStatisticsPersistenceManager$HistoryPersistenceHandler, IMemoryBufferEntry[] iMemoryBufferEntryArray) {
        return hybridStatisticsPersistenceManager$HistoryPersistenceHandler.write(iMemoryBufferEntryArray);
    }

    static /* synthetic */ IMemoryBufferEntry[] access$500(HybridStatisticsPersistenceManager$HistoryPersistenceHandler hybridStatisticsPersistenceManager$HistoryPersistenceHandler) {
        return hybridStatisticsPersistenceManager$HistoryPersistenceHandler.read();
    }
}

