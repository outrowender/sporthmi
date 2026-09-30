/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.evo.client;

import de.audi.app.bluetooth.core.online.IConnectAppSetup;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.client.AbstractWlanConnection;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class WlanConnection
extends AbstractWlanConnection {
    private IConnectAppSetup audiConnectSetup;
    private ServiceTracker serviceTracker;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$online$IConnectAppSetup;

    public WlanConnection(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
        super.updateConnectedNetwork(string, string2, n, n2);
        if (n2 != 1) {
            return;
        }
        if (this.audiConnectSetup != null) {
            this.audiConnectSetup.updateWlanState(!string2.equals(""));
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IConnectAppSetup) {
            this.audiConnectSetup = (IConnectAppSetup)object;
            return object;
        }
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectAppSetup) {
            this.audiConnectSetup = null;
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IConnectAppSetup) {
            this.audiConnectSetup = (IConnectAppSetup)object;
        } else {
            super.modifiedService(serviceReference, object);
        }
    }

    public void init() {
        super.init();
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$app$bluetooth$core$online$IConnectAppSetup == null ? (class$de$audi$app$bluetooth$core$online$IConnectAppSetup = WlanConnection.class$("de.audi.app.bluetooth.core.online.IConnectAppSetup")) : class$de$audi$app$bluetooth$core$online$IConnectAppSetup).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void deinit() {
        this.serviceTracker.close();
        this.serviceTracker = null;
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

