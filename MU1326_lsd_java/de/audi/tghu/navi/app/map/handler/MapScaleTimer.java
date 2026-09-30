/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.map.handler.MapScaleHandler;
import de.audi.tghu.navi.app.map.handler.MapScaleInfo;

public class MapScaleTimer
implements TimerListener {
    static final int MAP_SCALE_TIMEOUT = 3000;
    static final int MAP_SCALE_TIMEOUT_MAX = 2000;
    private final NavigationEnv env;
    private final ClusterService clusterService;
    private final MapScaleHandler mapScaleHandler;
    private final LogChannel logger;
    private final Timer scaleTimer;
    public MapScaleInfo mapScaleInfo;

    public MapScaleTimer(NavigationEnv navigationEnv, ClusterService clusterService, MapScaleHandler mapScaleHandler) {
        this.env = navigationEnv;
        this.clusterService = clusterService;
        this.mapScaleHandler = mapScaleHandler;
        this.logger = navigationEnv.getClusterKOMOLogChannel();
        this.scaleTimer = new Timer("MapScaleTimer", 3000L, true, this);
    }

    public void restart(MapScaleInfo mapScaleInfo) {
        this.mapScaleInfo = mapScaleInfo;
        this.logger.log(100000000, "MapScaleTimer#restart()");
        this.scaleTimer.setDelay(mapScaleInfo.isMaxScale ? 2000L : 3000L);
        this.clusterService.updateMapScale(mapScaleInfo.scale, mapScaleInfo.scaleUnit, mapScaleInfo.scaleValidity);
        this.scaleTimer.restart();
    }

    public void cancel() {
        this.logger.log(100000000, "MapScaleTimer#cancel()");
        this.clusterService.updateMapScale(0, 255, false);
        this.scaleTimer.cancel();
    }

    public void fireTimer(Timer timer) {
        this.logger.log(100000000, "MapScaleTimer#fireTimer()");
        if (this.mapScaleInfo.scale == 65534 && this.mapScaleInfo.isMaxScale) {
            this.scaleTimer.setDelay(2000L);
            this.mapScaleInfo.isMaxScale = false;
            this.mapScaleInfo.scale = this.mapScaleHandler.getMaximumScaleValue();
            this.mapScaleInfo.scaleUnit = this.mapScaleHandler.getMaximumScaleUnit();
            this.restart(this.mapScaleInfo);
        } else {
            this.clusterService.updateMapScale(0, 255, false);
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

