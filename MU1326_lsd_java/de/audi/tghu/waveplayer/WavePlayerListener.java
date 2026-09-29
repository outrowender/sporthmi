/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

public interface WavePlayerListener {
    public static final int STATE_UKNOWN;
    public static final int STATE_PLAYING;
    public static final int STATE_ABORTED;
    public static final int STATE_FINISHED;
    public static final int STATE_INTERRUPTED;

    default public void state(int n) {
    }

    default public void playToneInfo(int n) {
    }
}

