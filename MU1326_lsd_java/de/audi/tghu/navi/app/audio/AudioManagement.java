/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

public interface AudioManagement {
    public void updateAudioRequest(int var1);

    public void fadedIn(int var1, int var2);

    public void pauseConnection(int var1, int var2);

    public void startConnection(int var1, int var2);

    public void stopConnection(int var1, int var2);

    public void errorConnection(int var1, int var2, int var3);
}

