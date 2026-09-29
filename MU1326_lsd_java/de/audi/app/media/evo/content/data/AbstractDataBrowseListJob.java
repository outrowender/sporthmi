/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.evo.content.data.DataBrowserList;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractDataBrowseListJob
extends AbstractQueueJob {
    protected final LogChannel logChannel;
    private final DataBrowserList dataBrowserList;

    public AbstractDataBrowseListJob(LogChannel logChannel, DataBrowserList dataBrowserList) {
        this.logChannel = logChannel;
        this.dataBrowserList = dataBrowserList;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void abort(boolean bl) {
    }

    public DataBrowserList getDataBrowserList() {
        return this.dataBrowserList;
    }

    public void addSelectionFinished(boolean bl, long l) {
    }

    public void browsePathSelectionFinished() {
    }

    public String toString() {
        return "";
    }
}

