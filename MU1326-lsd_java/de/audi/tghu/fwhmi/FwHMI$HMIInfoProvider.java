/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.fwhmi.FwHMI$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class FwHMI$HMIInfoProvider
implements DumpInfoProvider {
    private final /* synthetic */ FwHMI this$0;

    private FwHMI$HMIInfoProvider(FwHMI fwHMI) {
        this.this$0 = fwHMI;
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        boolean bl = false;
        for (int i2 = 0; i2 < 8; ++i2) {
            if (this.this$0.getTerminalManager(i2) == null) continue;
            if (bl) {
                printStream.println();
            }
            this.this$0.getTerminalManager(i2).dump(printStream);
            bl = true;
        }
    }

    @Override
    public String getName() {
        return "HMIState";
    }

    /* synthetic */ FwHMI$HMIInfoProvider(FwHMI fwHMI, FwHMI$1 fwHMI$1) {
        this(fwHMI);
    }
}

