/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.EvoTransferController;
import de.audi.app.media.evo.transfer.EvoTransferState;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferController;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractTransferJobEvo
extends AbstractQueueJob {
    protected static final int JOB_NONE;
    protected static final int JOB_CHANGE_ENCODING_QUALITY;
    protected static final int JOB_SOURCE_ACTIVATION;
    protected static final int JOB_TRANSFER_RUNNING;
    protected static final int JOB_TRANSFER_RESUME;
    protected static final int JOB_TRANSFER_ABORT;
    protected final LogChannel logger;
    protected final ITransferController transferController;
    protected final EvoTransferController evoTransferController;
    protected final EvoTransferState transferState;

    public AbstractTransferJobEvo(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        this.logger = logChannel;
        this.transferController = iTransferController;
        this.evoTransferController = evoTransferController;
        this.transferState = evoTransferState;
    }

    @Override
    public void abort(boolean bl) {
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", hashcode=");
        buffer.append(Integer.toHexString(this.hashCode()));
        buffer.append("]");
        return buffer.toString();
    }

    public abstract void browseModeChanged(boolean bl, int n) {
    }

    public abstract void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
    }

    public abstract void readyForTransfer() {
    }

    public abstract void activationFailed(ISourceSlot iSourceSlot) {
    }

    public abstract void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    public abstract void startFailed() {
    }

    public abstract void importAborted(long l, long l2, long l3, boolean bl) {
    }

    public abstract void importFinished(long l, long l2, long l3, boolean bl) {
    }

    public abstract void importWillBeResumed() {
    }

    public abstract void importIsSuspended() {
    }

    public abstract void deletionFinished() {
    }

    public abstract void deletionAborted() {
    }

    public abstract void encodingQualityChanged(boolean bl, int n) {
    }

    public abstract void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public abstract void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public abstract boolean isWaiting() {
    }
}

