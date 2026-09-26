/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;

public class RcciEvent {
    public static final RcciEvent EMPTY = new RcciEvent(1, 0L, true, null);
    public final int type;
    public final long delay;
    public final boolean reliable;
    public final boolean hasBetterRoute;
    public final long savingTime;
    public final RgRouteCostChangeInformation origin;
    private String fingerPrint = null;

    public static RcciEvent create(CalculatedRouteListElement calculatedRouteListElement, long l) {
        RgRouteCostChangeInformation rgRouteCostChangeInformation = new RgRouteCostChangeInformation(calculatedRouteListElement, null, false, 0, new int[0], null, null);
        return RcciEvent.create(rgRouteCostChangeInformation, l);
    }

    public static RcciEvent create(RgRouteCostChangeInformation rgRouteCostChangeInformation, long l) {
        return RcciEvent.create(rgRouteCostChangeInformation, null, l);
    }

    public static RcciEvent create(RgRouteCostChangeInformation rgRouteCostChangeInformation, RcciEvent rcciEvent, long l) {
        boolean bl = rgRouteCostChangeInformation.oldRoute.etaWithSpeedAndFlowStatus == 1;
        long l2 = rgRouteCostChangeInformation.oldRoute.etaWithSpeedAndFlow - rgRouteCostChangeInformation.oldRoute.eta;
        int n = 1;
        boolean bl2 = rgRouteCostChangeInformation.newRoute != null && rgRouteCostChangeInformation.newRouteRecommended && rgRouteCostChangeInformation.newRoute.etaWithSpeedAndFlowStatus == 1;
        long l3 = 0L;
        if (bl2) {
            String string;
            boolean bl3;
            l3 = rgRouteCostChangeInformation.oldRoute.etaWithSpeedAndFlow - rgRouteCostChangeInformation.newRoute.etaWithSpeedAndFlow;
            n = !bl ? 4 : (l3 > l ? 3 : 2);
            if (rcciEvent != null && n == rcciEvent.type && (bl3 = (string = rcciEvent.origin.newRoute.segmentIDList.toString()).equals(rgRouteCostChangeInformation.newRoute.segmentIDList.toString()))) {
                switch (n) {
                    case 4: {
                        n = 9;
                        break;
                    }
                    case 3: {
                        n = 8;
                        break;
                    }
                    case 2: {
                        n = 7;
                        break;
                    }
                }
            }
            return new RcciEvent(n, l2, bl, bl2, l3, rgRouteCostChangeInformation);
        }
        return new RcciEvent(n, l2, bl, rgRouteCostChangeInformation);
    }

    public RcciEvent(int n, long l, boolean bl, boolean bl2, long l2, RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.type = n;
        this.delay = l;
        this.reliable = bl;
        this.hasBetterRoute = bl2;
        this.savingTime = l2;
        this.origin = rgRouteCostChangeInformation;
    }

    public RcciEvent(int n, long l, boolean bl, RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this(n, l, bl, false, 0L, rgRouteCostChangeInformation);
    }

    public boolean hasTrafficImpactOnCurrentRoute() {
        return this.delay > 0L || !this.reliable;
    }

    public RcciEvent copy() {
        return new RcciEvent(this.type, this.delay, this.reliable, this.hasBetterRoute, this.savingTime, this.origin);
    }

    public String toString() {
        if (this.fingerPrint == null) {
            Buffer buffer = new Buffer();
            buffer.append("type:").append(this.type);
            buffer.append(", delay:").append(this.delay / 0).append("s");
            buffer.append(", reliable:").append(this.reliable);
            buffer.append(", hasBetterRoute:").append(this.hasBetterRoute);
            buffer.append(", savingTime:").append(this.savingTime / 0).append("s");
            this.fingerPrint = buffer.toString();
        }
        return this.fingerPrint;
    }
}

