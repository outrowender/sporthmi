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

public class NullTransferJob
extends AbstractTransferJobEvo {
    private static final String LOGCLASS = "NullTransferJob";

    public NullTransferJob(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
    }

    public int getType() {
        return 0;
    }

    public String getName() {
        return "JobNone";
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
    }

    public void readyForTransfer() {
        this.logger.log(1000000, "[%1.readyForTransfer]", (Object)LOGCLASS);
    }

    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1000000, "[%1.activationSuccessful]", (Object)LOGCLASS);
    }

    public void activationFailed(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activationFailed]", (Object)LOGCLASS);
    }

    public void abortImport() {
        this.logger.log(1000000, "[%1.abortImport]", (Object)LOGCLASS);
    }

    public void importWillBeResumed() {
        this.logger.log(1000000, "[%1.importWillBeResumed]", (Object)LOGCLASS);
    }

    public void importIsSuspended() {
    }

    public void startFailed() {
        this.logger.log(1000000, "[%1.startFailed]", (Object)LOGCLASS);
    }

    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.browseModeChanged]", (Object)LOGCLASS);
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
        this.logger.log(1000000, "[%1.addSelectionResult]", (Object)LOGCLASS);
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.browseFolderChanged]", (Object)LOGCLASS);
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void importAborted(long l, long l2, long l3, boolean bl) {
        this.logger.log(1000000, "[%1.importAborted]", (Object)LOGCLASS);
    }

    public void importFinished(long l, long l2, long l3, boolean bl) {
        this.logger.log(1000000, "[%1.importFinished]", (Object)LOGCLASS);
    }

    public void deletionFinished() {
        this.logger.log(1000000, "[%1.deletionFinished]", (Object)LOGCLASS);
    }

    public void deletionAborted() {
        this.logger.log(1000000, "[%1.deletionAborted]", (Object)LOGCLASS);
    }

    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.encodingQualityChanged]", (Object)LOGCLASS);
    }

    public boolean isWaiting() {
        return false;
    }
}

