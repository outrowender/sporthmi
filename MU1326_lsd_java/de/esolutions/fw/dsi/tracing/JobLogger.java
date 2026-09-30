/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tracing;

import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.tracing.TraceChannel;

public class JobLogger
implements IJobLogger {
    private static final TraceChannel tracer = Channels.SERVICEWORKER;

    public void log(int n, String string, Object object) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object);
    }

    public void log(int n, String string, Object object, int n2) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, (Object)String.valueOf(n2));
    }

    public void log(int n, String string, Object object, int n2, int n3) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, (Object)String.valueOf(n2), (Object)String.valueOf(n3));
    }

    public void log(int n, String string, Object object, Object object2) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, object2);
    }

    public void log(int n, String string, Object object, Object object2, int n2) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, object2, (Object)String.valueOf(n2));
    }

    public void logException(Exception exception) {
        tracer.log((short)4, "Caught exception: " + exception.toString());
    }

    private final short jobLogerLevel2TraceLevel(int n) {
        if (n == 1000) {
            return 5;
        }
        if (n == 10000) {
            return 4;
        }
        if (n == 100000) {
            return 3;
        }
        if (n == 1000000) {
            return 2;
        }
        if (n == 10000000) {
            return 1;
        }
        if (n == 100000000) {
            return 0;
        }
        return 2;
    }
}

