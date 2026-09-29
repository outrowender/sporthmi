/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma.proxy;

import de.audi.app.car.core.charisma.proxy.AbstractCharismaIndividualSettingsClient;
import de.audi.app.car.core.charisma.proxy.ICharismaIndividualSettingsProxy;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AbstractCharismaIndividualSettingsClient$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AbstractCharismaIndividualSettingsClient this$0;

    AbstractCharismaIndividualSettingsClient$1(AbstractCharismaIndividualSettingsClient abstractCharismaIndividualSettingsClient) {
        this.this$0 = abstractCharismaIndividualSettingsClient;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.application.getBundleContext().getService(serviceReference);
        if (object instanceof ICharismaIndividualSettingsProxy) {
            this.this$0.proxy = (ICharismaIndividualSettingsProxy)object;
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

