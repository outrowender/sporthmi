/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.SDISSystemDiag
 */
package de.audi.app.system;

import de.audi.app.system.SystemSDISActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.SDISConnectionStateListener;
import de.audi.atip.interapp.sdis.ISDISBlockingListener;
import de.mib.swdiagnosis.SDISSystemDiag;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SystemSDISActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SystemSDISActivator this$0;

    SystemSDISActivator$1(SystemSDISActivator systemSDISActivator) {
        this.this$0 = systemSDISActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = SystemSDISActivator.access$000(this.this$0).getService(serviceReference);
        if (object != null) {
            if (object instanceof ISDISBlockingListener) {
                SystemSDISActivator.access$100(this.this$0).addBlockingListener((ISDISBlockingListener)object);
            } else if (object instanceof SwDiagnosisManager) {
                SystemSDISActivator.access$202(this.this$0, new SDISSystemDiag(SystemSDISActivator.access$300(this.this$0), SystemSDISActivator.access$100(this.this$0), SystemSDISActivator.access$400(this.this$0), SystemSDISActivator.access$500(this.this$0)));
                ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)SystemSDISActivator.access$200(this.this$0));
            } else if (object instanceof SDISConnectionStateListener) {
                SystemSDISActivator.access$300(this.this$0).addSDISConnectionStateListener((SDISConnectionStateListener)object);
            } else {
                SystemSDISActivator.access$600(this.this$0).ungetService(serviceReference);
                return null;
            }
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ISDISBlockingListener) {
            SystemSDISActivator.access$100(this.this$0).addBlockingListener((ISDISBlockingListener)object);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)SystemSDISActivator.access$200(this.this$0));
            SystemSDISActivator.access$202(this.this$0, null);
        } else if (object instanceof SDISConnectionStateListener) {
            SystemSDISActivator.access$300(this.this$0).removeSDISConnectionStateListener(object);
        }
        SystemSDISActivator.access$700(this.this$0).ungetService(serviceReference);
    }
}

