/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.AudioContext;
import de.audi.app.media.audio.AudioManager$1;
import de.audi.app.media.audio.AudioManager$2;
import de.audi.app.media.audio.AudioManager$3;
import de.audi.app.media.audio.AudioManager$4;
import de.audi.app.media.audio.AudioManager$5;
import de.audi.app.media.audio.AudioManager$6;
import de.audi.app.media.audio.AudioManager$7;
import de.audi.app.media.audio.AudioManager$MediaRouterServiceListener;
import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioContextStateNotifier;
import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.audio.JobNotifyAudioFocus;
import de.audi.app.media.audio.JobNotifyAudioState;
import de.audi.app.media.audio.JobNotifyRearSeatAudioFocus;
import de.audi.app.media.audio.TunerServiceHandler;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.def.ATIPAudioRouteImpl;
import de.audi.atip.interapp.def.NullHMIAudioService;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.osgi.framework.ServiceRegistration;

public class AudioManager
extends AbstractMediaTerminalComponent
implements HMIAudioServiceListener,
IAudioManager,
IAudioContextStateNotifier {
    private static final String LOGCLASS;
    private static final int AUDIO_FOCUS_OTHER;
    private static final int AUDIO_FOCUS_MEDIA_FRONT;
    private static final int AUDIO_FOCUS_MEDIA_ONLY_REARSEAT;
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
    private static final int MAX_RETRIES_ON_ERROR;
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
        this.audioManagerServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AudioManager.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService, new AudioManager$1(this));
        this.audioFocusManagerTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = AudioManager.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager, new AudioManager$2(this));
        this.audioDrawerContextTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = AudioManager.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext, new AudioManager$3(this));
        this.mediaRoutesServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$ATIPMediaRouterService == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterService = AudioManager.class$("de.audi.atip.interapp.audio.ATIPMediaRouterService")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterService, new AudioManager$4(this));
        this.logger.audio().log(-1601830656, "[%1.init] create a tone service tracker.", (Object)"AudioManager");
        this.toneServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = AudioManager.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService, new AudioManager$5(this));
        this.getTerminal().getDiagnosisManager().addDataProvider(-1, new AudioManager$6(this));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"AudioManager");
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
        this.audioFocusClientRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = AudioManager.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient, new AudioManager$7(this), new Hashtable(0));
        object = new Hashtable(1);
        ((Hashtable)object).put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_MEDIA);
        this.audioServiceListenerRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AudioManager.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener, this, (Dictionary)object);
        this.mediaRouterListenerRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener = AudioManager.class$("de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener, new AudioManager$MediaRouterServiceListener(this, null), new Hashtable(0));
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"AudioManager");
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

    @Override
    public void requestAudioFocus() {
        this.logger.audio().log(1078071040, "[%1.requestAudioFocus]", (Object)"AudioManager");
        this.audioFocusManager.setActiveAudioApp(this.getTerminal().getTerminalID(), 2);
    }

    @Override
    public void switchAudioFocusToTuner() {
        this.setAudioFocus(this.getTerminal().getTerminalID(), false, false);
        this.audioFocusManager.setActiveAudioApp(this.getTerminal().getTerminalID(), 1);
    }

    @Override
    public void switchAudioFocusToTV() {
        this.audioFocusManager.setActiveAudioApp(this.getTerminal().getTerminalID(), 38);
    }

    @Override
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
            this.logger.audio().log(1078071040, "[%2.setAudioFocus] '%1' (terminal='%3')", bl, (Object)"AudioManager", (Object)new Integer(n));
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
                this.logger.audio().log(1078071040, "[%1.setAudioFocus] Not changed. Ignore.", (Object)"AudioManager");
                return;
            }
            this.logger.audio().log(1078071040, "[%1.setAudioFocus] '%2'", (Object)"AudioManager", (Object)AudioManager.getFocusStr(n2));
            this.setDrawerContext();
            if (n2 == 1) {
                this.restoreCurrentAudioContext(bl2, this.activeAudioContext.isCheckAudioFocus());
            } else if (n2 == 2) {
                if (this.prevAudioFocus == 1 && this.activeAudioContext.getState() == 3) {
                    this.logger.audio().log(1078071040, "[%1.setAudioFocus] Media on front and rear is paused. Do not start playback on rear.", (Object)"AudioManager");
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

    @Override
    public boolean hasRearSeatAudioFocus() {
        return this.audioFocusOnTerminal[3] | this.audioFocusOnTerminal[4] | this.audioFocusOnTerminal[2];
    }

    @Override
    public boolean hasAudioFocus() {
        return this.getAudioFocus() != 0;
    }

    @Override
    public boolean hasFrontAudioFocus() {
        return this.getAudioFocus() == 1;
    }

    @Override
    public boolean hasRearSeatAudioFocusOnly() {
        return this.getAudioFocus() == 2;
    }

    private void setAudioService(HMIAudioService hMIAudioService) {
        this.logger.audio().log(1078071040, "[%1.setAudioService] '%2'", (Object)"AudioManager", (Object)hMIAudioService);
        this.audioService = hMIAudioService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private HMIAudioService getAudioService() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (!this.audioMgrReady) {
                this.logger.audio().log(1078071040, "[%1.getAudioService] Not ready to control.", (Object)"AudioManager");
                return new NullHMIAudioService(this.logger.audio());
            }
            return this.audioService;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addAudioContextListener(IAudioStateListener iAudioStateListener) {
        if (iAudioStateListener == null) {
            throw new IllegalArgumentException("Argument is null.");
        }
        if (!this.audioContextListeners.addIfAbsent(iAudioStateListener)) {
            this.logger.audio().log(1078071040, "[%1.addAudioContextListener] '%2' already added", (Object)"AudioManager", (Object)iAudioStateListener);
            return;
        }
        this.logger.audio().log(1078071040, "[%1.addAudioContextListener] '%2'", (Object)"AudioManager", (Object)iAudioStateListener);
        Object object = this.audioContextMutex;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(iAudioStateListener);
            this.notifyAudioStateChanged(this.activeAudioContext.getConnection(), this.activeAudioContext.getState(), arrayList);
            this.notifyRearSeatAudioFocusChanged(this.hasRearSeatAudioFocus(), arrayList);
        }
    }

    @Override
    public void removeAudioContextListener(IAudioStateListener iAudioStateListener) {
        this.logger.audio().log(1078071040, "[%1.removeAudioContextListener] '%2'.", (Object)"AudioManager", (Object)iAudioStateListener);
        this.audioContextListeners.remove(iAudioStateListener);
    }

    @Override
    public void notifyAudioStateChanged(int n, int n2) {
        this.notifyAudioStateChanged(n, n2, this.audioContextListeners);
    }

    private void notifyAudioStateChanged(int n, int n2, List list) {
        if (list.isEmpty() || n == 9) {
            return;
        }
        AudioState audioState = new AudioState(n, n2);
        this.logger.audio().log(1078071040, "[%1.notifyAudioStateChanged] '%2'", (Object)"AudioManager", (Object)audioState);
        this.getTerminal().getDispatcher().execute(new JobNotifyAudioState(this.logger, list, audioState));
    }

    private void notifyAudioFocusChanged(boolean bl, List list) {
        if (list.isEmpty()) {
            return;
        }
        this.logger.audio().log(1078071040, "[%1.notifyAudioFocus] '%2'", (Object)"AudioManager", (Object)bl);
        this.getTerminal().getDispatcher().execute(new JobNotifyAudioFocus(this.logger, list, bl));
    }

    private void notifyRearSeatAudioFocusChanged(boolean bl, List list) {
        this.logger.audio().log(1078071040, "[%1.notifyRearSeatAudioFocusChanged] '%2'", (Object)"AudioManager", (Object)bl);
        this.getTerminal().getDispatcher().execute(new JobNotifyRearSeatAudioFocus(this.logger, this.getChoiceModel(-955251968), bl, list));
    }

    @Override
    public void requestAudio(int n, boolean bl) {
        this.requestAudio(n, bl, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean requestAudio(int n, boolean bl, boolean bl2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            boolean bl3 = this.activeAudioContext == null || this.activeAudioContext.getConnection() != n;
            this.activeAudioContext = new AudioContext(n, this, bl);
            if (bl && !this.hasAudioFocus()) {
                this.logger.audio().log(1078071040, "[%1.requestAudio] '%2' (no audio focus)", (Object)"AudioManager", (long)n);
                return bl3;
            }
            if (this.getAudioFocus() == 2 && !AudioManager.isSDISConnection(n)) {
                this.logger.audio().log(1078071040, "[%1.requestAudio] '%2' (remote only)", (Object)"AudioManager", (long)n);
                if (this.prevAudioFocus == 1 && this.prevRearSeatAudioFocus) {
                    this.logger.audio().log(1078071040, "[%1.requestAudio] Media was and is only on rear active. Do not change the rear media state.", (Object)"AudioManager");
                } else {
                    this.changeAudioContextState("requestAudio", n, this.getTerminal().getTerminalID(), 2);
                }
                return bl3;
            }
            this.logger.audio().log(1078071040, "[%1.requestAudio] '%2'", (Object)"AudioManager", (long)n);
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
                this.logger.audio().log(1078071040, "[%1.requestAudio] demute=false", (Object)"AudioManager");
                this.mute();
            }
            return bl3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestEntSuppression() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.activeAudioContext = new AudioContext(9, this, true);
            if (!this.hasAudioFocus()) {
                this.logger.audio().log(1078071040, "[%1.requestEntSuppression] No audio focus", (Object)"AudioManager");
                return;
            }
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1078071040, "[%1.requestEntSuppression] Remote only.", (Object)"AudioManager");
                return;
            }
            this.logger.audio().log(1078071040, "[%1.requestEntSuppression]", (Object)"AudioManager");
            this.errorRetriesCounter = 0;
            this.getAudioService().requestConnection(9, this.getTerminal().getTerminalID(), 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fadeTo() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.activeAudioContext.getState() != 2) {
                this.logger.audio().log(1078071040, "[%1.fadeTo] Not STARTED, ignore.", (Object)"AudioManager");
                return;
            }
            if (this.activeAudioContext.getConnection() == 9) {
                this.logger.audio().log(1078071040, "[%1.fadeTo]", (Object)"AudioManager");
                return;
            }
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1078071040, "[%1.fadeTo] Remote only.", (Object)"AudioManager");
                return;
            }
            this.logger.audio().log(1078071040, "[%1.fadeTo] '%2'", (Object)"AudioManager", (long)this.activeAudioContext.getConnection());
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
                this.logger.audio().log(1078071040, "[%1.restoreCurrentAudioContext] No audio focus at front.", (Object)"AudioManager");
                return;
            }
            if (!this.audioMgrReady) {
                this.logger.audio().log(1078071040, "[%1.restoreCurrentAudioContext] Not ready to control", (Object)"AudioManager");
                return;
            }
            this.logger.audio().log(1078071040, "[%1.restoreCurrentAudioContext] '%2'", (Object)"AudioManager", (long)this.activeAudioContext.getConnection());
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
    @Override
    public void releaseAudio() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            int n = this.activeAudioContext.getConnection();
            this.logger.audio().log(1078071040, "[%1.releaseAudio] '%2'", (Object)"AudioManager", (long)n);
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

    @Override
    public void mute() {
        this.logger.audio().log(1078071040, "[%1.mute] Mute (conn='%2')", (Object)"AudioManager", (long)this.CONN_MUTE);
        this.errorRetriesCounter = 0;
        this.getAudioService().requestConnection(this.CONN_MUTE, this.getTerminal().getTerminalID(), 0);
    }

    @Override
    public void demute() {
        this.logger.audio().log(1078071040, "[%1.demute] Demute (conn='%2')", (Object)"AudioManager", (long)this.CONN_MUTE);
        this.getAudioService().releaseConnection(this.CONN_MUTE, this.getTerminal().getTerminalID());
    }

    @Override
    public boolean resumeAudio(boolean bl) {
        if (bl && !this.hasAudioFocus()) {
            this.logger.audio().log(1078071040, "[%1.resumeAudio] No audio focus", (Object)"AudioManager");
            return false;
        }
        this.logger.audio().log(1078071040, "[%1.resumeAudio] check focus %2", (Object)"AudioManager", (Object)bl);
        if (this.isAudioAudible()) {
            this.logger.audio().log(1078071040, "[%1.resumeAudio] audible, no demute required", (Object)"AudioManager");
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
    @Override
    public void btMute() {
        if (!this.hasAudioFocus()) {
            this.logger.audio().log(1078071040, "[%1.btMute] No audio focus", (Object)"AudioManager");
            return;
        }
        this.logger.audio().log(1078071040, "[%1.btMute] BTMute (con='%2').", (Object)"AudioManager", (long)0);
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.errorRetriesCounter = 0;
        }
        this.getAudioService().requestConnection(200, this.getTerminal().getTerminalID(), 0);
    }

    @Override
    public void btDemute() {
        this.logger.audio().log(1078071040, "[%1.btDemute] BTDemute (con='%2')", (Object)"AudioManager", (long)0);
        this.getAudioService().releaseConnection(200, this.getTerminal().getTerminalID());
    }

    @Override
    public boolean isStandbyMuted() {
        return this.getAudioService().getStatus(this.CONN_STANDBY, this.getTerminal().getTerminalID()) != 5;
    }

    @Override
    public boolean isMuted() {
        return this.getAudioService().getStatus(this.CONN_MUTE, this.getTerminal().getTerminalID()) != 5;
    }

    @Override
    public boolean isBtMuted() {
        return this.getAudioService().getStatus(200, this.getTerminal().getTerminalID()) != 5;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestVolumelock(String string) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.audio().log(1078071040, "[%1.requestVolumelock] '%2'", (Object)"AudioManager", (long)this.activeAudioContext.getConnection());
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
    @Override
    public void releaseVolumelock(String string) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.audio().log(1078071040, "[%1.releaseVolumelock] '%2'", (Object)"AudioManager", (long)this.activeAudioContext.getConnection());
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
            this.logger.audio().log(1078071040, "[AudioManager.isAudioAudible] connection %1 state %2", (long)this.activeAudioContext.getConnection(), (long)this.activeAudioContext.getState());
            if (this.activeAudioContext.getConnection() == 9 && this.isMuted()) {
                return false;
            }
            return new AudioState(this.activeAudioContext.getConnection(), this.activeAudioContext.getState()).isAudible();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateAMAvailable(boolean bl) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.audio().log(1078071040, "[%1.updateAMAvailable] '%2'", (Object)"AudioManager", (Object)(bl ? "AVAILABLE" : "NOT AVAILABLE"));
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
        this.logger.audio().log(1078071040, "[%1.changeAudioContextState] Called", (Object)"AudioManager");
        this.logger.audio().log(1078071040, new StringBuffer().append("[%1.changeAudioContextState] connection:").append(n).append(" terminal: ").append(n2).append(" newState: ").append(n3).toString(), (Object)"AudioManager");
        if (n2 != this.getTerminal().getTerminalID()) {
            this.logger.audio().log(1078071040, new StringBuffer().append("[%1.changeAudioContextState] Not for this terminal. ").append(this.getTerminal().getTerminalID()).toString(), (Object)"AudioManager");
            return false;
        }
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.activeAudioContext.getConnection() != n && !AudioManager.isSDISConnection(n)) {
                this.logger.audio().log(1078071040, "[%1.changeAudioContextState] Not for this audio context.", (Object)"AudioManager");
                return false;
            }
            this.logger.audio().log(1078071040, "[%1.%2] '%3'", (Object)"AudioManager", (Object)string, (long)n);
            this.logger.audio().log(1078071040, new StringBuffer().append("[%1.changeAudioContextState] old state:").append(this.activeAudioContext.getState()).append(" newState: ").append(n3).toString(), (Object)"AudioManager");
            this.activeAudioContext.setState(n3);
            return true;
        }
    }

    private void setDrawerContext() {
        if (this.audioDrawerContext == null) {
            this.logger.audio().log(1078071040, "%1.setDrawerContext no drawer context available ", (Object)"AudioManager");
            return;
        }
        if (this.hasFrontAudioFocus()) {
            this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_MEDIA, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
            this.logger.audio().log(1078071040, "%1.setDrawerContext active ", (Object)"AudioManager");
        } else {
            this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_MEDIA, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
            this.logger.audio().log(1078071040, "%1.setDrawerContext inactive", (Object)"AudioManager");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stopConnection(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1078071040, "[%1.stopConnection] %2 REMOTE only. Ignore.", (Object)"AudioManager", (long)n);
                return;
            }
            this.changeAudioContextState("stopConnection", n, n2, 5);
        }
        if (201 == n) {
            this.filePlayerACStarted = false;
            if (1 != this.currentMPL1Route && null != this.mediaRouterService) {
                this.logger.audio().log(1078071040, "[%1.stopConnection] Change audio route %2", (Object)"AudioManager", (long)this.currentMPL1Route);
                this.mediaRouterService.setAudioRoutes(new ATIPAudioRoute[]{new ATIPAudioRouteImpl(this.currentMPL1Route, 1, 0)});
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void pauseConnection(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1078071040, "[%1.pauseConnection] %2 REMOTE only. Ignore.", (Object)"AudioManager", (long)n);
                return;
            }
            this.changeAudioContextState("pauseConnection", n, n2, 3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startConnection(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                if (AudioManager.isSDISConnection(n)) {
                    this.changeAudioContextState("startConnection", n, this.getTerminal().getTerminalID(), 2);
                }
                this.logger.audio().log(1078071040, "[%1.startConnection] %2 REMOTE only. Ignore.", (Object)"AudioManager", (long)n);
                return;
            }
            this.changeAudioContextState("startConnection", n, n2, 2);
        }
        if (201 == n) {
            this.filePlayerACStarted = true;
            if (1 != this.currentMPL1Route && null != this.mediaRouterService) {
                this.logger.audio().log(1078071040, "[%1.startConnection] Change audio route.", (Object)"AudioManager");
                this.mediaRouterService.setAudioRoutes(new ATIPAudioRoute[]{new ATIPAudioRouteImpl(1, 1, 0)});
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void errorConnection(int n, int n2, int n3) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1078071040, "[%1.errorConnection] %2 REMOTE only. Ignore.", (Object)"AudioManager", (long)n);
                return;
            }
            if (!this.audioMgrReady) {
                this.logger.audio().log(-2137614336, "[%1.errorConnection] AudioMgt=NOT READY, ignore errorConnection(%2)", (Object)"AudioManager", (long)n);
                return;
            }
            if (this.changeAudioContextState("errorConnection", n, n2, 6)) {
                if (!this.hasAudioFocus()) {
                    return;
                }
                if (3 >= this.errorRetriesCounter) {
                    this.logger.audio().log(1078071040, "[%1.errorConnection] Max retries reached.", (Object)"AudioManager");
                    return;
                }
                this.logger.audio().log(1078071040, "[%1.errorConnection] Request connection again", (Object)"AudioManager");
                ++this.errorRetriesCounter;
                this.getAudioService().requestConnection(this.activeAudioContext.getConnection(), this.getTerminal().getTerminalID(), 0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fadedIn(int n, int n2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() == 2) {
                this.logger.audio().log(1078071040, "[%1.fadedIn] %2 REMOTE only. Ignore.", (Object)"AudioManager", (long)n);
                return;
            }
            this.changeAudioContextState("fadedIn", n, n2, 4);
        }
    }

    @Override
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

    @Override
    public void requestSdisConnectionsIfRequired(int n) {
        int n2 = AudioManager.getSDISConnection(n);
        boolean bl = AudioManager.isSDISConnection(n2);
        if (this.hasRearSeatAudioFocus() && bl) {
            this.logger.audio().log(1078071040, "[%1.requestSdisConnectionsIfRequired] AC:%2", (Object)"AudioManager", (long)n2);
            this.getAudioService().requestConnection(n2, 2, 0);
        }
    }

    @Override
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

    static /* synthetic */ IMediaLogger access$000(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$100(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ void access$200(AudioManager audioManager, HMIAudioService hMIAudioService) {
        audioManager.setAudioService(hMIAudioService);
    }

    static /* synthetic */ IMediaLogger access$300(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$400(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IAudioFocusManager access$502(AudioManager audioManager, IAudioFocusManager iAudioFocusManager) {
        audioManager.audioFocusManager = iAudioFocusManager;
        return audioManager.audioFocusManager;
    }

    static /* synthetic */ IAudioFocusManager access$500(AudioManager audioManager) {
        return audioManager.audioFocusManager;
    }

    static /* synthetic */ IMediaLogger access$600(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$700(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$800(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ AudioDrawerContext access$902(AudioManager audioManager, AudioDrawerContext audioDrawerContext) {
        audioManager.audioDrawerContext = audioDrawerContext;
        return audioManager.audioDrawerContext;
    }

    static /* synthetic */ void access$1000(AudioManager audioManager) {
        audioManager.setDrawerContext();
    }

    static /* synthetic */ AudioDrawerContext access$900(AudioManager audioManager) {
        return audioManager.audioDrawerContext;
    }

    static /* synthetic */ IMediaLogger access$1100(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$1200(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ ATIPMediaRouterService access$1302(AudioManager audioManager, ATIPMediaRouterService aTIPMediaRouterService) {
        audioManager.mediaRouterService = aTIPMediaRouterService;
        return audioManager.mediaRouterService;
    }

    static /* synthetic */ IMediaLogger access$1400(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ ATIPMediaRouterService access$1300(AudioManager audioManager) {
        return audioManager.mediaRouterService;
    }

    static /* synthetic */ IMediaLogger access$1500(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ ToneService access$1602(AudioManager audioManager, ToneService toneService) {
        audioManager.toneService = toneService;
        return audioManager.toneService;
    }

    static /* synthetic */ IMediaLogger access$1700(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$1800(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$1900(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ ToneService access$1600(AudioManager audioManager) {
        return audioManager.toneService;
    }

    static /* synthetic */ boolean[] access$2000(AudioManager audioManager) {
        return audioManager.audioFocusOnTerminal;
    }

    static /* synthetic */ IMediaLogger access$2200(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$2300(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ void access$2400(AudioManager audioManager, int n, boolean bl, boolean bl2) {
        audioManager.setAudioFocus(n, bl, bl2);
    }

    static /* synthetic */ IMediaLogger access$2600(AudioManager audioManager) {
        return audioManager.logger;
    }

    static /* synthetic */ IMediaLogger access$2700(AudioManager audioManager) {
        return audioManager.logger;
    }
}

