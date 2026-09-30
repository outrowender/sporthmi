/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.observer;

import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;

public interface BAPObserverRegistry {
    public BAPValueObserverable getBapValueObservable(int var1);

    public void flushAllBapValueObserverables();
}

