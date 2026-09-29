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
    private static final String LOGCLASS;

    public NullTransferJob(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, evoTransferState);
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "JobNone";
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"NullTransferJob");
    }

    @Override
    public void readyForTransfer() {
        this.logger.log(1078071040, "[%1.readyForTransfer]", (Object)"NullTransferJob");
    }

    @Override
    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1078071040, "[%1.activationSuccessful]", (Object)"NullTransferJob");
    }

    @Override
    public void activationFailed(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.activationFailed]", (Object)"NullTransferJob");
    }

    public void abortImport() {
        this.logger.log(1078071040, "[%1.abortImport]", (Object)"NullTransferJob");
    }

    @Override
    public void importWillBeResumed() {
        this.logger.log(1078071040, "[%1.importWillBeResumed]", (Object)"NullTransferJob");
    }

    @Override
    public void importIsSuspended() {
    }

    @Override
    public void startFailed() {
        this.logger.log(1078071040, "[%1.startFailed]", (Object)"NullTransferJob");
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.browseModeChanged]", (Object)"NullTransferJob");
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4) {
        this.logger.log(1078071040, "[%1.addSelectionResult]", (Object)"NullTransferJob");
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.browseFolderChanged]", (Object)"NullTransferJob");
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public void importAborted(long l, long l2, long l3, boolean bl) {
        this.logger.log(1078071040, "[%1.importAborted]", (Object)"NullTransferJob");
    }

    @Override
    public void importFinished(long l, long l2, long l3, boolean bl) {
        this.logger.log(1078071040, "[%1.importFinished]", (Object)"NullTransferJob");
    }

    @Override
    public void deletionFinished() {
        this.logger.log(1078071040, "[%1.deletionFinished]", (Object)"NullTransferJob");
    }

    @Override
    public void deletionAborted() {
        this.logger.log(1078071040, "[%1.deletionAborted]", (Object)"NullTransferJob");
    }

    @Override
    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.encodingQualityChanged]", (Object)"NullTransferJob");
    }

    @Override
    public boolean isWaiting() {
        return false;
    }
}

