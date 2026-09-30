/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.util;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class PopupHandler
implements TimerListener {
    public static final int MIN_POPUP_SHOW_DURATION = 3000;
    private HMIService hmiService;
    private LogChannel log;
    private Timer timer;
    private int popupId;
    private boolean removePopupDelayed;

    public PopupHandler(int n, int n2, HMIService hMIService, LogChannel logChannel) {
        this.hmiService = hMIService;
        this.log = logChannel;
        this.popupId = n;
        this.timer = new Timer("Popup show duration timer", n2, true, this);
    }

    public PopupHandler(int n, HMIService hMIService, LogChannel logChannel) {
        this(n, 3000, hMIService, logChannel);
    }

    public void showPopup() {
        if (!this.timer.isRunning()) {
            this.hmiService.showPopup(this.popupId);
            this.timer.start();
        } else {
            this.removePopupDelayed = false;
        }
    }

    public void removePopup() {
        if (!this.timer.isRunning()) {
            this.hmiService.removePopup(this.popupId);
        } else {
            this.removePopupDelayed = true;
        }
    }

    public void fireTimer(Timer timer) {
        this.log.log(1000000, "PopupHandler#fireTimer minimum popup show duration expired");
        this.handlePopups();
    }

    public void cancelTimer(Timer timer) {
    }

    public void popupRemoved(int n, int n2) {
        if (this.timer.isRunning() && n == this.popupId) {
            this.timer.cancel();
        }
    }

    private void handlePopups() {
        if (this.removePopupDelayed) {
            this.log.log(1000000, "PopupHandler#fireTimer minimum popup show duration expired, removing delayed popup id=%1", (long)this.popupId);
            this.removePopupDelayed = false;
            this.hmiService.removePopup(this.popupId);
        }
    }
}

