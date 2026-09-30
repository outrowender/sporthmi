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
    protected static final int JOB_NONE = 0;
    protected static final int JOB_CHANGE_ENCODING_QUALITY = 1;
    protected static final int JOB_SOURCE_ACTIVATION = 2;
    protected static final int JOB_TRANSFER_RUNNING = 3;
    protected static final int JOB_TRANSFER_RESUME = 4;
    protected static final int JOB_TRANSFER_ABORT = 5;
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

    public abstract void browseModeChanged(boolean var1, int var2);

    public abstract void addSelectionResult(boolean var1, int var2, int var3, boolean var4, long var5, long var7, long var9, long var11);

    public abstract void readyForTransfer();

    public abstract void activationFailed(ISourceSlot var1);

    public abstract void activationSuccessful(ISourceSlot var1, IBrowseListContext var2);

    public abstract void startFailed();

    public abstract void importAborted(long var1, long var3, long var5, boolean var7);

    public abstract void importFinished(long var1, long var3, long var5, boolean var7);

    public abstract void importWillBeResumed();

    public abstract void importIsSuspended();

    public abstract void deletionFinished();

    public abstract void deletionAborted();

    public abstract void encodingQualityChanged(boolean var1, int var2);

    public abstract void browseFolderChanged(boolean var1, MediaListEntry[] var2, int var3);

    public abstract void responseList(boolean var1, MediaListEntry[] var2, int var3);

    public abstract boolean isWaiting();
}

