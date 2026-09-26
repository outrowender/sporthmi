/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.NavRouteListData;

public class RouteInfoHandler$TravelData {
    long mDistCarToFinalDest = -1L;
    long mRttCarToFinalDest = -1L;
    int indexOfCurrentDestination = 0;
    NavRouteListData[] rgDestinationInfo = new NavRouteListData[0];

    public long getDistCarToDest() {
        return this.mDistCarToFinalDest;
    }

    public boolean isTravelDataValid() {
        return this.rgDestinationInfo != null && this.rgDestinationInfo.length > 0;
    }

    public long getRttCarToDest() {
        return this.mRttCarToFinalDest;
    }

    public long getDistCarToEvent(long l, int n) {
        return 0L;
    }

    public long getRttCarToEvent(long l, int n) {
        return 0L;
    }

    public String toString() {
        Buffer buffer = new Buffer("TravelData(");
        buffer.append("distCarToFinalDest: ").append(this.mDistCarToFinalDest);
        buffer.append("m, rttCarToFinalDest: ").append(this.mRttCarToFinalDest);
        buffer.append("s, currentDestIndex: ").append(this.indexOfCurrentDestination);
        buffer.append(')');
        return buffer.toString();
    }
}

