/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.bap.EcallBapServiceAdapter;
import de.audi.app.ecall.core.bap.IEcallBapServiceAdapter;
import de.audi.app.ecall.core.bap.NullBAPServiceEcall;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcall;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EcallBapServiceAdapterCustomizer
extends AbstractEcallComponent
implements ServiceTrackerCustomizer {
    private final EcallServiceTracker bapServiceEcallTracker;
    private volatile IEcallBapServiceAdapter ecallBapServiceAdapter = new EcallBapServiceAdapter(new NullBAPServiceEcall(this.getLogger()), this.getLogger());
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall;

    public EcallBapServiceAdapterCustomizer(IEcallApplication iEcallApplication, String string) {
        super(iEcallApplication, string);
        this.bapServiceEcallTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall == null ? (class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall = EcallBapServiceAdapterCustomizer.class$("de.audi.atip.interapp.bap.ecall.BAPServiceEcall")) : class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall).getName(), (ServiceTrackerCustomizer)this, this.log);
    }

    @Override
    public void init() {
        this.bapServiceEcallTracker.openTracker();
    }

    @Override
    public void deinit() {
        this.bapServiceEcallTracker.closeTracker();
    }

    @Override
    public IEcallBapServiceAdapter getEcallBapServiceAdapter() {
        return this.ecallBapServiceAdapter;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        this.log.log(-2137614336, "EcallBapServiceAdapterCustomizer#addingService(): service: %1", object);
        if (object instanceof BAPServiceEcall) {
            this.ecallBapServiceAdapter = new EcallBapServiceAdapter((BAPServiceEcall)object, this.log);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof BAPServiceEcall) {
            this.log.log(-2137614336, "EcallBapServiceAdapterCustomizer#removedService(): removing ecall bap service");
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.ecallBapServiceAdapter = new EcallBapServiceAdapter(new NullBAPServiceEcall(this.log), this.log);
        }
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

