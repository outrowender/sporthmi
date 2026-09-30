/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.audio.AudioStateMachine;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;

public class NaviAudioHandler
implements INaviAudioHandler {
    private int audioConnectionType = 120;
    private final LogChannel logChannel;
    private SystemTonePlayer wavePlayer;
    private volatile boolean isBeepToneRequested = false;
    private volatile boolean isBeepTonePlaying = false;
    private volatile int toneID;
    private AudioStateMachine audioStateMachine;

    public NaviAudioHandler(NavigationEnv navigationEnv) {
        this.logChannel = navigationEnv.getNaviAudioLogChannel();
        this.wavePlayer = new NullSystemTonePlayer(this.logChannel);
    }

    public void setAudioStateMachine(AudioStateMachine audioStateMachine) {
        this.audioStateMachine = audioStateMachine;
    }

    public void setWavePlayer(WavePlayer wavePlayer) {
        this.logChannel.log(10000000, "NaviAudioHandler#setWavePlayer( %1 )", (Object)wavePlayer);
        if (wavePlayer != null) {
            this.wavePlayer = wavePlayer.getSystemTonePlayer();
            try {
                this.wavePlayer.setListener(this);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "NaviAudioHandler#setWavePlayer() - ERROR = %1", (Throwable)exception);
            }
        } else {
            this.wavePlayer.removeListener(this);
            this.wavePlayer = new NullSystemTonePlayer(this.logChannel);
            this.isBeepToneRequested = false;
            this.isBeepTonePlaying = false;
        }
    }

    public void audioConnectionFadedIn() {
        this.logChannel.log(10000000, "NaviAudioHandler#audioConnectionFadedIn() - isBeepToneRequested: %1, isBeepTonePlaying: %2", this.isBeepToneRequested, this.isBeepTonePlaying);
        if (this.isBeepToneRequested && !this.isBeepTonePlaying) {
            this.isBeepToneRequested = false;
            this.isBeepTonePlaying = true;
            try {
                this.wavePlayer.playTone(0, this.toneID);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "NaviAudioHandler#audioConnectionFadedIn() - ERROR = %1", (Throwable)exception);
                this.isBeepTonePlaying = false;
            }
        }
    }

    public void requestBeepTone(int n, int n2) {
        this.audioConnectionType = n;
        this.toneID = n2;
        this.logChannel.log(10000000, "NaviAudioHandler#requestBeepTone() - isBeepToneRequested: %1, isBeepTonePlaying: %2", this.isBeepToneRequested, this.isBeepTonePlaying);
        if (!this.isBeepTonePlaying) {
            this.isBeepToneRequested = true;
            try {
                this.audioStateMachine.getAudioManagement().requestAndFadeToConnection(n);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "NaviAudioHandler#requestBeepTone() - ERROR = %1", (Throwable)exception);
                this.isBeepToneRequested = false;
            }
        }
    }

    public void state(int n) {
        this.logChannel.log(10000000, "NaviAudioHandler#state( status: %2 ) - isBeepTonePlaying: %1", this.isBeepTonePlaying, (long)n);
        try {
            boolean bl = this.audioStateMachine.getAudioManagement().isActive(this.audioConnectionType);
            this.logChannel.log(10000000, "NaviAudioHandler#state() - isStreetViewAudioConnectionActive: %1", bl);
            if (n != 0) {
                if (bl) {
                    this.audioStateMachine.getAudioManagement().releaseConnection(this.audioConnectionType);
                }
                this.isBeepTonePlaying = false;
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "NaviAudioHandler#state() - ERROR = %1", (Throwable)exception);
            this.isBeepTonePlaying = false;
        }
    }

    public void playToneInfo(int n) {
    }

    public boolean isBeepTonePlaying() {
        return this.isBeepTonePlaying;
    }
}

