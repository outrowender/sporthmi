/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 *  de.mib.swdiagnosis.connectivity.TrustedDevicesDiag
 */
package de.audi.app.bluetooth.core.connectivity.trusted;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.trusted.CommandRemoveAuthentication;
import de.audi.app.bluetooth.core.connectivity.trusted.ITrustedDeviceList;
import de.audi.app.bluetooth.core.interapp.IDataBluetoothStateListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import de.mib.swdiagnosis.connectivity.TrustedDevicesDiag;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractTrustedDeviceList
extends AbstractBluetoothComponent
implements ITrustedDeviceList,
IDiagComponent {
    private final int[] attributeNotifications = new int[]{6};
    private final Map map;
    private final ServiceTracker tracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener == null ? (class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener = AbstractTrustedDeviceList.class$("de.audi.app.bluetooth.core.interapp.IDataBluetoothStateListener")) : class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener).getName()}, (ServiceTrackerCustomizer)this);
    private final LabelModelApp phoneNameLabel;
    private boolean hfpConnected;
    private boolean sapSupported;
    private IDataBluetoothStateListener online;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener;

    protected AbstractTrustedDeviceList(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
        this.map = new HashMap();
        this.phoneNameLabel = this.getLabelModel(2500216);
    }

    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public boolean isConnected(String string) {
        TrustedDevice trustedDevice = (TrustedDevice)this.map.get(string);
        return trustedDevice != null && trustedDevice.getActiveServiceTypes() != 0;
    }

    public void removeAuthentication(String string) {
        ChoiceModelApp choiceModelApp = this.getRemoveAuthenticationCommandMonitor();
        CommandRemoveAuthentication.schedule(this.bluetoothApplication, this.dsiBluetooth, string, choiceModelApp);
    }

    protected ChoiceModelApp getRemoveAuthenticationCommandMonitor() {
        return this.getChoiceModel(0x262655);
    }

    public TrustedDevice get(String string) {
        return (TrustedDevice)this.map.get(string);
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n == 1 && trustedDeviceArray != null) {
            this.log.log(1000000, "AbstractTrustedDeviceList#updateTrustedDevices(): List updated (%1 devices)", (long)trustedDeviceArray.length);
            this.map.clear();
            boolean bl = false;
            boolean bl2 = false;
            String string = "";
            this.log.log(10000000, "AbstractTrustedDeviceList#updateTrustedDevices(): %1", (Object)Converter.array2String(trustedDeviceArray));
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                TrustedDevice trustedDevice = trustedDeviceArray[i2];
                String string2 = trustedDevice.getDeviceAddress();
                this.map.put(string2, trustedDevice);
                this.bluetoothApplication.getDeviceProfileList().updateProfiles(string2);
                this.bluetoothApplication.getDeviceProfileList().updateConnectedProfiles(string2, false);
                if ((trustedDevice.getActiveServiceTypes() & 2) != 0) {
                    bl = true;
                    boolean bl3 = bl2 = bl2 || (trustedDevice.getOfferedServiceTypes() & 4) != 0;
                }
                if ((trustedDevice.getActiveServiceTypes() & 6) == 0) continue;
                string = trustedDevice.getDeviceName();
            }
            this.hfpConnected = bl;
            this.sapSupported = bl2;
            if (this.online != null) {
                this.online.updateHfpConnection(this.hfpConnected, this.sapSupported);
            }
            this.phoneNameLabel.setText(string);
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IDataBluetoothStateListener) {
            this.online = (IDataBluetoothStateListener)object;
            this.online.updateHfpConnection(this.hfpConnected, this.sapSupported);
            return object;
        }
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IDataBluetoothStateListener) {
            this.online = null;
            this.bundleContext.ungetService(serviceReference);
        }
        super.removedService(serviceReference, object);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IDataBluetoothStateListener) {
            this.online = (IDataBluetoothStateListener)object;
        }
        super.modifiedService(serviceReference, object);
    }

    public void init() {
        super.init();
        this.tracker.open();
        this.bluetoothApplication.getDiag().addDiagnosisComponent((IDiagComponent)new TrustedDevicesDiag((ITrustedDeviceList)this));
    }

    public void deinit() {
        this.map.clear();
        this.tracker.close();
        super.deinit();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("=== Trusted Bluetooth devices ===\n");
        Iterator iterator = this.map.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            TrustedDevice trustedDevice = (TrustedDevice)this.map.get(string);
            buffer.append(trustedDevice.getDeviceName());
            buffer.append(" : ");
            buffer.append(string);
            buffer.append(" activeServiceTypes= 0x");
            buffer.append(Integer.toHexString(trustedDevice.activeServiceTypes));
            buffer.append(" offeredServiceTypes= 0x");
            buffer.append(Integer.toHexString(trustedDevice.offeredServiceTypes));
            buffer.append(" lastConnectedServiceTypes= 0x");
            buffer.append(Integer.toHexString(trustedDevice.lastConnectedServiceTypes));
            buffer.append("\n");
        }
        return buffer.toString();
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

