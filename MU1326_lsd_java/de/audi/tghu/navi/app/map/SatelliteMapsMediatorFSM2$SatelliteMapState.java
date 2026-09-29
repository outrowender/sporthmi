/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2;
import de.audi.tghu.navi.app.util.Util;

public class SatelliteMapsMediatorFSM2$SatelliteMapState {
    private final String statename;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final /* synthetic */ SatelliteMapsMediatorFSM2 this$0;

    public SatelliteMapsMediatorFSM2$SatelliteMapState(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, String string) {
        this.this$0 = satelliteMapsMediatorFSM2;
        this.statename = string;
    }

    void enter() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#enter()", (Object)this.CLASS_NAME);
    }

    void activateSatellite() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#activateSatellite()", (Object)this.CLASS_NAME);
    }

    void activateStandard() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#activateStandard()", (Object)this.CLASS_NAME);
    }

    void activateTraffic() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#activateTraffic()", (Object)this.CLASS_NAME);
    }

    void updateSatellite() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#updateSatellite()", (Object)this.CLASS_NAME);
    }

    void updateStandard() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#updateStandard()", (Object)this.CLASS_NAME);
    }

    boolean isConfirmed() {
        return false;
    }

    void exit() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#exit()", (Object)this.CLASS_NAME);
    }

    String getName() {
        return this.statename;
    }

    public void setBlockingBit(boolean bl) {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#setBlockingBit()", (Object)this.CLASS_NAME);
    }

    public void updateTraffic() {
        SatelliteMapsMediatorFSM2.access$000(this.this$0).log(-2137614336, "%1#updateTraffic()", (Object)this.CLASS_NAME);
    }
}

