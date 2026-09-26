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

    @Override
    public boolean isFolder() {
        return false;
    }

    @Override
    public long getEntryId() {
        return this.entryId;
    }

    @Override
    public int getContentType() {
        return 1;
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
        Buffer buffer = new Buffer();
        buffer.append("TransferItemCDDAItem '");
        buffer.append(this.entryId);
        buffer.append("'");
        return buffer.toString();
    }
}

