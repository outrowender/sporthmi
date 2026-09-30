/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.ComponentStateListener;
import de.audi.atip.base.IDomainListener;
import de.audi.atip.progress.IProgressMonitor;

public interface IAppStateManager {
    public static final int COMPONENT_STATE_UNINITIALIZED = 0;
    public static final int COMPONENT_STATE_INITIALIZED = 1;
    public static final int COMPONENT_STATE_ERROR = 256;
    public static final int COMPONENT_STATE_NOT_ENABLED = 512;
    public static final int COMPONENT_STATE_NOT_PRESENT = 1024;
    public static final int COMPONENT_STATE_MASK = -768;

    public void registerComponentStateListener(ComponentStateListener var1);

    public void unregisterComponentStateListener(ComponentStateListener var1);

    public void registerDomainStateListener(IDomainListener var1);

    public void unregisterDomainStateListener(IDomainListener var1);

    public boolean isAppSwdlStarted();

    public void enqueueDomainStart(int var1, int var2);

    public IProgressMonitor getNavProgressMonitor();
}

