/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.HybridStatisticsPersistenceManager;
import de.audi.app.car.core.hybrid.HybridStatisticsPersistenceManager$1;
import de.audi.app.car.core.hybrid.IHybridStatisticsConfig;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class HybridStatisticsPersistenceManager$ConfigPersistenceHandler
extends AbstractStorageDataContainer {
    private volatile IHybridStatisticsConfig storageData;
    private final /* synthetic */ HybridStatisticsPersistenceManager this$0;

    private HybridStatisticsPersistenceManager$ConfigPersistenceHandler(HybridStatisticsPersistenceManager hybridStatisticsPersistenceManager, IStorageAccess iStorageAccess, int n, int n2, int n3) {
        this.this$0 = hybridStatisticsPersistenceManager;
        super(iStorageAccess, n, n2, n3);
    }

    private boolean write(IHybridStatisticsConfig iHybridStatisticsConfig) {
        if (null == iHybridStatisticsConfig) {
            return false;
        }
        this.storageData = iHybridStatisticsConfig;
        this.serializeAndWrite();
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-2137614336, "[ConfigPersistenceHandler#write] storage size: %1", (long)this.getSize());
        return true;
    }

    private IHybridStatisticsConfig read() {
        this.readAndDeserialize();
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-2137614336, "[ConfigPersistenceHandler#read] storage size: %1", (long)this.getSize());
        return this.storageData;
    }

    @Override
    protected void handleCRC32Error() {
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-1601830656, "[ConfigPersistenceHandler#handleCRC32Error]");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-1601830656, "[ConfigPersistenceHandler#convertContainer] persistedVersion=%1, containerVersion=%2", (long)n, (long)n2);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(1);
        IHybridStatisticsConfig iHybridStatisticsConfig = this.storageData;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        objectOutputStream.writeObject(iHybridStatisticsConfig);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        HybridStatisticsPersistenceManager.access$600(this.this$0).log(-2137614336, "[ConfigPersistenceHandler#deserialize] arrayLength=%1", (long)n);
        if (1 != n) {
            HybridStatisticsPersistenceManager.access$600(this.this$0).log(10000, "[ConfigPersistenceHandler#deserialize] array length not valid: %1", (long)n);
            return;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
        try {
            IHybridStatisticsConfig iHybridStatisticsConfig;
            this.storageData = iHybridStatisticsConfig = (IHybridStatisticsConfig)objectInputStream.readObject();
        }
        catch (ClassNotFoundException classNotFoundException) {
            HybridStatisticsPersistenceManager.access$600(this.this$0).log(10000, "[ConfigPersistenceHandler#deserialize] %1", (Throwable)classNotFoundException);
        }
    }

    /* synthetic */ HybridStatisticsPersistenceManager$ConfigPersistenceHandler(HybridStatisticsPersistenceManager hybridStatisticsPersistenceManager, IStorageAccess iStorageAccess, int n, int n2, int n3, HybridStatisticsPersistenceManager$1 hybridStatisticsPersistenceManager$1) {
        this(hybridStatisticsPersistenceManager, iStorageAccess, n, n2, n3);
    }

    static /* synthetic */ boolean access$200(HybridStatisticsPersistenceManager$ConfigPersistenceHandler hybridStatisticsPersistenceManager$ConfigPersistenceHandler, IHybridStatisticsConfig iHybridStatisticsConfig) {
        return hybridStatisticsPersistenceManager$ConfigPersistenceHandler.write(iHybridStatisticsConfig);
    }

    static /* synthetic */ IHybridStatisticsConfig access$300(HybridStatisticsPersistenceManager$ConfigPersistenceHandler hybridStatisticsPersistenceManager$ConfigPersistenceHandler) {
        return hybridStatisticsPersistenceManager$ConfigPersistenceHandler.read();
    }
}

