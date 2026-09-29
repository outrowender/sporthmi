/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.IDispatcher;

public class Handler$SyncronousDispatcher
implements IDispatcher {
    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}

