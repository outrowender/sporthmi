/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.audio.IMediaRoutesChangeListener;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.app.terminalmode.statemachine.commands.RequestAudioConnection$1;
import de.audi.tghu.command.Command;
import de.esolutions.fw.util.commons.Buffer;

public class RequestAudioConnection
extends AbstractCommand
implements IAudioStateListener,
IMediaRoutesChangeListener {
    public static final int ANDROID_AUTO_TIMEOUT;
    public static final int CARPLAY_TIMEOUT;
    private final IAudioManager audioManager;
    private final TMAudioConnection audioConnection;
    private final boolean checkAudioFocus;
    private final int timeout;
    private volatile boolean mediaRoutesReady;
    private volatile boolean audioConnectionReady;

    public RequestAudioConnection(TMAudioConnection tMAudioConnection, IContext iContext, boolean bl, int n) {
        super(iContext.getLogger().main(), RequestAudioConnection.formatTag(tMAudioConnection, n, iContext.getAudioManager()), iContext);
        this.audioManager = iContext.getAudioManager();
        this.audioConnection = tMAudioConnection;
        this.checkAudioFocus = bl;
        this.timeout = n;
    }

    private static String formatTag(TMAudioConnection tMAudioConnection, int n, IAudioManager iAudioManager) {
        return new Buffer().append("RequestAudioConnection(").append(tMAudioConnection.toString()).append(")").append(", timeout=").append(n).append(")").toString();
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)this.getName());
        if (this.audioManager.isAudioServiceAvailable()) {
            this.audioManager.addAudioContextListener((IAudioStateListener)this);
            this.mediaRoutesReady = true;
            this.audioManager.addMediaRouteChangeListener((IMediaRoutesChangeListener)this);
            this.audioManager.requestAudio(this.audioConnection, this.checkAudioFocus);
        } else {
            this.audioManager.requestAudio(this.audioConnection, this.checkAudioFocus);
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void audioStateChanged(AudioConnectionState audioConnectionState) {
        if (this.audioConnection.isNot(audioConnectionState.getTMConnection())) {
            return;
        }
        this.audioConnectionReady = audioConnectionState.isAudible() || audioConnectionState.getState().is(AudioState.PAUSED);
        this.logger.log(1078071040, "[%1.audioStateChanged] state=%2, %3, %4", (Object)this.getName(), (Object)String.valueOf(audioConnectionState.getState()), (Object)(this.audioConnectionReady ? "audible" : "not audible"), (Object)(this.mediaRoutesReady ? "media routes ready" : "media routes not ready"));
        if (this.audioConnectionReady && this.mediaRoutesReady) {
            this.finishCommand();
        }
        if (audioConnectionState.getState().is(AudioState.ERROR)) {
            this.logger.log(10000, "[%1.audioStateChanged] Error for audio connection %2", (Object)this.getName(), (Object)audioConnectionState.getTMConnection());
            this.finishCommand();
        }
    }

    @Override
    public void mediaRoutesChanging() {
        this.logger.log(1078071040, "[%1.mediaRoutesChanging]", (Object)this.getName());
        this.mediaRoutesReady = false;
    }

    @Override
    public void mediaRoutesChanged() {
        this.logger.log(1078071040, "[%1.mediaRoutesChanged]", (Object)this.getName());
        this.mediaRoutesReady = true;
        if (this.audioConnectionReady && this.mediaRoutesReady) {
            this.finishCommand();
        }
    }

    private void finishCommand() {
        this.deRegisterListeners();
        this.commandList.commandFinished();
    }

    @Override
    public void audioFocusChanged(boolean bl) {
    }

    @Override
    public long getTimeout() {
        return this.timeout;
    }

    @Override
    protected Command canceled() {
        this.logger.log(-1601830656, "[RequestAudioConnection.canceled] no response, but still continue");
        this.deRegisterListeners();
        return new RequestAudioConnection$1(this, this.logger);
    }

    private void deRegisterListeners() {
        this.audioManager.removeAudioContextListener((IAudioStateListener)this);
        this.audioManager.removeMediaRouteChangeListener((IMediaRoutesChangeListener)this);
    }
}

