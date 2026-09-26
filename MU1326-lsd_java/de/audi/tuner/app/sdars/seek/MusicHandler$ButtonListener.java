/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.seek.MusicHandler;
import de.audi.tuner.app.sdars.seek.MusicHandler$1;

class MusicHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ MusicHandler this$0;

    private MusicHandler$ButtonListener(MusicHandler musicHandler) {
        this.this$0 = musicHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        MusicHandler.access$1200(this.this$0);
    }

    /* synthetic */ MusicHandler$ButtonListener(MusicHandler musicHandler, MusicHandler$1 musicHandler$1) {
        this(musicHandler);
    }
}

