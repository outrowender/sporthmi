/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEClient;
import de.audi.tghu.swdl.ude.handler.AbstractDSIListener;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;

abstract class AbstractClient
extends AbstractDSIListener
implements IEClient {
    private AbstractIETask ieTask;
    protected final String file;

    AbstractClient(LogChannel logChannel, File file) {
        super(logChannel);
        this.file = file.getAbsolutePath();
    }

    final void setTask(AbstractIETask abstractIETask) {
        this.ieTask = abstractIETask;
    }

    final AbstractIETask getTask() {
        return this.ieTask;
    }

    @Override
    protected void longRunningTaskAborted() {
        if (this.ieTask != null) {
            this.lc.log(10000, "[%1.longRunningTaskAborted]", (Object)this);
            this.ieTask.updateClientResult(this, this.file, false, true);
        } else {
            this.lc.log(10000, "[%1.abortRunningTask] No task found!", (Object)this);
        }
    }

    @Override
    public File getFile() {
        return new File(this.file);
    }
}

