/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds.g2p;

import de.audi.app.media.sds.g2p.G2PCallbackHandler;
import de.audi.atip.interapp.media.IMediaSDSServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class G2PCallbackHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ G2PCallbackHandler this$0;

    G2PCallbackHandler$1(G2PCallbackHandler g2PCallbackHandler) {
        this.this$0 = g2PCallbackHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        G2PCallbackHandler.access$000(this.this$0).log(1078071040, "[%1.removedService] SDS listener removed.", (Object)"G2PCallbackHandler");
        G2PCallbackHandler.access$100(this.this$0).releaseService(serviceReference);
        G2PCallbackHandler.access$202(this.this$0, null);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        G2PCallbackHandler.access$202(this.this$0, (IMediaSDSServiceListener)G2PCallbackHandler.access$100(this.this$0).getService(serviceReference));
        G2PCallbackHandler.access$000(this.this$0).log(1078071040, "[%1.addingService] SDS listener found ('%2').", (Object)"G2PCallbackHandler", (Object)G2PCallbackHandler.access$200(this.this$0));
        return G2PCallbackHandler.access$200(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

