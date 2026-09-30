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
    private static final String LOGCLASS = "NullTransferListener";
    private final LogChannel logger;

    public NullTransferListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void blockImportFunctionality() {
        this.logger.log(1000000, "[%1.blockImportFunctionality]", (Object)LOGCLASS);
    }

    public void unblockImportFunctionality() {
        this.logger.log(1000000, "[%1.unblockImportFunctionality]", (Object)LOGCLASS);
    }

    public void readyForTransfer() {
        this.logger.log(1000000, "[%1.readyForTransfer]", (Object)LOGCLASS);
    }

    public void importStarted() {
        this.logger.log(1000000, "[%1.importStarted]", (Object)LOGCLASS);
    }

    public void importAborted(long l, long l2, long l3, boolean bl) {
        this.logger.log(1000000, "[%1.importAborted]", (Object)LOGCLASS);
    }

    public void importFinished(long l, long l2, long l3, boolean bl) {
        this.logger.log(1000000, "[%1.importFinished]", (Object)LOGCLASS);
    }

    public void importWillBeResumed() {
        this.logger.log(1000000, "[%1.importWillBeResumed]", (Object)LOGCLASS);
    }

    public void importIsSuspended() {
        this.logger.log(1000000, "[%1.importIsSuspended]", (Object)LOGCLASS);
    }

    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1000000, "[%1.activationSuccessful]", (Object)LOGCLASS);
    }

    public void jukeboxSpaceChanged(long l, long l2, long l3, long l4, long l5, long l6) {
        this.logger.log(1000000, "[%1.jukeboxSpaceChanged]", (Object)LOGCLASS);
    }

    public void deletionPostprocessing() {
        this.logger.log(1000000, "[%1.deletionPostprocessing]", (Object)LOGCLASS);
    }

    public void deletionStarted() {
        this.logger.log(1000000, "[%1.deletionStarted]", (Object)LOGCLASS);
    }

    public void deletionFinished() {
        this.logger.log(1000000, "[%1.deletionFinished]", (Object)LOGCLASS);
    }

    public void deletionAborted() {
        this.logger.log(1000000, "[%1.deletionAborted]", (Object)LOGCLASS);
    }

    public void deletionProgressChanged(long l) {
        this.logger.log(1000000, "[%1.deletionProgressChanged]", (Object)LOGCLASS);
    }

    public void importProgressChanged(long l, ListEntry listEntry) {
        this.logger.log(1000000, "[%1.importProgressChanged]", (Object)LOGCLASS);
    }

    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.encodingQualityChanged]", (Object)LOGCLASS);
    }

    public void activationFailed(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activationFailed]", (Object)LOGCLASS);
    }

    public void startFailed() {
        this.logger.log(1000000, "[%1.startFailed]", (Object)LOGCLASS);
    }

    public void sourceRemoved(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.sourceRemoved]", (Object)LOGCLASS);
    }

    public void unreadyToTransfer() {
        this.logger.log(1000000, "[%1.unreadyToTransfer]", (Object)LOGCLASS);
    }
}

