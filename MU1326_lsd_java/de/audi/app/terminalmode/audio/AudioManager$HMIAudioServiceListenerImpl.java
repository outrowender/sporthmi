/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$1;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl$1;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl$2;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl$3;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl$4;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl$5;
import de.audi.app.terminalmode.audio.AudioManager$HMIAudioServiceListenerImpl$6;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.IMediaRoutesChangeListener;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import java.util.Iterator;

final class AudioManager$HMIAudioServiceListenerImpl
implements HMIAudioServiceListener {
    private static final String LOGCLASS;
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$HMIAudioServiceListenerImpl(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$HMIAudioServiceListenerImpl$1(this, "AudioManager.HMIAudioServiceListenerImpl.updateAMAvailable", bl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean changeAudioContextState(String string, int n, int n2, AudioState audioState) {
        if (n2 != AudioManager.access$2000(this.this$0).getTerminalId()) {
            return false;
        }
        Object object = AudioManager.access$2700(this.this$0);
        synchronized (object) {
            AudioManager.access$300(this.this$0).log(1078071040, "<- [%1.%2] '%3'", (Object)"AudioManager.HMIAudioServiceListenerImpl", (Object)string, (long)n);
            AudioConnectionState audioConnectionState = new AudioConnectionState(n, audioState);
            if (audioState.is(new AudioState[]{AudioState.STARTED, AudioState.STOPPED})) {
                if (n == 95 && AudioManager.access$1700(this.this$0).getAudioConnectionState(162) != null && AudioManager.access$1700(this.this$0).getAudioConnectionState(162).getState().is(AudioState.STARTED) && audioState.is(AudioState.STOPPED)) {
                    AudioManager.access$300(this.this$0).log(1078071040, "<- [%1.stopConnection] ignore stoping of PHONE_MP3_RINGING because of IOS_MEDIA was staretd before.", (Object)"AudioManager.HMIAudioServiceListenerImpl");
                } else {
                    ATIPAudioRoute[] aTIPAudioRouteArray = this.this$0.filterAudioRouteChanges(AudioManager.access$4100(this.this$0).getAudioRoutes(audioConnectionState));
                    if (aTIPAudioRouteArray.length > 0) {
                        this.notifyMediaRoutesChanging();
                        this.this$0.requestMediaRoutes(aTIPAudioRouteArray);
                    } else if (162 == n && audioState.is(AudioState.STARTED) && AudioManager.access$1700(this.this$0).getAudioConnectionState(162) != null && AudioManager.access$1700(this.this$0).getAudioConnectionState(162).getState().is(AudioState.PAUSED) && ((AudioConnectionState)AudioManager.access$1700(this.this$0).getAudioObservableForAudioConnection(TMAudioConnection.RINGTONE).get()).getState().is(AudioState.STOPPED)) {
                        ATIPAudioRoute[] aTIPAudioRouteArray2 = AudioManager.access$4100(this.this$0).getAudioRoutes(audioConnectionState);
                        AudioManager.access$300(this.this$0).log(1078071040, "[%1.changeAudioContextState] special routes:%2", (Object)"AudioManager.HMIAudioServiceListenerImpl", (Object)TerminalModeUtils.logMediaRoutes((ATIPAudioRoute[])aTIPAudioRouteArray2));
                        this.this$0.requestMediaRoutes(aTIPAudioRouteArray2);
                    }
                }
            }
            if (audioState.is(AudioState.STOPPED) && AudioManager.access$1700(this.this$0).getState(n).isNot(AudioState.UNDEFINED)) {
                AudioManager.access$1700(this.this$0).releaseConnection(n);
            }
            AudioManager.access$1700(this.this$0).setAudioConnectionState(audioConnectionState);
            return true;
        }
    }

    private void notifyMediaRoutesChanging() {
        AudioManager.access$300(this.this$0).log(1078071040, "[%1.notifyMediaRoutesChanging]", (Object)"AudioManager.HMIAudioServiceListenerImpl");
        Iterator iterator = AudioManager.access$3600(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaRoutesChangeListener)iterator.next()).mediaRoutesChanging();
            }
            catch (Exception exception) {
                AudioManager.access$300(this.this$0).log(10000, "[%1.notifyMediaRoutesChanging]", (Object)"AudioManager.HMIAudioServiceListenerImpl", (Throwable)exception);
            }
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$HMIAudioServiceListenerImpl$2(this, "AudioManager.HMIAudioServiceListenerImpl.stopConnection", n, n2));
    }

    @Override
    public void pauseConnection(int n, int n2) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$HMIAudioServiceListenerImpl$3(this, "AudioManager.HMIAudioServiceListenerImpl.pauseConnection", n, n2));
    }

    @Override
    public void startConnection(int n, int n2) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$HMIAudioServiceListenerImpl$4(this, "AudioManager.HMIAudioServiceListenerImpl.startConnection", n, n2));
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$HMIAudioServiceListenerImpl$5(this, "AudioManager.HMIAudioServiceListenerImpl.errorConnection", n, n2));
    }

    @Override
    public void fadedIn(int n, int n2) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$HMIAudioServiceListenerImpl$6(this, "AudioManager.HMIAudioServiceListenerImpl.updateAMAvailable", n, n2));
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
    }

    /* synthetic */ AudioManager$HMIAudioServiceListenerImpl(AudioManager audioManager, AudioManager$1 audioManager$1) {
        this(audioManager);
    }

    static /* synthetic */ AudioManager access$3700(AudioManager$HMIAudioServiceListenerImpl audioManager$HMIAudioServiceListenerImpl) {
        return audioManager$HMIAudioServiceListenerImpl.this$0;
    }

    static /* synthetic */ boolean access$4300(AudioManager$HMIAudioServiceListenerImpl audioManager$HMIAudioServiceListenerImpl, String string, int n, int n2, AudioState audioState) {
        return audioManager$HMIAudioServiceListenerImpl.changeAudioContextState(string, n, n2, audioState);
    }
}

