/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.timer.TimerDispatcher;
import de.audi.atip.timer.TimerDispatcher$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.Date;
import java.util.TimeZone;

class TimerDispatcher$TimerInfoProvider
implements DumpInfoProvider {
    private TimerDispatcher$TimerInfoProvider() {
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        long l = TimerDispatcher.access$100().getMonotonicTime();
        long l2 = TimerDispatcher.access$100().getKombiTime();
        printStream.println(new StringBuffer().append("user.timezone ").append(System.getProperty("user.timezone")).toString());
        printStream.println(new StringBuffer().append("TimeZone.getDefault() ").append(TimeZone.getDefault().getID()).toString());
        printStream.println(new StringBuffer().append("System.currentTimeMillis(): ").append(System.currentTimeMillis()).toString());
        printStream.println(new StringBuffer().append("Framework.getMonotonicTime(): ").append(l).toString());
        printStream.print(new StringBuffer().append("Framework.getKombiTime(): ").append(l2).append(" ").toString());
        printStream.println(new Date(l2));
        TimerDispatcher.dumpAll(printStream, l);
    }

    @Override
    public String getName() {
        return "Timer";
    }

    /* synthetic */ TimerDispatcher$TimerInfoProvider(TimerDispatcher$1 timerDispatcher$1) {
        this();
    }
}

