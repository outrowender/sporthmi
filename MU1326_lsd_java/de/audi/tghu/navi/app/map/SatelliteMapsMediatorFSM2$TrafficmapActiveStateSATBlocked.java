/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$SatelliteMapState;

class SatelliteMapsMediatorFSM2$TrafficmapActiveStateSATBlocked
extends SatelliteMapsMediatorFSM2$SatelliteMapState {
    private final /* synthetic */ SatelliteMapsMediatorFSM2 this$0;

    public SatelliteMapsMediatorFSM2$TrafficmapActiveStateSATBlocked(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, String string) {
        this.this$0 = satelliteMapsMediatorFSM2;
        super(satelliteMapsMediatorFSM2, string);
    }

    @Override
    void activateSatellite() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "TrafficmapActiveStateSATBlocked#activateSatellite()");
        SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$1500(this.this$0));
    }

    @Override
    void activateStandard() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "TrafficmapActiveStateSATBlocked#activateStandard()");
        SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$800(this.this$0));
    }

    @Override
    public void setBlockingBit(boolean bl) {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "TrafficmapActiveStateSATBlocked#setBlockingBit()  blocked %1", bl);
        if (!bl) {
            SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$700(this.this$0));
        }
    }
}

