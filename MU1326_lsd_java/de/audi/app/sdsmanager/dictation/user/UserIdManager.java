/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;
import de.audi.app.sdsmanager.dictation.osgi.AbstractTrackerCustomizer;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceFilterBuilder;
import de.audi.app.sdsmanager.dictation.user.DsiBluetoothEmptyListener;
import de.audi.app.sdsmanager.dictation.user.DsiTelephoneEmptyListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.dsi.ifc.telephone.DSITelephone;
import org.dsi.ifc.telephone.PhoneInformation;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class UserIdManager
extends AbstractDictationComponent {
    private volatile String imsi = "";
    private volatile String mapDeviceAddress = "";
    private volatile String sapDeviceAddress = "";
    private volatile boolean dsiAvailable = false;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSITelephone;

    public UserIdManager(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        dictationComponentManager.getDsiDictationAdapter().addListener(new DsiDictationAdapterListener());
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[UserIdManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginOr();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = UserIdManager.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(0));
        serviceFilterBuilder.endAnd();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$telephone$DSITelephone == null ? (class$org$dsi$ifc$telephone$DSITelephone = UserIdManager.class$("org.dsi.ifc.telephone.DSITelephone")) : class$org$dsi$ifc$telephone$DSITelephone).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(0));
        serviceFilterBuilder.endAnd();
        serviceFilterBuilder.endOr();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        AbstractTrackerCustomizer abstractTrackerCustomizer = new AbstractTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                if (object != null) {
                    if (object instanceof DSIBluetooth) {
                        ((DSIBluetooth)object).setNotification(6, (DSIListener)new DsiBluetoothListener());
                    } else {
                        ((DSITelephone)object).setNotification(20, (DSIListener)new DsiTelephoneListener());
                    }
                }
            }

            public void removeService(ServiceReference serviceReference, Object object) {
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractTrackerCustomizer);
    }

    private void setImsi(String string) {
        String string2;
        this.log.log(10000000, "[UserIdManager#setImsi] pImsi = %1", (Object)String.valueOf(string));
        String string3 = string2 = string == null ? "" : string;
        if (!this.imsi.equals(string2)) {
            this.imsi = string2;
            this.computeAndSetUserId();
        }
    }

    private void setMapDeviceAddress(String string) {
        String string2;
        this.log.log(10000000, "[UserIdManager#setMapDevice] pMapDeviceAddress = %1", (Object)String.valueOf(string));
        String string3 = string2 = string == null ? "" : string;
        if (!this.mapDeviceAddress.equals(string2)) {
            this.mapDeviceAddress = string2;
            this.computeAndSetUserId();
        }
    }

    private void setSapDeviceAddress(String string) {
        String string2;
        this.log.log(10000000, "[UserIdManager#setSapDevice] pSapDeviceAddress = %1", (Object)String.valueOf(string));
        String string3 = string2 = string == null ? "" : string;
        if (!this.sapDeviceAddress.equals(string2)) {
            this.sapDeviceAddress = string2;
            this.computeAndSetUserId();
        }
    }

    private void computeAndSetUserId() {
        this.log.log(10000000, "[UserIdManager#computeAndSetUserId]");
        if (this.dsiAvailable) {
            String string = "";
            if (!DictationUtil.isNullOrEmpty(this.sapDeviceAddress)) {
                string = this.sapDeviceAddress;
            } else if (!DictationUtil.isNullOrEmpty(this.mapDeviceAddress)) {
                string = this.mapDeviceAddress;
            } else if (!DictationUtil.isNullOrEmpty(this.imsi)) {
                string = this.imsi;
            }
            try {
                this.dictationComponentManager.getDsiDictationAdapter().requestSetUserId(string);
            }
            catch (Exception exception) {
                DictationUtil.logException(this.log, exception, "[LanguageManager#setUserId]");
            }
        }
    }

    private static boolean isMapConnected(TrustedDevice trustedDevice) {
        int n = trustedDevice.getActiveServiceTypes();
        boolean bl = (n & 0x200000) != 0;
        boolean bl2 = (n & 0x400000) != 0;
        return bl || bl2;
    }

    private static boolean isSapConnected(TrustedDevice trustedDevice) {
        return (trustedDevice.getActiveServiceTypes() & 4) != 0;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class DsiBluetoothListener
    extends DsiBluetoothEmptyListener {
        private DsiBluetoothListener() {
        }

        public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
            if (n != 1 && UserIdManager.this.log.isInfo()) {
                UserIdManager.this.log.log(1000000, "[UserIdManager#updateTrustedDevices] validFlag = %1", (long)n);
            } else if (n == 1) {
                Object object;
                TrustedDevice trustedDevice = null;
                TrustedDevice trustedDevice2 = null;
                for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                    object = trustedDeviceArray[i2];
                    if (trustedDevice == null && UserIdManager.isMapConnected((TrustedDevice)object)) {
                        trustedDevice = object;
                    }
                    if (trustedDevice2 == null && UserIdManager.isSapConnected((TrustedDevice)object)) {
                        trustedDevice2 = object;
                    }
                    if (trustedDevice != null && trustedDevice2 != null) break;
                }
                if (UserIdManager.this.log.isInfo()) {
                    UserIdManager.this.log.log(1000000, " [UserIdManager#updateTrustedDevices] mapDevice = %1, sapDevice = %2", (Object)trustedDevice, (Object)trustedDevice2);
                }
                String string = trustedDevice != null ? trustedDevice.getDeviceAddress() : null;
                object = trustedDevice2 != null ? trustedDevice2.getDeviceAddress() : null;
                UserIdManager.this.setMapDeviceAddress(string);
                UserIdManager.this.setSapDeviceAddress((String)object);
            }
        }
    }

    private final class DsiTelephoneListener
    extends DsiTelephoneEmptyListener {
        private DsiTelephoneListener() {
        }

        public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
            if (n != 1 && UserIdManager.this.log.isInfo()) {
                UserIdManager.this.log.log(1000000, "[UserIdManager#updatePhoneInformation] validFlag = %1", (long)n);
            } else if (n == 1) {
                String string;
                String string2 = string = phoneInformation != null ? phoneInformation.getImsi() : null;
                if (UserIdManager.this.log.isInfo()) {
                    UserIdManager.this.log.log(1000000, "[UserIdManager#updatePhoneInformation] validFlag = %1, phoneInformation.getImsi() = %2", (Object)String.valueOf(n), (Object)String.valueOf(string));
                }
                UserIdManager.this.setImsi(string);
            }
        }
    }

    private class DsiDictationAdapterListener
    extends DsiDictationAdapterEmptyListener {
        private DsiDictationAdapterListener() {
        }

        public void updateDsiAvailability(boolean bl) {
            UserIdManager.this.log.log(10000000, "[UserIdManager$DsiDictationAdapterListener#updateDsiAvailability] dsiAvailable = %1", bl);
            UserIdManager.this.dsiAvailable = bl;
            if (bl) {
                UserIdManager.this.computeAndSetUserId();
            }
        }
    }
}

