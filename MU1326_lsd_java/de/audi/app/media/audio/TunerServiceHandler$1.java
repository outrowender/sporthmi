/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.TunerServiceHandler;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.def.NullTunerService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TunerServiceHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TunerServiceHandler this$0;

    TunerServiceHandler$1(TunerServiceHandler tunerServiceHandler) {
        this.this$0 = tunerServiceHandler;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TunerServiceHandler.access$002(this.this$0, (TunerService)this.this$0.getTerminal().getServiceManager().getService(serviceReference));
        TunerServiceHandler.access$100(this.this$0).audio().log(-2137614336, "[%1.addingService] '%2'", (Object)"TunerServiceHandler", (Object)TunerServiceHandler.access$000(this.this$0));
        return TunerServiceHandler.access$000(this.this$0);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TunerServiceHandler.access$200(this.this$0).audio().log(-2137614336, "[%1.removedService]", (Object)"TunerServiceHandler");
        TunerServiceHandler.access$002(this.this$0, new NullTunerService(TunerServiceHandler.access$300(this.this$0).audio()));
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

