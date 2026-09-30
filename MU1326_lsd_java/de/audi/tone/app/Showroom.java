/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AbstractAppListener;

public class Showroom
extends AbstractAppListener
implements TimerListener {
    private static final int PORSCHE_PARTIAL_POPUP_ID = 335;
    private static final int POPUP_ID = 4711;
    private final ToneEnv env;
    private final Timer showPopupTimer = new Timer("ShowPopupTimer", 2000L, true, this);
    private volatile boolean muteStandbyActive;
    private volatile boolean muteTheftProtectionActive;

    public Showroom(ToneEnv toneEnv) {
        this.env = toneEnv;
    }

    public void updateMuteTheftProtection(boolean bl) {
        this.env.lcMain.log(10000000, "[Showroom.updateMuteTheftProtection] muteTheftProtection:%1", bl);
        this.muteTheftProtectionActive = bl;
        if (bl) {
            this.showPopup();
        } else {
            this.hidePopup();
        }
    }

    public void updateConnectionStatus(int n, int n2, int n3) {
        if (n != 3) {
            return;
        }
        switch (n2) {
            case 2: {
                this.muteStandbyActive = true;
                break;
            }
            case 5: {
                this.muteStandbyActive = false;
                this.showPopup();
                break;
            }
        }
    }

    private void showPopup() {
        this.env.lcMain.log(10000000, "[Showroom.showPopup] muteTheftProtection:%1 muteStandby:%2", this.muteTheftProtectionActive, this.muteStandbyActive);
        if (this.muteTheftProtectionActive && !this.muteStandbyActive && !this.showPopupTimer.isRunning()) {
            this.showPopupTimer.start();
            if (this.env.isPorsche()) {
                this.env.showPartialPopup(335);
            }
        }
    }

    private void hidePopup() {
        this.env.lcMain.log(10000000, "[Showroom.hidePopup] muteTheftProtection:%1", this.muteTheftProtectionActive);
        if (!this.muteTheftProtectionActive) {
            this.env.lcHMI.log(10000000, "[Showroom.hidePopup] remove popup");
            this.showPopupTimer.cancel();
            this.env.removePopup(4711);
            if (this.env.isPorsche()) {
                this.env.removePartialPopup(335);
            }
        }
    }

    public void fireTimer(Timer timer) {
        this.env.lcHMI.log(10000000, "[Showroom.fireTimer] show popup");
        this.env.showPopup(4711);
    }

    public void cancelTimer(Timer timer) {
    }
}

