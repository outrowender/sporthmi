/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class HMITerminalImplMIB2High$16
implements Runnable {
    private final /* synthetic */ HMITerminalImplMIB2High this$0;

    HMITerminalImplMIB2High$16(HMITerminalImplMIB2High hMITerminalImplMIB2High) {
        this.this$0 = hMITerminalImplMIB2High;
    }

    @Override
    public void run() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        AbstractWidget.hmiService.getEventDispatcherAdmin().dumpEventQueue(printStream);
        this.this$0.getFramework().getLogChannel("Fw.Startup").log(-2137614336, printStream.toString());
    }

    public String toString() {
        return "HMIEventQueue.dump";
    }
}

