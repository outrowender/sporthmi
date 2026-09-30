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

    protected abstract int[] getAttributeNotifications();

    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = AbstractBluetoothComponent.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void deinit() {
        if (this.dsiBluetooth != null) {
            this.dsiBluetooth.clearNotification(this);
            this.dsiBluetooth = null;
        }
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIBluetooth) {
            this.dsiBluetooth = (DSIBluetooth)object;
            this.dsiBluetooth.setNotification(this.getAttributeNotifications(), (DSIListener)this);
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIBluetooth) {
            this.dsiBluetooth = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DSIBluetooth) {
            this.dsiBluetooth = (DSIBluetooth)object;
        }
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void responseAbortConnectService(int n) {
    }

    public void responseAbortInquiry(int n) {
    }

    public void responseAcceptIncomingServiceRequest(int n) {
    }

    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
    }

    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
    }

    public void responseDisconnectService(String string, int n, int n2) {
    }

    public void responseGetServices(String string, String string2, int n, int n2) {
    }

    public void responseInquiry(int n, int n2) {
    }

    public void responsePasskeyResponse(String string, String string2, int n) {
    }

    public void responseRemoveAuthentication(String string, String string2, int n) {
    }

    public void responseRestoreFactorySettings(int n) {
    }

    public void responseSetA2DPUserSetting(int n) {
    }

    public void responseSetPriorizedDeviceReconnect(int n) {
    }

    public void responseSwitchBTState(int n) {
    }

    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    public void updateAccessibleMode(int n, boolean bl, int n2) {
    }

    public void updateBTState(int n, int n2) {
    }

    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
    }

    public void updateHUCandBTHSState(int n, int n2) {
    }

    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
    }

    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
    }

    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
    }

    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
    }

    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
    }

    public void updateSupportedBTProfiles(int n, int n2) {
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
    }

    public void updateUserFriendlyName(String string, int n) {
    }

    public void updateA2DPUserSetting(boolean bl, int n) {
    }

    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    public void serviceRejectNoSupport(String string, String string2) {
    }

    public void responseReconnectSuspend(int n) {
    }

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

