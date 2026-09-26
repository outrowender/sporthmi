/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.seek.GameHandler;
import de.audi.tuner.app.sdars.seek.GameHandler$1;
import de.audi.tuner.app.sdars.seek.TeamRow;

class GameHandler$TeamListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ GameHandler this$0;

    private GameHandler$TeamListModelListener(GameHandler gameHandler) {
        this.this$0 = gameHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        GameHandler.access$1700(this.this$0, n2, (TeamRow)evoListRow);
    }

    /* synthetic */ GameHandler$TeamListModelListener(GameHandler gameHandler, GameHandler$1 gameHandler$1) {
        this(gameHandler);
    }
}

