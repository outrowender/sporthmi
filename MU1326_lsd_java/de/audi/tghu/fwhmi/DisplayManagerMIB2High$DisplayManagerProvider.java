/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.DisplayManagerMIB2High;
import de.audi.tghu.fwhmi.DisplayManagerMIB2High$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class DisplayManagerMIB2High$DisplayManagerProvider
implements DumpInfoProvider {
    private final /* synthetic */ DisplayManagerMIB2High this$0;

    private DisplayManagerMIB2High$DisplayManagerProvider(DisplayManagerMIB2High displayManagerMIB2High) {
        this.this$0 = displayManagerMIB2High;
    }

    @Override
    public String getName() {
        return "DisplayManager-Info";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        this.dumpTerminalInfo(printStream, 0);
        this.dumpTerminalInfo(printStream, 1);
    }

    private void dumpTerminalInfo(PrintStream printStream, int n) {
        printStream.println(new StringBuffer().append("DM info for terminal: ").append(n).toString());
        if (this.this$0.getCurrentContextID(n) != -1) {
            int n2;
            String[] stringArray = DisplayManagerMIB2High.access$000(this.this$0, this.this$0.getCurrentContextID(n));
            String[] stringArray2 = DisplayManagerMIB2High.access$100(this.this$0, this.this$0.getCurrentContextID(n), n);
            for (n2 = 0; n2 < stringArray.length; ++n2) {
                printStream.println(stringArray[n2]);
            }
            for (n2 = 0; n2 < stringArray2.length; ++n2) {
                printStream.println(stringArray2[n2]);
            }
        } else {
            printStream.println("no context activated ");
        }
    }

    /* synthetic */ DisplayManagerMIB2High$DisplayManagerProvider(DisplayManagerMIB2High displayManagerMIB2High, DisplayManagerMIB2High$1 displayManagerMIB2High$1) {
        this(displayManagerMIB2High);
    }
}

