/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.intra;

public interface IAudioListener {
    public static final int CONN_FADEDIN;
    public static final int CONN_PAUSED;
    public static final int CONN_STARTED;
    public static final int CONN_STOPPED;

    default public void updateConnStatus(int n, int n2, int n3) {
    }

    default public void updateAMAvailable(boolean bl) {
    }

    default public void updateActiveConnection(int n, int n2) {
    }

    default public void updateActiveEntertainmentConnection(int n, int n2) {
    }
}

