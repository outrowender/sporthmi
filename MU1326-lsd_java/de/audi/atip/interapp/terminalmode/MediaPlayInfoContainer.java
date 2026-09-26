/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

public class MediaPlayInfoContainer {
    private final int playState;
    private int trackPosition;

    public MediaPlayInfoContainer(int n) {
        this.playState = n;
    }

    public int getTrackPosition() {
        return this.trackPosition;
    }

    public void setTrackPosition(int n) {
        this.trackPosition = n;
    }

    public int getPlayState() {
        return this.playState;
    }
}

