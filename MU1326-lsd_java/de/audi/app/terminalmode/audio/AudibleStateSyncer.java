/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$1;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$2;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$AudioStateListener;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$EventListener;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle$IAudioConnectionListener;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.properties.ObservableProperty;

public class AudibleStateSyncer
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    private final IAudioManager am;
    private final AudibleStateSyncer$EventListener eventListener;
    private final LogChannel lc;
    private final IEventBus eventBus;
    private final IAudioConnectionHandle audioConnectionHandle;
    private final IAudioConnectionHandle$IAudioConnectionListener audioConnectionListener;
    private final IStateHandler stateHandler;
    private final CommandListHelper commandListHelper;
    private final IContext context;
    private volatile PlaybackInfoChangedEvent$PlaybackState playbackState = PlaybackInfoChangedEvent$PlaybackState.INVALID;
    private volatile AudioConnectionState audioConnectionState = new AudioConnectionState(-1, AudioState.UNKNOWN);

    public AudibleStateSyncer(IContext iContext, IStateHandler iStateHandler) {
        this.am = iContext.getAudioManager();
        this.lc = iContext.getLogger().audio();
        this.stateHandler = iStateHandler;
        this.commandListHelper = iContext.getCommandListHelper();
        this.context = iContext;
        this.eventListener = new AudibleStateSyncer$EventListener(this, null);
        this.eventBus = iContext.getEventBus();
        this.audioConnectionHandle = this.am.createAudioConnectionHandle(TMAudioConnection.MEDIA);
        this.audioConnectionListener = new AudibleStateSyncer$AudioStateListener(this, null);
    }

    @Override
    public void init() {
        this.audioConnectionHandle.registerListener(this.audioConnectionListener);
        this.eventBus.registerListener(this.eventListener);
        ObservableProperty observableProperty = this.am.getAudioObservableForAudioConnection(TMAudioConnection.MEDIA);
        this.am.getAudioObservableForAudioConnection(8).combineWith(observableProperty).subscribe(new AudibleStateSyncer$1(this));
    }

    @Override
    public void deinit() {
        this.eventBus.unregisterListener(this.eventListener);
        this.audioConnectionHandle.unregisterListener(this.audioConnectionListener);
    }

    private void executePausedByMuteCommand() {
        this.commandListHelper.create().addSingle(new AudibleStateSyncer$2(this, this.context.getLogger().main(), "PauseAudioByMute", this.context, this.stateHandler)).execute("AudibleStateSyncer");
    }

    static /* synthetic */ IStateHandler access$200(AudibleStateSyncer audibleStateSyncer) {
        return audibleStateSyncer.stateHandler;
    }

    static /* synthetic */ void access$300(AudibleStateSyncer audibleStateSyncer) {
        audibleStateSyncer.executePausedByMuteCommand();
    }

    static /* synthetic */ PlaybackInfoChangedEvent$PlaybackState access$400(AudibleStateSyncer audibleStateSyncer) {
        return audibleStateSyncer.playbackState;
    }

    static /* synthetic */ AudioConnectionState access$500(AudibleStateSyncer audibleStateSyncer) {
        return audibleStateSyncer.audioConnectionState;
    }

    static /* synthetic */ LogChannel access$600(AudibleStateSyncer audibleStateSyncer) {
        return audibleStateSyncer.lc;
    }

    static /* synthetic */ IContext access$700(AudibleStateSyncer audibleStateSyncer) {
        return audibleStateSyncer.context;
    }

    static /* synthetic */ CommandListHelper access$800(AudibleStateSyncer audibleStateSyncer) {
        return audibleStateSyncer.commandListHelper;
    }

    static /* synthetic */ PlaybackInfoChangedEvent$PlaybackState access$402(AudibleStateSyncer audibleStateSyncer, PlaybackInfoChangedEvent$PlaybackState playbackState) {
        audibleStateSyncer.playbackState = playbackState;
        return audibleStateSyncer.playbackState;
    }

    static /* synthetic */ IAudioManager access$900(AudibleStateSyncer audibleStateSyncer) {
        return audibleStateSyncer.am;
    }
}

