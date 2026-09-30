/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FocusedListStorage {
    public static final int FOCUS_STATIONLIST = 0;
    public static final int FOCUS_FAVORITESLIST = 1;
    public static final int DEFAULT = 0;
    private int focusedList = 0;
    private final StorageDataContainer storageAccess;
    private LogChannel log;
    private static final int VERSION = 1;

    public FocusedListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.log = logChannel;
        this.storageAccess = new StorageDataContainer(iStorageAccess);
        this.storageAccess.readAndDeserialize();
    }

    public int getFocusedList() {
        return this.focusedList;
    }

    public void saveFocusedList(int n) {
        this.focusedList = n;
        this.storageAccess.serializeAndWrite();
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        public StorageDataContainer(IStorageAccess iStorageAccess) {
            super(iStorageAccess, 1, 1007, 2);
        }

        protected void handleCRC32Error() {
            FocusedListStorage.this.log.log(10000, "[ActiveListStorage.handleCRC32Error]");
        }

        protected void handleStorageReadError(Exception exception) {
            FocusedListStorage.this.log.log(100000, "[ActiveListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            FocusedListStorage.this.log.log(1000000, "[ActiveListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            FocusedListStorage.this.log.log(10000000, "[ActiveListStorage.serialize] focused list: %1", (long)FocusedListStorage.this.focusedList);
            dataOutputStream.writeInt(FocusedListStorage.this.focusedList);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            FocusedListStorage.this.focusedList = dataInputStream.readInt();
            FocusedListStorage.this.log.log(10000000, "[ActiveListStorage.deserialize] focused list: %1", (long)FocusedListStorage.this.focusedList);
        }
    }
}

