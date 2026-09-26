/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.app.connectivity.manager.contents.CoMaDeviceBlue;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.esolutions.fw.util.commons.StringUtils;
import java.util.ArrayList;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceRegistration;

class ComaBluetoothListener
extends AbstractBluetoothComponent
implements IConnectivityPhoneStateListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{6, 17};
    private final ConnectivityManager coma;
    private ServiceRegistration registration;
    private volatile TrustedDevice[] bluetoothDevices = new TrustedDevice[0];
    private volatile String prioritizedPhone;
    private volatile ITelMESlotState primary;
    private volatile ITelMESlotState secondary;
    private volatile ITelMESlotState data;
    private volatile boolean isTerminalModelActive;
    private volatile boolean isAnyEorBCallActive;
    private boolean phoneModuleIsOn = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;

    private static final int getCoMaServices(int n) {
        int n2 = 0;
        if ((n & 6) != 0) {
            n2 |= 3;
        }
        if ((n & 4) != 0) {
            n2 |= 4;
        }
        if ((n & 0x800100) != 0) {
            n2 |= 0x10;
        }
        if ((n & 0x20006000) != 0) {
            n2 |= 0x20;
        }
        return n2;
    }

    private static final boolean isPhoneConnectedWithOffice(int n) {
        boolean bl = ComaBluetoothListener.isConnectedPhone(n);
        boolean bl2 = ComaBluetoothListener.isConnectedOffice(n);
        return bl && bl2;
    }

    private static boolean isConnectedOffice(int n) {
        return (n & 0x20) > 0;
    }

    private static final boolean isConnectedPhone(int n) {
        return (n & 3) > 0;
    }

    ComaBluetoothListener(IBluetoothApplication iBluetoothApplication, ConnectivityManager connectivityManager) {
        super(iBluetoothApplication);
        this.coma = connectivityManager;
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    private void update() {
        ArrayList arrayList = new ArrayList(this.bluetoothDevices.length);
        for (int i2 = 0; i2 < this.bluetoothDevices.length; ++i2) {
            TrustedDevice trustedDevice = this.bluetoothDevices[i2];
            int n = ComaBluetoothListener.getCoMaServices(trustedDevice.getOfferedServiceTypes());
            boolean bl = trustedDevice.getDeviceRole() == 1;
            int n2 = ComaBluetoothListener.getCoMaServices(trustedDevice.getActiveServiceTypes()) & n & this.getComaPhoneServiceMask(bl);
            boolean bl2 = this.isCallActive(trustedDevice.getDeviceAddress(), this.isAnyEorBCallActive);
            int n3 = this.getChangeableServices(n2, bl2, bl && ComaBluetoothListener.isConnectedPhone(n2), this.isTerminalModelActive, this.phoneModuleIsOn, this.isAnyEorBCallActive);
            boolean bl3 = this.isPrioPhone(trustedDevice.getDeviceAddress());
            CoMaDeviceBlue coMaDeviceBlue = new CoMaDeviceBlue(trustedDevice, n, n2, n3, bl3, bl2);
            arrayList.add(coMaDeviceBlue);
        }
        this.coma.updateBluetoothDevices(arrayList, this.checkIfSimOrRSAPAvailable());
    }

    private boolean checkIfSimOrRSAPAvailable() {
        if (this.data != null) {
            return this.data.isSim();
        }
        return false;
    }

    private int getComaPhoneServiceMask(boolean bl) {
        return bl ? -3 : -2;
    }

    private boolean isCallActive(String string, boolean bl) {
        return this.primary != null && this.primary.isCallActiveOrPhoneRinging() || this.secondary != null && this.secondary.isCallActiveOrPhoneRinging() || bl;
    }

    private int getChangeableServices(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        int n2 = 255;
        if (!this.isPhoneAvailable(this.primary) || bl2 && !this.isPhoneAvailable(this.secondary) || bl3 || bl5) {
            n2 &= 0xFFFFFFFD | n & 2;
        }
        if (bl || bl5 || bl3) {
            n2 &= 0xFFFFFFFC;
            n2 &= 0xFFFFFFFB;
        }
        if (ComaBluetoothListener.isPhoneConnectedWithOffice(n) || this.isNotIphoneUseCase(n) || bl3 || bl5) {
            n2 &= 0xFFFFFFDF;
        }
        if (this.data != null && this.data.isInternalSim() || bl3 || !bl4 || bl5) {
            n2 &= 0xFFFFFFFB;
        }
        if (bl3 || bl5) {
            n2 &= 0xFFFFFFEF;
        }
        return n2;
    }

    private boolean isNotIphoneUseCase(int n) {
        return !ComaBluetoothListener.isConnectedPhone(n) && !ComaBluetoothListener.isConnectedOffice(n) && !this.isVoiceSimAvailable();
    }

    private boolean isPhoneAvailable(ITelMESlotState iTelMESlotState) {
        return iTelMESlotState != null && iTelMESlotState.isUnlocked();
    }

    private boolean isVoiceSimAvailable() {
        return this.primary != null && this.primary.isInternalSim() && this.primary.isUnlocked() || this.secondary != null && this.secondary.isInternalSim() && this.secondary.isUnlocked();
    }

    private boolean isPrioPhone(String string) {
        return string != null && string.equals(this.prioritizedPhone);
    }

    public void updateTerminalModeState(boolean bl) {
        if (this.isTerminalModelActive != bl) {
            this.isTerminalModelActive = bl;
            this.update();
        }
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "ComaBluetoothListener#updateTrustedDevices(): %1", (Object)StringUtils.toString(trustedDeviceArray));
        }
        if (trustedDeviceArray == null) {
            this.log.log(-1601830656, "ComaBluetoothListener#updateTrustedDevices(): trustedDevices List from DSI is NULL!");
            return;
        }
        this.bluetoothDevices = trustedDeviceArray;
        this.update();
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        this.log.log(1078071040, "ComaBluetoothListener#updatePriorizedDeviceReconnect():  '%2' %1", bl, (Object)string);
        this.prioritizedPhone = bl ? string : null;
        this.update();
    }

    @Override
    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        this.log.log(-2137614336, "ComaBluetoothListener#updateMESlotInfo(): %1 %2 %3", (Object)iTelMESlotState, (Object)iTelMESlotState2, (Object)iTelMESlotState3);
        this.primary = iTelMESlotState;
        this.secondary = iTelMESlotState2;
        this.data = iTelMESlotState3;
        this.update();
    }

    @Override
    public void updatePhoneState(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = n2 == 2;
        if (this.phoneModuleIsOn != bl) {
            this.phoneModuleIsOn = bl;
            this.update();
        }
    }

    @Override
    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
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
        this.log.log(1078071040, "ComaBluetoothListener#updateConnectedGatewayState(): isAnyEorBCallActive=%1", bl);
        if (this.isAnyEorBCallActive != bl) {
            this.isAnyEorBCallActive = bl;
            this.update();
        }
    }

    @Override
    public void init() {
        super.init();
        this.registration = this.coma.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = ComaBluetoothListener.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.registration.unregister();
        this.registration = null;
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

