/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.DispatcherDiag
 *  de.mib.swdiagnosis.JDSIManagerDiag
 *  de.mib.swdiagnosis.StartUpDiag
 */
package de.audi.atip.startup;

import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.startup.StartupManager;
import de.mib.swdiagnosis.DispatcherDiag;
import de.mib.swdiagnosis.JDSIManagerDiag;
import de.mib.swdiagnosis.StartUpDiag;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class StartupManager$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ StartupManager this$0;

    StartupManager$2(StartupManager startupManager) {
        this.this$0 = startupManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = StartupManager.access$2700(this.this$0).getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new StartUpDiag(this.this$0));
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new DispatcherDiag(StartupManager.access$2700(this.this$0)));
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new JDSIManagerDiag(StartupManager.access$2800(this.this$0)));
            return object;
        }
        StartupManager.access$2700(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        StartupManager.access$2700(this.this$0).ungetService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

