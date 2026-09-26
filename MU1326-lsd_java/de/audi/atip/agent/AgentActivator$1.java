/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.agent;

import de.audi.atip.agent.AgentActivator;
import de.audi.atip.agent.IASIProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AgentActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$context;
    private final /* synthetic */ AgentActivator this$0;

    AgentActivator$1(AgentActivator agentActivator, BundleContext bundleContext) {
        this.this$0 = agentActivator;
        this.val$context = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AgentActivator.access$000(this.this$0).log(1078071040, "Adding service: %1", (Object)serviceReference);
        Object object = null;
        try {
            object = this.val$context.getService(serviceReference);
            if (object instanceof IASIProvider) {
                AgentActivator.access$000(this.this$0).log(1078071040, "Adding ASIHandler: %1", object);
                AgentActivator.access$100(this.this$0).register((IASIProvider)object);
                return object;
            }
        }
        catch (Exception exception) {
            AgentActivator.access$000(this.this$0).log(1078071040, "Adding Service failed: %1", (Object)serviceReference, (Throwable)exception);
        }
        if (object != null) {
            this.val$context.ungetService(serviceReference);
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AgentActivator.access$000(this.this$0).log(1078071040, "Removed service: %1 %2", (Object)serviceReference, object);
        try {
            this.val$context.ungetService(serviceReference);
            if (object instanceof IASIProvider) {
                AgentActivator.access$000(this.this$0).log(1078071040, "Removed ASIHandler: %1", object);
                AgentActivator.access$100(this.this$0).unregister((IASIProvider)object);
            }
        }
        catch (Exception exception) {
            AgentActivator.access$000(this.this$0).log(1078071040, "Removed Service failed: %1", (Object)serviceReference, (Throwable)exception);
        }
    }
}

