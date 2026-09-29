/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.tghu.fwhmi.evo.RootWindowQNX;
import de.audi.tghu.fwhmi.evo.RootWindowQNX$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class RootWindowQNX$RepaintProvider
implements DumpInfoProvider {
    private final /* synthetic */ RootWindowQNX this$0;

    private RootWindowQNX$RepaintProvider(RootWindowQNX rootWindowQNX) {
        this.this$0 = rootWindowQNX;
    }

    @Override
    public String getName() {
        return new StringBuffer().append("RepaintInfo").append(this.this$0.getTerminalID()).toString();
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        printStream.println(RootWindowQNX.access$100(this.this$0) ? "In Repaint" : "Not in Repaint");
        if (RootWindowQNX.access$200(this.this$0) != null) {
            printStream.println(new StringBuffer().append("Current Screen: ").append(RootWindowQNX.access$300(this.this$0).getID()).toString());
        }
    }

    /* synthetic */ RootWindowQNX$RepaintProvider(RootWindowQNX rootWindowQNX, RootWindowQNX$1 rootWindowQNX$1) {
        this(rootWindowQNX);
    }
}

