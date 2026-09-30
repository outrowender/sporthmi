/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.intra;

public interface IAudioListener {
    public static final int CONN_FADEDIN = 0;
    public static final int CONN_PAUSED = 4;
    public static final int CONN_STARTED = 2;
    public static final int CONN_STOPPED = 5;

    public void updateConnStatus(int var1, int var2, int var3);

    public void updateAMAvailable(boolean var1);

    public void updateActiveConnection(int var1, int var2);

    public void updateActiveEntertainmentConnection(int var1, int var2);
}

