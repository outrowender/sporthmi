/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractRemoteHMITask
implements RemoteHMITask {
    private final String name;
    private final LogAppender logAppender;

    public AbstractRemoteHMITask(String string) {
        this(string, null);
    }

    public AbstractRemoteHMITask(String string, LogAppender logAppender) {
        this.name = string;
        this.logAppender = logAppender;
    }

    protected LogAppender getParamsForDebugging() {
        return this.logAppender;
    }

    public Long getDelayMillis() {
        return null;
    }

    public boolean isCoalescable() {
        return false;
    }

    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        return false;
    }

    public final String toString() {
        LogAppender logAppender = this.getParamsForDebugging();
        if (logAppender == null) {
            return this.name;
        }
        Buffer buffer = new Buffer(this.name.length() + ": ".length() + logAppender.getEstimatedLength());
        buffer.append(this.name);
        buffer.append(": ");
        logAppender.appendTo(buffer);
        return buffer.toString();
    }
}

