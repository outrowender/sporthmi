/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.TMInterAppHandler$ActiveDeviceStateListener;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TMInterAppHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$1(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TMInterAppHandler.access$100(this.this$0).log(1078071040, "[%1.removedService]", (Object)"TMInterAppHandler");
        if (object instanceof ITerminalModeUpdateListener) {
            TMInterAppHandler.access$100(this.this$0).log(1078071040, "[%1.removedService] removed service", (Object)"TMInterAppHandler");
            TMInterAppHandler.access$200(this.this$0).remove((ITerminalModeUpdateListener)object);
        }
        TMInterAppHandler.access$300(this.this$0).getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = TMInterAppHandler.access$300(this.this$0).getServiceManager().getService(serviceReference);
        if (!(object instanceof ITerminalModeUpdateListener)) {
            TMInterAppHandler.access$100(this.this$0).log(14808325, "[%1.addingService] unwanted service", (Object)"TMInterAppHandler");
            TMInterAppHandler.access$300(this.this$0).getServiceManager().releaseService(serviceReference);
            return object;
        }
        ITerminalModeUpdateListener iTerminalModeUpdateListener = (ITerminalModeUpdateListener)object;
        TMInterAppHandler.access$200(this.this$0).add(iTerminalModeUpdateListener);
        GList gList = Generics.newArrayList((Object[])new ITerminalModeUpdateListener[]{iTerminalModeUpdateListener});
        if (null != TMInterAppHandler.access$400(this.this$0)) {
            TMInterAppHandler.access$500(this.this$0, gList, TMInterAppHandler.access$400(this.this$0));
        }
        if (null != TMInterAppHandler.access$600(this.this$0)) {
            TMInterAppHandler.access$700(this.this$0, gList, TMInterAppHandler.access$600(this.this$0));
        }
        iTerminalModeUpdateListener.updateActiveDeviceState(TMInterAppHandler$ActiveDeviceStateListener.access$900(TMInterAppHandler.access$800(this.this$0)));
        return iTerminalModeUpdateListener;
    }
}

