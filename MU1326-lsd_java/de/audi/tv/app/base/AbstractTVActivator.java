/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.AbstractTVActivator$AudioDrawerContextTracker;
import de.audi.tv.app.base.AbstractTVActivator$AudioFocusTracker;
import de.audi.tv.app.base.AbstractTVActivator$AudioManagementTracker;
import de.audi.tv.app.base.AbstractTVActivator$CombiBAPServiceTracker;
import de.audi.tv.app.base.AbstractTVActivator$ComponentServiceTracker;
import de.audi.tv.app.base.AbstractTVActivator$DSIDisplayManagementTracker;
import de.audi.tv.app.base.AbstractTVActivator$DSITVTunerTracker;
import de.audi.tv.app.base.AbstractTVActivator$DisplayManagementTracker;
import de.audi.tv.app.base.AbstractTVActivator$InterappListenerTracker;
import de.audi.tv.app.base.AbstractTVActivator$SdsServiceTracker;
import de.audi.tv.app.base.AbstractTVActivator$SwDiagnosisManagerTracker;
import de.audi.tv.app.base.AbstractTVActivator$TunerServiceTracker;
import de.audi.tv.app.base.AbstractTVActivator$WavePlayerTracker;
import de.audi.tv.app.base.TVAppCommon;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITVTunerListenerImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
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

    protected abstract TVAppCommon getApp() {
    }

    protected abstract void init(TVEnv tVEnv) {
    }

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        TVUtil.init(this.framework);
        this.env = new TVEnv(this.framework);
        this.env.lcMain.log(-2137614336, "[Activator.start]");
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
        this.env.lcMain.log(-2137614336, "[Activator.trackAndStartDSITVTuner]");
        this.trackerSwDiagnosisManager = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractTVActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$SwDiagnosisManagerTracker(this, null));
        this.trackerSwDiagnosisManager.open();
        this.trackerDSITVTuner = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$tvtuner$DSITVTuner == null ? (class$org$dsi$ifc$tvtuner$DSITVTuner = AbstractTVActivator.class$("org.dsi.ifc.tvtuner.DSITVTuner")) : class$org$dsi$ifc$tvtuner$DSITVTuner).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$DSITVTunerTracker(this, null));
        this.trackerDSITVTuner.open();
        this.trackerDSIDisplayManagement = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = AbstractTVActivator.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$DSIDisplayManagementTracker(this, null));
        this.trackerDSIDisplayManagement.open();
        this.trackerDisplayManagement = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService == null ? (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService = AbstractTVActivator.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerService")) : class$de$audi$atip$interapp$displaymanager$IDisplayManagerService).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$DisplayManagementTracker(this, null));
        this.trackerDisplayManagement.open();
        this.trackerAudioServiceManagement = new ServiceTracker(this.bundleContext, (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AbstractTVActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$AudioManagementTracker(this, null));
        this.trackerAudioServiceManagement.open();
        this.trackerAudioFocus = new ServiceTracker(this.bundleContext, (class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = AbstractTVActivator.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$AudioFocusTracker(this, null));
        this.trackerAudioFocus.open();
        this.trackerAudioContext = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = AbstractTVActivator.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$AudioDrawerContextTracker(this, null));
        this.trackerAudioContext.open();
        if (this.env.framework.getKombiProtocol() == 2) {
            this.trackerCombiBAP = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV = AbstractTVActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$CombiBAPServiceTracker(this, null));
            this.trackerCombiBAP.open();
        }
        this.trackerTVInterappListener = new ServiceTracker(this.bundleContext, (class$de$audi$tv$app$interapp$ITVInterappListener == null ? (class$de$audi$tv$app$interapp$ITVInterappListener = AbstractTVActivator.class$("de.audi.tv.app.interapp.ITVInterappListener")) : class$de$audi$tv$app$interapp$ITVInterappListener).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$InterappListenerTracker(this, null));
        this.trackerTVInterappListener.open();
        this.trackerTunerService = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$TunerService == null ? (class$de$audi$atip$interapp$TunerService = AbstractTVActivator.class$("de.audi.atip.interapp.TunerService")) : class$de$audi$atip$interapp$TunerService).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$TunerServiceTracker(this, null));
        this.trackerTunerService.open();
        this.trackerSystemTonePlayer = new ServiceTracker(this.getBundleContext(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = AbstractTVActivator.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$WavePlayerTracker(this, null));
        this.trackerSystemTonePlayer.open();
        this.trackerSdsService = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$TVServiceListener == null ? (class$de$audi$atip$interapp$TVServiceListener = AbstractTVActivator.class$("de.audi.atip.interapp.TVServiceListener")) : class$de$audi$atip$interapp$TVServiceListener).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$SdsServiceTracker(this, null));
        this.trackerSdsService.open();
        this.trackerComponentListener = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$tv$ITVComponentListener == null ? (class$de$audi$atip$interapp$tv$ITVComponentListener = AbstractTVActivator.class$("de.audi.atip.interapp.tv.ITVComponentListener")) : class$de$audi$atip$interapp$tv$ITVComponentListener).getName(), (ServiceTrackerCustomizer)new AbstractTVActivator$ComponentServiceTracker(this, null));
        this.trackerComponentListener.open();
        this.framework.startDSIService((class$org$dsi$ifc$tvtuner$DSITVTuner == null ? (class$org$dsi$ifc$tvtuner$DSITVTuner = AbstractTVActivator.class$("org.dsi.ifc.tvtuner.DSITVTuner")) : class$org$dsi$ifc$tvtuner$DSITVTuner).getName(), 0);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.env.lcMain.log(1078071040, "[Activator.stop]");
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

    static /* synthetic */ BundleContext access$1300(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1400(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1500(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1600(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1700(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1800(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1900(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2000(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2100(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2200(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2300(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2400(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2500(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2600(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2700(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2800(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$2900(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$3000(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$3100(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$3200(AbstractTVActivator abstractTVActivator) {
        return abstractTVActivator.bundleContext;
    }
}

