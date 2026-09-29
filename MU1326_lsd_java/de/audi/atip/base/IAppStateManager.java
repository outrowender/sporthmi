/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.ComponentStateListener;
import de.audi.atip.base.IDomainListener;
import de.audi.atip.progress.IProgressMonitor;

public interface IAppStateManager {
    public static final int COMPONENT_STATE_UNINITIALIZED;
    public static final int COMPONENT_STATE_INITIALIZED;
    public static final int COMPONENT_STATE_ERROR;
    public static final int COMPONENT_STATE_NOT_ENABLED;
    public static final int COMPONENT_STATE_NOT_PRESENT;
    public static final int COMPONENT_STATE_MASK;

    default public void registerComponentStateListener(ComponentStateListener componentStateListener) {
    }

    default public void unregisterComponentStateListener(ComponentStateListener componentStateListener) {
    }

    default public void registerDomainStateListener(IDomainListener iDomainListener) {
    }

    default public void unregisterDomainStateListener(IDomainListener iDomainListener) {
    }

    default public boolean isAppSwdlStarted() {
    }

    default public void enqueueDomainStart(int n, int n2) {
    }

    default public IProgressMonitor getNavProgressMonitor() {
    }
}

