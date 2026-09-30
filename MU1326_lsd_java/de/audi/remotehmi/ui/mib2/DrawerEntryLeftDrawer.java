/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.DrawerEntry;
import de.audi.remotehmi.ui.mib2.DrawerEntryIcon;

public interface DrawerEntryLeftDrawer
extends DrawerEntry {
    public DrawerEntryIcon getClosedIcon();

    public DrawerEntryIcon getClosedInactiveIcon();

    public void updateIconPath(int var1, String var2);
}

