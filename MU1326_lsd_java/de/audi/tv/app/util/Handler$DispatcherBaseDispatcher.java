/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.IDispatcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class Handler$DispatcherBaseDispatcher
implements IDispatcher {
    private final DispatcherBase dispatcherBase;

    public Handler$DispatcherBaseDispatcher(DispatcherBase dispatcherBase) {
        this.dispatcherBase = dispatcherBase;
    }

    @Override
    public void execute(Runnable runnable) {
        this.dispatcherBase.execute(runnable);
        this.dispatcherBase.start();
    }
}

