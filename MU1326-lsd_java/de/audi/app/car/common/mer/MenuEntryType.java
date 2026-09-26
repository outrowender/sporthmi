/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

public final class MenuEntryType {
    private static final int ME_TYPE_NORMAL;
    private static final int ME_TYPE_MMI_COMBI;
    private static final int ME_TYPE_SLOT;
    private static final int ME_TYPE_INCLUDE;
    private static final int ME_TYPE_PERSISTENT;
    private final String typeName;
    private final int typeID;
    public static final MenuEntryType MENU_ENTRY;
    public static final MenuEntryType INCLUDE_MENU_ENTRY;
    public static final MenuEntryType SLOT_MENU_ENTRY;
    public static final MenuEntryType MMICOMBI_MENU_ENTRY;
    public static final MenuEntryType PERSISTENT_MENU_ENTRY;

    private MenuEntryType(String string, int n) {
        this.typeName = string;
        this.typeID = n;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public int getTypeID() {
        return this.typeID;
    }

    public boolean equalsMenuEntryType(MenuEntryType menuEntryType) {
        return this.typeID == menuEntryType.getTypeID();
    }

    public boolean equals(Object object) {
        return object instanceof MenuEntryType && this.equalsMenuEntryType((MenuEntryType)object);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.typeID;
        return n;
    }

    public String toString() {
        return this.typeName;
    }

    static {
        MENU_ENTRY = new MenuEntryType("MenuEntry", 0);
        INCLUDE_MENU_ENTRY = new MenuEntryType("IncludeMenuEntry", 3);
        SLOT_MENU_ENTRY = new MenuEntryType("SlotMenuEntry", 2);
        MMICOMBI_MENU_ENTRY = new MenuEntryType("MenuEntryMMICombi", 1);
        PERSISTENT_MENU_ENTRY = new MenuEntryType("PersistentMenuEntry", 4);
    }
}

