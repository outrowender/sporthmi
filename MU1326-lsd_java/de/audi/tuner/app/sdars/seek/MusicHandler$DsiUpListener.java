/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.MusicHandler;
import de.audi.tuner.app.sdars.seek.MusicHandler$1;
import org.dsi.ifc.sdars.SeekEntry;

class MusicHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ MusicHandler this$0;

    private MusicHandler$DsiUpListener(MusicHandler musicHandler) {
        this.this$0 = musicHandler;
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray) {
        MusicHandler.access$800(this.this$0, seekEntryArray);
    }

    /* synthetic */ MusicHandler$DsiUpListener(MusicHandler musicHandler, MusicHandler$1 musicHandler$1) {
        this(musicHandler);
    }
}

