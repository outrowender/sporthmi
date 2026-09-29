/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IncludeMenuEntry;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryPersistence;
import de.audi.app.car.common.mer.PersistentMenuEntry;
import de.audi.app.car.common.mer.SlotMenuEntry;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;

public abstract class AbstractMenuEntryFactory {
    private final IFrameworkAccess frameworkAccess;
    private final LogChannel logChannel;
    private HashMap menuEntries;

    public AbstractMenuEntryFactory(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, HashMap hashMap) {
        this.frameworkAccess = iFrameworkAccess;
        this.logChannel = logChannel;
        this.menuEntries = hashMap;
    }

    public final MenuEntry createMenuEntry(int n, String string, int n2) {
        MenuEntry menuEntry = new MenuEntry(n, string, n2, this.getFrameworkAccess(), this.getLogChannel());
        this.getMenuEntries().put(new Integer(n), menuEntry);
        return menuEntry;
    }

    public final MenuEntry createMenuEntry(int n, String string) {
        MenuEntry menuEntry = new MenuEntry(n, string, this.getFrameworkAccess(), this.getLogChannel());
        this.getMenuEntries().put(new Integer(n), menuEntry);
        return menuEntry;
    }

    public final MenuEntry createMenuEntry(int n, String string, MenuEntryPersistence menuEntryPersistence) {
        PersistentMenuEntry persistentMenuEntry = new PersistentMenuEntry(n, string, this.getFrameworkAccess(), this.getLogChannel(), menuEntryPersistence);
        this.getMenuEntries().put(new Integer(n), persistentMenuEntry);
        return persistentMenuEntry;
    }

    public final MenuEntry createMenuEntry(int n, String string, int n2, MenuEntryPersistence menuEntryPersistence) {
        PersistentMenuEntry persistentMenuEntry = new PersistentMenuEntry(n, string, n2, this.getFrameworkAccess(), this.getLogChannel(), menuEntryPersistence);
        this.getMenuEntries().put(new Integer(n), persistentMenuEntry);
        return persistentMenuEntry;
    }

    public final SlotMenuEntry createSlotMenuEntry(int n, String string, int[] nArray) {
        SlotMenuEntry slotMenuEntry = new SlotMenuEntry(n, string, this.getFrameworkAccess(), this.getLogChannel(), nArray);
        this.getMenuEntries().put(new Integer(n), slotMenuEntry);
        return slotMenuEntry;
    }

    public final IncludeMenuEntry createIncludeMenuEntry(int n, String string, int[] nArray) {
        IncludeMenuEntry includeMenuEntry = new IncludeMenuEntry(n, string, this.getFrameworkAccess(), this.getLogChannel(), nArray);
        this.getMenuEntries().put(new Integer(n), includeMenuEntry);
        return includeMenuEntry;
    }

    protected IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    protected LogChannel getLogChannel() {
        return this.logChannel;
    }

    protected HashMap getMenuEntries() {
        return this.menuEntries;
    }
}

