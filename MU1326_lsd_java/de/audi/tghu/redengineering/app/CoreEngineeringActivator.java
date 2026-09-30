/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.swdl.EngineeringDiagnosisGateway
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.SDSService;
import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.swdl.ude.IEActivator;
import de.mib.swdiagnosis.swdl.EngineeringDiagnosisGateway;
import org.dsi.ifc.swap.DSISWaP;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
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

    private void initTracker(final EngineeringEnv engineeringEnv) {
        this.tracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = CoreEngineeringActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = CoreEngineeringActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = CoreEngineeringActivator.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder).getName(), (class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = CoreEngineeringActivator.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = CoreEngineeringActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, new ServiceTrackerCustomizer(){

            /*
             * Enabled aggressive block sorting
             */
            public Object addingService(ServiceReference serviceReference) {
                Object object = CoreEngineeringActivator.this.bundleContext.getService(serviceReference);
                if (object instanceof HMIAudioService) {
                    Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
                    if (HMIAudioService.CLIENT_SWDL.equals(object2)) {
                        CoreEngineeringActivator.this.getEngineeringApp().getAudioManagementHandler().setHmiAudioService((HMIAudioService)object);
                        return object;
                    }
                    CoreEngineeringActivator.this.bundleContext.ungetService(serviceReference);
                    return null;
                }
                if (object instanceof SDSService) {
                    engineeringEnv.setSdsService((SDSService)object);
                    return object;
                }
                if (object instanceof DSISWaP) {
                    CoreEngineeringActivator.this.getEngineeringApp().getFSCViewer().setDSI((DSISWaP)object);
                    return object;
                }
                if (object instanceof SwDiagnosisManager) {
                    EngineeringDiagnosisGateway engineeringDiagnosisGateway = new EngineeringDiagnosisGateway(CoreEngineeringActivator.this.engApp, engineeringEnv);
                    ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)engineeringDiagnosisGateway);
                    return object;
                }
                CoreEngineeringActivator.this.bundleContext.ungetService(serviceReference);
                return null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof HMIAudioService) {
                    Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
                    if (HMIAudioService.CLIENT_SWDL.equals(object2)) {
                        CoreEngineeringActivator.this.getEngineeringApp().getAudioManagementHandler().setHmiAudioService(null);
                    }
                } else if (object.equals(engineeringEnv.getSdsService())) {
                    engineeringEnv.setSdsService(null);
                }
                CoreEngineeringActivator.this.bundleContext.ungetService(serviceReference);
            }
        });
        this.tracker.open();
    }

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
}

