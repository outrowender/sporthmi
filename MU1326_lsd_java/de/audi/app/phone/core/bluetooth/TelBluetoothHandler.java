/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.bluetooth;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.bluetooth.ITelBluetoothHandler;
import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;
import de.audi.app.phone.core.bluetooth.TelDefaultBluetoothListener;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class TelBluetoothHandler
extends AbstractPhoneComponent
implements ITelBluetoothHandler {
    private static final Map SERVICE_TYPE_STRING_MAPPING = new HashMap();
    private final PhoneServiceProvider dsiBluetoothListenerServiceProvider;
    private final TelDSIBluetoothListener dsiBluetoothListener;
    private final LinkedList listeners = new LinkedList();
    private final DSIBluetoothTracker dsiBluetoothTracker;
    private volatile DSIBluetooth dsiBluetooth;
    private volatile TrustedDevice[] devices;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;

    private static boolean containsServiceType(int n, int n2) {
        return (n2 & n) == n;
    }

    private static String getDeviceSecurityName(int n) {
        switch (n) {
            case 4: {
                return "ENCRYPTED";
            }
            case 0: {
                return "PAIRED";
            }
            case 8: {
                return "STRONG_PASSKEY";
            }
            case 2: {
                return "TRUSTED";
            }
        }
        return "";
    }

    private static String getLinkModeName(int n) {
        switch (n) {
            case 1: {
                return "ACTIVE";
            }
            case 2: {
                return "HOLD";
            }
            case 4: {
                return "PARK";
            }
            case 3: {
                return "SNIFF";
            }
            case 0: {
                return "UNSPECIFIED";
            }
        }
        return "";
    }

    private static String getServiceTypeName(int n) {
        String string = (String)SERVICE_TYPE_STRING_MAPPING.get(new Integer(n));
        if (string == null) {
            string = new StringBuffer().append("unknown service type ").append(n).toString();
        }
        return string;
    }

    private static String getExistingServiceTypeNames(int n) {
        Buffer buffer = new Buffer();
        if (n == -1 || n == 0) {
            buffer.append(TelBluetoothHandler.getServiceTypeName(n));
        } else {
            int n2 = 0;
            int n3 = 0;
            for (int i2 = 0; i2 < 32; ++i2) {
                n2 = n2 == 0 ? 1 : (n2 <<= 1);
                if (!TelBluetoothHandler.containsServiceType(n2, n)) continue;
                if (n3 > 0) {
                    buffer.append('|');
                }
                buffer.append(TelBluetoothHandler.getServiceTypeName(n2));
                ++n3;
            }
        }
        return buffer.toString();
    }

    private static Buffer getTrustedDevicesStringBuffer(TrustedDevice[] trustedDeviceArray) {
        if (trustedDeviceArray != null && trustedDeviceArray.length > 0) {
            Buffer buffer = new Buffer();
            buffer.append("\n");
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                TrustedDevice trustedDevice = trustedDeviceArray[i2];
                buffer.append("TrustedDevice");
                buffer.append('(');
                buffer.append("deviceName");
                buffer.append('=');
                buffer.append('\"');
                buffer.append(trustedDevice.deviceName);
                buffer.append('\"');
                buffer.append(',');
                buffer.append("deviceAddress");
                buffer.append('=');
                buffer.append('\"');
                buffer.append(trustedDevice.deviceAddress);
                buffer.append('\"');
                buffer.append(',');
                buffer.append("deviceRole");
                buffer.append('=');
                buffer.append(trustedDevice.deviceRole);
                buffer.append(',');
                buffer.append("deviceClass");
                buffer.append('=');
                buffer.append(trustedDevice.deviceClass);
                buffer.append(',');
                buffer.append("deviceSecurity");
                buffer.append('=');
                buffer.append(TelBluetoothHandler.getDeviceSecurityName(trustedDevice.deviceSecurity));
                buffer.append(',');
                buffer.append("linkMode");
                buffer.append('=');
                buffer.append(TelBluetoothHandler.getLinkModeName(trustedDevice.linkMode));
                buffer.append(',');
                buffer.append("linkkeyStrength");
                buffer.append('=');
                buffer.append(trustedDevice.linkkeyStrength);
                buffer.append(',');
                buffer.append("lastConnectedServiceTypes");
                buffer.append('=');
                buffer.append(TelBluetoothHandler.getExistingServiceTypeNames(trustedDevice.lastConnectedServiceTypes));
                buffer.append(',');
                buffer.append("activeServiceTypes");
                buffer.append('=');
                buffer.append(TelBluetoothHandler.getExistingServiceTypeNames(trustedDevice.activeServiceTypes));
                buffer.append(',');
                buffer.append("offeredServiceTypes");
                buffer.append('=');
                buffer.append(TelBluetoothHandler.getExistingServiceTypeNames(trustedDevice.offeredServiceTypes));
                buffer.append(')');
                if (i2 >= trustedDeviceArray.length - 1) continue;
                buffer.append("\n");
            }
            return buffer;
        }
        return null;
    }

    public TelBluetoothHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.dsiBluetoothListener = new TelDSIBluetoothListener();
        this.dsiBluetoothTracker = new DSIBluetoothTracker(iTelApplication);
        Hashtable hashtable = new Hashtable(8);
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TelBluetoothHandler.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.dsiBluetoothListenerServiceProvider = new PhoneServiceProvider((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = TelBluetoothHandler.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.dsiBluetoothListener, hashtable, this.getApplication().getBundleContext(), this.log);
        this.addSubPhoneComponent(new DSIBluetoothTracker(iTelApplication));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addBluetoothListener(ITelBluetoothListener iTelBluetoothListener) {
        LinkedList linkedList = this.listeners;
        synchronized (linkedList) {
            this.listeners.add(iTelBluetoothListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeBluetoothListener(ITelBluetoothListener iTelBluetoothListener) {
        LinkedList linkedList = this.listeners;
        synchronized (linkedList) {
            this.listeners.remove(iTelBluetoothListener);
        }
    }

    public void init() {
        this.dsiBluetoothListenerServiceProvider.startService();
        super.init();
        this.getApplication().addDiagnosisComponent(new TelBluetoothDiag());
    }

    public void deinit() {
        super.deinit();
        this.dsiBluetoothListenerServiceProvider.stopService();
        DSIBluetooth dSIBluetooth = this.dsiBluetooth;
        if (dSIBluetooth != null) {
            dSIBluetooth.clearNotification(this.dsiBluetoothListener);
        }
        this.listeners.clear();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ TrustedDevice[] access$502(TelBluetoothHandler telBluetoothHandler, TrustedDevice[] trustedDeviceArray) {
        telBluetoothHandler.devices = trustedDeviceArray;
        return trustedDeviceArray;
    }

    static {
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(65536), "A2DP_AVRCP_SOURCE");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(32768), "A2DP_AVRCP_SINK");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(32), "ADRDL");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(-1), "ALL");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(2048), "BIP");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(256), "DUN_CLIENT");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(512), "DUN_SERVER");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(4096), "FTP");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(1024), "HID");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(0x200000), "MAP");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(0x400000), "MAP2");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(0), "NONE");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(64), "OBJECTPUSH_CLIENT");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(8192), "OBJECTPUSH_SERVER");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(524288), "PAN_GN");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(262144), "PAN_NAP");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(0x100000), "PAN_USER");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(16384), "SPP");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(128), "SYNCML");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(16), "TELEPHONY_HANDSET");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(8), "TELEPHONY_HEADSET");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(2), "TELEPHONY_HFP");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(131072), "TELEPHONY_HFP_HF");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(4), "TELEPHONY_SIMAP");
        SERVICE_TYPE_STRING_MAPPING.put(new Integer(1), "UNSPECIFIED");
    }

    private class TelBluetoothDiag
    implements IPhoneDiagComponent {
        private TelBluetoothDiag() {
        }

        public String getBTTrustedDevices() {
            return TelBluetoothHandler.getTrustedDevicesStringBuffer(TelBluetoothHandler.this.devices).toString();
        }
    }

    private class DSIBluetoothTracker
    extends AbstractTelServiceTracker {
        public DSIBluetoothTracker(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = TelBluetoothHandler.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
        }

        protected void serviceAvailable(Object object) {
            TelBluetoothHandler.this.dsiBluetooth = (DSIBluetooth)object;
            TelBluetoothHandler.this.dsiBluetooth.setNotification(TelBluetoothHandler.this.dsiBluetoothListener);
        }

        protected void serviceRemoved(Object object) {
            TelBluetoothHandler.this.dsiBluetooth = null;
        }
    }

    private class TelDSIBluetoothListener
    extends TelDefaultBluetoothListener {
        private TelDSIBluetoothListener() {
        }

        public void updateTrustedDevices(final TrustedDevice[] trustedDeviceArray, int n) {
            if (n == 1) {
                TelBluetoothHandler.this.getApplication().enqueueEvent(new AbstractTelDSIUpdateEvent("TelDSIBluetoothListener#updateTrustedDevices"){

                    public void run() {
                        TelBluetoothHandler.access$502(TelBluetoothHandler.this, trustedDeviceArray);
                        TelBluetoothHandler.this.log.log(1000000, "[TelBluetoothHandler.TelDSIBluetoothListener#updateTrustedDevices] trustedDevices=%1", (Object)TelBluetoothHandler.getTrustedDevicesStringBuffer(trustedDeviceArray));
                        LinkedList linkedList = (LinkedList)TelBluetoothHandler.this.listeners.clone();
                        Iterator iterator = linkedList.iterator();
                        while (iterator.hasNext()) {
                            ((ITelBluetoothListener)iterator.next()).updateTrustedDevices(trustedDeviceArray);
                        }
                    }
                });
            }
        }
    }
}

