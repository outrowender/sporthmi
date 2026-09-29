/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.tuner.app.sdars.seek.MusicHandler;
import de.audi.tuner.app.sdars.seek.MusicHandler$1;

class MusicHandler$OptionModelListener
extends DefaultOptionListener {
    private final /* synthetic */ MusicHandler this$0;

    private MusicHandler$OptionModelListener(MusicHandler musicHandler) {
        this.this$0 = musicHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        MusicHandler.access$1000(this.this$0, MusicHandler.access$900(this.this$0).getOptionModel(n), n3, n5);
    }

    /* synthetic */ MusicHandler$OptionModelListener(MusicHandler musicHandler, MusicHandler$1 musicHandler$1) {
        this(musicHandler);
    }
}

