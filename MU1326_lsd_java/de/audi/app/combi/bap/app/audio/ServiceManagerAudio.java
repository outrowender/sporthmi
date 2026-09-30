/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.app.combi.bap.app.audio.AppConnectorMedia;
import de.audi.app.combi.bap.app.audio.AppConnectorTV;
import de.audi.app.combi.bap.app.audio.AppConnectorTerminalMode;
import de.audi.app.combi.bap.app.audio.AppConnectorTone;
import de.audi.app.combi.bap.app.audio.AppConnectorTuner;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.info.AppConnectorInfo;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.ExternalKeyListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceInfoListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTVListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalModeListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceToneListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerAudio
extends AbstractBAPModuleServiceManager {
    private final LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceInfo;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$ExternalKeyListener;

    public ServiceManagerAudio(AbstractCombiModule abstractCombiModule, BundleContext bundleContext) {
        super(abstractCombiModule, bundleContext);
        this.logChannel = abstractCombiModule.getLogChannel();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServiceTunerListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#addingService] CombiBAPServiceTunerListener found");
            ((AppConnectorTuner)this.module.getAppConnectors().get("Tuner")).setAppServiceListener((CombiBAPServiceTunerListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceMediaListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#addingService] CombiBAPServiceMediaListener found");
            ((AppConnectorMedia)this.module.getAppConnectors().get("Media")).setAppServiceListener((CombiBAPServiceMediaListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceTVListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#addingService] CombiBAPServiceTVListener found");
            ((AppConnectorTV)this.module.getAppConnectors().get("TV")).setAppServiceListener((CombiBAPServiceTVListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceTerminalModeListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#addingService] CombiBAPServiceTerminalModeListener found");
            ((AppConnectorTerminalMode)this.module.getAppConnectors().get("TerminalMode")).setAppServiceListener((CombiBAPServiceTerminalModeListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceToneListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#addingService] CombiBAPServiceToneListener found");
            ((AppConnectorTone)this.module.getAppConnectors().get("Tone")).setAppServiceListener((CombiBAPServiceToneListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceInfoListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#addingService] CombiBAPServiceInfoListener found");
            ((AppConnectorInfo)this.module.getAppConnectors().get("Info")).setAppServiceListener((CombiBAPServiceInfoListener)object);
            return object;
        }
        if (object instanceof ExternalKeyListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#addingService] ExternalKeyListener found");
            ((CombiModuleAudio)this.module).setExternalKeyListener((ExternalKeyListener)object);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceTunerListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#removedService] CombiBAPServiceTunerListener removed");
            ((AppConnectorTuner)this.module.getAppConnectors().get("Tuner")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else if (object instanceof CombiBAPServiceMediaListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#removedService] CombiBAPServiceMediaListener removed");
            ((AppConnectorMedia)this.module.getAppConnectors().get("Media")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else if (object instanceof CombiBAPServiceTVListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#removedService] CombiBAPServiceTVListener removed");
            ((AppConnectorTV)this.module.getAppConnectors().get("TV")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else if (object instanceof CombiBAPServiceTerminalModeListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#removedService] CombiBAPServiceTerminalModeListener removed");
            ((AppConnectorTerminalMode)this.module.getAppConnectors().get("TerminalMode")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else if (object instanceof CombiBAPServiceToneListener) {
            this.logChannel.log(10000000, "[ServiceManagerAudio#removedService] CombiBAPServiceToneListener removed");
            ((AppConnectorTone)this.module.getAppConnectors().get("Tone")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            this.logChannel.log(100000, "[ServiceManagerAudio#removedService] removing unknown service: %1", (Object)serviceReference);
            super.removedService(serviceReference, object);
        }
    }

    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorTuner as CombiBAPServiceTuner");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTuner).getName(), this.module.getAppConnectors().get("Tuner"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorMedia as CombiBAPServiceMedia");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMedia")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMedia).getName(), this.module.getAppConnectors().get("Media"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorTV as CombiBAPServiceTV");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTV).getName(), this.module.getAppConnectors().get("TV"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorTerminalMode as CombiBAPServiceTerminalMode");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode).getName(), this.module.getAppConnectors().get("TerminalMode"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorTone as CombiBAPServiceTone");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTone")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTone).getName(), this.module.getAppConnectors().get("Tone"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorSDS as CombiBAPServiceSDS");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS).getName(), this.module.getAppConnectors().get("SDSManager"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorInfo as CombiBAPServiceInfo");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceInfo == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceInfo = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceInfo")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceInfo).getName(), this.module.getAppConnectors().get("Info"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering AppConnectorSystem as CombiBAPServiceSystem");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSystem")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem).getName(), this.module.getAppConnectors().get("System"), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering InitializationManagerAudio as MessageListener");
        abstractActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ServiceManagerAudio.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.module.getInitializationManager(), null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registering module as MessageListener");
        abstractActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ServiceManagerAudio.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.module, null);
        this.logChannel.log(10000000, "[ServiceManagerAudio#registerServices] Registerung activeAudioApplicationHandler as AudioFocusClient");
        abstractActivator.registerService((class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = ServiceManagerAudio.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient).getName(), (Object)((CombiModuleAudio)this.module).getAudioApplicationFocusHandler(), null);
    }

    public void trackServices() {
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener).getName(), (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceMediaListener).getName(), (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTVListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTVListener).getName(), (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener = ServiceManagerAudio.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceToneListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceToneListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerAudio.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$interapp$ExternalKeyListener == null ? (class$de$audi$atip$interapp$ExternalKeyListener = ServiceManagerAudio.class$("de.audi.atip.interapp.ExternalKeyListener")) : class$de$audi$atip$interapp$ExternalKeyListener).getName()};
        this.serviceTracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
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

