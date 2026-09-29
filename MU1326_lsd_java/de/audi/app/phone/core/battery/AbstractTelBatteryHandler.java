/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.battery;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.battery.AbstractTelBatteryHandler$TelBatteryBluetoothListener;
import de.audi.app.phone.core.battery.AbstractTelBatteryHandler$TelBatteryDiag;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.log.LogChannel;
import java.util.LinkedList;
import org.dsi.ifc.bluetooth.TrustedDevice;

public abstract class AbstractTelBatteryHandler
extends AbstractPhoneComponent {
    private final AbstractTelBatteryHandler$TelBatteryBluetoothListener bluetoothListener = new AbstractTelBatteryHandler$TelBatteryBluetoothListener(this, null);
    private final LinkedList btTelephoneConnectedDeviceList = new LinkedList();

    private static boolean isDeviceViaHFPOrSAPConnected(TrustedDevice trustedDevice) {
        if (trustedDevice != null) {
            int n = trustedDevice.getActiveServiceTypes();
            boolean bl = (n & 2) == 2;
            boolean bl2 = (n & 4) == 4;
            return bl || bl2;
        }
        return false;
    }

    private static String getMEMacAddress(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null ? iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeBtAddress() : "";
    }

    private static String getMEFriendlyName(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null ? iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName() : "";
    }

    private static int getBatteryChargeLevel(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getBatteryChargeLevel() : 255;
    }

    public AbstractTelBatteryHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getBluetoothHandler().addBluetoothListener(this.bluetoothListener);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().addDiagnosisComponent(new AbstractTelBatteryHandler$TelBatteryDiag(this));
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getBluetoothHandler().removeBluetoothListener(this.bluetoothListener);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "AbstractTelBatteryHandler#updateGlobalTelephoneStateProperty stateStruct is null");
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getPrimaryDeviceState();
        String string = AbstractTelBatteryHandler.getMEMacAddress(iTelDSIMobileEquipmentDeviceState);
        String string2 = AbstractTelBatteryHandler.getMEFriendlyName(iTelDSIMobileEquipmentDeviceState);
        int n2 = AbstractTelBatteryHandler.getBatteryChargeLevel(iTelDSIMobileEquipmentDeviceState);
        if (n == 0x6000100 || n == 0x12000100) {
            this.handleBatteryChargeLevel(string2, string, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean isConnectedViaSAPOrHFP(String string) {
        LinkedList linkedList = this.btTelephoneConnectedDeviceList;
        synchronized (linkedList) {
            return this.btTelephoneConnectedDeviceList.contains(string);
        }
    }

    protected abstract void handleBatteryChargeLevel(String string, String string2, int n) {
    }

    static /* synthetic */ boolean access$100(TrustedDevice trustedDevice) {
        return AbstractTelBatteryHandler.isDeviceViaHFPOrSAPConnected(trustedDevice);
    }

    static /* synthetic */ LogChannel access$200(AbstractTelBatteryHandler abstractTelBatteryHandler) {
        return abstractTelBatteryHandler.log;
    }

    static /* synthetic */ LogChannel access$300(AbstractTelBatteryHandler abstractTelBatteryHandler) {
        return abstractTelBatteryHandler.log;
    }

    static /* synthetic */ LinkedList access$400(AbstractTelBatteryHandler abstractTelBatteryHandler) {
        return abstractTelBatteryHandler.btTelephoneConnectedDeviceList;
    }

    static /* synthetic */ LogChannel access$500(AbstractTelBatteryHandler abstractTelBatteryHandler) {
        return abstractTelBatteryHandler.log;
    }
}

