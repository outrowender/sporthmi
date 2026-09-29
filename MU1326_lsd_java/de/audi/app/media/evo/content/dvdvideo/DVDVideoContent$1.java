/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.evo.content.dvdvideo.DVDVideoContent;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DVDVideoContent$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ DVDVideoContent this$0;

    DVDVideoContent$1(DVDVideoContent dVDVideoContent) {
        this.this$0 = dVDVideoContent;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        DVDVideoContent.access$000(this.this$0).main().log(1078071040, "[%1.removedService]", (Object)"DVDVideoContent");
        DVDVideoContent.access$102(this.this$0, null);
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
        DVDVideoContent.access$200(this.this$0).setDisplayManagerService(null);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.this$0.getTerminal().getServiceManager().getService(serviceReference);
        if (!(object instanceof IDisplayManagerService)) {
            DVDVideoContent.access$300(this.this$0).main().log(1078071040, "[%1.addingService] unwanted service", (Object)"DVDVideoContent");
            this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
            return object;
        }
        DVDVideoContent.access$102(this.this$0, (IDisplayManagerService)object);
        DVDVideoContent.access$200(this.this$0).setDisplayManagerService(DVDVideoContent.access$100(this.this$0));
        if (DVDVideoContent.access$400(this.this$0)) {
            DVDVideoContent.access$100(this.this$0).activateComponent(34);
        }
        return object;
    }
}

