/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class EtronPopupHKTimerController {
    LogChannel logChan = null;
    ChoiceModelApp model = null;
    Timer timer = null;
    final long ETRON_POPUP_TIMEOUT;

    public EtronPopupHKTimerController(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.ETRON_POPUP_TIMEOUT = 6000L;
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
        final ChoiceModelApp choiceModelApp = this.model;
        TimerListener timerListener = new TimerListener(){

            public void fireTimer(Timer timer) {
                choiceModelApp.setValue(0);
            }

            public void cancelTimer(Timer timer) {
            }
        };
        this.timer = new Timer("ETRON_POPUP_TIMER", 6000L, true, timerListener);
        this.timer.start();
    }
}

