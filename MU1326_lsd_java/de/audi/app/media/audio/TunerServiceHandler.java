/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.def.NullTunerService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TunerServiceHandler
extends AbstractMediaTerminalComponent {
    private static final String LOGCLASS = "TunerServiceHandler";
    private final IServiceTracker serviceTracker;
    private volatile TunerService tunerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerService;

    public TunerServiceHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.tunerService = new NullTunerService(this.logger.audio());
        this.serviceTracker = iMediaTerminal.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$TunerService == null ? (class$de$audi$atip$interapp$TunerService = TunerServiceHandler.class$("de.audi.atip.interapp.TunerService")) : class$de$audi$atip$interapp$TunerService, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                TunerServiceHandler.this.tunerService = (TunerService)TunerServiceHandler.this.getTerminal().getServiceManager().getService(serviceReference);
                TunerServiceHandler.this.logger.audio().log(10000000, "[%1.addingService] '%2'", (Object)TunerServiceHandler.LOGCLASS, (Object)TunerServiceHandler.this.tunerService);
                return TunerServiceHandler.this.tunerService;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                TunerServiceHandler.this.logger.audio().log(10000000, "[%1.removedService]", (Object)TunerServiceHandler.LOGCLASS);
                TunerServiceHandler.this.tunerService = new NullTunerService(TunerServiceHandler.this.logger.audio());
                TunerServiceHandler.this.getTerminal().getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
    }

    protected void init() {
        this.logger.audio().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.serviceTracker.open();
    }

    protected void deinit() {
        this.logger.audio().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceTracker.close();
    }

    protected void abortActiveTA() {
        this.logger.audio().log(10000000, "[%1.abortActiveTA]", (Object)LOGCLASS);
        this.tunerService.abortActiveTA();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

