/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 *  de.audi.atip.utils.reactive.observables.Observable
 *  de.audi.atip.utils.reactive.observables.Observables
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.SpeechReset$1;
import de.audi.app.terminalmode.audio.SpeechReset$2;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Subscription;

public class SpeechReset
implements ITerminalModeComponent {
    private static final String LOGCLASS;
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

    @Override
    public void init() {
        this.subscribe = Observables.combineLatest((Observable)this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.SPEECH), (Observable)this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.SPEECH_INPUT)).using(new SpeechReset$2(this)).subscribe((Consumer)new SpeechReset$1(this));
    }

    @Override
    public void deinit() {
        if (this.subscribe != null) {
            this.subscribe.cancel();
        }
    }

    static /* synthetic */ IStateHandler access$000(SpeechReset speechReset) {
        return speechReset.stateHandler;
    }

    static /* synthetic */ IDeviceManager access$100(SpeechReset speechReset) {
        return speechReset.deviceManager;
    }

    static /* synthetic */ LogChannel access$200(SpeechReset speechReset) {
        return speechReset.logger;
    }
}

