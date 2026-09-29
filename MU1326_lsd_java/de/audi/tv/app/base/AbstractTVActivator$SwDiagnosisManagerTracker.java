/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.tv.TVDiagnosis
 */
package de.audi.tv.app.base;

import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.mib.swdiagnosis.tv.TVDiagnosis;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$SwDiagnosisManagerTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$SwDiagnosisManagerTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SwDiagnosisManager swDiagnosisManager = (SwDiagnosisManager)AbstractTVActivator.access$1900(this.this$0).getService(serviceReference);
        if (swDiagnosisManager != null) {
            TVDiagnosis tVDiagnosis = new TVDiagnosis(this.this$0.getApp());
            this.this$0.getApp().dsiListener.addListeners(new DefaultTVListener[]{tVDiagnosis.tvListener});
            swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)tVDiagnosis);
        }
        return swDiagnosisManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AbstractTVActivator.access$2000(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$SwDiagnosisManagerTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

