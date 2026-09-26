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

    @Override
    public boolean isFolder() {
        return true;
    }

    @Override
    public long getEntryId() {
        return -1L;
    }

    @Override
    public int getContentType() {
        return 7;
    }

    @Override
    public boolean isContentTypeCDDA() {
        return true;
    }

    @Override
    public MediaListEntry[] getTransferFolder() {
        return IBrowseListContext.EMPTY_BROWSE_FOLDER;
    }

    @Override
    public boolean isPhysicalFolder() {
        return true;
    }

    @Override
    public boolean isDeletionSource() {
        return false;
    }

    @Override
    public boolean isDynamicTransferFolder() {
        return false;
    }

    @Override
    public ISourceSlot getTransferSourceSlot() {
        return this.sourceSlot;
    }

    public String toString() {
        return "TransferItemCDDAFolder";
    }
}

