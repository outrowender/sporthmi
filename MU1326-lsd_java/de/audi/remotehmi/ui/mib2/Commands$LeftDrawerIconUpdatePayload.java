/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;
import de.audi.remotehmi.ui.mib2.DrawerEntryLeftDrawer;

public class Commands$LeftDrawerIconUpdatePayload
extends Commands$AbstractContextPayload {
    private final DrawerEntryLeftDrawer drawerEntry;
    private final int updateType;

    public Commands$LeftDrawerIconUpdatePayload(String string, DrawerEntryLeftDrawer drawerEntryLeftDrawer, int n) {
        super(string);
        this.drawerEntry = drawerEntryLeftDrawer;
        this.updateType = n;
    }

    public final DrawerEntryLeftDrawer getDrawerEntry() {
        return this.drawerEntry;
    }

    public final int getUpdateType() {
        return this.updateType;
    }
}

