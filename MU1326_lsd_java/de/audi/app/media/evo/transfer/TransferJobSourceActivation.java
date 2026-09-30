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

public class TransferJobSourceActivation
extends AbstractTransferJobEvo {
    private static final String LOGCLASS = "TransferJobSourceActivation";
    private final ITransferItem transferItem;

    public TransferJobSourceActivation(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, ITransferItem iTransferItem, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
        this.transferItem = iTransferItem;
    }

    public int getType() {
        return 2;
    }

    public String getName() {
        return "SourceActivation";
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.evoTransferController.resetTransferProgressModels();
        this.transferState.reset();
        this.evoTransferController.disableTransfer();
        this.transferController.activate(this.transferItem.getTransferSourceSlot());
    }

    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1000000, "[%1.activationSuccessful]", (Object)LOGCLASS);
        iBrowseListContext.setBrowseMode(this.transferItem.isPhysicalFolder() ? 0 : 1);
    }

    public void activationFailed(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activationFailed]", (Object)LOGCLASS);
        this.evoTransferController.abortImport();
    }

    public boolean isWaiting() {
        return false;
    }

    public void readyForTransfer() {
    }

    public void importAborted(long l, long l2, long l3, boolean bl) {
    }

    public void importFinished(long l, long l2, long l3, boolean bl) {
    }

    public void importWillBeResumed() {
    }

    public void importIsSuspended() {
    }

    public void deletionFinished() {
    }

    public void deletionAborted() {
    }

    public void encodingQualityChanged(boolean bl, int n) {
    }

    public void startFailed() {
    }

    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.browseModeChanged]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", source=");
        buffer.append(null == this.transferItem || null == this.transferItem.getTransferSourceSlot() ? "null" : LogUtil.getSourceTypeStr(this.transferItem.getTransferSourceSlot().getSource().getType()));
        buffer.append(", hashcode=");
        buffer.append(Integer.toHexString(this.hashCode()));
        buffer.append("]");
        return buffer.toString();
    }
}

