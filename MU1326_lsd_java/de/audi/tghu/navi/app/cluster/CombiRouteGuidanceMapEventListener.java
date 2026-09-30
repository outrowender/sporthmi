/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.map.event.MapEventListener;

public class CombiRouteGuidanceMapEventListener
implements MapEventListener {
    private final LogChannel logger;
    private final CombiBAPListener combiBAPListener;

    public CombiRouteGuidanceMapEventListener(LogChannel logChannel, CombiBAPListener combiBAPListener) {
        this.logger = logChannel;
        this.combiBAPListener = combiBAPListener;
    }

    public void onEvent(int n, int n2) {
        this.logger.log(10000000, "CombiRouteGuidanceMapEventListener#onEvent() eventId=%1, value=%2", (long)n, (long)n2);
        if (n == 211) {
            this.combiBAPListener.routeGuidanceActDeactResult(1);
        }
        if (n == 202) {
            this.combiBAPListener.routeGuidanceActDeactResult(1);
        }
        if (n == 212) {
            this.combiBAPListener.routeGuidanceActDeactResult(0);
        } else {
            this.logger.log(100000000, "CombiRouteGuidanceMapEventListener#onEvent() unknown eventId");
        }
    }
}

