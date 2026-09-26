/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.AbstractWirelessChargingComponent;
import de.audi.app.wirelesscharging.core.IWirelessChargingApplication;
import de.audi.app.wirelesscharging.core.IWirelessChargingPresentationHandler;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$1;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$2;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$3;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$ReminderBluetoothListener;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$ReminderMediaServiceListener;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$ReminderPowerEventListener;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$ReminderTMUpdateListener;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$WirelessChargingReminderPopupAppDiag;
import de.audi.app.wirelesscharging.core.WLCDefaultBluetoothListener;
import de.audi.app.wirelesscharging.core.WirelessChargingServiceProvider;
import de.audi.atip.interapp.media.IMediaServiceListener$DefaultMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.timer.Timer;
import de.audi.mib.jdsi.DSIActivator;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener;

public class ReminderPopupHandler
extends AbstractWirelessChargingComponent
implements DSIWirelessChargingListener,
MsgListener {
    private static final int EPS_ENABLED;
    private static final int EPS_DISABLED;
    private final IWirelessChargingApplication wlcApp;
    private final IWirelessChargingPresentationHandler presentationHandler;
    private final DSIActivator dsiWirelessChargingActivator;
    private final DSIActivator dsiBluetoothActivator;
    private final LogChannel log;
    private final WirelessChargingServiceProvider serviceProvider;
    private final IPowerManager pwrManager;
    private volatile int chargingInfo = 1;
    private volatile boolean isPopupReminderShowing = false;
    private volatile boolean isTerminalModeActive = false;
    private volatile boolean isDeviceConnectedViaUsbAndBT = false;
    private final Timer popupTimer;
    private final WirelessChargingServiceProvider tmUpdateListnerService;
    private final DefaultTerminalModeUpdateListener tmUpdateListener;
    private final WirelessChargingServiceProvider mediaService;
    private final IMediaServiceListener$DefaultMediaServiceListener mediaServiceListener;
    private final WLCDefaultBluetoothListener wlcBluetoothListener;
    private volatile List usbDevices = new ArrayList();
    private volatile TrustedDevice[] trustedDevices = new TrustedDevice[0];
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging;
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public ReminderPopupHandler(IWirelessChargingApplication iWirelessChargingApplication, IWirelessChargingPresentationHandler iWirelessChargingPresentationHandler, LogChannel logChannel, IPowerManager iPowerManager) {
        super(iWirelessChargingApplication, "App.WirelessCharging.Main");
        this.wlcApp = iWirelessChargingApplication;
        this.presentationHandler = iWirelessChargingPresentationHandler;
        this.log = logChannel;
        this.pwrManager = iPowerManager;
        this.popupTimer = new Timer("ReminderPopupTimer", 0, true, new ReminderPopupHandler$1(this));
        this.tmUpdateListener = new ReminderPopupHandler$ReminderTMUpdateListener(this, null);
        this.tmUpdateListnerService = new WirelessChargingServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = ReminderPopupHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, this.wlcApp.getBundleContext(), this.log);
        this.mediaServiceListener = new ReminderPopupHandler$ReminderMediaServiceListener(this, null);
        this.mediaService = new WirelessChargingServiceProvider((class$de$audi$atip$interapp$media$IMediaServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaServiceListener = ReminderPopupHandler.class$("de.audi.atip.interapp.media.IMediaServiceListener")) : class$de$audi$atip$interapp$media$IMediaServiceListener).getName(), this.mediaServiceListener, null, this.wlcApp.getBundleContext(), this.log);
        this.wlcBluetoothListener = new ReminderPopupHandler$ReminderBluetoothListener(this, null);
        this.dsiWirelessChargingActivator = new DSIActivator(iWirelessChargingApplication.getFrameworkAccess(), (class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging = ReminderPopupHandler.class$("org.dsi.ifc.wirelesscharging.DSIWirelessCharging")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging).getName(), (class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener = ReminderPopupHandler.class$("org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener).getName(), new Integer(0), this, new ReminderPopupHandler$2(this));
        this.dsiBluetoothActivator = new DSIActivator(iWirelessChargingApplication.getFrameworkAccess(), (class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = ReminderPopupHandler.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth).getName(), (class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = ReminderPopupHandler.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener).getName(), new Integer(0), this.wlcBluetoothListener, new ReminderPopupHandler$3(this));
        this.serviceProvider = new WirelessChargingServiceProvider((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = ReminderPopupHandler.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), new ReminderPopupHandler$ReminderPowerEventListener(this, null), new Hashtable(0), this.wlcApp.getBundleContext(), logChannel);
    }

    private void logState() {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("[ReminderPopupHandler#logState] called, ");
            buffer.append("isWLCInfoPopupEnabled = ").append(this.wlcApp.isWLCInfoPopupEnabled()).append(", ");
            buffer.append("isPhoneInPhoneBox = ").append(this.isPhoneInPhoneBox()).append(", ");
            buffer.append("isTerminalModeActive = ").append(this.isTerminalModeActive).append(", ");
            buffer.append("isDeviceConnectedViaUsbAndBT = ").append(this.isDeviceConnectedViaUsbAndBT).append(", ");
            this.log.log(1078071040, buffer.toString());
        }
    }

    private boolean isPopupReminderRequired() {
        this.logState();
        return (this.isPhoneInPhoneBox() || this.isTerminalModeActive || this.isDeviceConnectedViaUsbAndBT) && this.wlcApp.isWLCInfoPopupEnabled();
    }

    private boolean isSoundReminderRequired() {
        this.logState();
        return this.isPhoneInPhoneBox() || this.isTerminalModeActive || this.isDeviceConnectedViaUsbAndBT;
    }

    @Override
    public void updateChargingInfo(int n, int n2) {
        this.chargingInfo = n;
        if (this.isPopupReminderShowing) {
            if (!(n != 1 && n != 2 || this.isPopupReminderRequired())) {
                this.stopReminderPopupTimer();
            }
        } else {
            this.updateExtendedPowerState();
        }
    }

    @Override
    public void processMsg(int n) {
        if (n == 102) {
            this.log.log(1078071040, "[ReminderPopupHandler#processMsg] event MMI_STANDBY && door_opened from PowerManager received");
            if (this.isPopupReminderRequired()) {
                this.showReminderPopup();
            } else {
                this.log.log(1078071040, "[ReminderPopupHandler#processMsg] NOT showing reminder popup");
            }
            if (this.isSoundReminderRequired()) {
                this.wlcApp.getFrameworkAccess().getMsgDistrib().sendMessage(103);
            } else {
                this.log.log(1078071040, "[ReminderPopupHandler#processMsg] NOT playing reminder sound");
            }
        } else if (n == 28) {
            this.log.log(1078071040, "[ReminderPopupHandler#processMsg] event RESET_PHONE_SETTINGS received");
            this.wlcApp.resetFactorySettings();
        }
    }

    private void stopReminderPopupTimer() {
        this.log.log(1078071040, "[ReminderPopupHandler#stopReminderPopupTimer] called, chargingInfo=%1", (Object)ReminderPopupHandler.getChargingInfoName(this.chargingInfo));
        this.popupTimer.cancel();
    }

    private void removeReminderPopup() {
        this.presentationHandler.removeReminder();
        this.isPopupReminderShowing = false;
        this.setPowerState(161);
    }

    private void showReminderPopup() {
        if (this.wlcApp.isWLCInfoPopupEnabled() && !this.isPopupReminderShowing) {
            this.setPowerState(160);
            this.presentationHandler.onRemindWLCDeviceStillInPhonebox();
            this.popupTimer.start();
            this.isPopupReminderShowing = true;
        } else {
            this.log.log(1078071040, "[ReminderPopupHandler#showReminderPopup] Reminder is already showing or was switched off in settings -> NOP!");
        }
    }

    private void updateExtendedPowerState() {
        if (this.isPopupReminderRequired()) {
            this.setPowerState(160);
        } else {
            this.setPowerState(161);
        }
    }

    private void setPowerState(int n) {
        this.log.log(1078071040, "[ReminderPopupHandler#setPowerState] setting EPS to %3, chargingInfo=%2, isWLCInfoPopupEnabled=%1", this.wlcApp.isWLCInfoPopupEnabled(), (Object)ReminderPopupHandler.getChargingInfoName(this.chargingInfo), (Object)ReminderPopupHandler.getEPSName(n));
        this.pwrManager.setExtendedPowerState(n, 0);
    }

    private boolean checkConnectionViaUsbAndBT() {
        Iterator iterator = this.usbDevices.iterator();
        while (iterator.hasNext()) {
            MediaSlotInfo mediaSlotInfo = (MediaSlotInfo)iterator.next();
            if (!this.areUsbAndBtNamesEqual(mediaSlotInfo.getName())) continue;
            return true;
        }
        return false;
    }

    private boolean areUsbAndBtNamesEqual(String string) {
        for (int i2 = 0; i2 < this.trustedDevices.length; ++i2) {
            TrustedDevice trustedDevice = this.trustedDevices[i2];
            if (trustedDevice == null || !this.isConnectedAsHFP(trustedDevice) || string == null || !string.equalsIgnoreCase(trustedDevice.getDeviceName())) continue;
            this.log.log(1078071040, "[ReminderPopupHandler#checkConnectionViaUsbAndBT] We have a match! USB: %1, BT: %2.", (Object)string, (Object)trustedDevice.getDeviceName());
            return true;
        }
        return false;
    }

    private boolean isConnectedAsHFP(TrustedDevice trustedDevice) {
        return (trustedDevice.getActiveServiceTypes() & 2) > 0;
    }

    @Override
    public void init() {
        super.init();
        this.dsiWirelessChargingActivator.start(this.getApplication().getBundleContext());
        this.dsiBluetoothActivator.start(this.getApplication().getBundleContext());
        this.getApplication().addDiagnosisComponent(new ReminderPopupHandler$WirelessChargingReminderPopupAppDiag(this));
        this.getApplication().getMessageDispatcher().addMessageListener(102, this);
        this.getApplication().getMessageDispatcher().addMessageListener(28, this);
        this.serviceProvider.startService();
        this.tmUpdateListnerService.startService();
        this.mediaService.startService();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.stopReminderPopupTimer();
        this.dsiWirelessChargingActivator.stop(this.getApplication().getBundleContext());
        this.dsiBluetoothActivator.stop(this.getApplication().getBundleContext());
        this.getApplication().getMessageDispatcher().removeMessageListener(102, this);
        this.getApplication().getMessageDispatcher().removeMessageListener(28, this);
        this.serviceProvider.stopService();
        this.tmUpdateListnerService.stopService();
        this.mediaService.stopService();
    }

    private boolean isPhoneInPhoneBox() {
        return this.chargingInfo == 4 || this.chargingInfo == 3 || this.chargingInfo == 5;
    }

    private static String getChargingInfoName(int n) {
        String string = new StringBuffer().append("unknown charging info ").append(n).toString();
        switch (n) {
            case 1: {
                string = "EMPTY";
                break;
            }
            case 2: {
                string = "NONWLC";
                break;
            }
            case 0: {
                string = "OFF";
                break;
            }
            case 3: {
                string = "WLCFOD";
                break;
            }
            case 5: {
                string = "WLCFULL";
                break;
            }
            case 4: {
                string = "WLCHARGE";
                break;
            }
        }
        return string;
    }

    private static String getEPSName(int n) {
        switch (n) {
            case 160: {
                return "ENABLED";
            }
            case 161: {
                return "DISABLED";
            }
        }
        return new StringBuffer().append("unknown EPS ").append(n).toString();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateBatteryLevel(int n, int n2) {
    }

    static /* synthetic */ void access$000(ReminderPopupHandler reminderPopupHandler) {
        reminderPopupHandler.removeReminderPopup();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$500(ReminderPopupHandler reminderPopupHandler) {
        return reminderPopupHandler.log;
    }

    static /* synthetic */ boolean access$602(ReminderPopupHandler reminderPopupHandler, boolean bl) {
        reminderPopupHandler.isTerminalModeActive = bl;
        return reminderPopupHandler.isTerminalModeActive;
    }

    static /* synthetic */ boolean access$700(ReminderPopupHandler reminderPopupHandler) {
        return reminderPopupHandler.isPopupReminderShowing;
    }

    static /* synthetic */ void access$800(ReminderPopupHandler reminderPopupHandler) {
        reminderPopupHandler.updateExtendedPowerState();
    }

    static /* synthetic */ List access$902(ReminderPopupHandler reminderPopupHandler, List list) {
        reminderPopupHandler.usbDevices = list;
        return reminderPopupHandler.usbDevices;
    }

    static /* synthetic */ boolean access$1002(ReminderPopupHandler reminderPopupHandler, boolean bl) {
        reminderPopupHandler.isDeviceConnectedViaUsbAndBT = bl;
        return reminderPopupHandler.isDeviceConnectedViaUsbAndBT;
    }

    static /* synthetic */ boolean access$1100(ReminderPopupHandler reminderPopupHandler) {
        return reminderPopupHandler.checkConnectionViaUsbAndBT();
    }

    static /* synthetic */ boolean access$1000(ReminderPopupHandler reminderPopupHandler) {
        return reminderPopupHandler.isDeviceConnectedViaUsbAndBT;
    }

    static /* synthetic */ TrustedDevice[] access$1202(ReminderPopupHandler reminderPopupHandler, TrustedDevice[] trustedDeviceArray) {
        reminderPopupHandler.trustedDevices = trustedDeviceArray;
        return trustedDeviceArray;
    }

    static /* synthetic */ IWirelessChargingApplication access$1300(ReminderPopupHandler reminderPopupHandler) {
        return reminderPopupHandler.wlcApp;
    }

    static /* synthetic */ void access$1400(ReminderPopupHandler reminderPopupHandler) {
        reminderPopupHandler.stopReminderPopupTimer();
    }
}

