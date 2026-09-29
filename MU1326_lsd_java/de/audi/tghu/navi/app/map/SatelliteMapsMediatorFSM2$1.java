/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;

class SatelliteMapsMediatorFSM2$1
implements Runnable {
    private final /* synthetic */ int val$mapStyle;
    private final /* synthetic */ SatelliteMapsMediatorFSM2 this$0;

    SatelliteMapsMediatorFSM2$1(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, int n) {
        this.this$0 = satelliteMapsMediatorFSM2;
        this.val$mapStyle = n;
    }

    @Override
    public void run() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatelliteMapsMediatorFSM2#updatemapStyle() dispatched %1 ", (long)this.val$mapStyle);
        SatelliteMapsMediatorFSM2.access$1700(this.this$0, this.val$mapStyle);
    }
}

