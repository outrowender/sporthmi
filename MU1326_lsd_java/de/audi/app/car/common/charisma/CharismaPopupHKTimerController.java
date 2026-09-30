/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.charisma;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class CharismaPopupHKTimerController {
    LogChannel logChan = null;
    ChoiceModelApp model = null;
    private static final int MODEL_VALUE_TIMER_ACTIVE = 0;
    private static final int MODEL_VALUE_TIMER_INACTIVE = -1;

    public CharismaPopupHKTimerController(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.logChan = logChannel;
        this.model = choiceModelApp;
    }

    public synchronized void activate() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1000000, "CharismaPopupHKTimerController: Timer is activated");
        }
        this.setChoiceModelValue(0);
        this.setChoiceModelStatus(1);
    }

    public synchronized void deactivate() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1000000, "CharismaPopupHKTimerController: Timer is deactivated");
        }
        this.setChoiceModelValue(-1);
        this.setChoiceModelStatus(0);
    }

    public synchronized void resetActivated() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1000000, "CharismaPopupHKTimerController: Timer is resetted and activated");
        }
        this.setChoiceModelStatus(0);
        this.setChoiceModelValue(0);
        this.setChoiceModelStatus(1);
    }

    private void setChoiceModelStatus(int n) {
        this.model.setStatus(n);
    }

    private void setChoiceModelValue(int n) {
        this.model.setValue(n);
    }
}

