/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

public interface HMIAudioServiceListener {
    public void updateAMAvailable(boolean var1);

    public void stopConnection(int var1, int var2);

    public void pauseConnection(int var1, int var2);

    public void startConnection(int var1, int var2);

    public void errorConnection(int var1, int var2, int var3);

    public void fadedIn(int var1, int var2);

    public void updateVolumeLock(int var1, int var2, boolean var3);
}

