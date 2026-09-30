/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.ChargePopupHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class GoodbyePopupHKTimerController {
    private static final long GOODBYE_POPUP_TIMEOUT = 120000L;
    private static final long GOODBYE_POPUP_EXTENDED_TIMEOUT = 240000L;
    private ChargePopupHandler popupHandler = null;
    private IFrameworkAccess framework;
    private LogChannel logChannel = null;
    private Timer timer = null;
    private boolean timerCanceledPrematurely = false;
    private long start = 0L;

    public GoodbyePopupHKTimerController(ChargePopupHandler chargePopupHandler, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.popupHandler = chargePopupHandler;
        this.framework = iFrameworkAccess;
    }

    public synchronized void activate() {
    }

    public synchronized void deactivate() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timerCanceledPrematurely = false;
        }
    }

    public synchronized void resetActivated() {
        if (this.timerCanceledPrematurely) {
            long l;
            long l2;
            if (this.timer != null) {
                this.timer.cancel();
            }
            if ((l2 = 240000L - (l = this.framework.getMonotonicTime() - this.start)) > 0L) {
                this.timer = new Timer("GOODBYE_POPUP_EXTENDED_TIMER", l2, true, this.createTimerListener());
                this.timer.start();
            }
        } else {
            if (this.timer != null) {
                this.timer.cancel();
            }
            this.timer = new Timer("GOODBYE_POPUP_TIMER", 120000L, true, this.createTimerListener());
            this.timer.start();
            this.start = this.framework.getMonotonicTime();
            this.timerCanceledPrematurely = true;
        }
    }

    private TimerListener createTimerListener() {
        TimerListener timerListener = new TimerListener(){
            private boolean shouldFire = true;

            public void fireTimer(Timer timer) {
                if (this.shouldFire) {
                    GoodbyePopupHKTimerController.this.popupHandler.removePopup();
                    GoodbyePopupHKTimerController.this.timerCanceledPrematurely = false;
                }
            }

            public void cancelTimer(Timer timer) {
                this.shouldFire = false;
                GoodbyePopupHKTimerController.this.timerCanceledPrematurely = true;
            }
        };
        return timerListener;
    }
}

