/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;

class SatelliteMapsMediatorFSM2$3
implements Runnable {
    private final /* synthetic */ int val$mapStyle;
    private final /* synthetic */ boolean val$triggeredByGeBlockingBit;
    private final /* synthetic */ SatelliteMapsMediatorFSM2 this$0;

    SatelliteMapsMediatorFSM2$3(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, int n, boolean bl) {
        this.this$0 = satelliteMapsMediatorFSM2;
        this.val$mapStyle = n;
        this.val$triggeredByGeBlockingBit = bl;
    }

    @Override
    public void run() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatelliteMapsMediatorFSM2#togglemapStyle() dispacthed  %1 ", (long)this.val$mapStyle);
        this.this$0.setBlockingBit(this.val$triggeredByGeBlockingBit);
        SatelliteMapsMediatorFSM2.access$1900(this.this$0, this.val$mapStyle);
    }
}

