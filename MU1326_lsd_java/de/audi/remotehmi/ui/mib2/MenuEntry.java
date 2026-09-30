/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.DrawerEntryLeftDrawer;
import de.audi.remotehmi.util.DeepCloneable;
import java.util.List;

public interface MenuEntry
extends DeepCloneable {
    public List getRightDrawerEntries();

    public DrawerEntryLeftDrawer getLeftDrawerEntry();

    public List getLeftDrawerSubEntries();
}

