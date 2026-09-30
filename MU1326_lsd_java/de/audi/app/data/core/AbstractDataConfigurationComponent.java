/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.connectivity.core.AbstractApplicationComponent;
import de.audi.app.data.core.IDataApplication;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfiguration;
import org.dsi.ifc.networking.DSIDataConfigurationListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractDataConfigurationComponent
extends AbstractApplicationComponent
implements ServiceTrackerCustomizer,
DSIDataConfigurationListener {
    protected final IDataApplication dataApplication;
    protected DSIDataConfiguration dsiDataConfiguration;
    private ServiceTracker serviceTracker;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfiguration;

    protected AbstractDataConfigurationComponent(IDataApplication iDataApplication) {
        super(iDataApplication);
        this.dataApplication = iDataApplication;
    }

    protected abstract int[] getAttributeNotifications();

    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$networking$DSIDataConfiguration == null ? (class$org$dsi$ifc$networking$DSIDataConfiguration = AbstractDataConfigurationComponent.class$("org.dsi.ifc.networking.DSIDataConfiguration")) : class$org$dsi$ifc$networking$DSIDataConfiguration).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void deinit() {
        if (this.dsiDataConfiguration != null) {
            this.dsiDataConfiguration.clearNotification(this);
            this.dsiDataConfiguration = null;
        }
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIDataConfiguration) {
            this.dsiDataConfiguration = (DSIDataConfiguration)object;
            this.dsiDataConfiguration.setNotification(this.getAttributeNotifications(), (DSIListener)this);
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIDataConfiguration) {
            this.dsiDataConfiguration = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIDataConfiguration) {
            this.dsiDataConfiguration = (DSIDataConfiguration)object;
        }
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void acceptDataRequestResponse(int n) {
    }

    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
    }

    public void resetPacketCounterResponse(int n) {
    }

    public void restoreFactorySettingsResponse(int n) {
    }

    public void setConnectionModeResponse(int n) {
    }

    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
    }

    public void setRequestSettingResponse(int n) {
    }

    public void setRoamingStateResponse(int n) {
    }

    public void updateActiveProfile(int n, int n2) {
    }

    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
    }

    public void updateConnectionMode(int n, int n2) {
    }

    public void updateDataRequest(int n, int n2) {
    }

    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
    }

    public void updateRequestSetting(int n, int n2, int n3) {
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

