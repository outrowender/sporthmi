/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes$AbstractDrawerEntryMatcher;
import de.audi.remotehmi.ui.mib2.DrawerEntry;

class RightDrawerTypes$AppIdMatcher
extends RightDrawerTypes$AbstractDrawerEntryMatcher {
    private final /* synthetic */ RightDrawerTypes this$0;

    public RightDrawerTypes$AppIdMatcher(RightDrawerTypes rightDrawerTypes, String string) {
        this.this$0 = rightDrawerTypes;
        super(rightDrawerTypes, null);
        this.property = string;
    }

    @Override
    public boolean matches(DrawerEntry drawerEntry) {
        if (drawerEntry == null || drawerEntry.getAppId() == null) {
            return false;
        }
        return drawerEntry.getAppId().equals(this.property);
    }
}

