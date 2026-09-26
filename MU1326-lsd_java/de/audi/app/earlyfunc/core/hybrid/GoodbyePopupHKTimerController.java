/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.ChargePopupHandler;
import de.audi.app.earlyfunc.core.hybrid.GoodbyePopupHKTimerController$1;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class GoodbyePopupHKTimerController {
    private static final long GOODBYE_POPUP_TIMEOUT;
    private static final long GOODBYE_POPUP_EXTENDED_TIMEOUT;
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
            int n;
            if (this.timer != null) {
                this.timer.cancel();
            }
            if ((n = 0 - (l = this.framework.getMonotonicTime() - this.start)) > 0L) {
                this.timer = new Timer("GOODBYE_POPUP_EXTENDED_TIMER", n, true, this.createTimerListener());
                this.timer.start();
            }
        } else {
            if (this.timer != null) {
                this.timer.cancel();
            }
            this.timer = new Timer("GOODBYE_POPUP_TIMER", 0, true, this.createTimerListener());
            this.timer.start();
            this.start = this.framework.getMonotonicTime();
            this.timerCanceledPrematurely = true;
        }
    }

    private TimerListener createTimerListener() {
        GoodbyePopupHKTimerController$1 goodbyePopupHKTimerController$1 = new GoodbyePopupHKTimerController$1(this);
        return goodbyePopupHKTimerController$1;
    }

    static /* synthetic */ ChargePopupHandler access$000(GoodbyePopupHKTimerController goodbyePopupHKTimerController) {
        return goodbyePopupHKTimerController.popupHandler;
    }

    static /* synthetic */ boolean access$102(GoodbyePopupHKTimerController goodbyePopupHKTimerController, boolean bl) {
        goodbyePopupHKTimerController.timerCanceledPrematurely = bl;
        return goodbyePopupHKTimerController.timerCanceledPrematurely;
    }
}

