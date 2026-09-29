/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.AbstractTransferJobEvo;
import de.audi.app.media.evo.transfer.EvoTransferController;
import de.audi.app.media.evo.transfer.EvoTransferState;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.ITransferController;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class TransferJobRunning
extends AbstractTransferJobEvo {
    private static final String LOGCLASS;
    private final ITransferItem transferItem;

    public TransferJobRunning(LogChannel logChannel, ITransferItem iTransferItem, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
        this.transferItem = iTransferItem;
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public String getName() {
        return "TransferJobRunning";
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"TransferJobRunning");
        this.evoTransferController.disableTransfer();
        if (this.transferItem.isContentTypeCDDA() || this.transferItem.isPhysicalFolder() && this.transferItem.isDynamicTransferFolder()) {
            this.evoTransferController.getBrowserListContext().addSelection(true, this.transferItem.isFolder() ? 1 : 0, this.transferItem.getEntryId(), this.transferItem.getContentType(), true);
        } else if (this.transferItem.isDynamicTransferFolder()) {
            this.evoTransferController.getBrowserListContext().changeFolder(this.evoTransferController.getFolderStack(this.transferItem.getContentType()));
        } else {
            this.evoTransferController.getBrowserListContext().changeFolder(this.transferItem.getTransferFolder());
        }
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
        if (bl || 3 == n) {
            this.handleTransferError();
            return;
        }
        this.transferState.setJukeboxFull(2 == n || 1 == n);
        if (0L == l4) {
            this.logger.log(1078071040, "[%1.addSelectionResult] No entry selected.", (Object)"TransferJobRunning");
            this.transferState.setAllItemsSuccessfullyImported(bl2);
            if (bl2) {
                this.evoTransferController.updateImportProgressModels(100);
                this.transferState.setRecopy(bl2);
                this.transferController.abort();
            }
            this.evoTransferController.updateModelsAndShowTransferPopup(1074594560);
            this.finishJob();
            return;
        }
        this.transferController.start();
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (bl) {
            this.logger.log(1078071040, "[%1.browseFolderChanged] ChangeFolder failed.", (Object)"TransferJobRunning");
            this.handleTransferError();
            return;
        }
        this.logger.log(1078071040, "[%1.browseFolderChanged] folder='%2' listSize='%3'", (Object)"TransferJobRunning", (Object)LogUtil.listEntryToStr(mediaListEntryArray), (long)n);
        this.evoTransferController.getBrowserListContext().addSelection(true, this.transferItem.isFolder() ? 1 : 0, this.transferItem.getEntryId(), this.transferItem.getContentType(), true);
    }

    @Override
    public void readyForTransfer() {
        this.logger.log(1078071040, "[%1.readyForTransfer]", (Object)"TransferJobRunning");
        this.evoTransferController.updateModelsAndShowTransferPopup(1074594560);
        this.finishJob();
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
            this.logger.log(1078071040, "[%1.importAborted] %2", (Object)"TransferJobRunning", (Object)buffer.toString());
        }
        this.transferState.setNumberOfImportedFiles(l);
        this.transferState.setNumberOfFilesTotalToImport(l2);
        this.transferState.setNumberOfErroneousFiles(l3);
        this.transferState.setAllItemsSuccessfullyImported(bl);
        this.transferState.setAbortedByUser(true);
    }

    @Override
    public void importFinished(long l, long l2, long l3, boolean bl) {
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
            this.logger.log(1078071040, "[%1.importFinished] %2", (Object)"TransferJobRunning", (Object)buffer.toString());
        }
        this.transferState.setNumberOfImportedFiles(l);
        this.transferState.setNumberOfFilesTotalToImport(l2);
        this.transferState.setNumberOfErroneousFiles(l3);
        this.transferState.setAllItemsSuccessfullyImported(bl);
        this.transferState.setAbortedByUser(false);
    }

    @Override
    public void deletionFinished() {
        this.logger.log(1078071040, "[%1.deletionFinished]", (Object)"TransferJobRunning");
        this.transferState.setDelete(true);
        this.transferState.setAbortedByUser(false);
    }

    @Override
    public void deletionAborted() {
        this.logger.log(1078071040, "[%1.deletionAborted]", (Object)"TransferJobRunning");
        this.transferState.setDelete(true);
        this.transferState.setAbortedByUser(true);
    }

    @Override
    public void startFailed() {
        this.logger.log(1078071040, "[%1.startFailed]", (Object)"TransferJobRunning");
        this.handleTransferError();
    }

    @Override
    public boolean isWaiting() {
        return false;
    }

    private void handleTransferError() {
        this.logger.log(1078071040, "[%1.handleTransferError]", (Object)"TransferJobRunning");
        this.evoTransferController.updateModelsAndShowTransferPopup(1074594560);
        this.finishJob();
    }

    private void finishJob() {
        this.logger.log(1078071040, "[%1.finishJob]", (Object)"TransferJobRunning");
        this.evoTransferController.enableTransfer();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", item=");
        buffer.append(this.transferItem);
        buffer.append(", hashcode=");
        buffer.append(Integer.toHexString(this.hashCode()));
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
    }

    @Override
    public void activationFailed(ISourceSlot iSourceSlot) {
    }

    @Override
    public void importWillBeResumed() {
    }

    @Override
    public void importIsSuspended() {
    }

    @Override
    public void encodingQualityChanged(boolean bl, int n) {
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }
}

