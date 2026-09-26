/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class JobActivateSource
extends AbstractJobTransfer {
    private static final String LOGCLASS;
    private final ISourceSlot slot;
    private final ISourceSlot activeSlot;
    private volatile boolean isAborted = false;

    public JobActivateSource(LogChannel logChannel, TransferController transferController, AbstractMediaBrowser abstractMediaBrowser, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, ISourceSlot iSourceSlot, ISourceSlot iSourceSlot2) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, abstractMediaBrowser);
        this.slot = iSourceSlot;
        this.activeSlot = iSourceSlot2;
    }

    @Override
    public int getType() {
        return 2;
    }

    @Override
    public String getName() {
        return "ActivateSource";
    }

    @Override
    public void browserActivated(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1078071040, "[%1.browserActivated]", (Object)"TransferJobActivateSource");
        this.getTransferController().setTransferState(2);
        this.getTransferListener().activationSuccessful(iSourceSlot, iBrowseListContext);
        this.jobFinished();
    }

    @Override
    public void browserDeactivated(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.browserDeactivated]", (Object)"TransferJobActivateSource");
        this.getTransferListener().activationFailed(iSourceSlot);
        this.getTransferBrowser().deactivate();
        this.jobFinished();
    }

    @Override
    public void sourceSlotActivated(MediaSourceSlot mediaSourceSlot) {
        this.logger.log(1078071040, "[%1.sourceSlotActivated]", (Object)"TransferJobActivateSource");
        if (!((Object)this.slot).equals(mediaSourceSlot)) {
            this.getTransferListener().activationFailed(this.slot);
        }
    }

    @Override
    public void asyncException(int n, int n2) {
        switch (n) {
            case 1000: {
                this.logger.log(-1601830656, "[%1.asyncException] setActiveMedia: function not supported. Activation failed.", (Object)"TransferJobActivateSource");
                this.getTransferListener().activationFailed(this.slot);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.asyncException] No handling of exception supported at this point.", (Object)"TransferJobActivateSource");
            }
        }
    }

    @Override
    public void importStatusChanged(int n) {
        switch (n) {
            case 7: {
                this.getTransferBrowser().activate(this.slot);
                break;
            }
            case 0: {
                if (!this.isAborted) break;
                this.getTransferListener().readyForTransfer();
                this.jobFinished();
                break;
            }
        }
    }

    @Override
    public void deletionStatusChanged(int n) {
        switch (n) {
            case 7: {
                this.getTransferBrowser().activate(this.slot);
                break;
            }
            case 0: {
                if (!this.isAborted) break;
                this.getTransferListener().readyForTransfer();
                this.jobFinished();
                break;
            }
        }
    }

    @Override
    public void start() {
        if (!this.slot.isLoaded()) {
            this.logger.log(1078071040, "[%1.start] Slot is %2, activation failed.", (Object)"TransferJobActivateSource", (Object)(this.slot.isLoading() || this.slot.isReloading() ? "on loading" : "empty"));
            this.getTransferListener().activationFailed(this.slot);
            this.jobFinished();
            return;
        }
        if (((Object)this.slot).equals(this.activeSlot)) {
            this.logger.log(1078071040, "[%1.start] Activate the browser.", (Object)"TransferJobActivateSource");
            this.getTransferBrowser().activate(this.slot);
        } else {
            this.logger.log(1078071040, "[%1.start] Activate slot on recorder.", (Object)"TransferJobActivateSource");
            this.getMediaDSIRecorder().setActiveMedia((MediaSourceSlot)this.slot);
        }
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"TransferJobActivateSource");
        if (bl) {
            this.isAborted = true;
            this.getMediaDSIRecorder().abortDelete();
            this.getMediaDSIRecorder().abortImport();
            this.getTransferController().removeTransferState(2);
        }
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", source=");
        buffer.append(this.slot.getSource().getType());
        buffer.append("]");
        return buffer.toString();
    }
}

