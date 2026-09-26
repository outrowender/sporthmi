/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.event.RegisterPartialPopupsEvent;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AbstractPartialPopupManager$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AbstractPartialPopupManager this$0;

    AbstractPartialPopupManager$2(AbstractPartialPopupManager abstractPartialPopupManager) {
        this.this$0 = abstractPartialPopupManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        HMIBundle hMIBundle = (HMIBundle)this.this$0.bundleContext.getService(serviceReference);
        AbstractPartialPopupManager.LOGPOPUPS.log(1078071040, "PartialPopupManager#initializeUnboundPartialPopupTracker: addingService HMIBundle: service: %1", (Object)hMIBundle);
        long l = this.this$0.framework.getMonotonicTime();
        IPartialPopupController[] iPartialPopupControllerArray = hMIBundle.getPartialPopupStubs(this.this$0.terminal.getTerminalID());
        if (AbstractPartialPopupManager.LOGPERFORMANCE.isDebug()) {
            long l2 = this.this$0.framework.getMonotonicTime();
            AbstractPartialPopupManager.LOGPERFORMANCE.log(-2137614336, "PartialPopupManager#initializeUnboundPartialPopupTracker getting PartialPopupStubs from bundle %1 took %2ms", (long)hMIBundle.getId(), l2 - l);
        }
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new RegisterPartialPopupsEvent(this.this$0, iPartialPopupControllerArray, true, hMIBundle.getId()));
        return hMIBundle;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        AbstractPartialPopupManager.LOGPOPUPS.log(-2137614336, "PartialPopupManager: modified HMIBundle: service: %1, ignored!", object);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        AbstractPartialPopupManager.LOGPOPUPS.log(1078071040, "PartialPopupManager#initializeUnboundPartialPopupTracker: removedService HMIBundle: service: %1", object);
        long l = this.this$0.framework.getMonotonicTime();
        IPartialPopupController[] iPartialPopupControllerArray = ((HMIBundle)object).getPartialPopupStubs(this.this$0.terminal.getTerminalID());
        if (AbstractPartialPopupManager.LOGPERFORMANCE.isDebug()) {
            long l2 = this.this$0.framework.getMonotonicTime();
            AbstractPartialPopupManager.LOGPERFORMANCE.log(-2137614336, "PartialPopupManager#removedService getting PartialPopupStubs from bundle %1 took %2ms", (long)((HMIBundle)object).getId(), l2 - l);
        }
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new RegisterPartialPopupsEvent(this.this$0, iPartialPopupControllerArray, false, ((HMIBundle)object).getId()));
    }
}

