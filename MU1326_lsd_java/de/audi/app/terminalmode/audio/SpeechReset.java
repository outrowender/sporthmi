/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Subscription;

public class SpeechReset
implements ITerminalModeComponent {
    private static final String LOGCLASS = "SpeechReset";
    private IAudioManager audioManager;
    private IStateHandler stateHandler;
    private Subscription subscribe;
    private final LogChannel logger;
    private IDeviceManager deviceManager;

    public SpeechReset(IAudioManager iAudioManager, IStateHandler iStateHandler, LogChannel logChannel, IDeviceManager iDeviceManager) {
        this.audioManager = iAudioManager;
        this.stateHandler = iStateHandler;
        this.logger = logChannel;
        this.deviceManager = iDeviceManager;
    }

    public void init() {
        this.subscribe = Observables.combineLatest(this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.SPEECH), this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.SPEECH_INPUT)).using(new Observables.Combinator<AudioConnectionState, AudioConnectionState, AudioState>(){

            @Override
            public AudioState combine(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2) {
                if (audioConnectionState.getState().is(AudioState.STOPPED) || audioConnectionState2.getState().is(AudioState.STOPPED)) {
                    return AudioState.STOPPED;
                }
                return null;
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2) {
                return this.combine((AudioConnectionState)object, (AudioConnectionState)object2);
            }
        }).subscribe(new Consumer<AudioState>(){

            @Override
            public void accept(AudioState audioState) {
                if (audioState == null) {
                    return;
                }
                if (audioState.is(AudioState.STOPPED) && ((ResourceOwner)SpeechReset.this.stateHandler.getStateResourceProperty(Resource.AUDIO_SPEECH).get()).is(ResourceOwner.DEVICE) && SpeechReset.this.deviceManager.getActiveDevice().isCarplayDevice()) {
                    SpeechReset.this.logger.log(1000000, "[%1.accept] owner[AUDIO_SPEECH] -> MU", (Object)SpeechReset.LOGCLASS);
                    SpeechReset.this.stateHandler.setOwnerForResource(Resource.AUDIO_SPEECH, ResourceOwner.MAINUNIT);
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((AudioState)object);
            }
        });
    }

    public void deinit() {
        if (this.subscribe != null) {
            this.subscribe.cancel();
        }
    }
}

