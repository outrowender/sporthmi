/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.tv.TVDiagnosis
 */
package de.audi.tv.app.base;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.TVServiceListener;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.atip.interapp.def.NullTunerService;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import de.audi.atip.interapp.tv.ITVComponentListener;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.util.osgi.NullDSIDisplayManagement;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVAppCommon;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.combi.NullCombiBAPServiceTV;
import de.audi.tv.app.dsi.DSITVTunerListenerImpl;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.NullDSITVTuner;
import de.audi.tv.app.dsi.NullDisplayManager;
import de.audi.tv.app.interapp.ITVInterappListener;
import de.audi.tv.app.interapp.NullTVInterappListener;
import de.mib.swdiagnosis.tv.TVDiagnosis;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.tvtuner.DSITVTuner;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

abstract class AbstractTVActivator
extends AbstractActivator {
    private ServiceTracker trackerSwDiagnosisManager;
    private ServiceTracker trackerDSITVTuner;
    private ServiceTracker trackerDSIDisplayManagement;
    private ServiceTracker trackerDisplayManagement;
    private ServiceTracker trackerAudioServiceManagement;
    private ServiceTracker trackerAudioFocus;
    private ServiceTracker trackerAudioContext;
    private ServiceTracker trackerCombiBAP;
    private ServiceTracker trackerTVInterappListener;
    private ServiceTracker trackerSystemTonePlayer;
    private ServiceTracker trackerTunerService;
    private ServiceTracker trackerSdsService;
    private ServiceTracker trackerComponentListener;
    protected TVEnv env;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$DSITVTunerListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$displaymanager$IDisplayManagerListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener;
    static /* synthetic */ Class class$de$audi$tv$app$interapp$ITVInterappService;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$TVService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$DSITVTuner;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$de$audi$atip$interapp$displaymanager$IDisplayManagerService;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV;
    static /* synthetic */ Class class$de$audi$tv$app$interapp$ITVInterappListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerService;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;
    static /* synthetic */ Class class$de$audi$atip$interapp$TVServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVComponentListener;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;

    AbstractTVActivator() {
    }

    protected abstract TVAppCommon getApp();

    protected abstract void init(TVEnv var1);

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        TVUtil.init(this.framework);
        this.env = new TVEnv(this.framework);
        this.env.lcMain.log(10000000, "[Activator.start]");
        this.init(this.env);
        DSITVTunerListenerImpl dSITVTunerListenerImpl = this.getApp().dsiListener;
        this.registerHMIApplication();
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractTVActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), dSITVTunerListenerImpl, (class$org$dsi$ifc$tvtuner$DSITVTunerListener == null ? (class$org$dsi$ifc$tvtuner$DSITVTunerListener = AbstractTVActivator.class$("org.dsi.ifc.tvtuner.DSITVTunerListener")) : class$org$dsi$ifc$tvtuner$DSITVTunerListener).getName(), 0);
        this.registerService((class$de$audi$atip$interapp$displaymanager$IDisplayManagerListener == null ? (class$de$audi$atip$interapp$displaymanager$IDisplayManagerListener = AbstractTVActivator.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerListener")) : class$de$audi$atip$interapp$displaymanager$IDisplayManagerListener).getName(), (Object)this.getApp().dsiDisplayListener, (Dictionary)new Hashtable(0));
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractTVActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.getApp().tvEventDispatcher.powerEventDispatcher, (Dictionary)new Hashtable(0));
        this.registerAudioListener();
        this.registerService((class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = AbstractTVActivator.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient).getName(), (Object)this.getApp().audioFocus, (Dictionary)new Hashtable(0));
        if (this.env.framework.getKombiProtocol() == 2) {
            this.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener = AbstractTVActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTVListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener).getName(), (Object)this.getApp().combiBAPListener, (Dictionary)new Hashtable(0));
        }
        this.registerService((class$de$audi$tv$app$interapp$ITVInterappService == null ? (class$de$audi$tv$app$interapp$ITVInterappService = AbstractTVActivator.class$("de.audi.tv.app.interapp.ITVInterappService")) : class$de$audi$tv$app$interapp$ITVInterappService).getName(), (Object)this.getApp().interappManager, (Dictionary)new Hashtable(0));
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractTVActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.getApp().msgHandler, (Dictionary)new Hashtable(0));
        this.registerService((class$de$audi$atip$interapp$TVService == null ? (class$de$audi$atip$interapp$TVService = AbstractTVActivator.class$("de.audi.atip.interapp.TVService")) : class$de$audi$atip$interapp$TVService).getName(), (Object)this.getApp().sdsServiceListener, (Dictionary)new Hashtable(0));
        this.env.registerSpeedThresholdListener(this.getApp().tvEventDispatcher.speedThresholdListener, 2);
        this.trackServices();
    }

    private void trackServices() {
        this.env.lcMain.log(10000000, "[Activator.trackAndStartDSITVTuner]");
        this.trackerSwDiagnosisManager = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractTVActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)new SwDiagnosisManagerTracker());
        this.trackerSwDiagnosisManager.open();
        this.trackerDSITVTuner = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$tvtuner$DSITVTuner == null ? (class$org$dsi$ifc$tvtuner$DSITVTuner = AbstractTVActivator.class$("org.dsi.ifc.tvtuner.DSITVTuner")) : class$org$dsi$ifc$tvtuner$DSITVTuner).getName(), (ServiceTrackerCustomizer)new DSITVTunerTracker());
        this.trackerDSITVTuner.open();
        this.trackerDSIDisplayManagement = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = AbstractTVActivator.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName(), (ServiceTrackerCustomizer)new DSIDisplayManagementTracker());
        this.trackerDSIDisplayManagement.open();
        this.trackerDisplayManagement = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService == null ? (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService = AbstractTVActivator.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerService")) : class$de$audi$atip$interapp$displaymanager$IDisplayManagerService).getName(), (ServiceTrackerCustomizer)new DisplayManagementTracker());
        this.trackerDisplayManagement.open();
        this.trackerAudioServiceManagement = new ServiceTracker(this.bundleContext, (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AbstractTVActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (ServiceTrackerCustomizer)new AudioManagementTracker());
        this.trackerAudioServiceManagement.open();
        this.trackerAudioFocus = new ServiceTracker(this.bundleContext, (class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = AbstractTVActivator.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager).getName(), (ServiceTrackerCustomizer)new AudioFocusTracker());
        this.trackerAudioFocus.open();
        this.trackerAudioContext = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = AbstractTVActivator.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext).getName(), (ServiceTrackerCustomizer)new AudioDrawerContextTracker());
        this.trackerAudioContext.open();
        if (this.env.framework.getKombiProtocol() == 2) {
            this.trackerCombiBAP = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV = AbstractTVActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV).getName(), (ServiceTrackerCustomizer)new CombiBAPServiceTracker());
            this.trackerCombiBAP.open();
        }
        this.trackerTVInterappListener = new ServiceTracker(this.bundleContext, (class$de$audi$tv$app$interapp$ITVInterappListener == null ? (class$de$audi$tv$app$interapp$ITVInterappListener = AbstractTVActivator.class$("de.audi.tv.app.interapp.ITVInterappListener")) : class$de$audi$tv$app$interapp$ITVInterappListener).getName(), (ServiceTrackerCustomizer)new InterappListenerTracker());
        this.trackerTVInterappListener.open();
        this.trackerTunerService = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$TunerService == null ? (class$de$audi$atip$interapp$TunerService = AbstractTVActivator.class$("de.audi.atip.interapp.TunerService")) : class$de$audi$atip$interapp$TunerService).getName(), (ServiceTrackerCustomizer)new TunerServiceTracker());
        this.trackerTunerService.open();
        this.trackerSystemTonePlayer = new ServiceTracker(this.getBundleContext(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = AbstractTVActivator.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (ServiceTrackerCustomizer)new WavePlayerTracker());
        this.trackerSystemTonePlayer.open();
        this.trackerSdsService = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$TVServiceListener == null ? (class$de$audi$atip$interapp$TVServiceListener = AbstractTVActivator.class$("de.audi.atip.interapp.TVServiceListener")) : class$de$audi$atip$interapp$TVServiceListener).getName(), (ServiceTrackerCustomizer)new SdsServiceTracker());
        this.trackerSdsService.open();
        this.trackerComponentListener = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$tv$ITVComponentListener == null ? (class$de$audi$atip$interapp$tv$ITVComponentListener = AbstractTVActivator.class$("de.audi.atip.interapp.tv.ITVComponentListener")) : class$de$audi$atip$interapp$tv$ITVComponentListener).getName(), (ServiceTrackerCustomizer)new ComponentServiceTracker());
        this.trackerComponentListener.open();
        this.framework.startDSIService((class$org$dsi$ifc$tvtuner$DSITVTuner == null ? (class$org$dsi$ifc$tvtuner$DSITVTuner = AbstractTVActivator.class$("org.dsi.ifc.tvtuner.DSITVTuner")) : class$org$dsi$ifc$tvtuner$DSITVTuner).getName(), 0);
    }

    public void stop(BundleContext bundleContext) {
        this.env.lcMain.log(1000000, "[Activator.stop]");
        this.trackerSwDiagnosisManager = this.closeTracker(this.trackerSwDiagnosisManager);
        this.trackerDSITVTuner = this.closeTracker(this.trackerDSITVTuner);
        this.trackerDSIDisplayManagement = this.closeTracker(this.trackerDSIDisplayManagement);
        this.trackerDisplayManagement = this.closeTracker(this.trackerDisplayManagement);
        this.trackerAudioServiceManagement = this.closeTracker(this.trackerAudioServiceManagement);
        this.trackerAudioFocus = this.closeTracker(this.trackerAudioFocus);
        this.trackerAudioContext = this.closeTracker(this.trackerAudioContext);
        if (this.env.framework.getKombiProtocol() == 2) {
            this.trackerCombiBAP = this.closeTracker(this.trackerCombiBAP);
        }
        this.trackerTVInterappListener = this.closeTracker(this.trackerTVInterappListener);
        this.trackerTunerService = this.closeTracker(this.trackerTunerService);
        this.trackerSystemTonePlayer = this.closeTracker(this.trackerSystemTonePlayer);
        this.trackerSdsService = this.closeTracker(this.trackerSdsService);
        this.trackerComponentListener = this.closeTracker(this.trackerComponentListener);
        super.stop(bundleContext);
    }

    protected void registerActionProxy(int n, ActionProxy actionProxy) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(n));
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AbstractTVActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)actionProxy, (Dictionary)hashtable);
    }

    private void registerHMIApplication() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(26));
        this.registerService((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractTVActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (Object)this.getApp().hmiApplication, (Dictionary)hashtable);
    }

    private void registerAudioListener() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_TV);
        this.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AbstractTVActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this.getApp().audioListener, (Dictionary)hashtable);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class AudioFocusTracker
    extends DefaultServiceTrackerCustomizer {
        private AudioFocusTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            IAudioFocusManager iAudioFocusManager = (IAudioFocusManager)AbstractTVActivator.this.bundleContext.getService(serviceReference);
            if (iAudioFocusManager != null) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.AudioFocusTracker.addingService] %1", (Object)iAudioFocusManager);
                AbstractTVActivator.this.getApp().audioFocus.register(iAudioFocusManager);
            }
            return iAudioFocusManager;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.AudioFocusTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().audioFocus.register(new NullAudioFocusManager(AbstractTVActivator.this.env.lcHMI));
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class DSITVTunerTracker
    extends DefaultServiceTrackerCustomizer {
        private DSITVTunerTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = AbstractTVActivator.this.bundleContext.getService(serviceReference);
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.DSITVTunerTracker.addingService] %1", object);
            AbstractTVActivator.this.getApp().setDSI((DSITVTuner)object);
            return object;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.DSITVTunerTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().setDSI(new NullDSITVTuner(AbstractTVActivator.this.env.lcMain));
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class SdsServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private SdsServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            TVServiceListener tVServiceListener = (TVServiceListener)AbstractTVActivator.this.getBundleContext().getService(serviceReference);
            if (tVServiceListener != null) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.SdsServiceTracker.addingService] %1", (Object)tVServiceListener);
                AbstractTVActivator.this.getApp().sdsServiceHandler.addListener(tVServiceListener);
            }
            return tVServiceListener;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.SdsServiceTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().sdsServiceHandler.removeListener((TVServiceListener)object);
            AbstractTVActivator.this.getBundleContext().ungetService(serviceReference);
        }
    }

    private class WavePlayerTracker
    extends DefaultServiceTrackerCustomizer {
        private WavePlayerTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            WavePlayer wavePlayer = (WavePlayer)AbstractTVActivator.this.getBundleContext().getService(serviceReference);
            if (wavePlayer != null) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.WavePlayerTracker.addingService] %1", (Object)wavePlayer);
                SystemTonePlayer systemTonePlayer = wavePlayer.getSystemTonePlayer();
                AbstractTVActivator.this.getApp().ewsBeep.setSystemTonePlayer(systemTonePlayer);
                systemTonePlayer.setListener(AbstractTVActivator.this.getApp().ewsBeep.playerListener);
            }
            return wavePlayer;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.WavePlayerTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().ewsBeep.setSystemTonePlayer(new NullSystemTonePlayer(AbstractTVActivator.this.env.lcMain));
            AbstractTVActivator.this.getBundleContext().ungetService(serviceReference);
        }
    }

    private class TunerServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private TunerServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            TunerService tunerService = (TunerService)AbstractTVActivator.this.bundleContext.getService(serviceReference);
            AbstractTVActivator.this.env.lcMain.log(10000000, "[Activator.TunerServiceTracker.addingService] '%1'", (Object)tunerService);
            AbstractTVActivator.this.getApp().taHandler.registerService(tunerService);
            return tunerService;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(10000000, "[Activator.TunerServiceTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().taHandler.registerService(new NullTunerService(AbstractTVActivator.this.env.lcAudio));
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class AudioManagementTracker
    extends DefaultServiceTrackerCustomizer {
        private AudioManagementTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            HMIAudioService hMIAudioService = (HMIAudioService)AbstractTVActivator.this.bundleContext.getService(serviceReference);
            if (HMIAudioService.CLIENT_TV.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.AudioManagementTracker.addingService] %1", (Object)hMIAudioService);
                AbstractTVActivator.this.getApp().audioListener.setService(hMIAudioService);
                AbstractTVActivator.this.getApp().ewsBeep.setHMIAudioService(hMIAudioService);
            }
            return hMIAudioService;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.AudioManagementTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().audioListener.setService(new NullHMIAudioService(AbstractTVActivator.this.env.lcMain));
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class CombiBAPServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private CombiBAPServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            CombiBAPServiceTV combiBAPServiceTV = (CombiBAPServiceTV)AbstractTVActivator.this.bundleContext.getService(serviceReference);
            if (combiBAPServiceTV != null) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.CombiBAPServiceTracker.addingService] %1", (Object)combiBAPServiceTV);
                AbstractTVActivator.this.getApp().combiBAPHandler.registerService(combiBAPServiceTV);
            }
            return combiBAPServiceTV;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.CombiBAPServiceTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().combiBAPHandler.registerService(new NullCombiBAPServiceTV());
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class ComponentServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private ComponentServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            ITVComponentListener iTVComponentListener = (ITVComponentListener)AbstractTVActivator.this.getBundleContext().getService(serviceReference);
            if (iTVComponentListener != null) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.ComponentServiceTracker.addingService] %1", (Object)iTVComponentListener);
                AbstractTVActivator.this.getApp().componentCallListener.setListener(iTVComponentListener);
            }
            return iTVComponentListener;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.ComponentServiceTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().componentCallListener.setListener(null);
            AbstractTVActivator.this.getBundleContext().ungetService(serviceReference);
        }
    }

    private class InterappListenerTracker
    extends DefaultServiceTrackerCustomizer {
        private InterappListenerTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            ITVInterappListener iTVInterappListener = (ITVInterappListener)AbstractTVActivator.this.bundleContext.getService(serviceReference);
            if (iTVInterappListener != null) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.InterappListenerTracker.addingService] %1", (Object)iTVInterappListener);
                AbstractTVActivator.this.getApp().interappManager.registerService(iTVInterappListener);
            }
            return iTVInterappListener;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.InterappListenerTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().interappManager.registerService(new NullTVInterappListener());
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class DisplayManagementTracker
    extends DefaultServiceTrackerCustomizer {
        private DisplayManagementTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = AbstractTVActivator.this.bundleContext.getService(serviceReference);
            AbstractTVActivator.this.getApp().setDSI((IDisplayManagerService)object);
            return object;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.getApp().setDSI(new NullDisplayManager());
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class AudioDrawerContextTracker
    extends DefaultServiceTrackerCustomizer {
        private AudioDrawerContextTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            AudioDrawerContext audioDrawerContext = (AudioDrawerContext)AbstractTVActivator.this.bundleContext.getService(serviceReference);
            if (audioDrawerContext != null) {
                AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.AudioDrawerContextTracker.addingService] %1", (Object)audioDrawerContext);
                AbstractTVActivator.this.getApp().audioFocus.register(audioDrawerContext);
            }
            return audioDrawerContext;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.env.lcMain.log(1000000, "[Activator.AudioDrawerContextTracker.removedService] %1", object);
            AbstractTVActivator.this.getApp().audioFocus.register(new NullAudioDrawerContext(AbstractTVActivator.this.env.lcAudio));
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class SwDiagnosisManagerTracker
    extends DefaultServiceTrackerCustomizer {
        private SwDiagnosisManagerTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            SwDiagnosisManager swDiagnosisManager = (SwDiagnosisManager)AbstractTVActivator.this.bundleContext.getService(serviceReference);
            if (swDiagnosisManager != null) {
                TVDiagnosis tVDiagnosis = new TVDiagnosis(AbstractTVActivator.this.getApp());
                AbstractTVActivator.this.getApp().dsiListener.addListeners(new DefaultTVListener[]{tVDiagnosis.tvListener});
                swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)tVDiagnosis);
            }
            return swDiagnosisManager;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class DSIDisplayManagementTracker
    extends DefaultServiceTrackerCustomizer {
        private DSIDisplayManagementTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = AbstractTVActivator.this.bundleContext.getService(serviceReference);
            AbstractTVActivator.this.getApp().setDSI((DSIDisplayManagement)object);
            return object;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            AbstractTVActivator.this.getApp().setDSI(new NullDSIDisplayManagement(AbstractTVActivator.this.env.lcMain));
            AbstractTVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }
}

