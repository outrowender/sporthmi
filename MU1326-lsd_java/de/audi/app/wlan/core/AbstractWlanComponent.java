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

    protected abstract int[] getAttributeNotifications() {
    }

    @Override
    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = AbstractWlanComponent.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    @Override
    public void deinit() {
        if (this.dsiWlan != null) {
            this.dsiWlan.clearNotification(this);
            this.dsiWlan = null;
        }
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIWLAN) {
            this.dsiWlan = (DSIWLAN)object;
            this.dsiWlan.setNotification(this.getAttributeNotifications(), (DSIListener)this);
            return object;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIWLAN) {
            this.dsiWlan = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIWLAN) {
            this.dsiWlan = (DSIWLAN)object;
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseAbortSearch(int n) {
    }

    @Override
    public void responseConnectNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseDisconnectNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseFactoryReset(int n) {
    }

    @Override
    public void responseNetworkSearch(int n, int n2) {
    }

    @Override
    public void responseSetProfile(int n) {
    }

    @Override
    public void responseSetRFActive(int n) {
    }

    @Override
    public void responseSetRole(int n) {
    }

    @Override
    public void responseActivateWps(int n) {
    }

    @Override
    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
    }

    @Override
    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
    }

    @Override
    public void updateNodeList(Node[] nodeArray, int n) {
    }

    @Override
    public void updateProfile(Profile profile, int n) {
    }

    @Override
    public void updateRFActive(int n, int n2) {
    }

    @Override
    public void updateRole(int n, int n2) {
    }

    @Override
    public void updateStartupState(int n, int n2) {
    }

    @Override
    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
    }

    @Override
    public void updateWlanEnabled(boolean bl, int n) {
    }

    @Override
    public void updateWPSRunning(int n, int n2) {
    }

    @Override
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

