/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.tuner.app.sdars.seek.GameHandler;
import de.audi.tuner.app.sdars.seek.GameHandler$1;

class GameHandler$OptionModelListener
extends DefaultOptionListener {
    private final /* synthetic */ GameHandler this$0;

    private GameHandler$OptionModelListener(GameHandler gameHandler) {
        this.this$0 = gameHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        GameHandler.access$2200(this.this$0, GameHandler.access$2100(this.this$0).getOptionModel(n), n3, n5);
    }

    /* synthetic */ GameHandler$OptionModelListener(GameHandler gameHandler, GameHandler$1 gameHandler$1) {
        this(gameHandler);
    }
}

