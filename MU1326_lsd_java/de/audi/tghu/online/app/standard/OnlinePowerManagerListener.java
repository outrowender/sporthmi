/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.online.app.standard.OnlinePowerManagerListener$1;

public class OnlinePowerManagerListener
implements PowerEventListener {
    private static final int EPS_ENABLED;
    private static final int EPS_DISABLED;
    private final IPowerManager pwrManager;
    private final Timer popupTimer;
    private volatile boolean isPopupHintShowing = false;
    private HMIService hmiService;
    private LogChannel log;
    private int popupId;
    private boolean clamp15old;
    private boolean usersAvailable;
    private boolean privacyModeActive;
    private boolean alertServiceActive;

    public OnlinePowerManagerListener(HMIService hMIService, LogChannel logChannel, int n, IPowerManager iPowerManager, Timer timer) {
        this.hmiService = hMIService;
        this.log = logChannel;
        this.popupId = n;
        this.pwrManager = iPowerManager;
        this.popupTimer = timer != null ? timer : new Timer("HintPopupTimer", 0, true, new OnlinePowerManagerListener$1(this));
    }

    public OnlinePowerManagerListener(HMIService hMIService, LogChannel logChannel, int n, IPowerManager iPowerManager) {
        this(hMIService, logChannel, n, iPowerManager, null);
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.log.log(1078071040, "OnlinePowerManagerListener#updateClampState clampS: %1, clamp15: %2; clampX: %3, clamp50: %4", (Object)Boolean.toString(bl), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl3), (Object)Boolean.toString(bl4));
        if (!bl2 && this.clamp15old) {
            if (!this.isPopupHintShowing && this.isPopupAllowed()) {
                this.showHintPopup();
                this.popupTimer.start();
            } else {
                this.log.log(1078071040, "OnlinePowerManagerListener#updateClampState clamp15 off, hint popup '%1' either already displayed or not allowed", (long)this.popupId);
            }
        } else if (bl2 && !this.clamp15old) {
            if (this.isPopupHintShowing) {
                this.popupTimer.cancel();
                this.removeHintPopup();
            } else {
                this.log.log(1078071040, "OnlinePowerManagerListener#updateClampState clamp15 on");
            }
        } else {
            this.log.log(1078071040, "OnlinePowerManagerListener#updateClampState unsupported clamp change");
        }
        this.clamp15old = bl2;
    }

    private boolean isPopupAllowed() {
        this.log.log(-2137614336, "OnlinePowerManagerListener#isPopupAllowed usersAvailable: %1, privacyModeActive: %2, alertServiceActive: %3", (Object)String.valueOf(this.usersAvailable), (Object)String.valueOf(this.privacyModeActive), (Object)String.valueOf(this.alertServiceActive));
        boolean bl = this.usersAvailable && (!this.privacyModeActive || this.alertServiceActive);
        this.log.log(-2137614336, "OnlinePowerManagerListener#isPopupAllowed result: %1", bl);
        return bl;
    }

    public void indicateUsersAvailable(boolean bl) {
        this.log.log(-2137614336, "OnlinePowerManagerListener#indicateUsersAvailable: %1", bl);
        this.usersAvailable = bl;
    }

    public void setPrivacyMode(boolean bl) {
        this.log.log(-2137614336, "OnlinePowerManagerListener#setPrivacyMode privacyModeActive: %1", bl);
        this.privacyModeActive = bl;
    }

    public void setAlertServiceActive(boolean bl) {
        this.log.log(-2137614336, "OnlinePowerManagerListener#setAlertServiceActive alertServiceActive: %1", bl);
        this.alertServiceActive = bl;
    }

    private void showHintPopup() {
        this.log.log(1078071040, "OnlinePowerManagerListener#showHintPopup '%1'", (long)this.popupId);
        this.hmiService.showPopup(this.popupId);
        this.isPopupHintShowing = true;
        this.setPowerState(166);
    }

    private void setPowerState(int n) {
        this.log.log(1078071040, "OnlinePowerManagerListener#setPowerState setting EPS to '%1'", (Object)OnlinePowerManagerListener.getEPSName(n));
        this.pwrManager.setExtendedPowerState(n, 0);
    }

    private static String getEPSName(int n) {
        switch (n) {
            case 166: {
                return "ENABLED";
            }
            case 167: {
                return "DISABLED";
            }
        }
        return new StringBuffer().append("Unknown EPS ").append(n).toString();
    }

    private void removeHintPopup() {
        this.log.log(1078071040, "OnlinePowerManagerListener#removeHintPopup '%1'", (long)this.popupId);
        this.setPowerState(167);
        this.hmiService.removePopup(this.popupId);
        this.isPopupHintShowing = false;
    }

    static /* synthetic */ void access$000(OnlinePowerManagerListener onlinePowerManagerListener) {
        onlinePowerManagerListener.removeHintPopup();
    }
}

