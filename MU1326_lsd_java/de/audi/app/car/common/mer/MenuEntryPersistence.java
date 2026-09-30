/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.PersistentMenuEntry;
import de.audi.atip.storage.IStorageAccess;

public class MenuEntryPersistence {
    static final int PERSISTENCE_NAMESPACE = 1006;
    private final IStorageAccess storageAccess;
    private final int persistenceKey;

    public MenuEntryPersistence(IStorageAccess iStorageAccess, int n) {
        this.storageAccess = iStorageAccess;
        this.persistenceKey = n;
    }

    public int readPersistentViewOptionState() {
        if (this.storageAccess != null) {
            return this.storageAccess.getInt(1006, this.persistenceKey, 2);
        }
        return 2;
    }

    public void writePersistentViewOptionState(PersistentMenuEntry persistentMenuEntry, int n) {
        if (this.storageAccess != null) {
            persistentMenuEntry.logChannel.log(10000000, "[%1('%2')#writePersistentViewOptionState] saves ViewOption state of Menu Entry persistently: NameSpace.Car, persistenceKey='%3', stateViewOptions='%4'", (Object)persistentMenuEntry.getType(), (Object)persistentMenuEntry, (Object)new Integer(this.persistenceKey), (long)n);
            this.storageAccess.setInt(1006, this.persistenceKey, n);
        }
    }
}

