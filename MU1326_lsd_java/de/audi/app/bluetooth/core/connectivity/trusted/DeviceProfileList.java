/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.trusted;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.trusted.IDeviceProfileList;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceRegistration;

public class DeviceProfileList
extends AbstractBluetoothComponent
implements IDeviceProfileList,
BaseListModelListener,
IConnectivityPhoneStateListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private static final int PROFILE_NOT_OFFERED = 0;
    private static final int PROFILE_DISCONNECTED = 1;
    private static final int PROFILE_CONNECTED = 2;
    private static final int DISCONNECTED = 0;
    protected static final int CONNECTED = 1;
    private static final int DISABLED = 0;
    private static final int ENABLED = 1;
    private static final int ENABLED_AND_CONNECTED = 2;
    protected static final int COL_DEVICE_SSID = 0;
    protected static final int COL_PROFILE = 1;
    private static final int COL_ENABLED = 2;
    protected static final int COL_CONNECTED = 3;
    private static final int COL_LAST_CONNECTED = 4;
    private static final int COL_ENABLE_AND_CONNECT = 5;
    private static final int NUM_COLUMNS = 6;
    protected static final int INDEX_SIMAP = 0;
    protected static final int INDEX_HFP = 1;
    protected static final int INDEX_MAP = 2;
    protected static final int INDEX_ADRDL = 3;
    private static final int[] PROFILE_CATEGORIES = new int[]{4, 2, 0x600000, 32, 65536};
    private final ChoiceModelApp[] profileStatus;
    private BaseListModelApp deviceProfilesList = this.getBaseListModel(0x262669);
    private ChoiceModelApp connectActionChoice = this.getChoiceModel(2500184);
    private ServiceRegistration serviceRegistration;
    private String currentDevice = "";
    private String currentBondingDevice = "";
    private boolean isCallActive;
    private boolean isNadModeVoiceAndData;
    private boolean isSimInserted;
    private boolean isPhoneRolePrimary = true;
    private boolean isAnyEorBCallActive;
    private boolean isPrimaryPhoneConnected;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;

    public DeviceProfileList(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
        ChoiceModelApp choiceModelApp = this.getChoiceModel(2500191);
        ChoiceModelApp choiceModelApp2 = this.getChoiceModel(2500189);
        ChoiceModelApp choiceModelApp3 = this.getChoiceModel(2500190);
        ChoiceModelApp choiceModelApp4 = this.getChoiceModel(2500188);
        ChoiceModelApp choiceModelApp5 = this.getChoiceModel(2500187);
        this.profileStatus = new ChoiceModelApp[]{choiceModelApp, choiceModelApp2, choiceModelApp3, choiceModelApp4, choiceModelApp5};
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        this.log.log(10000000, "DeviceProfileList#updateMESlotInfo(): %1 %2 %3", (Object)iTelMESlotState, (Object)iTelMESlotState2, (Object)iTelMESlotState3);
        this.isSimInserted = iTelMESlotState3 != null && iTelMESlotState3.isInternalSim() && iTelMESlotState3.isDevicePossiblyAvailable();
        this.isCallActive = iTelMESlotState != null && iTelMESlotState.isCallActive() || iTelMESlotState2 != null && iTelMESlotState2.isCallActive();
        this.isPrimaryPhoneConnected = iTelMESlotState != null && iTelMESlotState.getActivationState() == 5 && iTelMESlotState.getLockState() == 2;
        this.updateProfiles();
    }

    public void updatePhoneState(int n, int n2) {
        this.isNadModeVoiceAndData = n == 1;
        this.updateProfiles();
    }

    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
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
        if (this.isAnyEorBCallActive != bl) {
            this.isAnyEorBCallActive = bl;
            this.updateProfiles();
        }
    }

    public void updateConnectedProfiles(String string, boolean bl) {
        if (bl) {
            this.currentBondingDevice = string;
        }
        TrustedDevice trustedDevice = this.bluetoothApplication.getTrustedDeviceList().get(string);
        this.log.log(1000000, "DeviceProfileList#updateConnectedProfiles(): current bonding device=%1, %2", (Object)this.currentBondingDevice, (Object)trustedDevice);
        if (trustedDevice != null && trustedDevice.getDeviceAddress().equals(this.currentBondingDevice)) {
            this.updateModels(trustedDevice.getOfferedServiceTypes(), trustedDevice.getActiveServiceTypes());
        }
    }

    private void updateModels(int n, int n2) {
        for (int i2 = 0; i2 < PROFILE_CATEGORIES.length; ++i2) {
            boolean bl;
            ChoiceModelApp choiceModelApp = this.profileStatus[i2];
            boolean bl2 = (n & PROFILE_CATEGORIES[i2]) != 0;
            boolean bl3 = bl = (n2 & PROFILE_CATEGORIES[i2]) != 0;
            if (bl2) {
                if (bl) {
                    choiceModelApp.setValue(2);
                    continue;
                }
                choiceModelApp.setValue(1);
                continue;
            }
            choiceModelApp.setValue(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void showProfiles(String string) {
        this.currentDevice = string;
        TrustedDevice trustedDevice = this.bluetoothApplication.getTrustedDeviceList().get(string);
        this.log.log(1000000, "DeviceProfileList#showProfiles(): %1", (Object)trustedDevice);
        if (trustedDevice == null) {
            this.log.log(10000, "DeviceProfileList#showProfiles(): device not found %1", (Object)string);
            return;
        }
        BaseListModelApp baseListModelApp = this.deviceProfilesList;
        synchronized (baseListModelApp) {
            int n = trustedDevice.getActiveServiceTypes();
            int n2 = trustedDevice.getLastConnectedServiceTypes();
            int n3 = this.bluetoothApplication.getSupportedBtProfiles().getConnectableServices(6, true);
            ModelGroup modelGroup = new ModelGroup();
            modelGroup.add(this.deviceProfilesList);
            this.deviceProfilesList.removeAll();
            for (int i2 = 0; i2 < PROFILE_CATEGORIES.length; ++i2) {
                boolean bl;
                int n4 = trustedDevice.offeredServiceTypes & PROFILE_CATEGORIES[i2];
                boolean bl2 = (n & n4) != 0;
                boolean bl3 = bl = (n2 & n4) != 0;
                if (n4 == 0) continue;
                boolean bl4 = true;
                if (this.isCallActive && (i2 == 1 || i2 == 0) || this.isAnyEorBCallActive) {
                    this.log.log(10000000, "DeviceProfileList#showProfiles(): (isCallActive AND category is HFP or SIMAP) OR (Bcall or Ecall active)");
                    bl4 = false;
                }
                if (this.isOfficeRowDisabled(n, i2)) {
                    this.log.log(10000000, "DeviceProfileList#showProfiles(): isOfficeRowDisabled");
                    bl4 = false;
                }
                if ((n4 & n3) == 0) {
                    this.log.log(10000000, "DeviceProfileList#showProfiles(): supportedProfiles");
                    bl4 = false;
                }
                bl4 = this.checkPrimaryAssociatedProfileActivationRules(i2, n, bl4);
                EvoListRow evoListRow = this.createListRow(string, i2, bl4, bl2, bl);
                this.deviceProfilesList.append(evoListRow);
            }
            modelGroup.flush();
        }
    }

    public void setPhoneRole(boolean bl) {
        this.isPhoneRolePrimary = bl;
    }

    protected boolean isOfficeRowDisabled(int n, int n2) {
        boolean bl = n2 == 3 || n2 == 2;
        return bl && !this.isVoiceSimInserted() && !DeviceProfileList.isPhoneConnectedWithoutService(n, PROFILE_CATEGORIES[n2]);
    }

    protected boolean isVoiceSimInserted() {
        return this.isNadModeVoiceAndData && this.isSimInserted;
    }

    private boolean checkPrimaryAssociatedProfileActivationRules(int n, int n2, boolean bl) {
        boolean bl2;
        boolean bl3 = bl;
        boolean bl4 = bl2 = this.bluetoothApplication.getFramework().getSysConstManager().getSysConst(4168) == 7 || this.bluetoothApplication.getFramework().getSysConstManager().getSysConst(4168) == 5;
        if (!(this.isPhoneRolePrimary || this.isPrimaryPhoneConnected || bl2)) {
            if (n == 1 && (n2 & PROFILE_CATEGORIES[n]) == 0) {
                this.log.log(10000000, "DeviceProfileList#showProfiles(): associated device and ...");
                bl3 = false;
            } else if (n == 0 && (n2 & PROFILE_CATEGORIES[n]) == 0) {
                this.log.log(10000000, "DeviceProfileList#showProfiles(): associated device and ...");
                bl3 = false;
            }
        }
        return bl3;
    }

    private static boolean isPhoneConnectedWithoutService(int n, int n2) {
        boolean bl = (n & 6) > 0;
        boolean bl2 = (n & n2) == 0;
        return bl && bl2;
    }

    private EvoListRow createListRow(String string, int n, boolean bl, boolean bl2, boolean bl3) {
        EvoListRow evoListRow = new EvoListRow(n, 6);
        evoListRow.setText(0, string);
        evoListRow.setInteger(1, n);
        evoListRow.setInteger(2, bl ? 1 : 0);
        evoListRow.setInteger(3, bl2 ? 1 : 0);
        evoListRow.setInteger(4, bl3 ? 1 : 0);
        evoListRow.setInteger(5, bl ? (bl2 ? 2 : 1) : 0);
        return evoListRow;
    }

    public void updateProfiles(String string) {
        if (this.currentDevice != null && this.currentDevice.equals(string)) {
            this.showProfiles(string);
        }
    }

    public void updateProfiles() {
        this.showProfiles(this.currentDevice);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        String string = evoListRow.getText(0);
        TrustedDevice trustedDevice = this.bluetoothApplication.getTrustedDeviceList().get(string);
        this.log.log(1000000, "DeviceProfileList#itemSelected(): deviceAddress=%1 trusted device=%2", (Object)string, (Object)trustedDevice);
        if (trustedDevice != null) {
            int n5 = trustedDevice.getActiveServiceTypes();
            int n6 = evoListRow.getInteger(1);
            int n7 = trustedDevice.offeredServiceTypes & PROFILE_CATEGORIES[n6];
            if (n7 == 0) {
                this.showProfiles(string);
            } else {
                boolean bl;
                boolean bl2 = (n5 & n7) != 0;
                boolean bl3 = bl = evoListRow.getInteger(3) == 1;
                if (bl2 != bl) {
                    this.showProfiles(string);
                } else {
                    boolean bl4;
                    boolean bl5 = bl4 = evoListRow.getInteger(2) == 1;
                    if (bl4) {
                        if (bl2) {
                            this.connectActionChoice.setValue(1);
                            this.bluetoothApplication.getConnection().disconnectService(string, n7);
                        } else {
                            this.connectActionChoice.setValue(0);
                            this.bluetoothApplication.getConnection().connectService(string, n7, trustedDevice.getDeviceName(), this.isPhoneRolePrimary);
                        }
                        this.deviceProfilesList.fireEvent(n4);
                    } else {
                        this.log.log(100000, "DeviceProfileList#itemSelected(): The row is disabled!");
                    }
                }
            }
        } else {
            this.log.log(10000, "DeviceProfileList#itemSelected(): device not found %1", (Object)string);
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void init() {
        super.init();
        this.deviceProfilesList.setListener(this);
        this.serviceRegistration = this.bluetoothApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = DeviceProfileList.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
    }

    public void deinit() {
        this.serviceRegistration.unregister();
        this.serviceRegistration = null;
        this.deviceProfilesList.resetListener();
        this.deviceProfilesList.removeAll();
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

