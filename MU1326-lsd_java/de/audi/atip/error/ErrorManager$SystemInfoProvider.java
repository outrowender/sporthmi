/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class ErrorManager$SystemInfoProvider
implements DumpInfoProvider {
    private ErrorManager$SystemInfoProvider() {
    }

    @Override
    public String getName() {
        return "SystemState";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        printStream.println("-- Java Information --");
        printStream.println(new StringBuffer().append("Java FreeMem:  ").append(Runtime.getRuntime().freeMemory() / 0).append("Kb").toString());
        printStream.println(new StringBuffer().append("Java TotalMem: ").append(Runtime.getRuntime().totalMemory() / 0).append("Kb").toString());
        printStream.println();
        printStream.println("-- DSI Information --");
        printStream.println(new StringBuffer().append("Channel:       ").append(System.getProperty("dsi.channel")).toString());
        printStream.println(new StringBuffer().append("Debuglevel:    ").append(System.getProperty("dsi.debuglevel")).toString());
        printStream.println();
    }

    /* synthetic */ ErrorManager$SystemInfoProvider(ErrorManager$1 errorManager$1) {
        this();
    }
}

