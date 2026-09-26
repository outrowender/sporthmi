/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;

public interface IDispatcher {
    default public void execute(Runnable runnable) {
    }

    default public IDispatcher$ICancelable execute(Runnable runnable, long l) {
    }

    default public boolean isDispatchThread() {
    }
}

