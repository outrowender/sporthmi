/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.DefaultAudioConnectionListener;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.ObservableProperty;
import de.audi.tghu.command.CommandList;

public class AudibleStateSyncer
implements ITerminalModeComponent {
    private static final String LOGCLASS = "AudibleStateSyncer";
    private final IAudioManager am;
    private final EventListener eventListener;
    private final LogChannel lc;
    private final IEventBus eventBus;
    private final IAudioConnectionHandle audioConnectionHandle;
    private final IAudioConnectionHandle.IAudioConnectionListener audioConnectionListener;
    private final IStateHandler stateHandler;
    private final CommandListHelper commandListHelper;
    private final IContext context;
    private volatile PlaybackInfoChangedEvent.PlaybackState playbackState = PlaybackInfoChangedEvent.PlaybackState.INVALID;
    private volatile AudioConnectionState audioConnectionState = new AudioConnectionState(-1, AudioState.UNKNOWN);

    public AudibleStateSyncer(IContext iContext, IStateHandler iStateHandler) {
        this.am = iContext.getAudioManager();
        this.lc = iContext.getLogger().audio();
        this.stateHandler = iStateHandler;
        this.commandListHelper = iContext.getCommandListHelper();
        this.context = iContext;
        this.eventListener = new EventListener();
        this.eventBus = iContext.getEventBus();
        this.audioConnectionHandle = this.am.createAudioConnectionHandle(TMAudioConnection.MEDIA);
        this.audioConnectionListener = new AudioStateListener();
    }

    public void init() {
        this.audioConnectionHandle.registerListener(this.audioConnectionListener);
        this.eventBus.registerListener(this.eventListener);
        ObservableProperty<AudioConnectionState> observableProperty = this.am.getAudioObservableForAudioConnection(TMAudioConnection.MEDIA);
        this.am.getAudioObservableForAudioConnection(8).combineWith(observableProperty).subscribe(new Observables.Consumer2<AudioState, AudioConnectionState>(){

            @Override
            public void accept(AudioState audioState, AudioConnectionState audioConnectionState) {
                if (audioState.is(AudioState.STARTED) && audioConnectionState.getState().is(AudioState.PAUSED) && AudibleStateSyncer.this.stateHandler.getCurrentState().getStateForResource(Resource.AUDIO_MEDIA).isNot(ResourceState.PAUSED_BY_MUTE)) {
                    AudibleStateSyncer.this.executePausedByMuteCommand();
                }
            }

            @Override
            public /* synthetic */ void accept(Object object, Object object2) {
                this.accept((AudioState)object, (AudioConnectionState)object2);
            }
        });
    }

    public void deinit() {
        this.eventBus.unregisterListener(this.eventListener);
        this.audioConnectionHandle.unregisterListener(this.audioConnectionListener);
    }

    private void executePausedByMuteCommand() {
        this.commandListHelper.create().addSingle(new AbstractStateHandlerCommand(this.context.getLogger().main(), "PauseAudioByMute", this.context, this.stateHandler){

            public void execute() {
                TMState tMState = this.stateHandler.getCurrentState();
                tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
                this.logger.log(1000000, "[%1.execute] new state=%2", (Object)AudibleStateSyncer.LOGCLASS, (Object)tMState.toString());
                CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        }).execute(LOGCLASS);
    }

    private final class EventListener
    extends DefaultEventListener {
        private EventListener() {
        }

        public void updatePlaybackInfo(PlaybackInfoChangedEvent playbackInfoChangedEvent) {
            AudibleStateSyncer.this.playbackState = playbackInfoChangedEvent.getState();
            if (AudibleStateSyncer.this.playbackState.isOneOf(PlaybackInfoChangedEvent.PlaybackState.PLAYING, PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD, PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD) && !AudibleStateSyncer.this.audioConnectionState.isAudible()) {
                this.onDevicePlayingWhileNotAudible();
            }
        }

        private void onDevicePlayingWhileNotAudible() {
            AudibleStateSyncer.this.lc.log(10000000, "[AudibleStateSyncer.onDevicePlayingWhileNotAudible] %1 while not audible -> AudioManager.resumeAudio()", (Object)AudibleStateSyncer.this.playbackState);
            AudibleStateSyncer.this.am.resumeAudio(true);
        }
    }

    private final class AudioStateListener
    extends DefaultAudioConnectionListener {
        private AudioStateListener() {
        }

        public void onPause() {
            if (AudibleStateSyncer.this.playbackState.isOneOf(PlaybackInfoChangedEvent.PlaybackState.PLAYING, PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD, PlaybackInfoChangedEvent.PlaybackState.SEEKFORWARD)) {
                AudibleStateSyncer.this.lc.log(10000000, "[AudibleStateSyncer.onAudioConnectionPaused] %1 while %2 -> playerModificationListener.pause()", (Object)AudibleStateSyncer.this.audioConnectionState, (Object)AudibleStateSyncer.this.playbackState);
                AudibleStateSyncer.this.commandListHelper.create().addSingle(new AbstractStateHandlerCommand(AudibleStateSyncer.this.context.getLogger().main(), "PauseAudio", AudibleStateSyncer.this.context, AudibleStateSyncer.this.stateHandler){

                    public void execute() {
                        TMState tMState = this.stateHandler.getCurrentState();
                        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED);
                        this.logger.log(1000000, "[%1.execute] new state=%2", (Object)AudibleStateSyncer.LOGCLASS, (Object)tMState.toString());
                        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                    }
                }).execute(AudibleStateSyncer.LOGCLASS);
            }
        }

        public void onPauseByMute() {
            if (AudibleStateSyncer.this.playbackState.isOneOf(PlaybackInfoChangedEvent.PlaybackState.PLAYING, PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD, PlaybackInfoChangedEvent.PlaybackState.SEEKFORWARD)) {
                AudibleStateSyncer.this.lc.log(10000000, "[AudibleStateSyncer.onAudioConnectionPaused] %1 while %2 -> playerModificationListener.pause()", (Object)AudibleStateSyncer.this.audioConnectionState, (Object)AudibleStateSyncer.this.playbackState);
                AudibleStateSyncer.this.executePausedByMuteCommand();
            }
        }

        public void onResume() {
            AudibleStateSyncer.this.lc.log(10000000, "[AudibleStateSyncer.onAudioConnectionStarted] %1 while %2 -> playerModificationListener.resume()", (Object)AudibleStateSyncer.this.audioConnectionState, (Object)AudibleStateSyncer.this.playbackState);
            AudibleStateSyncer.this.commandListHelper.create().addSingle(new AbstractStateHandlerCommand(AudibleStateSyncer.this.context.getLogger().main(), "ResumeAudio", AudibleStateSyncer.this.context, AudibleStateSyncer.this.stateHandler){

                public void execute() {
                    TMState tMState = this.stateHandler.getCurrentState();
                    tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                    this.logger.log(1000000, "[%1.execute] new state=%2", (Object)AudibleStateSyncer.LOGCLASS, (Object)tMState.toString());
                    CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }).execute(AudibleStateSyncer.LOGCLASS);
        }
    }
}

