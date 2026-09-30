/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.audio.IMediaRoutesChangeListener;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.utils.reactive.properties.ObservableProperty;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tghu.command.Command;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IAudioManager {
    public void requestAudioFocus();

    public boolean hasAudioFocus();

    public ObservableProperty<Boolean> getAudioFocusObservable();

    public ObservableProperty<AudioConnectionState> getAudioObservableForAudioConnection(TMAudioConnection var1);

    public void requestAudio(TMAudioConnection var1, boolean var2);

    public void requestAudio(TMAudioConnection var1, int var2);

    public void releaseAudio(TMAudioConnection var1);

    public void addAudioContextListener(IAudioStateListener var1);

    public void removeAudioContextListener(IAudioStateListener var1);

    public boolean resumeAudio(boolean var1);

    public boolean isStandbyMuted();

    public void mute();

    public void requestMediaRoutes(ATIPAudioRoute[] var1);

    public void addMediaRouteChangeListener(IMediaRoutesChangeListener var1);

    public void removeMediaRouteChangeListener(IMediaRoutesChangeListener var1);

    public void releaseAudioFocus();

    public Command createAudioConnectionRequest(TMAudioConnection var1, boolean var2);

    public IAudioConnectionHandle createAudioConnectionHandle(TMAudioConnection var1);

    public boolean isAudioServiceAvailable();

    public ReadOnlyProperty<AudioState> getAudioObservableForAudioConnection(int var1);
}

