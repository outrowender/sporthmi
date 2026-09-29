/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.info.AppTestSupportDiag
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.Activator$1;
import de.audi.app.testsupport.TestSupportApplication;
import de.audi.atip.activator.AbstractActivator;
import de.mib.swdiagnosis.info.AppTestSupportDiag;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator
extends AbstractActivator {
    TestSupportApplication app;
    AppTestSupportDiag diagGateway;
    ServiceTracker diagTracker;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.app = new TestSupportApplication(this.getFramework(), bundleContext);
        this.app.init();
        this.initTracker();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.diagTracker != null) {
            this.diagTracker.close();
            this.diagTracker = null;
        }
        super.stop(bundleContext);
        this.app.deinit();
    }

    private void initTracker() {
        this.diagTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = Activator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)new Activator$1(this));
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

    static /* synthetic */ BundleContext access$000(Activator activator) {
        return activator.bundleContext;
    }

    static /* synthetic */ BundleContext access$100(Activator activator) {
        return activator.bundleContext;
    }

    static /* synthetic */ BundleContext access$200(Activator activator) {
        return activator.bundleContext;
    }
}

