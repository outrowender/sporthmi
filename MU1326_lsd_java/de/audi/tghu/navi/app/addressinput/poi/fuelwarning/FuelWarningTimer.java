/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.FuelWarningTimer$1;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IPoiFuelWarningService;

public class FuelWarningTimer {
    private static final int FUEL_WARNING_TIMERDELAY;
    protected Timer timer;
    public NavigationEnv env;
    public LogChannel logChannel;
    public IPoiFuelWarningService fuelWarningService;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$addressinput$poi$fuelwarning$FuelWarningTimer;

    protected FuelWarningTimer(NavigationEnv navigationEnv, LogChannel logChannel, IPoiFuelWarningService iPoiFuelWarningService) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.fuelWarningService = iPoiFuelWarningService;
        FuelWarningTimer$1 fuelWarningTimer$1 = new FuelWarningTimer$1(this, logChannel);
        this.timer = new Timer("fuelWarningTimer", 5, logChannel, fuelWarningTimer$1, 0, false);
    }

    public void start() {
        if (!this.timer.isRunning()) {
            this.timer.restart();
        }
    }

    public void stop() {
        this.timer.cancel();
    }

    private void showPopup() {
        this.fuelWarningService.checkPendingEvents();
        this.stop();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$000(FuelWarningTimer fuelWarningTimer) {
        fuelWarningTimer.showPopup();
    }
}

