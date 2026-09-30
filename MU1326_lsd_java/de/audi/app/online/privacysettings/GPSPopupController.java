/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.privacysettings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;

public class GPSPopupController
implements PowerEventListener {
    public static final int GPS_POPUP_NOT_TRIGGERED = 0;
    public static final int GPS_POPUP_SHOULD_APPEAR = 1;
    public static final int GPS_POPUP_ACKNOWLEDGED = 2;
    private IPopupManager popupManager;
    private int popupId;
    private ChoiceModelApp popupShouldAppearModel;
    private LogChannel logChannel;
    private DSIOnlineServiceRegistration dsi;
    private boolean clampSOld = true;
    private boolean popupIfGpsInUse = false;

    public GPSPopupController(IPopupManager iPopupManager, int n, ChoiceModelApp choiceModelApp, boolean bl, LogChannel logChannel) {
        this.popupManager = iPopupManager;
        this.popupId = n;
        this.popupShouldAppearModel = choiceModelApp;
        this.popupShouldAppearModel.setValue(0);
        this.popupIfGpsInUse = bl;
        this.logChannel = logChannel;
    }

    public void setDsi(DSIOnlineServiceRegistration dSIOnlineServiceRegistration) {
        this.dsi = dSIOnlineServiceRegistration;
    }

    public void showPopup() {
        this.logChannel.log(1000000, "GPSPopupController#showPopup GPS in use; popupIfGpsInUse: %1; popup state: %2", (Object)String.valueOf(this.popupIfGpsInUse), (Object)String.valueOf(this.popupShouldAppearModel.getValue()));
        if (this.popupIfGpsInUse && this.popupShouldAppearModel.getValue() != 2) {
            this.logChannel.log(1000000, "GPSPopupController#showPopup showing popup %1", (long)this.popupId);
            this.popupShouldAppearModel.setValue(1);
            this.popupManager.showPopup(this.popupId);
        }
    }

    public void gpsPopupAcknowledged(int n) {
        this.logChannel.log(1000000, "GPSPopupController#gpsPopupAcknowledged GPS popup acknowledged by the user, won't display the popup anymore for the rest of the bus cycle");
        this.popupShouldAppearModel.setValue(2);
        if (this.dsi != null) {
            this.dsi.setGPSUseMode(0);
        } else {
            this.logChannel.log(100000, "GPSPopupController#gpsPopupAcknowledged no DSI available; sending no feedback to the south-side");
        }
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1000000, "GPSPopupController#updateClampState popup state: %1; clampSOld: %2; clampS: %3", (Object)String.valueOf(this.popupShouldAppearModel.getValue()), (Object)String.valueOf(this.clampSOld), (Object)String.valueOf(bl));
        if (this.popupShouldAppearModel.getValue() == 2 && this.clampSOld && !bl) {
            this.logChannel.log(1000000, "GPSPopupController#updateClampState new clamp S cycle detected; the GPS popup can be shown again");
            this.popupShouldAppearModel.setValue(0);
        }
        this.clampSOld = bl;
    }
}

