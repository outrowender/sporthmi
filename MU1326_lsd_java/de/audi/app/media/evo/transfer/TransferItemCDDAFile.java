/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;

public class TransferItemCDDAFile
implements ITransferItem {
    private final long entryId;
    private final ISourceSlot sourceSlot;

    public TransferItemCDDAFile(long l, ISourceSlot iSourceSlot) {
        this.entryId = l;
        this.sourceSlot = iSourceSlot;
    }

    public boolean isFolder() {
        return false;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public int getContentType() {
        return 1;
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
        Buffer buffer = new Buffer();
        buffer.append("TransferItemCDDAItem '");
        buffer.append(this.entryId);
        buffer.append("'");
        return buffer.toString();
    }
}

