/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.bluetooth.core.interapp.IDataBluetoothStateListener;
import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.ServiceRegistration;

public class AbstractSimStateListener
implements IApplicationComponent,
IConnectivityPhoneStateListener,
IDataBluetoothStateListener {
    static final int SIM_STATE_OK;
    static final int SIM_STATE_NA_DATA_ONLY;
    static final int SIM_STATE_NA;
    static final int SIM_STATE_SAP_NA;
    static final int SIM_STATE_SAP;
    static final int SIM_STATE_PIN_REQUIRED;
    static final int SIM_STATE_PUK_REQUIRED;
    static final int SIM_STATE_PUK_BLOCKED;
    static final int SIM_STATE_FAILURE;
    static final int SIM_STATE_NAD_OFF;
    static final int SIM_STATE_GSM_CALL_ACTIVE;
    static final int SIM_STATE_PENDING_DATA_ONLY;
    static final int SIM_STATE_PENDING;
    private static final String[] SIM_STATE_NAMES;
    private final LogChannel log;
    private final IDataApplication dataApplication;
    private ServiceRegistration registration1;
    private ServiceRegistration registration2;
    private final ChoiceModelApp simStateChoice;
    private int simState = -1;
    private volatile boolean phoneModuleOff;
    private volatile boolean isNadModeDataOnly;
    private volatile ITelMESlotState dataDevice;
    private volatile int profileState = -1;
    private volatile boolean hfpConnected;
    private volatile boolean sapSupported;
    private volatile boolean phoneModuleNotAvailable;
    private volatile boolean eSimActive;
    private volatile boolean esimLicenseAvailable;
    private volatile boolean phoneModuleIsCurrentlyTurningOnOrOff;
    private final int eSIMUsage;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;
    static /* synthetic */ Class class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener;

    public AbstractSimStateListener(IDataApplication iDataApplication, IHMIServiceApp iHMIServiceApp) {
        this.dataApplication = iDataApplication;
        this.log = iDataApplication.getLogChannel();
        this.simStateChoice = iHMIServiceApp.getChoiceModel(925246976);
        this.eSIMUsage = iDataApplication.getFramework().getSysConstManager().getAdaptationANP().getESIMUUsage();
    }

    @Override
    public void telAppEntered() {
        this.dataApplication.getOnline().telAppEntered();
    }

    @Override
    public void telAppLeft() {
        this.dataApplication.getOnline().telAppLeft();
    }

    @Override
    public void telUnlockEntered() {
        this.dataApplication.getOnline().telUnlockEntered();
    }

    @Override
    public void telUnlockLeft() {
        this.dataApplication.getOnline().telUnlockLeft();
    }

    @Override
    public void updatePhoneState(int n, int n2) {
        this.log.log(-2137614336, "AbstractSimStateListener#updatePhoneState(): nadMode=%1, phoneModuleState=%2", (long)n, (long)n2);
        boolean bl = n == 2;
        boolean bl2 = bl != this.isNadModeDataOnly;
        this.isNadModeDataOnly = bl;
        this.phoneModuleIsCurrentlyTurningOnOrOff = n2 == 8 || n2 == 7;
        this.phoneModuleOff = n2 == 3;
        this.phoneModuleNotAvailable = n2 == 0;
        this.updateSimState(bl2);
    }

    @Override
    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        this.log.log(-2137614336, "AbstractSimStateListener#updateMESlotInfo(): %1 %2 %3", (Object)iTelMESlotState, (Object)iTelMESlotState2, (Object)iTelMESlotState3);
        if (iTelMESlotState3 != null && iTelMESlotState3.getTelMode() != 3) {
            this.dataDevice = iTelMESlotState3;
            this.updateSimState(false);
        }
    }

    @Override
    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
        this.log.log(-2137614336, "AbstractSimStateListener#updateESIMInfo(): eSimActive=%1", bl);
        this.eSimActive = bl;
        this.updateSimState(false);
    }

    @Override
    public void updateConnectedGatewayState(boolean bl) {
    }

    public void updateESimLicenseStatus(boolean bl) {
        this.log.log(-2137614336, "AbstractSimStateListener#updateESimLicenseStatus(): esimLicenseAvailable=%1", bl);
        this.esimLicenseAvailable = bl;
        this.updateSimState(false);
    }

    public void updateProfileState(int n) {
        this.profileState = n;
        this.updateSimState(false);
    }

    @Override
    public void updateHfpConnection(boolean bl, boolean bl2) {
        this.log.log(1078071040, "AbstractSimStateListener#updateHfpConnection(): connected=%1, sapSupported=%2", bl, bl2);
        this.hfpConnected = bl;
        this.sapSupported = bl2;
        this.updateSimState(false);
    }

    private void updateSimState(boolean bl) {
        boolean bl2 = this.isESimCodedAndActiveAndLicensed();
        int n = this.computeNewSimState(bl2);
        this.dataApplication.getDataProfile().esimActiveCheckIfisProfileStateAvailable(bl2);
        if (n != this.simState || bl) {
            this.log.log(1078071040, new StringBuffer().append("AbstractSimStateListener#isESimCodedAndActiveAndLicensed(): eSIMUsage: ").append(this.eSIMUsage).append(", eSimActive: %1, esimLicenseAvailable=%2").toString(), this.eSimActive, this.esimLicenseAvailable);
            this.log.log(1078071040, "AbstractSimStateListener#updateSimState(): old: %1, new: %2, isNadModeUpdate=%3", (Object)(this.simState >= 0 ? SIM_STATE_NAMES[this.simState] : ""), (Object)SIM_STATE_NAMES[n], (Object)bl);
            this.simState = n;
            this.simStateChoice.setValue(this.simState);
            if (this.dataDevice != null) {
                this.dataApplication.getOnline().updateSimState(this.simState, this.isNadModeDataOnly, this.dataDevice.isPhoneOn(), bl2);
                this.dataApplication.getDataProfile().updateSimState(this.simState == 0, this.dataDevice.isPhoneOn(), this.dataDevice.isUnlocked());
            }
        }
    }

    public boolean isESimCodedAndActiveAndLicensed() {
        boolean bl;
        switch (this.eSIMUsage) {
            case 1: {
                bl = false;
                break;
            }
            case 0: {
                bl = this.eSimActive && this.esimLicenseAvailable;
                break;
            }
            case 2: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private int computeNewSimState(boolean bl) {
        int n = this.phoneModuleNotAvailable ? 0 : (this.phoneModuleIsCurrentlyTurningOnOrOff ? this.returnSimPending() : (this.phoneModuleOff ? 9 : (bl ? 0 : (this.isNadModeDataOnly ? this.getDataSimState() : this.getVoiceSimState()))));
        return n;
    }

    private int getDataSimState() {
        int n = 1;
        if (this.dataDevice != null) {
            if (this.dataDevice.isPhoneOn() || this.dataDevice.getActivationState() == 9) {
                n = this.getSimLockState();
            } else if (this.isSimStatePending()) {
                n = 11;
            }
        }
        return n;
    }

    private int getVoiceSimState() {
        int n = 2;
        if (this.dataDevice != null) {
            if (this.dataDevice.isPhoneOn() || this.dataDevice.getActivationState() == 9) {
                n = this.dataDevice.isGsmCallActive() ? 10 : this.getSimLockState();
            } else if (this.isSimStatePending()) {
                n = 12;
            }
        } else if (this.hfpConnected) {
            n = this.sapSupported ? 4 : 3;
        }
        return n;
    }

    private boolean isSimStatePending() {
        return this.dataDevice != null && (this.dataDevice.getActivationState() == 7 || this.dataDevice.getActivationState() == 0);
    }

    private int getSimLockState() {
        int n;
        int n2 = this.simState;
        int n3 = n = this.dataDevice != null ? this.dataDevice.getLockState() : 0;
        if (n == 2) {
            n2 = this.checkProfileState();
        } else if (n == 3) {
            n2 = 5;
        } else if (n == 5) {
            n2 = 6;
        } else if (n == 7) {
            n2 = 7;
        } else if (n == 11) {
            n2 = 8;
        } else if (n == 1) {
            this.log.log(-2137614336, "AbstractSimStateListener#checkLockState(): unlock in progress, waiting for result, doing nothing");
        } else {
            this.log.log(-1601830656, "AbstractSimStateListener#checkLockState(): Unhandled SIM lock state: %1", (long)n);
        }
        return n2;
    }

    private int checkProfileState() {
        return this.isInvalidProfile() ? this.returnSimPending() : 0;
    }

    private int returnSimPending() {
        return this.isNadModeDataOnly ? 11 : 12;
    }

    private boolean isInvalidProfile() {
        return this.profileState == -1;
    }

    @Override
    public void init() {
        this.registration1 = this.dataApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = AbstractSimStateListener.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
        this.registration2 = this.dataApplication.getBundleContext().registerService((class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener == null ? (class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener = AbstractSimStateListener.class$("de.audi.app.bluetooth.core.interapp.IDataBluetoothStateListener")) : class$de$audi$app$bluetooth$core$interapp$IDataBluetoothStateListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.registration1.unregister();
        this.registration2.unregister();
        this.registration1 = null;
        this.registration2 = null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SIM_STATE_NAMES = new String[]{"SIM_STATE_OK", "SIM_STATE_NA_DATA_ONLY", "SIM_STATE_NA", "SIM_STATE_SAP_NA", "SIM_STATE_SAP", "SIM_STATE_PIN_REQUIRED", "SIM_STATE_PUK_REQUIRED", "SIM_STATE_PUK_BLOCKED", "SIM_STATE_FAILURE", "SIM_STATE_NAD_OFF", "SIM_STATE_GSM_CALL_ACTIVE", "SIM_STATE_PENDING_DATA_ONLY", "SIM_STATE_PENDING"};
    }
}

