/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.PhoneAppHandler;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class PhoneAppHandler$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ PhoneAppHandler this$0;

    PhoneAppHandler$2(PhoneAppHandler phoneAppHandler) {
        this.this$0 = phoneAppHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        PhoneAppHandler.access$000(this.this$0).log(1078071040, "[%1.removedService]", (Object)"PhoneAppHandler");
        if (object instanceof ITerminalModeUpdateListener) {
            PhoneAppHandler.access$000(this.this$0).log(1078071040, "[%1.addingService] removed service", (Object)"PhoneAppHandler");
            PhoneAppHandler.access$400(this.this$0).remove((ITerminalModeUpdateListener)object);
        }
        PhoneAppHandler.access$200(this.this$0).getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = PhoneAppHandler.access$200(this.this$0).getServiceManager().getService(serviceReference);
        if (!(object instanceof ITerminalModeUpdateListener)) {
            PhoneAppHandler.access$000(this.this$0).log(1078071040, "[%1.addingService] unwanted service", (Object)"PhoneAppHandler");
            PhoneAppHandler.access$200(this.this$0).getServiceManager().releaseService(serviceReference);
            return object;
        }
        ITerminalModeUpdateListener iTerminalModeUpdateListener = (ITerminalModeUpdateListener)object;
        iTerminalModeUpdateListener.updateTMVideoFocus(PhoneAppHandler.access$300(this.this$0));
        PhoneAppHandler.access$400(this.this$0).add(iTerminalModeUpdateListener);
        return iTerminalModeUpdateListener;
    }
}

