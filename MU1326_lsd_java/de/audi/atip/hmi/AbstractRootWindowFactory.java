/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IRootWindow;

public abstract class AbstractRootWindowFactory {
    private static AbstractRootWindowFactory instance = null;
    protected IFrameworkAccess framework;

    public static final AbstractRootWindowFactory getInstance() {
        return instance;
    }

    protected AbstractRootWindowFactory(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        instance = this;
    }

    public abstract IRootWindow getRootWindow(int var1);
}

