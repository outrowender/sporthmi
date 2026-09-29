/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.DomainHandler;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class DomainHandler$1
implements DumpInfoProvider {
    private final /* synthetic */ DomainHandler this$0;

    DomainHandler$1(DomainHandler domainHandler) {
        this.this$0 = domainHandler;
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        this.this$0.dumpDomainStartupTimes(printStream, "\n");
    }

    @Override
    public String getName() {
        return "DomainStates";
    }
}

