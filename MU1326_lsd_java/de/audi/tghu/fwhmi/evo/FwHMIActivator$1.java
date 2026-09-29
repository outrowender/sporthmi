/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.evo.HMIDiagGatewayEvo
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.tghu.fwhmi.evo.FwHMIActivator;
import de.mib.swdiagnosis.evo.HMIDiagGatewayEvo;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class FwHMIActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ FwHMIActivator this$0;

    FwHMIActivator$1(FwHMIActivator fwHMIActivator) {
        this.this$0 = fwHMIActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = FwHMIActivator.access$000(this.this$0).getBundleCxt().getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new HMIDiagGatewayEvo(FwHMIActivator.access$100(this.this$0)));
        } else {
            FwHMIActivator.access$200(this.this$0).getBundleCxt().ungetService(serviceReference);
            object = null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        FwHMIActivator.access$300(this.this$0).getBundleCxt().ungetService(serviceReference);
    }
}

