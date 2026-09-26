/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.IAudioStateListener;
import de.audi.atip.interapp.audio.ToneService;

public interface IAudioManager {
    public static final int AUDIO_STATE_UNDEFINED;
    public static final int AUDIO_STATE_STARTED;
    public static final int AUDIO_STATE_PAUSED;
    public static final int AUDIO_STATE_FADEDIN;
    public static final int AUDIO_STATE_STOPPED;
    public static final int AUDIO_STATE_ERROR;

    default public void requestAudioFocus() {
    }

    default public void switchAudioFocusToTuner() {
    }

    default public void switchAudioFocusToTV() {
    }

    default public boolean hasAudioFocus() {
    }

    default public boolean hasFrontAudioFocus() {
    }

    default public boolean hasRearSeatAudioFocus() {
    }

    default public boolean hasRearSeatAudioFocusOnly() {
    }

    default public void requestAudio(int n, boolean bl) {
    }

    default public boolean requestAudio(int n, boolean bl, boolean bl2) {
    }

    default public void requestEntSuppression() {
    }

    default public void releaseAudio() {
    }

    default public void fadeTo() {
    }

    default public void addAudioContextListener(IAudioStateListener iAudioStateListener) {
    }

    default public void removeAudioContextListener(IAudioStateListener iAudioStateListener) {
    }

    default public void requestVolumelock(String string) {
    }

    default public void releaseVolumelock(String string) {
    }

    default public boolean resumeAudio(boolean bl) {
    }

    default public boolean isStandbyMuted() {
    }

    default public boolean isMuted() {
    }

    default public boolean isBtMuted() {
    }

    default public void mute() {
    }

    default public void demute() {
    }

    default public void btMute() {
    }

    default public void btDemute() {
    }

    default public void requestSdisConnectionsIfRequired(int n) {
    }

    default public void switchSDISAudioFocusToTV() {
    }

    default public ToneService getToneService() {
    }
}

