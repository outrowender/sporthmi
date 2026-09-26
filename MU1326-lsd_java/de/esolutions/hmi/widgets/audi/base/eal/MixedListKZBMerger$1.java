/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.event.MergeKZBAsyncEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

final class MixedListKZBMerger$1
implements ServiceTrackerCustomizer {
    MixedListKZBMerger$1() {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference.getBundle().getLocation().equals("HMINavi")) {
            IWidgetLogChannel.mixedListLogChannel.log(-2137614336, "MixedListKZBMerger#startTrackingAndMerge addingService: Post MergeKZBEvent");
            MergeKZBAsyncEvent mergeKZBAsyncEvent = new MergeKZBAsyncEvent(AbstractWidget.hmiService.getRootWindow(0), 255, 17);
            AbstractWidget.hmiService.getEventDispatcher().postEvent(mergeKZBAsyncEvent);
            MixedListKZBMerger.access$000().close();
        }
        return serviceReference;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

