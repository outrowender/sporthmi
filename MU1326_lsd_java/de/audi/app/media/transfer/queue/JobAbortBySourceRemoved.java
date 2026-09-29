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
    private static final String LOGCLASS;

    public JobAbortBySourceRemoved(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, AbstractMediaBrowser abstractMediaBrowser, TransferLockHandler transferLockHandler) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, abstractMediaBrowser, transferLockHandler);
    }

    @Override
    public int getType() {
        return 7;
    }

    @Override
    public String getName() {
        return "AbortSourceRemoved";
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"JobAbortBySourceRemoved");
    }
}

