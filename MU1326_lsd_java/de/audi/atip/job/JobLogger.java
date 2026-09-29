/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.job;

import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.esolutions.fw.util.commons.job.IJobLogger;

public class JobLogger
implements IJobLogger {
    private final LogChannel log;

    public JobLogger(LogChannel logChannel) {
        this.log = logChannel != null ? logChannel : NullLogChannel.getInstance();
    }

    @Override
    public final void log(int n, String string, Object object) {
        this.log.log(n, string, object);
    }

    @Override
    public final void log(int n, String string, Object object, int n2) {
        this.log.log(n, string, object, (long)n2);
    }

    @Override
    public final void log(int n, String string, Object object, int n2, int n3) {
        this.log.log(n, string, object, (long)n2, (long)n3);
    }

    @Override
    public final void log(int n, String string, Object object, Object object2) {
        this.log.log(n, string, object, object2);
    }

    @Override
    public final void log(int n, String string, Object object, Object object2, int n2) {
        this.log.log(n, string, object, object2, (long)n2);
    }

    @Override
    public void logException(Exception exception) {
        this.log.log(10000, "ERROR: ", (Throwable)exception);
    }
}

