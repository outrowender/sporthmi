/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.storage.FocusedListStorage$StorageDataContainer;

public class FocusedListStorage {
    public static final int FOCUS_STATIONLIST;
    public static final int FOCUS_FAVORITESLIST;
    public static final int DEFAULT;
    private int focusedList = 0;
    private final FocusedListStorage$StorageDataContainer storageAccess;
    private LogChannel log;
    private static final int VERSION;

    public FocusedListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.log = logChannel;
        this.storageAccess = new FocusedListStorage$StorageDataContainer(this, iStorageAccess);
        this.storageAccess.readAndDeserialize();
    }

    public int getFocusedList() {
        return this.focusedList;
    }

    public void saveFocusedList(int n) {
        this.focusedList = n;
        this.storageAccess.serializeAndWrite();
    }

    static /* synthetic */ LogChannel access$000(FocusedListStorage focusedListStorage) {
        return focusedListStorage.log;
    }

    static /* synthetic */ int access$100(FocusedListStorage focusedListStorage) {
        return focusedListStorage.focusedList;
    }

    static /* synthetic */ int access$102(FocusedListStorage focusedListStorage, int n) {
        focusedListStorage.focusedList = n;
        return focusedListStorage.focusedList;
    }
}

