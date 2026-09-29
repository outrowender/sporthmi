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
    private static final int STATUSBAR_WIRELESS_CHARGING_CHOICE_EMPTY;
    private static final int STATUSBAR_WIRELESS_CHARGING_CHOICE_ACTIVE;
    private static final int STATUSBAR_WIRELESS_CHARGING_CHOICE_FULL_BATTERY;
    private static final int FOD_POPUP_MIN_SHOW_DURATION;
    private final IHMIServiceApp hmiService;
    private final LogChannel log;
    private final ChoiceModel statusBarChoice;
    private final PopupHandler popupHandler;

    public EvoWirelessChargingPresentationHandler(IHMIServiceApp iHMIServiceApp, LogChannel logChannel) {
        this.hmiService = iHMIServiceApp;
        this.log = logChannel;
        this.statusBarChoice = (ChoiceModel)iHMIServiceApp.getChoiceModel(4585);
        this.popupHandler = new PopupHandler(1088500480, 4000, (HMIService)iHMIServiceApp, logChannel);
    }

    @Override
    public void updateStatusBar(int n) {
        this.log.log(1078071040, "[EvoWirelessChargingPresentationHandler#updateStatusBar] called");
        if (n == 4) {
            this.statusBarChoice.setValue(1);
        } else if (n == 5) {
            this.statusBarChoice.setValue(2);
        } else {
            this.statusBarChoice.setValue(0);
        }
    }

    @Override
    public void onWLCDeviceBeingCharged() {
        this.popupHandler.removePopup();
        this.log.log(1078071040, "[EvoWirelessChargingPresentationHandler#onWLCDeviceBeingCharged] showing C_H_A_R_G_I_N_G_P_O_P_U_P_O_B_J_E_C_T popup");
        this.hmiService.showPartialPopup(0, 1088500480);
    }

    @Override
    public void onForeignObjectDetected() {
        this.hmiService.removePartialPopup(0, 1088500480);
        this.log.log(1078071040, "[EvoWirelessChargingPresentationHandler#onForeignObjectDetected] ! showing POPUP_CHARGING_POPUP_FOREIGN_OBJECT_DETECT_ID");
        this.popupHandler.showPopup();
    }

    @Override
    public void onRemindWLCDeviceStillInPhonebox() {
        this.log.log(1078071040, "[EvoWirelessChargingPresentationHandler#onRemindWLCDeviceStillInPhonebox] showing POPUP_CHARGING_POPUP_REMINDER_ID");
        this.hmiService.showPopup(1105277696);
    }

    @Override
    public void clearPresentation() {
        this.log.log(-2137614336, "[EvoWirelessChargingPresentationHandler#clearPresentation] removing possible popups from the screen");
        this.popupHandler.removePopup();
        this.hmiService.removePartialPopup(0, 1088500480);
    }

    @Override
    public void removeReminder() {
        this.log.log(1078071040, "[EvoWirelessChargingPresentationHandler#removeReminder] removing reminder popup from the screen");
        this.hmiService.removePopup(1105277696);
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.popupHandler.removePopup();
    }
}

