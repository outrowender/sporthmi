/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.earlyfunc.hybrid.EtronPopupHKTimerController$1;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;

public class EtronPopupHKTimerController {
    LogChannel logChan = null;
    ChoiceModelApp model = null;
    Timer timer = null;
    final long ETRON_POPUP_TIMEOUT;

    public EtronPopupHKTimerController(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.ETRON_POPUP_TIMEOUT = 0;
        this.logChan = logChannel;
        this.model = choiceModelApp;
    }

    public synchronized void activate() {
        if (this.timer != null) {
            this.timer.start();
        }
    }

    public synchronized void deactivate() {
        if (this.timer != null) {
            this.timer.cancel();
        }
    }

    public synchronized void resetActivated() {
        if (this.timer != null) {
            this.timer.cancel();
        }
        ChoiceModelApp choiceModelApp = this.model;
        EtronPopupHKTimerController$1 etronPopupHKTimerController$1 = new EtronPopupHKTimerController$1(this, choiceModelApp);
        this.timer = new Timer("ETRON_POPUP_TIMER", 0, true, etronPopupHKTimerController$1);
        this.timer.start();
    }
}

