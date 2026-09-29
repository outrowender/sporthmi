/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.ITransferListener;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.media.ListEntry;

public abstract class AbstractJobTransfer
extends AbstractQueueJob {
    protected final LogChannel logger;
    private final TransferController controller;
    private final MediaDSIRecorderControllerImpl mediaDSIRecorderController;
    private final AbstractMediaBrowser transferBrowser;
    public static final int TRANSFERJOB_NULL;
    public static final int TRANSFERJOB_SET_ENCODING_QUALITY;
    public static final int TRANSFERJOB_ACTIVATE_SOURCE;
    public static final int TRANSFERJOB_TRANSFERRING;
    public static final int TRANSFERJOB_RESUME_TRANSFER;
    public static final int TRANSFERJOB_ACTIVATION;
    public static final int TRANSFERJOB_ABORT;
    public static final int TRANSFERJOB_ABORT_BYSOURCE_REMOVED;

    public AbstractJobTransfer(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, AbstractMediaBrowser abstractMediaBrowser) {
        this.controller = transferController;
        this.mediaDSIRecorderController = mediaDSIRecorderControllerImpl;
        this.logger = logChannel;
        this.transferBrowser = abstractMediaBrowser;
    }

    protected void jobFinished() {
        this.getExecutionContext().jobFinished();
    }

    protected TransferController getTransferController() {
        return this.controller;
    }

    protected MediaDSIRecorderControllerImpl getMediaDSIRecorder() {
        return this.mediaDSIRecorderController;
    }

    protected ITransferListener getTransferListener() {
        return this.controller.getTransferListener();
    }

    protected AbstractMediaBrowser getTransferBrowser() {
        return this.transferBrowser;
    }

    public void asyncException(int n, int n2) {
    }

    public void encodingQualityChanged(int n) {
    }

    public void responseSetSelection(int n, boolean bl) {
    }

    public void importStatusChanged(int n) {
    }

    public void deletionStatusChanged(int n) {
    }

    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6) {
    }

    public void browserActivated(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    public void browserDeactivated(ISourceSlot iSourceSlot) {
    }

    public void sourceSlotActivated(MediaSourceSlot mediaSourceSlot) {
    }

    public void importProgressChanged(long l, ListEntry listEntry) {
    }

    public void deletionProgressChanged(long l) {
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append("]");
        return buffer.toString();
    }
}

