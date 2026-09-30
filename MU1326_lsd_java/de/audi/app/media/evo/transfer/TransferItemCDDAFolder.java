/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.source.ISourceSlot;

public class TransferItemCDDAFolder
implements ITransferItem {
    private final ISourceSlot sourceSlot;

    public TransferItemCDDAFolder(ISourceSlot iSourceSlot) {
        this.sourceSlot = iSourceSlot;
    }

    public boolean isFolder() {
        return true;
    }

    public long getEntryId() {
        return -1L;
    }

    public int getContentType() {
        return 7;
    }

    public boolean isContentTypeCDDA() {
        return true;
    }

    public MediaListEntry[] getTransferFolder() {
        return IBrowseListContext.EMPTY_BROWSE_FOLDER;
    }

    public boolean isPhysicalFolder() {
        return true;
    }

    public boolean isDeletionSource() {
        return false;
    }

    public boolean isDynamicTransferFolder() {
        return false;
    }

    public ISourceSlot getTransferSourceSlot() {
        return this.sourceSlot;
    }

    public String toString() {
        return "TransferItemCDDAFolder";
    }
}

