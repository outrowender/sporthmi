/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioContext;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.BCLAudioConnection;
import de.audi.app.terminalmode.audio.DIOAudioConnection;
import de.audi.app.terminalmode.audio.GALAudioConnection;
import de.audi.app.terminalmode.audio.IAudioConnection;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.IAudioContextStateNotifier;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.audio.IMediaRoutesChangeListener;
import de.audi.app.terminalmode.audio.JobNotifyAudioFocus;
import de.audi.app.terminalmode.audio.JobNotifyAudioState;
import de.audi.app.terminalmode.audio.NullMediaRouterService;
import de.audi.app.terminalmode.audio.NullToneService;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.RequestAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.RequestAudioConnectionWithoutSync;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener;
import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.terminalmode.ITerminalModeAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.atip.utils.collections.CopyOnWriteArrayList;
import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.generics.IFluentCollection;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.ObservableProperty;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tghu.command.Command;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AudioManager
implements IAudioManager,
ITerminalModeComponent,
IActionProxyListener,
ITerminalModeAudioService {
    private static final String LOGCLASS = "AudioManager";
    private final LogChannel logger;
    private static final int AUDIO_FOCUS_OTHER = 0;
    private static final int AUDIO_FOCUS_TERMINALMODE_FRONT = 1;
    private final int CONN_MUTE;
    private final int CONN_STANDBY;
    private final Object audioContextMutex = new Object();
    private final IServiceTracker audioManagerServiceTracker;
    private final IServiceTracker audioFocusManagerTracker;
    private final IServiceTracker mediaRoutesServiceTracker;
    private final IServiceTracker toneServiceTracker;
    private final IServiceTracker audioDrawerContextTracker;
    private final LoggingPropertyFactory audioManagerPropertyFactory;
    private final Property<Boolean> audioFocusOnFront;
    volatile HMIAudioService audioService;
    private volatile IAudioFocusManager audioFocusManager;
    private volatile ATIPMediaRouterService mediaRouterService;
    private volatile ToneService toneService;
    private volatile ServiceRegistration audioServiceListenerRegistration;
    private volatile ServiceRegistration audioFocusClientRegistration;
    private volatile ServiceRegistration mediaRouterListenerRegistration;
    private final GCopyOnWriteList<IAudioStateListener> audioContextListeners = Generics.newCopyOnWriteArrayList();
    private final AudioContext activeAudioContext;
    private boolean audioMgrReady;
    private static final int MAX_RETRIES_ON_ERROR = 3;
    private int errorRetriesCounter = 0;
    private final IContext context;
    private final Map activeRoutes;
    private final Object activeRoutesMutex = new Object();
    private final CopyOnWriteArrayList mediaRoutesChangeListener;
    private volatile AudioDrawerContext audioDrawerContext = null;
    private final ChoiceModelApp audioFocusModel;
    private volatile int lastAudioContext = -1;
    private final IAudioConnection dioAudioConnection;
    private final IAudioConnection galAudioConnection;
    private final IAudioConnection bclAudioConnection;
    private volatile IAudioConnection currentAudioConnection;
    private final Property<TMDevice> activeDevice;
    private final ActiveDeviceStateListener activeDeviceStateListener;
    private final AudioContextStateNotifier audioContextStateNotifier;
    private final IDispatcher dispatcher;
    private volatile ServiceRegistration audioServiceRegistration;
    private volatile Subscription volumeLockObserver;
    private final IServiceManager serviceManager;
    private final GMap<Integer, Property<AudioState>> audioConnections;
    private volatile Subscription tmMediaObserver;
    private boolean isDrawerContextSet;
    private boolean isTMMediaActive;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPMediaRouterService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService;

    public AudioManager(IContext iContext, IDispatcher iDispatcher, final IServiceManager iServiceManager) {
        this.context = iContext;
        this.logger = iContext.getLogger().audio();
        this.dispatcher = iDispatcher;
        this.serviceManager = iServiceManager;
        this.audioManagerPropertyFactory = LoggingPropertyFactory.create();
        this.audioFocusOnFront = this.audioManagerPropertyFactory.createProperty("AudioFocus");
        this.activeDevice = this.audioManagerPropertyFactory.createProperty("ActiveDevice");
        this.audioFocusOnFront.observe().redirectTo(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                AudioManager.this.notifyAudioFocusChanged(bl, AudioManager.this.audioContextListeners);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
        this.audioFocusManager = new NullAudioFocusManager(this.logger);
        this.mediaRoutesChangeListener = new CopyOnWriteArrayList();
        this.audioContextStateNotifier = new AudioContextStateNotifier();
        this.activeAudioContext = new AudioContext(this.audioContextStateNotifier, this.logger);
        this.activeRoutes = new HashMap();
        this.audioFocusModel = this.context.getChoiceModel(3200033);
        switch (this.context.getTerminalId()) {
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
        this.dioAudioConnection = new DIOAudioConnection();
        this.galAudioConnection = new GALAudioConnection();
        this.bclAudioConnection = new BCLAudioConnection();
        this.currentAudioConnection = this.dioAudioConnection;
        this.audioService = new NullHMIAudioService(this.logger);
        this.mediaRouterService = new NullMediaRouterService(this.logger);
        this.audioConnections = Generics.newHashMap();
        this.audioManagerServiceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AudioManager.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
                if (!HMIAudioService.CLIENT_MEDIA.equals(object2)) {
                    return;
                }
                AudioManager.this.logger.log(100000, "[%1.removedService] Audio service removed.", (Object)AudioManager.LOGCLASS);
                iServiceManager.releaseService(serviceReference);
                AudioManager.this.setAudioService(new NullHMIAudioService(AudioManager.this.logger));
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = serviceReference.getProperty("AUDIO_CLIENT_ID");
                if (!HMIAudioService.CLIENT_MEDIA.equals(object)) {
                    return null;
                }
                Object object2 = iServiceManager.getService(serviceReference);
                AudioManager.this.logger.log(100000000, "[%1.addingService] Audio service found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.setAudioService((HMIAudioService)object2);
                return object2;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.audioFocusManagerTracker = iServiceManager.createServiceTracker(class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = AudioManager.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.log(100000000, "[%1.addingService] Audio focus manager found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.audioFocusManager = (IAudioFocusManager)iServiceManager.getService(serviceReference);
                return AudioManager.this.audioFocusManager;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.log(100000, "[%1.removedService] Audio focus manager removed", (Object)AudioManager.LOGCLASS);
                AudioManager.this.audioFocusManager = new NullAudioFocusManager(AudioManager.this.logger);
                iServiceManager.releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.mediaRoutesServiceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$audio$ATIPMediaRouterService == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterService = AudioManager.class$("de.audi.atip.interapp.audio.ATIPMediaRouterService")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.log(100000, "[%1.removedService]", (Object)AudioManager.LOGCLASS);
                AudioManager.this.mediaRouterService = new NullMediaRouterService(AudioManager.this.logger);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.log(100000000, "[%1.addingService] Media router serrive found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.mediaRouterService = (ATIPMediaRouterService)iServiceManager.getService(serviceReference);
                return AudioManager.this.mediaRouterService;
            }
        });
        this.toneServiceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = AudioManager.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.log(100000, "[%1.removedService]", (Object)AudioManager.LOGCLASS);
                AudioManager.this.toneService = new NullToneService(AudioManager.this.logger);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.log(100000000, "[%1.addingService] tone service found.", (Object)AudioManager.LOGCLASS);
                AudioManager.this.toneService = (ToneService)iServiceManager.getService(serviceReference);
                return AudioManager.this.toneService;
            }
        });
        this.audioDrawerContextTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = AudioManager.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                AudioManager.this.logger.log(100000000, "[%1.addingService] Audio Drawer manager found. %2 ", (Object)AudioManager.LOGCLASS, (Object)serviceReference.toString());
                AudioManager.this.audioDrawerContext = (AudioDrawerContext)iServiceManager.getService(serviceReference);
                AudioManager.this.setDrawerContext();
                return AudioManager.this.audioDrawerContext;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                AudioManager.this.logger.log(100000, "[%1.addingService] Audio Drawer manager removed", (Object)AudioManager.LOGCLASS);
                AudioManager.this.audioDrawerContext = null;
                iServiceManager.releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.activeDeviceStateListener = new ActiveDeviceStateListener();
        this.audioConnections.put(new Integer(8), this.audioManagerPropertyFactory.createProperty("MUTE_ENT", AudioState.UNDEFINED));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.audioFocusOnFront.accept(new Boolean(false));
            this.audioMgrReady = false;
            this.isDrawerContextSet = false;
        }
        this.lastAudioContext = this.context.getFramework().getStorageMgr().getInt(1008, 2, 2);
        this.context.getChoiceModel(5536).setValue(this.mapAppId(this.lastAudioContext));
        this.context.getDeviceManager().addActiveDeviceListener(this.activeDeviceStateListener);
        this.audioManagerServiceTracker.open();
        this.audioFocusManagerTracker.open();
        this.mediaRoutesServiceTracker.open();
        this.toneServiceTracker.open();
        this.audioDrawerContextTracker.open();
        this.audioFocusClientRegistration = this.serviceManager.registerService(class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = AudioManager.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient, new AudioFocusClient(), new Hashtable(0));
        this.mediaRouterListenerRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener = AudioManager.class$("de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener, new MediaRouterServiceListener(), new Hashtable(0));
        object = new Hashtable(1);
        ((Hashtable)object).put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_MEDIA);
        HMIAudioServiceListenerImpl hMIAudioServiceListenerImpl = new HMIAudioServiceListenerImpl();
        this.audioServiceListenerRegistration = this.serviceManager.registerService(class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AudioManager.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener, new HMIAudioServiceListenerImpl(), (Dictionary)object);
        this.context.getDiagnosisManager().addCommandProvider(0, new DiagnosisCommandProvider(hMIAudioServiceListenerImpl));
        this.audioServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService = AudioManager.class$("de.audi.atip.interapp.terminalmode.ITerminalModeAudioService")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService, this, new Hashtable(0));
        this.context.getDiagnosisManager().addDataProvider(-1, new DiagnosisDataProvider());
        this.context.addActionProxyListener(1001, this);
        this.context.addActionProxyListener(1002, this);
        this.volumeLockObserver = Observables.combineLatest(this.activeAudioContext.getAudioObservableForAudioConnection(TMAudioConnection.MEDIA).observe(), this.activeAudioContext.getAudioObservableForAudioConnection(TMAudioConnection.SPEECH_INPUT).observe(), this.activeAudioContext.getAudioObservableForAudioConnection(TMAudioConnection.SPEECH_GUIDANCE).observe(), this.activeDevice.observe()).using(new Observables.Combinator4<AudioConnectionState, AudioConnectionState, AudioConnectionState, TMDevice, Boolean>(){

            @Override
            public Boolean combine(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2, AudioConnectionState audioConnectionState3, TMDevice tMDevice) {
                return new Boolean(audioConnectionState.isAtAMActive() && audioConnectionState2.isAtAMActive() && !audioConnectionState3.isAudible() && tMDevice.isAndroidAutoDevice());
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2, Object object3, Object object4) {
                return this.combine((AudioConnectionState)object, (AudioConnectionState)object2, (AudioConnectionState)object3, (TMDevice)object4);
            }
        }).distinctUntilChanged().redirectTo(new Consumer<Boolean>(){
            private volatile boolean volumeLock = false;

            @Override
            public void accept(Boolean bl) {
                if (bl.booleanValue() && !this.volumeLock) {
                    AudioManager.this.requestVolumelock(AudioManager.this.galAudioConnection.getAudioConnection(TMAudioConnection.MEDIA).get(), "micro on");
                    this.volumeLock = true;
                } else if (this.volumeLock) {
                    AudioManager.this.releaseVolumelock(AudioManager.this.galAudioConnection.getAudioConnection(TMAudioConnection.MEDIA).get(), "micro off");
                    this.volumeLock = false;
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
        this.tmMediaObserver = Observables.combineLatest(this.activeAudioContext.getAudioObservableForAudioConnection(TMAudioConnection.MEDIA), this.activeDevice).using(new Observables.Combinator<AudioConnectionState, TMDevice, Boolean>(){

            @Override
            public Boolean combine(AudioConnectionState audioConnectionState, TMDevice tMDevice) {
                AudioManager.this.isTMMediaActive = audioConnectionState.isAtAMActive();
                return new Boolean(AudioManager.this.isTMMediaActive && tMDevice != null && tMDevice.isActive());
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2) {
                return this.combine((AudioConnectionState)object, (TMDevice)object2);
            }
        }).subscribe(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                if (bl.booleanValue()) {
                    AudioManager.this.setDrawerContext();
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
    }

    private int mapAppId(int n) {
        if (n == 1) {
            return 0;
        }
        return 1;
    }

    @Override
    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.getDeviceManager().removeActiveDeviceListener(this.activeDeviceStateListener);
        this.volumeLockObserver.cancel();
        this.tmMediaObserver.cancel();
        this.context.removeActionProxyListener(this);
        if (null != this.audioFocusClientRegistration) {
            this.audioFocusClientRegistration.unregister();
        }
        if (null != this.audioServiceListenerRegistration) {
            this.audioServiceListenerRegistration.unregister();
        }
        if (null != this.mediaRouterListenerRegistration) {
            this.mediaRouterListenerRegistration.unregister();
        }
        if (null != this.audioServiceRegistration) {
            this.audioServiceRegistration.unregister();
        }
        this.audioManagerServiceTracker.close();
        this.audioFocusManagerTracker.close();
        this.mediaRoutesServiceTracker.close();
        this.toneServiceTracker.close();
    }

    @Override
    public void requestAudioFocus() {
        this.logger.log(1000000, "[%1.requestAudioFocus]", (Object)LOGCLASS);
        this.audioFocusManager.setActiveAudioApp(this.context.getTerminalId(), 48);
    }

    @Override
    public void releaseAudioFocus() {
        this.logger.log(1000000, "[%1.releaseAudioFocus] %2", (Object)LOGCLASS, (long)this.lastAudioContext);
        if (-1 != this.lastAudioContext) {
            this.audioFocusManager.setActiveAudioApp(this.context.getTerminalId(), this.lastAudioContext);
        }
    }

    @Override
    public void addMediaRouteChangeListener(IMediaRoutesChangeListener iMediaRoutesChangeListener) {
        if (null == iMediaRoutesChangeListener) {
            return;
        }
        if (!this.mediaRoutesChangeListener.addIfAbsent(iMediaRoutesChangeListener)) {
            this.logger.log(1000000, "[%1.addAudioContextListener] '%2' already added", (Object)LOGCLASS, (Object)iMediaRoutesChangeListener);
            return;
        }
        this.logger.log(1000000, "[%1.addAudioContextListener] '%2'", (Object)LOGCLASS, (Object)iMediaRoutesChangeListener);
    }

    @Override
    public void removeMediaRouteChangeListener(IMediaRoutesChangeListener iMediaRoutesChangeListener) {
        this.logger.log(1000000, "[%1.removeMediaRouteChangeListener]", (Object)LOGCLASS);
        this.mediaRoutesChangeListener.remove(iMediaRoutesChangeListener);
    }

    @Override
    public void requestMediaRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        this.logger.log(100000000, "[%1.requestMediaRoutes] %2", (Object)LOGCLASS, (Object)TerminalModeUtils.logMediaRoutes(aTIPAudioRouteArray));
        this.mediaRouterService.setAudioRoutes(aTIPAudioRouteArray);
    }

    private String getFocusStr(int n) {
        switch (n) {
            case 1: {
                return "FRONT";
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
            boolean bl = (Boolean)this.audioFocusOnFront.get();
            if (bl) {
                return 1;
            }
            return 0;
        }
    }

    @Override
    public boolean hasAudioFocus() {
        return this.getAudioFocus() != 0;
    }

    private void setAudioService(HMIAudioService hMIAudioService) {
        this.logger.log(1000000, "[%1.setAudioService] '%2'", (Object)LOGCLASS, (Object)hMIAudioService);
        this.audioService = hMIAudioService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private HMIAudioService getAudioService() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (!this.audioMgrReady) {
                this.logger.log(1000000, "[%1.getAudioService] Not ready to control.", (Object)LOGCLASS);
                return new NullHMIAudioService(this.logger);
            }
            return this.audioService;
        }
    }

    @Override
    public void addAudioContextListener(IAudioStateListener iAudioStateListener) {
        if (iAudioStateListener == null) {
            throw new IllegalArgumentException("Argument is null.");
        }
        boolean bl = this.audioContextListeners.addIfAbsent(iAudioStateListener);
        if (!bl) {
            this.logger.log(100000, "[%1.addAudioContextListener] '%2' already added", (Object)LOGCLASS, (Object)iAudioStateListener);
        }
        iAudioStateListener.audioFocusChanged((Boolean)this.audioFocusOnFront.get());
    }

    @Override
    public void removeAudioContextListener(IAudioStateListener iAudioStateListener) {
        this.logger.log(1000000, "[%1.removeAudioContextListener] '%2'.", (Object)LOGCLASS, (Object)iAudioStateListener);
        this.audioContextListeners.remove(iAudioStateListener);
    }

    private void notifyAudioFocusChanged(boolean bl, GList<IAudioStateListener> gList) {
        if (gList.isEmpty()) {
            return;
        }
        this.logger.log(1000000, "[%1.notifyAudioFocus] '%2'", (Object)LOGCLASS, (Object)bl);
        this.dispatcher.execute(new JobNotifyAudioFocus(this.logger, gList, bl));
    }

    @Override
    public void requestAudio(TMAudioConnection tMAudioConnection, boolean bl) {
        this.requestAudio(tMAudioConnection, bl, TMAudioConnection.MEDIA.is(tMAudioConnection));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void requestAudio(TMAudioConnection tMAudioConnection, boolean bl, boolean bl2) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            Optional<Integer> optional = this.currentAudioConnection.getAudioConnection(tMAudioConnection);
            if (!optional.exists()) {
                return;
            }
            int n = optional.get();
            this.activeAudioContext.setAudioConnectionState(new AudioConnectionState(n));
            if (bl && !this.hasAudioFocus()) {
                this.logger.log(1000000, "[%1.requestAudio] '%2' (no audio focus)", (Object)LOGCLASS, (long)n);
                return;
            }
            this.errorRetriesCounter = 0;
            boolean bl3 = !bl2 && this.isMuted();
            this.logger.log(10000000, "[%1.requestAudio] '%2', %3", (Object)LOGCLASS, (Object)Integer.toString(n), (Object)(bl3 ? "demute=false" : (this.isMuted() ? "demute=true" : "")));
            if (TMAudioConnection.MEDIA.is(tMAudioConnection)) {
                this.getAudioService().releaseA2LSConnection();
            }
            this.getAudioService().requestConnection(n, this.context.getTerminalId(), 0);
            if (bl3) {
                this.mute();
            } else if (this.isMuted()) {
                this.demute();
            }
        }
    }

    @Override
    public void requestAudio(TMAudioConnection tMAudioConnection, int n) {
        this.logger.log(1000000, "[%1.requestAudio] audioConn=%2 dur=%3", (Object)LOGCLASS, (Object)tMAudioConnection, (long)n);
        Optional<Integer> optional = this.currentAudioConnection.getAudioConnection(tMAudioConnection);
        if (!optional.exists()) {
            return;
        }
        int n2 = optional.get();
        this.activeAudioContext.setAudioConnectionState(new AudioConnectionState(n2));
        this.toneService.setDuration(n2, n);
        this.getAudioService().requestConnection(n2, this.context.getTerminalId(), 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void fadeTo(AudioConnectionState audioConnectionState) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (audioConnectionState.getState().isNot(AudioState.STARTED)) {
                this.logger.log(1000000, "[%1.fadeTo] Not STARTED, ignore.", (Object)LOGCLASS);
                return;
            }
            int n = audioConnectionState.getConnection();
            if (n == 9 || n == 153 || n == 159 || n == 100 || n == 163 || n == 164) {
                this.logger.log(1000000, "[%1.fadeTo] Ignore", (Object)LOGCLASS);
                return;
            }
            this.logger.log(100000000, "[%1.fadeTo] '%2'", (Object)LOGCLASS, (long)n);
            this.getAudioService().fadeToConnection(n, this.context.getTerminalId());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void restoreCurrentEntertainmentContext(boolean bl) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            if (this.getAudioFocus() != 1) {
                this.logger.log(1000000, "[%1.restoreCurrentEntertainmentContext] No audio focus at front.", (Object)LOGCLASS);
                return;
            }
            if (!this.audioMgrReady) {
                this.logger.log(1000000, "[%1.restoreCurrentEntertainmentContext] Not ready to control", (Object)LOGCLASS);
                return;
            }
            this.errorRetriesCounter = 0;
            int n = this.currentAudioConnection.getAudioConnection(TMAudioConnection.MEDIA).get();
            int n2 = 9;
            GIterator<AudioConnectionState> gIterator = this.activeAudioContext.getActiveAudioConnections().iterator();
            while (gIterator.hasNext()) {
                AudioConnectionState audioConnectionState = gIterator.next();
                if (n != audioConnectionState.getConnection()) continue;
                n2 = audioConnectionState.getConnection();
                break;
            }
            if (bl) {
                this.resumeAudio(false);
            }
            if (9 != n2) {
                this.logger.log(1000000, "[%1.restoreCurrentEntertainmentContext] '%2'", (Object)LOGCLASS, (long)n2);
                this.getAudioService().requestConnection(n2, this.context.getTerminalId(), 0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void restoreCurrentAudioContext() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            IFluentCollection.PartitionResult<AudioConnectionState> partitionResult = this.activeAudioContext.getActiveAudioConnections().fluent().filter(new Predicate<AudioConnectionState>(){

                @Override
                public boolean apply(AudioConnectionState audioConnectionState) {
                    return AudioManager.this.activeAudioContext.isActiveAudioConnection(audioConnectionState.getConnection());
                }

                @Override
                public /* synthetic */ boolean apply(Object object) {
                    return this.apply((AudioConnectionState)object);
                }
            }).partition(new Predicate<AudioConnectionState>(){

                @Override
                public boolean apply(AudioConnectionState audioConnectionState) {
                    return audioConnectionState.getTMConnection().is(TMAudioConnection.MEDIA);
                }

                @Override
                public /* synthetic */ boolean apply(Object object) {
                    return this.apply((AudioConnectionState)object);
                }
            });
            this.logger.log(1000000, "[%1.restoreCurrentAudioContext] Restoring requested audio connections:%2", (Object)LOGCLASS, partitionResult.rejected());
            GIterator<AudioConnectionState> gIterator = partitionResult.rejected().iterator();
            while (gIterator.hasNext()) {
                this.getAudioService().requestConnection(gIterator.next().getConnection(), 0, 0);
            }
            if (this.getAudioFocus() == 1) {
                partitionResult.applied().fluent().first().ifExists(new Consumer<AudioConnectionState>(){

                    @Override
                    public void accept(AudioConnectionState audioConnectionState) {
                        AudioManager.this.logger.log(1000000, "[%1.restoreCurrentAudioContext] Restoring requested media connection:%2", (Object)AudioManager.LOGCLASS, (Object)audioConnectionState);
                        AudioManager.this.getAudioService().requestConnection(audioConnectionState.getConnection(), 0, 0);
                    }

                    @Override
                    public /* synthetic */ void accept(Object object) {
                        this.accept((AudioConnectionState)object);
                    }
                });
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releaseAudio(TMAudioConnection tMAudioConnection) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            Optional<Integer> optional = this.currentAudioConnection.getAudioConnection(tMAudioConnection);
            if (!optional.exists()) {
                this.logger.log(1000000, "[%1.releaseAudio] Not a valid connection. NOP.", (Object)LOGCLASS, (Object)tMAudioConnection.toString());
                return;
            }
            int n = optional.get();
            this.logger.log(100000000, "[%1.releaseAudio] '%2'", (Object)LOGCLASS, (long)n);
            this.activeAudioContext.setAudioConnectionState(new AudioConnectionState(n, AudioState.RELEASED));
            this.getAudioService().releaseConnection(n, this.context.getTerminalId());
        }
    }

    @Override
    public void mute() {
        this.logger.log(1000000, "[%1.mute] Mute (conn='%2')", (Object)LOGCLASS, (long)this.CONN_MUTE);
        this.errorRetriesCounter = 0;
        this.getAudioService().requestConnection(this.CONN_MUTE, this.context.getTerminalId(), 0);
    }

    private void demute() {
        this.logger.log(1000000, "[%1.demute] Demute (conn='%2')", (Object)LOGCLASS, (long)this.CONN_MUTE);
        this.getAudioService().releaseConnection(this.CONN_MUTE, this.context.getTerminalId());
    }

    @Override
    public void muteIncomingCarPlayRingtone() {
        if (this.activeAudioContext.isActiveAudioConnection(95)) {
            this.logger.log(1000000, "<<- [%1.muteIncomingCarPlayRingtone]", (Object)LOGCLASS);
            this.releaseAudio(TMAudioConnection.RINGTONE);
        }
    }

    @Override
    public boolean resumeAudio(boolean bl) {
        if (bl && !this.hasAudioFocus()) {
            this.logger.log(1000000, "[%1.resumeAudio] No audio focus", (Object)LOGCLASS);
            return false;
        }
        this.logger.log(1000000, "[%1.resumeAudio]", (Object)LOGCLASS);
        this.getAudioService().releaseA2LSConnection();
        if (this.isAudioAudible()) {
            return true;
        }
        boolean bl2 = false;
        if (this.isMuted()) {
            this.demute();
            bl2 = true;
        }
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isAudioAudible() {
        Object object = this.audioContextMutex;
        synchronized (object) {
            return this.activeAudioContext.isAudible();
        }
    }

    @Override
    public boolean isStandbyMuted() {
        return this.getAudioService().getStatus(this.CONN_STANDBY, this.context.getTerminalId()) != 5;
    }

    private boolean isMuted() {
        return this.getAudioService().getStatus(this.CONN_MUTE, this.context.getTerminalId()) != 5;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestVolumelock(int n, String string) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.requestVolumelock] '%2'", (Object)LOGCLASS, (long)n);
            this.getAudioService().setVolumelock(n, this.context.getTerminalId(), true, string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseVolumelock(int n, String string) {
        Object object = this.audioContextMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.releaseVolumelock] '%2'", (Object)LOGCLASS, (long)n);
            this.getAudioService().setVolumelock(n, this.context.getTerminalId(), false, string);
        }
    }

    @Override
    public ObservableProperty<Boolean> getAudioFocusObservable() {
        return this.audioFocusOnFront;
    }

    @Override
    public ObservableProperty<AudioConnectionState> getAudioObservableForAudioConnection(TMAudioConnection tMAudioConnection) {
        return this.activeAudioContext.getAudioObservableForAudioConnection(tMAudioConnection);
    }

    @Override
    public ReadOnlyProperty<AudioState> getAudioObservableForAudioConnection(int n) {
        return this.audioConnections.get(new Integer(n));
    }

    @Override
    public Command createAudioConnectionRequest(TMAudioConnection tMAudioConnection, boolean bl) {
        if (((TMDevice)this.activeDevice.get()).isAndroidAutoDevice()) {
            if (TMAudioConnection.SPEECH.is(tMAudioConnection)) {
                return new Command(this.logger, "RequestAudioConnection(not applicable)"){

                    public void execute() {
                        this.getCommandList().commandFinished();
                    }
                };
            }
            return new RequestAudioConnection(tMAudioConnection, this.context, bl, 350);
        }
        if (TMAudioConnection.ANNOUNCEMENT.is(tMAudioConnection)) {
            return new RequestAudioConnectionWithoutSync(tMAudioConnection, this.context, bl);
        }
        return new RequestAudioConnection(tMAudioConnection, this.context, bl, 10000);
    }

    @Override
    public IAudioConnectionHandle createAudioConnectionHandle(TMAudioConnection tMAudioConnection) {
        return new AudioConnectionHandle(tMAudioConnection);
    }

    private void setDrawerContext() {
        if (this.audioDrawerContext == null) {
            this.logger.log(1000000, "%1.setDrawerContext no drawer context available ", (Object)LOGCLASS);
            return;
        }
        TMDevice tMDevice = (TMDevice)this.activeDevice.get();
        if (this.hasAudioFocus() && tMDevice != null && tMDevice.isActive() && this.isTMMediaActive) {
            if (!this.isDrawerContextSet) {
                this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_TERMINAL_MODE, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
                this.isDrawerContextSet = true;
                this.logger.log(1000000, "%1.setDrawerContext active ", (Object)LOGCLASS);
            } else {
                this.logger.log(1000000, "%1.setDrawerContext already active ", (Object)LOGCLASS);
            }
        } else {
            this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_TERMINAL_MODE, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
            this.isDrawerContextSet = false;
            this.logger.log(1000000, "%1.setDrawerContext inactive", (Object)LOGCLASS);
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (this.audioDrawerContext == null) {
            this.logger.log(1000000, "%1.setDrawerContext no drawer context available ", (Object)LOGCLASS);
            return;
        }
        switch (n) {
            case 1001: {
                this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_TERMINAL_MODE_PHONE, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
                this.logger.log(1000000, "%1.actionProxyCallPerformed high prio drawer active ", (Object)LOGCLASS);
                break;
            }
            case 1002: {
                this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_TERMINAL_MODE_PHONE, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                this.logger.log(1000000, "%1.actionProxyCallPerformed high prio drawer inactive ", (Object)LOGCLASS);
                break;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ATIPAudioRoute[] filterAudioRouteChanges(ATIPAudioRoute[] aTIPAudioRouteArray) {
        this.logger.log(100000000, "[%1.filterAudioRouteChanges]", (Object)LOGCLASS);
        ArrayList arrayList = new ArrayList(aTIPAudioRouteArray.length);
        Object object = this.activeRoutesMutex;
        synchronized (object) {
            for (int i2 = 0; i2 < aTIPAudioRouteArray.length; ++i2) {
                ATIPAudioRoute aTIPAudioRoute = (ATIPAudioRoute)this.activeRoutes.get(Util.createInteger(aTIPAudioRouteArray[i2].getRoutingOutput()));
                if (null != aTIPAudioRoute && aTIPAudioRoute.equals(aTIPAudioRouteArray[i2])) continue;
                arrayList.add(aTIPAudioRouteArray[i2]);
            }
        }
        return (ATIPAudioRoute[])arrayList.toArray(new ATIPAudioRoute[arrayList.size()]);
    }

    @Override
    public boolean isAudioServiceAvailable() {
        return this.audioMgrReady;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class AudioFocusClient
    implements IAudioFocusClient {
        private static final String LOGCLASS = "AudioManager.AudioFocusClient";

        private AudioFocusClient() {
        }

        public void updateAudioFocus(final int n, final int n2) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.AudioFocusClient.updateAudioFocus"){

                public void run() {
                    boolean bl;
                    if (0 != n) {
                        AudioManager.this.logger.log(1000000, "<- [%1.updateAudioFocus] '%3' (terminalID='%2') Ignore.", (Object)AudioFocusClient.LOGCLASS, (long)n, (long)n2);
                        return;
                    }
                    boolean bl2 = bl = n2 == 43 || n2 == 48;
                    if (AudioManager.this.logger.isInfo()) {
                        AudioManager.this.logger.log(1000000, "<- [%1.updateAudioFocus] '%3' (terminalID='%2')", (Object)AudioFocusClient.LOGCLASS, (Object)new Integer(n), (Object)(bl ? "TERMINALMODE" : "OTHER"));
                    }
                    if (!bl) {
                        AudioManager.this.logger.log(100000000, "<- [%1.updateAudioFocus] switch off App=%2", (Object)AudioFocusClient.LOGCLASS, (long)n2);
                        AudioManager.this.audioFocusModel.setValue(n2);
                        AudioManager.this.lastAudioContext = n2;
                        AudioManager.this.context.getChoiceModel(5536).setValue(AudioManager.this.mapAppId(AudioManager.this.lastAudioContext));
                        AudioManager.this.context.getFramework().getStorageMgr().setInt(1008, 2, AudioManager.this.lastAudioContext);
                    } else {
                        AudioManager.this.logger.log(100000000, "<- [%1.updateAudioFocus] switch off App=Media", (Object)AudioFocusClient.LOGCLASS);
                        AudioManager.this.audioFocusModel.setValue(2);
                    }
                    AudioFocusClient.this.setAudioFocus(n, bl, true);
                }
            });
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void setAudioFocus(int n, boolean bl, boolean bl2) {
            Object object = AudioManager.this.audioContextMutex;
            synchronized (object) {
                AudioManager.this.logger.log(10000000, "[%2.setAudioFocus] '%1' (terminal='%3')", bl, (Object)LOGCLASS, (Object)new Integer(n));
                int n2 = AudioManager.this.getAudioFocus();
                AudioManager.this.audioFocusOnFront.accept(new Boolean(bl));
                int n3 = AudioManager.this.getAudioFocus();
                if (n2 == n3) {
                    AudioManager.this.logger.log(10000000, "[%1.setAudioFocus] Not changed. Ignore.", (Object)LOGCLASS);
                    return;
                }
                AudioManager.this.logger.log(10000000, "[%1.setAudioFocus] '%2'", (Object)LOGCLASS, (Object)AudioManager.this.getFocusStr(n3));
                AudioManager.this.setDrawerContext();
                if (n3 == 1) {
                    AudioManager.this.restoreCurrentEntertainmentContext(bl2);
                }
            }
        }
    }

    private final class AudioConnectionHandle
    implements IAudioConnectionHandle {
        private final TMAudioConnection audioConnection;

        private AudioConnectionHandle(TMAudioConnection tMAudioConnection) {
            this.audioConnection = tMAudioConnection;
        }

        public Command createRequestCommand(boolean bl) {
            return AudioManager.this.createAudioConnectionRequest(this.audioConnection, bl);
        }

        public Command createReleaseCommand() {
            return new ReleaseAudioConnection(this.audioConnection, AudioManager.this.context);
        }

        public void registerListener(IAudioConnectionHandle.IAudioConnectionListener iAudioConnectionListener) {
            AudioManager.this.addAudioContextListener(new AudioConnectionListenerAdapter(iAudioConnectionListener, this.audioConnection, AudioManager.this));
        }

        public void unregisterListener(IAudioConnectionHandle.IAudioConnectionListener iAudioConnectionListener) {
            AudioManager.this.removeAudioContextListener(new AudioConnectionListenerAdapter(iAudioConnectionListener, this.audioConnection, AudioManager.this));
        }
    }

    private final class DiagnosisDataProvider
    implements IDiagnosisDataProvider {
        private DiagnosisDataProvider() {
        }

        public String getDiagKey() {
            return "getActiveAudioConnections";
        }

        public String getDiagValue() {
            return AudioManager.this.activeAudioContext.toString();
        }
    }

    private final class DiagnosisCommandProvider
    implements IDiagnosisCommandProvider {
        private final String PAUSE_AC;
        private final String START_AC;
        private final HMIAudioServiceListener hmiAudioServiceListener;

        public DiagnosisCommandProvider(HMIAudioServiceListener hMIAudioServiceListener) {
            this.PAUSE_AC = "pauseConnection(AC)";
            this.START_AC = "startConnection(AC)";
            this.hmiAudioServiceListener = hMIAudioServiceListener;
        }

        public String[] getDiagKeys() {
            return new String[]{"pauseConnection(AC)", "startConnection(AC)"};
        }

        public void executeDiagCommand(String string, String[] stringArray) {
            if ("pauseConnection(AC)".equals(string)) {
                this.hmiAudioServiceListener.pauseConnection(Integer.parseInt(stringArray[0]), 0);
            } else if ("startConnection(AC)".equals(string)) {
                this.hmiAudioServiceListener.startConnection(Integer.parseInt(stringArray[0]), 0);
            }
        }
    }

    private final class ActiveDeviceStateListener
    implements IActiveDeviceStateListener {
        private static final String LOGCLASS = "AudioManager.ActiveDeviceStateListener";

        private ActiveDeviceStateListener() {
        }

        public void updateActiveDeviceState(TMDevice tMDevice) {
            AudioManager.this.activeDevice.accept(tMDevice);
            if (tMDevice.isActive()) {
                AudioManager.this.logger.log(100000000, "[%1.updateActiveDeviceState] %2", (Object)LOGCLASS, (Object)(tMDevice.isCarplayDevice() ? "will use CarPlay connections" : "will use AndroidAuto connections"));
                if (tMDevice.isCarplayDevice()) {
                    AudioManager.this.currentAudioConnection = AudioManager.this.dioAudioConnection;
                } else if (tMDevice.isAndroidAutoDevice()) {
                    AudioManager.this.currentAudioConnection = AudioManager.this.galAudioConnection;
                } else if (tMDevice.smartphoneType().is(SmartphoneManager.SmartphoneType.CARLIFE)) {
                    AudioManager.this.currentAudioConnection = AudioManager.this.bclAudioConnection;
                }
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private final class AudioContextStateNotifier
    implements IAudioContextStateNotifier {
        private AudioContextStateNotifier() {
        }

        @Override
        public void notifyAudioStateChanged(AudioConnectionState audioConnectionState) {
            this.notifyAudioStateChanged(audioConnectionState, AudioManager.this.audioContextListeners);
        }

        private void notifyAudioStateChanged(AudioConnectionState audioConnectionState, GList<IAudioStateListener> gList) {
            AudioManager.this.dispatcher.execute(new JobNotifyAudioState(AudioManager.this.logger, gList, audioConnectionState));
        }
    }

    private final class MediaRouterServiceListener
    implements ATIPMediaRouterServiceListener {
        private static final String LOGCLASS = "AudioManager.MediaRouterServiceListener";

        private MediaRouterServiceListener() {
        }

        public void updateActiveAudioRoutes(final ATIPAudioRoute[] aTIPAudioRouteArray) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.updateActiveAudioRoutes"){

                public void run() {
                    AudioManager.this.logger.log(1000000, "<- [%1.updateActiveAudioRoutes] %2", (Object)MediaRouterServiceListener.LOGCLASS, (Object)Arrays2.toString(aTIPAudioRouteArray));
                    MediaRouterServiceListener.this.setMediaRoutes(aTIPAudioRouteArray);
                }
            });
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void setMediaRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
            AudioManager.this.logger.log(1000000, "[%1.setMediaRoutes] %2", (Object)LOGCLASS, (Object)Arrays2.toString(aTIPAudioRouteArray));
            Object object = AudioManager.this.activeRoutesMutex;
            synchronized (object) {
                for (int i2 = 0; i2 < aTIPAudioRouteArray.length; ++i2) {
                    if (26 == aTIPAudioRouteArray[i2].getRoutingInput()) continue;
                    AudioManager.this.activeRoutes.put(Util.createInteger(aTIPAudioRouteArray[i2].getRoutingOutput()), aTIPAudioRouteArray[i2]);
                }
            }
            this.notifyMediaRoutesChanged();
        }

        private void notifyMediaRoutesChanged() {
            AudioManager.this.logger.log(1000000, "[%1.notifyMediaRoutesChanged]", (Object)LOGCLASS);
            Iterator iterator = AudioManager.this.mediaRoutesChangeListener.iterator();
            while (iterator.hasNext()) {
                try {
                    ((IMediaRoutesChangeListener)iterator.next()).mediaRoutesChanged();
                }
                catch (Exception exception) {
                    AudioManager.this.logger.log(10000, "[%1.notifyMediaRoutesChanged]", (Object)LOGCLASS, (Throwable)exception);
                }
            }
        }
    }

    private final class HMIAudioServiceListenerImpl
    implements HMIAudioServiceListener {
        private static final String LOGCLASS = "AudioManager.HMIAudioServiceListenerImpl";

        private HMIAudioServiceListenerImpl() {
        }

        public void updateAMAvailable(final boolean bl) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.HMIAudioServiceListenerImpl.updateAMAvailable"){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void run() {
                    Object object = AudioManager.this.audioContextMutex;
                    synchronized (object) {
                        AudioManager.this.logger.log(1000000, "<- [%1.updateAMAvailable] '%2'", (Object)HMIAudioServiceListenerImpl.LOGCLASS, (Object)(bl ? "AVAILABLE" : "NOT AVAILABLE"));
                        AudioManager.this.audioMgrReady = bl;
                        if (AudioManager.this.audioMgrReady) {
                            AudioManager.this.errorRetriesCounter = 0;
                            AudioManager.this.restoreCurrentAudioContext();
                        }
                    }
                }
            });
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private boolean changeAudioContextState(String string, int n, int n2, AudioState audioState) {
            if (n2 != AudioManager.this.context.getTerminalId()) {
                return false;
            }
            Object object = AudioManager.this.audioContextMutex;
            synchronized (object) {
                AudioManager.this.logger.log(1000000, "<- [%1.%2] '%3'", (Object)LOGCLASS, (Object)string, (long)n);
                AudioConnectionState audioConnectionState = new AudioConnectionState(n, audioState);
                if (audioState.is((T[])new AudioState[]{AudioState.STARTED, AudioState.STOPPED})) {
                    if (n == 95 && AudioManager.this.activeAudioContext.getAudioConnectionState(162) != null && AudioManager.this.activeAudioContext.getAudioConnectionState(162).getState().is(AudioState.STARTED) && audioState.is(AudioState.STOPPED)) {
                        AudioManager.this.logger.log(1000000, "<- [%1.stopConnection] ignore stoping of PHONE_MP3_RINGING because of IOS_MEDIA was staretd before.", (Object)LOGCLASS);
                    } else {
                        ATIPAudioRoute[] aTIPAudioRouteArray = AudioManager.this.filterAudioRouteChanges(AudioManager.this.currentAudioConnection.getAudioRoutes(audioConnectionState));
                        if (aTIPAudioRouteArray.length > 0) {
                            this.notifyMediaRoutesChanging();
                            AudioManager.this.requestMediaRoutes(aTIPAudioRouteArray);
                        } else if (162 == n && audioState.is(AudioState.STARTED) && AudioManager.this.activeAudioContext.getAudioConnectionState(162) != null && AudioManager.this.activeAudioContext.getAudioConnectionState(162).getState().is(AudioState.PAUSED) && ((AudioConnectionState)AudioManager.this.activeAudioContext.getAudioObservableForAudioConnection(TMAudioConnection.RINGTONE).get()).getState().is(AudioState.STOPPED)) {
                            ATIPAudioRoute[] aTIPAudioRouteArray2 = AudioManager.this.currentAudioConnection.getAudioRoutes(audioConnectionState);
                            AudioManager.this.logger.log(1000000, "[%1.changeAudioContextState] special routes:%2", (Object)LOGCLASS, (Object)TerminalModeUtils.logMediaRoutes(aTIPAudioRouteArray2));
                            AudioManager.this.requestMediaRoutes(aTIPAudioRouteArray2);
                        }
                    }
                }
                if (audioState.is(AudioState.STOPPED) && AudioManager.this.activeAudioContext.getState(n).isNot(AudioState.UNDEFINED)) {
                    AudioManager.this.activeAudioContext.releaseConnection(n);
                }
                AudioManager.this.activeAudioContext.setAudioConnectionState(audioConnectionState);
                return true;
            }
        }

        private void notifyMediaRoutesChanging() {
            AudioManager.this.logger.log(1000000, "[%1.notifyMediaRoutesChanging]", (Object)LOGCLASS);
            Iterator iterator = AudioManager.this.mediaRoutesChangeListener.iterator();
            while (iterator.hasNext()) {
                try {
                    ((IMediaRoutesChangeListener)iterator.next()).mediaRoutesChanging();
                }
                catch (Exception exception) {
                    AudioManager.this.logger.log(10000, "[%1.notifyMediaRoutesChanging]", (Object)LOGCLASS, (Throwable)exception);
                }
            }
        }

        public void stopConnection(final int n, final int n2) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.HMIAudioServiceListenerImpl.stopConnection"){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void run() {
                    AudioManager.this.logger.log(1000000, "<- [%1.stopConnection] %2", (Object)HMIAudioServiceListenerImpl.LOGCLASS, (long)n);
                    if (AudioManager.this.audioConnections.containsKey(new Integer(n))) {
                        ((Property)AudioManager.this.audioConnections.get(new Integer(n))).accept(AudioState.STOPPED);
                    }
                    Object object = AudioManager.this.audioContextMutex;
                    synchronized (object) {
                        if (null == AudioManager.this.activeAudioContext.getAudioConnectionState(n)) {
                            return;
                        }
                        HMIAudioServiceListenerImpl.this.changeAudioContextState("stopConnection", n, n2, AudioState.STOPPED);
                    }
                }
            });
        }

        public void pauseConnection(final int n, final int n2) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.HMIAudioServiceListenerImpl.pauseConnection"){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void run() {
                    if (AudioManager.this.audioConnections.containsKey(new Integer(n))) {
                        ((Property)AudioManager.this.audioConnections.get(new Integer(n))).accept(AudioState.PAUSED);
                    }
                    Object object = AudioManager.this.audioContextMutex;
                    synchronized (object) {
                        if (!AudioManager.this.activeAudioContext.isActiveAudioConnection(n)) {
                            return;
                        }
                        AudioManager.this.logger.log(1000000, "<- [%1.pauseConnection] %2", (Object)HMIAudioServiceListenerImpl.LOGCLASS, (long)n);
                        HMIAudioServiceListenerImpl.this.changeAudioContextState("pauseConnection", n, n2, AudioState.PAUSED);
                    }
                }
            });
        }

        public void startConnection(final int n, final int n2) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.HMIAudioServiceListenerImpl.startConnection"){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void run() {
                    if (AudioManager.this.audioConnections.containsKey(new Integer(n))) {
                        ((Property)AudioManager.this.audioConnections.get(new Integer(n))).accept(AudioState.STARTED);
                    }
                    Object object = AudioManager.this.audioContextMutex;
                    synchronized (object) {
                        if (!AudioManager.this.activeAudioContext.isActiveAudioConnection(n)) {
                            return;
                        }
                        AudioManager.this.logger.log(1000000, "<- [%1.startConnection] %2", (Object)HMIAudioServiceListenerImpl.LOGCLASS, (long)n);
                        if (AudioManager.this.activeAudioContext.getState(n).is(AudioState.RELEASED)) {
                            return;
                        }
                        HMIAudioServiceListenerImpl.this.changeAudioContextState("startConnection", n, n2, AudioState.STARTED);
                        AudioConnectionState audioConnectionState = AudioManager.this.activeAudioContext.getAudioConnectionState(n);
                        AudioManager.this.fadeTo(audioConnectionState);
                    }
                }
            });
        }

        public void errorConnection(final int n, final int n2, int n3) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.HMIAudioServiceListenerImpl.errorConnection"){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void run() {
                    if (AudioManager.this.audioConnections.containsKey(new Integer(n))) {
                        ((Property)AudioManager.this.audioConnections.get(new Integer(n))).accept(AudioState.ERROR);
                    }
                    Object object = AudioManager.this.audioContextMutex;
                    synchronized (object) {
                        if (!AudioManager.this.activeAudioContext.isActiveAudioConnection(n)) {
                            return;
                        }
                        if (HMIAudioServiceListenerImpl.this.changeAudioContextState("errorConnection", n, n2, AudioState.ERROR)) {
                            if (!AudioManager.this.hasAudioFocus()) {
                                return;
                            }
                            if (3 >= AudioManager.this.errorRetriesCounter) {
                                AudioManager.this.logger.log(1000000, "<- [%1.errorConnection] Max retries reached.", (Object)HMIAudioServiceListenerImpl.LOGCLASS);
                                return;
                            }
                            AudioManager.this.logger.log(1000000, "<- [%1.errorConnection] Request connection again", (Object)HMIAudioServiceListenerImpl.LOGCLASS);
                            AudioManager.this.errorRetriesCounter++;
                            AudioManager.this.getAudioService().requestConnection(n, AudioManager.this.context.getTerminalId(), 0);
                        }
                    }
                }
            });
        }

        public void fadedIn(final int n, final int n2) {
            AudioManager.this.dispatcher.execute(new AbstractDispatcherRunnable("AudioManager.HMIAudioServiceListenerImpl.updateAMAvailable"){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public void run() {
                    if (AudioManager.this.audioConnections.containsKey(new Integer(n))) {
                        ((Property)AudioManager.this.audioConnections.get(new Integer(n))).accept(AudioState.FADEDIN);
                    }
                    Object object = AudioManager.this.audioContextMutex;
                    synchronized (object) {
                        if (!AudioManager.this.activeAudioContext.isActiveAudioConnection(n)) {
                            return;
                        }
                        HMIAudioServiceListenerImpl.this.changeAudioContextState("fadedIn", n, n2, AudioState.FADEDIN);
                    }
                }
            });
        }

        public void updateVolumeLock(int n, int n2, boolean bl) {
        }
    }

    private static class AudioConnectionListenerAdapter
    implements IAudioStateListener {
        private final IAudioConnectionHandle.IAudioConnectionListener audioConnectionListener;
        private final TMAudioConnection audioConnection;
        private final int androidAutoAudioManagementConnection;
        private final int carplayAudioManagementConnection;
        private final int carlifeAudioManagementConnection;
        private AudioState lastState = AudioState.UNDEFINED;
        private final AudioManager audioManager;

        public AudioConnectionListenerAdapter(IAudioConnectionHandle.IAudioConnectionListener iAudioConnectionListener, TMAudioConnection tMAudioConnection, AudioManager audioManager) {
            this.audioConnectionListener = iAudioConnectionListener;
            this.audioConnection = tMAudioConnection;
            this.androidAutoAudioManagementConnection = GALAudioConnection.getAndroidAutoAudioConnection(tMAudioConnection).get();
            this.carplayAudioManagementConnection = DIOAudioConnection.getCarplayAudioConnection(tMAudioConnection).get();
            this.carlifeAudioManagementConnection = BCLAudioConnection.getBaiduAudioConnection(tMAudioConnection).get();
            this.audioManager = audioManager;
        }

        public void audioStateChanged(AudioConnectionState audioConnectionState) {
            int n = audioConnectionState.getConnection();
            if (n == this.androidAutoAudioManagementConnection || n == this.carplayAudioManagementConnection || n == this.carlifeAudioManagementConnection) {
                if (audioConnectionState.getState().is(AudioState.STARTED)) {
                    if (this.lastState.is((T[])new AudioState[]{AudioState.ERROR, AudioState.PAUSED})) {
                        this.audioConnectionListener.onResume();
                    } else {
                        this.audioConnectionListener.onStart();
                    }
                } else if (audioConnectionState.getState().is(AudioState.PAUSED)) {
                    int n2 = this.audioManager.audioService.getStatus(8);
                    if (3 == n2 || 2 == n2 || 6 == n2) {
                        this.audioConnectionListener.onPauseByMute();
                    } else {
                        this.audioConnectionListener.onPause();
                    }
                } else if (audioConnectionState.getState().is(AudioState.STOPPED)) {
                    this.audioConnectionListener.onStopped();
                } else if (audioConnectionState.getState().is(AudioState.FADEDIN)) {
                    this.audioConnectionListener.onFadedIn();
                } else if (audioConnectionState.getState().is(AudioState.ERROR)) {
                    this.audioConnectionListener.onError();
                }
                this.lastState = audioConnectionState.getState();
            }
        }

        public void audioFocusChanged(boolean bl) {
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + (this.audioConnection == null ? 0 : this.audioConnection.hashCode());
            n = 31 * n + (this.audioConnectionListener == null ? 0 : this.audioConnectionListener.hashCode());
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            AudioConnectionListenerAdapter audioConnectionListenerAdapter = (AudioConnectionListenerAdapter)object;
            if (this.audioConnection == null ? audioConnectionListenerAdapter.audioConnection != null : !this.audioConnection.equals(audioConnectionListenerAdapter.audioConnection)) {
                return false;
            }
            return !(this.audioConnectionListener == null ? audioConnectionListenerAdapter.audioConnectionListener != null : !this.audioConnectionListener.equals(audioConnectionListenerAdapter.audioConnectionListener));
        }
    }
}

