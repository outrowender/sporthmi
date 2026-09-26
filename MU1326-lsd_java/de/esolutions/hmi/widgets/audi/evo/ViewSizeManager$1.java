/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.interapp.SDSService;
import de.audi.atip.mmicombi.IMMICombiViewSizeSync;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class ViewSizeManager$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ ViewSizeManager val$thisRef;
    private final /* synthetic */ ViewSizeManager this$0;

    ViewSizeManager$1(ViewSizeManager viewSizeManager, BundleContext bundleContext, ViewSizeManager viewSizeManager2) {
        this.this$0 = viewSizeManager;
        this.val$bundleContext = bundleContext;
        this.val$thisRef = viewSizeManager2;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.val$bundleContext.getService(serviceReference);
        if (object instanceof IMMICombiViewSizeSync) {
            ViewSizeManager.access$202(this.this$0, (IMMICombiViewSizeSync)object);
        } else if (object instanceof SDSService) {
            ViewSizeManager.access$302(this.this$0, (SDSService)object);
            ViewSizeManager.access$300(this.this$0).registerStatusListener(this.val$thisRef);
        }
        return ViewSizeManager.access$200(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IMMICombiViewSizeSync) {
            ViewSizeManager.access$202(this.this$0, null);
        } else if (object instanceof SDSService) {
            ViewSizeManager.access$300(this.this$0).unregisterStatusListener(this.val$thisRef);
            ViewSizeManager.access$302(this.this$0, null);
        }
    }
}

