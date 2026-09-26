/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.start;

public interface PhasedStartup {
    public static final int STATE_INITIAL;
    public static final int STATE_AUDIO_READY;
    public static final int STATE_LASTMODE_READY;
    public static final int STATE_READY;

    default public String getName() {
    }

    default public int getState() {
    }

    default public void startAudio(int n) {
    }

    default public void startLastmode(int n) {
    }

    default public void startFull() {
    }
}

