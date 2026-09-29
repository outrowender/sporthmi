/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIActivator;
import de.audi.tghu.jdsi.JDSIManager;
import org.dsi.ifc.base.DSIBase;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class JDSIActivator$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ JDSIManager val$manager;
    private final /* synthetic */ JDSIActivator this$0;

    JDSIActivator$2(JDSIActivator jDSIActivator, JDSIManager jDSIManager) {
        this.this$0 = jDSIActivator;
        this.val$manager = jDSIManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = JDSIActivator.access$500(this.this$0).getService(serviceReference);
        if (object instanceof DSIBase) {
            try {
                this.val$manager.addDSIService((DSIBase)object, JDSIActivator.access$600(this.this$0, serviceReference), JDSIActivator.access$700(this.this$0, serviceReference));
                return object;
            }
            catch (Exception exception) {
                JDSIActivator.access$800(this.this$0).ungetService(serviceReference);
                JDSIActivator.access$900(this.this$0).log(10000, "Incorrect property DEVICE_INSTANCE for a DSI reference %1", (Object)serviceReference);
                return null;
            }
        }
        JDSIActivator.access$1000(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        JDSIActivator.access$1100(this.this$0).ungetService(serviceReference);
        this.val$manager.removedDSIService((DSIBase)object, JDSIActivator.access$600(this.this$0, serviceReference), JDSIActivator.access$700(this.this$0, serviceReference));
    }
}

