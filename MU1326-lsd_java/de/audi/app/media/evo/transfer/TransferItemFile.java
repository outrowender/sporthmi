/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;

public class TransferItemFile
implements ITransferItem {
    private final long entryId;
    private final int contentType;
    private final MediaListEntry[] transferFolder;
    private final boolean physicalFolder;
    private final ISourceSlot sourceSlot;

    public TransferItemFile(MediaListEntry[] mediaListEntryArray, boolean bl, long l, int n, ISourceSlot iSourceSlot) {
        this.transferFolder = mediaListEntryArray;
        this.entryId = l;
        this.contentType = n;
        this.physicalFolder = bl;
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
        return this.contentType;
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
        return null == this.transferFolder;
    }

    @Override
    public ISourceSlot getTransferSourceSlot() {
        return this.sourceSlot;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TransferItemFile '");
        buffer.append(this.entryId);
        buffer.append(", ");
        buffer.append(this.contentType);
        buffer.append(", ");
        buffer.append(this.transferFolder);
        buffer.append(", ");
        buffer.append(this.physicalFolder);
        buffer.append("'");
        return buffer.toString();
    }
}

