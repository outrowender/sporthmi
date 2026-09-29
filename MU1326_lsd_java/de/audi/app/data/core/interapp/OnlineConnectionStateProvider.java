/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.interapp;

import de.audi.app.data.core.AbstractDataConnectionComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.interapp.INaviConnectivityStateListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity;
import org.dsi.ifc.networking.DataConnectionStateStruct;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OnlineConnectionStateProvider
extends AbstractDataConnectionComponent {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{1};
    private final ServiceTracker tracker;
    private final ServiceTracker tracker2;
    private CombiBAPServiceConnectivity bapService;
    private INaviConnectivityStateListener naviService;
    private boolean connectionActive;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity;
    static /* synthetic */ Class class$de$audi$atip$interapp$INaviConnectivityStateListener;

    public OnlineConnectionStateProvider(IDataApplication iDataApplication) {
        super(iDataApplication);
        this.tracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity = OnlineConnectionStateProvider.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity).getName(), (ServiceTrackerCustomizer)this);
        this.tracker2 = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$INaviConnectivityStateListener == null ? (class$de$audi$atip$interapp$INaviConnectivityStateListener = OnlineConnectionStateProvider.class$("de.audi.atip.interapp.INaviConnectivityStateListener")) : class$de$audi$atip$interapp$INaviConnectivityStateListener).getName(), (ServiceTrackerCustomizer)this);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
        if (n != 1 || dataConnectionStateStruct == null) {
            return;
        }
        switch (dataConnectionStateStruct.getContextState()) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                this.connectionActive = true;
                break;
            }
            default: {
                this.connectionActive = false;
            }
        }
        this.updateState();
    }

    private void updateState() {
        this.log.log(-2137614336, "OnlineConnectionStateProvider#updateState(): connection active=%1", this.connectionActive);
        if (this.bapService != null) {
            this.bapService.updateDataConnection2Active(this.connectionActive);
        }
        if (this.naviService != null) {
            this.naviService.updateOnlineConnectionState(this.connectionActive);
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.updateState();
            return object;
        }
        if (object instanceof INaviConnectivityStateListener) {
            this.naviService = (INaviConnectivityStateListener)object;
            this.updateState();
            return object;
        }
        return super.addingService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.updateState();
        } else if (object instanceof INaviConnectivityStateListener) {
            this.naviService = (INaviConnectivityStateListener)object;
            this.updateState();
        } else {
            super.modifiedService(serviceReference, object);
        }
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.bundleContext.ungetService(serviceReference);
        } else if (object instanceof INaviConnectivityStateListener) {
            this.naviService = (INaviConnectivityStateListener)object;
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    @Override
    public void init() {
        super.init();
        this.tracker.open();
        this.tracker2.open();
    }

    @Override
    public void deinit() {
        this.tracker.close();
        this.tracker2.close();
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

