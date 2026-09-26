/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;

class SatelliteMapsMediatorFSM2$2
implements Runnable {
    private final /* synthetic */ boolean val$blocked;
    private final /* synthetic */ SatelliteMapsMediatorFSM2 this$0;

    SatelliteMapsMediatorFSM2$2(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, boolean bl) {
        this.this$0 = satelliteMapsMediatorFSM2;
        this.val$blocked = bl;
    }

    @Override
    public void run() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "SatelliteMapsMediatorFSM2#setBlockingBit() dispacthed  %1 ", this.val$blocked);
        SatelliteMapsMediatorFSM2.access$1800(this.this$0).setBlockingBit(this.val$blocked);
    }
}

