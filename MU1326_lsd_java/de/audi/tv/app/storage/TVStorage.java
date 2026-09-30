/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.storage.ActiveServiceStorage;
import de.audi.tv.app.storage.ActiveSourceStorage;
import de.audi.tv.app.storage.MemoryListStorage;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVStorage {
    private final IStorageAccess storageAccess;
    private final LogChannel lc;
    private volatile ServiceInfo activeService;
    private final ActiveServiceStorage activeServiceStorage;
    private final ActiveSourceStorage activeSourceStorage;

    public TVStorage(TVEnv tVEnv) {
        this.storageAccess = tVEnv.framework.getStorageMgr();
        this.lc = tVEnv.lcMain;
        this.activeServiceStorage = new ActiveServiceStorage(this.storageAccess, this.lc);
        this.activeSourceStorage = new ActiveSourceStorage(this.storageAccess, this.lc);
    }

    public void setTunedService(ServiceInfo serviceInfo) {
        this.lc.log(10000000, "[TVStorage.setTunedService] %1", (Object)serviceInfo);
        if (TVUtil.equalsFullPID(this.activeService, serviceInfo) && this.activeService.name.equals(serviceInfo.name)) {
            return;
        }
        this.activeService = serviceInfo;
        this.activeServiceStorage.save(serviceInfo);
    }

    public ServiceInfo getTunedService() {
        if (this.activeService == null) {
            this.activeService = this.activeServiceStorage.load();
        }
        this.lc.log(10000000, "[TVStorage.getTunedService] %1", (Object)this.activeService);
        return this.activeService;
    }

    public ServiceInfo[] loadMemoryList() {
        this.lc.log(100000000, "[TVStorage.loadMemoryList]");
        MemoryListStorage memoryListStorage = new MemoryListStorage(this.storageAccess, this.lc);
        ServiceInfo[] serviceInfoArray = memoryListStorage.read();
        return serviceInfoArray;
    }

    void saveFavoriteList(ServiceInfo[] serviceInfoArray) {
        this.lc.log(100000000, "[TVStorage.saveMemoryList]");
        MemoryListStorage memoryListStorage = new MemoryListStorage(this.storageAccess, this.lc);
        memoryListStorage.write(serviceInfoArray);
    }

    public void removeMemoryList() {
        this.lc.log(10000000, "[TVStorage.removeMemoryList]");
        MemoryListStorage memoryListStorage = new MemoryListStorage(this.storageAccess, this.lc);
        memoryListStorage.write(memoryListStorage.createEmptyMemoryList());
    }

    public void setActiveSource(int n) {
        this.activeSourceStorage.setActiveSource(n);
    }

    public int getActiveSource() {
        return this.activeSourceStorage.getActiveSource();
    }

    public void setAvSourceAvailable(boolean bl) {
        this.activeSourceStorage.setAvSourceAvailable(bl);
    }

    public boolean isAvSourceAvailable() {
        return this.activeSourceStorage.isAvSourceAvailable();
    }
}

