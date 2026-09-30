/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.intra;

public interface IAppAudioListener {
    public static final int CONN_FADEDIN = 0;
    public static final int CONN_PAUSED = 4;
    public static final int CONN_STARTED = 2;
    public static final int CONN_STOPPED = 5;

    public void updateConnectionStatus(int var1, int var2, int var3);

    public void updateAMAvailable(boolean var1);
}

