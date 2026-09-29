/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class EALManager$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ EALManager this$0;

    EALManager$1(EALManager eALManager) {
        this.this$0 = eALManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        EALManager.access$602(this.this$0, (IMMICombiAnimationSyncer)EALManager.access$700(this.this$0).getFramework().getBundleCxt().getService(serviceReference));
        return EALManager.access$600(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        EALManager.access$602(this.this$0, null);
    }
}

