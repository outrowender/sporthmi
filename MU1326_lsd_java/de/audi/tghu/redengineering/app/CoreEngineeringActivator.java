/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.tghu.redengineering.app.CoreEngineeringActivator$1;
import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.swdl.ude.IEActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class CoreEngineeringActivator
extends AbstractActivator {
    private EngineeringApp engApp;
    private ServiceTracker tracker;
    private IEActivator ieActivator;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaP;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$engineering$fsc$IFSCService;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaPListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public EngineeringApp getEngineeringApp() {
        return this.engApp;
    }

    protected void startCoreBundle(EngineeringApp engineeringApp, EngineeringEnv engineeringEnv) {
        this.engApp = engineeringApp;
        this.registerServices(this.engApp);
        this.initTracker(engineeringEnv);
        this.framework.startDSIService((class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = CoreEngineeringActivator.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP).getName(), 0);
        if (!this.framework.isEvoStd() && !this.framework.isPorscheStd()) {
            this.ieActivator = new IEActivator(engineeringApp, engineeringEnv);
            this.ieActivator.start(this.bundleContext);
        }
    }

    private void registerServices(EngineeringApp engineeringApp) {
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = CoreEngineeringActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)engineeringApp, null);
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = CoreEngineeringActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)engineeringApp, null);
        this.registerService((class$de$audi$atip$engineering$fsc$IFSCService == null ? (class$de$audi$atip$engineering$fsc$IFSCService = CoreEngineeringActivator.class$("de.audi.atip.engineering.fsc.IFSCService")) : class$de$audi$atip$engineering$fsc$IFSCService).getName(), (Object)engineeringApp.getFSCViewer().getFscService(), null);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = CoreEngineeringActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), engineeringApp.getFSCViewer(), (class$org$dsi$ifc$swap$DSISWaPListener == null ? (class$org$dsi$ifc$swap$DSISWaPListener = CoreEngineeringActivator.class$("org.dsi.ifc.swap.DSISWaPListener")) : class$org$dsi$ifc$swap$DSISWaPListener).getName(), 0);
    }

    private void initTracker(EngineeringEnv engineeringEnv) {
        this.tracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = CoreEngineeringActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = CoreEngineeringActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = CoreEngineeringActivator.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder).getName(), (class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = CoreEngineeringActivator.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = CoreEngineeringActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)new CoreEngineeringActivator$1(this, engineeringEnv));
        this.tracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.ieActivator != null) {
            this.ieActivator.stop();
            this.ieActivator = null;
        }
        this.tracker = this.closeTracker(this.tracker);
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

    static /* synthetic */ BundleContext access$000(CoreEngineeringActivator coreEngineeringActivator) {
        return coreEngineeringActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$100(CoreEngineeringActivator coreEngineeringActivator) {
        return coreEngineeringActivator.bundleContext;
    }

    static /* synthetic */ EngineeringApp access$200(CoreEngineeringActivator coreEngineeringActivator) {
        return coreEngineeringActivator.engApp;
    }

    static /* synthetic */ BundleContext access$300(CoreEngineeringActivator coreEngineeringActivator) {
        return coreEngineeringActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$400(CoreEngineeringActivator coreEngineeringActivator) {
        return coreEngineeringActivator.bundleContext;
    }
}

