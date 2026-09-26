/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.connectivity.core.AbstractApplicationComponent;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractBluetoothComponent
extends AbstractApplicationComponent
implements ServiceTrackerCustomizer,
DSIBluetoothListener {
    protected final IBluetoothApplication bluetoothApplication;
    protected DSIBluetooth dsiBluetooth;
    private ServiceTracker serviceTracker;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;

    protected AbstractBluetoothComponent(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
        this.bluetoothApplication = iBluetoothApplication;
    }

    protected abstract int[] getAttributeNotifications() {
    }

    @Override
    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = AbstractBluetoothComponent.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    @Override
    public void deinit() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.clearNotification(this);
            this.dsiBluetooth = null;
        }
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIBluetooth) {
            this.dsiBluetooth = (DSIBluetooth)object;
            this.dsiBluetooth.setNotification(this.getAttributeNotifications(), (DSIListener)this);
            return object;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIBluetooth) {
            this.dsiBluetooth = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIBluetooth) {
            this.dsiBluetooth = (DSIBluetooth)object;
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseAbortConnectService(int n) {
    }

    @Override
    public void responseAbortInquiry(int n) {
    }

    @Override
    public void responseAcceptIncomingServiceRequest(int n) {
    }

    @Override
    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
    }

    @Override
    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
    }

    @Override
    public void responseDisconnectService(String string, int n, int n2) {
    }

    @Override
    public void responseGetServices(String string, String string2, int n, int n2) {
    }

    @Override
    public void responseInquiry(int n, int n2) {
    }

    @Override
    public void responsePasskeyResponse(String string, String string2, int n) {
    }

    @Override
    public void responseRemoveAuthentication(String string, String string2, int n) {
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
    }

    @Override
    public void responseSetA2DPUserSetting(int n) {
    }

    @Override
    public void responseSetPriorizedDeviceReconnect(int n) {
    }

    @Override
    public void responseSwitchBTState(int n) {
    }

    @Override
    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    @Override
    public void updateAccessibleMode(int n, boolean bl, int n2) {
    }

    @Override
    public void updateBTState(int n, int n2) {
    }

    @Override
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
    }

    @Override
    public void updateHUCandBTHSState(int n, int n2) {
    }

    @Override
    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
    }

    @Override
    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
    }

    @Override
    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    @Override
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
    }

    @Override
    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
    }

    @Override
    public void updateSupportedBTProfiles(int n, int n2) {
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
    }

    @Override
    public void updateUserFriendlyName(String string, int n) {
    }

    @Override
    public void updateA2DPUserSetting(boolean bl, int n) {
    }

    @Override
    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    @Override
    public void serviceRejectNoSupport(String string, String string2) {
    }

    @Override
    public void responseReconnectSuspend(int n) {
    }

    @Override
    public void responseSetAccessibleMode(int n) {
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

