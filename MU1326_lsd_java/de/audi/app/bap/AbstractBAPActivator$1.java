/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap;

import de.audi.app.bap.AbstractBAPActivator;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AbstractBAPActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AbstractBAPActivator this$0;

    AbstractBAPActivator$1(AbstractBAPActivator abstractBAPActivator) {
        this.this$0 = abstractBAPActivator;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).removeDiagGateway(AbstractBAPActivator.access$000(this.this$0));
            AbstractBAPActivator.access$100(this.this$0).ungetService(serviceReference);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = AbstractBAPActivator.access$200(this.this$0).getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            AbstractBAPActivator.access$002(this.this$0, this.this$0.createDiagnosis(this.this$0.bapApplication));
            if (AbstractBAPActivator.access$000(this.this$0) != null) {
                ((SwDiagnosisManager)object).addDiagGateway(AbstractBAPActivator.access$000(this.this$0));
            } else {
                this.this$0.logChannel.log(-2137614336, "[AbstractBAPActivator.startSwDiagnosis().new ServiceTrackerCustomizer() {...}#addingService] diagnosis not available for %1", (Object)super.getClass().getName());
            }
            return object;
        }
        return null;
    }
}

