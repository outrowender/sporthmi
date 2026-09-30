/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.audio.sdis.SdisAudioDiag
 */
package de.audi.audio.sdis;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.IBluetoothA2LSService;
import de.audi.atip.interapp.audio.SDISRangeListener;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.def.NullBluetoothA2LSService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.atip.util.osgi.NullDSISound;
import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.ASIHMISyncAudioImpl;
import de.audi.audio.sdis.ISdisCommandFactory;
import de.audi.audio.sdis.SdisAudioHandler;
import de.audi.audio.sdis.SdisStreamState;
import de.audi.audio.sdis.cmd.SdisCommandFactoryImpl;
import de.audi.audio.sdis.ifc.NullDSIMediaRouter;
import de.mib.swdiagnosis.audio.sdis.SdisAudioDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRouter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SdisAudioActivator
extends AbstractActivator {
    private ServiceTracker trackerSDISAudioService;
    private ServiceTracker trackerDSISound;
    private ServiceTracker trackerHMIAudioService;
    private ServiceTracker trackerAudioDrawerContext;
    private ServiceTracker trackerDSIMediaRouter;
    private ServiceTracker trackerDSIMediaBase;
    private ServiceTracker trackerSwDiagnosisManager;
    private ServiceTracker trackerRangeListener;
    private ServiceTracker trackerBluetooth;
    private ServiceTracker trackerMedia;
    ASIHMISyncAudioImpl asiProvider;
    private SdisAudioHandler sdisHandler;
    private AudioEnv env;
    private SdisCommandFactoryImpl commandFactory;
    private final ServiceTrackerCustomizer serviceTracker = new SdisAudioServiceTracker();
    private SdisStreamState streamState;
    static /* synthetic */ Class class$de$audi$audio$sdis$ifc$SdisAudioService;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouter;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBase;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$SDISRangeListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBluetoothA2LSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaService;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$AtipAudioSdisService;
    static /* synthetic */ Class class$de$audi$audio$sdis$ifc$SdisAudioListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaServiceListener;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IAudioSdisListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouterListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.env = new AudioEnv(this.framework);
        this.env.lcSDIS.log(10000000, "[AudioSDISActivator.start]");
        ILastmodeHandler iLastmodeHandler = this.env.framework.getLastmodeHandler();
        this.asiProvider = new ASIHMISyncAudioImpl(0, this.env.lcSDIS);
        this.streamState = new SdisStreamState(this.env.lcSDIS);
        this.commandFactory = new SdisCommandFactoryImpl(this.env, iLastmodeHandler, this.asiProvider.sdisAudioListener, this.streamState);
        this.sdisHandler = new SdisAudioHandler(this.env, this.commandFactory, this.asiProvider.sdisAudioListener);
        this.asiProvider.setAudioService(this.sdisHandler.sdisAudioService);
        this.trackerSDISAudioService = this.openTracker(class$de$audi$audio$sdis$ifc$SdisAudioService == null ? (class$de$audi$audio$sdis$ifc$SdisAudioService = SdisAudioActivator.class$("de.audi.audio.sdis.ifc.SdisAudioService")) : class$de$audi$audio$sdis$ifc$SdisAudioService, this.serviceTracker);
        this.trackerDSISound = this.openTracker(class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = SdisAudioActivator.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound, this.serviceTracker);
        this.trackerDSIMediaRouter = this.openTracker(class$org$dsi$ifc$media$DSIMediaRouter == null ? (class$org$dsi$ifc$media$DSIMediaRouter = SdisAudioActivator.class$("org.dsi.ifc.media.DSIMediaRouter")) : class$org$dsi$ifc$media$DSIMediaRouter, this.serviceTracker);
        this.trackerDSIMediaBase = this.openTracker(class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = SdisAudioActivator.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase, this.serviceTracker);
        this.trackerSwDiagnosisManager = this.openTracker(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = SdisAudioActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager, this.serviceTracker);
        this.trackerHMIAudioService = this.openTracker(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = SdisAudioActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService, this.serviceTracker);
        this.trackerAudioDrawerContext = this.openTracker(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = SdisAudioActivator.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext, this.serviceTracker);
        this.trackerRangeListener = this.openTracker(class$de$audi$atip$interapp$audio$SDISRangeListener == null ? (class$de$audi$atip$interapp$audio$SDISRangeListener = SdisAudioActivator.class$("de.audi.atip.interapp.audio.SDISRangeListener")) : class$de$audi$atip$interapp$audio$SDISRangeListener, this.serviceTracker);
        this.trackerBluetooth = this.openTracker(class$de$audi$atip$interapp$IBluetoothA2LSService == null ? (class$de$audi$atip$interapp$IBluetoothA2LSService = SdisAudioActivator.class$("de.audi.atip.interapp.IBluetoothA2LSService")) : class$de$audi$atip$interapp$IBluetoothA2LSService, this.serviceTracker);
        this.trackerMedia = this.openTracker(class$de$audi$atip$interapp$media$IMediaService == null ? (class$de$audi$atip$interapp$media$IMediaService = SdisAudioActivator.class$("de.audi.atip.interapp.media.IMediaService")) : class$de$audi$atip$interapp$media$IMediaService, this.serviceTracker);
        this.registerService(class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = SdisAudioActivator.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient, this.sdisHandler.sdisAudioService);
        this.registerService(class$de$audi$atip$interapp$audio$AtipAudioSdisService == null ? (class$de$audi$atip$interapp$audio$AtipAudioSdisService = SdisAudioActivator.class$("de.audi.atip.interapp.audio.AtipAudioSdisService")) : class$de$audi$atip$interapp$audio$AtipAudioSdisService, this.sdisHandler.sdisAudioService);
        this.registerService(class$de$audi$audio$sdis$ifc$SdisAudioListener == null ? (class$de$audi$audio$sdis$ifc$SdisAudioListener = SdisAudioActivator.class$("de.audi.audio.sdis.ifc.SdisAudioListener")) : class$de$audi$audio$sdis$ifc$SdisAudioListener, this.asiProvider.sdisAudioListener);
        this.registerService(class$de$audi$atip$interapp$media$IMediaServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaServiceListener = SdisAudioActivator.class$("de.audi.atip.interapp.media.IMediaServiceListener")) : class$de$audi$atip$interapp$media$IMediaServiceListener, this.sdisHandler.sdisMediaServiceListener);
        this.registerService(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = SdisAudioActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider, this.asiProvider);
        this.registerService(class$de$audi$atip$interapp$audio$IAudioSdisListener == null ? (class$de$audi$atip$interapp$audio$IAudioSdisListener = SdisAudioActivator.class$("de.audi.atip.interapp.audio.IAudioSdisListener")) : class$de$audi$atip$interapp$audio$IAudioSdisListener, this.sdisHandler.audioListener);
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_SDIS);
        this.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = SdisAudioActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this.sdisHandler.audioListener, (Dictionary)hashtable);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = SdisAudioActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.sdisHandler.dsiMediaRouterListener, (class$org$dsi$ifc$media$DSIMediaRouterListener == null ? (class$org$dsi$ifc$media$DSIMediaRouterListener = SdisAudioActivator.class$("org.dsi.ifc.media.DSIMediaRouterListener")) : class$org$dsi$ifc$media$DSIMediaRouterListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = SdisAudioActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.sdisHandler.dsiSoundListener, (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = SdisAudioActivator.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), 0);
        this.env.lcSDIS.log(10000000, "[AudioSDISActivator.start] fnished");
    }

    public void stop(BundleContext bundleContext) {
        this.trackerSDISAudioService = this.closeTracker(this.trackerSDISAudioService);
        this.trackerDSISound = this.closeTracker(this.trackerDSISound);
        this.trackerDSIMediaRouter = this.closeTracker(this.trackerDSIMediaRouter);
        this.trackerDSIMediaBase = this.closeTracker(this.trackerDSIMediaBase);
        this.trackerSwDiagnosisManager = this.closeTracker(this.trackerSwDiagnosisManager);
        this.trackerHMIAudioService = this.closeTracker(this.trackerHMIAudioService);
        this.trackerBluetooth = this.closeTracker(this.trackerBluetooth);
        this.trackerMedia = this.closeTracker(this.trackerMedia);
        this.sdisHandler = null;
        this.env = null;
        super.stop(bundleContext);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class SdisAudioServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private SdisAudioServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = SdisAudioActivator.this.bundleContext.getService(serviceReference);
            ((SdisAudioActivator)SdisAudioActivator.this).env.lcSDIS.log(1000000, "[AudioSDISActivator.addingService] %1", object);
            if (object instanceof HMIAudioService) {
                Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
                if (!HMIAudioService.CLIENT_SDIS.equals(object2)) {
                    return null;
                }
                SdisAudioActivator.this.commandFactory.setHmiAudioService((HMIAudioService)object);
                SdisAudioActivator.this.sdisHandler.setAudioService((HMIAudioService)object);
                return object;
            }
            if (object instanceof AudioDrawerContext) {
                SdisAudioActivator.this.sdisHandler.setAudioDrawerContext((AudioDrawerContext)object);
            }
            if (object instanceof DSIMediaRouter) {
                int[] nArray = new int[]{2, 1};
                DSIMediaRouter dSIMediaRouter = (DSIMediaRouter)object;
                dSIMediaRouter.setNotification(nArray, (DSIListener)((SdisAudioActivator)SdisAudioActivator.this).sdisHandler.dsiMediaRouterListener);
                SdisAudioActivator.this.commandFactory.setDsiMediaRouter(dSIMediaRouter);
                return object;
            }
            if (object instanceof DSISound) {
                SdisAudioActivator.this.sdisHandler.setDSISound((DSISound)object);
                return object;
            }
            if (object instanceof SwDiagnosisManager) {
                ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new SdisAudioDiag(SdisAudioActivator.this.sdisHandler, SdisAudioActivator.this.asiProvider.sdisAudioListener, (ISdisCommandFactory)SdisAudioActivator.this.commandFactory));
                return object;
            }
            if (object instanceof SDISRangeListener) {
                SdisAudioActivator.this.sdisHandler.setRangeListener((SDISRangeListener)object);
                return object;
            }
            if (object instanceof IBluetoothA2LSService) {
                ((SdisAudioActivator)SdisAudioActivator.this).sdisHandler.sdisAudioService.setBluetoothService((IBluetoothA2LSService)object);
                return object;
            }
            if (object instanceof IMediaService) {
                ((SdisAudioActivator)SdisAudioActivator.this).sdisHandler.mediaService = (IMediaService)object;
                return object;
            }
            return null;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            ((SdisAudioActivator)SdisAudioActivator.this).env.lcSDIS.log(1000000, "[AudioSDISActivator.removedService] %1", object);
            if (object instanceof DSIMediaRouter) {
                SdisAudioActivator.this.commandFactory.setDsiMediaRouter(new NullDSIMediaRouter(((SdisAudioActivator)SdisAudioActivator.this).env.lcSDIS));
            } else if (object instanceof DSISound) {
                SdisAudioActivator.this.sdisHandler.setDSISound(new NullDSISound(((SdisAudioActivator)SdisAudioActivator.this).env.lcSDIS));
            } else if (object instanceof HMIAudioService) {
                Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
                if (HMIAudioService.CLIENT_SDIS.equals(object2)) {
                    SdisAudioActivator.this.commandFactory.setHmiAudioService(new NullHMIAudioService(((SdisAudioActivator)SdisAudioActivator.this).env.lcSDIS));
                }
            } else if (object instanceof AudioDrawerContext) {
                SdisAudioActivator.this.sdisHandler.setAudioDrawerContext(new NullAudioDrawerContext(((SdisAudioActivator)SdisAudioActivator.this).env.lcSDIS));
            } else if (object instanceof IBluetoothA2LSService) {
                ((SdisAudioActivator)SdisAudioActivator.this).sdisHandler.sdisAudioService.setBluetoothService(new NullBluetoothA2LSService(((SdisAudioActivator)SdisAudioActivator.this).env.lcSDIS));
            } else if (object instanceof IMediaService) {
                ((SdisAudioActivator)SdisAudioActivator.this).sdisHandler.mediaService = null;
            }
        }
    }
}

