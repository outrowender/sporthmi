/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.GALAudioConnection
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.BCLAudioConnection;
import de.audi.app.terminalmode.audio.DIOAudioConnection;
import de.audi.app.terminalmode.audio.GALAudioConnection;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle$IAudioConnectionListener;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.audio.TMAudioConnection;

class AudioManager$AudioConnectionListenerAdapter
implements IAudioStateListener {
    private final IAudioConnectionHandle$IAudioConnectionListener audioConnectionListener;
    private final TMAudioConnection audioConnection;
    private final int androidAutoAudioManagementConnection;
    private final int carplayAudioManagementConnection;
    private final int carlifeAudioManagementConnection;
    private AudioState lastState = AudioState.UNDEFINED;
    private final AudioManager audioManager;

    public AudioManager$AudioConnectionListenerAdapter(IAudioConnectionHandle$IAudioConnectionListener iAudioConnectionHandle$IAudioConnectionListener, TMAudioConnection tMAudioConnection, AudioManager audioManager) {
        this.audioConnectionListener = iAudioConnectionHandle$IAudioConnectionListener;
        this.audioConnection = tMAudioConnection;
        this.androidAutoAudioManagementConnection = (Integer)GALAudioConnection.getAndroidAutoAudioConnection((TMAudioConnection)tMAudioConnection).get();
        this.carplayAudioManagementConnection = (Integer)DIOAudioConnection.getCarplayAudioConnection(tMAudioConnection).get();
        this.carlifeAudioManagementConnection = (Integer)BCLAudioConnection.getBaiduAudioConnection(tMAudioConnection).get();
        this.audioManager = audioManager;
    }

    @Override
    public void audioStateChanged(AudioConnectionState audioConnectionState) {
        int n = audioConnectionState.getConnection();
        if (n == this.androidAutoAudioManagementConnection || n == this.carplayAudioManagementConnection || n == this.carlifeAudioManagementConnection) {
            if (audioConnectionState.getState().is(AudioState.STARTED)) {
                if (this.lastState.is(new AudioState[]{AudioState.ERROR, AudioState.PAUSED})) {
                    this.audioConnectionListener.onResume();
                } else {
                    this.audioConnectionListener.onStart();
                }
            } else if (audioConnectionState.getState().is(AudioState.PAUSED)) {
                int n2 = this.audioManager.audioService.getStatus(8);
                if (3 == n2 || 2 == n2 || 6 == n2) {
                    this.audioConnectionListener.onPauseByMute();
                } else {
                    this.audioConnectionListener.onPause();
                }
            } else if (audioConnectionState.getState().is(AudioState.STOPPED)) {
                this.audioConnectionListener.onStopped();
            } else if (audioConnectionState.getState().is(AudioState.FADEDIN)) {
                this.audioConnectionListener.onFadedIn();
            } else if (audioConnectionState.getState().is(AudioState.ERROR)) {
                this.audioConnectionListener.onError();
            }
            this.lastState = audioConnectionState.getState();
        }
    }

    @Override
    public void audioFocusChanged(boolean bl) {
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.audioConnection == null ? 0 : this.audioConnection.hashCode());
        n = 31 * n + (this.audioConnectionListener == null ? 0 : this.audioConnectionListener.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AudioManager$AudioConnectionListenerAdapter audioManager$AudioConnectionListenerAdapter = (AudioManager$AudioConnectionListenerAdapter)object;
        if (this.audioConnection == null ? audioManager$AudioConnectionListenerAdapter.audioConnection != null : !this.audioConnection.equals(audioManager$AudioConnectionListenerAdapter.audioConnection)) {
            return false;
        }
        return !(this.audioConnectionListener == null ? audioManager$AudioConnectionListenerAdapter.audioConnectionListener != null : !this.audioConnectionListener.equals(audioManager$AudioConnectionListenerAdapter.audioConnectionListener));
    }
}

