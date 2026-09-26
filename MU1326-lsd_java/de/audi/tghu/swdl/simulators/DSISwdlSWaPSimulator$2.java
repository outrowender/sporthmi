/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.simulators;

import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator;
import org.dsi.ifc.swap.SFscDetails;

class DSISwdlSWaPSimulator$2
implements Runnable {
    private final /* synthetic */ int val$fsc;
    private final /* synthetic */ int val$fscState;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ DSISwdlSWaPSimulator this$0;

    DSISwdlSWaPSimulator$2(DSISwdlSWaPSimulator dSISwdlSWaPSimulator, int n, int n2, int n3) {
        this.this$0 = dSISwdlSWaPSimulator;
        this.val$fsc = n;
        this.val$fscState = n2;
        this.val$index = n3;
    }

    @Override
    public void run() {
        DSISwdlSWaPSimulator.access$100(this.this$0).sleep(0);
        SFscDetails sFscDetails = new SFscDetails(this.val$fsc, this.val$fscState, this.val$index, (short)(DSISwdlSWaPSimulator.access$000(this.this$0).isInstalled(this.val$fsc) ? 128 : 0), DSISwdlSWaPSimulator.access$000(this.this$0).isInstalled(this.val$fsc) ? "WAUZZZ8K99A123456" : "---", DSISwdlSWaPSimulator.access$000(this.this$0).isInstalled(this.val$fsc) ? "200806231015+0100" : "---", "VCRN ???");
        DSISwdlSWaPSimulator.access$000(this.this$0).getFscDetail(sFscDetails);
    }
}

