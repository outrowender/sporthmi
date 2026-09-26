/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.evo;

import de.audi.app.terminalmode.evo.MMICombiStageListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MMICombiStageListener$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ MMICombiStageListener this$0;

    MMICombiStageListener$1(MMICombiStageListener mMICombiStageListener) {
        this.this$0 = mMICombiStageListener;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        MMICombiStageListener.access$000(this.this$0).releaseService(serviceReference);
        MMICombiStageListener.access$102(this.this$0, null);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = MMICombiStageListener.access$000(this.this$0).getService(serviceReference);
        if (object instanceof IViewSizeManager && object != null) {
            MMICombiStageListener.access$102(this.this$0, (IViewSizeManager)object);
            MMICombiStageListener.access$100(this.this$0).addViewSizeListener(this.this$0);
            this.this$0.viewSizeChanged(MMICombiStageListener.access$100(this.this$0).getCurrentViewSize());
        }
        return object;
    }
}

