/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.Properties;

class ErrorManager$EnvInfoProvider
implements DumpInfoProvider {
    private ErrorManager$EnvInfoProvider() {
    }

    @Override
    public String getName() {
        return "Env";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        Properties properties = System.getProperties();
        properties.list(printStream);
        printStream.println();
    }

    /* synthetic */ ErrorManager$EnvInfoProvider(ErrorManager$1 errorManager$1) {
        this();
    }
}

