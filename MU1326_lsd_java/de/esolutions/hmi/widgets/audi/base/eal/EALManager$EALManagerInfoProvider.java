/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager$1;
import java.io.PrintStream;

class EALManager$EALManagerInfoProvider
implements DumpInfoProvider {
    private EALManager$EALManagerInfoProvider() {
    }

    @Override
    public String getName() {
        return "EALManager";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        printStream.println(new StringBuffer().append("PartianRendering enabled: ").append(EALManager.access$1100()).toString());
        printStream.println(new StringBuffer().append("Annotatione enabled: ").append(EALManager.access$1200()).toString());
    }

    /* synthetic */ EALManager$EALManagerInfoProvider(EALManager$1 eALManager$1) {
        this();
    }
}

