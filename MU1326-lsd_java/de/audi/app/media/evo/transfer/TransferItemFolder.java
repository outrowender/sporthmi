/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;

public class TransferItemFolder
implements ITransferItem {
    private final MediaListEntry[] transferFolder;
    private final boolean physicalFolder;
    private final ISourceSlot sourceSlot;

    public TransferItemFolder(MediaListEntry[] mediaListEntryArray, boolean bl, ISourceSlot iSourceSlot) {
        this.transferFolder = mediaListEntryArray;
        this.physicalFolder = bl;
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
        return -1;
    }

    @Override
    public boolean isContentTypeCDDA() {
        return false;
    }

    @Override
    public MediaListEntry[] getTransferFolder() {
        return this.transferFolder;
    }

    @Override
    public boolean isPhysicalFolder() {
        return this.physicalFolder;
    }

    @Override
    public boolean isDeletionSource() {
        return this.sourceSlot.getSource().getType() == 6;
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
        buffer.append("TransferItemFolder '");
        buffer.append(this.transferFolder);
        buffer.append(", ");
        buffer.append(this.physicalFolder);
        buffer.append("'");
        return buffer.toString();
    }
}

