/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$SatelliteMapState;

class SatelliteMapsMediatorFSM2$SatellitemapActiveStateSATBlocked
extends SatelliteMapsMediatorFSM2$SatelliteMapState {
    private final /* synthetic */ SatelliteMapsMediatorFSM2 this$0;

    public SatelliteMapsMediatorFSM2$SatellitemapActiveStateSATBlocked(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, String string) {
        this.this$0 = satelliteMapsMediatorFSM2;
        super(satelliteMapsMediatorFSM2, string);
    }

    @Override
    void enter() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveStateSATBlocked#enter()");
        SatelliteMapsMediatorFSM2.access$100(this.this$0, 0);
        this.this$0.setLogosAccordingToSetup();
        SatelliteMapsMediatorFSM2.access$200(this.this$0).getChoiceModel(958137856).setValue(0);
        SatelliteMapsMediatorFSM2.access$400(this.this$0, SatelliteMapsMediatorFSM2.access$300(this.this$0));
    }

    @Override
    void activateStandard() {
        SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$800(this.this$0));
    }

    @Override
    void activateTraffic() {
        SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$1600(this.this$0));
    }

    @Override
    public void setBlockingBit(boolean bl) {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatellitemapActiveStateSATBlocked#setBlockingBit() blocked %1", bl);
        if (!bl) {
            SatelliteMapsMediatorFSM2.access$600(this.this$0, SatelliteMapsMediatorFSM2.access$500(this.this$0));
        }
    }
}

