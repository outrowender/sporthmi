/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.accessibility.ISupportedBtProfiles;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceRegistration;

public class ProfileSupport
extends AbstractBluetoothComponent
implements ISupportedBtProfiles,
IConnectivityPhoneStateListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{12, 6};
    private volatile int supportedBTProfiles = 0;
    private volatile boolean isNadModeVoiceAndData;
    private volatile boolean isSimInserted;
    private volatile boolean isSapPrioConnected;
    private volatile boolean enableHfpProfile;
    private volatile boolean callActive;
    private ServiceRegistration serviceRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;

    public ProfileSupport(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void updateSupportedBTProfiles(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1000000, "ProfileSupport#updateSupportedBTProfiles %1", (Object)Integer.toHexString(n));
        this.supportedBTProfiles = n;
        this.bluetoothApplication.getDeviceProfileList().updateProfiles();
        this.bluetoothApplication.getConnection().updateHfpSupport((n & 2) > 0);
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n == 1 && trustedDeviceArray != null) {
            boolean bl = false;
            boolean bl2 = false;
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                if ((trustedDeviceArray[i2].getActiveServiceTypes() & 4) <= 0) continue;
                bl = true;
                bl2 = trustedDeviceArray[i2].getDeviceRole() == 1;
                break;
            }
            this.isSapPrioConnected = bl && bl2;
        }
    }

    public int getConnectableServices(int n, boolean bl) {
        int n2 = 0;
        if (n == 0) {
            this.log.log(1000000, "ProfileSupport#getConnectableServices(): supportedServices=%2, hfp+=%1", this.enableHfpProfile && !this.callActive, (long)this.supportedBTProfiles);
            n2 = this.supportedBTProfiles & 6;
            if (this.isSapPrioConnected && !bl) {
                n2 &= 0xFFFFFFFB;
            }
            if (this.enableHfpProfile && !this.callActive) {
                n2 |= 2;
            }
            this.log.log(1000000, "ProfileSupport#getConnectableServices(): returning connectable profiles: %1", (long)n2);
        } else if (n == 1) {
            n2 = this.supportedBTProfiles & 4;
        } else if (n == 3) {
            n2 = 65536;
        } else if (n == 4) {
            n2 = 0x600020;
        } else if (n == 6) {
            n2 = this.getConnectableServices(0, bl) | this.getConnectableServices(1, bl) | this.getConnectableServices(3, bl) | this.getConnectableServices(4, bl);
        }
        return n2;
    }

    public boolean isHfpSupportFaked() {
        return (this.supportedBTProfiles & 2) == 0 && this.enableHfpProfile;
    }

    public void updatePhoneState(int n, int n2) {
        this.isNadModeVoiceAndData = n == 1;
        this.updateFakeHfpProfileSupport();
    }

    private void updateFakeHfpProfileSupport() {
        if (this.isNadModeVoiceAndData && this.isSimInserted) {
            this.log.log(1000000, "ProfileSupport#updateFakeHfpProfileSupport(): Overwriting HFP profile support!");
            this.enableHfpProfile = true;
        } else {
            if (this.enableHfpProfile) {
                this.log.log(1000000, "ProfileSupport#updateFakeHfpProfileSupport(): Using original profile support again!");
            }
            this.enableHfpProfile = false;
        }
    }

    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        this.callActive = iTelMESlotState != null && iTelMESlotState.isCallActive() || iTelMESlotState2 != null && iTelMESlotState2.isCallActive();
        this.isSimInserted = iTelMESlotState3 != null && iTelMESlotState3.isInternalSim();
        this.updateFakeHfpProfileSupport();
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

    public void init() {
        super.init();
        this.serviceRegistration = this.bluetoothApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = ProfileSupport.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
    }

    public void deinit() {
        this.serviceRegistration.unregister();
        this.serviceRegistration = null;
        super.deinit();
    }

    public String toString() {
        return new StringBuffer().append("Supported Bluetooth profiles: ").append(this.supportedBTProfiles).toString();
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

