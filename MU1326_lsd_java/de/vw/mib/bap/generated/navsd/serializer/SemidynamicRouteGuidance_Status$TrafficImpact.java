/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$TrafficImpact
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean alternativeRouteAvailable;
    public boolean trafficImpactOnCurrentRoute;
    private static final int TRAFFIC_IMPACT_BITSIZE;

    public SemidynamicRouteGuidance_Status$TrafficImpact() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$TrafficImpact(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.alternativeRouteAvailable = false;
        this.trafficImpactOnCurrentRoute = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$TrafficImpact semidynamicRouteGuidance_Status$TrafficImpact = (SemidynamicRouteGuidance_Status$TrafficImpact)bAPEntity;
        return this.alternativeRouteAvailable == semidynamicRouteGuidance_Status$TrafficImpact.alternativeRouteAvailable && this.trafficImpactOnCurrentRoute == semidynamicRouteGuidance_Status$TrafficImpact.trafficImpactOnCurrentRoute;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TrafficImpact:");
        stringBuffer.append("\n - Bit 1: ");
        if (this.alternativeRouteAvailable) {
            stringBuffer.append("true  (alternative route available");
        } else {
            stringBuffer.append("false  (no alternative route available");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.trafficImpactOnCurrentRoute) {
            stringBuffer.append("true  (traffic impact on current route");
        } else {
            stringBuffer.append("false  (no traffic impact on current route or unknown");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.alternativeRouteAvailable);
        bitStream.pushBoolean(this.trafficImpactOnCurrentRoute);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.alternativeRouteAvailable = bitStream.popFrontBoolean();
        this.trafficImpactOnCurrentRoute = bitStream.popFrontBoolean();
    }
}

