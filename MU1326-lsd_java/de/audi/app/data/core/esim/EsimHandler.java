/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.data.core.esim;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.esim.EsimHandler$EsimHandlerDiag;
import de.audi.app.data.core.esim.EsimHandler$OnlineServiceListener;
import de.audi.app.data.core.online.AbstractSimStateListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EsimHandler
extends AbstractDataConfigurationComponent
implements IConnectivityPhoneStateListener,
IRemoteHMIEsimLicenseListener {
    private static final String[] LICENSE_STATES = new String[]{"UNKNOWN_STATE", "TEASER_STATE", "EXPIRED_STATE", "LICENSED_STATE", "NOT_LICENSED_STATE"};
    private static final int INACTIVE;
    private static final int ACTIVE;
    private static final int STATE_NOT_AVAILABLE;
    private static final int STATE_LICENSED;
    private static final int STATE_TRIAL;
    private static final int STATE_EXPIRED;
    private static final int[] ATTRIBUTE_NOTIFICATIONS;
    private static final String HOTSPOT_ESIM_LICENSE_ID;
    private ServiceRegistration serviceRegistration;
    private ServiceRegistration serviceRegistration2;
    private final ChoiceModelApp eSimState;
    private final ChoiceModelApp eSimUsageState;
    private final ChoiceModelApp eSimWifiLicense;
    private final boolean eSimAvailable;
    private volatile int esimLicenseState;
    private volatile boolean eSimActive = false;
    private volatile boolean b2bActive = true;
    private final EsimHandler$OnlineServiceListener oslWlanOverEsim;
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
        this.eSimState = this.getChoiceModel(-668588544);
        this.eSimUsageState = this.getChoiceModel(-601479680);
        this.eSimWifiLicense = this.getChoiceModel(-551148032);
        this.oslWlanOverEsim = new EsimHandler$OnlineServiceListener(this, "hotspotwlan", null);
        this.esimLicenseState = this.getPersistedEsimLicenseState();
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    private void updateLicense(String string, boolean bl) {
        if ("hotspotwlan".equals(string)) {
            this.wifiLicenseAvailable = bl;
            this.updateWifiLicense();
        }
    }

    private void updateStatus() {
        this.log.log(1078071040, "EsimHandler#updateStatus(): available=%1, active=%2", this.eSimAvailable, this.eSimActive);
        this.log.log(1078071040, "EsimHandler#updateStatus(): license=%1, b2b=%2", this.isEsimLicenseAvailable(), this.b2bActive);
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

    @Override
    public void updateLicenseState(int n) {
        if (n > 0 && n <= LICENSE_STATES.length) {
            this.log.log(1078071040, "EsimHandler#updateLicenseState(): %1", (Object)LICENSE_STATES[n - 1]);
            if (n != 1 && n != this.esimLicenseState) {
                this.log.log(1078071040, "EsimHandler#updateLicenseState(): saving licenseState=%1 to persistence", (Object)LICENSE_STATES[n - 1]);
                this.storageManager.setInt(1023, 30, n);
                this.esimLicenseState = n;
            }
        }
        this.updateStatus();
    }

    @Override
    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
        this.log.log(1078071040, "EsimHandler#updateESIMInfo(): ICCID=%1, eSimActive=%2, b2b=%3", (Object)string, (Object)new Boolean(bl), (Object)new Boolean(bl2));
        this.eSimActive = bl;
        this.b2bActive = bl2;
        this.updateStatus();
    }

    @Override
    public void updatePhoneState(int n, int n2) {
    }

    @Override
    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
    }

    @Override
    public void telAppEntered() {
    }

    @Override
    public void telAppLeft() {
    }

    @Override
    public void telUnlockEntered() {
    }

    @Override
    public void telUnlockLeft() {
    }

    @Override
    public void updateConnectedGatewayState(boolean bl) {
    }

    @Override
    public void init() {
        super.init();
        EsimHandler$OnlineServiceListener.access$100(this.oslWlanOverEsim);
        this.serviceRegistration = this.bundleContext.registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = EsimHandler.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
        this.serviceRegistration2 = this.bundleContext.registerService((class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener == null ? (class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener = EsimHandler.class$("de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener")) : class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener).getName(), (Object)this, null);
        this.dataApplication.getDiag().addDiagnosisComponent((IDiagComponent)new EsimHandler$EsimHandlerDiag(this));
    }

    @Override
    public void deinit() {
        EsimHandler$OnlineServiceListener.access$200(this.oslWlanOverEsim);
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

    static /* synthetic */ boolean access$302(EsimHandler esimHandler, boolean bl) {
        esimHandler.eSimActive = bl;
        return esimHandler.eSimActive;
    }

    static /* synthetic */ String[] access$400() {
        return LICENSE_STATES;
    }

    static /* synthetic */ int access$500(EsimHandler esimHandler) {
        return esimHandler.getPersistedEsimLicenseState();
    }

    static /* synthetic */ LogChannel access$600(EsimHandler esimHandler) {
        return esimHandler.log;
    }

    static /* synthetic */ BundleContext access$700(EsimHandler esimHandler) {
        return esimHandler.bundleContext;
    }

    static /* synthetic */ BundleContext access$800(EsimHandler esimHandler) {
        return esimHandler.bundleContext;
    }

    static /* synthetic */ LogChannel access$900(EsimHandler esimHandler) {
        return esimHandler.log;
    }

    static /* synthetic */ LogChannel access$1000(EsimHandler esimHandler) {
        return esimHandler.log;
    }

    static /* synthetic */ void access$1100(EsimHandler esimHandler, String string, boolean bl) {
        esimHandler.updateLicense(string, bl);
    }

    static /* synthetic */ LogChannel access$1200(EsimHandler esimHandler) {
        return esimHandler.log;
    }

    static /* synthetic */ BundleContext access$1300(EsimHandler esimHandler) {
        return esimHandler.bundleContext;
    }

    static {
        ATTRIBUTE_NOTIFICATIONS = new int[0];
    }
}

