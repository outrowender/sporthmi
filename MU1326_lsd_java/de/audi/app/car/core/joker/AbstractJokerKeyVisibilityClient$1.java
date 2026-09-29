/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.joker;

import de.audi.app.car.core.joker.AbstractJokerKeyVisibilityClient;
import de.audi.atip.interapp.car.jokerkey.ICarJokerKeyVisibilityProxy;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AbstractJokerKeyVisibilityClient$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AbstractJokerKeyVisibilityClient this$0;

    AbstractJokerKeyVisibilityClient$1(AbstractJokerKeyVisibilityClient abstractJokerKeyVisibilityClient) {
        this.this$0 = abstractJokerKeyVisibilityClient;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.application.getBundleContext().getService(serviceReference);
        if (object instanceof ICarJokerKeyVisibilityProxy) {
            this.this$0.proxy = (ICarJokerKeyVisibilityProxy)object;
            this.this$0.proxy.registerClient(this.this$0);
        }
        return object;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.proxy = null;
        this.this$0.application.getBundleContext().ungetService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

