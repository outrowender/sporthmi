/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

public interface WavePlayerListener {
    public static final int STATE_UKNOWN = -1;
    public static final int STATE_PLAYING = 0;
    public static final int STATE_ABORTED = 1;
    public static final int STATE_FINISHED = 2;
    public static final int STATE_INTERRUPTED = 3;

    public void state(int var1);

    public void playToneInfo(int var1);
}

