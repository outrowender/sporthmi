/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.IDomainListener;
import de.audi.atip.startup.AppStateManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AppStateManager$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AppStateManager this$0;

    AppStateManager$1(AppStateManager appStateManager) {
        this.this$0 = appStateManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AppStateManager.access$000(this.this$0).log(1078071040, "AppStateManager.initDomainStateListenerTracker(): Removing service: %1", object);
        if (object instanceof IDomainListener) {
            this.this$0.unregisterDomainStateListener((IDomainListener)object);
        } else {
            AppStateManager.access$000(this.this$0).log(10000, "AppStateManager.initDomainStateListenerTracker(): Removed service not an instance of IDomainListener: %1", object);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        AppStateManager.access$000(this.this$0).log(10000, "AppStateManager.initDomainStateListenerTracker(): Modified service: %1", object);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.getFramework().getBundleCxt().getService(serviceReference);
        AppStateManager.access$000(this.this$0).log(1078071040, "AppStateManager.initDomainStateListenerTracker(): Adding service: %1", object);
        if (object instanceof IDomainListener) {
            this.this$0.registerDomainStateListener((IDomainListener)object);
        } else {
            AppStateManager.access$000(this.this$0).log(10000, "AppStateManager.initDomainStateListenerTracker(): Added service not an instance of IDomainListener: %1", object);
        }
        return object;
    }
}

