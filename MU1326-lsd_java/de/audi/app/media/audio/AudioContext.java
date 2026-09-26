/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.IAudioContextStateNotifier;

class AudioContext {
    private final IAudioContextStateNotifier notifier;
    private final int connection;
    private int state = 0;
    private final boolean checkAudioFocus;

    public AudioContext(int n, IAudioContextStateNotifier iAudioContextStateNotifier, boolean bl) {
        this.connection = n;
        this.notifier = iAudioContextStateNotifier;
        this.checkAudioFocus = bl;
    }

    public int getConnection() {
        return this.connection;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        if (this.state == n) {
            return;
        }
        this.state = n;
        this.notifier.notifyAudioStateChanged(this.connection, this.state);
    }

    public boolean isCheckAudioFocus() {
        return this.checkAudioFocus;
    }
}

