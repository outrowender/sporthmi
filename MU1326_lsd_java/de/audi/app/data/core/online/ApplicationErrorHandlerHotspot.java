/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.online.AbstractApplicationErrorHandler;
import de.audi.app.data.core.online.AnnoyingOrange;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class ApplicationErrorHandlerHotspot
extends AbstractApplicationErrorHandler
implements TimerListener {
    private static final String TIMER_NAME = "ErrorHandlerHotspotTimer";
    private static final long TIMER_DELAY = 30000L;
    private final AnnoyingOrange orange;
    private final Timer wlanTimer;
    private boolean isActive = false;
    private int errorWlan = 0;
    private boolean errorShown = false;
    private boolean isErrorStable = false;
    private boolean roamingDeactivatedShown = false;

    private static final boolean isError(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 18: {
                return true;
            }
        }
        return false;
    }

    private static final boolean isStableError(int n) {
        switch (n) {
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 14: 
            case 15: {
                return true;
            }
        }
        return false;
    }

    ApplicationErrorHandlerHotspot(AnnoyingOrange annoyingOrange) {
        this.orange = annoyingOrange;
        this.wlanTimer = new Timer(TIMER_NAME, 30000L, true, this);
    }

    void updateErrorState(int n, int n2) {
        this.wlanTimer.cancel();
        this.errorWlan = n2;
        this.errorShown = false;
        this.isErrorStable = ApplicationErrorHandlerHotspot.isStableError(n2);
        if (!this.isErrorStable) {
            this.wlanTimer.start();
        }
        if (n2 != 0 && n2 != 16 && n2 != 18) {
            this.roamingDeactivatedShown = false;
        }
    }

    void updateApplicationState(int n, boolean bl, boolean bl2) {
        this.isActive = bl && n != 3 && n != 4;
    }

    void notifyErrorShown(int n, int n2) {
        boolean bl = this.errorWlan == n2 && n2 != 14;
        boolean bl2 = this.errorShown = n == 1 || bl ? true : this.errorShown;
        if (n2 == 18) {
            this.roamingDeactivatedShown = true;
        }
    }

    boolean isActionRequired() {
        return this.isActive && ApplicationErrorHandlerHotspot.isError(this.errorWlan) && !this.errorShown && this.isErrorStable && this.orange.isStartupOverAndClampOn() && !this.isReconnectBlocking() && !this.errorSuppressed(this.errorWlan);
    }

    private boolean isReconnectBlocking() {
        return !ApplicationErrorHandlerHotspot.isStableError(this.errorWlan) && this.orange.isReconnect();
    }

    private boolean errorSuppressed(int n) {
        return n == 18 && this.roamingDeactivatedShown;
    }

    void roamingSettingDeactivatedByUser() {
        this.roamingDeactivatedShown = true;
    }

    public void fireTimer(Timer timer) {
        if (TIMER_NAME.equals(timer.getName())) {
            this.isErrorStable = true;
            this.orange.retriggerErrorPresentation();
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

