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
    private static final String LOGCLASS = "TransferJobSourceActivationWithBrowser";

    public TransferJobSourceActivationWithBrowser(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, ITransferItem iTransferItem, EvoTransferState evoTransferState) {
        super(logChannel, iTransferController, evoTransferController, iTransferItem, evoTransferState);
    }

    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.browseModeChanged]", (Object)LOGCLASS);
        if (1 != n || bl) {
            this.getExecutionContext().jobFinished();
        }
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.browseFolderChanged]", (Object)LOGCLASS);
        if (bl) {
            this.getExecutionContext().jobFinished();
            return;
        }
        this.evoTransferController.setRootFolder(mediaListEntryArray);
        this.evoTransferController.getBrowserListContext().requestListByIndex(0, n, this.evoTransferController.getClientId());
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.responseList]", (Object)LOGCLASS);
        if (bl) {
            this.getExecutionContext().jobFinished();
            return;
        }
        this.evoTransferController.setBrowserEntries(mediaListEntryArray);
        this.getExecutionContext().jobFinished();
    }
}

