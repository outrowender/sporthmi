/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService$UpdateTrafficSignCommand$1;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService$UpdateTrafficSignCommand$2;
import de.audi.tghu.navi.app.tr.TrafficRegulationService$CurrentTrafficSignObserver;
import de.audi.tghu.navi.app.tr.TrafficUtil;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

class TrafficRegulationInterAppService$UpdateTrafficSignCommand
extends NavCommand
implements TrafficRegulationService$CurrentTrafficSignObserver {
    private final NaviServiceListener naviServiceListener;
    private final Timer updateTrafficSignTimer;
    private static final long UPDATE_TRAFFIC_SIGN_TIMEOUT;
    private final Object mutex = new Object();
    private volatile boolean updateReceived = false;
    private boolean stillListeningForUpdates = true;
    private final /* synthetic */ TrafficRegulationInterAppService this$0;

    public TrafficRegulationInterAppService$UpdateTrafficSignCommand(TrafficRegulationInterAppService trafficRegulationInterAppService, NaviServiceListener naviServiceListener) {
        this.this$0 = trafficRegulationInterAppService;
        this.naviServiceListener = naviServiceListener;
        this.updateTrafficSignTimer = new Timer("Stop waiting for update Timer", 0, true, this);
    }

    @Override
    public void execute() {
        this.updateTrafficSignTimer.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = this.mutex;
        synchronized (object) {
            if (!this.updateReceived) {
                this.logger.log(-2137614336, "%1#fireTimer - timeout of %2 ms reached, waiting for updates will be stopped.", (Object)this.CLASS_NAME, (long)0);
                this.turnOffListeningForUpdates();
                this.getCommandList().commandFinishedWithPostCommand(new TrafficRegulationInterAppService$UpdateTrafficSignCommand$1(this, this.naviServiceListener));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.stillListeningForUpdates) {
                int n;
                this.updateReceived = true;
                this.turnOffListeningForUpdates();
                this.logger.log(-2137614336, "%1#updateCurrentTrafficSign - currentTrafficSign=%2", (Object)this.CLASS_NAME, (Object)trafficSignInformation);
                this.updateTrafficSignTimer.cancel();
                int n2 = 0;
                if (trafficSignInformation != null && (n = TrafficUtil.retrieveCurrentSignID(trafficSignInformation)) != -1) {
                    n2 = TrafficUtil.extractSpeedLimitFromSignID(n);
                }
                n = n2;
                byte by = TrafficRegulationInterAppService.access$000(this.this$0).getCurrentSpeedLimitUnit();
                byte by2 = n == 0 || by == -1 ? (byte)3 : 0;
                this.logger.log(-2137614336, "UpdateTrafficSignCommand#updateCurrentTrafficSign() - notify SDS with result=%1, currentSpeedLimit=%2, currentSpeedLimitUnit=%3", (long)by2, (long)n, (long)by);
                this.getCommandList().commandFinishedWithPostCommand(new TrafficRegulationInterAppService$UpdateTrafficSignCommand$2(this, this.naviServiceListener, by2, n, by));
            }
        }
    }

    private void turnOffListeningForUpdates() {
        TrafficRegulationInterAppService.access$000(this.this$0).registerCurrentTrafficSignObserver(null);
        this.stillListeningForUpdates = false;
        if (!TrafficUtil.isTrafficRegulationInfoEnabled(this.env)) {
            TrafficRegulationInterAppService.access$000(this.this$0).setEnableTrafficRegulationInfo(false);
        }
    }
}

