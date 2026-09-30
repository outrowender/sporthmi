/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.obex.core;

import de.audi.app.connectivity.core.AbstractApplicationComponent;
import de.audi.app.obex.core.IObexApplication;
import org.dsi.ifc.bluetooth.DSIObjectPush;
import org.dsi.ifc.bluetooth.DSIObjectPushListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractObjectPushComponent
extends AbstractApplicationComponent
implements ServiceTrackerCustomizer,
DSIObjectPushListener {
    protected DSIObjectPush dsi;
    private ServiceTracker serviceTracker;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObjectPush;

    public AbstractObjectPushComponent(IObexApplication iObexApplication) {
        super(iObexApplication);
    }

    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$bluetooth$DSIObjectPush == null ? (class$org$dsi$ifc$bluetooth$DSIObjectPush = AbstractObjectPushComponent.class$("org.dsi.ifc.bluetooth.DSIObjectPush")) : class$org$dsi$ifc$bluetooth$DSIObjectPush).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void deinit() {
        if (this.dsi != null) {
            this.dsi.clearNotification(this);
            this.dsi = null;
        }
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIObjectPush) {
            this.dsi = (DSIObjectPush)object;
            this.dsi.setNotification(this);
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIObjectPush) {
            this.dsi = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIObjectPush) {
            this.dsi = (DSIObjectPush)object;
        }
    }

    public void asyncException(int n, String string, int n2) {
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

