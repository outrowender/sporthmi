/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.IEClient;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ListIterator;

public abstract class AbstractIETask {
    private final ListIterator ieClients;
    protected final IEApp ieApp;
    private final LogChannel lc;
    private final String label;
    private boolean success;

    protected AbstractIETask(IEApp iEApp, ListIterator listIterator, String string) {
        this.ieApp = iEApp;
        this.ieClients = listIterator;
        this.lc = iEApp.getLogChannel();
        this.label = string;
    }

    public void start() {
        this.lc.log(-2137614336, "[%1.start]", (Object)this.label);
        this.success = false;
        this.startNexTask();
    }

    abstract void startNexTask() {
    }

    abstract void finished(boolean bl) {
    }

    protected IEClient getNextIEClient() {
        return (IEClient)this.ieClients.next();
    }

    public void updateClientResult(IEClient iEClient, String string, boolean bl, boolean bl2) {
        if (this.lc.getCurrentLogThreshold() >= -2137614336) {
            Buffer buffer = new Buffer(100);
            buffer.append("client:").append(iEClient);
            buffer.append(" file:").append(string);
            buffer.append(" result:").append(bl);
            this.lc.log(-2137614336, "[%1.updateClientResult] %2", (Object)this.label, (Object)buffer);
        }
        if (bl) {
            this.success = true;
        }
        if (bl2) {
            this.ieApp.getCleanupTask().add(string);
        }
        if (this.ieClients.hasNext()) {
            this.startNexTask();
        } else {
            this.finished(this.success);
        }
    }
}

