/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.accessibility.CommandRequestSwitchBTState;
import de.audi.app.bluetooth.core.accessibility.CommandSetAccessibleMode;
import de.audi.app.bluetooth.core.accessibility.IAccessibility;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractAccessibility
extends AbstractBluetoothComponent
implements IAccessibility,
IConnectivityPhoneStateListener {
    private static final int AVAILABLE = 1;
    private static final int NOT_AVAILABLE = 0;
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{1, 3};
    private ServiceRegistration serviceRegistration;
    private final ChoiceModelApp bluetoothState = this.getChoiceModel(0x262676);
    private volatile boolean visible;
    private volatile int btState = -1;
    private volatile boolean isCallActive;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;

    public AbstractAccessibility(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void activateBluetooth() {
        this.log.log(1000000, "AbstractAccessibility#activateBluetooth(): btState=%1", (long)this.btState);
        if (this.isTurnOnValid()) {
            this.requestSwitchBTState(true);
        }
    }

    private boolean isTurnOnValid() {
        return this.bluetoothApplication.getClampStateProvider().isClampSOn() && (this.btState == 1 || this.btState == 4);
    }

    public void setAccessibleMode(int n) {
        this.log.log(1000000, "AbstractAccessibility#setAccessibleMode(): mode=%1", (long)n);
        this.btStateSelected(n);
    }

    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        this.isCallActive = iTelMESlotState != null && iTelMESlotState.isCallActiveOrPhoneRinging() || iTelMESlotState2 != null && iTelMESlotState2.isCallActiveOrPhoneRinging();
        this.log.log(10000000, "AbstractAccessibility#updateMESlotInfo(): isCallActive: %1", this.isCallActive);
    }

    public void updatePhoneState(int n, int n2) {
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
    }

    public void updateAccessibleMode(int n, boolean bl, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1000000, "AbstractAccessibility#updateAccessibleMode(): visible=%1", bl);
        this.visible = bl;
        this.updateModels(this.btState, this.visible);
    }

    public void updateBTState(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1000000, "AbstractAccessibility#updateBTState(): bTState=%1", (long)n);
        if (this.btState != n) {
            this.btState = n;
            this.updateModels(this.btState, this.visible);
            this.bluetoothState.setValue(this.getState());
        }
    }

    protected abstract void updateModels(int var1, boolean var2);

    private int getState() {
        return this.btState == 5 || this.btState == 2 ? 0 : 1;
    }

    protected void btStateSelected(int n) {
        if (this.dsiBluetooth != null) {
            if (n == 2) {
                if (this.isTurnOffValid()) {
                    this.requestSwitchBTState(false);
                }
            } else {
                this.activateBluetooth();
                if (n == 1) {
                    this.visible = false;
                    CommandSetAccessibleMode.schedule(this.bluetoothApplication, this.dsiBluetooth, 3);
                } else if (n == 0) {
                    this.visible = true;
                    CommandSetAccessibleMode.schedule(this.bluetoothApplication, this.dsiBluetooth, 4);
                }
            }
        } else {
            this.log.log(100000, "AbstractAccessibility#btStateSelected(): DSIBluetooth is still not available.");
        }
    }

    protected boolean isTurnOffValid() {
        return this.btState == 0 && !this.isCallActive;
    }

    private void requestSwitchBTState(boolean bl) {
        if (this.dsiBluetooth != null) {
            this.log.log(1000000, "AbstractAccessibility#requestSwitchBTState(): on=%1", bl);
            CommandRequestSwitchBTState.schedule(this.bluetoothApplication, this.dsiBluetooth, bl ? 0 : 1);
        } else {
            this.log.log(100000, "AbstractAccessibility#requestSwitchBTState(): DSIBluetooth is still not available.");
        }
    }

    public void init() {
        super.init();
        this.serviceRegistration = this.bluetoothApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = AbstractAccessibility.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
    }

    public void deinit() {
        this.serviceRegistration.unregister();
        this.serviceRegistration = null;
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

