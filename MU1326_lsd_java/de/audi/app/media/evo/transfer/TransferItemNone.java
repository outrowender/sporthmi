/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.source.ISourceSlot;

public class TransferItemNone
implements ITransferItem {
    @Override
    public boolean isFolder() {
        return false;
    }

    @Override
    public long getEntryId() {
        return -1L;
    }

    @Override
    public int getContentType() {
        return -1;
    }

    @Override
    public boolean isContentTypeCDDA() {
        return false;
    }

    @Override
    public MediaListEntry[] getTransferFolder() {
        return IBrowseListContext.EMPTY_BROWSE_FOLDER;
    }

    @Override
    public boolean isPhysicalFolder() {
        return false;
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
        return null;
    }

    public String toString() {
        return "TransferItemNone";
    }
}

