/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.evo.client;

import de.audi.app.connectivity.manager.IConnectivityManager;
import de.audi.app.data.core.online.IOnline;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.client.AbstractTrustedNetworkList;
import de.audi.app.wlan.core.client.Network;
import de.audi.app.wlan.evo.IEvoWlanApplication;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TrustedNetworkList
extends AbstractTrustedNetworkList {
    private final ServiceTracker tracker;
    private IOnline iOnline;
    static /* synthetic */ Class class$de$audi$app$data$core$online$IOnline;

    public TrustedNetworkList(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
        this.tracker = new ServiceTracker(this.bundleContext, (class$de$audi$app$data$core$online$IOnline == null ? (class$de$audi$app$data$core$online$IOnline = TrustedNetworkList.class$("de.audi.app.data.core.online.IOnline")) : class$de$audi$app$data$core$online$IOnline).getName(), (ServiceTrackerCustomizer)this);
    }

    protected void updateTrustedNetworks(Network[] networkArray) {
        IConnectivityManager iConnectivityManager = ((IEvoWlanApplication)this.wlanApplication).getConnectivity().getConnectivityManager();
        if (iConnectivityManager != null) {
            iConnectivityManager.updateTrustedWlanNetworks(networkArray);
        }
        if (this.iOnline != null) {
            this.iOnline.updateTrustedNetworks(networkArray != null && networkArray.length > 0);
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IOnline) {
            this.iOnline = (IOnline)object;
            return object;
        }
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnline) {
            this.iOnline = null;
            this.bundleContext.ungetService(serviceReference);
        }
        super.removedService(serviceReference, object);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnline) {
            this.iOnline = (IOnline)object;
        }
        super.modifiedService(serviceReference, object);
    }

    public void init() {
        super.init();
        this.tracker.open();
    }

    public void deinit() {
        this.tracker.close();
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

