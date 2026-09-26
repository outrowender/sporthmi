/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.tghu.hmi.evo.IPartialPopupControllerEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager$1$1;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager$1$2;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AbstractPartialPopupManager$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AbstractPartialPopupManager this$0;

    AbstractPartialPopupManager$1(AbstractPartialPopupManager abstractPartialPopupManager) {
        this.this$0 = abstractPartialPopupManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)this.this$0.bundleContext.getService(serviceReference);
        IWidgetLogChannel.logChannelPopups.log(-2137614336, "PartialPopupManager#addingService reference: %1, ppListener: %2", (Object)serviceReference, (Object)iPartialPopupListener);
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, new AbstractPartialPopupManager$1$1(this, iPartialPopupListener)));
        return iPartialPopupListener;
    }

    private boolean isPartialPopupVisible(int n) {
        for (int i2 = 0; i2 < this.this$0.currentVisiblePopups.length; ++i2) {
            IPartialPopupControllerEvo iPartialPopupControllerEvo = this.this$0.currentVisiblePopups[i2];
            if (iPartialPopupControllerEvo == null || iPartialPopupControllerEvo.getID() != n) continue;
            return true;
        }
        return false;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)this.this$0.bundleContext.getService(serviceReference);
        IWidgetLogChannel.logChannelPopups.log(-2137614336, "PartialPopupManager#removedService reference: %1, ppListener: %2", (Object)serviceReference, (Object)iPartialPopupListener);
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, new AbstractPartialPopupManager$1$2(this, iPartialPopupListener)));
    }

    static /* synthetic */ AbstractPartialPopupManager access$000(AbstractPartialPopupManager$1 abstractPartialPopupManager$1) {
        return abstractPartialPopupManager$1.this$0;
    }

    static /* synthetic */ boolean access$200(AbstractPartialPopupManager$1 abstractPartialPopupManager$1, int n) {
        return abstractPartialPopupManager$1.isPartialPopupVisible(n);
    }
}

