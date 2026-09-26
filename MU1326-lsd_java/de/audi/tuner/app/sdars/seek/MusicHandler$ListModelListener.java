/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.seek.MusicHandler;
import de.audi.tuner.app.sdars.seek.MusicHandler$1;

class MusicHandler$ListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ MusicHandler this$0;

    private MusicHandler$ListModelListener(MusicHandler musicHandler) {
        this.this$0 = musicHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        MusicHandler.access$1100(this.this$0, n2);
    }

    /* synthetic */ MusicHandler$ListModelListener(MusicHandler musicHandler, MusicHandler$1 musicHandler$1) {
        this(musicHandler);
    }
}

