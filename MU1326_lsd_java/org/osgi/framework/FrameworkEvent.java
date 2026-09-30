/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.EventObject;
import org.osgi.framework.Bundle;

public class FrameworkEvent
extends EventObject {
    private transient Bundle bundle;
    private transient Throwable throwable;
    private transient int type;
    public static final int STARTED = 1;
    public static final int ERROR = 2;
    public static final int PACKAGES_REFRESHED = 4;
    public static final int STARTLEVEL_CHANGED = 8;

    public FrameworkEvent(int n, Object object) {
        super(object);
        this.type = n;
        this.bundle = null;
        this.throwable = null;
    }

    public FrameworkEvent(int n, Bundle bundle, Throwable throwable) {
        super(bundle);
        this.type = n;
        this.bundle = bundle;
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public int getType() {
        return this.type;
    }
}

