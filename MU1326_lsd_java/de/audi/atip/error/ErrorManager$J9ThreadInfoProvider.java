/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager;
import de.audi.atip.error.ErrorManager$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class ErrorManager$J9ThreadInfoProvider
implements DumpInfoProvider {
    private final /* synthetic */ ErrorManager this$0;

    private ErrorManager$J9ThreadInfoProvider(ErrorManager errorManager) {
        this.this$0 = errorManager;
    }

    @Override
    public String getName() {
        return "ThreadState";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void dump(PrintStream printStream, String string) {
        PrintStream printStream2 = System.out;
        try {
            System.setOut(printStream);
            if (ErrorManager.access$600(this.this$0).isEvoStd()) {
                try {
                    (ErrorManager.class$com$microdoc$j9$Tools == null ? (ErrorManager.class$com$microdoc$j9$Tools = ErrorManager.class$("com.microdoc.j9.Tools")) : ErrorManager.class$com$microdoc$j9$Tools).getMethod("dumpThreadsInfo", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.TRUE});
                }
                catch (Exception exception) {
                    ErrorManager.access$700(this.this$0).log(10000, "Calling dumpThreadsInfo failed!", (Throwable)exception);
                }
            } else {
                try {
                    (ErrorManager.class$com$microdoc$j9$Tools == null ? (ErrorManager.class$com$microdoc$j9$Tools = ErrorManager.class$("com.microdoc.j9.Tools")) : ErrorManager.class$com$microdoc$j9$Tools).getMethod("dumpThreadsInfo", new Class[0]).invoke(null, new Object[0]);
                }
                catch (Exception exception) {
                    ErrorManager.access$700(this.this$0).log(10000, "Calling dumpThreadsInfo failed!", (Throwable)exception);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace(printStream);
        }
        finally {
            System.setOut(printStream2);
        }
    }

    /* synthetic */ ErrorManager$J9ThreadInfoProvider(ErrorManager errorManager, ErrorManager$1 errorManager$1) {
        this(errorManager);
    }
}

