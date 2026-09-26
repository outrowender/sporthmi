/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerTypes$1;
import de.audi.remotehmi.ui.mib2.DrawerEntry;

abstract class RightDrawerTypes$AbstractDrawerEntryMatcher {
    protected String property;
    private final /* synthetic */ RightDrawerTypes this$0;

    private RightDrawerTypes$AbstractDrawerEntryMatcher(RightDrawerTypes rightDrawerTypes) {
        this.this$0 = rightDrawerTypes;
    }

    abstract boolean matches(DrawerEntry drawerEntry) {
    }

    public String toString() {
        return this.property;
    }

    /* synthetic */ RightDrawerTypes$AbstractDrawerEntryMatcher(RightDrawerTypes rightDrawerTypes, RightDrawerTypes$1 rightDrawerTypes$1) {
        this(rightDrawerTypes);
    }
}

