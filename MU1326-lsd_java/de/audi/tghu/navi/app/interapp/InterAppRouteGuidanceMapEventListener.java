/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.event.MapEventListener;

public class InterAppRouteGuidanceMapEventListener
implements MapEventListener {
    private final NaviServiceListener listener;
    private final LogChannel logger;

    public InterAppRouteGuidanceMapEventListener(NaviServiceListener naviServiceListener, LogChannel logChannel) {
        this.listener = naviServiceListener;
        this.logger = logChannel;
    }

    @Override
    public void onEvent(int n, int n2) {
        this.logger.log(-2137614336, "InterAppRouteGuidanceMapEventListener#onEvent() eventId=%1, value=%2", (long)n, (long)n2);
        if (n == 211) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "InterAppRouteGuidanceMapEventListener#onEvent() response SDS with RESULT_INVALID");
            }
            this.listener.responseStartRouteGuidance((byte)3);
        } else if (n == 202) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "InterAppRouteGuidanceMapEventListener#onEvent() response SDS with RESULT_ERROR");
            }
            this.listener.responseStartRouteGuidance((byte)1);
        } else if (n == 212) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "InterAppRouteGuidanceMapEventListener#onEvent() response SDS with RESULT_OK");
            }
            this.listener.responseStartRouteGuidance((byte)0);
        } else if (this.logger.isDebug2()) {
            this.logger.log(14808325, "InterAppRouteGuidanceMapEventListener#onEvent() unknown eventId");
        }
    }
}

