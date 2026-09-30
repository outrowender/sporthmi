/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.AbstractRootWindowFactory;
import de.audi.atip.hmi.IRootWindow;
import de.audi.tghu.fwhmi.evo.RootWindowQNX;

public final class RootWindowFactoryQNX
extends AbstractRootWindowFactory {
    public RootWindowFactoryQNX(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    public IRootWindow getRootWindow(int n) {
        return new RootWindowQNX(n, this.framework);
    }
}

