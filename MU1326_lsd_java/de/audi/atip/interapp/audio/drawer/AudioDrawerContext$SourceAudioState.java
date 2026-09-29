/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio.drawer;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$1;

public final class AudioDrawerContext$SourceAudioState {
    private final String state;
    private final IntegerListCell cell;

    private AudioDrawerContext$SourceAudioState(String string, IntegerListCell integerListCell) {
        this.state = string;
        this.cell = integerListCell;
    }

    public IntegerListCell getCell() {
        return this.cell;
    }

    public String toString() {
        return this.state;
    }

    /* synthetic */ AudioDrawerContext$SourceAudioState(String string, IntegerListCell integerListCell, AudioDrawerContext$1 audioDrawerContext$1) {
        this(string, integerListCell);
    }
}

