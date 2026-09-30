/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.DiagnosisSwDiagGateway
 */
package de.audi.tghu.diag;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.diag.IDiagnosisApp;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.NaviService;
import de.audi.tghu.diag.DiagnosisApp;
import de.mib.swdiagnosis.DiagnosisSwDiagGateway;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.diagnose.DSIDiagnoseSystem;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class DiagnosisActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private DiagnosisApp diagnosisApp;
    private ServiceTracker dsiTracker;
    private ServiceRegistration sRegDiag;
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIDiagnoseSystem;
    static /* synthetic */ Class class$de$audi$atip$diag$IDiagnosisApp;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;

    public DiagnosisActivator() {
        super("FwDiag");
    }

    public DiagnosisApp getService() {
        return this.diagnosisApp;
    }

    protected void startInternal(BundleContext bundleContext) {
        this.diagnosisApp = new DiagnosisApp(this.framework);
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener = DiagnosisActivator.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystemListener")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.sRegDiag = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DiagnosisActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.diagnosisApp.getDsiHandler(), (Dictionary)hashtable);
        this.dsiTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$diagnose$DSIDiagnoseSystem == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystem = DiagnosisActivator.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystem")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystem).getName(), (class$de$audi$atip$diag$IDiagnosisApp == null ? (class$de$audi$atip$diag$IDiagnosisApp = DiagnosisActivator.class$("de.audi.atip.diag.IDiagnosisApp")) : class$de$audi$atip$diag$IDiagnosisApp).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = DiagnosisActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = DiagnosisActivator.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName()}, (ServiceTrackerCustomizer)this);
        this.dsiTracker.open();
        this.framework.startDSIService((class$org$dsi$ifc$diagnose$DSIDiagnoseSystem == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystem = DiagnosisActivator.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystem")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystem).getName(), 0);
    }

    public void stop(BundleContext bundleContext) {
        if (this.sRegDiag != null) {
            this.sRegDiag.unregister();
            this.sRegDiag = null;
        }
        if (this.dsiTracker != null) {
            this.dsiTracker.close();
            this.dsiTracker = null;
        }
        super.stop(bundleContext);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIDiagnoseSystem) {
            this.diagnosisApp.getDsiHandler().setDSIDiagnoseSystem((DSIDiagnoseSystem)object);
        }
        if (object instanceof NaviService) {
            this.diagnosisApp.getDsiHandler().setNaviService((NaviService)object);
        } else if (object instanceof IDiagnosisApp) {
            this.diagnosisApp.addDiagnosisApplication((IDiagnosisApp)object);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new DiagnosisSwDiagGateway(this.getService()));
        } else {
            return null;
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IDiagnosisApp) {
            this.diagnosisApp.removeDiagnosisApplication((IDiagnosisApp)object);
        } else if (object instanceof NaviService) {
            this.diagnosisApp.getDsiHandler().setNaviService(null);
        }
        this.bundleContext.ungetService(serviceReference);
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

