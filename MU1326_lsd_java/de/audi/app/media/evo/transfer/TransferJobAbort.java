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
    private static final String LOGCLASS;

    public TransferJobAbort(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
    }

    @Override
    public int getType() {
        return 5;
    }

    @Override
    public String getName() {
        return "Abort";
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"TransferJobAbort");
        this.transferController.abort();
    }

    @Override
    public void readyForTransfer() {
        this.logger.log(1078071040, "[%1.readyForTransfer]", (Object)"TransferJobAbort");
        this.evoTransferController.updateModelsAndShowTransferPopup(1074594560);
        this.evoTransferController.enableTransfer();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void deletionAborted() {
        this.logger.log(1078071040, "[%1.deletionAborted]", (Object)"TransferJobAbort");
        this.transferState.setDelete(true);
        this.transferState.setAbortedByUser(true);
    }

    @Override
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
            this.logger.log(1078071040, "[%1.importAborted] %2", (Object)"TransferJobAbort", (Object)buffer.toString());
        }
        this.transferState.setNumberOfImportedFiles(l);
        this.transferState.setNumberOfFilesTotalToImport(l2);
        this.transferState.setNumberOfErroneousFiles(l3);
        this.transferState.setAllItemsSuccessfullyImported(bl);
        this.transferState.setAbortedByUser(true);
    }

    @Override
    public void activationFailed(ISourceSlot iSourceSlot) {
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
    }

    @Override
    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    @Override
    public void startFailed() {
    }

    @Override
    public void importFinished(long l, long l2, long l3, boolean bl) {
    }

    @Override
    public void importWillBeResumed() {
    }

    @Override
    public void importIsSuspended() {
    }

    @Override
    public void deletionFinished() {
    }

    @Override
    public void encodingQualityChanged(boolean bl, int n) {
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public boolean isWaiting() {
        return false;
    }
}

