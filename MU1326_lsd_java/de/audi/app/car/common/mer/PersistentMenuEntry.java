/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryPersistence;
import de.audi.app.car.common.mer.MenuEntryType;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class PersistentMenuEntry
extends MenuEntry {
    private final MenuEntryPersistence persistence;

    public PersistentMenuEntry(int n, String string, int n2, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, MenuEntryPersistence menuEntryPersistence) {
        super(n, string, n2, iFrameworkAccess, logChannel);
        this.persistence = menuEntryPersistence;
    }

    public PersistentMenuEntry(int n, String string, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, MenuEntryPersistence menuEntryPersistence) {
        super(n, string, iFrameworkAccess, logChannel);
        this.persistence = menuEntryPersistence;
    }

    protected void setStateViewOptions(int n) {
        super.setStateViewOptions(n);
        this.persistence.writePersistentViewOptionState(this, n);
    }

    public MenuEntryType getType() {
        return MenuEntryType.PERSISTENT_MENU_ENTRY;
    }

    public int getStateViewOptionsForRegistration() {
        int n = this.persistence.readPersistentViewOptionState();
        this.logChannel.log(10000000, "[%1('%2')#getStateViewOptionsForRegistration] HMI persistence returns stateViewOptions='%3'", (Object)this.getType(), (Object)this, (long)n);
        return n;
    }
}

