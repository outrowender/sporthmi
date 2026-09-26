/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.info.AppTestSupportDiag
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.Activator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.mib.swdiagnosis.info.AppTestSupportDiag;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class Activator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ Activator this$0;

    Activator$1(Activator activator) {
        this.this$0 = activator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = Activator.access$000(this.this$0).getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            this.this$0.diagGateway = new AppTestSupportDiag();
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.this$0.diagGateway);
            return object;
        }
        Activator.access$100(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof SwDiagnosisManager) {
            Activator.access$200(this.this$0).ungetService(serviceReference);
            ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)this.this$0.diagGateway);
            this.this$0.diagGateway = null;
        }
    }
}

