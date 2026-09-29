/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager;
import de.audi.tghu.log.BlackBox;
import de.audi.tghu.log.LogServImpl;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

final class ErrorManager$BlackBoxProvider
implements DumpInfoProvider {
    private final /* synthetic */ ErrorManager this$0;

    ErrorManager$BlackBoxProvider(ErrorManager errorManager) {
        this.this$0 = errorManager;
        int n = 100;
        try {
            n = Integer.parseInt(System.getProperty("BLACKBOX_SIZE", "100"));
        }
        catch (NumberFormatException numberFormatException) {
            n = 100;
        }
        ErrorManager.access$802(errorManager, new BlackBox(n));
        ErrorManager.access$600(errorManager).getLogChannelAdmin().addLogSink(ErrorManager.access$800(errorManager));
        ErrorManager.access$800(errorManager).setConfiguration(LogServImpl.decodeLogConfig(System.getProperty("BLACKBOX_LOG")));
    }

    @Override
    public String getName() {
        return "Logs";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        printStream.println("-- BlackBox --");
        printStream.println(new StringBuffer().append("Blackbox log : ").append(System.getProperty("BLACKBOX_LOG")).toString());
        printStream.println(new StringBuffer().append("Blackbox size: ").append(System.getProperty("BLACKBOX_SIZE")).toString());
        printStream.println();
        ErrorManager.access$800(this.this$0).dumpBuffer(printStream);
    }
}

