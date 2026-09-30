/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.sds;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.app.ecall.core.sds.SDSHandler;
import de.audi.atip.interapp.AbstractSDSService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.def.NullSDSService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EcallSDSHandler
extends AbstractEcallComponent
implements SDSHandler,
ServiceTrackerCustomizer {
    private volatile EcallServiceTracker sdsPhoneServiceListenerTracker;
    private volatile SDSService sdsService;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public EcallSDSHandler(IEcallApplication iEcallApplication, String string) {
        super(iEcallApplication, string);
        this.sdsPhoneServiceListenerTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = EcallSDSHandler.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.sdsService = new NullSDSService(this.getLogger());
    }

    public void init() {
        this.sdsPhoneServiceListenerTracker.openTracker();
    }

    public void deinit() {
        this.sdsPhoneServiceListenerTracker.closeTracker();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof SDSService) {
            this.sdsService = (SDSService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof AbstractSDSService) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.sdsService = new NullSDSService(this.getLogger());
        }
    }

    public void enablePTT() {
        this.log.log(1000000, "EcallSDSHandler#enablePTT(): called");
        this.sdsService.disablePTT(false, true, (byte)3);
    }

    public void disablePTT() {
        this.log.log(1000000, "EcallSDSHandler#disablePTT(): called");
        this.sdsService.disablePTT(true, true, (byte)3);
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

