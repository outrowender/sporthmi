/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.interapp;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BapWlanStateProvider
extends AbstractWlanComponent {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{12, 22, 13};
    private final ServiceTracker tracker;
    private CombiBAPServiceConnectivity bapService;
    private final boolean connectionStateSupported;
    private int wlanState;
    private int wlanVisibility;
    private int wlanConnections;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity;

    public BapWlanStateProvider(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
        this.connectionStateSupported = true;
        this.tracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity = BapWlanStateProvider.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity).getName(), (ServiceTrackerCustomizer)this);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void updateRFActive(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        switch (n) {
            case 1: {
                this.wlanState = 2;
                break;
            }
            case 0: 
            case 2: 
            case 3: {
                this.wlanState = 1;
                break;
            }
            default: {
                this.wlanState = 0;
            }
        }
        this.updateState();
    }

    @Override
    public void updateProfile(Profile profile, int n) {
        if (n != 1) {
            return;
        }
        this.wlanVisibility = profile.isSSIDBroadcast() ? 1 : 0;
        this.updateState();
    }

    @Override
    public void updateNodeList(Node[] nodeArray, int n) {
        if (n != 1) {
            return;
        }
        this.wlanConnections = nodeArray.length;
        this.updateState();
    }

    private void updateState() {
        if (this.bapService != null) {
            this.bapService.updateWLANConnectionState(this.wlanState, this.wlanVisibility, this.wlanConnections);
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.bapService.updateMobileServiceSupportWLAN(true);
            this.updateState();
            return object;
        }
        return super.addingService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
        } else {
            super.modifiedService(serviceReference, object);
        }
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    @Override
    public void init() {
        super.init();
        this.tracker.open();
    }

    @Override
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

