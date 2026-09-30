/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.connectivity.core.AbstractApplicationComponent;
import de.audi.app.wlan.core.IWlanApplication;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractWlanComponent
extends AbstractApplicationComponent
implements ServiceTrackerCustomizer,
DSIWLANListener {
    protected final IWlanApplication wlanApplication;
    protected DSIWLAN dsiWlan;
    private ServiceTracker serviceTracker;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLAN;

    protected AbstractWlanComponent(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
        this.wlanApplication = iWlanApplication;
    }

    protected abstract int[] getAttributeNotifications();

    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = AbstractWlanComponent.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void deinit() {
        if (this.dsiWlan != null) {
            this.dsiWlan.clearNotification(this);
            this.dsiWlan = null;
        }
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIWLAN) {
            this.dsiWlan = (DSIWLAN)object;
            this.dsiWlan.setNotification(this.getAttributeNotifications(), (DSIListener)this);
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIWLAN) {
            this.dsiWlan = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIWLAN) {
            this.dsiWlan = (DSIWLAN)object;
        }
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void responseAbortSearch(int n) {
    }

    public void responseConnectNetwork(String string, String string2, int n) {
    }

    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
    }

    public void responseDisconnectNetwork(String string, String string2, int n) {
    }

    public void responseFactoryReset(int n) {
    }

    public void responseNetworkSearch(int n, int n2) {
    }

    public void responseSetProfile(int n) {
    }

    public void responseSetRFActive(int n) {
    }

    public void responseSetRole(int n) {
    }

    public void responseActivateWps(int n) {
    }

    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
    }

    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
    }

    public void updateNodeList(Node[] nodeArray, int n) {
    }

    public void updateProfile(Profile profile, int n) {
    }

    public void updateRFActive(int n, int n2) {
    }

    public void updateRole(int n, int n2) {
    }

    public void updateStartupState(int n, int n2) {
    }

    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
    }

    public void updateWlanEnabled(boolean bl, int n) {
    }

    public void updateWPSRunning(int n, int n2) {
    }

    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
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

