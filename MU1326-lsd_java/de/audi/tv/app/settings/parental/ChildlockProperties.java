/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.tv.app.settings.parental.ChildlockProperties$Properties
 */
package de.audi.tv.app.settings.parental;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.settings.parental.ChildlockProperties;
import de.audi.tv.app.settings.parental.ChildlockProperties$ChildlockListener;

public class ChildlockProperties {
    public final TVEventDefaultListener childLockListener = new ChildlockProperties$ChildlockListener(this, null);
    private final Properties myProperties;

    public ChildlockProperties(TVEnv tVEnv) {
        this.myProperties = tVEnv.properties.childlock;
    }

    static /* synthetic */ Properties access$100(ChildlockProperties childlockProperties) {
        return childlockProperties.myProperties;
    }
}

