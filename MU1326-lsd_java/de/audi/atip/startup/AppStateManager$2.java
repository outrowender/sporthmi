/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.ComponentStateListener;
import de.audi.atip.startup.AppStateManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AppStateManager$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AppStateManager this$0;

    AppStateManager$2(AppStateManager appStateManager) {
        this.this$0 = appStateManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AppStateManager.access$000(this.this$0).log(1078071040, "AppStateManager.initComponentStateListenerTracker(): Removing service: %1", object);
        if (object instanceof ComponentStateListener) {
            this.this$0.unregisterComponentStateListener((ComponentStateListener)object);
        } else {
            AppStateManager.access$000(this.this$0).log(10000, "AppStateManager.initComponentStateListenerTracker(): Removed service not an instance of ComponentStateListener: %1", object);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        AppStateManager.access$000(this.this$0).log(10000, "AppStateManager.initComponentStateListenerTracker(): Modified service: %1", object);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.getFramework().getBundleCxt().getService(serviceReference);
        AppStateManager.access$000(this.this$0).log(1078071040, "AppStateManager.initComponentStateListenerTracker(): Adding service: %1", object);
        if (object instanceof ComponentStateListener) {
            this.this$0.registerComponentStateListener((ComponentStateListener)object);
        } else {
            AppStateManager.access$000(this.this$0).log(10000, "AppStateManager.initComponentStateListenerTracker(): Registered service not an instance of ComponentStateListener: %1", object);
        }
        return object;
    }
}

