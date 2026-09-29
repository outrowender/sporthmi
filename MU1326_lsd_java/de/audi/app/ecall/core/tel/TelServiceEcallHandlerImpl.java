/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.tel;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.app.ecall.core.tel.ITelServiceEcallHandler;
import de.audi.app.ecall.core.tel.TelServiceEcallHandlerImpl$1;
import de.audi.atip.interapp.phone.ITelServiceEcall;
import de.audi.atip.interapp.phone.ITelServiceEcallListener;
import de.audi.atip.interapp.phone.NullTelServiceEcall;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelServiceEcallHandlerImpl
extends AbstractEcallComponent
implements ServiceTrackerCustomizer,
ITelServiceEcallHandler {
    private final EcallServiceTracker bapServiceEcallTracker;
    private ITelServiceEcall telServiceEcall = new NullTelServiceEcall(this.getLogger());
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceEcall;

    public TelServiceEcallHandlerImpl(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Main");
        this.bapServiceEcallTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$phone$ITelServiceEcall == null ? (class$de$audi$atip$interapp$phone$ITelServiceEcall = TelServiceEcallHandlerImpl.class$("de.audi.atip.interapp.phone.ITelServiceEcall")) : class$de$audi$atip$interapp$phone$ITelServiceEcall).getName(), (ServiceTrackerCustomizer)this, this.log);
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
    public void hangupAllCalls(ITelServiceEcallListener iTelServiceEcallListener) {
        this.log.log(1078071040, "TelServiceEcallHandlerImpl#hangupAllCalls(): called");
        this.telServiceEcall.hangupAllCalls(iTelServiceEcallListener);
    }

    @Override
    public void hangupAllCalls() {
        this.hangupAllCalls(new TelServiceEcallHandlerImpl$1(this));
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof ITelServiceEcall) {
            this.telServiceEcall = (ITelServiceEcall)object;
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
        if (object instanceof ITelServiceEcall) {
            this.telServiceEcall = new NullTelServiceEcall(this.log);
            this.getApplication().getBundleContext().ungetService(serviceReference);
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

    static /* synthetic */ LogChannel access$000(TelServiceEcallHandlerImpl telServiceEcallHandlerImpl) {
        return telServiceEcallHandlerImpl.log;
    }
}

