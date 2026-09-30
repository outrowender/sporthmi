/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.TransferLockHandler;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.queue.JobAbort;
import de.audi.atip.log.LogChannel;

public class JobAbortBySourceRemoved
extends JobAbort {
    private static final String LOGCLASS = "JobAbortBySourceRemoved";

    public JobAbortBySourceRemoved(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, AbstractMediaBrowser abstractMediaBrowser, TransferLockHandler transferLockHandler) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, abstractMediaBrowser, transferLockHandler);
    }

    public int getType() {
        return 7;
    }

    public String getName() {
        return "AbortSourceRemoved";
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
    }
}

