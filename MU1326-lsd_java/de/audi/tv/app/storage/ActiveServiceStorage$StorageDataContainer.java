/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.tv.app.storage.ActiveServiceStorage;
import de.audi.tv.app.storage.ServiceStoreHelper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.dsi.ifc.tvtuner.ServiceInfo;

class ActiveServiceStorage$StorageDataContainer
extends AbstractStorageDataContainer {
    private ServiceInfo serviceInfo;
    private final /* synthetic */ ActiveServiceStorage this$0;

    ActiveServiceStorage$StorageDataContainer(ActiveServiceStorage activeServiceStorage) {
        this.this$0 = activeServiceStorage;
        super(ActiveServiceStorage.access$000(activeServiceStorage), 1, 1007, 29);
        this.serviceInfo = ActiveServiceStorage.DEFAULT_SERVICE_INFO;
    }

    @Override
    protected void handleCRC32Error() {
        ActiveServiceStorage.access$100(this.this$0).log(10000, "[ActiveServiceStorage.handleCRC32Error]");
        this.serviceInfo = ActiveServiceStorage.DEFAULT_SERVICE_INFO;
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        ActiveServiceStorage.access$100(this.this$0).log(-1601830656, "[ActiveServiceStorage.handleStorageReadError] %1", (Object)exception.getMessage());
        this.serviceInfo = ActiveServiceStorage.DEFAULT_SERVICE_INFO;
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        ActiveServiceStorage.access$100(this.this$0).log(1078071040, "[ActiveServiceStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        this.serviceInfo = ActiveServiceStorage.DEFAULT_SERVICE_INFO;
    }

    void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        ActiveServiceStorage.access$100(this.this$0).log(-2137614336, "[ActiveServiceStorage.serialize]");
        ServiceStoreHelper.serializeServices(this.serviceInfo, dataOutputStream);
    }

    ServiceInfo getServiceInfo() {
        return this.serviceInfo;
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        ActiveServiceStorage.access$100(this.this$0).log(-2137614336, "[ActiveServiceStorage.deserialize]");
        this.serviceInfo = ServiceStoreHelper.deserializeServices(dataInputStream);
    }
}

