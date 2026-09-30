/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.data.core.esim;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.esim.ServiceFilterBuilder;
import de.audi.app.data.core.online.AbstractSimStateListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.online.IOnlineDataStateListener;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.audi.atip.storage.IStorageAccess;
import de.esolutions.fw.util.commons.StringUtils;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EsimHandler
extends AbstractDataConfigurationComponent
implements IConnectivityPhoneStateListener,
IRemoteHMIEsimLicenseListener {
    private static final String[] LICENSE_STATES = new String[]{"UNKNOWN_STATE", "TEASER_STATE", "EXPIRED_STATE", "LICENSED_STATE", "NOT_LICENSED_STATE"};
    private static final int INACTIVE = 0;
    private static final int ACTIVE = 1;
    private static final int STATE_NOT_AVAILABLE = 0;
    private static final int STATE_LICENSED = 1;
    private static final int STATE_TRIAL = 2;
    private static final int STATE_EXPIRED = 3;
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private static final String HOTSPOT_ESIM_LICENSE_ID = "hotspotwlan";
    private ServiceRegistration serviceRegistration;
    private ServiceRegistration serviceRegistration2;
    private final ChoiceModelApp eSimState;
    private final ChoiceModelApp eSimUsageState;
    private final ChoiceModelApp eSimWifiLicense;
    private final boolean eSimAvailable;
    private volatile int esimLicenseState;
    private volatile boolean eSimActive = false;
    private volatile boolean b2bActive = true;
    private final OnlineServiceListener oslWlanOverEsim;
    private volatile boolean wifiLicenseAvailable = false;
    private final IStorageAccess storageManager;
    private final AbstractSimStateListener simStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineService;

    public EsimHandler(IDataApplication iDataApplication, AbstractSimStateListener abstractSimStateListener) {
        super(iDataApplication);
        this.storageManager = iDataApplication.getFramework().getStorageMgr();
        this.simStateListener = abstractSimStateListener;
        this.eSimAvailable = iDataApplication.getFramework().getSysConstManager().getSysConst(4219) == 1;
        this.eSimState = this.getChoiceModel(2500312);
        this.eSimUsageState = this.getChoiceModel(2500316);
        this.eSimWifiLicense = this.getChoiceModel(2500319);
        this.oslWlanOverEsim = new OnlineServiceListener(HOTSPOT_ESIM_LICENSE_ID);
        this.esimLicenseState = this.getPersistedEsimLicenseState();
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    private void updateLicense(String string, boolean bl) {
        if (HOTSPOT_ESIM_LICENSE_ID.equals(string)) {
            this.wifiLicenseAvailable = bl;
            this.updateWifiLicense();
        }
    }

    private void updateStatus() {
        this.log.log(1000000, "EsimHandler#updateStatus(): available=%1, active=%2", this.eSimAvailable, this.eSimActive);
        this.log.log(1000000, "EsimHandler#updateStatus(): license=%1, b2b=%2", this.isEsimLicenseAvailable(), this.b2bActive);
        this.simStateListener.updateESimLicenseStatus(this.isEsimLicenseAvailable());
        this.eSimState.setValue(this.getStateValue());
        this.eSimUsageState.setValue(this.eSimActive ? 1 : 0);
    }

    private int getStateValue() {
        return this.eSimAvailable ? (this.isEsimLicenseAvailable() ? (this.b2bActive ? 2 : 1) : 3) : 0;
    }

    private void updateWifiLicense() {
        this.eSimWifiLicense.setValue(this.wifiLicenseAvailable ? 1 : 3);
    }

    private int getPersistedEsimLicenseState() {
        return this.storageManager.getInt(1023, 30, 1);
    }

    private boolean isEsimLicenseAvailable() {
        return this.esimLicenseState == 2 || this.esimLicenseState == 4;
    }

    public void updateLicenseState(int n) {
        if (n > 0 && n <= LICENSE_STATES.length) {
            this.log.log(1000000, "EsimHandler#updateLicenseState(): %1", (Object)LICENSE_STATES[n - 1]);
            if (n != 1 && n != this.esimLicenseState) {
                this.log.log(1000000, "EsimHandler#updateLicenseState(): saving licenseState=%1 to persistence", (Object)LICENSE_STATES[n - 1]);
                this.storageManager.setInt(1023, 30, n);
                this.esimLicenseState = n;
            }
        }
        this.updateStatus();
    }

    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
        this.log.log(1000000, "EsimHandler#updateESIMInfo(): ICCID=%1, eSimActive=%2, b2b=%3", (Object)string, (Object)new Boolean(bl), (Object)new Boolean(bl2));
        this.eSimActive = bl;
        this.b2bActive = bl2;
        this.updateStatus();
    }

    public void updatePhoneState(int n, int n2) {
    }

    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
    }

    public void telAppEntered() {
    }

    public void telAppLeft() {
    }

    public void telUnlockEntered() {
    }

    public void telUnlockLeft() {
    }

    public void updateConnectedGatewayState(boolean bl) {
    }

    public void init() {
        super.init();
        this.oslWlanOverEsim.init();
        this.serviceRegistration = this.bundleContext.registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = EsimHandler.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
        this.serviceRegistration2 = this.bundleContext.registerService((class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener == null ? (class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener = EsimHandler.class$("de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener")) : class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener).getName(), (Object)this, null);
        this.dataApplication.getDiag().addDiagnosisComponent((IDiagComponent)new EsimHandlerDiag());
    }

    public void deinit() {
        this.oslWlanOverEsim.deinit();
        this.serviceRegistration.unregister();
        this.serviceRegistration = null;
        this.serviceRegistration2.unregister();
        this.serviceRegistration2 = null;
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

    public class EsimHandlerDiag
    implements IDiagComponent {
        public void cmdUpdateESIMLicenseState(int n, boolean bl) {
            EsimHandler.this.eSimActive = bl;
            EsimHandler.this.updateLicenseState(n);
        }

        public void cmdGetPersistedEsimLicenseState() {
            EsimHandler.this.log.log(1000000, "EsimHandler#cmdGetPersistedEsimLicenseState(): %1", (Object)LICENSE_STATES[EsimHandler.this.getPersistedEsimLicenseState() - 1]);
        }
    }

    private class OnlineServiceListener
    implements ServiceTrackerCustomizer,
    IOnlineServiceListener {
        private final String licenseId;
        private IOnlineService online;
        private ServiceTracker tracker;
        private volatile boolean licenseAvailable = false;

        private OnlineServiceListener(String string) {
            this.licenseId = string;
        }

        private void init() {
            ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
            serviceFilterBuilder.beginAnd();
            serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$online$IOnlineService == null ? (class$de$audi$atip$interapp$online$IOnlineService = EsimHandler.class$("de.audi.atip.interapp.online.IOnlineService")) : class$de$audi$atip$interapp$online$IOnlineService).getName());
            serviceFilterBuilder.addProperty("ONLINE_APP_ID", this.licenseId);
            serviceFilterBuilder.endAnd();
            String string = serviceFilterBuilder.createFilterString();
            try {
                this.tracker = new ServiceTracker(EsimHandler.this.bundleContext, EsimHandler.this.bundleContext.createFilter(string), (ServiceTrackerCustomizer)this);
            }
            catch (InvalidSyntaxException invalidSyntaxException) {
                EsimHandler.this.log.log(100000, "EsimHandler.OnlineServiceListener#init(): %1", (Throwable)invalidSyntaxException);
            }
            this.tracker.open();
        }

        private void deinit() {
            this.tracker.close();
        }

        public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
            int n;
            EsimHandler.this.log.log(1000000, "EsimHandler.OnlineServiceListener#getLicenseInformationResult(): %1", (Object)StringUtils.toString(oSRLicenseArray));
            this.licenseAvailable = oSRLicenseArray != null && oSRLicenseArray.length > 0 ? (n = oSRLicenseArray[0].getState()) == 1 : true;
            EsimHandler.this.updateLicense(this.licenseId, this.licenseAvailable);
        }

        public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
            EsimHandler.this.log.log(1000000, "EsimHandler.OnlineServiceListener#updateApplicationState(): %1", (Object)StringUtils.toString(oSRNotifyPropertiesArray));
        }

        public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        }

        public void activateLicenseResponse(int n) {
        }

        public void getReminderStatusResult(int n) {
        }

        public void setReminderStateResponse(int n) {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = EsimHandler.this.bundleContext.getService(serviceReference);
            if (object instanceof IOnlineService) {
                this.online = (IOnlineService)object;
                this.online.addCallBackListener(this);
                this.online.getLicenseInformation(this);
                return object;
            }
            return null;
        }

        public void modifiedService(ServiceReference serviceReference, Object object) {
            if (object instanceof IOnlineDataStateListener) {
                this.online = (IOnlineService)object;
            }
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            if (object instanceof IOnlineDataStateListener) {
                this.online = null;
            }
        }

        public void updateServiceState(OnlineServiceListState onlineServiceListState) {
        }

        public void getPreCheckResult(OSRServiceState oSRServiceState) {
        }
    }
}

