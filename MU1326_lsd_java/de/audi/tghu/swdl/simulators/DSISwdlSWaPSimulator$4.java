/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.simulators;

import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator;

class DSISwdlSWaPSimulator$4
implements Runnable {
    private final /* synthetic */ DSISwdlSWaPSimulator this$0;

    DSISwdlSWaPSimulator$4(DSISwdlSWaPSimulator dSISwdlSWaPSimulator) {
        this.this$0 = dSISwdlSWaPSimulator;
    }

    @Override
    public void run() {
        DSISwdlSWaPSimulator.access$100(this.this$0).sleep(0);
        System.out.println("Simulating: DSISWaPSimulator::exportCCD(int medium)");
        DSISwdlSWaPSimulator.access$100(this.this$0).sleep(0);
        DSISwdlSWaPSimulator.access$000(this.this$0).exportCCD(0);
    }
}

