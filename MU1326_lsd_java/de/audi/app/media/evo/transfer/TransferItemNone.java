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
    public boolean isFolder() {
        return false;
    }

    public long getEntryId() {
        return -1L;
    }

    public int getContentType() {
        return -1;
    }

    public boolean isContentTypeCDDA() {
        return false;
    }

    public MediaListEntry[] getTransferFolder() {
        return IBrowseListContext.EMPTY_BROWSE_FOLDER;
    }

    public boolean isPhysicalFolder() {
        return false;
    }

    public boolean isDeletionSource() {
        return false;
    }

    public boolean isDynamicTransferFolder() {
        return false;
    }

    public ISourceSlot getTransferSourceSlot() {
        return null;
    }

    public String toString() {
        return "TransferItemNone";
    }
}

