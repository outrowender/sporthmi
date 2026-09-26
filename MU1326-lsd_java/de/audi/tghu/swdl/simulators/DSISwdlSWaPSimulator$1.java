/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.simulators;

import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator;
import org.dsi.ifc.swap.SFscStatus;

class DSISwdlSWaPSimulator$1
implements Runnable {
    private final /* synthetic */ DSISwdlSWaPSimulator this$0;

    DSISwdlSWaPSimulator$1(DSISwdlSWaPSimulator dSISwdlSWaPSimulator) {
        this.this$0 = dSISwdlSWaPSimulator;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
        }
        DSISwdlSWaPSimulator.access$000(this.this$0).updateFscList(new SFscStatus[]{new SFscStatus(1024, 0, 0), new SFscStatus(1024, 0, 1), new SFscStatus(0x1000400, 1, 0), new SFscStatus(0x2000400, 2, 0), new SFscStatus(0x3000400, 4, 0), new SFscStatus(1280, 0, 0), new SFscStatus(1536, 3, 0)}, 1);
    }
}

