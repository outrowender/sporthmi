/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.intra;

public interface IAppAudioListener {
    public static final int CONN_FADEDIN;
    public static final int CONN_PAUSED;
    public static final int CONN_STARTED;
    public static final int CONN_STOPPED;

    default public void updateConnectionStatus(int n, int n2, int n3) {
    }

    default public void updateAMAvailable(boolean bl) {
    }
}

