/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.connectivity.core.AbstractApplicationComponent;
import de.audi.app.data.core.IDataApplication;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConnection;
import org.dsi.ifc.networking.DSIDataConnectionListener;
import org.dsi.ifc.networking.DataConnectionStateStruct;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractDataConnectionComponent
extends AbstractApplicationComponent
implements ServiceTrackerCustomizer,
DSIDataConnectionListener {
    protected final IDataApplication dataApplication;
    private DSIDataConnection dsiDataConnection;
    private ServiceTracker serviceTracker;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConnection;

    protected AbstractDataConnectionComponent(IDataApplication iDataApplication) {
        super(iDataApplication);
        this.dataApplication = iDataApplication;
    }

    protected abstract int[] getAttributeNotifications();

    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$networking$DSIDataConnection == null ? (class$org$dsi$ifc$networking$DSIDataConnection = AbstractDataConnectionComponent.class$("org.dsi.ifc.networking.DSIDataConnection")) : class$org$dsi$ifc$networking$DSIDataConnection).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void deinit() {
        if (this.dsiDataConnection != null) {
            this.dsiDataConnection.clearNotification(this);
            this.dsiDataConnection = null;
        }
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIDataConnection) {
            this.dsiDataConnection = (DSIDataConnection)object;
            this.dsiDataConnection.setNotification(this.getAttributeNotifications(), (DSIListener)this);
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIDataConnection) {
            this.dsiDataConnection = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIDataConnection) {
            this.dsiDataConnection = (DSIDataConnection)object;
        }
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
    }

    public void updateConnectionStateInformation(ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
    }

    public void updateErrorState(ApplicationErrorStruct applicationErrorStruct, int n) {
    }

    public void forceDisconnectResponse(int n) {
    }

    public void updateRoamingState(int n, int n2) {
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

