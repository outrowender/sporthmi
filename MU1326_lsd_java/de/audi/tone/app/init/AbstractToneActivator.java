/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.init;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.audio.AmplifierListener;
import de.audi.atip.interapp.audio.IAnnouncementStateListener;
import de.audi.atip.interapp.audio.IAnnouncementStateService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSISound;
import de.audi.tone.app.announcement.AnnouncementStateDispatcher;
import de.audi.tone.app.ap.ToneActionProxyBase;
import de.audi.tone.app.init.ToneAppCommon;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.audio.DSISound;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractToneActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private volatile HMIAudioService toneAudioService;
    private volatile DSISound dsiSound;
    private volatile boolean initDone = false;
    private AnnouncementStateDispatcher annStateDispatcher;
    private LogChannel lcMain;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IAnnouncementStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem;
    static /* synthetic */ Class class$de$audi$atip$interapp$PhoneService;
    static /* synthetic */ Class class$de$audi$atip$interapp$BluetoothService;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaFilePlayerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NavAsiaToneConnector;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneServiceListener;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$AtipAudioSdisService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IAnnouncementStateService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ISoundHandlerListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$AmplifierListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IAudioSdisListener;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.lcMain = this.framework.getLogChannel("Fw.Audio.Main");
        this.lcMain.log(10000000, "[ToneActivator.start]");
        this.init();
        this.annStateDispatcher = new AnnouncementStateDispatcher();
        if (this.getApp().getVolumeRangeManager().getMenus()[0] instanceof IAnnouncementStateListener) {
            this.annStateDispatcher.addAnnouncementStateListener((IAnnouncementStateListener)((Object)this.getApp().getVolumeRangeManager().getMenus()[0]), 1);
        }
        if (this.getApp().getVolumeRangeManager().getMenus()[3] instanceof IAnnouncementStateListener) {
            this.annStateDispatcher.addAnnouncementStateListener((IAnnouncementStateListener)((Object)this.getApp().getVolumeRangeManager().getMenus()[3]), 0);
        }
        if (this.getApp().getVolumeRangeManager().getMenus()[1] instanceof IAnnouncementStateListener) {
            this.annStateDispatcher.addAnnouncementStateListener((IAnnouncementStateListener)((Object)this.getApp().getVolumeRangeManager().getMenus()[1]), 2);
        }
        this.trackAndRegisterBaseServices();
    }

    protected abstract ToneAppCommon getApp();

    protected abstract void init();

    public Object addingService(ServiceReference serviceReference) {
        Object object;
        Object object2;
        Object object3 = this.bundleContext.getService(serviceReference);
        if (object3 instanceof HMIAudioService || object3 instanceof DSISound) {
            object2 = this.addBaseService(serviceReference);
        } else if (object3 instanceof IAnnouncementStateService) {
            object = serviceReference.getProperty("ANN_STATE_CLIENT_ID");
            object2 = this.getApp().setService(object3, object);
        } else if (object3 instanceof AmplifierListener) {
            object2 = this.getApp().setService(object3);
        } else {
            object = serviceReference.getProperty("TTS_CLIENT_ID");
            object2 = this.getApp().setService(object3, object);
        }
        if (object2 != null) {
            object = serviceReference.getProperty("objectClass");
            this.lcMain.log(10000000, "[ToneActivator.addingService] %1 -> %2", object, object3);
        } else {
            this.bundleContext.ungetService(serviceReference);
        }
        return object2;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("objectClass");
        this.lcMain.log(1000000, "[ToneActivator.removedService] %1 -> %2", object2, object);
        if (object instanceof DSISound) {
            this.getApp().setService(new NullDSISound(this.framework.getLogChannel("Fw.Audio.DSI")));
            this.dsiSound = null;
            this.getApp().setToneReady(false);
        } else if (object instanceof IAnnouncementStateService) {
            Object object3 = serviceReference.getProperty("ANN_STATE_CLIENT_ID");
            this.getApp().removeService(object, object3);
        } else {
            this.getApp().removeService(object);
        }
    }

    private void trackAndRegisterBaseServices() {
        this.lcMain.log(10000000, "[ToneActivator.trackBaseServices]");
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractToneActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.getApp().getDSISoundListener(), (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = AbstractToneActivator.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), 0);
        String[] stringArray = new String[]{(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AbstractToneActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = AbstractToneActivator.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName()};
        new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this).open();
    }

    private Object addBaseService(ServiceReference serviceReference) {
        Object object;
        Object object2 = this.bundleContext.getService(serviceReference);
        if (object2 instanceof HMIAudioService) {
            object = serviceReference.getProperty("AUDIO_CLIENT_ID");
            if (!HMIAudioService.CLIENT_TONE.equals(object)) {
                return null;
            }
            this.toneAudioService = (HMIAudioService)object2;
        }
        if (object2 instanceof DSISound) {
            this.dsiSound = (DSISound)object2;
        }
        if (this.toneAudioService != null && this.dsiSound != null) {
            this.lcMain.log(10000000, "[ToneActivator.addBaseService] HMIAudioService (Tone) & DSISound registered.");
            this.getApp().setService(this.dsiSound);
            this.getApp().setService(this.toneAudioService);
            object = new Hashtable();
            ((Hashtable)object).put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_TONE);
            this.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AbstractToneActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this.getApp().getHMIAudioServiceListener(), (Dictionary)object);
            this.getApp().setNotifications(this.dsiSound);
            this.getApp().getVolumeRangeManager().init();
            if (!this.initDone) {
                this.registerAndTrackOtherServices();
                this.getApp().initInputGainOffsetHandler(this.toneAudioService);
                this.initDone = true;
            }
            this.getApp().setToneReady(true);
        }
        return object2;
    }

    protected void registerAndTrackOtherServices() {
        this.lcMain.log(10000000, "[ToneActivator.registerAndTrackOtherServices]");
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(10));
        hashtable.put("ApplicationName", "AudioAmplifier");
        this.registerService((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractToneActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (Object)this.getApp().getHMIApplication(), (Dictionary)hashtable);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractToneActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.getApp().getMessageListener(), (Dictionary)hashtable);
        this.registerService((class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = AbstractToneActivator.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService).getName(), (Object)this.getApp().getVolumeRangeManager().toneService, null);
        this.registerService((class$de$audi$atip$interapp$audio$ATIPAudioServiceListener == null ? (class$de$audi$atip$interapp$audio$ATIPAudioServiceListener = AbstractToneActivator.class$("de.audi.atip.interapp.audio.ATIPAudioServiceListener")) : class$de$audi$atip$interapp$audio$ATIPAudioServiceListener).getName(), (Object)this.getApp().getATIPAudioListener(), (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_TOUCHPAD_VOLUME_MENU);
        hashtable.put("ApplicationName", "TOUCHPAD_VOLUME_MENU");
        TTSListener tTSListener = (TTSListener)((Object)this.getApp().getVolumeRangeManager().getSamplePlayer(6));
        this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractToneActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)tTSListener, (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_WIRELESS_CHARGING_VOLUME_MENU);
        hashtable.put("ApplicationName", "WIRELESS_CHARGING_VOLUME_MENU");
        TTSListener tTSListener2 = (TTSListener)((Object)this.getApp().getVolumeRangeManager().getSamplePlayer(11));
        this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractToneActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)tTSListener2, (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_ETC_VOLUME_MENU);
        hashtable.put("ApplicationName", "INFO_ANNOUNCEMENT_VOLUME_MENU");
        TTSListener tTSListener3 = (TTSListener)((Object)this.getApp().getVolumeRangeManager().getSamplePlayer(12));
        this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractToneActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)tTSListener3, (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_WIRELESS_CHARGING);
        hashtable.put("ApplicationName", "WIRELESS_CHARGING");
        TTSListener tTSListener4 = this.getApp().getWirelessChargingReminder().getSamplePlayer();
        this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractToneActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)tTSListener4, (Dictionary)hashtable);
        this.registerService((class$de$audi$atip$interapp$audio$IAnnouncementStateListener == null ? (class$de$audi$atip$interapp$audio$IAnnouncementStateListener = AbstractToneActivator.class$("de.audi.atip.interapp.audio.IAnnouncementStateListener")) : class$de$audi$atip$interapp$audio$IAnnouncementStateListener).getName(), (Object)this.annStateDispatcher, null);
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = AbstractToneActivator.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = AbstractToneActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = AbstractToneActivator.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem = AbstractToneActivator.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystem")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem).getName(), (class$de$audi$atip$interapp$PhoneService == null ? (class$de$audi$atip$interapp$PhoneService = AbstractToneActivator.class$("de.audi.atip.interapp.PhoneService")) : class$de$audi$atip$interapp$PhoneService).getName(), (class$de$audi$atip$interapp$BluetoothService == null ? (class$de$audi$atip$interapp$BluetoothService = AbstractToneActivator.class$("de.audi.atip.interapp.BluetoothService")) : class$de$audi$atip$interapp$BluetoothService).getName(), (class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = AbstractToneActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractToneActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$interapp$audio$ATIPAudioService == null ? (class$de$audi$atip$interapp$audio$ATIPAudioService = AbstractToneActivator.class$("de.audi.atip.interapp.audio.ATIPAudioService")) : class$de$audi$atip$interapp$audio$ATIPAudioService).getName(), (class$de$audi$atip$interapp$media$IMediaFilePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaFilePlayerService = AbstractToneActivator.class$("de.audi.atip.interapp.media.IMediaFilePlayerService")) : class$de$audi$atip$interapp$media$IMediaFilePlayerService).getName(), (class$de$audi$atip$interapp$NavAsiaToneConnector == null ? (class$de$audi$atip$interapp$NavAsiaToneConnector = AbstractToneActivator.class$("de.audi.atip.interapp.NavAsiaToneConnector")) : class$de$audi$atip$interapp$NavAsiaToneConnector).getName(), (class$de$audi$atip$interapp$audio$ToneServiceListener == null ? (class$de$audi$atip$interapp$audio$ToneServiceListener = AbstractToneActivator.class$("de.audi.atip.interapp.audio.ToneServiceListener")) : class$de$audi$atip$interapp$audio$ToneServiceListener).getName(), (class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = AbstractToneActivator.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager).getName(), (class$de$audi$atip$interapp$audio$AtipAudioSdisService == null ? (class$de$audi$atip$interapp$audio$AtipAudioSdisService = AbstractToneActivator.class$("de.audi.atip.interapp.audio.AtipAudioSdisService")) : class$de$audi$atip$interapp$audio$AtipAudioSdisService).getName(), (class$de$audi$atip$interapp$audio$IAnnouncementStateService == null ? (class$de$audi$atip$interapp$audio$IAnnouncementStateService = AbstractToneActivator.class$("de.audi.atip.interapp.audio.IAnnouncementStateService")) : class$de$audi$atip$interapp$audio$IAnnouncementStateService).getName(), (class$de$audi$atip$interapp$audio$ISoundHandlerListener == null ? (class$de$audi$atip$interapp$audio$ISoundHandlerListener = AbstractToneActivator.class$("de.audi.atip.interapp.audio.ISoundHandlerListener")) : class$de$audi$atip$interapp$audio$ISoundHandlerListener).getName(), (class$de$audi$atip$interapp$audio$AmplifierListener == null ? (class$de$audi$atip$interapp$audio$AmplifierListener = AbstractToneActivator.class$("de.audi.atip.interapp.audio.AmplifierListener")) : class$de$audi$atip$interapp$audio$AmplifierListener).getName(), (class$de$audi$atip$interapp$audio$IAudioSdisListener == null ? (class$de$audi$atip$interapp$audio$IAudioSdisListener = AbstractToneActivator.class$("de.audi.atip.interapp.audio.IAudioSdisListener")) : class$de$audi$atip$interapp$audio$IAudioSdisListener).getName()};
        new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this).open();
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    protected void registerActionProxy(int n, ToneActionProxyBase toneActionProxyBase) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(n));
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AbstractToneActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)toneActionProxyBase, (Dictionary)hashtable);
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

