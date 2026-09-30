/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.audio.AudioManagement;
import de.audi.tghu.navi.app.audio.AudioState;
import de.audi.tghu.navi.app.audio.ConnectionFadedIn;
import de.audi.tghu.navi.app.audio.ConnectionStopped;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.audio.LastAnnouncementHandler;
import de.audi.tghu.navi.app.audio.WaitForConnectionFadedIn;
import de.audi.tghu.navi.app.audio.WaitForConnectionStarted;
import de.audi.tghu.navi.app.audio.WaitForConnectionStopped;
import de.audi.tghu.navi.app.call.RequestAudioTriggerCall;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;

public final class AudioStateMachine
implements AudioManagement,
HMIAudioServiceListener {
    public static final int STATE_CONNECTION_STOPPED = 0;
    public static final int STATE_WAIT_FOR_CONNECTION_STARTED = 1;
    public static final int STATE_WAIT_FOR_CONNECTION_FADEDIN = 2;
    public static final int STATE_CONNECTION_FADEDIN = 3;
    public static final int STATE_WAIT_FOR_CONNECTION_STOPPED = 4;
    private static final int STATE_COUNT = 5;
    private final NavigationEnv env;
    private final DSINavigationManager dsiNavigationManager;
    private LogChannel logChannel;
    private AudioState[] audioStates;
    private int currentState;
    private boolean autoRepeatMode;
    private long lastAnnouncementTimestamp = 0L;
    private LastAnnouncementHandler lastAnnouncementHandler;
    private HMIAudioService audioManagement;
    private volatile int audioState;
    private int currentConnection;
    private final INaviAudioHandler naviAudioHandler;

    public AudioStateMachine(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, INaviAudioHandler iNaviAudioHandler, SpeechManager speechManager) {
        this.env = navigationEnv;
        this.dsiNavigationManager = dSINavigationManager;
        this.naviAudioHandler = iNaviAudioHandler;
        this.logChannel = navigationEnv.getNaviAudioLogChannel();
        this.lastAnnouncementHandler = null;
        this.audioManagement = null;
        this.audioState = 2;
        this.audioStates = new AudioState[5];
        this.audioStates[0] = new ConnectionStopped(navigationEnv, this, speechManager);
        this.audioStates[1] = new WaitForConnectionStarted(navigationEnv, this, speechManager);
        this.audioStates[2] = new WaitForConnectionFadedIn(navigationEnv, this, speechManager);
        this.audioStates[3] = new ConnectionFadedIn(navigationEnv, this, speechManager);
        this.audioStates[4] = new WaitForConnectionStopped(navigationEnv, this, speechManager);
        this.currentState = 0;
        this.autoRepeatMode = false;
        this.initAudio();
    }

    public static boolean isNaviAudioConnection(int n) {
        return n == 116 || n == 117 || n == 83;
    }

    public HMIAudioService getAudioManagement() {
        return this.audioManagement;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setAudioManagement(HMIAudioService hMIAudioService) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "AudioStateMachine#setAudioManagement() - %1 ", (Object)hMIAudioService);
        }
        this.audioManagement = hMIAudioService;
        if (hMIAudioService != null) {
            AudioStateMachine audioStateMachine = this;
            synchronized (audioStateMachine) {
                int n = hMIAudioService.getActiveConnection(0);
                if (AudioStateMachine.isNaviAudioConnection(n)) {
                    hMIAudioService.releaseConnection(n);
                }
            }
        }
    }

    private void setAudioState(int n) {
        this.audioState = n;
    }

    public int getAudioState() {
        return this.audioState;
    }

    public int getCurrentConnection() {
        return this.currentConnection;
    }

    public void setCurrentConnection(int n) {
        this.currentConnection = n;
    }

    public void initAudio() {
        this.currentConnection = 0;
        this.goTo(0);
    }

    public LastAnnouncementHandler getLastAnnouncementHandler() {
        return this.lastAnnouncementHandler;
    }

    public void setLastAnnouncementHandler(LastAnnouncementHandler lastAnnouncementHandler) {
        this.lastAnnouncementHandler = lastAnnouncementHandler;
    }

    public long getLastAnnouncementTimestamp() {
        return this.lastAnnouncementTimestamp;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void goTo(int n) {
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.logChannel.log(10000000, "AudioStateMachine#goTo() - %1 -> %2 ", (Object)this.audioStates[this.currentState], (Object)this.audioStates[n]);
            this.currentState = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void storeAudioStateWithoutTransition(int n) {
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.setAudioState(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAudioRequest(int n) {
        if (n == 3) {
            this.lastAnnouncementTimestamp = this.env.getFramework().getMonotonicTime();
        }
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.setAudioState(n);
            this.audioStates[this.currentState].updateAudioRequest(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fadedIn(int n, int n2) {
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.audioStates[this.currentState].fadedIn(n, 0);
        }
        if (this.naviAudioHandler != null && (n == 120 || n == 235)) {
            this.naviAudioHandler.audioConnectionFadedIn();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void pauseConnection(int n, int n2) {
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.audioStates[this.currentState].pauseConnection(n, 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void startConnection(int n, int n2) {
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.audioStates[this.currentState].startConnection(n, 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stopConnection(int n, int n2) {
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.audioStates[this.currentState].stopConnection(n, 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void errorConnection(int n, int n2, int n3) {
        AudioStateMachine audioStateMachine = this;
        synchronized (audioStateMachine) {
            this.audioStates[this.currentState].errorConnection(n, 0, n3);
        }
    }

    public void updateAMAvailable(boolean bl) {
    }

    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(10000, "AudioStateMachine#asyncException( %2, %1, %3 ) -  ", (Object)string, (long)n, (long)n2);
        this.initAudio();
    }

    public boolean isAutoRepeatMode() {
        return this.autoRepeatMode;
    }

    public void setAutoRepeatMode(boolean bl) {
        this.autoRepeatMode = bl;
        if (bl && this.getLastAnnouncementHandler() != null) {
            this.logChannel.log(10000000, "AudioStateMachine#setAutoRepeatMode( %1 ) - repeat last announcement", bl);
            this.getLastAnnouncementHandler().repeatLastAnnouncementSimple(0);
        } else {
            this.logChannel.log(10000000, "AudioStateMachine#setAutoRepeatMode( %1 ) - abort announcement", bl);
            this.audioTrigger(false);
        }
    }

    public void audioTrigger(boolean bl) {
        this.logChannel.log(10000000, "AudioStateMachine#audioTrigger( %1 )", bl);
        RequestAudioTriggerCall requestAudioTriggerCall = new RequestAudioTriggerCall(this.env, this.dsiNavigationManager, bl ? 0 : 2);
        requestAudioTriggerCall.execute("AudioStateMachine#audioTrigger");
    }

    public void responseAudioTrigger(int n) {
        this.logChannel.log(10000000, "DefaultDSINavigationMainHandler#responseAudioTrigger( %1 )", (long)n);
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

