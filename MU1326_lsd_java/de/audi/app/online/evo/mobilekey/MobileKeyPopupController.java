/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.mobilekey;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;

public class MobileKeyPopupController
implements MsgListener {
    private final HMIService hmiService;
    private final LogChannel log;
    private boolean lockingActive = false;

    public MobileKeyPopupController(HMIService hMIService, LogChannel logChannel) {
        this.hmiService = hMIService;
        this.log = logChannel;
    }

    private boolean isLockingConceptCoded() {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(5601);
        boolean bl = false;
        if (choiceModelApp != null) {
            bl = choiceModelApp.getValue() == 1;
        } else {
            this.log.log(10000, "MobileKeyPopupController#isLockingConceptCoded: Drawer blocking bit model is null!");
        }
        this.log.log(10000000, "MobileKeyPopupController#isLockingConceptCoded: blocking: %1", bl);
        return bl;
    }

    private boolean isLockingConceptActive() {
        this.log.log(10000000, "MobileKeyPopupController#isLockingConceptActive: active: %1", this.lockingActive);
        return this.lockingActive;
    }

    private boolean isPopupAllowed() {
        this.log.log(10000000, "MobileKeyPopupController#isPopupAllowed");
        if (!this.isLockingConceptCoded()) {
            this.log.log(10000000, "MobileKeyPopupController#isPopupAllowed: locking concept not coded, popups allowed.");
            return true;
        }
        boolean bl = !this.isLockingConceptActive();
        this.log.log(10000000, "MobileKeyPopupController#isPopupAllowed: locking concept coded, popups: %1.", bl);
        return bl;
    }

    public void showPopup(int n, boolean bl) {
        this.log.log(1000000, "MobileKeyPopupController#showPopup");
        if (!this.isPopupAllowed()) {
            this.log.log(1000000, "MobileKeyPopupController#showPopup: popups not allowed!");
            return;
        }
        this.log.log(1000000, "MobileKeyPopupController#showPopup: show popup. id: %1, partial: %2", (Object)Integer.toString(n), (Object)Boolean.toString(bl));
        if (bl) {
            this.hmiService.showPartialPopup(0, n);
        } else {
            this.hmiService.showPopup(n);
        }
    }

    public void processMsg(int n) {
        if (n == 206) {
            this.log.log(1000000, "MobileKeyPopupController#processMsg: Locking concept enabled");
            this.lockingActive = true;
        } else if (n == 207) {
            this.log.log(1000000, "MobileKeyPopupController#processMsg: Locking concept disabled");
            this.lockingActive = false;
        }
    }
}

