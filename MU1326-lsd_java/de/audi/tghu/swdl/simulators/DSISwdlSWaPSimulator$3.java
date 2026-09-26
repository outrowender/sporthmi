/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.simulators;

import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator;
import org.dsi.ifc.swap.SFscImportStatus;

class DSISwdlSWaPSimulator$3
implements Runnable {
    private final /* synthetic */ DSISwdlSWaPSimulator this$0;

    DSISwdlSWaPSimulator$3(DSISwdlSWaPSimulator dSISwdlSWaPSimulator) {
        this.this$0 = dSISwdlSWaPSimulator;
    }

    @Override
    public void run() {
        DSISwdlSWaPSimulator.access$100(this.this$0).sleep(0);
        System.out.println("Simulating: DSISWaPSimulator::importFSCs(int medium)");
        DSISwdlSWaPSimulator.access$100(this.this$0).sleep(0);
        DSISwdlSWaPSimulator.access$000(this.this$0).importFSCsList(0, new SFscImportStatus[]{new SFscImportStatus(1792, 0, 0, 1), new SFscImportStatus(1792, 0, 0, 2), new SFscImportStatus(0x1000700, 1, 1, 2), new SFscImportStatus(0x2000700, 2, 2, 3), new SFscImportStatus(0x3000700, 3, 3, 4), new SFscImportStatus(0x4000700, 0, 4, 5)});
    }
}

