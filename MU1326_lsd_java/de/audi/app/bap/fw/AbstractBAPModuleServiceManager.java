/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractBAPModuleServiceManager
implements ServiceTrackerCustomizer {
    protected AbstractBAPModule module;
    protected BundleContext bundleContext;
    protected ServiceTracker serviceTracker;

    public AbstractBAPModuleServiceManager(AbstractBAPModule abstractBAPModule, BundleContext bundleContext) {
        this.module = abstractBAPModule;
        this.bundleContext = bundleContext;
    }

    public abstract void registerServices(AbstractActivator var1);

    public abstract void trackServices();

    protected void closeTracker() {
        if (this.serviceTracker != null) {
            this.serviceTracker.close();
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            this.module.getLogChannel().log(10000000, "[AbstractBAPModuleServiceManager#addingService] SwDiagnosisManager found -> adding diagnosis gateway of lsg=%1", (Object)LSGIDs.getDescription(this.module.getLSGID()));
            AbstractSwDiagnosis abstractSwDiagnosis = this.module.getDiagnosisGateway(true);
            if (abstractSwDiagnosis != null) {
                ((SwDiagnosisManager)object).addDiagGateway(abstractSwDiagnosis);
                return object;
            }
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        AbstractSwDiagnosis abstractSwDiagnosis;
        if (object instanceof SwDiagnosisManager && (abstractSwDiagnosis = this.module.getDiagnosisGateway(false)) != null) {
            ((SwDiagnosisManager)object).removeDiagGateway(abstractSwDiagnosis);
            this.bundleContext.ungetService(serviceReference);
        }
    }
}

