/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractTelBAPPropertyHandler
extends AbstractPhoneComponent
implements ServiceTrackerCustomizer {
    private volatile PhoneServiceTracker bapServiceTracker;
    private volatile IGlobalTelephoneStateStruct telephoneState;
    private volatile Object combiService;

    public AbstractTelBAPPropertyHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.BAP");
    }

    @Override
    public void init() {
        this.bapServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), this.getBAPServiceClazz().getName(), (ServiceTrackerCustomizer)this, this.log);
        this.bapServiceTracker.openTracker();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        if (this.bapServiceTracker != null) {
            this.bapServiceTracker.closeTracker();
            this.bapServiceTracker = null;
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTelBAPPropertyHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "AbstractTelBAPPropertyHandler#addingService service is null");
            return null;
        }
        if (this.getBAPServiceClazz().isInstance(object)) {
            this.setBAPService(object);
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
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTelBAPPropertyHandler#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "AbstractTelBAPPropertyHandler#removedService service is null");
            return;
        }
        if (this.getBAPServiceClazz().isInstance(object)) {
            this.setBAPService(null);
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "AbstractTelBAPPropertyHandler#updateGlobalTelephoneStateProperty stateStruct is null");
            return;
        }
        this.setTelephoneState(iGlobalTelephoneStateStruct);
        if (this.doProcessGlobalTelephoneStateUpdate(n, iGlobalTelephoneStateStruct)) {
            this.update();
        }
    }

    protected IGlobalTelephoneStateStruct getTelephoneState() {
        return this.telephoneState;
    }

    public void setBAPService(Object object) {
        this.combiService = object;
        if (object != null) {
            this.update();
        }
    }

    protected Object getCombiService() {
        return this.combiService;
    }

    protected abstract Class getBAPServiceClazz() {
    }

    protected abstract boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    protected abstract void update() {
    }

    public void setTelephoneState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
    }
}

