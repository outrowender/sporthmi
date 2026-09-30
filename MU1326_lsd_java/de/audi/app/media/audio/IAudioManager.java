/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.IAudioStateListener;
import de.audi.atip.interapp.audio.ToneService;

public interface IAudioManager {
    public static final int AUDIO_STATE_UNDEFINED = 0;
    public static final int AUDIO_STATE_STARTED = 2;
    public static final int AUDIO_STATE_PAUSED = 3;
    public static final int AUDIO_STATE_FADEDIN = 4;
    public static final int AUDIO_STATE_STOPPED = 5;
    public static final int AUDIO_STATE_ERROR = 6;

    public void requestAudioFocus();

    public void switchAudioFocusToTuner();

    public void switchAudioFocusToTV();

    public boolean hasAudioFocus();

    public boolean hasFrontAudioFocus();

    public boolean hasRearSeatAudioFocus();

    public boolean hasRearSeatAudioFocusOnly();

    public void requestAudio(int var1, boolean var2);

    public boolean requestAudio(int var1, boolean var2, boolean var3);

    public void requestEntSuppression();

    public void releaseAudio();

    public void fadeTo();

    public void addAudioContextListener(IAudioStateListener var1);

    public void removeAudioContextListener(IAudioStateListener var1);

    public void requestVolumelock(String var1);

    public void releaseVolumelock(String var1);

    public boolean resumeAudio(boolean var1);

    public boolean isStandbyMuted();

    public boolean isMuted();

    public boolean isBtMuted();

    public void mute();

    public void demute();

    public void btMute();

    public void btDemute();

    public void requestSdisConnectionsIfRequired(int var1);

    public void switchSDISAudioFocusToTV();

    public ToneService getToneService();
}

