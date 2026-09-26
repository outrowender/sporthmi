/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.storage.LogoListStorage$StorageDataContainer;
import org.dsi.ifc.tvtuner.LogoInfo;

public class LogoListStorage {
    private final IStorageAccess storageAccess;
    private final LogChannel lc;
    private static final int VERSION;

    public LogoListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    public void write(LogoInfo[] logoInfoArray) {
        this.lc.log(-2137614336, "[LogoListStorage.write]");
        LogoListStorage$StorageDataContainer logoListStorage$StorageDataContainer = new LogoListStorage$StorageDataContainer(this);
        logoListStorage$StorageDataContainer.setRows(logoInfoArray);
        logoListStorage$StorageDataContainer.serializeAndWrite();
    }

    public LogoInfo[] read() {
        this.lc.log(-2137614336, "[LogoListStorage.read]");
        LogoListStorage$StorageDataContainer logoListStorage$StorageDataContainer = new LogoListStorage$StorageDataContainer(this);
        logoListStorage$StorageDataContainer.readAndDeserialize();
        return logoListStorage$StorageDataContainer.getRows();
    }

    private LogoInfo[] createEmptyMemoryList() {
        return new LogoInfo[50];
    }

    static /* synthetic */ LogoInfo[] access$000(LogoListStorage logoListStorage) {
        return logoListStorage.createEmptyMemoryList();
    }

    static /* synthetic */ IStorageAccess access$100(LogoListStorage logoListStorage) {
        return logoListStorage.storageAccess;
    }

    static /* synthetic */ LogChannel access$200(LogoListStorage logoListStorage) {
        return logoListStorage.lc;
    }
}

