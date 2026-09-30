/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.evo.screen;

import de.audi.app.wirelesscharging.core.IWirelessChargingPresentationHandler;
import de.audi.app.wirelesscharging.util.PopupHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.log.LogChannel;

public class EvoWirelessChargingPresentationHandler
implements IWirelessChargingPresentationHandler {
    private static final int STATUSBAR_WIRELESS_CHARGING_CHOICE_EMPTY = 0;
    private static final int STATUSBAR_WIRELESS_CHARGING_CHOICE_ACTIVE = 1;
    private static final int STATUSBAR_WIRELESS_CHARGING_CHOICE_FULL_BATTERY = 2;
    private static final int FOD_POPUP_MIN_SHOW_DURATION = 4000;
    private final IHMIServiceApp hmiService;
    private final LogChannel log;
    private final ChoiceModel statusBarChoice;
    private final PopupHandler popupHandler;

    public EvoWirelessChargingPresentationHandler(IHMIServiceApp iHMIServiceApp, LogChannel logChannel) {
        this.hmiService = iHMIServiceApp;
        this.log = logChannel;
        this.statusBarChoice = (ChoiceModel)iHMIServiceApp.getChoiceModel(4585);
        this.popupHandler = new PopupHandler(3400000, 4000, (HMIService)iHMIServiceApp, logChannel);
    }

    public void updateStatusBar(int n) {
        this.log.log(1000000, "[EvoWirelessChargingPresentationHandler#updateStatusBar] called");
        if (n == 4) {
            this.statusBarChoice.setValue(1);
        } else if (n == 5) {
            this.statusBarChoice.setValue(2);
        } else {
            this.statusBarChoice.setValue(0);
        }
    }

    public void onWLCDeviceBeingCharged() {
        this.popupHandler.removePopup();
        this.log.log(1000000, "[EvoWirelessChargingPresentationHandler#onWLCDeviceBeingCharged] showing C_H_A_R_G_I_N_G_P_O_P_U_P_O_B_J_E_C_T popup");
        this.hmiService.showPartialPopup(0, 3400000);
    }

    public void onForeignObjectDetected() {
        this.hmiService.removePartialPopup(0, 3400000);
        this.log.log(1000000, "[EvoWirelessChargingPresentationHandler#onForeignObjectDetected] ! showing POPUP_CHARGING_POPUP_FOREIGN_OBJECT_DETECT_ID");
        this.popupHandler.showPopup();
    }

    public void onRemindWLCDeviceStillInPhonebox() {
        this.log.log(1000000, "[EvoWirelessChargingPresentationHandler#onRemindWLCDeviceStillInPhonebox] showing POPUP_CHARGING_POPUP_REMINDER_ID");
        this.hmiService.showPopup(3400001);
    }

    public void clearPresentation() {
        this.log.log(10000000, "[EvoWirelessChargingPresentationHandler#clearPresentation] removing possible popups from the screen");
        this.popupHandler.removePopup();
        this.hmiService.removePartialPopup(0, 3400000);
    }

    public void removeReminder() {
        this.log.log(1000000, "[EvoWirelessChargingPresentationHandler#removeReminder] removing reminder popup from the screen");
        this.hmiService.removePopup(3400001);
    }

    public void popupRemoved(int n, int n2) {
        this.popupHandler.removePopup();
    }
}

