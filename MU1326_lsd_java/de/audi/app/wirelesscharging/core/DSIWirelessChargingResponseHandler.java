/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.AbstractWirelessChargingComponent;
import de.audi.app.wirelesscharging.core.IWirelessChargingApplication;
import de.audi.app.wirelesscharging.core.IWirelessChargingPresentationHandler;
import de.audi.app.wirelesscharging.core.WirelessChargingServiceProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.DefaultPowerEventListener;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener;

public class DSIWirelessChargingResponseHandler
extends AbstractWirelessChargingComponent
implements DSIWirelessChargingListener {
    private final IWirelessChargingApplication wlcApp;
    private final IWirelessChargingPresentationHandler presentationHandler;
    private final DSIActivator dsiWirelessChargingActivator;
    private final LogChannel log;
    private final WirelessChargingServiceProvider serviceProvider;
    private volatile int currentChargingInfo = 1;
    private volatile int previousChargingInfo = 1;
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging;
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public DSIWirelessChargingResponseHandler(IWirelessChargingApplication iWirelessChargingApplication, IWirelessChargingPresentationHandler iWirelessChargingPresentationHandler, LogChannel logChannel) {
        super(iWirelessChargingApplication, "App.WirelessCharging.Main");
        this.wlcApp = iWirelessChargingApplication;
        this.presentationHandler = iWirelessChargingPresentationHandler;
        this.log = logChannel;
        this.dsiWirelessChargingActivator = new DSIActivator(iWirelessChargingApplication.getFrameworkAccess(), (class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging = DSIWirelessChargingResponseHandler.class$("org.dsi.ifc.wirelesscharging.DSIWirelessCharging")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging).getName(), (class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener = DSIWirelessChargingResponseHandler.class$("org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener).getName(), new Integer(0), this, new IDSIClient(){

            public void setDSI(DSIBase dSIBase) {
            }

            public int[] getAutoNotifications() {
                return DSIActivator.ATTR_ALL;
            }
        });
        this.serviceProvider = new WirelessChargingServiceProvider((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = DSIWirelessChargingResponseHandler.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), new WirelessChargingPowerEventListener(), new Hashtable(0), this.wlcApp.getBundleContext(), logChannel);
    }

    public void init() {
        super.init();
        this.dsiWirelessChargingActivator.start(this.getApplication().getBundleContext());
        this.getApplication().addDiagnosisComponent(new WirelessChargingAppDiag());
        this.serviceProvider.startService();
    }

    public void deinit() {
        super.deinit();
        this.dsiWirelessChargingActivator.stop(this.getApplication().getBundleContext());
        this.serviceProvider.stopService();
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

    public void updateChargingInfo(int n, int n2) {
        if (n2 == 1) {
            this.log.log(1000000, "[DSIWirelessChargingResponseHandler#updateChargingInfo] chargingInfo=%1", (Object)DSIWirelessChargingResponseHandler.getChargingInfoName(n));
            this.previousChargingInfo = this.currentChargingInfo;
            this.currentChargingInfo = n;
            this.presentationHandler.updateStatusBar(n);
            if (this.wlcApp.isWLCInfoPopupEnabled() || n == 3) {
                this.updatePresentation();
            } else {
                this.log.log(1000000, "[DSIWirelessChargingResponseHandler#updateChargingInfo] WLC info popups were disabled by user -> NOP!");
            }
        }
    }

    private void updatePresentation() {
        this.log.log(1000000, "[DSIWirelessChargingResponseHandler#updatePresentation] called");
        switch (this.currentChargingInfo) {
            case 4: {
                this.handleIsCharging();
                break;
            }
            case 3: {
                this.handleForeignObject();
                break;
            }
            case 5: {
                this.handleFullyCharged();
                break;
            }
            case 0: 
            case 1: 
            case 2: {
                this.handleChargingInactive();
                break;
            }
            default: {
                this.log.log(10000, "[DSIWirelessChargingResponseHandler#updatePresentation] unknown chargingInfo=%1", (Object)DSIWirelessChargingResponseHandler.getChargingInfoName(this.currentChargingInfo));
            }
        }
    }

    private void handleIsCharging() {
        this.log.log(1000000, "[DSIWirelessChargingResponseHandler#handleIsCharging] WLC is being charged, chargingInfo=%1", (Object)DSIWirelessChargingResponseHandler.getChargingInfoName(this.currentChargingInfo));
        if (this.previousChargingInfo == 1 || this.previousChargingInfo == 0) {
            this.presentationHandler.onWLCDeviceBeingCharged();
        } else {
            this.log.log(1000000, "[DSIWirelessChargingResponseHandler#handleIsCharging] NOT showing popup! previousChargingInfo=%1", (Object)DSIWirelessChargingResponseHandler.getChargingInfoName(this.previousChargingInfo));
        }
    }

    private void handleForeignObject() {
        this.log.log(1000000, "[DSIWirelessChargingResponseHandler#handleForeignObject] foreign object detected: %1", (Object)DSIWirelessChargingResponseHandler.getChargingInfoName(this.currentChargingInfo));
        this.presentationHandler.onForeignObjectDetected();
    }

    private void handleFullyCharged() {
        this.log.log(1000000, "[DSIWirelessChargingResponseHandler#handleFullyCharged] WLC is fully charged: %1", (Object)DSIWirelessChargingResponseHandler.getChargingInfoName(this.currentChargingInfo));
        this.presentationHandler.clearPresentation();
    }

    private void handleChargingInactive() {
        this.log.log(1000000, "[DSIWirelessChargingResponseHandler#handleChargingInactive] wlc is inactive: %1", (Object)DSIWirelessChargingResponseHandler.getChargingInfoName(this.currentChargingInfo));
        this.presentationHandler.clearPresentation();
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[DSIWirelessChargingResponseHandler#asyncException] !asyncException! errorCode=%2, errorMsg=%1", (Object)string, (long)n);
    }

    public void updateBatteryLevel(int n, int n2) {
        this.log.log(1000000, "[DSIWirelessChargingResponseHandler#updateBatteryLevel] battLevel=%1", (long)n);
    }

    public void popupRemoved(int n, int n2) {
        this.presentationHandler.popupRemoved(n, n2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public class WirelessChargingAppDiag
    implements IWirelessChargingDiagComponent {
        public int cmdGetChargingInfo() {
            return DSIWirelessChargingResponseHandler.this.currentChargingInfo;
        }

        public void cmdUpdateChargeInfo(int n) {
            DSIWirelessChargingResponseHandler.this.updateChargingInfo(n, 1);
        }
    }

    private class WirelessChargingPowerEventListener
    extends DefaultPowerEventListener {
        private int lastPwrState = -1;

        private WirelessChargingPowerEventListener() {
        }

        public void notifyPowerListenerOnEnterState(int n, int n2) {
            if (n == 2) {
                DSIWirelessChargingResponseHandler.this.log.log(1000000, "[WirelessChargingPowerEventListener#notifyPowerListenerOnEnterState] going standby.");
                DSIWirelessChargingResponseHandler.this.presentationHandler.updateStatusBar(1);
            } else if (!(this.lastPwrState != 2 && this.lastPwrState != 3 || n != 0 && n != 4)) {
                DSIWirelessChargingResponseHandler.this.log.log(1000000, "[WirelessChargingPowerEventListener#notifyPowerListenerOnEnterState] starting from standby. Update the wireless information with the latest recieved value.");
                DSIWirelessChargingResponseHandler.this.presentationHandler.updateStatusBar(DSIWirelessChargingResponseHandler.this.currentChargingInfo);
            }
            this.lastPwrState = n;
        }
    }
}

