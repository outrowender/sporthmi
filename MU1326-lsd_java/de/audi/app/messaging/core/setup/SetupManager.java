/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.setup;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.setup.ISetupManagerObserver;
import de.audi.app.messaging.core.setup.SetupManager$1;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class SetupManager
extends AbstractMessagingComponent
implements DSIBluetoothListener {
    private final CopyOnWriteArrayList setupManagerObservers = new CopyOnWriteArrayList();
    private volatile TrustedDevice mapDevice = null;
    private volatile TrustedDevice sapDevice = null;
    private volatile TrustedDevice hfpDevice = null;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;

    public SetupManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.logSystemProperties();
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[SetupManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = SetupManager.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth).getName());
        serviceFilterBuilder.addProperty("DEVICE_INSTANCE", String.valueOf(0));
        serviceFilterBuilder.endAnd();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        SetupManager$1 setupManager$1 = new SetupManager$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)setupManager$1);
    }

    public String getSapDeviceAddress() {
        String string = "";
        if (this.sapDevice != null) {
            string = this.sapDevice.getDeviceAddress();
        }
        return string;
    }

    public String getSapDeviceName() {
        String string = null;
        if (this.sapDevice != null) {
            String string2 = this.sapDevice.getDeviceName();
            string = !Strings.isNullOrEmpty(string2) ? string2 : "";
        }
        return string;
    }

    public String getMapDeviceAddress() {
        String string = "";
        if (this.mapDevice != null) {
            string = this.mapDevice.getDeviceAddress();
        }
        return string;
    }

    public String getMapDeviceName() {
        String string = null;
        if (this.mapDevice != null) {
            String string2 = this.mapDevice.getDeviceName();
            string = !Strings.isNullOrEmpty(string2) ? string2 : "";
        }
        return string;
    }

    public String getHfpDeviceName() {
        String string = null;
        if (this.hfpDevice != null) {
            String string2 = this.hfpDevice.getDeviceName();
            string = !Strings.isNullOrEmpty(string2) ? string2 : "";
        }
        return string;
    }

    public String getImsi() {
        String string = "";
        return string;
    }

    public boolean isSapConnected() {
        return this.sapDevice != null;
    }

    public boolean isMapConnected() {
        return this.mapDevice != null;
    }

    public boolean isSimInserted() {
        return !this.isSapConnected() && !Strings.isNullOrEmpty(this.getImsi());
    }

    private String getMapDeviceName(MessagingAccount messagingAccount) {
        String string = null;
        if (messagingAccount != null && (messagingAccount.getAccountType() == 2 || messagingAccount.getAccountType() == 3)) {
            string = this.getMapDeviceName();
        }
        return string;
    }

    private String getSapDeviceName(MessagingAccount messagingAccount) {
        String string = null;
        if (messagingAccount != null && (messagingAccount.getAccountType() == 1 || messagingAccount.getAccountType() == 3)) {
            string = this.getSapDeviceName();
        }
        return string;
    }

    public boolean isBasedOnBtConnection(MessagingAccount messagingAccount) {
        boolean bl = this.isSapConnected();
        return Accounts.isBasedOnBtConnection(messagingAccount, bl);
    }

    public String getBtDeviceName(MessagingAccount messagingAccount) {
        String string = null;
        if (this.isBasedOnBtConnection(messagingAccount)) {
            String string2 = this.getMapDeviceName(messagingAccount);
            String string3 = this.getSapDeviceName(messagingAccount);
            String string4 = this.getHfpDeviceName();
            if (string2 != null) {
                string = string2;
            } else if (string3 != null) {
                string = string3;
            } else if (messagingAccount.getAccountType() == 2 && string4 != null) {
                string = string4;
            }
        }
        return string;
    }

    private boolean isMapConnected(TrustedDevice trustedDevice) {
        int n = trustedDevice != null ? trustedDevice.getActiveServiceTypes() : 0;
        boolean bl = (n & 0x2000) != 0;
        boolean bl2 = (n & 0x4000) != 0;
        return bl || bl2;
    }

    private boolean isSapConnected(TrustedDevice trustedDevice) {
        return trustedDevice != null && (trustedDevice.getActiveServiceTypes() & 4) != 0;
    }

    private boolean isHfpConnected(TrustedDevice trustedDevice) {
        return trustedDevice != null && (trustedDevice.getActiveServiceTypes() & 2) != 0;
    }

    public void logSystemProperties() {
        if (this.log.isInfo()) {
            boolean bl = this.framework.getSysConst(472) == 1;
            boolean bl2 = this.framework.getSysConst(4004) == 1;
            boolean bl3 = this.framework.getSysConst(4062) == 1;
            boolean bl4 = this.framework.getSysConst(549) == 1;
            boolean bl5 = this.framework.getSysConst(4368) == 1;
            String string = this.huRegionToString(this.framework.getSysConst(442));
            boolean bl6 = this.framework.getSysConst(4306) == 1;
            Buffer buffer = new Buffer();
            buffer.append("[SetupManager#logSystemProperties] ");
            buffer.append("messaging = ").append(bl).append(", ");
            buffer.append("email = ").append(bl2).append(", ");
            buffer.append("messagingTemplateOnly = ").append(bl3).append(", ");
            buffer.append("sdsOnlineDictation = ").append(bl4).append(", ");
            buffer.append("blockContentWhileDriving = ").append(bl5).append(", ");
            buffer.append("huRegion = ").append(string).append(", ");
            buffer.append("isArabicLanguageAvailable = ").append(bl6);
            this.log.log(1078071040, buffer.toString());
        }
    }

    private String huRegionToString(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "EU";
                break;
            }
            case 1: {
                string = "NAR";
                break;
            }
            case 2: {
                string = "CN";
                break;
            }
            case 3: {
                string = "JP";
                break;
            }
            case 4: {
                string = "KOREA";
                break;
            }
            case 5: {
                string = "TAIWAN";
                break;
            }
            case 6: {
                string = "RDW";
                break;
            }
            default: {
                string = String.valueOf(n);
            }
        }
        return string;
    }

    public void addObserver(ISetupManagerObserver iSetupManagerObserver) {
        this.log.log(-2137614336, "[SetupManager#addObserver] observer = %1", (Object)iSetupManagerObserver);
        this.setupManagerObservers.add(iSetupManagerObserver);
    }

    private void emitIndicateConfigurationChanged() {
        this.log.log(-2137614336, "[SetupManager#emitIndicateConfigurationChanged]");
        Iterator iterator = this.setupManagerObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISetupManagerObserver)iterator.next()).indicateConfigurationChanged();
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[SetupManager#emitIndicateConfigurationChanged]");
            }
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
        this.log.log(-2137614336, "[SetupManager#updateTrustedDevices] validFlag = %1", (long)n);
        if (n == 1 && trustedDeviceArray != null) {
            TrustedDevice trustedDevice = null;
            TrustedDevice trustedDevice2 = null;
            TrustedDevice trustedDevice3 = null;
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                TrustedDevice trustedDevice4 = trustedDeviceArray[i2];
                if (trustedDevice == null && this.isMapConnected(trustedDevice4)) {
                    trustedDevice = trustedDevice4;
                }
                if (trustedDevice2 == null && this.isSapConnected(trustedDevice4)) {
                    trustedDevice2 = trustedDevice4;
                }
                if (trustedDevice3 == null && this.isHfpConnected(trustedDevice4)) {
                    trustedDevice3 = trustedDevice4;
                }
                if (trustedDevice != null && trustedDevice2 != null && trustedDevice3 != null) break;
            }
            if (this.log.isInfo()) {
                this.log.log(1078071040, " [SetupManager#updateTrustedDevices] mapDevice = %1, sapDevice = %2, hfpDevice = %3", (Object)trustedDevice, trustedDevice2, trustedDevice3);
            }
            this.mapDevice = trustedDevice;
            this.sapDevice = trustedDevice2;
            this.hfpDevice = trustedDevice3;
            this.emitIndicateConfigurationChanged();
        }
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
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    @Override
    public void responseSetPriorizedDeviceReconnect(int n) {
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

