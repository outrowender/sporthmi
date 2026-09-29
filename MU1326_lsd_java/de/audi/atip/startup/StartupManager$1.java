/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupManager;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class StartupManager$1
implements DumpInfoProvider {
    private final /* synthetic */ StartupManager this$0;

    StartupManager$1(StartupManager startupManager) {
        this.this$0 = startupManager;
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        StartupManager.access$2400(this.this$0, printStream);
        printStream.println();
        StartupManager.access$2500(this.this$0).dump(printStream, string);
        printStream.println();
        StartupManager.access$2600(this.this$0, printStream);
    }

    @Override
    public String getName() {
        return "StartupManager";
    }
}

