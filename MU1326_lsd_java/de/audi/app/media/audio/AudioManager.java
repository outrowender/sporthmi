/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.AudioContext;
import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioContextStateNotifier;
import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.audio.JobNotifyAudioFocus;
import de.audi.app.media.audio.JobNotifyAudioState;
import de.audi.app.media.audio.JobNotifyRearSeatAudioFocus;
import de.audi.app.media.audio.NullToneService;
import de.audi.app.media.audio.TunerServiceHandler;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener;
import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.def.ATIPAudioRouteImpl;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AudioManager
extends AbstractMediaTerminalComponent
implements HMIAudioServiceListener,
IAudioManager,
IAudioContextStateNotifier {
    private static final String LOGCLASS = "AudioManager";
    private static final int AUDIO_FOCUS_OTHER = 0;
    private static final int AUDIO_FOCUS_MEDIA_FRONT = 1;
    private static final int AUDIO_FOCUS_MEDIA_ONLY_REARSEAT = 2;
    private final int CONN_MUTE;
    private final int CONN_STANDBY;
    private final Object audioContextMutex = new Object();
    private final IServiceTracker audioManagerServiceTracker;
    private final IServiceTracker audioFocusManagerTracker;
    private final IServiceTracker audioDrawerContextTracker;
    private final TunerServiceHandler tunerServiceHandler;
    private final boolean[] audioFocusOnTerminal = new boolean[8];
    private volatile HMIAudioService audioService;
    private volatile IAudioFocusManager audioFocusManager;
    private volatile AudioDrawerContext audioDrawerContext = null;
    private volatile ServiceRegistration audioServiceListenerRegistration;
    private volatile ServiceRegistration audioFocusClientRegistration;
    private volatile CopyOnWriteArrayList audioContextListeners = new CopyOnWriteArrayList();
    private AudioContext activeAudioContext;
    private boolean audioMgrReady;
    private static final int MAX_RETRIES_ON_ERROR = 3;
    private int errorRetriesCounter = 0;
    private volatile int prevAudioFocus = 0;
    private volatile boolean prevRearSeatAudioFocus = false;
    private final IServiceTracker mediaRoutesServiceTracker;
    private final IServiceTracker toneServiceTracker;
    private volatile ServiceRegistration mediaRouterListenerRegistration;
    private volatile ATIPMediaRouterService mediaRouterService;
    private volatile ToneService toneService;
    public volatile int currentMPL1Route = 1;
    public volatile boolean filePlayerACStarted;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPMediaRouterService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneService;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener;

    public AudioManager(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.tunerServiceHandler = new TunerServiceHandler(iMediaTerminal);
        this.audioFocusManager = new NullAudioFocusManager(this.logger.audio());
        switch (iMediaTerminal.getTerminalID()) {
            case 3: 
            case 4: {
                this.CONN_MUTE = 8;
                this.CONN_STANDBY = 3;
                break;
            }
            default: {
                this.CONN_MUTE = 8;
                this.CONN_STANDBY = 3;
            }
        }
        this.audioService = new NullHMIAudioService(this.logger.audio());
        this.audioManagerServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AudioManager.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
                if (!HMIAudioService.CLIENT_MEDIA.equals(object2)) {
                    return;
                }
                AudioManager.this.logger.audio().log(1000000, "[%1.removedService] Audio service removed.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.getTerminal().getServiceManager().releaseService(serviceReference);
                AudioManager.this.setAudioService(new NullHMIAudioService(AudioManager.this.logger.audio()));
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = serviceReference.getProperty("AUDIO_CLIENT_ID");
                if (!HMIAudioService.CLIENT_MEDIA.equals(object)) {
                    return null;
                }
                Object object2 = AudioManager.this.getTerminal().getServiceManager().getService(serviceReference);
                AudioManager.this.logger.audio().log(1000000, "[%1.addingService] Audio service found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.setAudioService((HMIAudioService)object2);
                return object2;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.audioFocusManagerTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = AudioManager.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.audio().log(1000000, "[%1.addingService] Audio focus manager found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.audioFocusManager = (IAudioFocusManager)AudioManager.this.getTerminal().getServiceManager().getService(serviceReference);
                return AudioManager.this.audioFocusManager;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.audio().log(1000000, "[%1.addingService] Audio focus manager removed", (Object)AudioManager.LOGCLASS);
                AudioManager.this.audioFocusManager = new NullAudioFocusManager(AudioManager.this.logger.audio());
                AudioManager.this.getTerminal().getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.audioDrawerContextTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = AudioManager.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.audio().log(1000000, "[%1.addingService] Audio Drawer manager found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.audioDrawerContext = (AudioDrawerContext)AudioManager.this.getTerminal().getServiceManager().getService(serviceReference);
                AudioManager.this.setDrawerContext();
                return AudioManager.this.audioDrawerContext;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.audio().log(1000000, "[%1.addingService] Audio Drawer manager removed", (Object)AudioManager.LOGCLASS);
                AudioManager.this.audioDrawerContext = null;
                AudioManager.this.getTerminal().getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.mediaRoutesServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$ATIPMediaRouterService == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterService = AudioManager.class$("de.audi.atip.interapp.audio.ATIPMediaRouterService")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.audio().log(100000, "[%1.removedService]", (Object)AudioManager.LOGCLASS);
                AudioManager.this.mediaRouterService = null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.audio().log(100000000, "[%1.addingService] Media router serrive found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.mediaRouterService = (ATIPMediaRouterService)AudioManager.this.getTerminal().getServiceManager().getService(serviceReference);
                return AudioManager.this.mediaRouterService;
            }
        });
        this.logger.audio().log(100000, "[%1.init] create a tone service tracker.", (Object)LOGCLASS);
        this.toneServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = AudioManager.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.audio().log(100000, "[%1.removedService]", (Object)AudioManager.LOGCLASS);
                AudioManager.this.toneService = new NullToneService(AudioManager.this.logger.audio());
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.audio().log(100000, "[%1.modifiedService]", (Object)AudioManager.LOGCLASS);
            }

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.audio().log(100000000, "[%1.addingService] media tone service found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.toneService = (ToneService)AudioManager.this.getTerminal().getServiceManager().getService(serviceReference);
                return AudioManager.this.toneService;
            }
        });
        this.getTerminal().getDiagnosisManager().addDataProvider(-1, new IDiagnosisDataProvider(){

            public String getDiagValue() {
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < 8; ++i2) {
                    buffer.append("terminal='").append(i2).append("', focus='").append(AudioManager.this.audioFocusOnTerminal[i2]).append("'\n");
                }
                return buffer.toString();
            }

            public String getDiagKey() {
                return "AudioManager.audioFocus";
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.activeAudioContext = new AudioContext(9, this, true);
            for (int i2 = 0; i2 < 8; ++i2) {
                this.audioFocusOnTerminal[i2] = false;
            }
            this.audioMgrReady = false;
        }
        this.tunerServiceHandler.init();
        this.audioManagerServiceTracker.open();
        this.audioFocusManagerTracker.open();
        this.audioDrawerContextTracker.open();
        this.mediaRoutesServiceTracker.open();
        this.toneServiceTracker.open();
        this.audioFocusClientRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = AudioManager.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient, new IAudioFocusClient(){

            public void updateAudioFocus(final int n, final int n2) {
                final boolean bl = AudioManager.this.getTerminal().isStartup() && 2 == AudioManager.this.getTerminal().getFramework().getLastmodeHandler().getLastmodeAudio(n);
                AudioManager.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("AudioManager.updateAudioFocus"){

                    public void run() {
                        boolean bl3;
                        boolean bl2 = bl3 = n2 == 2;
                        if (AudioManager.this.logger.audio().isInfo()) {
                            AudioManager.this.logger.audio().log(1000000, "[%1.updateAudioFocus] '%3' (terminalID='%2')", (Object)AudioManager.LOGCLASS, (Object)new Integer(n), (Object)(bl3 ? "MEDIA" : "OTHER"));
                        }
                        AudioManager.this.setAudioFocus(n, bl3, !bl);
                    }
                });
            }
        }, new Hashtable(0));
        object = new Hashtable(1);
        ((Hashtable)object).put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_MEDIA);
        this.audioServiceListenerRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AudioManager.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener, this, (Dictionary)object);
        this.mediaRouterListenerRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener = AudioManager.class$("de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener, new MediaRouterServiceListener(), new Hashtable(0));
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        if (this.hasAudioFocus()) {
            this.releaseAudio();
        }
        this.audioFocusClientRegistration.unregister();
        this.mediaRouterListenerRegistration.unregister();
        this.audioServiceListenerRegistration.unregister();
        this.mediaRoutesServiceTracker.close();
        this.audioManagerServiceTracker.close();
        this.audioFocusManagerTracker.close();
        this.audioDrawerContextTracker.close();
        this.toneServiceTracker.close();
        this.tunerServiceHandler.deinit();
    }

    public void requestAudioFocus() {
        this.logger.audio().log(1000000, "[%1.requestAudioFocus]", (Object)LOGCLASS);
        this.audioFocusManager.setActiveAudioApp(this.getTerminal().getTerminalID(), 2);
    }

    public void switchAudioFocusToTuner() {
        this.setAudioFocus(this.getTerminal().getTerminalID(), false, false);
        this.audioFocusManager.setActiveAudioApp(this.getTerminal().getTerminalID(), 1);
    }

    public void switchAudioFocusToTV() {
        this.audioFocusManager.setActiveAudioApp(this.getTerminal().getTerminalID(), 38);
    }

    public void switchSDISAudioFocusToTV() {
        this.audioFocusManager.setActiveAudioApp(2, 38);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAudioFocus(int n, boolean bl, boolean bl2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            int n2;
            this.logger.audio().log(1000000, "[%2.setAudioFocus] '%1' (terminal='%3')", bl, (Object)LOGCLASS, (Object)new Integer(n));
            this.prevAudioFocus = this.getAudioFocus();
            this.prevRearSeatAudioFocus = this.hasRearSeatAudioFocus();
            this.audioFocusOnTerminal[n] = bl;
            boolean bl3 = this.hasRearSeatAudioFocus();
            if (!this.prevRearSeatAudioFocus && bl3 && this.prevAudioFocus == 1) {
                this.requestAudio(this.activeAudioContext.getConnection(), true, bl2);
            }
            if (this.prevRearSeatAudioFocus != bl3) {
                this.notifyRearSeatAudioFocusChanged(bl3, this.audioContextListeners);
            }
            if (this.prevAudioFocus == (n2 = this.getAudioFocus())) {
                this.logger.audio().log(1000000, "[%1.setAudioFocus] Not changed. Ignore.", (Object)LOGCLASS);
                return;
            }
            this.logger.audio().log(1000000, "[%1.setAudioFocus] '%2'", (Object)LOGCLASS, (Object)AudioManager.getFocusStr(n2));
            this.setDrawerContext();
            if (n2 == 1) {
                this.restoreCurrentAudioContext(bl2, this.activeAudioContext.isCheckAudioFocus());
            } else if (n2 == 2) {
                if (this.prevAudioFocus == 1 && this.activeAudioContext.getState() == 3) {
                    this.logger.audio().log(1000000, "[%1.setAudioFocus] Media on front and rear is paused. Do not start playback on rear.", (Object)LOGCLASS);
                } else {
                    this.changeAudioContextState("audioFocus", this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), 2);
                }
            } else if (this.prevAudioFocus == 2 && n2 == 0) {
                this.changeAudioContextState("audioFocus", this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), 5);
            }
            this.notifyAudioFocusChanged(n2 == 1, this.audioContextListeners);
        }
    }

    private static String getFocusStr(int n) {
        switch (n) {
            case 1: {
                return "FRONT";
            }
            case 2: {
                return "REARSEAT_ONLY";
            }
            case 0: {
                return "OTHER";
            }
        }
        return new StringBuffer().append("UNKOWN(").append(n).append(")").toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getAudioFocus() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            boolean bl = this.audioFocusOnTerminal[this.getTerminal().getTerminalID()];
            boolean bl2 = this.hasRearSeatAudioFocus();
            if (bl) {
                return 1;
            }
            if (bl2) {
                return 2;
            }
            return 0;
        }
    }

    public boolean hasRearSeatAudioFocus() {
        return this.audioFocusOnTerminal[3] | this.audioFocusOnTerminal[4] | this.audioFocusOnTerminal[2];
    }

    public boolean hasAudioFocus() {
        return this.getAudioFocus() != 0;
    }

    public boolean hasFrontAudioFocus() {
        return this.getAudioFocus() == 1;
    }

    public boolean hasRearSeatAudioFocusOnly() {
        return this.getAudioFocus() == 2;
    }

    private void setAudioService(HMIAudioService hMIAudioService) {
        this.logger.audio().log(1000000, "[%1.setAudioService] '%2'", (Object)LOGCLASS, (Object)hMIAudioService);
        this.audioService = hMIAudioService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private HMIAudioService getAudioService() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (!this.audioMgrReady) {
                this.logger.audio().log(1000000, "[%1.getAudioService] Not ready to control.", (Object)LOGCLASS);
                return new NullHMIAudioService(this.logger.audio());
            }
            return this.audioService;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addAudioContextListener(IAudioStateListener iAudioStateListener) {
        if (iAudioStateListener == null) {
            throw new IllegalArgumentException("Argument is null.");
        }
        if (!this.audioContextListeners.addIfAbsent(iAudioStateListener)) {
            this.logger.audio().log(1000000, "[%1.addAudioContextListener] '%2' already added", (Object)LOGCLASS, (Object)iAudioStateListener);
            return;
        }
        this.logger.audio().log(1000000, "[%1.addAudioContextListener] '%2'", (Object)LOGCLASS, (Object)iAudioStateListener);
        Object object = this.audioContextMutex;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(iAudioStateListener);
            this.notifyAudioStateChanged(this.activeAudioContext.getConnection(), this.activeAudioContext.getState(), arrayList);
            this.notifyRearSeatAudioFocusChanged(this.hasRearSeatAudioFocus(), arrayList);
        }
    }

    public void removeAudioContextListener(IAudioStateListener iAudioStateListener) {
        this.logger.audio().log(1000000, "[%1.removeAudioContextListener] '%2'.", (Object)LOGCLASS, (Object)iAudioStateListener);
        this.audioContextListeners.remove(iAudioStateListener);
    }

    public void notifyAudioStateChanged(int n, int n2) {
        this.notifyAudioStateChanged(n, n2, this.audioContextListeners);
    }

    private void notifyAudioStateChanged(int n, int n2, List list) {
        if (list.isEmpty() || n == 9) {
            return;
        }
        AudioState audioState = new AudioState(n, n2);
        this.logger.audio().log(1000000, "[%1.notifyAudioStateChanged] '%2'", (Object)LOGCLASS, (Object)audioState);
        this.getTerminal().getDispatcher().execute(new JobNotifyAudioState(this.logger, list, audioState));
    }

    private void notifyAudioFocusChanged(boolean bl, List list) {
        if (list.isEmpty()) {
            return;
        }
        this.logger.audio().log(1000000, "[%1.notifyAudioFocus] '%2'", (Object)LOGCLASS, (Object)bl);
        this.getTerminal().getDispatcher().execute(new JobNotifyAudioFocus(this.logger, list, bl));
    }

    private void notifyRearSeatAudioFocusChanged(boolean bl, List list) {
        this.logger.audio().log(1000000, "[%1.notifyRearSeatAudioFocusChanged] '%2'", (Object)LOGCLASS, (Object)bl);
        this.getTerminal().getDispatcher().execute(new JobNotifyRearSeatAudioFocus(this.logger, this.getChoiceModel(200903), bl, list));
    }

    public void requestAudio(int n, boolean bl) {
        this.requestAudio(n, bl, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean requestAudio(int n, boolean bl, boolean bl2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            boolean bl3 = this.activeAudioContext == null || this.activeAudioContext.getConnection() != n;
            this.activeAudioContext = new AudioContext(n, this, bl);
            if (bl && !this.hasAudioFocus()) {
                this.logger.audio().log(1000000, "[%1.requestAudio] '%2' (no audio focus)", (Object)LOGCLASS, (long)n);
                return bl3;
            }
            if (this.getAudioFocus() == 2 && !AudioManager.isSDISConnection(n)) {
                this.logger.audio().log(1000000, "[%1.requestAudio] '%2' (remote only)", (Object)LOGCLASS, (long)n);
                if (this.prevAudioFocus == 1 && this.prevRearSeatAudioFocus) {
                    this.logger.audio().log(1000000, "[%1.requestAudio] Media was and is only on rear active. Do not change the rear media state.", (Object)LOGCLASS);
                } else {
                    this.changeAudioContextState("requestAudio", n, this.getTerminal().getTerminalID(), 2);
                }
                return bl3;
            }
            this.logger.audio().log(1000000, "[%1.requestAudio] '%2'", (Object)LOGCLASS, (long)n);
            this.errorRetriesCounter = 0;
            boolean bl4 = !bl2 && this.CONN_MUTE == this.getAudioService().getActiveConnection(this.getTerminal().getTerminalID());
            this.releaseSDISConnections();
            if (AudioManager.isSDISConnection(n)) {
                this.getAudioService().requestConnection(n, 2, 0);
            } else {
                int n2;
                this.getAudioService().requestConnection(n, this.getTerminal().getTerminalID(), 0);
                if ((this.audioFocusOnTerminal[2] || this.audioFocusOnTerminal[3]) && AudioManager.isSDISConnection(n2 = AudioManager.getSDISConnection(n))) {
                    this.getAudioService().requestConnection(n2, 2, 0);
                }
            }
            if (bl4) {
                this.logger.audio().log(1000000, "[%1.requestAudio] demute=false", (Object)LOGCLASS);
                this.mute();
            }
            return bl3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestEntSuppression() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.activeAudioContext = new AudioContext(9, this, true);
            if (!this.hasAudioFocus()) {
                this.logger.audio().log(1000000, "[%1.requestEntSuppression] No audio focus", (Object)LOGCLASS);
                return;
            }
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1000000, "[%1.requestEntSuppression] Remote only.", (Object)LOGCLASS);
                return;
            }
            this.logger.audio().log(1000000, "[%1.requestEntSuppression]", (Object)LOGCLASS);
            this.errorRetriesCounter = 0;
            this.getAudioService().requestConnection(9, this.getTerminal().getTerminalID(), 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fadeTo() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.activeAudioContext.getState() != 2) {
                this.logger.audio().log(1000000, "[%1.fadeTo] Not STARTED, ignore.", (Object)LOGCLASS);
                return;
            }
            if (this.activeAudioContext.getConnection() == 9) {
                this.logger.audio().log(1000000, "[%1.fadeTo]", (Object)LOGCLASS);
                return;
            }
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1000000, "[%1.fadeTo] Remote only.", (Object)LOGCLASS);
                return;
            }
            this.logger.audio().log(1000000, "[%1.fadeTo] '%2'", (Object)LOGCLASS, (long)this.activeAudioContext.getConnection());
            this.getAudioService().fadeToConnection(this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void restoreCurrentAudioContext(boolean bl, boolean bl2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() != 1 && bl2) {
                this.logger.audio().log(1000000, "[%1.restoreCurrentAudioContext] No audio focus at front.", (Object)LOGCLASS);
                return;
            }
            if (!this.audioMgrReady) {
                this.logger.audio().log(1000000, "[%1.restoreCurrentAudioContext] Not ready to control", (Object)LOGCLASS);
                return;
            }
            this.logger.audio().log(1000000, "[%1.restoreCurrentAudioContext] '%2'", (Object)LOGCLASS, (long)this.activeAudioContext.getConnection());
            if (bl) {
                this.resumeAudio(false);
            }
            if (AudioManager.isSDISConnection(this.activeAudioContext.getConnection())) {
                this.activeAudioContext = new AudioContext(AudioManager.getFrontConnectionfromSDISConnection(this.activeAudioContext.getConnection()), this, false);
            }
            this.errorRetriesCounter = 0;
            this.getAudioService().requestConnection(this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseAudio() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            int n = this.activeAudioContext.getConnection();
            this.logger.audio().log(1000000, "[%1.releaseAudio] '%2'", (Object)LOGCLASS, (long)n);
            if (n != 9) {
                this.getAudioService().releaseConnection(this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID());
            }
        }
    }

    private boolean releaseTA() {
        if (this.getTerminal().getTerminalID() != 0) {
            return false;
        }
        this.tunerServiceHandler.abortActiveTA();
        return true;
    }

    private void releaseSDISConnections() {
        this.getAudioService().releaseConnection(306, 2);
        this.getAudioService().releaseConnection(305, 2);
    }

    public void mute() {
        this.logger.audio().log(1000000, "[%1.mute] Mute (conn='%2')", (Object)LOGCLASS, (long)this.CONN_MUTE);
        this.errorRetriesCounter = 0;
        this.getAudioService().requestConnection(this.CONN_MUTE, this.getTerminal().getTerminalID(), 0);
    }

    public void demute() {
        this.logger.audio().log(1000000, "[%1.demute] Demute (conn='%2')", (Object)LOGCLASS, (long)this.CONN_MUTE);
        this.getAudioService().releaseConnection(this.CONN_MUTE, this.getTerminal().getTerminalID());
    }

    public boolean resumeAudio(boolean bl) {
        if (bl && !this.hasAudioFocus()) {
            this.logger.audio().log(1000000, "[%1.resumeAudio] No audio focus", (Object)LOGCLASS);
            return false;
        }
        this.logger.audio().log(1000000, "[%1.resumeAudio] check focus %2", (Object)LOGCLASS, (Object)bl);
        if (this.isAudioAudible()) {
            this.logger.audio().log(1000000, "[%1.resumeAudio] audible, no demute required", (Object)LOGCLASS);
            return true;
        }
        this.getAudioService().releaseA2LSConnection();
        boolean bl2 = this.releaseTA();
        if (this.isMuted() && !this.hasRearSeatAudioFocusOnly()) {
            this.demute();
            bl2 = true;
        }
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void btMute() {
        if (!this.hasAudioFocus()) {
            this.logger.audio().log(1000000, "[%1.btMute] No audio focus", (Object)LOGCLASS);
            return;
        }
        this.logger.audio().log(1000000, "[%1.btMute] BTMute (con='%2').", (Object)LOGCLASS, 200L);
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.errorRetriesCounter = 0;
        }
        this.getAudioService().requestConnection(200, this.getTerminal().getTerminalID(), 0);
    }

    public void btDemute() {
        this.logger.audio().log(1000000, "[%1.btDemute] BTDemute (con='%2')", (Object)LOGCLASS, 200L);
        this.getAudioService().releaseConnection(200, this.getTerminal().getTerminalID());
    }

    public boolean isStandbyMuted() {
        return this.getAudioService().getStatus(this.CONN_STANDBY, this.getTerminal().getTerminalID()) != 5;
    }

    public boolean isMuted() {
        return this.getAudioService().getStatus(this.CONN_MUTE, this.getTerminal().getTerminalID()) != 5;
    }

    public boolean isBtMuted() {
        return this.getAudioService().getStatus(200, this.getTerminal().getTerminalID()) != 5;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestVolumelock(String string) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.audio().log(1000000, "[%1.requestVolumelock] '%2'", (Object)LOGCLASS, (long)this.activeAudioContext.getConnection());
            if (AudioManager.isSDISConnection(this.activeAudioContext.getConnection())) {
                this.getAudioService().setVolumelock(this.activeAudioContext.getConnection(), 2, true, string);
            } else {
                this.getAudioService().setVolumelock(this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), true, string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseVolumelock(String string) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.audio().log(1000000, "[%1.releaseVolumelock] '%2'", (Object)LOGCLASS, (long)this.activeAudioContext.getConnection());
            if (AudioManager.isSDISConnection(this.activeAudioContext.getConnection())) {
                this.getAudioService().setVolumelock(this.activeAudioContext.getConnection(), 2, false, string);
            } else {
                this.getAudioService().setVolumelock(this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), false, string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isAudioAudible() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.audio().log(1000000, "[AudioManager.isAudioAudible] connection %1 state %2", (long)this.activeAudioContext.getConnection(), (long)this.activeAudioContext.getState());
            if (this.activeAudioContext.getConnection() == 9 && this.isMuted()) {
                return false;
            }
            return new AudioState(this.activeAudioContext.getConnection(), this.activeAudioContext.getState()).isAudible();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAMAvailable(boolean bl) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.audio().log(1000000, "[%1.updateAMAvailable] '%2'", (Object)LOGCLASS, (Object)(bl ? "AVAILABLE" : "NOT AVAILABLE"));
            this.audioMgrReady = bl;
            if (this.audioMgrReady) {
                boolean bl2 = this.activeAudioContext.getState() != 3 && this.activeAudioContext.getState() != 0;
                this.restoreCurrentAudioContext(bl2, this.activeAudioContext.isCheckAudioFocus());
            } else {
                this.changeAudioContextState("updateAMAvailable", this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), 0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean changeAudioContextState(String string, int n, int n2, int n3) {
        this.logger.audio().log(1000000, "[%1.changeAudioContextState] Called", (Object)LOGCLASS);
        this.logger.audio().log(1000000, new StringBuffer().append("[%1.changeAudioContextState] connection:").append(n).append(" terminal: ").append(n2).append(" newState: ").append(n3).toString(), (Object)LOGCLASS);
        if (n2 != this.getTerminal().getTerminalID()) {
            this.logger.audio().log(1000000, new StringBuffer().append("[%1.changeAudioContextState] Not for this terminal. ").append(this.getTerminal().getTerminalID()).toString(), (Object)LOGCLASS);
            return false;
        }
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.activeAudioContext.getConnection() != n && !AudioManager.isSDISConnection(n)) {
                this.logger.audio().log(1000000, "[%1.changeAudioContextState] Not for this audio context.", (Object)LOGCLASS);
                return false;
            }
            this.logger.audio().log(1000000, "[%1.%2] '%3'", (Object)LOGCLASS, (Object)string, (long)n);
            this.logger.audio().log(1000000, new StringBuffer().append("[%1.changeAudioContextState] old state:").append(this.activeAudioContext.getState()).append(" newState: ").append(n3).toString(), (Object)LOGCLASS);
            this.activeAudioContext.setState(n3);
            return true;
        }
    }

    private void setDrawerContext() {
        if (this.audioDrawerContext == null) {
            this.logger.audio().log(1000000, "%1.setDrawerContext no drawer context available ", (Object)LOGCLASS);
            return;
        }
        if (this.hasFrontAudioFocus()) {
            this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_MEDIA, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
            this.logger.audio().log(1000000, "%1.setDrawerContext active ", (Object)LOGCLASS);
        } else {
            this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_MEDIA, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
            this.logger.audio().log(1000000, "%1.setDrawerContext inactive", (Object)LOGCLASS);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stopConnection(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1000000, "[%1.stopConnection] %2 REMOTE only. Ignore.", (Object)LOGCLASS, (long)n);
                return;
            }
            this.changeAudioContextState("stopConnection", n, n2, 5);
        }
        if (201 == n) {
            this.filePlayerACStarted = false;
            if (1 != this.currentMPL1Route && null != this.mediaRouterService) {
                this.logger.audio().log(1000000, "[%1.stopConnection] Change audio route %2", (Object)LOGCLASS, (long)this.currentMPL1Route);
                this.mediaRouterService.setAudioRoutes(new ATIPAudioRoute[]{new ATIPAudioRouteImpl(this.currentMPL1Route, 1, 0)});
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void pauseConnection(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1000000, "[%1.pauseConnection] %2 REMOTE only. Ignore.", (Object)LOGCLASS, (long)n);
                return;
            }
            this.changeAudioContextState("pauseConnection", n, n2, 3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void startConnection(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                if (AudioManager.isSDISConnection(n)) {
                    this.changeAudioContextState("startConnection", n, this.getTerminal().getTerminalID(), 2);
                }
                this.logger.audio().log(1000000, "[%1.startConnection] %2 REMOTE only. Ignore.", (Object)LOGCLASS, (long)n);
                return;
            }
            this.changeAudioContextState("startConnection", n, n2, 2);
        }
        if (201 == n) {
            this.filePlayerACStarted = true;
            if (1 != this.currentMPL1Route && null != this.mediaRouterService) {
                this.logger.audio().log(1000000, "[%1.startConnection] Change audio route.", (Object)LOGCLASS);
                this.mediaRouterService.setAudioRoutes(new ATIPAudioRoute[]{new ATIPAudioRouteImpl(1, 1, 0)});
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void errorConnection(int n, int n2, int n3) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1000000, "[%1.errorConnection] %2 REMOTE only. Ignore.", (Object)LOGCLASS, (long)n);
                return;
            }
            if (!this.audioMgrReady) {
                this.logger.audio().log(10000000, "[%1.errorConnection] AudioMgt=NOT READY, ignore errorConnection(%2)", (Object)LOGCLASS, (long)n);
                return;
            }
            if (this.changeAudioContextState("errorConnection", n, n2, 6)) {
                if (!this.hasAudioFocus()) {
                    return;
                }
                if (3 >= this.errorRetriesCounter) {
                    this.logger.audio().log(1000000, "[%1.errorConnection] Max retries reached.", (Object)LOGCLASS);
                    return;
                }
                this.logger.audio().log(1000000, "[%1.errorConnection] Request connection again", (Object)LOGCLASS);
                ++this.errorRetriesCounter;
                this.getAudioService().requestConnection(this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), 0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fadedIn(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1000000, "[%1.fadedIn] %2 REMOTE only. Ignore.", (Object)LOGCLASS, (long)n);
                return;
            }
            this.changeAudioContextState("fadedIn", n, n2, 4);
        }
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }

    public static final boolean isSDISConnection(int n) {
        switch (n) {
            case 305: 
            case 306: {
                return true;
            }
        }
        return false;
    }

    private static final int getSDISConnection(int n) {
        switch (n) {
            case 24: {
                return 306;
            }
            case 23: {
                return 305;
            }
        }
        return n;
    }

    private static final int getFrontConnectionfromSDISConnection(int n) {
        switch (n) {
            case 306: {
                return 24;
            }
            case 305: {
                return 23;
            }
        }
        return n;
    }

    public void requestSdisConnectionsIfRequired(int n) {
        int n2 = AudioManager.getSDISConnection(n);
        boolean bl = AudioManager.isSDISConnection(n2);
        if (this.hasRearSeatAudioFocus() && bl) {
            this.logger.audio().log(1000000, "[%1.requestSdisConnectionsIfRequired] AC:%2", (Object)LOGCLASS, (long)n2);
            this.getAudioService().requestConnection(n2, 2, 0);
        }
    }

    public ToneService getToneService() {
        return this.toneService;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class MediaRouterServiceListener
    implements ATIPMediaRouterServiceListener {
        private MediaRouterServiceListener() {
        }

        public void updateActiveAudioRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
            AudioManager.this.logger.audio().log(1000000, "[%1.updateActiveAudioRoutes]", (Object)AudioManager.LOGCLASS);
            if (AudioManager.this.filePlayerACStarted) {
                return;
            }
            for (int i2 = 0; i2 < aTIPAudioRouteArray.length; ++i2) {
                if (1 != aTIPAudioRouteArray[i2].getRoutingOutput()) continue;
                AudioManager.this.currentMPL1Route = aTIPAudioRouteArray[i2].getRoutingInput();
                AudioManager.this.logger.audio().log(1000000, "[%1.updateActiveAudioRoutes] %2", (Object)AudioManager.LOGCLASS, (long)AudioManager.this.currentMPL1Route);
            }
        }
    }
}

