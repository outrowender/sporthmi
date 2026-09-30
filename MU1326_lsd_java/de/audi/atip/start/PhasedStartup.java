/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.start;

public interface PhasedStartup {
    public static final int STATE_INITIAL = 0;
    public static final int STATE_AUDIO_READY = 1;
    public static final int STATE_LASTMODE_READY = 2;
    public static final int STATE_READY = 3;

    public String getName();

    public int getState();

    public void startAudio(int var1);

    public void startLastmode(int var1);

    public void startFull();
}

