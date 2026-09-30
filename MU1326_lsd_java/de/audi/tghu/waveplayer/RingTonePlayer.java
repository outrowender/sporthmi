/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.tghu.waveplayer.WavePlayerListener;

public interface RingTonePlayer {
    public static final int PLAY_ONCE = 0;
    public static final int PLAY_REPEATEDLY = 1;

    public void playTone(int var1, int var2);

    public void playDefault(int var1);

    public void abort();

    public void setListener(WavePlayerListener var1);

    public void removeListener(WavePlayerListener var1);
}

