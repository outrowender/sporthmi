/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.mmicombi.IMMICombiDrawerStateSync;
import de.esolutions.hmi.widgets.audi.evo.DrawerFocusManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DrawerFocusManager$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ DrawerFocusManager this$0;

    DrawerFocusManager$1(DrawerFocusManager drawerFocusManager, BundleContext bundleContext) {
        this.this$0 = drawerFocusManager;
        this.val$bundleContext = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        DrawerFocusManager.access$002(this.this$0, (IMMICombiDrawerStateSync)this.val$bundleContext.getService(serviceReference));
        return DrawerFocusManager.access$000(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        DrawerFocusManager.access$002(this.this$0, null);
    }
}

