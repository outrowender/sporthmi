/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal.async;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.hmi.widgets.audi.base.eal.async.AsyncImageListener;

public class AsyncImageListener$UpdateEvent
extends ATIPEvent {
    private int state;
    private final /* synthetic */ AsyncImageListener this$0;

    protected AsyncImageListener$UpdateEvent(AsyncImageListener asyncImageListener, ATIPEventListener aTIPEventListener, int n, int n2) {
        this.this$0 = asyncImageListener;
        super(aTIPEventListener, n);
        this.state = n2;
    }

    public int getState() {
        return this.state;
    }

    static /* synthetic */ int access$000(AsyncImageListener$UpdateEvent asyncImageListener$UpdateEvent) {
        return asyncImageListener$UpdateEvent.state;
    }
}

