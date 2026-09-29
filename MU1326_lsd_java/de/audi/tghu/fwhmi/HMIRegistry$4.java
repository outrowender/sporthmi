/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.view.IKeyBoardManager;
import de.audi.tghu.fwhmi.HMIRegistry;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class HMIRegistry$4
implements ServiceTrackerCustomizer {
    private final /* synthetic */ HMIRegistry this$0;

    HMIRegistry$4(HMIRegistry hMIRegistry) {
        this.this$0 = hMIRegistry;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.bc.getService(serviceReference);
        if (object == null) {
            return null;
        }
        if (object instanceof IFocusManager) {
            this.this$0.log.log(-2137614336, "HMIRegistry: adding IFocusManager: service: %1 ", object);
            this.this$0.fwHMI.setFocusManager((IFocusManager)object);
            return object;
        }
        if (object instanceof IKeyBoardManager) {
            this.this$0.log.log(-2137614336, "HMIRegistry: adding IKeyBoardManager: service: %1 ", object);
            this.this$0.fwHMI.setKeyBoardManager((IKeyBoardManager)object);
            return object;
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IFocusManager) {
            this.this$0.log.log(-2137614336, "HMIRegistry: removed IFocusManager service: %1", object);
            this.this$0.fwHMI.setFocusManager(null);
        } else if (object instanceof IKeyBoardManager) {
            this.this$0.log.log(-2137614336, "HMIRegistry: removed IKeyBoardManager: service: %1 ", object);
            this.this$0.fwHMI.setKeyBoardManager(null);
        }
        this.this$0.bc.ungetService(serviceReference);
        HMIRegistry.access$100(this.this$0);
    }
}

