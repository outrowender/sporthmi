/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.init;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.audio.AudioEnv;
import de.audi.audio.init.ATIPAudioManager;
import de.audi.audio.init.pcsim.DSIAudioSpeechPCSim;
import de.audi.audio.init.pcsim.DSISoundSpeechPCSim;
import de.audi.audio.services.VolumeLockService;
import de.audi.audio.services.VolumeMapService;
import de.audi.audio.volume.OnOffVolumeRange$RangeListenerImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.media.DSIMediaRouter;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AudioActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    public ATIPAudioManager audioManager;
    private volatile DSIAudioManagement dsiAudio;
    private volatile DSISound dsiSound;
    private volatile DSIMediaRouter dsiMediaRouter;
    private volatile boolean initDone = false;
    private AudioEnv env;
    private ILastmodeHandler lastModeHandler;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusManager;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSEListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSE;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouter;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPMediaRouterService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$SDISRangeListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IVolumeLockService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IVolumeMapService;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerService;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceAudio;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$TIJPVolumeServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelMuteMicService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$VolumeOnOffPressListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.env = new AudioEnv(this.framework);
        this.env.lcMain.log(-2137614336, "[AudioActivator.start]");
        this.audioManager = new ATIPAudioManager(this.env);
        this.lastModeHandler = this.framework.getLastmodeHandler();
        this.lastModeHandler.initAudioFocusManagement();
        this.registerAndTrackBaseServices();
        if (this.framework.isSimulator()) {
            if (Boolean.getBoolean("hmi.audio.simulation")) {
                try {
                    BundleActivator bundleActivator = (BundleActivator)Class.forName("de.audi.audio.sim.AudioSimActivator").newInstance();
                    bundleActivator.start(bundleContext);
                }
                catch (Exception exception) {
                    this.env.lcMain.log(1078071040, "de.audi.audio.sim.AudioSimActivator not found!");
                    this.initBaseServices();
                }
            } else if (Boolean.getBoolean("hmi.speech.audio.simulation")) {
                this.env.lcMain.log(1078071040, "de.audi.audio.sim.AudioSimActivator not found!");
                this.dsiAudio = new DSIAudioSpeechPCSim(this.env.lcDSI);
                this.dsiSound = new DSISoundSpeechPCSim();
                this.initBaseServices();
            }
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        Object object2 = serviceReference.getProperty("objectClass");
        this.env.lcMain.log(-2137614336, "[AudioActivator.addingService] %1 -> %2", object2, object);
        if (object instanceof IAudioFocusClient) {
            this.lastModeHandler.registerAudioClient((IAudioFocusClient)object);
            return object;
        }
        if (object instanceof DSIAudioManagement) {
            this.env.logStartupEvent("[AUDIO] DSIAudioManagement registered");
            this.dsiAudio = (DSIAudioManagement)object;
            this.initBaseServices();
            return object;
        }
        if (object instanceof DSISound) {
            this.dsiSound = (DSISound)object;
            this.initBaseServices();
            return object;
        }
        if (object instanceof DSIMediaRouter) {
            this.dsiMediaRouter = (DSIMediaRouter)object;
            this.audioManager.dsiMediaRouterDisposer.addDSI(this.dsiMediaRouter);
            return object;
        }
        if (object instanceof HMIAudioServiceListener) {
            int n = (Integer)serviceReference.getProperty("AUDIO_CLIENT_ID");
            this.audioManager.registerListener((HMIAudioServiceListener)object, n);
            return object;
        }
        if (object instanceof DSIPowerManagement) {
            ((DSIPowerManagement)object).setNotification(this.audioManager.getPowerHandler());
            return object;
        }
        Object object3 = this.audioManager.register(object);
        if (object3 == null) {
            this.bundleContext.ungetService(serviceReference);
        }
        return object3;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("objectClass");
        this.env.lcMain.log(1078071040, "[AudioActivator.removedService] %1 -> %2", object2, object);
        if (object instanceof IAudioFocusClient) {
            this.lastModeHandler.deregisterAudioClient((IAudioFocusClient)object);
        } else if (object instanceof DSIAudioManagement) {
            this.dsiAudio = null;
            this.audioManager.dsiAudioDisposer.removeDSI();
        } else if (object instanceof DSISound) {
            this.dsiSound = null;
            this.audioManager.dsiSoundDisposer.removeDSI();
        } else if (object instanceof DSIMediaRouter) {
            this.dsiMediaRouter = null;
            this.audioManager.dsiMediaRouterDisposer.removeDSI();
        } else if (object instanceof HMIAudioServiceListener) {
            Integer n = (Integer)serviceReference.getProperty("AUDIO_CLIENT_ID");
            this.audioManager.deregisterHMIAudioServiceListener(n, (HMIAudioServiceListener)object);
        } else {
            this.audioManager.deregister(object);
        }
    }

    private void registerAndTrackBaseServices() {
        this.env.lcMain.log(-2137614336, "[AudioActivator.trackAndRegisterBaseServices]");
        this.registerService((class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = AudioActivator.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager).getName(), (Object)this.lastModeHandler, null);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AudioActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.audioManager.getAudioHandler(), (class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = AudioActivator.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AudioActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.audioManager.getDSISoundListener(), (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = AudioActivator.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AudioActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.audioManager.getDSISSEListener(), (class$org$dsi$ifc$sse$DSISSEListener == null ? (class$org$dsi$ifc$sse$DSISSEListener = AudioActivator.class$("org.dsi.ifc.sse.DSISSEListener")) : class$org$dsi$ifc$sse$DSISSEListener).getName(), 0);
        String[] stringArray = new String[]{(class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = AudioActivator.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement).getName(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = AudioActivator.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (class$org$dsi$ifc$sse$DSISSE == null ? (class$org$dsi$ifc$sse$DSISSE = AudioActivator.class$("org.dsi.ifc.sse.DSISSE")) : class$org$dsi$ifc$sse$DSISSE).getName(), (class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = AudioActivator.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient).getName(), (class$org$dsi$ifc$media$DSIMediaRouter == null ? (class$org$dsi$ifc$media$DSIMediaRouter = AudioActivator.class$("org.dsi.ifc.media.DSIMediaRouter")) : class$org$dsi$ifc$media$DSIMediaRouter).getName()};
        new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this).open();
        this.env.logStartupEvent("[AUDIO] start DSIAudioManagement");
        this.framework.startDSIService((class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = AudioActivator.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = AudioActivator.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), 0);
        if (!this.framework.isEvoStd() && !this.framework.isPorscheStd()) {
            this.framework.startDSIService((class$org$dsi$ifc$sse$DSISSE == null ? (class$org$dsi$ifc$sse$DSISSE = AudioActivator.class$("org.dsi.ifc.sse.DSISSE")) : class$org$dsi$ifc$sse$DSISSE).getName(), 0);
            this.framework.startDSIService((class$org$dsi$ifc$media$DSIMediaRouter == null ? (class$org$dsi$ifc$media$DSIMediaRouter = AudioActivator.class$("org.dsi.ifc.media.DSIMediaRouter")) : class$org$dsi$ifc$media$DSIMediaRouter).getName(), 0);
        }
    }

    private void initBaseServices() {
        if (this.dsiAudio != null && this.dsiSound != null) {
            this.env.lcMain.log(-2137614336, "[AudioActivator.initBaseServices] DSIAudiomanagement & DSISound registered.");
            this.audioManager.dsiAudioDisposer.addDSI(this.dsiAudio);
            this.audioManager.dsiSoundDisposer.addDSI(this.dsiSound);
            this.audioManager.dsiAudioDisposer.setNotifications(this.dsiAudio);
            if (!this.initDone) {
                this.registerAndTrackHMIAudioServices();
                this.registerAndTrackOtherServices();
                this.initDone = true;
            }
        }
    }

    private void registerAndTrackOtherServices() {
        this.env.lcMain.log(-2137614336, "[AudioActivator.registerAndTrackOtherServices]");
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AudioActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.audioManager.getReadinessSound().powerEventListener, null);
        this.registerService(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener = AudioActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceToneListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener, this.audioManager.getCombiHandler());
        this.registerService(class$de$audi$atip$interapp$audio$ATIPAudioService == null ? (class$de$audi$atip$interapp$audio$ATIPAudioService = AudioActivator.class$("de.audi.atip.interapp.audio.ATIPAudioService")) : class$de$audi$atip$interapp$audio$ATIPAudioService, this.audioManager.getAtipAudioService());
        this.registerService(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = AudioActivator.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext, this.audioManager.getAudioDrawerContext());
        this.registerService(class$de$audi$atip$interapp$audio$ATIPMediaRouterService == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterService = AudioActivator.class$("de.audi.atip.interapp.audio.ATIPMediaRouterService")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterService, this.audioManager.getMediaRouterService());
        this.registerService(class$de$audi$atip$interapp$audio$SDISRangeListener == null ? (class$de$audi$atip$interapp$audio$SDISRangeListener = AudioActivator.class$("de.audi.atip.interapp.audio.SDISRangeListener")) : class$de$audi$atip$interapp$audio$SDISRangeListener, new OnOffVolumeRange$RangeListenerImpl(this.audioManager.getController().getRange(0)));
        this.registerService(class$de$audi$atip$interapp$audio$IVolumeLockService == null ? (class$de$audi$atip$interapp$audio$IVolumeLockService = AudioActivator.class$("de.audi.atip.interapp.audio.IVolumeLockService")) : class$de$audi$atip$interapp$audio$IVolumeLockService, new VolumeLockService());
        this.registerService(class$de$audi$atip$interapp$audio$IVolumeMapService == null ? (class$de$audi$atip$interapp$audio$IVolumeMapService = AudioActivator.class$("de.audi.atip.interapp.audio.IVolumeMapService")) : class$de$audi$atip$interapp$audio$IVolumeMapService, new VolumeMapService());
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone = AudioActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTone")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone).getName(), (class$de$audi$atip$interapp$TunerService == null ? (class$de$audi$atip$interapp$TunerService = AudioActivator.class$("de.audi.atip.interapp.TunerService")) : class$de$audi$atip$interapp$TunerService).getName(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = AudioActivator.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (class$de$audi$atip$interapp$audio$ATIPAudioServiceListener == null ? (class$de$audi$atip$interapp$audio$ATIPAudioServiceListener = AudioActivator.class$("de.audi.atip.interapp.audio.ATIPAudioServiceListener")) : class$de$audi$atip$interapp$audio$ATIPAudioServiceListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AudioActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = AudioActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = AudioActivator.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName(), (class$de$audi$atip$interapp$phone$ITelServiceAudio == null ? (class$de$audi$atip$interapp$phone$ITelServiceAudio = AudioActivator.class$("de.audi.atip.interapp.phone.ITelServiceAudio")) : class$de$audi$atip$interapp$phone$ITelServiceAudio).getName(), (class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService = AudioActivator.class$("de.audi.atip.interapp.terminalmode.ITerminalModeAudioService")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeAudioService).getName(), (class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener = AudioActivator.class$("de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterServiceListener).getName(), (class$de$audi$atip$interapp$audio$TIJPVolumeServiceListener == null ? (class$de$audi$atip$interapp$audio$TIJPVolumeServiceListener = AudioActivator.class$("de.audi.atip.interapp.audio.TIJPVolumeServiceListener")) : class$de$audi$atip$interapp$audio$TIJPVolumeServiceListener).getName(), (class$de$audi$atip$interapp$phone$ITelMuteMicService == null ? (class$de$audi$atip$interapp$phone$ITelMuteMicService = AudioActivator.class$("de.audi.atip.interapp.phone.ITelMuteMicService")) : class$de$audi$atip$interapp$phone$ITelMuteMicService).getName(), (class$de$audi$atip$interapp$audio$VolumeOnOffPressListener == null ? (class$de$audi$atip$interapp$audio$VolumeOnOffPressListener = AudioActivator.class$("de.audi.atip.interapp.audio.VolumeOnOffPressListener")) : class$de$audi$atip$interapp$audio$VolumeOnOffPressListener).getName()};
        new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this).open();
    }

    private void registerAndTrackHMIAudioServices() {
        this.env.lcMain.log(-2137614336, "[AudioActivator.registerAndTrackHMIAudioServices]");
        this.registerHMIAudioService(HMIAudioService.CLIENT_STARTUP);
        this.registerHMIAudioService(HMIAudioService.CLIENT_RADIO);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TV);
        this.registerHMIAudioService(HMIAudioService.CLIENT_MEDIA);
        this.registerHMIAudioService(HMIAudioService.CLIENT_SDIS);
        this.registerHMIAudioService(HMIAudioService.CLIENT_POWER);
        this.registerHMIAudioService(HMIAudioService.CLIENT_PHONE);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TONE);
        this.registerHMIAudioService(HMIAudioService.CLIENT_NAVI);
        this.registerHMIAudioService(HMIAudioService.CLIENT_SDS);
        this.registerHMIAudioService(HMIAudioService.CLIENT_BT);
        this.registerHMIAudioService(HMIAudioService.CLIENT_CAR);
        this.registerHMIAudioService(HMIAudioService.CLIENT_SWDL);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TIM);
        this.registerHMIAudioService(HMIAudioService.CLIENT_INFO);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_ADB);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_CAR);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_DV);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_MESSAGING);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_OL);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_REMOTE_HMI);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_TIM);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_TOUCHPAD);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_TOUCHPAD_VOLUMEMENU);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_URR);
        this.registerHMIAudioService(HMIAudioService.CLIENT_ECALL);
        this.registerHMIAudioService(HMIAudioService.TTS_DSRC_HIGH);
        this.registerHMIAudioService(HMIAudioService.TTS_DSRC_LOW);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_ETC_VOLUMEMENU);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_WIRELESS_CHARGING);
        this.registerHMIAudioService(HMIAudioService.CLIENT_TTS_WIRELESS_CHARGING_VOLUMEMENU);
        new ServiceTracker(this.bundleContext, (class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AudioActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (ServiceTrackerCustomizer)this).open();
    }

    private void registerHMIAudioService(Integer n) {
        this.env.lcMain.log(-2137614336, "[AudioActivator.registerHMIAudioService] client:%1", (Object)n);
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", n);
        HMIAudioService hMIAudioService = this.audioManager.getAudioService(n);
        this.registerService((class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AudioActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (Object)hMIAudioService, (Dictionary)hashtable);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

