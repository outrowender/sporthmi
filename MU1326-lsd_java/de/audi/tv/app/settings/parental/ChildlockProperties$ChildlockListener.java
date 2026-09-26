/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.tv.app.settings.parental.ChildlockProperties$Properties
 */
package de.audi.tv.app.settings.parental;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.settings.parental.ChildlockProperties;
import de.audi.tv.app.settings.parental.ChildlockProperties$1;

class ChildlockProperties$ChildlockListener
extends TVEventDefaultListener {
    private final /* synthetic */ ChildlockProperties this$0;

    private ChildlockProperties$ChildlockListener(ChildlockProperties childlockProperties) {
        this.this$0 = childlockProperties;
    }

    @Override
    public void onChildLockEnabled() {
        ChildlockProperties.Properties.access$200((ChildlockProperties.Properties)ChildlockProperties.access$100(this.this$0)).accept(new Boolean(true));
    }

    @Override
    public void onChildLockDisabled() {
        ChildlockProperties.Properties.access$200((ChildlockProperties.Properties)ChildlockProperties.access$100(this.this$0)).accept(new Boolean(false));
    }

    @Override
    public void parentalLevelSettingChanged(int n) {
        ChildlockProperties.Properties.access$300((ChildlockProperties.Properties)ChildlockProperties.access$100(this.this$0)).accept(new Integer(n));
    }

    /* synthetic */ ChildlockProperties$ChildlockListener(ChildlockProperties childlockProperties, ChildlockProperties$1 childlockProperties$1) {
        this(childlockProperties);
    }
}

