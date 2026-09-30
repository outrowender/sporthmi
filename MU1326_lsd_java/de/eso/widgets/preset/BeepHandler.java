/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BeepHandler
implements HMIAudioServiceListener,
ServiceTrackerCustomizer {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    private volatile HMIAudioService audioService;
    private SystemTonePlayer systemTone;
    private ServiceTracker tracker;
    private boolean systemToneRequested = false;
    private BundleContext bundleContext;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;

    public BeepHandler(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_TTS_TOUCHPAD);
        bundleContext.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = BeepHandler.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this, (Dictionary)hashtable);
        this.tracker = new ServiceTracker(bundleContext, new String[]{(class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = BeepHandler.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = BeepHandler.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName()}, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    private void registerSystemTonePlayer(SystemTonePlayer systemTonePlayer) {
        lc.log(10000000, "BeepHandler#registerSystemTonePlayer");
        systemTonePlayer.setListener(new MyWavePlayerListener());
        this.systemTone = systemTonePlayer;
    }

    public void requestBeep() {
        lc.log(10000000, "BeepHandler#requestBeep");
        if (this.audioService != null) {
            this.audioService.requestConnection(120);
            this.systemToneRequested = true;
        }
    }

    private void playBeep() {
        if (this.systemTone != null) {
            try {
                this.systemTone.playTone(0, 17);
            }
            catch (Exception exception) {
                lc.log(10000, "BeepHandler#playBeep", (Throwable)exception);
                this.releaseAudio();
            }
        } else {
            lc.log(10000, "BeepHandler#SystemTonePlayer systemTone is null!");
            this.releaseAudio();
        }
    }

    private void releaseAudio() {
        this.systemToneRequested = false;
        if (this.audioService != null) {
            this.audioService.releaseConnection(120);
        }
    }

    public void updateAMAvailable(boolean bl) {
        lc.log(10000000, "BeepHandler#updateAMAvailable available=%1", bl);
    }

    public void stopConnection(int n, int n2) {
        lc.log(10000000, "BeepHandler#stopConnection connection=%1", (long)n);
    }

    public void pauseConnection(int n, int n2) {
        lc.log(10000000, "BeepHandler#pauseConnection connection=%1", (long)n);
    }

    public void startConnection(int n, int n2) {
        lc.log(1000000, "BeepHandler#startConnection now fade to connection=%2 if systemToneRequested(%1)", this.systemToneRequested, (long)n);
        if (n == 120 && this.systemToneRequested) {
            this.audioService.fadeToConnection(n);
        }
    }

    public void errorConnection(int n, int n2, int n3) {
        lc.log(100000, "BeepHandler#errorConnection connection=%1, errorCode=%2", (long)n, (long)n3);
    }

    public void fadedIn(int n, int n2) {
        lc.log(1000000, "BeepHandler#fadeIn now play beep if systemToneRequested(%1)(connection=%2)", this.systemToneRequested, (long)n);
        if (n == 120 && this.systemToneRequested) {
            this.playBeep();
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof HMIAudioService) {
            if (!HMIAudioService.CLIENT_TTS_TOUCHPAD.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
            this.audioService = (HMIAudioService)object;
        } else if (object instanceof WavePlayer) {
            SystemTonePlayer systemTonePlayer = ((WavePlayer)object).getSystemTonePlayer();
            this.registerSystemTonePlayer(systemTonePlayer);
        } else {
            this.bundleContext.ungetService(serviceReference);
            return null;
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class MyWavePlayerListener
    implements WavePlayerListener {
        private MyWavePlayerListener() {
        }

        public void state(int n) {
            lc.log(10000000, "BeepHandler#MyWavePlayerListener#state %1", (long)n);
            if (n != 0) {
                BeepHandler.this.releaseAudio();
            }
        }

        public void playToneInfo(int n) {
            lc.log(10000000, "BeepHandler#MyWavePlayerListener#playToneInfo playTone=%1 set.", (long)n);
        }
    }
}

