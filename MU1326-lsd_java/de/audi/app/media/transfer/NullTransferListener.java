/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.ListEntry;

public class NullTransferListener
implements ITransferListener {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullTransferListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void blockImportFunctionality() {
        this.logger.log(1078071040, "[%1.blockImportFunctionality]", (Object)"NullTransferListener");
    }

    @Override
    public void unblockImportFunctionality() {
        this.logger.log(1078071040, "[%1.unblockImportFunctionality]", (Object)"NullTransferListener");
    }

    @Override
    public void readyForTransfer() {
        this.logger.log(1078071040, "[%1.readyForTransfer]", (Object)"NullTransferListener");
    }

    @Override
    public void importStarted() {
        this.logger.log(1078071040, "[%1.importStarted]", (Object)"NullTransferListener");
    }

    @Override
    public void importAborted(long l, long l2, long l3, boolean bl) {
        this.logger.log(1078071040, "[%1.importAborted]", (Object)"NullTransferListener");
    }

    @Override
    public void importFinished(long l, long l2, long l3, boolean bl) {
        this.logger.log(1078071040, "[%1.importFinished]", (Object)"NullTransferListener");
    }

    @Override
    public void importWillBeResumed() {
        this.logger.log(1078071040, "[%1.importWillBeResumed]", (Object)"NullTransferListener");
    }

    @Override
    public void importIsSuspended() {
        this.logger.log(1078071040, "[%1.importIsSuspended]", (Object)"NullTransferListener");
    }

    @Override
    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1078071040, "[%1.activationSuccessful]", (Object)"NullTransferListener");
    }

    @Override
    public void jukeboxSpaceChanged(long l, long l2, long l3, long l4, long l5, long l6) {
        this.logger.log(1078071040, "[%1.jukeboxSpaceChanged]", (Object)"NullTransferListener");
    }

    @Override
    public void deletionPostprocessing() {
        this.logger.log(1078071040, "[%1.deletionPostprocessing]", (Object)"NullTransferListener");
    }

    @Override
    public void deletionStarted() {
        this.logger.log(1078071040, "[%1.deletionStarted]", (Object)"NullTransferListener");
    }

    @Override
    public void deletionFinished() {
        this.logger.log(1078071040, "[%1.deletionFinished]", (Object)"NullTransferListener");
    }

    @Override
    public void deletionAborted() {
        this.logger.log(1078071040, "[%1.deletionAborted]", (Object)"NullTransferListener");
    }

    @Override
    public void deletionProgressChanged(long l) {
        this.logger.log(1078071040, "[%1.deletionProgressChanged]", (Object)"NullTransferListener");
    }

    @Override
    public void importProgressChanged(long l, ListEntry listEntry) {
        this.logger.log(1078071040, "[%1.importProgressChanged]", (Object)"NullTransferListener");
    }

    @Override
    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.encodingQualityChanged]", (Object)"NullTransferListener");
    }

    @Override
    public void activationFailed(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.activationFailed]", (Object)"NullTransferListener");
    }

    @Override
    public void startFailed() {
        this.logger.log(1078071040, "[%1.startFailed]", (Object)"NullTransferListener");
    }

    @Override
    public void sourceRemoved(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.sourceRemoved]", (Object)"NullTransferListener");
    }

    @Override
    public void unreadyToTransfer() {
        this.logger.log(1078071040, "[%1.unreadyToTransfer]", (Object)"NullTransferListener");
    }
}

