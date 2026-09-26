/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.smi.SMIActivator;
import de.audi.tghu.smi.SMIActivator$1;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SMIActivator$SDSTrackerDispatcher
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SMIActivator this$0;

    private SMIActivator$SDSTrackerDispatcher(SMIActivator sMIActivator) {
        this.this$0 = sMIActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TTSASR tTSASR = (TTSASR)SMIActivator.access$500(this.this$0).getService(serviceReference);
        if (tTSASR != null) {
            SMIActivator.access$300((SMIActivator)this.this$0).getLogger().smi.log(1078071040, "[SMIActivator-SDSTrackerDispatcher#addingService] adding SDS Service...");
            SMIActivator.access$300(this.this$0).setSDSService(tTSASR);
            SMIActivator.access$300((SMIActivator)this.this$0).getLogger().smi.log(1078071040, "[SMIActivator-SDSTrackerDispatcher#addingService] triggering the SDSApp to fire initialize-event");
            tTSASR.initializeStateMachine();
            return tTSASR;
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        SMIActivator.access$300((SMIActivator)this.this$0).getLogger().smi.log(1000, "[SDSTrackerDispatcher#removedService] removed SDS Service...");
        SMIActivator.access$600(this.this$0).ungetService(serviceReference);
        SMIActivator.access$300(this.this$0).setSDSService(null);
    }

    /* synthetic */ SMIActivator$SDSTrackerDispatcher(SMIActivator sMIActivator, SMIActivator$1 sMIActivator$1) {
        this(sMIActivator);
    }
}

