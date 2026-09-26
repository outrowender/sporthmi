/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sdis.TunerSDISDiag
 */
package de.audi.app.tuner;

import de.audi.app.tuner.TunerSDISActivator;
import de.audi.app.tuner.TunerSDISActivator$1;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.tuner.ifc.IRadioInterappService;
import de.audi.tuner.ifc.NullRadioInterappService;
import de.mib.swdiagnosis.sdis.TunerSDISDiag;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TunerSDISActivator$MyServiceTracker
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TunerSDISActivator this$0;

    private TunerSDISActivator$MyServiceTracker(TunerSDISActivator tunerSDISActivator) {
        this.this$0 = tunerSDISActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TunerSDISActivator.access$400(this.this$0).log(1078071040, "MyServiceTracker#addingService( %1 )", (Object)serviceReference);
        boolean bl = false;
        Object object = TunerSDISActivator.access$500(this.this$0).getService(serviceReference);
        if (object instanceof IRadioInterappService) {
            this.this$0.asiProvider.setRadioInterappService((IRadioInterappService)object);
            bl = true;
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new TunerSDISDiag(this.this$0.asiProvider));
            bl = true;
        }
        return bl ? serviceReference : null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TunerSDISActivator.access$400(this.this$0).log(1078071040, "MyServiceTracker#removedService( %1, %2 )", (Object)serviceReference, object);
        if (object instanceof IRadioInterappService) {
            this.this$0.asiProvider.setRadioInterappService(new NullRadioInterappService(TunerSDISActivator.access$400(this.this$0)));
        }
    }

    /* synthetic */ TunerSDISActivator$MyServiceTracker(TunerSDISActivator tunerSDISActivator, TunerSDISActivator$1 tunerSDISActivator$1) {
        this(tunerSDISActivator);
    }
}

