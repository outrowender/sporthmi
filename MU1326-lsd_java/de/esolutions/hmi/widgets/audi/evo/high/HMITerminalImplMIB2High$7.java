/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;

class HMITerminalImplMIB2High$7
implements Runnable {
    private final /* synthetic */ HMITerminalImplMIB2High this$0;

    HMITerminalImplMIB2High$7(HMITerminalImplMIB2High hMITerminalImplMIB2High) {
        this.this$0 = hMITerminalImplMIB2High;
    }

    @Override
    public void run() {
        this.this$0.generateCarCodingHelper();
        this.this$0.generateKzbMappingHelper(HMITerminalImplMIB2High.access$100(this.this$0));
    }

    public String toString() {
        return "generateHelpers";
    }
}

