/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.observer;

import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPValueObserver {
    public void bapValueChanged(BAPValueObserverable var1, BAPEntity var2, BAPEntity var3, Object var4);

    public void bapValueError(BAPValueObserverable var1, int var2, Object var3);
}

