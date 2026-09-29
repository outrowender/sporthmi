/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.dumper;

import de.esolutions.graphics.eal.api.IManager;
import java.io.PrintStream;

public class DumpInfoProvider
implements de.esolutions.fw.util.commons.error.DumpInfoProvider {
    @Override
    public void dump(PrintStream printStream, String string) {
        System.loadLibrary("ealswig");
        String string2 = IManager.triggerDump();
        printStream.println(string2);
    }

    @Override
    public String getName() {
        return "EAL";
    }
}

