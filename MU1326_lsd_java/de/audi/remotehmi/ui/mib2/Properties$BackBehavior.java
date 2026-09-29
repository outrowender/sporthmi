/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.util.EnumHelper;

public class Properties$BackBehavior {
    private static final EnumHelper enumHelper = new EnumHelper();
    private final String name;
    private final boolean openSelectionDrawerOnHkReturn;
    public static final Properties$BackBehavior normal = new Properties$BackBehavior("normal", false);
    public static final Properties$BackBehavior openSelectionDrawer = new Properties$BackBehavior("openSelectionDrawer", true);

    private Properties$BackBehavior(String string, boolean bl) {
        this.name = string;
        this.openSelectionDrawerOnHkReturn = bl;
        enumHelper.addInstance(string, this);
    }

    public String getName() {
        return this.name;
    }

    public static final Properties$BackBehavior valueOf(String string) {
        return (Properties$BackBehavior)enumHelper.valueOf(string);
    }

    public String toString() {
        return this.getName();
    }

    public boolean isSelectionDrawerOpenedOnHkReturn() {
        return this.openSelectionDrawerOnHkReturn;
    }
}

