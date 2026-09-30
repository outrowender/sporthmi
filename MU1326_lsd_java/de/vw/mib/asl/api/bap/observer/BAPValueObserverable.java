/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.observer;

import de.vw.mib.asl.api.bap.observer.BAPValueObserver;

public interface BAPValueObserverable {
    public void addObserver(BAPValueObserver var1, Object var2);

    public void removeObserver(BAPValueObserver var1);
}

