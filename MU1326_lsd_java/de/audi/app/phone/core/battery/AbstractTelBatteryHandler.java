/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.battery;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.LinkedList;
import org.dsi.ifc.bluetooth.TrustedDevice;

public abstract class AbstractTelBatteryHandler
extends AbstractPhoneComponent {
    private final TelBatteryBluetoothListener bluetoothListener = new TelBatteryBluetoothListener();
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

    public void init() {
        super.init();
        this.getApplication().getBluetoothHandler().addBluetoothListener(this.bluetoothListener);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().addDiagnosisComponent(new TelBatteryDiag());
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getBluetoothHandler().removeBluetoothListener(this.bluetoothListener);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "AbstractTelBatteryHandler#updateGlobalTelephoneStateProperty stateStruct is null");
        }
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getPrimaryDeviceState();
        String string = AbstractTelBatteryHandler.getMEMacAddress(iTelDSIMobileEquipmentDeviceState);
        String string2 = AbstractTelBatteryHandler.getMEFriendlyName(iTelDSIMobileEquipmentDeviceState);
        int n2 = AbstractTelBatteryHandler.getBatteryChargeLevel(iTelDSIMobileEquipmentDeviceState);
        if (n == 65542 || n == 65554) {
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

    protected abstract void handleBatteryChargeLevel(String var1, String var2, int var3);

    public class TelBatteryDiag
    implements IPhoneDiagComponent {
        public void cmdSetBatteryLevel(String string, String string2, int n, String string3) {
            AbstractTelBatteryHandler.this.handleBatteryChargeLevel(string, string2, n);
        }
    }

    private class TelBatteryBluetoothListener
    implements ITelBluetoothListener {
        private TelBatteryBluetoothListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray) {
            if (trustedDeviceArray != null) {
                for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                    TrustedDevice trustedDevice = trustedDeviceArray[i2];
                    if (trustedDevice == null) continue;
                    boolean bl = AbstractTelBatteryHandler.isDeviceViaHFPOrSAPConnected(trustedDevice);
                    String string = trustedDevice.getDeviceAddress();
                    if (bl) {
                        AbstractTelBatteryHandler.this.log.log(10000000, "[AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices] %1 connected via HFP or SAP", (Object)string);
                    } else {
                        AbstractTelBatteryHandler.this.log.log(10000000, "[AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices] %1 not connected via HFP or SAP", (Object)string);
                    }
                    LinkedList linkedList = AbstractTelBatteryHandler.this.btTelephoneConnectedDeviceList;
                    synchronized (linkedList) {
                        if (bl) {
                            if (!AbstractTelBatteryHandler.this.btTelephoneConnectedDeviceList.contains(string)) {
                                AbstractTelBatteryHandler.this.btTelephoneConnectedDeviceList.add(string);
                            }
                        } else if (AbstractTelBatteryHandler.this.btTelephoneConnectedDeviceList.contains(string)) {
                            AbstractTelBatteryHandler.this.btTelephoneConnectedDeviceList.remove(string);
                        }
                        continue;
                    }
                }
            } else {
                AbstractTelBatteryHandler.this.log.log(10000, "AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices trustedDevices is null");
            }
        }
    }
}

