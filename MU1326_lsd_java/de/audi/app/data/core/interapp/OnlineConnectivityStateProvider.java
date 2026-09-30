/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.interapp;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.interapp.online.IOnlineDataStateListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OnlineConnectivityStateProvider
extends AbstractDataConfigurationComponent {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{3};
    private ServiceTracker tracker;
    private IOnlineDataStateListener online;
    private volatile boolean roamingAllowed;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineDataStateListener;

    public OnlineConnectivityStateProvider(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void updateRoamingState(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1000000, "OnlineConnectivityStateProvider#updateRoamingState(): %1", (long)n);
        this.roamingAllowed = n == 0;
        this.updateState();
    }

    private void updateState() {
        if (this.online != null) {
            this.online.updateRoamingSetting(this.roamingAllowed);
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IOnlineDataStateListener) {
            this.online = (IOnlineDataStateListener)object;
            this.updateState();
            return object;
        }
        return super.addingService(serviceReference);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnlineDataStateListener) {
            this.online = (IOnlineDataStateListener)object;
        } else {
            super.modifiedService(serviceReference, object);
        }
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnlineDataStateListener) {
            this.online = (IOnlineDataStateListener)object;
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    public void init() {
        super.init();
        this.tracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$online$IOnlineDataStateListener == null ? (class$de$audi$atip$interapp$online$IOnlineDataStateListener = OnlineConnectivityStateProvider.class$("de.audi.atip.interapp.online.IOnlineDataStateListener")) : class$de$audi$atip$interapp$online$IOnlineDataStateListener).getName(), (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    public void deinit() {
        this.tracker.close();
        this.tracker = null;
        super.deinit();
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

