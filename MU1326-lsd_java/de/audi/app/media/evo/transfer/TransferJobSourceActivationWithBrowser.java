/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.EvoTransferController;
import de.audi.app.media.evo.transfer.EvoTransferState;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.evo.transfer.TransferJobSourceActivation;
import de.audi.app.media.transfer.ITransferController;
import de.audi.atip.log.LogChannel;

public class TransferJobSourceActivationWithBrowser
extends TransferJobSourceActivation {
    private static final String LOGCLASS;

    public TransferJobSourceActivationWithBrowser(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, ITransferItem iTransferItem, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, iTransferItem, evoTransferState);
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.browseModeChanged]", (Object)"TransferJobSourceActivationWithBrowser");
        if (1 != n || bl) {
            this.getExecutionContext().jobFinished();
        }
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.browseFolderChanged]", (Object)"TransferJobSourceActivationWithBrowser");
        if (bl) {
            this.getExecutionContext().jobFinished();
            return;
        }
        this.evoTransferController.setRootFolder(mediaListEntryArray);
        this.evoTransferController.getBrowserListContext().requestListByIndex(0, n, this.evoTransferController.getClientId());
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.responseList]", (Object)"TransferJobSourceActivationWithBrowser");
        if (bl) {
            this.getExecutionContext().jobFinished();
            return;
        }
        this.evoTransferController.setBrowserEntries(mediaListEntryArray);
        this.getExecutionContext().jobFinished();
    }
}

