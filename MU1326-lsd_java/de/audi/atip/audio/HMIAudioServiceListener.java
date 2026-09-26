/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

public interface HMIAudioServiceListener {
    default public void updateAMAvailable(boolean bl) {
    }

    default public void stopConnection(int n, int n2) {
    }

    default public void pauseConnection(int n, int n2) {
    }

    default public void startConnection(int n, int n2) {
    }

    default public void errorConnection(int n, int n2, int n3) {
    }

    default public void fadedIn(int n, int n2) {
    }

    default public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

