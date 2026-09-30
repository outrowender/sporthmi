/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.online.AbstractErrorHandler;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class AnnoyingOrange
implements TimerListener,
PowerEventListener {
    private static final String TIMER_STARTUP_NAME = "OrangeStartupTimer";
    private static final long TIMER_STARTUP_DELAY = 90000L;
    private static final String TIMER_CLAMP_S_UP_NAME = "OrangeClampSUpTimer";
    private static final long TIMER_CLAMP_S_UP_DELAY = 3000L;
    private static final String TIMER_RSAP_RECONNECT_NAME = "OrangeReconnectTimer";
    private static final long TIMER_RSAP_RECONNECT_DELAY = 90000L;
    private final AbstractErrorHandler errorHandler;
    private final Timer clampSTimer;
    private final Timer reconnectTimer;
    private volatile boolean isStartupTimerFinished = false;
    private volatile boolean isClampS;
    private volatile boolean isReconnect;
    private volatile boolean isTethering;
    private volatile boolean isTrustedNetworkAvailable;

    public AnnoyingOrange(AbstractErrorHandler abstractErrorHandler) {
        this.errorHandler = abstractErrorHandler;
        new Timer(TIMER_STARTUP_NAME, 90000L, true, this).start();
        this.clampSTimer = new Timer(TIMER_CLAMP_S_UP_NAME, 3000L, true, this);
        this.reconnectTimer = new Timer(TIMER_RSAP_RECONNECT_NAME, 90000L, true, this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void updateReconnectInfo(boolean bl) {
        this.isReconnect = bl;
        Timer timer = this.clampSTimer;
        synchronized (timer) {
            if (this.isStartupTimerFinished && this.clampSTimer.isRunning() && bl) {
                this.clampSTimer.cancel();
                this.reconnectTimer.start();
            }
        }
    }

    void updateWlanMode(boolean bl, boolean bl2) {
        this.isTethering = bl && bl2;
        this.updateWlanReconnect();
    }

    void updateTrustedNetworks(boolean bl) {
        this.isTrustedNetworkAvailable = bl;
        this.updateWlanReconnect();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateWlanReconnect() {
        Timer timer = this.clampSTimer;
        synchronized (timer) {
            if (this.isStartupTimerFinished && this.clampSTimer.isRunning() && this.isWlanReconnect()) {
                this.clampSTimer.cancel();
                this.reconnectTimer.start();
            }
        }
    }

    boolean isStartupOverAndClampOn() {
        return this.isStartupTimerFinished && this.isClampS;
    }

    boolean isReconnect() {
        return this.clampSTimer.isRunning() || this.reconnectTimer.isRunning();
    }

    public void fireTimer(Timer timer) {
        if (TIMER_STARTUP_NAME.equals(timer.getName())) {
            this.isStartupTimerFinished = true;
            this.retriggerErrorPresentation();
        } else if (TIMER_CLAMP_S_UP_NAME.equals(timer.getName())) {
            this.retriggerErrorPresentation();
        } else if (TIMER_RSAP_RECONNECT_NAME.equals(timer.getName())) {
            this.retriggerErrorPresentation();
        }
    }

    void retriggerErrorPresentation() {
        this.errorHandler.reaction();
    }

    public void cancelTimer(Timer timer) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl != this.isClampS) {
            this.isClampS = bl;
            this.updateClampS(bl);
        }
    }

    private void updateClampS(boolean bl) {
        if (this.isStartupTimerFinished) {
            if (bl) {
                if (this.isReconnect) {
                    this.reconnectTimer.start();
                } else {
                    this.clampSTimer.start();
                }
            } else {
                this.clampSTimer.cancel();
                this.reconnectTimer.cancel();
            }
        }
    }

    private boolean isWlanReconnect() {
        return this.isTethering && this.isTrustedNetworkAvailable;
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }
}

