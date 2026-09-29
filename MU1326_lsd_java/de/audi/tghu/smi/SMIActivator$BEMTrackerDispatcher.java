/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.testsupport.ITestSupportService;
import de.audi.tghu.smi.SMIActivator;
import de.audi.tghu.smi.SMIActivator$1;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SMIActivator$BEMTrackerDispatcher
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SMIActivator this$0;

    private SMIActivator$BEMTrackerDispatcher(SMIActivator sMIActivator) {
        this.this$0 = sMIActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ITestSupportService iTestSupportService = (ITestSupportService)SMIActivator.access$200(this.this$0).getService(serviceReference);
        if (iTestSupportService != null) {
            SMIActivator.access$300(this.this$0).getSOSHandler().setTestSupportService(iTestSupportService);
            return iTestSupportService;
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        SMIActivator.access$400(this.this$0).ungetService(serviceReference);
        SMIActivator.access$300(this.this$0).getSOSHandler().setTestSupportService(null);
    }

    /* synthetic */ SMIActivator$BEMTrackerDispatcher(SMIActivator sMIActivator, SMIActivator$1 sMIActivator$1) {
        this(sMIActivator);
    }
}

