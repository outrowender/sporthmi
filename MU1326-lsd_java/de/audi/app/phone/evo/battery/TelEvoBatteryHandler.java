/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.battery;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.battery.AbstractTelBatteryHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import java.util.HashMap;
import java.util.Iterator;

public class TelEvoBatteryHandler
extends AbstractTelBatteryHandler {
    private static final int BATTERY_POPUP;
    private final ChoiceModelApp infoPopupModel;
    private final ITelApplication phoneApplication;
    private final HashMap popupShownMap = new HashMap(2);

    private static boolean isBatteryLevelLow(int n) {
        return n == 0 || n == 1;
    }

    private static boolean btDeviceAvailable(String string) {
        return !"".equals(string);
    }

    public TelEvoBatteryHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.infoPopupModel = iTelApplication.getFrameworkAccess().getHMIService().getChoiceModel(4343);
        this.phoneApplication = iTelApplication;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void handleBatteryChargeLevel(String string, String string2, int n) {
        this.log.log(-2137614336, "[TelEvoBatteryHandler#handleBatteryChargeLevel] called. meBTAddress=%2, batteryChargeLevel=%3, meFriendlyName=%1", (Object)string, (Object)string2, (Object)Integer.toString(n));
        HashMap hashMap = this.popupShownMap;
        synchronized (hashMap) {
            boolean bl;
            boolean bl2 = bl = this.popupShownMap.containsKey(string2) ? (Boolean)this.popupShownMap.get(string2) : false;
            if (bl) {
                this.log.log(1078071040, "[TelEvoBatteryHandler#handleBatteryChargeLevel] popup for (%1,%2) already shown --> NOP!", (Object)string, (Object)string2);
                return;
            }
            if (TelEvoBatteryHandler.btDeviceAvailable(string2)) {
                if (TelEvoBatteryHandler.isBatteryLevelLow(n)) {
                    if (this.isWLCPhoneBoxInstalled()) {
                        if (this.areInfoPopupsAvailable()) {
                            this.showBatteryWarningPopup(string2, n);
                            this.popupShownMap.put(string2, Boolean.TRUE);
                        } else {
                            this.log.log(1078071040, "[TelEvoBatteryHandler#handleBatteryChargeLevel] Info popups were desabled by user, NOT showing low battery level warning. InfoPopupModel.getValue()=%1", (long)this.infoPopupModel.getValue());
                        }
                    } else {
                        this.showBatteryWarningPopup(string2, n);
                        this.popupShownMap.put(string2, Boolean.TRUE);
                    }
                } else {
                    this.removeBatteryWarningPopup(string2, n);
                    this.popupShownMap.put(string2, Boolean.FALSE);
                }
            } else {
                this.removeBatteryWarningPopup(string2, n);
            }
            Iterator iterator = this.popupShownMap.keySet().iterator();
            while (iterator.hasNext()) {
                String string3 = (String)iterator.next();
                if (this.isConnectedViaSAPOrHFP(string3)) continue;
                this.log.log(-2137614336, "[TelEvoBatteryHandler#handleBatteryChargeLevel] removing btAddress %1 from map", (Object)string3);
                this.popupShownMap.remove(string3);
            }
        }
    }

    private void showBatteryWarningPopup(String string, int n) {
        this.log.log(1078071040, "[TelEvoBatteryHandler#showBatteryWarningPopup] meBTAddress=%1, batteryChargeLevel=%2", (Object)string, (Object)Integer.toString(n));
        this.phoneApplication.getFrameworkAccess().getHmiServiceApp().showPartialPopup(0, 898892800);
    }

    private void removeBatteryWarningPopup(String string, int n) {
        this.log.log(-2137614336, "[TelEvoBatteryHandler#removeBatteryWarningPopup] meBTAddress=%1, batteryChargeLevel=%2", (Object)string, (Object)Integer.toString(n));
        this.phoneApplication.getFrameworkAccess().getHmiServiceApp().removePartialPopup(0, 898892800);
    }

    private boolean areInfoPopupsAvailable() {
        return this.infoPopupModel != null && this.infoPopupModel.getValue() == 0;
    }

    private final boolean isWLCPhoneBoxInstalled() {
        return this.phoneApplication.getFrameworkAccess().getSysConst(4162) == 1;
    }
}

