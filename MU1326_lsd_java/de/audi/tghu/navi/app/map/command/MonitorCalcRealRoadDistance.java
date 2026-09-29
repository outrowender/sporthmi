/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.global.NavLocationWgs84;

public class MonitorCalcRealRoadDistance
extends Monitor {
    NavLocationWgs84 navLocationWgs84;

    public MonitorCalcRealRoadDistance(LogChannel logChannel, NavLocationWgs84 navLocationWgs84) {
        super(logChannel);
        this.navLocationWgs84 = navLocationWgs84;
    }

    public boolean equalsNavLocation(NavLocationWgs84 navLocationWgs84) {
        return this.navLocationWgs84.longitude == navLocationWgs84.longitude && this.navLocationWgs84.latitude == navLocationWgs84.latitude;
    }
}

