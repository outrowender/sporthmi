/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.interapp.navuota.UotaNavListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import org.dsi.ifc.global.NavLocationWgs84;

public class UotANavListenerImpl
implements UotaNavListener,
TimerListener {
    private static final long WAIT_TIMEOUT;
    private static final int MAX_SHOT_COUNT;
    private final BaseUpdateOverTheAirController uotaController;
    private final LogChannel logChannel;
    private Timer waitServiceReadyTimer = null;
    private int shotCount = 0;
    private NavLocationWgs84[] locations;

    public UotANavListenerImpl(BaseUpdateOverTheAirController baseUpdateOverTheAirController, LogChannel logChannel) {
        this.uotaController = baseUpdateOverTheAirController;
        this.logChannel = logChannel;
    }

    private BaseUpdateOverTheAirController getUotaController() {
        return this.uotaController;
    }

    @Override
    public void startNewGuidance(int n, int n2, boolean bl) {
        if (bl) {
            this.logChannel.log(1078071040, "[UotaNavListenerImpl].startNewGuidance(%1,%2)", (long)n, (long)n2);
            if (this.waitServiceReadyTimer != null) {
                this.waitServiceReadyTimer.cancel();
            }
            NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(n2, n);
            this.locations = new NavLocationWgs84[1];
            this.locations[0] = navLocationWgs84;
            if (this.getUotaController().isServiceReady()) {
                this.getUotaController().startNewGuidance(this.locations);
            } else {
                this.logChannel.log(1078071040, "[UotaNavListenerImpl].startNewGuidance(%1,%2): UotA service is not ready, wait %3 sec", (long)n, (long)n2, (long)0);
                this.waitServiceReadyTimer = new Timer("Wait UOTA service ready", 0, false, this);
                this.waitServiceReadyTimer.start();
            }
        } else {
            this.logChannel.log(1078071040, "[UotaNavListenerImpl].startNewGuidance(): trigger is not valid, nothing to do.");
        }
    }

    @Override
    public void cancelLastGuidance() {
        this.logChannel.log(1078071040, "[UotaNavListenerImpl].cancelLastGuidance()");
        this.getUotaController().cancelLastGuidance();
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(this.waitServiceReadyTimer)) {
            if (this.shotCount > 150) {
                this.logChannel.log(10000, "[UotaNavListenerImpl].fireTimer(): timer achieves the max limit of shots, cancel timer");
                this.waitServiceReadyTimer.cancel();
                return;
            }
            if (this.getUotaController().isServiceReady()) {
                this.getUotaController().startNewGuidance(this.locations);
                this.waitServiceReadyTimer.cancel();
            } else {
                this.logChannel.log(-2137614336, "[UotaNavListenerImpl].fireTimer(): UotA service still not ready, wait %1 sec", (long)0);
                ++this.shotCount;
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        if (timer.equals(this.waitServiceReadyTimer)) {
            this.waitServiceReadyTimer = null;
            this.shotCount = 0;
        }
    }
}

