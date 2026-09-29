/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.osgi.IServiceRegistry;
import de.audi.app.sdsmanager.dictation.osgi.ServiceFilterBuilder;
import de.audi.app.sdsmanager.dictation.user.UserIdManager$1;
import de.audi.app.sdsmanager.dictation.user.UserIdManager$DsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.Filter;
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

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        dictationComponentManager.getDsiDictationAdapter().addListener(new UserIdManager$DsiDictationAdapterListener(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[UserIdManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
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
        UserIdManager$1 userIdManager$1 = new UserIdManager$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)userIdManager$1);
    }

    private void setImsi(String string) {
        String string2;
        this.log.log(-2137614336, "[UserIdManager#setImsi] pImsi = %1", (Object)String.valueOf(string));
        String string3 = string2 = string == null ? "" : string;
        if (!this.imsi.equals(string2)) {
            this.imsi = string2;
            this.computeAndSetUserId();
        }
    }

    private void setMapDeviceAddress(String string) {
        String string2;
        this.log.log(-2137614336, "[UserIdManager#setMapDevice] pMapDeviceAddress = %1", (Object)String.valueOf(string));
        String string3 = string2 = string == null ? "" : string;
        if (!this.mapDeviceAddress.equals(string2)) {
            this.mapDeviceAddress = string2;
            this.computeAndSetUserId();
        }
    }

    private void setSapDeviceAddress(String string) {
        String string2;
        this.log.log(-2137614336, "[UserIdManager#setSapDevice] pSapDeviceAddress = %1", (Object)String.valueOf(string));
        String string3 = string2 = string == null ? "" : string;
        if (!this.sapDeviceAddress.equals(string2)) {
            this.sapDeviceAddress = string2;
            this.computeAndSetUserId();
        }
    }

    private void computeAndSetUserId() {
        this.log.log(-2137614336, "[UserIdManager#computeAndSetUserId]");
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
        boolean bl = (n & 0x2000) != 0;
        boolean bl2 = (n & 0x4000) != 0;
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

    static /* synthetic */ LogChannel access$301(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ boolean access$402(UserIdManager userIdManager, boolean bl) {
        userIdManager.dsiAvailable = bl;
        return userIdManager.dsiAvailable;
    }

    static /* synthetic */ void access$500(UserIdManager userIdManager) {
        userIdManager.computeAndSetUserId();
    }

    static /* synthetic */ LogChannel access$600(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ LogChannel access$700(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ boolean access$800(TrustedDevice trustedDevice) {
        return UserIdManager.isMapConnected(trustedDevice);
    }

    static /* synthetic */ boolean access$900(TrustedDevice trustedDevice) {
        return UserIdManager.isSapConnected(trustedDevice);
    }

    static /* synthetic */ LogChannel access$1000(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ LogChannel access$1100(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ void access$1200(UserIdManager userIdManager, String string) {
        userIdManager.setMapDeviceAddress(string);
    }

    static /* synthetic */ void access$1300(UserIdManager userIdManager, String string) {
        userIdManager.setSapDeviceAddress(string);
    }

    static /* synthetic */ LogChannel access$1400(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ LogChannel access$1500(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ LogChannel access$1600(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ LogChannel access$1700(UserIdManager userIdManager) {
        return userIdManager.log;
    }

    static /* synthetic */ void access$1800(UserIdManager userIdManager, String string) {
        userIdManager.setImsi(string);
    }
}

