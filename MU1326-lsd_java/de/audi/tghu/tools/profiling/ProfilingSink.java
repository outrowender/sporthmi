/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tools.profiling;

import de.audi.atip.log.AbstractLogSink;
import de.audi.atip.log.LogEntry;
import de.audi.tghu.tools.profiling.NativeProfAdapter;

public class ProfilingSink
extends AbstractLogSink {
    NativeProfAdapter adapter = NativeProfAdapter.getInstance();

    public ProfilingSink() {
        if (this.adapter == null) {
            return;
        }
    }

    @Override
    public void writeLog(LogEntry logEntry) {
        try {
            if ("Ext.Startup".equals(logEntry.getChannelName())) {
                this.adapter.createKernelUserEvent(907, logEntry.getLogMessage(null));
            } else {
                this.adapter.createKernelUserEvent(logEntry.getMsg());
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

