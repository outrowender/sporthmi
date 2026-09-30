/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.info.AppTestSupportDiag
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportApplication;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.mib.swdiagnosis.info.AppTestSupportDiag;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator
extends AbstractActivator {
    TestSupportApplication app;
    AppTestSupportDiag diagGateway;
    ServiceTracker diagTracker;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.app = new TestSupportApplication(this.getFramework(), bundleContext);
        this.app.init();
        this.initTracker();
    }

    public void stop(BundleContext bundleContext) {
        if (this.diagTracker != null) {
            this.diagTracker.close();
            this.diagTracker = null;
        }
        super.stop(bundleContext);
        this.app.deinit();
    }

    private void initTracker() {
        this.diagTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = Activator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = Activator.this.bundleContext.getService(serviceReference);
                if (object instanceof SwDiagnosisManager) {
                    Activator.this.diagGateway = new AppTestSupportDiag();
                    ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)Activator.this.diagGateway);
                    return object;
                }
                Activator.this.bundleContext.ungetService(serviceReference);
                return null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof SwDiagnosisManager) {
                    Activator.this.bundleContext.ungetService(serviceReference);
                    ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)Activator.this.diagGateway);
                    Activator.this.diagGateway = null;
                }
            }
        });
        this.diagTracker.open();
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

