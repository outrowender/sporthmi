/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.audio.AudioManagement;
import de.audi.tghu.navi.app.audio.AudioStateMachine;
import de.audi.tghu.navi.app.util.Util;

public abstract class AudioState
implements AudioManagement {
    protected LogChannel logChannel;
    protected AudioStateMachine stateMachine;
    protected NavigationEnv env;
    private final SpeechManager speechManager;

    public AudioState(NavigationEnv navigationEnv, AudioStateMachine audioStateMachine, SpeechManager speechManager) {
        this.env = navigationEnv;
        this.speechManager = speechManager;
        this.logChannel = navigationEnv.getAudioLogChannel();
        this.stateMachine = audioStateMachine;
    }

    protected int getConnectionType() {
        int n = this.stateMachine.isAutoRepeatMode() || this.stateMachine.getCurrentConnection() == 83 ? 83 : (this.stateMachine.getLastAnnouncementHandler().isAnnouncementRepeatActive() ? 116 : (this.speechManager.announcementOnCall() ? 116 : 117));
        return n;
    }

    protected void requestConnection() {
        int n = this.getConnectionType();
        boolean bl = this.stateMachine.getAudioManagement().isActive(n);
        try {
            this.stateMachine.setCurrentConnection(n);
            if (bl) {
                this.logChannel.log(-2137614336, "AudioState#requestConnection() - audioConnection: %1 already active", (long)n);
                this.stateMachine.goTo(2);
                this.stateMachine.fadedIn(n, 0);
            } else {
                this.logChannel.log(-2137614336, "AudioState#requestConnection() - audioConnection: %1 ", (long)n);
                this.stateMachine.getAudioManagement().requestConnection(n);
                this.stateMachine.goTo(1);
            }
        }
        catch (Exception exception) {
            Util.handleDSIException(exception, this.env);
            this.stateMachine.setCurrentConnection(n);
            this.stateMachine.goTo(0);
        }
    }

    protected void fadeToConnection(int n) {
        this.logChannel.log(-2137614336, "AudioState#fadeToConnection( %1 ) ", (long)n);
        try {
            this.stateMachine.getAudioManagement().fadeToConnection(n);
            this.stateMachine.goTo(2);
        }
        catch (Exception exception) {
            Util.handleDSIException(exception, this.env);
            this.releaseConnection(n);
        }
    }

    protected void releaseConnection(int n) {
        if (n == 83) {
            this.logChannel.log(1078071040, "AudioState#releaseConnection( %1 ) IGNORED (controlled by AppTone)", (long)n);
            return;
        }
        this.logChannel.log(-2137614336, "AudioState#releaseConnection( %1 ) ", (long)n);
        try {
            this.stateMachine.getAudioManagement().releaseConnection(n);
            this.stateMachine.goTo(4);
        }
        catch (Exception exception) {
            Util.handleDSIException(exception, this.env);
            this.stateMachine.goTo(0);
        }
    }

    protected void acknowledgeStopAudio(int n) {
        this.logChannel.log(-2137614336, "AudioState#acknowledgeStopAudio( %1 ) ", (long)n);
        this.stateMachine.initAudio();
    }

    @Override
    public void updateAudioRequest(int n) {
        if (this.logChannel.getCurrentLogThreshold() >= -2137614336) {
            String string;
            switch (n) {
                case 1: {
                    string = "AUDIOSTATE_ACTIVE";
                    break;
                }
                case 3: {
                    string = "AUDIOSTATE_REQUEST";
                    break;
                }
                case 2: {
                    string = "AUDIOSTATE_IDLE";
                    break;
                }
                case 4: {
                    string = "AUDIOSTATE_ERROR";
                    break;
                }
                default: {
                    string = "AUDIOSTATE_UNKNOWN";
                }
            }
            this.logChannel.log(-2137614336, "AudioState#updateAudioRequest( %2 ) %1", (Object)string, (long)n);
        }
    }

    @Override
    public void fadedIn(int n, int n2) {
        if (AudioStateMachine.isNaviAudioConnection(n) && n != 83) {
            this.logChannel.log(-1601830656, "AudioState#fadedIn( %2 ) - not expected [%1]! ", (Object)this, (long)n);
        }
    }

    @Override
    public void startConnection(int n, int n2) {
        if (n == 83) {
            this.logChannel.log(-2137614336, "AudioState#startConnection( %1 ) - going to CONNECTION_FADEDIN", (long)n);
            this.stateMachine.goTo(2);
        } else if (AudioStateMachine.isNaviAudioConnection(n)) {
            this.logChannel.log(-1601830656, "AudioState#startConnection( %2 ) - not expected [%1]! ", (Object)this, (long)n);
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        if (AudioStateMachine.isNaviAudioConnection(n)) {
            this.logChannel.log(-2137614336, "AudioState#stopConnection( %2 ) - [%1] ", (Object)this, (long)n);
            this.handleStopOrErrorConnection(n);
        }
    }

    @Override
    public final void pauseConnection(int n, int n2) {
        if (AudioStateMachine.isNaviAudioConnection(n)) {
            this.logChannel.log(-1601830656, "AudioState#pauseConnection( %2 ) - not expected [%1]! ", (Object)this, (long)n);
            this.handleStopOrErrorConnection(n);
        }
    }

    @Override
    public final void errorConnection(int n, int n2, int n3) {
        if (AudioStateMachine.isNaviAudioConnection(n)) {
            this.logChannel.log(-1601830656, "AudioState#errorConnection( %2, %3 ) - [%1] ", (Object)this, (long)n, (long)n3);
            this.handleStopOrErrorConnection(n);
        }
    }

    private void handleStopOrErrorConnection(int n) {
        this.logChannel.log(-2137614336, "AudioState#handleStopOrErrorConnection( %2 ) - going to CONNECTION_STOPPED [%1] ", (Object)this, (long)n);
        this.stateMachine.audioTrigger(false);
        HMIAudioService hMIAudioService = this.stateMachine.getAudioManagement();
        if (hMIAudioService.getStatus(116) != 5) {
            hMIAudioService.releaseConnection(116);
        }
        if (hMIAudioService.getStatus(117) != 5) {
            hMIAudioService.releaseConnection(117);
        }
        this.acknowledgeStopAudio(n);
    }
}

