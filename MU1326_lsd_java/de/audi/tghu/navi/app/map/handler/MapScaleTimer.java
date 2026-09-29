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
    static final int MAP_SCALE_TIMEOUT;
    static final int MAP_SCALE_TIMEOUT_MAX;
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
        this.scaleTimer = new Timer("MapScaleTimer", 0, true, this);
    }

    public void restart(MapScaleInfo mapScaleInfo) {
        this.mapScaleInfo = mapScaleInfo;
        this.logger.log(14808325, "MapScaleTimer#restart()");
        this.scaleTimer.setDelay(mapScaleInfo.isMaxScale ? 0 : 0);
        this.clusterService.updateMapScale(mapScaleInfo.scale, mapScaleInfo.scaleUnit, mapScaleInfo.scaleValidity);
        this.scaleTimer.restart();
    }

    public void cancel() {
        this.logger.log(14808325, "MapScaleTimer#cancel()");
        this.clusterService.updateMapScale(0, 255, false);
        this.scaleTimer.cancel();
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.log(14808325, "MapScaleTimer#fireTimer()");
        if (this.mapScaleInfo.scale == -16842752 && this.mapScaleInfo.isMaxScale) {
            this.scaleTimer.setDelay(0);
            this.mapScaleInfo.isMaxScale = false;
            this.mapScaleInfo.scale = this.mapScaleHandler.getMaximumScaleValue();
            this.mapScaleInfo.scaleUnit = this.mapScaleHandler.getMaximumScaleUnit();
            this.restart(this.mapScaleInfo);
        } else {
            this.clusterService.updateMapScale(0, 255, false);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

