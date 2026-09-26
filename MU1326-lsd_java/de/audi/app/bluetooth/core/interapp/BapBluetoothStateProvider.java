/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.interapp;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPBluetoothConnections;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BapBluetoothStateProvider
extends AbstractBluetoothComponent {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{3, 1, 6};
    private final ServiceTracker tracker;
    private CombiBAPServiceConnectivity bapService;
    private final boolean connectionStateSupported;
    private int bluetoothState;
    private int bluetoothVisibility;
    private CombiBAPBluetoothConnections bluetoothConnections = new CombiBAPBluetoothConnections(false, false, false, false);
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity;

    public BapBluetoothStateProvider(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
        this.connectionStateSupported = true;
        this.tracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity = BapBluetoothStateProvider.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity).getName(), (ServiceTrackerCustomizer)this);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void updateBTState(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        switch (n) {
            case 0: {
                this.bluetoothState = 2;
                break;
            }
            case 1: {
                this.bluetoothState = 1;
                break;
            }
            case 2: {
                this.bluetoothState = 5;
                break;
            }
            case 3: {
                this.bluetoothState = 4;
                break;
            }
            case 4: {
                this.bluetoothState = 3;
                break;
            }
            case 5: {
                this.bluetoothState = 0;
                break;
            }
            default: {
                this.bluetoothState = 0;
            }
        }
        this.updateState();
    }

    @Override
    public void updateAccessibleMode(int n, boolean bl, int n2) {
        if (n2 != 1) {
            return;
        }
        this.bluetoothVisibility = bl ? 1 : 0;
        this.updateState();
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n != 1 || trustedDeviceArray == null) {
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
            int n2 = trustedDeviceArray[i2].getActiveServiceTypes();
            bl = (n2 & 4) > 0;
            bl2 = (n2 & 2) > 0;
            bl3 = (n2 & 0x100) > 0;
            bl4 = (n2 & 0x20) > 0;
        }
        this.bluetoothConnections = new CombiBAPBluetoothConnections(bl3, bl2, bl4, bl);
        this.updateState();
    }

    private void updateState() {
        if (this.bapService != null) {
            this.bapService.updateBluetoothConnectionState(this.bluetoothState, this.bluetoothVisibility, this.bluetoothConnections);
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServiceConnectivity) {
            this.bapService = (CombiBAPServiceConnectivity)object;
            this.bapService.updateMobileServiceSupportBluetooth(true);
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

