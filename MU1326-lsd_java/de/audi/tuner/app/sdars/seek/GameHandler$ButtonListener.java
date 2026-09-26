/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.seek.GameHandler;
import de.audi.tuner.app.sdars.seek.GameHandler$1;

class GameHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ GameHandler this$0;

    private GameHandler$ButtonListener(GameHandler gameHandler) {
        this.this$0 = gameHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        GameHandler.access$2000(this.this$0);
    }

    /* synthetic */ GameHandler$ButtonListener(GameHandler gameHandler, GameHandler$1 gameHandler$1) {
        this(gameHandler);
    }
}

