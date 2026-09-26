/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.seek.GameHandler;
import de.audi.tuner.app.sdars.seek.GameHandler$1;

class GameHandler$ActionProxy
extends TunerActionProxyListener {
    private final /* synthetic */ GameHandler this$0;

    private GameHandler$ActionProxy(GameHandler gameHandler) {
        this.this$0 = gameHandler;
    }

    @Override
    public void tunerSDARSManageAlertsLeft() {
        GameHandler.access$1900(this.this$0);
    }

    /* synthetic */ GameHandler$ActionProxy(GameHandler gameHandler, GameHandler$1 gameHandler$1) {
        this(gameHandler);
    }
}

