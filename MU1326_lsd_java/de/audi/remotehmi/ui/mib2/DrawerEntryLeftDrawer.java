/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.DrawerEntry;
import de.audi.remotehmi.ui.mib2.DrawerEntryIcon;

public interface DrawerEntryLeftDrawer
extends DrawerEntry {
    default public DrawerEntryIcon getClosedIcon() {
    }

    default public DrawerEntryIcon getClosedInactiveIcon() {
    }

    default public void updateIconPath(int n, String string) {
    }
}

