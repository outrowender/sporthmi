/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.EventObject;
import org.osgi.framework.Bundle;

public class BundleEvent
extends EventObject {
    private transient Bundle bundle;
    private transient int type;
    public static final int INSTALLED = 1;
    public static final int STARTED = 2;
    public static final int STOPPED = 4;
    public static final int UPDATED = 8;
    public static final int UNINSTALLED = 16;

    public BundleEvent(int n, Bundle bundle) {
        super(bundle);
        this.bundle = bundle;
        this.type = n;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public int getType() {
        return this.type;
    }
}

