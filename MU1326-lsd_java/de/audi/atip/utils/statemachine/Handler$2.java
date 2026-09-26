/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.timer.Timer;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;

final class Handler$2
implements IDispatcher$ICancelable {
    private final /* synthetic */ Timer val$timer;

    Handler$2(Timer timer) {
        this.val$timer = timer;
    }

    @Override
    public void cancel() {
        this.val$timer.cancel();
    }
}

