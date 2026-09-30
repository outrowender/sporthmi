/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.AbstractTransferJobEvo;
import de.audi.app.media.evo.transfer.EvoTransferController;
import de.audi.app.media.evo.transfer.EvoTransferState;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferController;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class TransferJobAbort
extends AbstractTransferJobEvo {
    private static final String LOGCLASS = "TransferJobAbort";

    public TransferJobAbort(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
    }

    public int getType() {
        return 5;
    }

    public String getName() {
        return "Abort";
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.transferController.abort();
    }

    public void readyForTransfer() {
        this.logger.log(1000000, "[%1.readyForTransfer]", (Object)LOGCLASS);
        this.evoTransferController.updateModelsAndShowTransferPopup(200000);
        this.evoTransferController.enableTransfer();
        this.getExecutionContext().jobFinished();
    }

    public void deletionAborted() {
        this.logger.log(1000000, "[%1.deletionAborted]", (Object)LOGCLASS);
        this.transferState.setDelete(true);
        this.transferState.setAbortedByUser(true);
    }

    public void importAborted(long l, long l2, long l3, boolean bl) {
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("noImported='");
            buffer.append(l);
            buffer.append("' noError='");
            buffer.append(l3);
            buffer.append("' noTotal='");
            buffer.append(l2);
            buffer.append("' successful='");
            buffer.append(bl);
            buffer.append("'");
            this.logger.log(1000000, "[%1.importAborted] %2", (Object)LOGCLASS, (Object)buffer.toString());
        }
        this.transferState.setNumberOfImportedFiles(l);
        this.transferState.setNumberOfFilesTotalToImport(l2);
        this.transferState.setNumberOfErroneousFiles(l3);
        this.transferState.setAllItemsSuccessfullyImported(bl);
        this.transferState.setAbortedByUser(true);
    }

    public void activationFailed(ISourceSlot iSourceSlot) {
    }

    public void browseModeChanged(boolean bl, int n) {
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
    }

    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    public void startFailed() {
    }

    public void importFinished(long l, long l2, long l3, boolean bl) {
    }

    public void importWillBeResumed() {
    }

    public void importIsSuspended() {
    }

    public void deletionFinished() {
    }

    public void encodingQualityChanged(boolean bl, int n) {
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public boolean isWaiting() {
        return false;
    }
}

